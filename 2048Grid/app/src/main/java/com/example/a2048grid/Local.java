package com.example.a2048grid;

public class Local {
    private int ID;
    private int x;
    private int y;
    private int value;
    private int pictureUrl;
    int item;
    public void setXY(int x,int y){
        this.x=x;
        this.y=y;
    }
    public void setID(int id){
        this.ID=id;
    }
    public int getID(){
        return ID;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public int getValue(){
        return value;
    }
    public void setValue(int value){
        this.value=value;
    }
    public int getPictureUrl(int value){
        switch (value){
            case 2:
                item=0;
                break;
            case 4:
                item=1;
                break;
            case 8:
                item=2;
                break;
            case 16:
                item=3;
                break;
            case 32:
                item=4;
                break;
            case 64:
                item=5;
                break;
            case 128:
                item=6;
                break;
            case 256:
                item=7;
                break;
            case 512:
                item=8;
                break;
            case 1024:
                item=9;
                break;
            case 2048:
                item=10;
                break;
            case 4096:
                item=11;
        }
        return item;
    }
}
