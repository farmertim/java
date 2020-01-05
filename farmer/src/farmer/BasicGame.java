/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmer;

import java.awt.Graphics;

/**
 *
 * @author 胡維仁
 */
public abstract class BasicGame implements Important{
    protected int x, y;
    protected int state;
    protected boolean win;
    protected TAG tag;
    public BasicGame(TAG tag){
        win = false;
        this.tag = tag;
    }
    public TAG getTag(){
        return tag;
    }
    public void setX(int x){
        this.x = x;
    }
    public int getX(){
        return this.x;
    }
    public void display(Graphics g){
        
    }
    public void logic(){
        
    }
    public void setWin(boolean stat){
        win = stat;
    }
    public boolean getWin(){
        return win;
    }
}
