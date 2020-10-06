package com.example.radiobuttonpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener, TextWatcher {
    TextView textView;
    RadioGroup radioGroup;//=(RadioGroup)findViewById(R.id.check);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        radioGroup=(RadioGroup) findViewById(R.id.check);

        radioGroup.setOnCheckedChangeListener(this);
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {

    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

        appear();
    }
    public void appear(){
        textView=(TextView)findViewById(R.id.textView);
        if(radioGroup.getCheckedRadioButtonId()==R.id.radioButton5){
            textView.setText(getString(R.string.boy));
        }else{
            textView.setText(getString(R.string.girl));

        }

    }
}