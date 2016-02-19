package katest.dipenpradhan.com.katest_dipen.database;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteTransactionListener;
import android.net.Uri;
import android.provider.BaseColumns;
import android.support.annotation.Nullable;

/**
 * Created by dipenpradhan on 9/26/15.
 */
public class DBProvider extends ContentProvider {

    DBManager dbManager;

    private SQLiteOpenHelper sqLiteOpenHelper;
    private SQLiteDatabase sqLiteDatabase;


    private static final UriMatcher uriMatcher = new UriMatcher(0);

    public enum DB_URIs {
        BADGE(DBConstants.TABLE_BADGE),
        CATEGORY(DBConstants.TABLE_CATEGORY);

        private String mPath;

        DB_URIs(String path) {
            this.mPath = path;
        }

        public String getPath() {
            return mPath;
        }
    }


    static {
        uriMatcher.addURI(DBConstants.AUTHORITY, DB_URIs.BADGE.getPath(), DB_URIs.BADGE.ordinal());
        uriMatcher.addURI(DBConstants.AUTHORITY, DB_URIs.CATEGORY.getPath(), DB_URIs.CATEGORY.ordinal());
    }

    @Override
    public boolean onCreate() {
        sqLiteOpenHelper = new DBManager(getContext()).getSqLiteOpenHelper();
        sqLiteDatabase = sqLiteOpenHelper.getWritableDatabase();
        return false;
    }

    @Nullable
    @Override
    public Cursor query(Uri uri,
                        String[] projection,
                        String selection,
                        String[] selectionArgs,
                        String sortOrder) {
        DB_URIs dbUri = identifyUri(uri);
        if (dbUri != null) {
            switch (dbUri) {
                default:
                    Cursor cursor = sqLiteDatabase.query(dbUri.getPath(), projection, selection, selectionArgs, null, null, sortOrder);
                    cursor.setNotificationUri(getContext().getContentResolver(), uri);
                    return cursor;
            }

        }
        return null;
    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        return "vnd.android.cursor.dir/vnd." + DBConstants.AUTHORITY + uri.getPath();
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues contentValues) {

        try {
            DB_URIs dbUri = identifyUri(uri);
            if (dbUri != null) {
                int updatedRows = sqLiteDatabase.updateWithOnConflict(dbUri.getPath(), contentValues, BaseColumns._ID + " = ?", new String[]{contentValues.getAsString(BaseColumns._ID)}, SQLiteDatabase.CONFLICT_REPLACE);
                if (updatedRows == 0) {
                    long insertedRows = sqLiteDatabase.insertWithOnConflict(dbUri.getPath(), null, contentValues, SQLiteDatabase.CONFLICT_REPLACE);
                    if (insertedRows > 0) {
                        return uri;
                    }
                } else {
                    return uri;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public int bulkInsert(Uri uri, ContentValues[] values) {

        int totalAffectedRows = 0;

        sqLiteDatabase.beginTransactionWithListener(new SQLiteTransactionListener() {
            @Override
            public void onBegin() {
//                log.debug("Bulk insert transaction begin " + uri.toString());
            }

            @Override
            public void onCommit() {
//                log.debug("Bulk insert transaction successful commit " + uri.toString());
            }

            @Override
            public void onRollback() {
//                log.debug("Bulk insert transaction error - rolling back changes " + uri.toString());
            }
        });
        try {
            DB_URIs dbUri = identifyUri(uri);
            if (dbUri != null) {
                sqLiteDatabase.delete(dbUri.getPath(), null, null);
                boolean failed = false;
                for (ContentValues contentValues : values) {

                    int updatedRows = sqLiteDatabase.updateWithOnConflict(dbUri.getPath(), contentValues, BaseColumns._ID + " = ?", new String[]{contentValues.getAsString(BaseColumns._ID)}, SQLiteDatabase.CONFLICT_REPLACE);
                    long insertedRows = 0;

                    if (updatedRows == 0) {
                        insertedRows = sqLiteDatabase.insertWithOnConflict(dbUri.getPath(), null, contentValues, SQLiteDatabase.CONFLICT_REPLACE);
                        if (insertedRows > 0) {
                            totalAffectedRows++;
                        }
                    } else {
                        totalAffectedRows++;
                    }
                    if (updatedRows == 0 && insertedRows == 0) {
                        failed = true;
                        break;
                    }
                }
                if (!failed) {
                    sqLiteDatabase.setTransactionSuccessful();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqLiteDatabase.endTransaction();
        }
        getContext().getContentResolver().notifyChange(uri, null);
        return totalAffectedRows;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        try {
            DB_URIs dbUri = identifyUri(uri);
            if (dbUri != null) {

                return sqLiteDatabase.delete(dbUri.getPath(), selection, selectionArgs);
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        getContext().getContentResolver().notifyChange(uri, null);

        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues contentValues, String whereClause, String[]
            whereArgs) {
        try {
            DB_URIs dbUri = identifyUri(uri);
            if (dbUri != null) {
                return sqLiteDatabase.update(dbUri.getPath(), contentValues, whereClause, whereArgs);
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        getContext().getContentResolver().notifyChange(uri, null);

        return 0;
    }

    private DB_URIs identifyUri(Uri uri) {
        int index = uriMatcher.match(uri);

        if (DB_URIs.values().length > index && index >= 0) {
            return DB_URIs.values()[index];
        } else {
            return null;
        }
    }

}
