package com.example.a20201012;

import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ButtonOclick implements View.OnClickListener {
    double[] energy={3.1,4.4,13.2,9.7,5.1,3.7};
    AppCompatActivity mainClass;
    TextView textView,answer;
    EditText weight,time;
    public ButtonOclick(AppCompatActivity mainClass){
       this.mainClass=mainClass;

    }
    @Override
    public void onClick(View v) {
        String[] exercise=mainClass.getResources().getStringArray(R.array.exercise);
        Spinner spinner=mainClass.findViewById(R.id.spinner);
        weight=mainClass.findViewById(R.id.weight);
        time=mainClass.findViewById(R.id.time);
        int id=spinner.getSelectedItemPosition();
        double a=Double.parseDouble(weight.getText().toString())*Double.parseDouble(time.getText().toString())*Double.parseDouble(String.valueOf(energy[id]));
        answer=mainClass.findViewById(R.id.answer);
        answer.setText(String.valueOf(a));
    }
}
