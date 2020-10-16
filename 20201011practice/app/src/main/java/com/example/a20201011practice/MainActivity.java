package com.example.a20201011practice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button button;
    ListView listView;
    ArrayAdapter arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText=(EditText)findViewById(R.id.editText);
        button=(Button)findViewById(R.id.button);
        listView=(ListView)findViewById(R.id.listview);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    People people = new People(-1, editText.getText().toString());
                    DataBasesHelper dataBasesHelper = new DataBasesHelper(MainActivity.this);
                    boolean a = dataBasesHelper.addName(people);
                    List<People> show=dataBasesHelper.showName();
                    arrayAdapter=new ArrayAdapter<People>(MainActivity.this,android.R.layout.simple_list_item_1,show);
                    listView.setAdapter(arrayAdapter);

                    Toast.makeText(MainActivity.this, String.valueOf(a), Toast.LENGTH_SHORT).show();
                }catch (Exception e){
                    Toast.makeText(MainActivity.this,e.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}