package katest.dipenpradhan.com.katest_dipen.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteTransactionListener;
import android.support.annotation.NonNull;

import java.util.concurrent.Callable;

/**
 * Created by dipenpradhan on 9/26/15.
 */
public class DBManager {

    private static SQLiteOpenHelper mSqLiteOpenHelper;
    private static String DELETE_FROM = "DELETE FROM ";
    private static SQLiteDatabase mSqLiteDatabase;

    public DBManager(Context context) {
        mSqLiteOpenHelper = new DBSQLiteOpenHelper(context);
        mSqLiteDatabase = mSqLiteOpenHelper.getWritableDatabase();
    }

    public SQLiteOpenHelper getSqLiteOpenHelper() {
        return mSqLiteOpenHelper;
    }

    public void runInTransaction(@NonNull Callable<Void> callable, @NonNull SQLiteTransactionListener listener) {

        if(callable==null || listener == null)return;

        try {
            mSqLiteDatabase.beginTransactionWithListener(listener);
            callable.call();
            mSqLiteDatabase.endTransaction();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void clearTable(@NonNull Class<?> clazz) {
        if(clazz==null)return;

        mSqLiteDatabase.execSQL(DELETE_FROM + clazz.getSimpleName());
    }
}
