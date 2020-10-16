package com.example.a20201012;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ListViewListner implements AdapterView.OnItemClickListener {
    AppCompatActivity mainClass;
    TextView t;
    ArrayList<String> select=new ArrayList<String>();
    public ListViewListner(AppCompatActivity mainClass){
        this.mainClass=mainClass;
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        TextView textView=(TextView)view;
        String s="";
        String item=textView.getText().toString();
        if(select.contains(item)){
            select.remove(item);
        }else{
            select.add(item);
        }
        if(select.size()>0){
            s+="您點了";
            for(String str:select){
                s+=" "+str;
            }
        }
        t=mainClass.findViewById(R.id.watchlist);
        t.setText(s);
    }
}
