import java.awt.Image;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class oneLPRImage {

	private File picturePath;
	ImageIcon picture;
	Image scalepicture;
	float picturePrortion;
	int height;
	int width;
	
	public oneLPRImage()
	{
		this.picturePath = new File("");
		this.picture = null;
		this.height = 1;
		this.width = 1;
		this.picturePrortion = 1;
		
	}
	
	public oneLPRImage (File picturepath){
		
		this.picturePath = picturepath;
		this.picture = new ImageIcon(picturePath.getAbsolutePath());
		
		if (picture.getIconHeight() > picture.getIconWidth())
		{
			this.picturePrortion = ((float)picture.getIconHeight()/(float)picture.getIconWidth());
		}
		else
			this.picturePrortion = ((float)picture.getIconWidth()/(float)picture.getIconHeight());
		this.height = picture.getIconHeight();
		this.width = picture.getIconWidth();
		
		//JOptionPane.showMessageDialog(null, "picture height: "+ this.height +"; picture width: "+ this.width +"; picture propotion: "+ this.picturePrortion);
	}
	
	public ImageIcon ScaleImage (int panelHeight) {
		
		this.height = panelHeight;		
		this.scalepicture = this.picture.getImage().getScaledInstance((int) (panelHeight*this.picturePrortion),panelHeight, Image.SCALE_DEFAULT);
		
		return (new ImageIcon(this.scalepicture));
	}
	public int getHeight() {
		return this.height;
	}
}
	
	
