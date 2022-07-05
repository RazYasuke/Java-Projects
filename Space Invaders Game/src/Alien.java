/*
 Alien
 Gianni Lake
 GEEN 165 002
 22/11/15
 Creates and adds propeties to the alien images imported and adds value to different alien types/image 

 */
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class Alien extends Invader{
	
	private int  alienType;
	
	private static BufferedImage image1, image2, image3;
	
	static{
		try {//import image
		image1 = ImageIO.read(new File("alien1.png"));
		image2 = ImageIO.read(new File("alien2.png"));
		image3 = ImageIO.read(new File("alien3.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public Alien(int alienType) {//alien point value
		setVisible(true);
		this.alienType = alienType;
		if(alienType == 1)
			setPointValue(10);
		else if(alienType == 2)
			setPointValue(20);
		else
			setPointValue(40);
	}
	

	public int getAlienType() {
		return alienType;
	}



	public void setAlienType(int alienType) {
		this.alienType = alienType;
	}



	public void draw(Graphics g) { //set image to alien type
	if(alienType == 1)
		g.drawImage(image1, getLocation().x, getLocation().y, null);
	else if(alienType == 2)
		g.drawImage(image2, getLocation().x, getLocation().y, null);
	else
		g.drawImage(image3, getLocation().x, getLocation().y, null);
		
	}
	
	public Rectangle getCollisionRectangle(){
		return new Rectangle(new Point(getLocation().x, getLocation().y), new Dimension(32, 32));
	}
	
}
