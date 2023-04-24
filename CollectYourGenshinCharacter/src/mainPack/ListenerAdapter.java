package mainPack;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public abstract class ListenerAdapter implements KeyListener{
	@Override
	public void keyTyped(KeyEvent e) {
		//do nothing
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		//do nothing
	}
}
