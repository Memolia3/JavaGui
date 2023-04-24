package mainPack;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class FieldPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	
	Image image;
	
	JLayeredPane layeredPane;
	JLabel paimon;
	
	GenshinCharacter hutao;
	GenshinCharacter nahida;
	GenshinCharacter albedo;
	GenshinCharacter yaemiko;
	
	public FieldPanel() {
		this.setLayout(null);
		this.setOpaque(false);
		ImageIcon icon = new ImageIcon("images/enkanomiya.png");
		image = icon.getImage();
	}
	
	@Override
	  protected void paintComponent(Graphics g) {
	    super.paintComponent(g);
	        g.drawImage(image, 0, 0, null);
	}
	
	public void prepareComponents() {
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, MainWindow.WIDTH, MainWindow.HEIGHT);
		this.add(layeredPane);
		
		paimon = new CharacterFishing();
		paimon.setLocation(650, 0);
		this.layeredPane.add(paimon, JLayeredPane.DEFAULT_LAYER);
		
		hutao  = new Hutao();
		nahida = new Nahida();
		albedo = new Albedo();
		yaemiko = new YaeMiko();
		vitalizeGenshinCharacter(hutao);
		vitalizeGenshinCharacter(nahida);
		vitalizeGenshinCharacter(albedo);
		vitalizeGenshinCharacter(yaemiko);
	}
	
	public void vitalizeGenshinCharacter(GenshinCharacter gc) {
		new DDListener(gc);
		GenshinCharacterActionListener gcal = new GenshinCharacterActionListener(gc);
		gc.timer = new Timer(10, gcal);
		this.add(gc);
		gc.timer.start();
	}
	
	
	private class GenshinCharacterActionListener implements ActionListener {
		private GenshinCharacter gc;
		
		public GenshinCharacterActionListener(GenshinCharacter gc) {
			this.gc = gc;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(gc.x > Main.mainWindow.gamePanel.getWidth() - gc.getWidth() || gc.x < 0) {
				gc.xVelocity = gc.xVelocity * (-1);
			}
			gc.x = gc.x + gc.xVelocity;
			if(gc.y > Main.mainWindow.gamePanel.getHeight() - gc.getHeight() || gc.y < 0) {
				gc.yVelocity = gc.yVelocity * (-1);
			}
			gc.y = gc.y + gc.yVelocity;
			gc.setLocation(gc.x, gc.y);
			gc.repaint();
		}
	}
	
	private class DDListener extends MouseAdapter {
		private static int count;
		private int dx;
		private int dy;
		private GenshinCharacter gc;
		
		DDListener(GenshinCharacter gc){
			this.gc = gc;
			this.gc.addMouseListener(this);
			this.gc.addMouseMotionListener(this);
		}
		
		public void mousePressed(MouseEvent e) {
			gc.timer.stop();
			dx = e.getXOnScreen() - gc.getX();
			dy = e.getYOnScreen() - gc.getY();
		}
		
		public void mouseDragged(MouseEvent e) {
			int x = e.getXOnScreen() - dx;
			int y = e.getYOnScreen() - dy;
			if(x < Main.mainWindow.gamePanel.getWidth() - gc.getWidth() - 5 && x > 5) { gc.x = x; }
			if(y < Main.mainWindow.gamePanel.getHeight() - gc.getHeight() - 5 && y > 5) { gc.y = y; }
			gc.setLocation(gc.x, gc.y);
		}
		
		public void mouseReleased(MouseEvent e) {
			int x = e.getXOnScreen();
			int y = e.getYOnScreen();
			int px = (int)paimon.getLocationOnScreen().getX();
			int py = (int)paimon.getLocationOnScreen().getY();
			int ph = paimon.getHeight();
			int pw = paimon.getWidth();
			if((px < x) && (x < px + pw) && (py < y) && (y < py + ph)) {
				gc.setVisible(false);
				DDListener.count++;
				if(DDListener.count == 4) {
					Main.mainWindow.setFrontScreenAndFocus(ScreenMode.COMPLETE);
				}
			} else {
				gc.timer.start();
			}
		}
	}
}
