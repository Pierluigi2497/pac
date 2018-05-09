import javax.swing.JFrame;
import javax.swing.JComponent;
import javax.swing.JPanel;

import java.awt.image.BufferedImage;
import java.net.URL;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.*;

public class Frame extends JPanel implements Runnable {	

	
	
	static Map map=new Map();
	public JFrame f=new JFrame();
	private BufferedImage image;
	public void run(){
		for(;;){
			image=ImageIO.read(Pg.r);
		repaint();
		try{ Thread.sleep(40);} catch(Exception e) {}
		}
	}

	  public void paintComponent(Graphics g) {
	        for (int row = 0; row < map.maze.length; row++) /*row x */{
	            for (int col = 0; col < map.maze[0].length; col++)/*col y*/ {
	                Color color;
	                if(map.maze[row][col]==1)
	                	color=Color.BLUE;
	                else
	                	color=Color.BLACK;
	                if(row==Main.pg.pathx&&col==Main.pg.pathy) {
	                	color=Color.YELLOW;
	                }
	                for(int i=0;i<4;i++)
	                	if(row==Main.ne[i].pathx&&col==Main.ne[i].pathy) {
	                		color=Color.RED;
	               		 }
	                g.setColor(color);
	                g.fillRect((Main.f.getWidth()/Map.x) * row, (Main.f.getHeight()/Map.y) * (col), (Main.f.getWidth()/Map.x), (Main.f.getHeight()/Map.y));
	                g.setColor(color);
	                g.drawRect((Main.f.getWidth()/Map.x) * row, (Main.f.getHeight()/Map.y) * (col), (Main.f.getWidth()/Map.x), (Main.f.getHeight()/Map.y));
	                if(color==Color.YELLOW)
	                	g.drawImage(image,1,1,this);
	            }
	        }
	  }  


	  

	 }
