package katest.dipenpradhan.com.katest_dipen.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static katest.dipenpradhan.com.katest_dipen.database.DBConstants.TABLE_BADGE;
import static katest.dipenpradhan.com.katest_dipen.database.DBConstants.TABLE_CATEGORY;

/**
 * Created by dipenpradhan on 9/27/15.
 */
public class DBSQLiteOpenHelper extends SQLiteOpenHelper{

    private static String DROP_TABLE = "DROP TABLE IF EXISTS ";
    private static String DROP_VIEW = "DROP VIEW IF EXISTS ";

    public DBSQLiteOpenHelper(Context context) {
        super(context, DBConstants.DATABASE_NAME, null, DBConstants.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DBCreateTableQueries.CREATE_TABLE_BADGES);
        db.execSQL(DBCreateTableQueries.CREATE_TABLE_CATEGORY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_TABLE + TABLE_BADGE);
        db.execSQL(DROP_TABLE + TABLE_CATEGORY);
        onCreate(db);
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
    }


}
