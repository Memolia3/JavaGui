package mainPack;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CompletePanel extends JPanel {
	public static final long serialVersionUID = 1L;
	
	Image image;
	
	JLabel exit;
	JLabel text;
	
	MyKeyListener myKeyListener;
	
	CompletePanel(){
		this.setLayout(null);
		this.setOpaque(false);
		ImageIcon icon = new ImageIcon("images/CompleteWallPaper.png");
		image = icon.getImage();
	}
	
	@Override
	  protected void paintComponent(Graphics g) {
	    super.paintComponent(g);
	        g.drawImage(image, 0, 0, null);
	}
	
	public void prepareComponents() {
		text = new JLabel();
		text.setText("press SPACE!");
		text.setForeground(Color.pink);
		text.setFont(new Font("Serif" , Font.ITALIC+Font.BOLD, 40));
		text.setHorizontalTextPosition(JLabel.CENTER);
		text.setVerticalTextPosition(JLabel.BOTTOM);
		text.setBounds(280, 400, 300, 30);
		
		exit = new JLabel();
		exit.setText("EXIT");
		exit.setForeground(Color.yellow);
		exit.setFont(new Font("Serif" , Font.ITALIC+Font.BOLD, 40));
		exit.setHorizontalTextPosition(JLabel.CENTER);
		exit.setVerticalTextPosition(JLabel.BOTTOM);
		exit.setBounds(350, 450, 110, 40);
		
		this.add(text);
		this.add(exit);
		
		myKeyListener = new MyKeyListener(this);
	}
	
	private class MyKeyListener extends ListenerAdapter {
		CompletePanel panel;
		
		MyKeyListener(CompletePanel p){
			super();
			panel = p;
			panel.addKeyListener(this);
		}
		
		@Override
		public void keyPressed(KeyEvent e) {
			switch(e.getKeyCode()) {
			case KeyEvent.VK_SPACE:
				System.exit(0);
			}
		}
	}
}
