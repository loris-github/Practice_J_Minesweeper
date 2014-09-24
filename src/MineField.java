import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


public class MineField extends Frame {
	
	public static int GS_ROWS = 4; //
	public static int GS_COLS = 4; //
	public static int GS_HGAP = 1; //
	public static int GS_VGAP = 1; //
	Map<CurrentArea,Integer> mineMap = new HashMap<CurrentArea,Integer>();
	CurrentArea[][] currentAreas =null;
	
	//布雷
	
	public void setMine(){
		
	}
	
	MineField(){
		setBackground(Color.black);
		setSize(800,600);
		setLocation(800,400);
		setLayout(new GridLayout(GS_ROWS,GS_COLS,GS_HGAP,GS_VGAP));		
		currentAreas = new CurrentArea[GS_ROWS][GS_COLS];		
		}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
