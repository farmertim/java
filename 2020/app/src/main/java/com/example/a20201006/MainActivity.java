package com.example.a20201006;

import androidx.appcompat.app.AppCompatActivity;

import android.opengl.Visibility;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {
    ArrayList<CompoundButton> arrayList=new ArrayList<CompoundButton>();
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int[] arr=new int[]{R.id.checkBox,R.id.checkBox2,R.id.checkBox3,R.id.checkBox4};
        for(int i:arr){
            CheckBox checkBox=(CheckBox)findViewById(i);
            checkBox.setOnCheckedChangeListener(this);
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        int item;
        if(isChecked==true){
            arrayList.add(buttonView);
            item= View.VISIBLE;
        }
        else{
            arrayList.remove(buttonView);
            item=View.GONE;
        }
        switch (buttonView.getId()){
            case R.id.checkBox:
                findViewById(R.id.h).setVisibility(item);
                break;
            case R.id.checkBox2:
                findViewById(R.id.t).setVisibility(item);
                break;
            case R.id.checkBox3:
                findViewById(R.id.coco).setVisibility(item);
                break;
            case R.id.checkBox4:
                findViewById(R.id.soup).setVisibility(item);
                break;
        }
    }
}