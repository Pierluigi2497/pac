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



	public JFrame f=new JFrame();
	private BufferedImage image;
	private BufferedImage dot;
	static BufferedImage Dot;
	private int i;//Controllo per score
	private int l;//Controllo per invertire score

	public Frame(){
		f.setResizable(false);

	}

	public void run(){
		dot=Main.img.getSubimage(137,33,12,12);
		Dot=Main.img.getSubimage(154,31,12,12);
		for(;;){
		upD();
		Main.dots=0;
		repaint();
		try{ Thread.sleep(40);} catch(Exception e) {}
		}
	}

	  public void paintComponent(Graphics g) {
	  				super.paintComponent(g);
	  				this.setSize(616,713);
	  				f.setSize(622,742);
	                g.drawImage(Main.map,0,0,Main.dX*Map.x,Main.dY*Map.y,null);


	                //Disegno Palline
	             for(int i=0;i<Map.x;i++)
	               		for(int l=0;l<Map.y;l++)
	               			if(Map.maze[i][l]==2||Map.maze[i][l]==4){
	               				Main.dots++;
	               				g.drawImage(dot,Main.dX*i,Main.dY*l,Main.dX,Main.dY,null);}
	               			else if(Map.maze[i][l]==5){
	               				Main.dots++;
	               				g.drawImage(Dot,Main.dX*i,Main.dY*l,Main.dX,Main.dY,null);
	               			}


	               	if(!Main.gOver)
	               	 	for(int i=0;i<4;i++)
	                			g.drawImage(Main.ne[i].n,(Main.dX * Main.ne[i].pathx)+Main.ne[i].tX,(Main.dY * Main.ne[i].pathy)+Main.ne[i].tY,Main.dX,Main.dY,null);

	                 g.drawImage(Main.pg.Pac,(Main.dX * Main.pg.pathx)+Main.pg.tX,(Main.dY * Main.pg.pathy)+Main.pg.tY,Main.dX,Main.dY,null);


	                 for(i=3,l=0;i>=0;i--,l++){
	                 		g.drawImage(Main.sf[i],6+(l*11),255,11,10,null);
	                 }


	               	}




	public void upD(){
		Main.dX=(Main.f.getWidth()/Map.x);

		Main.dY=(Main.f.getHeight()/Map.y);


	}



}
