package com.mirea.kt.datastorageapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyAppSQLiteHelper extends SQLiteOpenHelper {
    public MyAppSQLiteHelper(Context c, String name, SQLiteDatabase.CursorFactory f, int version) {
        super(c, name, f, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table" +" TABLE_PLANTS" + "("
                + "_id integer primary key autoincrement,"
                + "name text,"
                + "variety text,"
                + "type boolean" + ");");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }

}
