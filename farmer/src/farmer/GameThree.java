
package farmer;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.ImageIcon;

public class GameThree extends BasicGame{
    
    ImageIcon normal;
    ImageIcon clock;
    farmer window;
    
    public GameThree(farmer jonah, TAG tag) {
        super(tag);
        this.window=jonah;
        
        System.out.println("GameThree");
        this.x = 100;
        this.y = 100;
        this.state = 3;
       
    }
     public void logic(){
        
    }
    public void display(Graphics g){
        Color color = new Color(217, 209, 255);
        g.setColor(color);
        g.fillRect(0,0,1000,800);
        
        color = new Color(53, 237, 148);
        g.setColor(color);
        g.fillRect(120,150,750,350);
        
        g.setColor(Color.RED);
        Font font=new Font("Arial",1,50);
        g.setFont(font);
        g.drawString("Score:",650,650);
        
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(120, 230, 750, 100);
        
//        normal = new ImageIcon("Animation/nor.jpg");
//        clock=new ImageIcon("Animation/tap.jpg");
//        g.drawImage(normal.getImage(),120,230,30,30,window);
//    
    }
}
