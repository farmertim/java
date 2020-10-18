package com.example.a2048grid;

import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ButtonLister implements View.OnClickListener {
    AppCompatActivity mainClass;
    Local[][] local;
    SQLite sqLite;
    TouchLister touchLister;
    logic logic=new logic();
    public ButtonLister(AppCompatActivity mainClass,TouchLister touchLister,Local[][] local,SQLite sqLite){
        this.mainClass=mainClass;
        this.touchLister=touchLister;
        this.local=local;
        this.sqLite=sqLite;
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.review:
                logic.grade=0;
                touchLister.RemoveView();
                int count=0;
                for(int i=0;i<4;i++){
                    for(int j=0;j<4;j++){
                        local[i][j].setValue(0);
                    }
                }
                logic.rand_L(local);
                sqLite.updateActive(0,0,"2",1);
                touchLister.visible(local,1);
                break;
        }
    }
}
