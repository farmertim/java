package com.example.a2048grid;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.ContactsContract;

import androidx.annotation.Nullable;

public class SQLite extends SQLiteOpenHelper{
    private  String[] DataTable=new String[2];
    private  String[] ID=new String[2];
    private  String Over="Over";
    private  String ActiveGrade="ActiveGrade",ActiveLocal="ActiveLocal";
    private  String Name="Name",HeightGrade="HeightGrade";
    public void newObject(){
        for(int i=0;i<DataTable.length;i++){
            DataTable[i]=new String();
            ID[i]=new String();
        }
        DataTable[0]="Active";
        DataTable[1]="Score";
        ID[0]="ActiveId";
        ID[1]="ScoreId";
    }
    public SQLite(@Nullable Context context) {
        super(context,"game.db", null, 1);
        newObject();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String query="CREATE TABLE "+DataTable[0]+"("+ID[0]+" INTEGER PRIMARY KEY AUTOINCREMENT ,"+
                Over+" INTEGER NOT NULL,"+ActiveGrade+" INTEGER NOT NULL,"+ ActiveLocal+" TEXT NOT NULL )";
        db.execSQL(query);
        query="CREATE TABLE "+DataTable[1]+"("+ID[1]+" INTEGER PRIMARY KEY AUTOINCREMENT ,"+HeightGrade+
               " INTEGER NOT NULL ,"+Name+" TEXT NOT NULL )";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void updateActive(int Over,int ActiveGrade,String ActiveLocal,int id){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(this.Over,Over);
        cv.put(this.ActiveGrade,ActiveGrade);
        cv.put(this.ActiveLocal,ActiveLocal);
        db.update(DataTable[0],cv,ID[0]+"="+id,null);

    }
    public boolean addActiveOne(){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(Over,1);
        cv.put(ActiveGrade,100);
        cv.put(ActiveLocal,"2,2");
        long insert= db.insert(DataTable[0],null,cv);
        if(insert==-1){
            return  false;
        }
        else{
            return true;
        }
    }
    public boolean addScoreOne(){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(HeightGrade,100);
        cv.put(Name,"ppp");
        long insert= db.insert(DataTable[1],null,cv);
        if(insert==-1){
            return  false;
        }
        else{
            return true;
        }
    }
}
