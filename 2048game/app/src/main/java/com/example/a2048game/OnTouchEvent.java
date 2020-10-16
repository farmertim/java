package com.example.a2048game;

import android.opengl.Visibility;
import android.view.MotionEvent;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

public class OnTouchEvent implements View.OnTouchListener {
    AppCompatActivity mainClass;
    public int firstDownX=0,firstDownY=0,secondUpX=0,secondUpY=0,item= View.GONE;
    public OnTouchEvent(AppCompatActivity mainClass){
        this.mainClass=mainClass;
        mainClass.findViewById(R.id.right).setVisibility(View.GONE);
        mainClass.findViewById(R.id.left).setVisibility(View.GONE);
        mainClass.findViewById(R.id.U).setVisibility(View.GONE);
        mainClass.findViewById(R.id.down).setVisibility(View.GONE);

    }

     public boolean visible(View view,int item){
        mainClass.findViewById(view.getId()).setVisibility(item);
        return true;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int checkX=0,checkY=0;
        int x=(int)event.getX();
        int y=(int)event.getY();
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                firstDownX=x;
                firstDownY=y;
                break;
            case MotionEvent.ACTION_UP:
                secondUpX=x;
                secondUpY=y;
                checkX=secondUpX-firstDownX;
                checkY=secondUpY-firstDownY;
                if(checkX>50&&checkY<10&&checkY>-10){
                    visible(mainClass.findViewById(R.id.right),View.VISIBLE);
                }else if(checkY>50&&checkX<10&&checkX>-10){
                    visible(mainClass.findViewById(R.id.U),View.VISIBLE);
                }else if(checkX<-50&&checkY<10&&checkY>-10){
                    visible(mainClass.findViewById(R.id.left),View.VISIBLE);
                }else if(checkY<-50&&checkX<10&&checkX>-10){
                    visible(mainClass.findViewById(R.id.left),View.VISIBLE);
                }
                else{
                    mainClass.findViewById(R.id.right).setVisibility(View.VISIBLE);
                    mainClass.findViewById(R.id.left).setVisibility(View.VISIBLE);
                    mainClass.findViewById(R.id.U).setVisibility(View.VISIBLE);
                    mainClass.findViewById(R.id.down).setVisibility(View.VISIBLE);
                }
                break;
        }
        return true;
    }
}
