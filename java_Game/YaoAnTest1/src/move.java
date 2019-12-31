
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
    
    static int a = 0, k = 0, mode =0;
    int rolex = 0, count = 0, roley = a, count1 = 0, check = 0;
     control button1=new control();
    control button2=new control();
    control button3=new control();
    control button4=new control();
    control button5=new control();
    control button6=new control();
    control button7=new control();
    control button8=new control();
     control button9=new control();
    public  static int count=0;
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
                        
                        mode = 1;
                       if(count==0){
        initComponents();
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
        else{
        
        }
                        } else if (roley == 800) {
                             a = roley;
                            mode = 2;
                        } else if (roley == 1200) {
                             a = roley;
                            mode = 3;


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

    class ImagePanel extends JPanel {

        ImagePanel() {

            this.setBackground(Color.WHITE);
        }

        protected void paintComponent(Graphics g) {
            if(mode==0)
            {
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
            else if(mode==3)
            {
                if( isLose )
			{
				g.setColor(new Color(255, 0, 0));
				g.setFont(new Font("Times", Font.BOLD, 30));
				g.drawString("Game Over", 50, 200);
			}
			else
			{
				g.setColor(new Color(240, 240, 80));
				g.fillOval(ballX, ballY, BALL_SIZE, BALL_SIZE);
				g.setColor(new Color(80, 80, 200));
				g.fillRect(racketX, RACKET_Y, RACKET_WIDTH, RACKET_HEIGHT);
			}
            }

        }
    }
}

