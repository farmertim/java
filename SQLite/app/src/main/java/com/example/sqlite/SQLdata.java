package com.example.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SQLdata extends SQLiteOpenHelper {
    private final static String DB="DBFirst";//資料庫
    private final static String TB="TB2020";//資料表
    private final static int VS=2;//版本
    public SQLdata(Context context) {
        super(context, DB, null, VS);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL="CREATE TABLE IF NOT EXISTS "+TB+"(ID INTEGER PRIMARY KEY AUTOINCREMENT" +
                ",TITLE VARCHAR(50))";
        db.execSQL(SQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String SQL="DROP TABLE "+TB;
        db.execSQL(SQL);
    }
}
