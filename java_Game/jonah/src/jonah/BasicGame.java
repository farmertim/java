/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jonah;

import java.awt.Graphics;

/**
 *
 * @author 胡維仁
 */
public abstract class BasicGame implements Important{
    protected int x, y;
    protected int state;
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
}
