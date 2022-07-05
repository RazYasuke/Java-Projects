/*
 Game Object
 Gianni Lake
 GEEN 165 002
 22/11/15
 Abstract class for all drawings eg: Aliens spaceship canon 

 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;





public abstract class GameObject {
	private boolean visible;
	private Point location;
	private Color color;
	
	public GameObject() {
	
	}

	public GameObject(boolean visible, Point location, Color color) {
		this.visible = visible;
		this.location = location;
		this.color = color;
	}

	public boolean isVisible() {
		return visible;
	}

	public Point getLocation() {
		return location;
	}

	public Color getColor() {
		return color;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public void setLocation(Point location) {
		this.location = location;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	public abstract void draw(Graphics g);
	
	public String toString() {
		return super.toString();
	}
	
	
}
