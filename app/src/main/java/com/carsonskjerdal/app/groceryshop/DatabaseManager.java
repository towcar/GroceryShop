package com.carsonskjerdal.app.groceryshop;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Carson on 2017-12-13.
 * <p>
 * Feel free to use code just give credit please :)
 *
 * Singleton that controls access to the SQLiteDatabase instance
 * for this application.
 */

public class DatabaseManager {
    private Integer mOpenCounter = 0;

    private static DatabaseManager sInstance;
    private DatabaseHelper myDbHelper;
    private SQLiteDatabase mDatabase;

    public DatabaseManager(Context context) {
        myDbHelper = new DatabaseHelper(context);
    }

    public static synchronized DatabaseManager getInstance(Context context) {
        // Use the application context, which will ensure that you
        // don't accidentally leak an Activity's context.
        // See this article for more information: http://bit.ly/6LRzfx
        if (sInstance == null) {
            sInstance = new DatabaseManager(context.getApplicationContext());
        }
        return sInstance;
    }

    public synchronized SQLiteDatabase openDatabase() {
        mOpenCounter+=1;
        if(mOpenCounter == 1) {
            // Opening new database
            mDatabase = myDbHelper.getWritableDatabase();
        }
        return mDatabase;
    }

    public synchronized void closeDatabase() {
        mOpenCounter-=1;
        if(mOpenCounter == 0) {
            // Closing database
            mDatabase.close();

        }
    }

    public Cursor queryAllItems(String table) {
        //Implements the query
        SQLiteDatabase db = myDbHelper.getReadableDatabase();
        return db.rawQuery("select * from " + table, null);
    }

}
