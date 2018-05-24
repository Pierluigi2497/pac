import javax.swing.JFrame;
import javax.swing.JComponent;
import java.awt.image.BufferedImage;
import javax.imageio.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.*;

public class Main{
	  static Frame f=new Frame();
	  static Ne[] ne=new Ne[4];
	  static BufferedImage img;
	  static Pg pg;  
	  static Thread disegno=new Thread(f);
	  static Thread[] n=new Thread[4];
	  static Thread p;
	  static char cdir;
	  static Boolean gOver =false;
	  static BufferedImage map;
	  static BufferedImage Game;
	  static int dots=0;
	  static Boolean Eat=false;


	  public static void main(String[] args) {


	  	try{img=ImageIO.read(Main.class.getResource("/res/sheet.png"));
	  		map=ImageIO.read(Main.class.getResource("/res/map.png"));}catch(Exception e){}

	  	 pg=new Pg(6,9);
	  	 ne[0]=new Ne(12,14,"red");
	 	 ne[1]=new Ne(13,14,"pink");
	 	 ne[2]=new Ne(14,14,"blue");
	 	 ne[3]=new Ne(15,14,"yellow");
	 	 n[0]=new Thread(ne[0]);
	 	 n[1]=new Thread(ne[1]);
	 	 n[2]=new Thread(ne[2]);
	 	 n[3]=new Thread(ne[3]);
	 	 p=new Thread(pg);
		  f.f.setVisible(true);
		  f.f.setSize(640,720);
		  f.f.add(f);
		  f.f.setBackground(Color.BLACK);	  
		  f.f.addKeyListener(new KeyAdapter() {
				public void keyTyped(KeyEvent e) {
					cdir=e.getKeyChar();
				}
			});
		
		  disegno.start();
		  p.start();
		  try{Thread.sleep(100);}catch(Exception e){}
		  n[0].start();
		//  n[1].start();
		 // n[2].start();
		  //n[3].start();
	  }
	   
}