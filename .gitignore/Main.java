import javax.swing.JFrame;
import javax.swing.JComponent;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.*;

public class Main{
	  static Frame f=new Frame();

	  static Thread th=new Thread(f);

	  public static void main(String[] args) {
		  f.f.setVisible(true);
		  f.f.setSize(640,740);
		  f.f.addKeyListener(new KeyAdapter() {
				public void keyTyped(KeyEvent e) {
					f.Move(e.getKeyChar());
				}
			});
		  f.f.add(f);
		  th.start();
	  }
}