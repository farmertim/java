package com.example.a20201011practice;

public class People {
    private int ID;
    private String Name;
    public People(int id,String name) {
        this.ID=id;
        this.Name = name;
    }
    public String getString(){
        return "我是"+ID+"號"+"我的名字是:"+this.Name;
    }
    public String  getName(){
        return Name;
    }
    public void setName(String name){
        this.Name=name;
    }
}
