
package farmer;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Set;

/**
 *
 * @author 胡維仁
 */
public class GameOne extends BasicGame{
    public static int wi=0;
  
    protected char click[] = new char[11];
    protected boolean player = false;
    public GameOne(TAG tag){
        super(tag);
        System.out.println("GameOne");
        this.x = 30;
        this.y = 10;
        this.state = 1;
        for(int i = 0; i < click.length; i++){
            click[i] = 'q';
        }
    }
    public void logic(){
        
    }
    public void setClick(int index){
        if(index==9){
            for( int i = 0; i < click.length; i++){
                click[i] = 'q';
            }
            System.out.println("Clear");
        }
        else if(index==10){
         click[index] = 'W';
        }
        else if(click[index]=='q'){
            player = (player)?false:true;
            char mark = (player)?'X':'O';
            click[index] = mark;
        }
    }
    public void display(Graphics g){
        int check=0;
        //System.out.println("display click 9");
        g.setColor(Color.BLACK);
        g.fillRect(0,0,1000,800);
        g.setColor(Color.RED);
        g.drawString("HELP",x,y);
        //System.out.println("running");
          g.setColor(Color.YELLOW);
        g.fillRect(120,150,750,450);
         g.setColor(Color.GREEN);
        g.fillRect(250,150,150,150);
        g.fillRect(400,150,150,150);
         g.fillRect(550,150,150,150);
           g.fillRect(550,450,150,150);
         g.fillRect(755,555,100,30);
        
         //g.setColor(Color.GREEN);
        g.fillRect(250,300,150,150);
          g.fillRect(250,450,150,150);
            g.fillRect(400,300,150,150);
              g.fillRect(550,300,150,150);
                 g.fillRect(400,450,150,150);
                    //g.fillRect(550,450,150,150);
        
                    
          g.setColor(Color.BLUE);
       
         g.drawRect(250,150,150,150);
               Font fnt = new Font("Arial", 1, 80);
        g.setFont(fnt);
        if( click[0] =='O'){
            g.drawString("O", 290, 250);
        }
        else if(click[0]=='X'){
            g.drawString("X", 290, 250);
        }
                  if( click[1] =='O'){
            g.drawString("O", 440, 250);
        }
        else if(click[1]=='X'){
            g.drawString("X", 440, 250);
        }
                  
        if( click[2] =='O'){
            g.drawString("O", 590, 250);
        }
        else if(click[2]=='X'){
            g.drawString("X", 590, 250);
        }
        if( click[3] =='O'){
            g.drawString("O", 290, 400);
        }
        else if(click[3]=='X'){
            g.drawString("X", 290, 400);
        }
        
           if( click[4] =='O'){
            g.drawString("O", 440, 400);
        }
        else if(click[4]=='X'){
            g.drawString("X", 440, 400);
        }
              if( click[5] =='O'){
            g.drawString("O", 590, 400);
        }
        else if(click[5]=='X'){
            g.drawString("X", 590, 400);
        }
              
            if( click[6] =='O'){
            g.drawString("O", 290, 550);
        }
        else if(click[6]=='X'){
            g.drawString("X", 290, 550);
        }
          if( click[7] =='O'){
            g.drawString("O", 440, 550);
        }
        else if(click[7]=='X'){
            g.drawString("X", 440, 550);
        }
            if( click[8] =='O'){
            g.drawString("O", 590, 550);
        }
        else if(click[8]=='X'){
            g.drawString("X", 590, 550);
        }
      
      
            if(click[0]==click[1]&&click[1]==click[2]&&click[0]=='X'||click[0]==click[1]&&click[1]==click[2]&&click[0]=='O'){
              win(g);
            }
            else if(click[3]==click[4]&&click[4]==click[5]&&click[3]=='X'||click[3]==click[4]&&click[4]==click[5]&&click[3]=='O'){
            win(g);
            }
            else if(click[6]==click[7]&&click[7]==click[8]&&click[6]=='X'||click[6]==click[7]&&click[7]==click[8]&&click[6]=='O'){
            win(g);
            }
            else if(click[0]==click[3]&&click[3]==click[6]&&click[0]=='X'||click[0]==click[3]&&click[3]==click[6]&&click[0]=='O'){
            win(g);
            }
            else if(click[1]==click[4]&&click[4]==click[7]&&click[1]=='X'||click[1]==click[4]&&click[4]==click[7]&&click[1]=='O'){
            win(g);
            }
             else if(click[2]==click[5]&&click[5]==click[8]&&click[2]=='X'||click[2]==click[5]&&click[5]==click[8]&&click[2]=='O'){
            win(g);
            }
             else if(click[0]==click[4]&&click[4]==click[8]&&click[0]=='X'||click[0]==click[4]&&click[4]==click[8]&&click[0]=='O'){
            win(g);
            }
             else if(click[2]==click[4]&&click[4]==click[6]&&click[2]=='X'||click[2]==click[4]&&click[4]==click[6]&&click[2]=='O'){
            win(g);
            }
             else{
               for(int i=0;i<9;i++){
       if( click[i]!='q'){
       check++;
       }
        }
        if(check==9){
        notwin(g);
        }
             }
        
        
            g.drawRect(400,150,150,150);
         g.drawRect(550,150,150,150);
        
         //g.setColor(Color.GREEN);
        g.drawRect(250,300,150,150);
     
          g.drawRect(250,450,150,150);
            g.drawRect(400,300,150,150);
              g.drawRect(550,300,150,150);
                 g.drawRect(400,450,150,150);
                    g.drawRect(550,450,150,150);
                    
                      g.setColor(Color.WHITE);
                       g.fillRect(740,170,100,30);
                          g.setColor(Color.BLUE);
                            g.drawRect(740,170,100,30);
                             Font fnt1 = new Font("Arial", 1, 20);
                              g.setFont(fnt1);
                             g.drawString("Begin",755,190);
                             
            
    }
    public void notwin(Graphics g){
     Font fnt1 = new Font(null, 1, 170);
        g.setColor(Color.RED);
        g.setFont(fnt1);
        g.drawString("平",250,300);
        g.drawString("手",550,300);
        if( click[10] == 'W'){
          farmer.setPage(PAGE.Game1);//Game2
        }
 
         
    
    }
    public void win(Graphics g) {
    /*
        for(int i = 0; i < click.length; i++){
            click[i] = 'q';
        }
*/
        Font fnt1 = new Font(null, 1, 170);
        g.setColor(Color.RED);
        g.setFont(fnt1);
        g.drawString("恭",250,300);
        g.drawString("喜",550,300);
        this.setWin(true);
        wi=1;
        //Thread.sleep(5000);
        Font fnt2 = new Font(null, 1, 20);
         g.setColor(Color.RED);
        g.setFont(fnt2);
           g.drawString("next>>",780,580);
           if(click[10]=='W'){
               System.out.println("123");
        farmer.setPage(PAGE.move);//Game2
           }
    }
}
