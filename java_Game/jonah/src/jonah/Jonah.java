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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.Set;
import javax.swing.JFrame;

/**
 *
 * @author 胡維仁
 */
public class Jonah extends Canvas{
    Window wind;
    BasicGame game;
    public static PAGE page;
    public static TAG tag;
    public static int score = 0;
    public ArrayList<BasicGame>gamelist = new ArrayList<BasicGame>();
    public Jonah(){
        page = PAGE.move;
        wind = new Window(this);
        MouseAdapter ma = new MouseAdapter(){
            @Override public void mousePressed(MouseEvent e){
                int xx = e.getX();
                int yy = e.getY();
                System.out.println("xx "+xx+" yy" + yy);
                if( Jonah.page == PAGE.move){
                    move bg = (move)gamelist.get(0);
                }
                else if( Jonah.page == PAGE.Game1){
                    GameOne bg = (GameOne)gamelist.get(0);
                    if(xx>250&&xx<400&&yy>150&&yy<300){
                        System.out.println("b1");
                        bg.setClick(0);
                    }
                    else  if(xx>400&&xx<550&&yy>150&&yy<300){
                        System.out.println("b2");
                        bg.setClick(1);
                    }
                     else  if(xx>550&&xx<700&&yy>150&&yy<300){
                        System.out.println("b3");
                         bg.setClick(2);
                    }
                      else  if(xx>250&&xx<400&&yy>300&&yy<450){
                        System.out.println("b4");
                         bg.setClick(3);
                    }
                       else  if(xx>400&&xx<550&&yy>300&&yy<450){
                        System.out.println("b5");
                         bg.setClick(4);
                    }
                       else  if(xx>550&&xx<700&&yy>300&&yy<450){
                        System.out.println("b6");
                         bg.setClick(5);
                    }
                      else  if(xx>250&&xx<400&&yy>450&&yy<700){
                        System.out.println("b7");
                         bg.setClick(6);
                    }
                       else  if(xx>400&&xx<550&&yy>450&&yy<700){
                        System.out.println("b8");
                         bg.setClick(7);
                    }
                     else  if(xx>550&&xx<700&&yy>450&&yy<700){
                        System.out.println("b9");
                         bg.setClick(8);
                    }
                      else  if(xx>740&&xx<840&&yy>170&&yy<200){
                        bg.setClick(9);
                        System.out.println("重新開始");
                    }
                      else if(xx>750&&xx<850&&yy>550&&yy<600&&GameOne.wi==1){
                       bg.setClick(10);
                      }
                }
            }
        };
        		KeyAdapter keyProcessor = new KeyAdapter() {
			public void keyPressed(KeyEvent ke)
			{
                            System.out.println("Key " + ke.getKeyCode());
                            System.out.println("KeyEvent " + KeyEvent.VK_D);
                             if( Jonah.page == PAGE.move){
                                  if( ke.getKeyCode() == KeyEvent.VK_RIGHT){
                                   move.a+=2;
                                   move.k++;
                                   if(move.a>=900){
                                   move.a=900;
                                   }
                                   else if(move.a==270){
                                       move.a+=2;
                                   move.k++;
                                       System.out.println("6666666");
                                       if(gamelist.size() != 0){
                                       gamelist.remove(0);
                                       }
                                        gamelist.add(new GameOne(TAG.G1));
                                          Jonah.page = PAGE.Game1;
                                   }
                               }
                             }
                            if( Jonah.page == PAGE.Game1){
                              
                            }
                            else  if(Jonah.page == PAGE.Move){
                                if( ke.getKeyCode() == KeyEvent.VK_D){
                                    Jonah.score++;
                                    System.out.println(Jonah.score);
                                    if( Jonah.score == 5){
                                        System.out.println("move to gameone");
                                    if(gamelist.size() == 0)
                                        gamelist.add(new GameOne(TAG.G1));
                                    else{
                                        gamelist.remove(0);
                                        gamelist.add(new GameOne(TAG.G1));
                                        
                                    }
                                    Jonah.page = PAGE.Game1;
                                    }
                                    
                                }
                            }
                            else if (Jonah.page == PAGE.Game1){
                                if( gamelist.get(0).getWin()){
                                    System.out.println("move to gametwo");
                                    if(gamelist.size() == 0){
                                        gamelist.add(new GameTwo(TAG.G2));
                                    
                                    }
                                    else{
                                        gamelist.remove(0);
                                        gamelist.add(new GameTwo(TAG.G2));
                                      
                                    }
                                    Jonah.page = PAGE.Game2;
                                  
                                }
                            }
			}
		};
		this.addKeyListener(keyProcessor);
                this.addMouseListener(ma);
                
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
        if(gamelist.size() != 0){
            for( int i = 0; i <gamelist.size(); i++){
                BasicGame bg = gamelist.get(i);
                bg.display(g);
            }
        }
        
        g.dispose();
        bs.show();
    }
    public void logic(){
        if(Jonah.page==PAGE.move){
         
                 if( gamelist.size() == 0){
                gamelist.add(new move(this,TAG.m));
                System.out.println(" create new game1");
            }
            else if(gamelist.get(0).getTag()==TAG.G1){
                gamelist.remove(0);
                gamelist.add(new move(this,TAG.m));
                System.out.println(" create game1");
            }
            else{
                // TODO
                System.out.println("XXX");
            }
            
        }
        else if( Jonah.page == PAGE.Game1){
            if( gamelist.size() == 0){
                gamelist.add(new GameOne(TAG.G1));
                System.out.println(" create new game1");
            }
            else if(gamelist.get(0).getTag()==TAG.G2){
                gamelist.remove(0);
                gamelist.add(new GameOne(TAG.G1));
                System.out.println(" create game1");
            }
            else{
                // TODO
                System.out.println("XXX");
            }  
        }
        else if(Jonah.page == PAGE.Game2){
             if( gamelist.size() == 0){
                gamelist.add(new GameTwo(TAG.G2));
                System.out.println(" create new game1");
            }
            else if(gamelist.get(0).getTag()==TAG.G1){
                gamelist.remove(0);
                gamelist.add(new GameTwo(TAG.G2));
                System.out.println(" create game1");
            }
            else{
                // TODO
                System.out.println("XXX");
            }  
        }
    }
    public static void main(String[] args) {
        // TODO code application logic here
        Jonah jonah = new Jonah();
        while( true ){
            jonah.logic();
            jonah.display();
        }
    }
    public static void setPage(PAGE page){
        Jonah.page = page;
    }
    
}
