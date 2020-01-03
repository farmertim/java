
import jonah.PAGE;
import static PAGE.Move;
import static PAGE.Move;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 胡維仁
 */
public class PageObject {
    //public static PAGE page;
    protected int x, y;
    /*public PageObject(int x, int y, PAGE page){
        this.page = page;
        this.x = x;
        this.y = y;
    }
    */
    PageObject(){
    
    }
    public void render(Graphics g){
        g.setColor(Color.GREEN);
        g.fillRect(x, y, move.WIDTH, move.HEIGHT);
        g.drawRect(100, 100, 100, 100);
    }
    public static void main(String[] args){
      
    PageObject p=new PageObject();
    while(true){
       
        
    
    }
    }
  
}
