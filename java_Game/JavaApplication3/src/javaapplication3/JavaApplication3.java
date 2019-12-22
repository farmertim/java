/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author 胡維仁
 */
public class JavaApplication3 extends JFrame{
    
JavaApplication3(){
CGPanel pane=new CGPanel();
pane.setBounds(20, 20, 200, 200);
add(pane);
setTitle("jlk");
setLayout(null);
setBounds(50,50,240,250);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
}
    /**
     * @param args the command line arguments
     */

    class CGPanel extends JPanel{

@Override
public void paintComponent(Graphics g){
    ImageIcon icon=new ImageIcon("下載.jpg");
    Image img=icon.getImage();
    g.drawImage(img,0,0,this);
}
}
}
class run{
public static void main(String[] args){
JavaApplication3 js=new JavaApplication3();
}
}
