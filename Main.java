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
	  static BufferedImage Scritte;
	  static int dots=0;
	  static int Eat=0;
	  static int dX;
	  static int dY;
	  static Pulse pulse;
	  static Thread pul; 
	  static BufferedImage[] s=new BufferedImage[10];
	  static BufferedImage[] sf=new BufferedImage[4];
	  static int score;


	  public static void main(String[] args) {
	  	

	  	
	  	try{img=ImageIO.read(Main.class.getResource("/res/sheet.png"));
	  		map=ImageIO.read(Main.class.getResource("/res/map.png"));
	  		Scritte=ImageIO.read(Main.class.getResource("/res/scritte.png"));}catch(Exception e){}
	  	 s[0]=Scritte.getSubimage(0,0,11,10);
	  	 s[1]=Scritte.getSubimage(13,0,9,10);
	  	 s[2]=Scritte.getSubimage(24,0,11,10);
	  	 s[3]=Scritte.getSubimage(36,0,11,10);
	  	 s[4]=Scritte.getSubimage(48,0,11,10);
	  	 s[5]=Scritte.getSubimage(60,0,11,10);
	  	 s[6]=Scritte.getSubimage(72,0,11,10);
	  	 s[7]=Scritte.getSubimage(84,0,11,10);
	  	 s[8]=Scritte.getSubimage(96,0,11,10);
	  	 s[9]=Scritte.getSubimage(108,0,11,10);

	  	 pg=new Pg(6,9);
	  	 ne[0]=new Ne(12,14,"red");
	 	 ne[1]=new Ne(13,14,"pink");
	 	 ne[2]=new Ne(14,14,"blue");
	 	 ne[3]=new Ne(15,14,"yellow");
	 	 n[0]=new Thread(ne[0]);
	 	 n[1]=new Thread(ne[1]);
	 	 n[2]=new Thread(ne[2]);
	 	 n[3]=new Thread(ne[3]);
	 	 pulse=new Pulse();
	 	 pul=new Thread(pulse);
	 	 p=new Thread(pg);
		  f.f.setVisible(true);
		  f.f.setSize(616,713);
		  dX=(f.f.getWidth()/Map.x);
		  dY=(f.f.getHeight()/Map.y);
		  f.f.add(f);
		  f.f.setBackground(Color.BLACK);	  
		  f.f.addKeyListener(new KeyAdapter() {
				public void keyTyped(KeyEvent e) {
					cdir=e.getKeyChar();
				}
			});
		  disegno.start();
		  try{Thread.sleep(300);}catch(Exception e){}//Inserire 3000
		  
		  p.start();
		  n[0].start();
		  n[1].start();
		  n[2].start();
		  n[3].start();
		  pul.start();
	  }
	   
}