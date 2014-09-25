import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;

public class CurrentArea extends JButton{
	
	boolean dug = false;
	int state = 0;
	
	public boolean isDug() {
		return dug;
	}

	public void setDug(boolean dug) {
		this.dug = dug;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	CurrentArea(){
		setFont(getFont());
		setSize(30, 30);
		//setBackground(Color.DARK_GRAY);
		setForeground(Color.red);
		//tButton.addMouseListener(new dig(this));
		setVisible(true);
	}

}
