import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
public class MSClient extends JFrame {
	public int MS_ROWS = 10; 
	public int MS_COLS = 10;
	public int MS_mineNum = 10;
	MineField mf = null;
	
	MSClient (){
		setBackground(Color.black);
		setSize(550,550);
		setLocation(200,200);
		mf = new MineField(MS_ROWS,MS_COLS,MS_mineNum);
		add(mf);
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		  });
		setVisible(true);
		}
	
	public static void main(String[] args) {
		MSClient ms = new MSClient();	

	}
}
