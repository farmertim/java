package com.example.a2048game;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView img_v;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setFinishOnTouchOutside(false);
        OnTouchEvent onTouchEvent=new OnTouchEvent(this);
        img_v = (ImageView)findViewById(R.id.imageView5);
        img_v.setOnTouchListener(onTouchEvent);
    }


}