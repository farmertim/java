package com.example.a20201012;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Spinner spinner;
    Button button;
    TextView textView;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = (Spinner) findViewById(R.id.spinner);
        ButtonOclick buttonOclick = new ButtonOclick(this);
        OnItemSelect cOnItemSelect = new OnItemSelect(this);
        button = (Button) findViewById(R.id.button);
        textView = (TextView) findViewById(R.id.textView);
        button.setOnClickListener(buttonOclick);
        ListViewListner listViewListner=new ListViewListner(this);
        listView=(ListView)findViewById(R.id.list);
        listView.setOnItemClickListener(listViewListner);
    }
}