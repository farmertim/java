package com.example.a2048;

import android.view.MotionEvent;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class TouchLister implements View.OnTouchListener {
    public int firstDownX=0,firstDownY=0;
    AppCompatActivity mainClass;
    int[] array;
    public TouchLister(AppCompatActivity mainClass){
        this.mainClass=mainClass;
        array= new int[]{mainClass.findViewById(R.id.right).getId(),mainClass.findViewById(R.id.left).getId(),
        mainClass.findViewById(R.id.U).getId(),mainClass.findViewById(R.id.down).getId()
        };
        for (int arr:array) {
            mainClass.findViewById(arr).setVisibility(View.GONE);
        }
    }
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int x=(int)event.getX();
        int y=(int)event.getY();
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                firstDownX=x;
                firstDownY=y;
                break;
            case MotionEvent.ACTION_MOVE:
                if(x-firstDownX<-100)
                    visible(mainClass.findViewById(R.id.left),View.VISIBLE);
                else if(x-firstDownX>100)
                    visible(mainClass.findViewById(R.id.right),View.VISIBLE);
                else if(y-firstDownY>100)
                    visible(mainClass.findViewById(R.id.down),View.VISIBLE);
                else if(y-firstDownY<-100)
                    visible(mainClass.findViewById(R.id.U),View.VISIBLE);
                break;
        }
        return true;
    }
    public boolean visible(View view,int item){
        for (int arr:array) {
            if(arr==view.getId())
                mainClass.findViewById(view.getId()).setVisibility(item);
            else
            mainClass.findViewById(arr).setVisibility(View.GONE);
        }
        return true;
    }

}
