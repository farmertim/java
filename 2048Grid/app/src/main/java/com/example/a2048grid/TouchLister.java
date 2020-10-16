package com.example.a2048grid;

import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

public class TouchLister implements View.OnTouchListener {
    boolean checkLong=true;
    int[] picture;
    Local[][] local;
    TextView showGrade;
    ImageView[] imageViews;
    public int firstDownX=0,firstDownY=0;
    AppCompatActivity mainClass;
    RelativeLayout relativeLayout;
    logic logic=new logic();
    public TouchLister(AppCompatActivity mainClass,Local[][] locals){
        this.mainClass=mainClass;
        picture=new int[]{R.drawable.one,R.drawable.two,R.drawable.three,R.drawable.four,R.drawable.five,
                R.drawable.six,R.drawable.seven,R.drawable.eight,R.drawable.nine,R.drawable.ten,R.drawable.eleven,R.drawable.twelve,
                R.drawable.gameover
        };
        imageViews=new ImageView[17];
        for(int i=0;i<17;i++){
            imageViews[i]=new ImageView(mainClass);
        }
        this.local=locals;
        logic.rand_L(local);
        visible(locals,1);


    }
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        logic=new logic();
        int x=(int)event.getX();
        int y=(int)event.getY();
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                firstDownX=x;
                firstDownY=y;
                relativeLayout=mainClass.findViewById(R.id.relativeLayout);
                relativeLayout.removeView(imageViews[16]);
                break;
            case MotionEvent.ACTION_MOVE:

                if(x-firstDownX<-100&&checkLong){
                    checkGameDirection(logic,1);
                }
                else if(x-firstDownX>100&&checkLong){
                    checkGameDirection(logic,2);
                }

                else if(y-firstDownY>100&&checkLong){
                    checkGameDirection(logic,3);
                }
                else if(y-firstDownY<-100&&checkLong){
                    checkGameDirection(logic,4);
                }
                break;
            case MotionEvent.ACTION_UP:
                checkLong=true;
                if(CheckGameOver()==false){
                    visible(local,2);
                }
                break;
        }

        //Toast.makeText(mainClass, "x:"+x+" y:"+y, Toast.LENGTH_SHORT).show();
        return true;
    }
    public boolean CheckGameOver(){
        boolean check=false;
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                if(local[i][j].getValue()==0){
                    return true;
                }
            }
        }
        for(int i=0;i<4;i++){
            for(int j=0;j<4-1;j++){
                if(local[i][j].getValue()==local[i][j+1].getValue()){
                    return true;
                }
            }
        }
        for(int j=0;j<4;j++){
            for(int i=0;i<4-1;i++){
                if(local[i][j].getValue()==local[i+1][j].getValue()){
                    return true;
                }
            }
        }
        return check;
    }
    public void visible(Local[][] locals,int checkGameOver){
        if(checkGameOver==1) {
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if (locals[i][j].getValue() != 0) {
                        relativeLayout = mainClass.findViewById(R.id.relativeLayout);
                        imageViews[locals[i][j].getID()].setImageResource(picture[locals[i][j].getPictureUrl(locals[i][j].getValue())]);
                        showGrade = mainClass.findViewById(R.id.grade);
                        showGrade.setText("分數" + "\n" + logic.grade);
                        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(200, 210);
                        params.leftMargin = locals[i][j].getX();
                        params.topMargin = locals[i][j].getY();
                        relativeLayout.addView(imageViews[locals[i][j].getID()], params);
                    }
                }
            }
        }else{
            relativeLayout = mainClass.findViewById(R.id.relativeLayout);
            imageViews[16].setImageResource(picture[12]);
            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(850, 850);
            params.leftMargin =100 ;
            params.topMargin = 300;
            relativeLayout.addView(imageViews[16], params);
        }
    }
    public void checkGameDirection(logic logic,int location){
        boolean check=true;
        if(location==4){
            RemoveView();
            check=logic.move_up(local);
        }
        else if(location==3){
            RemoveView();
            check=logic.move_down(local);
        }else if(location==2){
            RemoveView();
            check=logic.move_right(local);
        }else if(location==1){
            RemoveView();
            check=logic.move_left(local);
        }
        if(check){
            logic.rand_L(local);
        }
        visible(local,1);
        checkLong=false;
    }
    public void RemoveView(){

        for(int i=0;i<17;i++){
            relativeLayout=mainClass.findViewById(R.id.relativeLayout);
            relativeLayout.removeView(imageViews[i]);
        }
    }
    public int RandomNumber(){
        Random random=new Random();
        int number=random.nextInt(16);
        return number;
    }
}
