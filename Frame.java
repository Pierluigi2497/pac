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
	public void run(){
		for(;;){

		repaint();
		try{ Thread.sleep(40);} catch(Exception e) {}
		}
	}

	  public void paintComponent(Graphics g) {
	             g.setColor(Color.WHITE);
	                g.drawImage(Main.map,0,0,((Main.f.getWidth()/Map.x)*Map.x),((Main.f.getHeight()/Map.y)*Map.y),this);
	                g.drawImage(Main.pg.Pac,(Main.f.getWidth()/Map.x) * Main.pg.pathx,(Main.f.getHeight()/Map.y) * Main.pg.pathy,(Main.f.getWidth()/Map.x),(Main.f.getHeight()/Map.y),this);
	                if(!Main.gOver)
	               	 for(int i=0;i<4;i++)
	                	g.drawImage(Main.ne[i].n,(Main.f.getWidth()/Map.x) * Main.ne[i].pathx,(Main.f.getHeight()/Map.y) * Main.ne[i].pathy,(Main.f.getWidth()/Map.x),(Main.f.getHeight()/Map.y),this);
	                //Disegno Palline
	               	for(int i=0;i<Map.x;i++)
	               		for(int l=0;l<Map.y;l++)
	               			if(Map.maze[i][l]==2){
	               				g.drawOval((Main.f.getWidth()/Map.x) * i,(Main.f.getHeight()/Map.y) * l,5,5);
	               				g.fillOval((Main.f.getWidth()/Map.x) * i,(Main.f.getHeight()/Map.y) * l,5,5);}

	               	}



}