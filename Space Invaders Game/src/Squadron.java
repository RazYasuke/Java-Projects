/*
 Squadron
 Gianni Lake
 GEEN 165 002
 22/11/15
 Array of aliens to be drawn creates squadron of multiple and different aliens

 */
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.Timer;


public class Squadron extends GameObject {
	

	
	private Alien[][] aliens = new Alien[5][12];//array of aliens 5x12
	private Direction direction;
	private Timer moveTimer;
	private int numVisible;
	private GamePanel gamePanel; 
	
	
	public Squadron(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
		direction = Direction.EAST;
		numVisible = 5*12;
		setVisible(true);
		for (int i = 0; i < aliens.length; i++) {//draws 5x12 of aliens off different types in specified row
		for (int j = 0; j < aliens[i].length; j++) {
		int alienType;
			if(i==0)
			alienType = 3;
			else if(i<=2)
			alienType = 2;
			else
			alienType = 1;
			Alien alien = new Alien(alienType);
			int y = 64 + i*32 +i*8;
			int x = 16  + j*32 +j*8;
			alien.setLocation(new Point(x, y));
			aliens[i][j] = alien;
			}
		}
		
		moveTimer = new Timer(3000, new ActionListener() {
			
		public void actionPerformed(ActionEvent e) {  //squadron movement
                    for (int i = 0; i < aliens.length; i++) {
			
                        for (int j = 0; j < aliens[i].length; j++) {
				aliens[i][j].getLocation().y+=20;
						
					}
				}
				
			if(getLowestVisibleAlienHeight() >= 450){
			moveTimer.stop();
				gamePanel.newGame();
				}
					
				
				gamePanel.repaint();//auto restart
			}
		});
		moveTimer.start();
		
	}
	
	public void setNumVisible(int numVisible) {
		this.numVisible = numVisible;
	}


	public void draw(Graphics g) {
		for (int i = 0; i < aliens.length; i++) {
		
                    for (int j = 0; j < aliens[i].length; j++) {
			
                    if(aliens[i][j].isVisible())
			aliens[i][j].draw(g);
			}
		}
	}
	
	public Alien[][] getAliens() {
		return aliens;
	}
	
	public void decrementNumberVisible(){
		numVisible --;
	}
	
	public int getNumVisible() {
		return numVisible;
	}
	
	public int getLowestVisibleAlienHeight(){
		int max = 0;
		for (int i = 0; i < aliens.length; i++) {
			
                    for (int j = 0; j < aliens[i].length; j++) {
				
                        if(aliens[i][j].isVisible()){
					
                        if(aliens[i][j].getLocation().y > max )
				max = aliens[i][j].getLocation().y ;
				}
			}
		}
		
		return max;
	}
	
}
