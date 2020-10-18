package com.example.a2048grid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    ImageView grid,first;
    Local[][] local;
    ImageButton review;
    RelativeLayout relativeLayout;
    SQLite sqLite;
    logic logic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        logic=new logic();
        setLocal();
        relativeLayout=findViewById(R.id.relativeLayout);
        grid=new ImageView(this);
        grid.setImageResource(R.drawable.grid);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(1050, 1050);
        params.leftMargin =10;
        params.topMargin =230;
        relativeLayout.addView(grid, params);
        sqLite=new SQLite(this,logic,this);
        TouchLister touchLister=new TouchLister(this,local,sqLite,logic);
        ButtonLister buttonLister=new ButtonLister(this,touchLister,local,sqLite);
        review=(ImageButton)findViewById(R.id.review);
        review.setOnClickListener(buttonLister);
        grid.setOnTouchListener(touchLister);
    }

    private void showCustomerListView(SQLite sqLite) {
    }

    public void setLocal(){
        local=new Local[4][4];
        int count=0;
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                local[i][j]=new Local();
                local[i][j].setID(count);
                local[i][j].setValue(0);
                count++;
            }
        }
        int add=-100;

        local[0][0].setXY(100,440+add);
        local[1][0].setXY(100,646+add);
        local[2][0].setXY(100,835+add);
        local[3][0].setXY(100,1023+add);
        local[0][1].setXY(300,440+add);
        local[1][1].setXY(300,646+add);
        local[2][1].setXY(300,835+add);
        local[3][1].setXY(300,1023+add);
        local[0][2].setXY(506,440+add);
        local[1][2].setXY(506,646+add);
        local[2][2].setXY(506,835+add);
        local[3][2].setXY(506,1023+add);
        local[0][3].setXY(727,440+add);
        local[1][3].setXY(727,646+add);
        local[2][3].setXY(727,835+add);
        local[3][3].setXY(727,1023+add);

    }
}