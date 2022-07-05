/*
 Invader
 Gianni Lake
 GEEN 165 002
 22/11/15
 Abstract class that extends Game Object that is retains properties of aliens, squadron and spaceship 

 */
import java.util.Random;


public abstract class Invader  extends GameObject{
	private int pointValue;
	private int speed;
	private Direction direction;
	private int height;
	private int width;
	private Random rand;
	
	public Invader(){
		
	}

	public int getPointValue() {
		return pointValue;
	}

	public int getSpeed() {
		return speed;
	}

	public Direction getDirection() {
		return direction;
	}

	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}

	public Random getRand() {
		return rand;
	}

	public void setPointValue(int pointValue) {
		this.pointValue = pointValue;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public void setRand(Random rand) {
		this.rand = rand;
	}

	public String toString() {
		return "Invader [pointValue=" + pointValue + ", speed=" + speed
				+ ", direction=" + direction + ", height=" + height
				+ ", width=" + width + "]";
	}
	
	
}
