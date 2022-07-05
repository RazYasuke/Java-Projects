/*
 Space Ship
 Gianni Lake
 GEEN 165 002
 22/11/15
 Creates spaceship that is the highest score of an invader that moves behind of squadron. 

 */
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.Timer;

public class SpaceShip extends Invader {
//public enum Direction {
//	NORTH,SOUTH,EAST,WEST
//}	
    private Timer moveTimer;
        
	private Timer launchTimer;
	private GamePanel gamePanel;
	private Random rand;

	public final static int WIDTH = 32;
	public final static int HEIGHT = 16;

	public SpaceShip(GamePanel gamePanel) {
		setColor(Color.BLUE);
		this.gamePanel = gamePanel;
		rand = new Random();
		setSpeed(15);
		startLaunchTimer();
		
	}

	public void startMoveTimer() {
		
		
		
		moveTimer = new Timer(100, new ActionListener() {

			public void actionPerformed(ActionEvent e) { //movement

				
				if(getDirection() == Direction.EAST){
					if (getLocation().x + WIDTH >= gamePanel.getWidth()) {
						SpaceShip.this.setVisible(false);
						stopMoveTimer();
					} else {
						SpaceShip.this.getLocation().x += getSpeed();
						gamePanel.repaint();
					}
				}
				else{
					if (getLocation().x < 0) {
						SpaceShip.this.setVisible(false);
						stopMoveTimer();
					} else {
						SpaceShip.this.getLocation().x -= getSpeed();
						gamePanel.repaint();
					}
				}
				

			}
		});
		
		moveTimer.start();

	}

	public void stopMoveTimer() {

		moveTimer.stop();
	}

	public void startLaunchTimer() {
		
		
		
		int delay = (5 + rand.nextInt(20))*1000;
		launchTimer = new Timer(delay, new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				int points = 1 + rand.nextInt(6);
				setPointValue(points*50);
				
				int direction = rand.nextInt(2);
				
				
			
				
				if(direction==0)//back and forth movement
				SpaceShip.this.setDirection(Direction.EAST);
				else
				SpaceShip.this.setDirection(Direction.WEST);
				
				if(getDirection() == Direction.EAST)
				setLocation(new Point(0, HEIGHT));
				else
				setLocation(new Point(gamePanel.getWidth(), HEIGHT));
				
				
				setVisible(true);
				startMoveTimer();
			}
		});

		launchTimer.start();
	}

	public void stopLaunchTimer() {
		launchTimer.stop();
	}

	public void draw(Graphics g) {//draw ship
		g.setColor(getColor());
		g.fillOval(getLocation().x, getLocation().y, WIDTH, HEIGHT);

	}

	public String toString() {
		return "SpaceShip [moveTimer=" + moveTimer + ", launchTimer="
				+ launchTimer + ", rand=" + rand + "]";
	}
	
	public Rectangle getCollisionRectangle(){
		return new Rectangle(new Point(getLocation().x, getLocation().y - HEIGHT/2), new Dimension(WIDTH, HEIGHT));
	}
//public enum Direction {
//	NORTH,SOUTH,EAST,WEST
//}
}
