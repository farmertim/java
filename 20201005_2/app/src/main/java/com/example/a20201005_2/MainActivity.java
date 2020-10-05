package com.example.a20201005_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=(Button)findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show();
            }
        });
    }
    public void show(){
        TextView textView=(TextView)findViewById(R.id.textView3);
        CheckBox checkBox;
        int[] id=new int[]{R.id.checkBox,R.id.checkBox2};
        String s="";
        for(int i:id){
            checkBox=(CheckBox)findViewById(i);
            if(checkBox.isChecked()){
                s+=checkBox.getText().toString()+"  ";
            }

        }
        textView.setText(s);
    }
}