import java.awt.Image;
import java.io.File;

import javax.swing.ImageIcon;

public class LPRImage {

	private File picturePath;
	private ImageIcon picture;
	private Image scalepicture;
	private int picturePrortion;
	
	public LPRImage (File picturepath){
		
		this.picturePath = picturepath;
		this.picture = new ImageIcon(picturePath.getAbsolutePath());
		this.picturePrortion = (picture.getIconWidth()/picture.getIconHeight());
	}
	
	public ImageIcon ScaleImage (int panelWidth, int panelHeight) {
		
		this.picturePrortion = picture.getIconWidth()/picture.getIconHeight();		
		this.scalepicture = this.picture.getImage().getScaledInstance(panelWidth*this.picturePrortion,panelHeight, Image.SCALE_DEFAULT);
		return (new ImageIcon(this.scalepicture));
	}
}
	
	
