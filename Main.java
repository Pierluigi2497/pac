import javax.swing.JFrame;
import javax.swing.JComponent;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.*;

public class Main{
	  static Frame f=new Frame();
	  static Ne ne=new Ne(3,3);
	  static Pg pg=new Pg(6,9);  
	  static Thread disegno=new Thread(f);
	  static Thread n=new Thread(ne);
	  static Thread p=new Thread(pg);
	  static char cdir;


	  public static void main(String[] args) {
	  	 
		  f.f.setVisible(true);
		  f.f.setSize(640,740);
		  f.f.add(f);
		  p.start();
		  f.f.addKeyListener(new KeyAdapter() {
				public void keyTyped(KeyEvent e) {
					cdir=e.getKeyChar();
				}
			});
		  n.start();
		  disegno.start();
		  
	  }

	  


	   
}