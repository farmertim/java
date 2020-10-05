package com.example.a20201005;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener, TextWatcher {
    EditText editText;
    RadioGroup radioGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        radioGroup=(RadioGroup)findViewById(R.id.rrr);
        radioGroup.setOnCheckedChangeListener(this);
        editText=(EditText)findViewById(R.id.textView5);
        editText.addTextChangedListener(this);
    }



    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        calculate();
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        calculate();
    }
    public void calculate(){

        Double answer=0.0;
        TextView change1=(TextView)findViewById(R.id.textView2);
        TextView change2=(TextView)findViewById(R.id.textView3);
        RadioGroup r=(RadioGroup)findViewById(R.id.rrr);
        if(r.getCheckedRadioButtonId()==R.id.radioButton3){
            answer=Double.parseDouble(editText.getText().toString());
            answer=answer*(9/5)+32;
            change1.setText(editText.getText()+getString(R.string.degC));
            change2.setText(answer.toString()+getString(R.string.degF));
        }
    }
}