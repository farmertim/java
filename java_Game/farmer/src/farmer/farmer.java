/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmer;

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
public class farmer extends Canvas{
    Window wind;
    BasicGame game;
    public static PAGE page;
    public static TAG tag;
    public static int score = 0;
    public ArrayList<BasicGame>gamelist = new ArrayList<BasicGame>();
    public farmer(){
        page = PAGE.move;
        wind = new Window(this);
        MouseAdapter ma = new MouseAdapter(){
            @Override public void mousePressed(MouseEvent e){
                int xx = e.getX();
                int yy = e.getY();
                System.out.println("xx "+xx+" yy" + yy);
                if( farmer.page == PAGE.move){
                    move bg = (move)gamelist.get(0);
                }
                else if( farmer.page == PAGE.Game1){
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
                             if( farmer.page == PAGE.move){
                                  if( ke.getKeyCode() == KeyEvent.VK_RIGHT){
                                   move.a+=5;
                                   move.k++;
                                   if(move.a>=900){
                                   move.a=900;
                                   }
                                   else if(move.a==250){
                                       move.a+=5;
                                   move.k++;
                                       System.out.println("6666666");
                                       if(gamelist.size() != 0){
                                       gamelist.remove(0);
                                       }
                                        gamelist.add(new GameOne(TAG.G1));
                                          farmer.page = PAGE.Game1;
                                   }
                                   else if(move.a==500){
                                    move.a+=5;
                                   move.k++;
                                       System.out.println("6666666");
                                       if(gamelist.size() != 0){
                                       gamelist.remove(0);
                                        System.out.println("NORemoveGame3");
                                       }
                                        gamelist.add(new GameThree(farmer.this,TAG.G3));//this是只內部類別 所以要用farmer.this
                                          farmer.page = PAGE.Game3;
                                          System.out.println("Game3");
                                   }
                               }
                             }
                            if( farmer.page == PAGE.Game1){
                              
                            }
                            else  if(farmer.page == PAGE.Move){
                                if( ke.getKeyCode() == KeyEvent.VK_D){
                                    farmer.score++;
                                    System.out.println(farmer.score);
                                    if( farmer.score == 5){
                                        System.out.println("move to gameone");
                                    if(gamelist.size() == 0)
                                        gamelist.add(new GameOne(TAG.G1));
                                    else{
                                        gamelist.remove(0);
                                        gamelist.add(new GameOne(TAG.G1));
                                        
                                    }
                                    farmer.page = PAGE.Game1;
                                    }
                                    
                                }
                            }
                            else if (farmer.page == PAGE.Game3){
                                if( gamelist.get(0).getWin()){
                                    System.out.println("move to gametwo");
                                    if(gamelist.size() == 0){
                                        gamelist.add(new GameTwo(TAG.G3));
                                    
                                    }
                                    else{
                                        gamelist.remove(0);
                                        gamelist.add(new GameTwo(TAG.G3));
                                      
                                    }
                                    farmer.page = PAGE.Game3;
                                  
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
        if(farmer.page==PAGE.move){
                 if( gamelist.size() == 0){
                gamelist.add(new move(this,TAG.m));
                System.out.println(" create new game1");
            }
            else if(gamelist.get(0).getTag()!=TAG.m){
                gamelist.remove(0);
                gamelist.add(new move(this,TAG.m));
                System.out.println(" create game1");
            }
            else{
                // TODO
                //System.out.println("XXX");
            }
            
        }
        else if( farmer.page == PAGE.Game1){
            if( gamelist.size() == 0){
                gamelist.add(new GameOne(TAG.G1));
                System.out.println(" create new game1");
            }
            else if(gamelist.get(0).getTag()!=TAG.G1){
                gamelist.remove(0);
                gamelist.add(new GameOne(TAG.G1));
                System.out.println(" create game1");
            }
            else{
                // TODO
                //System.out.println("XXX");
            }  
        }
        else if(farmer.page == PAGE.Game2){
             if( gamelist.size() == 0){
                gamelist.add(new GameTwo(TAG.G2));
                System.out.println(" create new game1");
            }
            else if(gamelist.get(0).getTag()!=TAG.G2){
                gamelist.remove(0);
                gamelist.add(new GameTwo(TAG.G2));
                System.out.println(" create game1");
            }
            else{
                // TODO
                //System.out.println("XXX");
            }  
        }
         else if(farmer.page == PAGE.Game3){
             if( gamelist.size() == 0){
                gamelist.add(new GameThree(this,TAG.G3));
                System.out.println(" create new game3");
            }
            else if(gamelist.get(0).getTag()!=TAG.G3 ){
                gamelist.remove(0);
                gamelist.add(new GameThree(this,TAG.G3));
                System.out.println(" create game3");
            }
            else{
                // TODO
                //System.out.println("XXX");
            }  
        }
    }
    public static void main(String[] args) {
        // TODO code application logic here
        farmer jonah = new farmer();
        while( true ){
            jonah.logic();
            jonah.display();
        }
    }
    public static void setPage(PAGE page){
        farmer.page = page;
    }
    
}