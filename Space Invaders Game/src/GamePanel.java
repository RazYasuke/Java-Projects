/*
 Game Panel
 Gianni Lake
 GEEN 165 002
 22/11/15
 Creates panel that contains canon, and squadron. All game actions are put to use for example motion collisions 

 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.Timer;


public class GamePanel extends JPanel{
	
	public static final int PANEL_WIDTH = 512;
	public static final int PANEL_HEIGHT = 512; 
	public static final int PROJECTILE_SPEED = 40;
	
	
	
	private ArrayList<GameObject> gameObjects;
	
	private LaserCanon laserCanon ;
	private Timer projectileTimer;
	private Projectile projectile;
	private SpaceShip spaceShip;
	private Timer pointsTimer;
	private Squadron squadron;
	private Point collisionPoint;
	
	private StatusPanel statusPanel;
	
	public GamePanel(StatusPanel statusPanel) {
		this.statusPanel = statusPanel;
		
		setLayout(null);
		setBackground(Color.BLACK);
		setSize(PANEL_WIDTH, PANEL_HEIGHT);
		
		
		
		this.addKeyListener(new KeyListener() { 
			
		public void keyTyped(KeyEvent e) {}
			
		public void keyReleased(KeyEvent e) {}
			
		public void keyPressed(KeyEvent e) {
                    if(e.getKeyCode() == KeyEvent.VK_LEFT){//left arrow left movement
			laserCanon.moveLeft();
			repaint();
				}
				else if(e.getKeyCode() == KeyEvent.VK_RIGHT){//right arrow right movement
				
                                    laserCanon.moveRight();
				
                                repaint();
				}
				else if(e.getKeyCode() == KeyEvent.VK_SPACE ){//spacebar projectile shot
                                    if(projectileTimer ==null || !projectileTimer.isRunning()){
						
					projectile = new Projectile();
					gameObjects.add(projectile);
					projectile.setSpeed(PROJECTILE_SPEED);
					projectile.setLocation(laserCanon.getLocation());
					projectile.setVisible(true);
					projectileTimer = new Timer(100, new ActionListener() {
					public void actionPerformed(ActionEvent e) {
								
						projectile.moveUp();
						
                                                if(projectile.getLocation().y <=0){
						projectileTimer.stop();
							projectile.setVisible(false);
						
                                                }else if(checkSpaceShipProjectileColiision()){
							statusPanel.addPoints(spaceShip.getPointValue());
						projectileTimer.stop();
							projectile.setVisible(false);
						spaceShip.setVisible(false);
								}
						
                                                else if(checkAlienProjectileColisiion()){
						projectileTimer.stop();
							
                                                projectile.setVisible(false);
						if(squadron.getNumVisible() == 0){
                                                       int initialPoints = statusPanel.getPoints();
						newGame();
							statusPanel.addPoints(initialPoints);
									}
										
								}
									
								repaint();
							}
						});
				projectileTimer.setRepeats(true);
				projectileTimer.start();
						
					}
				}
                                
			}
		});
		
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		if(gameObjects!=null){
		for (GameObject gameObject : gameObjects) {
		if(gameObject!=null && gameObject.isVisible())
			
                    gameObject.draw(g);
			}
			
			
			
		if(collisionPoint!=null)
		g.drawString(spaceShip.getPointValue()+"", collisionPoint.x, collisionPoint.y);
		}
		

	}
	
	public void newGame(){//creates refreshed game screen
		laserCanon = new LaserCanon(PANEL_WIDTH, PANEL_HEIGHT);
		statusPanel.resetPoints();
		spaceShip = new SpaceShip(this);
		
		this.setFocusable(true);
		this.requestFocusInWindow();
		
		
		
		gameObjects = new ArrayList<GameObject>();
		gameObjects.add(laserCanon);
		gameObjects.add(spaceShip);
		gameObjects.add(projectile);
		
		
		squadron = new Squadron(this);
		gameObjects.add(squadron);
		repaint();
	}
	
	
	
	public boolean checkSpaceShipProjectileColiision(){
		if(spaceShip!=null && spaceShip.isVisible()){
			
			if(projectile.getCollisionRectangle().intersects(spaceShip.getCollisionRectangle())){
				
		collisionPoint = new Point(projectile.getLocation().x, projectile.getLocation().y);
		pointsTimer = new Timer(10, new ActionListener() {
					
		public void actionPerformed(ActionEvent e) {
			collisionPoint = null;
		
                        pointsTimer.stop();
					}
				});
		pointsTimer.setInitialDelay(1000);
				
		pointsTimer.start();
				
				return true;
				  
			}

				
		}
		
		return false;
	}
	
	public boolean checkAlienProjectileColisiion(){
		Alien[][] array = squadron.getAliens();
		for (int i = 0; i < array.length; i++) {
                    
                    for (int j = 0; j < array[i].length; j++) {
			
                        if(array[i][j].isVisible()){
                            
                        if(array[i][j].getCollisionRectangle().intersects(projectile.getCollisionRectangle())){
			array[i][j].setVisible(false);
			statusPanel.addPoints(array[i][j].getPointValue());
			squadron.decrementNumberVisible();
				return true;
						
					}
						
				}
			}
		}
		return false;
	}
	
	
}
