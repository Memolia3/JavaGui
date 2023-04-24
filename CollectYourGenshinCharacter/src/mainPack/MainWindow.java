package mainPack;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class MainWindow extends JFrame{
	private static final long serialVersionUID = 1L;
	
	ScreenMode screenMode;
	
	static final int WIDTH = 800;
	static final int HEIGHT = 600;
	
	CardLayout layout = new CardLayout();
	
	TitlePanel titlePanel;
	GamePanel gamePanel;
	CompletePanel completePanel;

	
	MainWindow(){
		this.setTitle("Collect your genshin character");
		ImageIcon icon = new ImageIcon("images/HutaoIcon.jpg");
		this.setIconImage(icon.getImage());
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.getContentPane().setBackground(Color.green);
		this.setLayout(layout);
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		this.pack();
		this.setLocationRelativeTo(null);
	}
	
	public void preparePanels() {
		titlePanel = new TitlePanel();
		this.add(titlePanel, "titleScreen");
		gamePanel = new GamePanel();
		this.add(gamePanel, "gameScreen");
		completePanel = new CompletePanel();
		this.add(completePanel, "finishScreen");
		this.pack();
	}
	
	public void prepareComponents() {
		titlePanel.prepareComponents();
		gamePanel.prepareComponents();
		completePanel.prepareComponents();
	}
	
	public void setFrontScreenAndFocus(ScreenMode s) {
		screenMode = s;
		switch(screenMode) {
		case TITLE:
			layout.show(this.getContentPane(), "titleScreen");
			titlePanel.requestFocus();
			break;
		case GAME:
			layout.show(this.getContentPane(), "gameScreen");
			gamePanel.requestFocus();
			break;
		case COMPLETE:
			layout.show(this.getContentPane(), "finishScreen");
			completePanel.requestFocus();
			break;
		}
	}
}
