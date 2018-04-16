import java.awt.Image;
import java.io.File;

import javax.swing.ImageIcon;

public class oneLPRImage {

	private File picturePath;
	ImageIcon picture;
	Image scalepicture;
	int picturePrortion;
	int height;
	
	public oneLPRImage (File picturepath){
		
		this.picturePath = picturepath;
		this.picture = new ImageIcon(picturePath.getAbsolutePath());
		this.picturePrortion = (picture.getIconWidth()/picture.getIconHeight());
		this.height = picture.getIconHeight();;
	}
	
	public ImageIcon ScaleImage (int panelHeight) {
		
		this.height = panelHeight;		
		this.scalepicture = this.picture.getImage().getScaledInstance(panelHeight*this.picturePrortion,panelHeight, Image.SCALE_DEFAULT);
		return (new ImageIcon(this.scalepicture));
	}
	public int getHeight() {
		return this.height;
	}
}
	
	
