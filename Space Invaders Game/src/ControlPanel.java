/*
 Control Panel
 Gianni Lake
 GEEN 165 002
 22/11/15
 Adds reset, start functions and program exit 

 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class ControlPanel extends JPanel{

	
	GamePanel gamePanel;
	public ControlPanel(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
		JButton btnStart = new JButton("Start/Restart");
                
		btnStart.addActionListener(new ActionListener() {
			
		public void actionPerformed(ActionEvent e) {
		gamePanel.newGame();
		gamePanel.repaint();
			}
		});
                
		add(btnStart);
		
    JButton btnExit = new JButton("Exit");
btnExit.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
                
                JLabel ins2 = new JLabel("Movement: Arrow Keys");
                JLabel ins3 = new JLabel("Shoot: Spacebar");
                
		add(btnExit);
               
                add(ins2);
                add(ins3);
	}
}
