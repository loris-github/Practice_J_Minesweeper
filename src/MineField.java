import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.JFrame;


public class MineField extends JFrame {
	
	public static int GS_ROWS = 10; //
	public static int GS_COLS = 10; //
	public static int GS_HGAP = 1; //
	public static int GS_VGAP = 1; //
	public static int mineNum = 20;
	CurrentArea[][] cas = null;

	MineField(){
		setBackground(Color.black);
		setSize(800,800);
		setLocation(800,200);
		setLayout(new GridLayout(GS_ROWS,GS_COLS,GS_HGAP,GS_VGAP));		
		cas = new CurrentArea[GS_ROWS][GS_COLS];
		setMine(10);
		//testSetMine();
		//pack();
		setVisible(true);
		
		}
	
	private void setMine(int mineNum){
		
		Random random = new Random();
		int count = 0;
		
		for(int i = 0;i<cas.length;i++){
			for(int j = 0;j<cas[i].length;j++){
				cas[i][j] = new CurrentArea();
				cas[i][j].addMouseListener(new Sweeper());
				this.add(cas[i][j]);
			}
		}

		
		for (int i = 0;i<=mineNum;i++){
			int x = random.nextInt(GS_ROWS-1);
			int y = random.nextInt(GS_ROWS-1);
			if(cas[x][y].getState()==9) continue;			
			else 
				cas[x][y].setState(9);
		}
		
		for(int i = 0;i<cas.length;i++){
			for(int j = 0;j<cas[i].length;j++){

				if(cas[i][j].getState()==9) continue;
				
				else{
					for(int m = (i == 0 ? 0 : i-1); m <= (i == cas.length-1 ? cas.length-1:i+1); m++){
						for(int n = (j == 0 ? 0 : j-1); n <= (j == cas[i].length-1 ? cas[i].length-1:j+1); n++){							
							if(cas[m][n].getState() == 9) count++;							
						}
					}
					
					cas[i][j].setState(count);
					count = 0;
					
				}
			}
		}	
	}
	
	private void areaShow(CurrentArea ca){
			if (ca.isDug() == true) ca.setBackground(Color.LIGHT_GRAY);;
			
		switch(ca.getState()){
		
		    case 0 : {
		    	ca.setText("");
		    	break;
		    }		    
		
			case 1 : ca.setForeground(new Color(0,128,255));
			break;
			
			case 2 : ca.setForeground(new Color(0,128,0));
			break;
			
			case 3 : ca.setForeground(new Color(255,0,0));
			break;
			
			case 4 : ca.setForeground(new Color(0,0,255));
			break;
			
			case 5 : ca.setForeground(new Color(128,0,64));
			break;
			
			case 6 : ca.setForeground(new Color(128,128,255));
			break;
			
			case 7 : ca.setForeground(new Color(64,0,0));
			break;
			
			case 8 : ca.setForeground(new Color(128,128,128));
			break;
			
			case 9 : {
				ca.setForeground(new Color(0,0,0));
				ca.setText("Boom");
				ca.setFont(getFont());
				break;
			}
			
		}
	}
	
	
	private class Sweeper extends MouseAdapter{		
		public void mouseReleased(MouseEvent e) {
			CurrentArea ca = (CurrentArea)e.getSource();
			
			 if (e.getButton() == MouseEvent.BUTTON3 && ca.isDug()!=true) {	
		        	ca.setText("Flag");	        	
		        }
			 else{
					ca.setDug(true);
					ca.setText(String.valueOf(ca.getState()));
					areaShow(ca);
			 }
		}
	}

	
	public static void main(String[] args) {
		new MineField();

	}

}
