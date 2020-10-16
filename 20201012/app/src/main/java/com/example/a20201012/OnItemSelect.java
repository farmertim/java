package com.example.a20201012;

import android.view.View;
import android.widget.AdapterView;

import androidx.appcompat.app.AppCompatActivity;

public class OnItemSelect implements AdapterView.OnItemSelectedListener {
    AppCompatActivity mainClass;
    public OnItemSelect(AppCompatActivity mainClass){
        this.mainClass=mainClass;
    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
