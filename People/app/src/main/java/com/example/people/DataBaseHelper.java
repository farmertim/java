package com.example.people;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DataBaseHelper extends SQLiteOpenHelper {

    public static final String CUSTOMER_TABLE="CUSTOMER_TABLE";
    private static final String CUSTOMER_ID="CUSTOMER_ID";
    private static final String CUSTOMER_NAME ="CUSTOMER_NAME" ;
    private static final String CUSTOMER_AGE="CUSTOMER_AGE";
    private static final String CUSTOMER_ACTIVE="CUSTOMER_ACTIVE";
    public DataBaseHelper(@Nullable Context context) {
        super(context, "customer.db", null, 1);
    }


    //this is called the first time a databases is accessed. There should be code in here to create a new databases
    @Override
    public void onCreate(SQLiteDatabase db) {
        String s="CREATE TABLE "+CUSTOMER_TABLE+" ("+CUSTOMER_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+CUSTOMER_NAME+" TEXT,"+CUSTOMER_AGE +" INT,"+CUSTOMER_ACTIVE+" BOOL)";
        db.execSQL(s);
    }


    //this is called if the database version number changes it prevents prevents users apps from breaking when you change the databases design.
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public boolean addOne(CustomerModel customerModel){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(CUSTOMER_NAME,customerModel.getName());
        cv.put(CUSTOMER_AGE,customerModel.getAge());
        cv.put(CUSTOMER_ACTIVE,customerModel.isActive());
        long insert= db.insert(CUSTOMER_TABLE,null,cv);
        if(insert==-1){
            return  false;
        }
        else{
            return true;
        }
    }
    public boolean deleteOne(CustomerModel customerModel){
        SQLiteDatabase db=this.getWritableDatabase();
        String query="DELETE FROM "+CUSTOMER_TABLE+" WHERE "+CUSTOMER_ID +" = "+customerModel.getId();
        Cursor cursor = db.rawQuery(query, null);
        if(cursor.moveToFirst()){
            return true;
        }else{
            return false;
        }

    }
    public List<CustomerModel> showEvery(){
        List<CustomerModel> returnList=new ArrayList<>();
        String query="SELECT * FROM "+CUSTOMER_TABLE;
        SQLiteDatabase sqLiteDatabase=this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(query,null);
        if(cursor.moveToFirst()){
            do{
                int customerID=cursor.getInt(0);
                String customerName=cursor.getString(1);
                int customerAge=cursor.getInt(2);
                boolean customerActive=cursor.getInt(3)==1 ? true :false;
                CustomerModel customerModel=new CustomerModel(customerID,customerName,customerAge,customerActive);
                returnList.add(customerModel);
            }while (cursor.moveToNext());
        }
        else{

        }
        cursor.close();
        sqLiteDatabase.close();
        return returnList;
    }
}
