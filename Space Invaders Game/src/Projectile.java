/*
 Projectile
 Gianni Lake
 GEEN 165 002
 22/11/15
 Creates, moves and adds collision properties to the projectile(drawing) that emits from the lasercannon  

 */
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;


public class Projectile extends GameObject {
	
	private int speed;
	
	private final static int WIDTH = 8;
	private final static int HEIGHT = 16;
	
	public Projectile() {
		this.speed = 30;
		setColor(Color.GREEN);
	}

	public int getSpeed() {
		return speed;
	}

	public void setLocation(Point location) { //starting point of projectile      
		int x = location.x + (LaserCanon.WIDTH - LaserCanon.WIDTH/4)/2;
		int y = location.y - LaserCanon.HEIGHT/4 - HEIGHT;
		super.setLocation(new Point(x, y));
	}
	
	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public void draw(Graphics g) {  //drawing for projectile 
		g.setColor(getColor());
		g.fillRect(getLocation().x, getLocation().y, WIDTH, HEIGHT);
	}

	public String toString() {
		return "Projectile [speed=" + speed + ", toString()="
				+ super.toString() + "]";
	}
	
	public void moveUp(){
		getLocation().y -= speed;
	}
	
	public Rectangle getCollisionRectangle(){
		return new Rectangle(getLocation(), new Dimension(WIDTH, HEIGHT));
	}
	
}
