/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmer;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.ImageIcon;

/**
 *
 * @author 胡維仁
 */
public class move extends BasicGame{
     static int a = 0, k = 0;
    int rolex = 0, count = 0, count1 = 0, check = 0;
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
    farmer window;
    public move(farmer jonah, TAG tag){
        super(tag);
        this.window = jonah;
        people1 = new ImageIcon("Animation/人1.jpg");
        people2 = new ImageIcon("Animation/人2.jpg");
        people3 = new ImageIcon("Animation/人3.jpg");
        people4 = new ImageIcon("Animation/人4.jpg");

    FinalImage = new ImageIcon("Animation/終點.jpg");
        FirstImage = new ImageIcon("Animation/起點.jpg");
        First = new ImageIcon("Animation/第一關.jpg");
        Second = new ImageIcon("Animation/第二關.jpg");
        Three = new ImageIcon("Animation/第三關.jpg");
    }
    public void display(Graphics g){
        //System.out.println("32323232");
        g.setColor(Color.WHITE);
        g.fillRect(0,0,1000,800);
        
            if (k == 4) {
                k = 0;
            }
            if (k == 0) {
                g.drawImage(people1.getImage(), a, 50, 80, 80, window);
            }
            if (k == 1) {
                g.drawImage(people2.getImage(), a, 50, 80, 80, window);
            }
            if (k == 2) {
                g.drawImage(people3.getImage(), a, 50, 80, 80, window);
            }
            if (k == 3) {
                g.drawImage(people4.getImage(), a, 50, 80, 80, window);
            }
             g.drawLine(0, 100, 900, 100);
            g.drawImage(FinalImage.getImage(), 900, 60, 50, 70, window);
            g.drawImage(FirstImage.getImage(), 15, 90, 30, 30, window);
            g.drawImage(First.getImage(), 250, 60, 80, 80, window);
            g.drawImage(Second.getImage(), 550, 60, 80, 80, window);
           // g.drawImage(Three.getImage(), 1200, 60, 80, 80, window);
         

    }
    
}
