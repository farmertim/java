
import java.awt.Button;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 胡維仁
 */

import java.awt.*;

import java.awt.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

public class move extends JFrame {

    int rolex=0,count=0,roley=0,count1=0;
    ImageIcon people;
    ImageIcon people2;
    Timer timer;
    public move(){
        Button bt=new Button();
        people=new ImageIcon("下載.jpg");
        people2=new ImageIcon("派大星.jpg");
        bt.setBounds(2000,2000,50,50);

        this.setTitle("HU WEI REN");
        this.setSize(3000, 3000);
        this.setLocation(0, 0);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        ImagePanel ip=new ImagePanel();
        this.add(ip);

        timer=new Timer();

        timer.schedule(new timerTask(),1000,10);

    }

    public static void main(String[] args){

        move p=new move();
    }
    class timerTask extends TimerTask{
        @Override
        public void run() {
            if(roley<=500&&count1==0){
                roley++;
            }
            else{
                roley--;
                count1=1;
                if(roley<=0) {
                    count1 = 0;
                }
            }
            if(rolex<=500&&count==0){
                rolex++;
            }
            else{
                rolex--;
                count=1;
                if(rolex<=0) {
                    count = 0;
                }
            }
            repaint();
        }
    }

    class ImagePanel extends JPanel{
        ImagePanel(){

            this.setBackground(Color.green);
        }

        protected void paintComponent(Graphics g){
            super.paintComponent(g);
            //role.paintIcon(this, g, role_x, 50);
            g.drawImage(people.getImage(), rolex, 100, null);
            g.drawImage(people2.getImage(),100,roley,null);
        }
    }
}
