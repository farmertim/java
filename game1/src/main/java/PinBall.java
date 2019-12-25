
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;
import javax.swing.JOptionPane;
 
import javax.swing.Timer;
 
public class PinBall {
 
	/**
	 * @param args
	 */
	//桌面长宽
	private final int TABLE_WIDTH = 300;
	private final int TABLE_HEIGHT = 400;
	//球拍的垂直位置
	private final int RACKET_Y = 340;
	//球拍的高度和宽度
	private final int RACKET_HEIGHT = 20;
	private final int RACKET_WIDTH = 60;
	//球大小
	private final int BALL_SIZE = 16;
	private Frame f = new Frame("PinBall");
	Random rand = new Random();
	//小球纵向的运行速度
	private int ySpeed = 20; 
	private double xyRate = rand.nextDouble() - 0.5;
	private int xSpeed = (int)(ySpeed*xyRate*2);
	private int ballX = rand.nextInt(200) + 20;
	private int ballY = rand.nextInt(10) + 20;
	private int racketX = rand.nextInt(200);
	private String shape = "";
	Timer timer;
	private boolean isLose = false;
	private MyCanvas tableArea = new MyCanvas();
	
	public void init()
	{
		tableArea.setPreferredSize(new Dimension(TABLE_WIDTH, TABLE_HEIGHT));
		f.add(tableArea);
		KeyAdapter keyProcessor = new KeyAdapter() {
			public void keyPressed(KeyEvent ke)
			{
				if( ke.getKeyCode() == KeyEvent.VK_LEFT )
				{
					if( racketX > 0 )
						racketX -= 10;
				}
				if( ke.getKeyCode() == KeyEvent.VK_RIGHT )
				{
					if( racketX < TABLE_WIDTH - RACKET_WIDTH )
						racketX += 10;
				}
			}
		};
		f.addKeyListener(keyProcessor);
		tableArea.addKeyListener(keyProcessor);
		
		ActionListener taskPerformer = new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if( ballX <= 0 || ballX >= TABLE_WIDTH-BALL_SIZE )
				{
					xSpeed = -xSpeed;
				}
				if( ballY>= RACKET_Y - BALL_SIZE &&
						(ballX < racketX || ballX > racketX + RACKET_WIDTH))
				{
					timer.stop();
					isLose = true;
					tableArea.repaint();
				}
				else if( ballY <= 0 || 
						(ballY >= RACKET_Y - BALL_SIZE
						&& ballX > racketX && ballX <= racketX + RACKET_WIDTH) )
				{
					ySpeed = -ySpeed;
				}
				ballY += ySpeed;
				ballX += xSpeed;
				tableArea.repaint();
			}
		};
		
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});
		timer = new Timer(100, taskPerformer);
		timer.start();
		f.pack();
		f.setVisible(true);
				
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new PinBall().init();
                
                 JOptionPane.showMessageDialog(null, "繼續遊戲", "恭喜獲勝",JOptionPane.WARNING_MESSAGE);
                move o=new move();
	}
	
	class MyCanvas extends Canvas
	{
		public void paint(Graphics g)
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
