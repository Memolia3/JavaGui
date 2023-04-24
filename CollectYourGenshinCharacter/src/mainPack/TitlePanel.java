package mainPack;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class TitlePanel extends JPanel{
	private static final long serialVersionUID = 1L;
	
	Image image;
	
	JLabel title;
	JLabel name;
	JLabel start;
	JLabel exit;
	JLabel select;
	JLabel message;
	
	Menu checkMenu = Menu.START;
	Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
	MyKeyListener myKeyListener;
	
	public enum Menu {
		START,
		EXIT,
	}
	
	TitlePanel(){
		this.setLayout(null);
		this.setBackground(Color.red);
		this.setOpaque(false);
		ImageIcon icon = new ImageIcon("images/loginScreen.png");
		image = icon.getImage();
	}
	
	@Override
	  protected void paintComponent(Graphics g) {
	    super.paintComponent(g);
	        g.drawImage(image, 0, 0, null);
	}
	
	public void prepareComponents() {
		name = new JLabel();
		name.setText("Created by Memolia");
		name.setForeground(Color.black);
		name.setHorizontalTextPosition(JLabel.LEFT);
		name.setVerticalTextPosition(SwingConstants.TOP);
		name.setBounds(0, 540, 300, 30);
		
		start = new JLabel();
		start.setText("START");
		start.setForeground(Color.pink);
		start.setFont(new Font("Serif" , Font.ITALIC+Font.BOLD, 40));
		start.setHorizontalTextPosition(JLabel.CENTER);
		start.setVerticalTextPosition(JLabel.BOTTOM);
		start.setBounds(330, 400, 150, 40);
		
		exit = new JLabel();
		exit.setText("EXIT");
		exit.setForeground(Color.cyan);
		exit.setFont(new Font("Serif" , Font.ITALIC+Font.BOLD, 40));
		exit.setHorizontalTextPosition(JLabel.CENTER);
		exit.setVerticalTextPosition(JLabel.BOTTOM);
		exit.setBounds(350, 450, 110, 40);
		
		select = new JLabel();
		ImageIcon icon = new ImageIcon("images/editedHutaoGhost2.png");
		select.setIcon(icon);
		select.setOpaque(false);
		select.setBounds(280, 400, 40, 40);
		
		message = new JLabel();
		message.setHorizontalAlignment(SwingConstants.CENTER);
		message.setText("select : ↑　↓  decision : SPACE");
		message.setForeground(Color.white);
		message.setVerticalTextPosition(JLabel.CENTER);
		message.setHorizontalTextPosition(JLabel.CENTER);
		message.setBounds(249, 517, 300, 30);
		
		this.setLayout(null);
		this.add(name);
		this.add(start);
		this.add(exit);
		this.add(select);
		this.add(message);
		
		myKeyListener = new MyKeyListener(this);
		
	}
	
	private class MyKeyListener extends ListenerAdapter {
		TitlePanel panel;
		
		MyKeyListener(TitlePanel p){
			super();
			panel = p;
			panel.addKeyListener(this);
		}
		
		@Override
		public void keyPressed(KeyEvent e) {
			switch(e.getKeyCode()) {
			case KeyEvent.VK_DOWN:
				if(checkMenu == Menu.START) {
					select.setLocation(select.getX(), select.getY() + 50);
					checkMenu = Menu.EXIT;
				}
				break;
			case KeyEvent.VK_UP:
				if(checkMenu == Menu.EXIT) {
					select.setLocation(select.getX(), select.getY() - 50);
					checkMenu = Menu.START;
				}
				break;
			case KeyEvent.VK_SPACE:
				if(checkMenu == Menu.START) {
					Main.mainWindow.setFrontScreenAndFocus(ScreenMode.GAME);
				}else if(checkMenu == Menu.EXIT) {
					System.exit(0);
				}
				break;
			}
		}
		
	}
}
