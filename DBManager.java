package com.mirea.kt.datastorageapplication;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class DBManager {

    private SQLiteOpenHelper sqLiteHelper;

    public DBManager(SQLiteOpenHelper sqLiteHelper) {
        this.sqLiteHelper = sqLiteHelper;
    }

    public boolean savePlantsToDatabase(Plants plant) {
        SQLiteDatabase db = this.sqLiteHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("name", plant.getName());
        cv.put("variety", plant.getVariety());
        cv.put("type", plant.getType());
        long rowId = db.insert("TABLE_PLANTS", null, cv);
        cv.clear();
        db.close();
        return rowId != -1;
    }

    public ArrayList<Plants> loadAllPlantsFromDatabase() {
        ArrayList<Plants> plants = new ArrayList<>();
        SQLiteDatabase db = this.sqLiteHelper.getWritableDatabase();
        Cursor dbCursor = db.query("TABLE_PLANTS",
                null, null, null,
                null, null, null);
        if (dbCursor.moveToFirst()){
            do {
                String name = dbCursor.getString(dbCursor.getColumnIndexOrThrow("name"));
                String variety = dbCursor.getString(dbCursor.getColumnIndexOrThrow("variety"));
                Boolean type = dbCursor.getExtras().getBoolean(String.valueOf(dbCursor.getColumnIndexOrThrow("type")));
                plants.add(new Plants(name, variety, type));
            } while (dbCursor.moveToNext());
        }
        dbCursor.close();
        db.close();
        return plants;
    }
}
