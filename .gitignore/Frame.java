import javax.swing.JFrame;
import javax.swing.JComponent;
import javax.swing.JPanel;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.*;

public class Frame extends JPanel implements Runnable {	

	private Pg pg=new Pg(5,3);  
	private Ne ne=new Ne(3,3);
	private Map map=new Map();
	public JFrame f=new JFrame();

	public void run(){
		for(;;){
		repaint();
		try{ Thread.sleep(40);} catch(Exception e) {}
		}
	}

	  public void paintComponent(Graphics g) {
	  	
	        for (int row = 0; row < map.maze.length; row++) /*row x */{
	            for (int col = 0; col < map.maze[0].length; col++)/*col y*/ {
	                Color color;
	                if(map.maze[row][col])
	                	color=Color.BLACK;
	                else
	                	color=Color.WHITE;
	                if(row==pg.pathx&&col==pg.pathy) {
	                	color=Color.GREEN;
	                }
	                if(row==ne.pathx&&col==ne.pathy) {
	                	color=Color.RED;
	                }
	                g.setColor(color);
	                g.fillRect(30 * row, 30 * (col), 30, 30);
	                g.setColor(Color.BLACK);
	                g.drawRect(30 * row, 30 * (col), 30, 30);
	                System.out.println("X:  "+row+" Y:  "+col);
	            }
	        }
	  }  

	  public void Move(char b){
	  		switch(b) {
				case 's':pg.MoveDw(map.maze);/*ne.Follow(pg.pathx,pg.pathy);repaint();*/ break;
				case 'a':pg.MoveSx(map.maze);/*ne.Follow(pg.pathx,pg.pathy);repaint();*/ break;
				case 'd':pg.MoveDx(map.maze);/*ne.Follow(pg.pathx,pg.pathy);repaint();*/ break;
				case 'w':pg.MoveUp(map.maze);/*ne.Follow(pg.pathx,pg.pathy);repaint();*/ break;
				}
	  }

	 }
