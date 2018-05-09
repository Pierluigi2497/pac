import javax.swing.JFrame;
import javax.swing.JComponent;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.*;

public class Main{
	  static Frame f=new Frame();
	  static Ne[] ne=new Ne[4];

	  static Pg pg=new Pg(6,9);  
	  static Thread disegno=new Thread(f);
	  static Thread[] n=new Thread[4];
	  static Thread p=new Thread(pg);
	  static char cdir;


	  public static void main(String[] args) {
	  	 ne[0]=new Ne(11,14);
	 	 ne[1]=new Ne(12,14);
	 	 ne[2]=new Ne(15,14);
	 	 ne[3]=new Ne(16,14);
	 	 n[0]=new Thread(ne[0]);
	 	 n[1]=new Thread(ne[1]);
	 	 n[2]=new Thread(ne[2]);
	 	 n[3]=new Thread(ne[3]);
		  f.f.setVisible(true);
		  f.f.setSize(640,740);
		  f.f.add(f);
		  f.f.setBackground(Color.BLACK);
		  p.start();
		  f.f.addKeyListener(new KeyAdapter() {
				public void keyTyped(KeyEvent e) {
					cdir=e.getKeyChar();
				}
			});
		  n[0].start();
		  n[1].start();
		  n[2].start();
		  n[3].start();
		  disegno.start();
		  
	  }


	  

	  


	   
}