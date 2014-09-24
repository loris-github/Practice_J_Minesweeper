import java.awt.Button;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class CurrentArea extends Button{
	
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
		setSize(20, 20);
		setBackground(Color.DARK_GRAY);
		setForeground(Color.yellow);
		//tButton.addMouseListener(new dig(this));
		setVisible(true);
	}

}
