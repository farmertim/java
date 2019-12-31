
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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Timer;
import java.util.TimerTask;

public class move extends JFrame {

    static int a = 0, k = 0,ch=0;
    int rolex = 0, count = 0, roley = a, count1 = 0, check = 0;
    ImageIcon people1;
    ImageIcon people2;
    ImageIcon people3;
    ImageIcon people4;
    ImageIcon people5;

    ImageIcon FinalImage;
    ImageIcon FirstImage;
    ImageIcon First;
    ImageIcon Second;
    ImageIcon Three;
    Timer timer;
   
    control button1=new control();
    control button2=new control();
    control button3=new control();
    control button4=new control();
    control button5=new control();
    control button6=new control();
    control button7=new control();
    control button8=new control();
    control button9=new control();
    
    public move() {
        ImagePanel panel = new ImagePanel();
        panel.setBounds(100, 100, 30, 30);
        Button bt = new Button();

        people1 = new ImageIcon("人1.jpg");
        people2 = new ImageIcon("人2.jpg");
        people3 = new ImageIcon("人3.jpg");
        people4 = new ImageIcon("人4.jpg");

        FinalImage = new ImageIcon("終點.jpg");
        FirstImage = new ImageIcon("起點.jpg");
        First = new ImageIcon("第一關.jpg");
        Second = new ImageIcon("第二關.jpg");
        Three = new ImageIcon("第三關.jpg");

        bt.setBounds(2000, 2000, 50, 50);
        this.setTitle("HU WEI REN");
        this.setSize(3000, 3000);
        this.setLocation(0, 0);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
      
        runfunction();

        // timer.schedule(new timerTask(),1000,10);
    }
    public  void runfunction(){
          ImagePanel ip = new ImagePanel();
        this.add(ip);
    this.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                int by = 0;
                int bu = 0;
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    by = by + 5;
                } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    by = by - 5;
                }
                if (e.getKeyCode() == KeyEvent.VK_A) {
                    bu += -5;
                } else if (e.getKeyCode() == KeyEvent.VK_D) {
                    bu += 5;
                }
                if (roley <= 1500) {
                    a = roley;
                    roley += by;
                    k++;
                    if (roley == 160) {
                        JOptionPane.showMessageDialog(null, "開始遊戲", "歡迎進入", JOptionPane.WARNING_MESSAGE);
                    } else if (roley == 400) {
                        check = 1;
                        a = roley;
                        if(ch==0){
                      
        add(button1);
        add(button2);
        add(button3);
        add(button4);
        add(button5);
        add(button6);
        add(button7);
        add(button8);
        add(button9);
        setLayout(new GridLayout(3, 3));
        setBounds(0, 0, 3000, 3000);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        }
                       
                    } else if (roley == 800) {
                         a = roley;
                      
                    } else if (roley == 1200) {
                         a = roley;
                     
                        
                       
                    } else if (roley == 1450) {
                        JOptionPane.showMessageDialog(null, "結束遊戲", "結束遊戲", JOptionPane.WARNING_MESSAGE);
                    }

                } else {
                    roley = 1500;
                    a = roley;
                }
                if (roley <= 0) {
                    roley = 0;
                    a = roley;
                }
                repaint();
            }
        });

        timer = new Timer();
    }
    public static void main(String[] args) {

        move p = new move();
    }
      protected int index=1;
    class control extends JButton implements ActionListener{
        public control(){
            this.addActionListener(this);
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            if (this.getText().equals("")) {
                if (index % 2 == 0) {
                    this.setText("O");
                } else {
                    this.setText("X");
                }
            }
            else{
                // this.setText("P");
            }
            int a=0;
            if(button1.getText()==button2.getText()&&button2.getText()==button3.getText()&&button1.getText()!=""){
                a=1;
            }
            else  if(button4.getText()==button5.getText()&&button5.getText()==button6.getText()&&button4.getText()!=""){

                a=1;
            }
            else  if(button7.getText()==button8.getText()&&button8.getText()==button9.getText()&&button7.getText()!=""){
                a=1;
            }
            else if(button1.getText()==button4.getText()&&button4.getText()==button7.getText()&&button1.getText()!=""){

                a=1;
            }
            else if(button2.getText()==button5.getText()&&button5.getText()==button8.getText()&&button2.getText()!=""){

                a=1;
            }
            else  if(button3.getText()==button6.getText()&&button6.getText()==button9.getText()&&button3.getText()!=""){

                a=1;
            }
            else if(button1.getText()==button5.getText()&&button5.getText()==button9.getText()&&button1.getText()!=""){

                a=1;
            }
            else if(button3.getText()==button5.getText()&&button5.getText()==button7.getText()&&button3.getText()!=""){

                a=1;
            }
            else{
                if(index==9){
                    System.out.println("平手");
                }
            }
            if(a==1){

                button1.setText("");
                button2.setText("");
                button3.setText("");
                button4.setText("");
                button5.setText("");
                button6.setText("");
                button7.setText("");
                button8.setText("");
                button9.setText("");
                winloss();
            }
            index++;
        }
    }
    public void winloss(){
        JOptionPane.showMessageDialog(null, "繼續遊戲", "恭喜獲勝",JOptionPane.WARNING_MESSAGE);
         count++;
         move m=new move();
       
       
    }
    
    class ImagePanel extends JPanel {

        ImagePanel() {

            this.setBackground(Color.WHITE);
        }

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            //role.paintIcon(this, g, role_x, 50);
            g.drawLine(100, 100, 1500, 100);
            g.drawImage(First.getImage(), 400, 60, 80, 80, null);
            if (k == 4) {
                k = 0;
            }
            if (k == 0) {
                g.drawImage(people1.getImage(), roley, 50, 80, 80, null);
            }
            if (k == 1) {
                g.drawImage(people2.getImage(), roley, 50, 80, 80, null);
            }
            if (k == 2) {
                g.drawImage(people3.getImage(), roley, 50, 80, 80, null);
            }
            if (k == 3) {
                g.drawImage(people4.getImage(), roley, 50, 80, 80, null);
            }

            g.drawImage(FinalImage.getImage(), 1450, 60, 50, 70, null);
            g.drawImage(FirstImage.getImage(), 160, 90, 30, 30, null);
            g.drawImage(First.getImage(), 400, 60, 80, 80, null);
            g.drawImage(Second.getImage(), 800, 60, 80, 80, null);
            g.drawImage(Three.getImage(), 1200, 60, 80, 80, null);

        }
    }
}
