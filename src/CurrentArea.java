import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;

public class CurrentArea extends JButton{
	
	private boolean dug = false;
	private int state = 0;
	private int vx = 0;
	private int vy = 0;
	private int mark = 0;
	
	
	public int getMark() {
		return mark;
	}

	public void setMark(int mark) {
		this.mark = mark;
	}

	public int getVx() {
		return vx;
	}

	public void setVx(int vx) {
		this.vx = vx;
	}

	public int getVy() {
		return vy;
	}

	public void setVy(int vy) {
		this.vy = vy;
	}

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
