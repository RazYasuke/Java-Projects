/*
 Status Panel
 Gianni Lake
 GEEN 165 002
 22/11/15
 Adds score to score counter 

 */
import javax.swing.JLabel;
import javax.swing.JPanel;


public class StatusPanel extends JPanel {
	private int points;
	
	JLabel lblPoints;
	public StatusPanel() {                  //Creates point counter
		add(new JLabel("Total Points"));
		lblPoints = new JLabel();
		lblPoints.setText(points+"");
		add(lblPoints);
	}
	
	public void resetPoints(){              //reset points
		points = 0;
		lblPoints.setText(points+"");
	}
	
	public void addPoints(int morePoints){  //increases current point
		points+=morePoints;
		lblPoints.setText(points+"");
	}
	
	public int getPoints() {
		return points;
	}
	
}
