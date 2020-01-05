/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmer;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.ImageIcon;

/**
 *
 * @author 胡維仁
 */
public class finalgame extends BasicGame{
     ImageIcon myframe1;
    long times = 0;
    int prepage = 0;
    int page1 = 0;
    int onpic = 0;
    int preonpic = 0;
     int g3preclick = -1;
    int g3click = -1;
   public static int g3drawX = -1;
   public static int g3drawY = -1;
    boolean g1haswin = false;
    boolean g2haswin = false;
    boolean g3haswin = false;
   public static int[][] game1 = {{0,0,0},{0,0,0},{0,0,0}};
   public static int[][] game3 = {{0,0,0},{0,0,0},{0,0,0}};
    int game1win = 0;
    boolean g3win = false;
    boolean deuce = false;
    public finalgame(farmer jonah, TAG tag){
      super(tag);
      game3[0][0] = 8;
            game3[0][1] = 2;
            game3[0][2] = 5;
            game3[1][0] = 3;
            game3[1][1] = 7;
            game3[1][2] = 4;
            game3[2][0] = 1;
            game3[2][1] = 6;
            game3[2][2] = 0;     
      //  farmer.window=jonah;
    }
    public void display(Graphics g){
       
            g3win = false;
            myframe1 = new ImageIcon("Animation/gamebg3.JPG");
            g.drawImage(myframe1.getImage(), 0, 0, 1200, 520, null);
            g.setColor(Color.black);
            g.drawRect(400, 100, 400, 350);
            g.setColor(Color.white);
            g.fillRect(402, 102, 398, 348);
            g.setColor(Color.black);
            g.drawRect(450, 120, 300, 300);
            g.fillRect(450, 120, 300, 300);
            g.setColor(Color.white);
            g.drawLine(450, 220, 750, 220);
            g.drawLine(450, 320, 750, 320);
            g.drawLine(550, 120, 550, 420);
            g.drawLine(650, 120, 650, 420);
            myframe1 = new ImageIcon("Animation/gameback.JPG");
            g.drawImage(myframe1.getImage(), 1070, 445, 100, 50, null);
            times = 1;
            if(g3haswin)
            {
                myframe1 = new ImageIcon("Animation/gwin.JPG");
                g.drawImage(myframe1.getImage(), 100, 150, 250, 220, null);
            }
          
          else if(!g3win)
          {
            g.setColor(Color.black);
            g.drawRect(450, 120, 300, 300);
            g.fillRect(450, 120, 300, 300);
            g.setColor(Color.white);
            g.drawLine(450, 220, 750, 220);
            g.drawLine(450, 320, 750, 320);
            g.drawLine(550, 120, 550, 420);
            g.drawLine(650, 120, 650, 420);
            if(g3drawX!=-1)
            {
                Font fnt = new Font("Arial", 1, 50);
                g.setFont(fnt);
                if(game3[g3drawX][g3drawY]!=0)
                {
                    g.drawString(Integer.toString(game3[g3drawX][g3drawY]), 485+100*g3drawX, 190+100*g3drawY);
                }
                else
                {
                    g.drawString("X", 485+100*g3drawX, 190+100*g3drawY);
                }
                for(int i=0; i<3; i++)
                    for(int j=0; j<3; j++)
                         System.out.println(game3[i][j]);
            }
          }
          else 
          {
              Font fnt = new Font("Arial", 1, 50);
              g.setFont(fnt);
              g.setColor(Color.white);
              for(int i=0; i<3; i++)
              {
                  for(int j=0; j<3; j++)
                  {
                      if(game3[i][j]!=0)
                      {
                          g.drawString(Integer.toString(game3[i][j]), 485+100*j, 190+100*i);                         
                      }
                      else 
                      {
                          g.drawString("XD", 465+100*j, 190+100*i);                          
                      }
                  }                 
              }
               myframe1 = new ImageIcon("Animation/gwin.JPG");
               g.drawImage(myframe1.getImage(), 100, 150, 250, 220, null);
               g3haswin = true;
          }
    
    }
    }

