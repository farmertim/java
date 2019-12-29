/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jonah;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author 胡維仁
 */
public class GameTwo extends BasicGame{
    public GameTwo(){
        System.out.println("GameTwo");
        this.x = 400;
        this.y = 400;
        this.state = 2;
    }
    public void logic(){
        
    }
    public void display(Graphics g){
        g.setColor(Color.DARK_GRAY);
        g.fillRect(0,0,1000,800);
        g.setColor(Color.RED);
        g.drawString("HELP HELP",x,y);
    }
}
