import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;


public class MineField extends Frame {
	
	public static int GS_ROWS = 10; //
	public static int GS_COLS = 10; //
	public static int GS_HGAP = 1; //
	public static int GS_VGAP = 1; //
	CurrentArea[][] currentAreas = null;

	MineField(){
		setBackground(Color.black);
		setSize(800,800);
		setLocation(800,200);
		setLayout(new GridLayout(GS_ROWS,GS_COLS,GS_HGAP,GS_VGAP));		
		currentAreas = new CurrentArea[GS_ROWS][GS_COLS];
		setMine(5);
		//testSetMine();
		pack();
		setVisible(true);
		
		}
	
	private void setMine(int mineNum){
		
		Random random = new Random();
		
		for(int i = 0;i<currentAreas.length;i++){
			for(int j = 0;j<currentAreas[i].length;j++){
				currentAreas[i][j] = new CurrentArea();
				currentAreas[i][j].addMouseListener(new Sweeper());
				this.add(currentAreas[i][j]);
			}
		}
		
		for (int i =0;i<=mineNum;i++){
			int x = random.nextInt(GS_ROWS-1);
			int y = random.nextInt(GS_ROWS-1);
			if(currentAreas[x][y].getState()==9) {
				continue;
			}
			else 
				currentAreas[x][y].setState(9);
		}
	
	}
	
	private class Sweeper extends MouseAdapter{		
		public void mouseReleased(MouseEvent e) {
			CurrentArea ca = (CurrentArea)e.getSource();
			ca.setLabel(String.valueOf(ca.getState()));
		}
	}
	
	public static void main(String[] args) {
		new MineField();

	}

}
