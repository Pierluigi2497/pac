import javax.swing.JFrame;
import javax.swing.JComponent;
import javax.swing.JPanel;

import java.awt.image.BufferedImage;
import javax.imageio.*;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.*;

public class Frame extends JPanel implements Runnable {	

	
	
	static Map map=new Map();
	public JFrame f=new JFrame();
	private BufferedImage image;
	private BufferedImage dot;
	private BufferedImage Dot;
	private int dX;
	private int dY;
	public void run(){
		dot=Main.img.getSubimage(137,33,12,12);
		Dot=Main.img.getSubimage(154,33,12,12);
		for(;;){
		upD();
		Main.dots=0;
		repaint();
		try{ Thread.sleep(40);} catch(Exception e) {}
		}
	}

	  public void paintComponent(Graphics g) {
	  	

	                g.drawImage(Main.map,0,0,dX*Map.x,dY*Map.y,null);
	               
	                
	                //Disegno Palline
	             for(int i=0;i<Map.x;i++)
	               		for(int l=0;l<Map.y;l++)
	               			if(Map.maze[i][l]==3){
	               				Main.dots++;
	               				g.drawImage(dot,dX*i,dY*l,dX,dY,null);}
	               			else if(Map.maze[i][l]==4){
	               				Main.dots++;
	               				g.drawImage(Dot,dX*i,dY*l,dX,dY,null);
	               			}


	               	if(!Main.gOver)
	               	 for(int i=0;i<4;i++)
	                	g.drawImage(Main.ne[i].n,dX * Main.ne[i].pathx,dY * Main.ne[i].pathy,dX,dY,null);
	                 g.drawImage(Main.pg.Pac,dX * Main.pg.pathx,dY * Main.pg.pathy,dX,dY,null);
	               
	               		


	               	}

	public void upD(){
		dX=(Main.f.getWidth()/Map.x);

		dY=(Main.f.getHeight()/Map.y);


	}



}