package mainPack;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MenuBar extends JPanel {
	private static final long serialVersionUID = 1L;
	
	Image image;
	
	JButton homeButton;
	JLabel homeLabel;
	HomeButtonListener homeButtonListener;
	
	public MenuBar() {
		this.setPreferredSize(new Dimension(100, 40));
		this.setBackground(Color.black);
		this.setLayout(null);
		image = new ImageIcon("images/MenuBar.jpg").getImage();
	}
	
	public void prepareComponents() {
		homeButton = new JButton();
		homeButton.setBounds(5, 5, 80, 30);
		homeButton.setText("HOME");
		homeButton.setForeground(Color.darkGray);
		homeButton.setFocusable(false);
		homeButtonListener = new HomeButtonListener();
		homeButton.addActionListener(homeButtonListener);
		
		homeLabel = new JLabel("← click this button or press 'H' to home");
		homeLabel.setFont(new Font("Serif", Font.ITALIC+Font.BOLD, 15));
		homeLabel.setForeground(Color.cyan);
		homeLabel.setBounds(100, 5, 250, 30);
		
		this.add(homeButton);
		this.add(homeLabel);
	}
	
	private class HomeButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Main.mainWindow.setFrontScreenAndFocus(ScreenMode.TITLE);
		}
	}
	
}
