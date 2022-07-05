/*
 Game Frame
 Gianni Lake
 GEEN 165 002
 22/11/15
 The General game frame 

 */
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import javax.swing.JFrame;


public class GameFrame extends JFrame {
	
	GamePanel gamePanel;
	StatusPanel statusPanel;
	ControlPanel controlPanel;
	
	public GameFrame() {
		
            setLayout(null);
	getContentPane().setBackground(Color.BLACK);
	
        setSize(525,615);
		
	statusPanel = new StatusPanel();
	
        statusPanel.setBounds(0, 515, 300, 300);
		
        add(statusPanel);
		
		
	gamePanel = new GamePanel(statusPanel);
		
               gamePanel.setLocation(0, 0);
		
               add(gamePanel);

		
	controlPanel = new ControlPanel(gamePanel);
		
        controlPanel.setBounds(300, 515, 225, 300);
		
       add(controlPanel);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
                setTitle("SPACE INVADERS (MP3)  ");
                
		
	}
	
	public static void main(String[] args) {
		new GameFrame();
	}
}
