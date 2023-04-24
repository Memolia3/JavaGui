package mainPack;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class CharacterFishing extends JLabel {
	private static final long serialVersionUID = 1L;
	
	ImageIcon image;
	
	CharacterFishing(){
		image = new ImageIcon("images/PaimonFishing.png");
		this.setSize(150, 150);
		this.setIcon(image);
		this.setText("pass me!!");
		this.setForeground(Color.pink);
		this.setHorizontalTextPosition(CENTER);
		this.setVerticalTextPosition(TOP);
	}
}
