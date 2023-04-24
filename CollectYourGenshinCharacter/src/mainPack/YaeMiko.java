package mainPack;

import javax.swing.ImageIcon;

public class YaeMiko extends GenshinCharacter{
	private static final long serialVersionUID = 1L;
	
	public void prepareImage() {
		super.image = new ImageIcon("images/YaeMiko.png").getImage();
	}
}
