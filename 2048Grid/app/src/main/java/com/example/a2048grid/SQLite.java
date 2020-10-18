package com.example.a2048grid;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.ContactsContract;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SQLite extends SQLiteOpenHelper{
    logic logic;
    AppCompatActivity mainClass;
    private int Grade;
    private int AGrade;
    private  String[] DataTable=new String[2];
    private  String[] ID=new String[2];
    private  String Over="Over";
    private  String ActiveGrade="ActiveGrade",ActiveLocal="ActiveLocal";
    private  String Name="Name",HeightGrade="HeightGrade";
    private String[] NowLocal;

    public void newObject(){
        NowLocal=new String[16];
        for(int i=0;i<16;i++){
                NowLocal[i]=new String();

        }
        for(int i=0;i<DataTable.length;i++){
            DataTable[i]=new String();
            ID[i]=new String();
        }
        DataTable[0]="Active";
        DataTable[1]="Score";
        ID[0]="ActiveId";
        ID[1]="ScoreId";
    }
    public SQLite(@Nullable Context context,logic logic,AppCompatActivity mainClass) {
        super(context,"game.db", null, 1);
        this.logic=logic;
        this.mainClass=mainClass;
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
        query="INSERT INTO "+DataTable[0]+" ("+Over+","+ActiveGrade+","+ActiveLocal+")VALUES (0,0,'2')";
        db.execSQL(query);
        query="INSERT INTO "+DataTable[1]+" ("+HeightGrade+","+Name+")VALUES (0,'hu')";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public int getActiveLocal(int id){
        int convert[] = new int[16];
        for(int i=0;i<16;i++){
            convert[i]=Integer.parseInt(NowLocal[i]);
        }
        return convert[id];
    }
    public int getAGrade(){
        return AGrade;
    }
    public int selectActiveLocal(){
        String s="";
        int number=0;
        SQLiteDatabase db=this.getReadableDatabase();
        String query="SELECT * from "+DataTable[0];
        Cursor cursor=db.rawQuery(query,null);
        while (cursor.moveToNext()){
            number=cursor.getInt(1);
            s=cursor.getString(3);
            AGrade=cursor.getInt(2);
        }
        s=s.trim();
        NowLocal=s.split(String.valueOf(' '));
        cursor.close();
        db.close();
        return number;
    }
    public int selectHeightScore(int id){

        SQLiteDatabase db=this.getReadableDatabase();
        String query="SELECT * from "+DataTable[1];
        Cursor cursor=db.rawQuery(query,null);
        while (cursor.moveToNext()){
            Grade=cursor.getInt(1);
        }

        cursor.close();
        db.close();
        //Toast.makeText(mainClass,String.valueOf(Grade), Toast.LENGTH_SHORT).show();
        return Grade;
    }
    public int updateHeightScore(int id){
        int a=selectHeightScore(1);
        if(logic.grade>a){
            SQLiteDatabase db=this.getWritableDatabase();
            ContentValues cv=new ContentValues();
            cv.put(this.HeightGrade,logic.grade);
            db.update(DataTable[1],cv,ID[1]+"="+id,null);
            return selectHeightScore(1);
        }else
            return a;

    }
    public void updateActive(int Over,int ActiveGrade,String ActiveLocal,int id){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(this.Over,Over);
        cv.put(this.ActiveGrade,ActiveGrade);
        cv.put(this.ActiveLocal,ActiveLocal);
        db.update(DataTable[0],cv,ID[0]+"="+id,null);

    }/*
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
    }*/

}
