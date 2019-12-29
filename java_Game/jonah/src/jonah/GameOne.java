
package jonah;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author 胡維仁
 */
public class GameOne extends BasicGame{
    public GameOne(){
        System.out.println("GameOne");
        this.x = 30;
        this.y = 10;
        this.state = 1;
        
    }
    public void logic(){
        
    }
    public void display(Graphics g){
        g.setColor(Color.GREEN);
        g.fillRect(0,0,1000,800);
        g.setColor(Color.RED);
        g.drawString("HELP",x,y);
        System.out.println("running");
    }
}
