package com.example.myapplication;

import android.app.Application;
import android.view.View;

public class ButtonLister implements View.OnClickListener{
    MainActivity application;
    public ButtonLister(MainActivity mainActivity){
        this.application=mainActivity;
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:
                application.textView.setText("huWeiRen");
                break;
            case R.id.button2:
                application.textView.setText("fat");

        }

    }
}
