
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

  static int a=0;
    int rolex = 0, count = 0, roley = a, count1 = 0,check=0;
    ImageIcon people;
    ImageIcon people2;
    ImageIcon FinalImage;
    ImageIcon FirstImage;
    ImageIcon First;
    Timer timer;

    public move() {
        ImagePanel panel = new ImagePanel();
        panel.setBounds(100, 100, 30, 30);
        Button bt = new Button();
        people = new ImageIcon("下載.jpg");
        people2 = new ImageIcon("派大星.jpg");
        FinalImage = new ImageIcon("終點.jpg");
        FirstImage = new ImageIcon("起點.jpg");
        First = new ImageIcon("第一關.jpg");
        bt.setBounds(2000, 2000, 50, 50);
  this.setTitle("HU WEI REN");
        this.setSize(3000, 3000);
        this.setLocation(0, 0);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
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
                      a=roley;
                    roley += by;
                    if (roley == 160) {
                        JOptionPane.showMessageDialog(null, "開始遊戲", "歡迎進入", JOptionPane.WARNING_MESSAGE);
                    } else if (roley == 400) {
                        check=1;
                       a=roley;
                    game1  g = new game1();
                    }else if(roley==1450){
                      JOptionPane.showMessageDialog(null, "結束遊戲", "結束遊戲", JOptionPane.WARNING_MESSAGE);
                    }
                    
                } else {
                    roley = 1500;
                    a=roley;
                }
                if (roley <= 0) {
                    roley = 0;
                      a=roley;
                }

                if (rolex <= 500) {
                    rolex += bu;
                } else {
                    rolex = 500;
                }
                if (rolex <= 0) {
                    rolex = 0;
                }
                repaint();
            }
        });

      

        timer = new Timer();

        // timer.schedule(new timerTask(),1000,10);
    }

    public static void main(String[] args) {

        move p = new move();
    }
    class ImagePanel extends JPanel {

        ImagePanel() {

            this.setBackground(Color.green);
        }

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            //role.paintIcon(this, g, role_x, 50);
            g.drawLine(100, 100, 1500, 100);
            g.drawImage(First.getImage(), 400, 60, 80, 80, null);
            g.drawImage(people.getImage(), rolex, 500, null);
            g.drawImage(people2.getImage(), roley, 50, null);
            g.drawImage(FinalImage.getImage(), 1450, 60, 50, 70, null);
            g.drawImage(FirstImage.getImage(), 160, 90, 30, 30, null);
            g.drawImage(First.getImage(), 400, 60, 80, 80, null);
        }
    }
}
