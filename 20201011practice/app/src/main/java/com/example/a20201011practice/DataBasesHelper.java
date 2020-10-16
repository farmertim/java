package com.example.a20201011practice;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DataBasesHelper extends SQLiteOpenHelper {

    private final static String PracticeDataTable="PracticeDataTable";
    private final static String PracticeId="PracticeId";
    private final static String PracticeName="PracticeName";

    public DataBasesHelper(Context context) {
        super(context, "practice.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String s="CREATE Table "+PracticeDataTable+" ("+PracticeId+" INTEGER PRIMARY KEY AUTOINCREMENT,"+PracticeName+" TEXT )";
        db.execSQL(s);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public boolean addName(People people){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(PracticeName,people.getName());
        long insert=db.insert(PracticeDataTable,null,cv);
        if(insert==-1) {
            return false;
        }else {
            return true;
        }
    }
    public List<People> showName(){
        List<People> returnShowName=new ArrayList<>();
        String query="SELECT * FROM "+PracticeDataTable;
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery(query,null);
        if(cursor.moveToFirst()){
            do{
                int id=cursor.getInt(0);
                String name=cursor.getString(1);
                People people=new People(id,name);
                returnShowName.add(people);
            }while (cursor.moveToNext());
        }
        else{

        }
        cursor.close();
        db.close();

        return returnShowName;
    }
}
