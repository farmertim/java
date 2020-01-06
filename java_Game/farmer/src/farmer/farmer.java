/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmer;

import java.awt.Canvas;
import java.awt.Color;
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
       public static int mx=-1;
       public static int my=-1;
    long times = 0;
    int prepage = 0;
    int page1 = 0;
    int onpic = 0;
    int preonpic = 0;
    int g3preclick = -1;
    int g3click = -1;
   // int g3drawX = -1;
   // int g3drawY = -1;
    boolean g1haswin = false;
    boolean g2haswin = false;
    boolean g3haswin = false;
   // int[][] game1 = {{0,0,0},{0,0,0},{0,0,0}};
   // int[][] game3 = {{0,0,0},{0,0,0},{0,0,0}};
    int game1win = 0;
    boolean g3win = false;
    boolean deuce = false;
    Window wind;
    BasicGame game;
    public static PAGE page;
    public static TAG tag;
    public static int score = 0;
    public ArrayList<BasicGame>gamelist = new ArrayList<BasicGame>();
    public farmer(){
        page = PAGE.Game4;
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
                  else if( farmer.page == PAGE.Game4){
                         finalgame bg = (finalgame)gamelist.get(0);
             mx = e.getX();
             my = e.getY();
            if(mx>=1070 && my>=445 && mx<=1170 && my<= 495)
            {
                times = 0;
                page1 = 0;
                prepage = 0;
               // repaint();
            }
            mx -= 450;
            my -= 120;
            if(mx>=0 && my>=0 && mx<=300 && my<=300)
            {
                mx/=100;
                my/=100;
                g3click = finalgame.game3[mx][my];
                if(g3click != g3preclick)
                {
                    g3preclick = g3click;
                    finalgame.g3drawX = mx;
                    finalgame.g3drawY = my;
                   // repaint();
                }
                else
                {
                    if(finalgame.game3[mx][my] != 0)
                    {
                        if(mx != 0)
                        {
                              System.out.println("99999999999999999999"+finalgame.game3[mx-1][my]);
                            if(finalgame.game3[mx-1][my]==0)
                            {
                                
                                int temp = finalgame.game3[mx-1][my];
                                finalgame.game3[mx-1][my] = finalgame.game3[mx][my];
                                finalgame.game3[mx][my] = temp;
                                 System.out.println("99999999999999999999"+temp);
                            }
                        }
                        if(mx != 2)
                        {
                            if(finalgame.game3[mx+1][my]==0)
                            {
                                System.out.println("111111111111111111"+finalgame.game3[mx+1][my]);
                           
                                int temp = finalgame.game3[mx+1][my];
                                 System.out.println("111111111111111111"+finalgame.game3[mx][my]);
                           
                                finalgame.game3[mx+1][my] = finalgame.game3[mx][my];
                                  System.out.println("111111111111111111"+finalgame.game3[mx+1][my]);
                           
                                finalgame.game3[mx][my] = temp;
                                  System.out.println("111111111111111111"+finalgame.game3[mx][my]);
                           
                            }
                        }
                        if(my != 0)
                        {
                           
                            if(finalgame.game3[mx][my-1]==0)
                            {
                                int temp = finalgame.game3[mx][my-1];
                                finalgame.game3[mx][my-1] = finalgame.game3[mx][my];
                                finalgame.game3[mx][my] = temp;
                                 System.out.println("8888888888888888888888"+temp);
                            }
                        }
                        if(my != 2)
                        {
                            if(finalgame.game3[mx][my+1]==0)
                            {
                                  System.out.println("2222222222222222222"+finalgame.game3[mx][my+1]);
                                int temp = finalgame.game3[mx][my+1];
                                finalgame.game3[mx][my+1] = finalgame.game3[mx][my];
                                finalgame.game3[mx][my] = temp;
                            }
                        }
                    }                   
                    finalgame.g3drawX =  -1;
                    finalgame.g3drawY =  -1;
                   // repaint();
                }
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
                                   /*
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
                                   */
                                   else if(move.a==550){
                                            move.a+=5;
                                   move.k++;
                                       System.out.println("6666666");
                                       if(gamelist.size() != 0){
                                       gamelist.remove(0);
                                        System.out.println("NORemoveGame4");
                                       }
                                        gamelist.add(new finalgame(farmer.this,TAG.G4));//this是只內部類別 所以要用farmer.this
                                          farmer.page = PAGE.Game4;
                                          System.out.println("Game4");
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
                            
                                 else if (farmer.page == PAGE.Game4){
                                if( gamelist.get(0).getWin()){
                                    System.out.println("move to gametwo");
                                    if(gamelist.size() == 0){
                                        gamelist.add(new GameTwo(TAG.G4));
                                    
                                    }
                                    else{
                                        gamelist.remove(0);
                                        gamelist.add(new finalgame(farmer.this,TAG.G4));
                                      
                                    }
                                    farmer.page = PAGE.Game4;
                                  
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
        Color color = new Color(153,255,153);
        g.setColor(color);
        g.fillRect(0,0,1000, 800);
        
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
         else if(farmer.page==PAGE.Game4){
        if( gamelist.size() == 0){
                gamelist.add(new finalgame(this,TAG.G4));
                System.out.println(" create new game4");
            }
            else if(gamelist.get(0).getTag()!=TAG.G4 ){
                gamelist.remove(0);
                gamelist.add(new finalgame(this,TAG.G4));
                System.out.println(" create game4");
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
