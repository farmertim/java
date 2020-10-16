package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SimpleTimeZone;

public class MainActivity extends AppCompatActivity {
    SQLdata DH=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DH=new SQLdata(this);
        add("boy");//加入資料
    }
    public void add(String s){
        SQLiteDatabase db=DH.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("TITLE",s.toString());//載入資料boy
        db.insert("RB2020",null,values);//寫入資料boy
        ListView LV=(ListView)findViewById(R.id.LV);//讀取元件

        //查詢資料庫並載入
        Cursor cursor=db.query("TB2020",new String[]{"ID,TITLE"},null,null,null,null,null);
        List<Map<String,Object>> items=new ArrayList<Map<String,Object>>();
        cursor.moveToFirst();

        //呼叫資料庫的資料
        for(int i=0;i<cursor.getCount();i++){
            Map<String,Object> item=new HashMap<String,Object>();
            item.put("ID",getString(0));
            item.put("TITLE",getString(0));
            items.add(item);
            cursor.moveToNext();

        }
        SimpleAdapter SA=new SimpleAdapter(this,items,android.R.layout.simple_expandable_list_item_2,new String[]{"ID","TITLE"},new int[]{android.R.id.text1,android.R.id.text2});
        LV.setAdapter(SA);

    }
}