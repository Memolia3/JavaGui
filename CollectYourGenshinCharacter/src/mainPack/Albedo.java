package mainPack;

import javax.swing.ImageIcon;

public class Albedo extends GenshinCharacter{
	private static final long serialVersionUID = 1L;
	
	public void prepareImage() {
		super.image = new ImageIcon("images/Albedo.png").getImage();
	}
}
