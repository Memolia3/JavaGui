package mainPack;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.Timer;

public abstract class GenshinCharacter extends JLabel{
	private static final long serialVersionUID = 1L;
	Image image;
	Timer timer = null;

	int x;
	int y;
	int xVelocity;
	int yVelocity;
	
	public GenshinCharacter() {
		x = new java.util.Random().nextInt(680);
		y = new java.util.Random().nextInt(300);
		do {
			xVelocity = -5 + new java.util.Random().nextInt(10);
			yVelocity = -5 + new java.util.Random().nextInt(10);
		}while(xVelocity == 0 || yVelocity == 0);
		this.prepareImage();
		this.setBounds(x, y, image.getWidth(null), image.getHeight(null));
	}
	
	protected abstract void prepareImage();
	
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2D = (Graphics2D)g;
		if(xVelocity >= 0) {
			g2D.drawImage(image, 0, 0, image.getWidth(null), image.getHeight(null), null);
		} else {
			g2D.drawImage(image, image.getWidth(null), 0, -image.getWidth(null), image.getHeight(null), null);
		}
	}
}
