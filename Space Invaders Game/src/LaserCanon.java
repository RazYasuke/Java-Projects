/*
 Lasor Cannon
 Gianni Lake
 GEEN 165 002
 22/11/15
 Creates lasor cannon drawing and repaints it creating movement 

 */
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;




public class LaserCanon extends GameObject{
	
	private int pnlWidth;
	private int pnlHeight;
	private int moveInc;
	
	public final static int WIDTH = 32;
	public final static int HEIGHT = 32;
	
	public LaserCanon(int pnlWidth, int pnlHeight) {
		super(true, new Point((pnlWidth - WIDTH)/2, pnlHeight - HEIGHT),Color.RED);
		this.pnlWidth = pnlWidth;
		this.pnlHeight = pnlHeight;
		moveInc = 5;
	}



	public void draw(Graphics g) { //draws cannon
		g.setColor(getColor());
		g.fillRect(getLocation().x, getLocation().y , WIDTH, HEIGHT);
		g.setColor(Color.YELLOW);
		g.fillRect(getLocation().x + (WIDTH - WIDTH/4)/2, getLocation().y - HEIGHT/4, WIDTH/4, HEIGHT/4);
	}
	
	public void moveLeft(){ //left movement
		getLocation().x -= moveInc;
		if(getLocation().x< 0)
			getLocation().x = 0;
	}
	
	public void moveRight(){ //right movement
		getLocation().x +=moveInc;
		if(getLocation().x + WIDTH > pnlWidth)
			getLocation().x = pnlWidth - WIDTH;
	}
	
	
	
}
