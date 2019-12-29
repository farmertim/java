/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jonah;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.util.Set;
import javax.swing.JFrame;

/**
 *
 * @author 胡維仁
 */
public class Jonah extends Canvas{
    Window wind;
    BasicGame game;
    public Jonah(){
        wind = new Window(this);
        game = new GameOne();
        		KeyAdapter keyProcessor = new KeyAdapter() {
			public void keyPressed(KeyEvent ke)
			{
                            if( ke.getKeyCode() == KeyEvent.VK_D){
                                game = new GameTwo();
                                                               
                            }
                            if( game.state == 1)
                            if( ke.getKeyCode() == KeyEvent.VK_D)
                                game.setX(game.getX()+20); 
			}
		};
		this.addKeyListener(keyProcessor);
    }
    /**
     * @param args the command line arguments
     */
    public void display(){
        BufferStrategy bs = this.getBufferStrategy();//
        if(bs==null){
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        game.display(g);
        
        g.dispose();
        bs.show();
    }
    public static void main(String[] args) {
        // TODO code application logic here
        Jonah jonah = new Jonah();
        while( true ){
            jonah.display();
        }
    }
    
}
