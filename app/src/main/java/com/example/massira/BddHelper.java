package com.example.massira;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import java.util.ArrayList;
import java.util.Date;

public class BddHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "ManifDB.sqlite";
    String tableManif = "MANIF";

    String sqlCreateQuery = "CREATE TABLE IF NOT EXISTS "+tableManif +
            "(Uid INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, " +
            "description TEXT,created_at TEXT ,updated_at TEXT,gps TEXT,UserID INTEGER)";


    public BddHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void queryData(String sql) {
        SQLiteDatabase database = getWritableDatabase();
        database.execSQL(sql);
    }
    public void addItenerary(String name ,String description ,String created_at,String updated_at,String gps ,int Userid) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
         //
        values.put("name", name); //
        values.put("description", description); //
        values.put("created_at", created_at); //
        values.put("updated_at",updated_at);
        values.put("gps",gps);//
        values.put("UserID", Userid); //
        // Inserting Row
        db.insert(tableManif, null, values);
        db.close(); // Closing database connection
    }





    public Cursor getData(String sql) {
        SQLiteDatabase database = getReadableDatabase();
        return database.rawQuery(sql, null);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        // create data table
        sqLiteDatabase.execSQL(sqlCreateQuery);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("Drop table if EXISTS MANIF");

        onCreate(sqLiteDatabase);
    }


}
