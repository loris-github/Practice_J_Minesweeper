import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MineField extends JPanel {
	
	private int ROWS = 10; 
	private int COLS = 10; 
	private int HGAP = 1; 
	private int VGAP = 1; 
	private int mineNum = 20;
	
	private CurrentArea[][] cas = null;
	private ArrayList<CurrentArea> minesArray = new ArrayList<CurrentArea>();
	private int  unknowArea = 0;

	MineField(int ROWS,int COLS,int mineNum){
		this.ROWS = ROWS;
		this.COLS = COLS;
		this.mineNum = mineNum;
		
		setLayout(new GridLayout(this.ROWS,this.COLS,this.HGAP,this.VGAP));		
		cas = new CurrentArea[this.ROWS][this.COLS];
		setMine(this.mineNum);
		//pack();
	}

	private class AroundInfo {	
		CurrentArea ca = null;
		ArrayList<CurrentArea> neighbourArray = null;
		int flags = 0;

		AroundInfo (CurrentArea ca){
			this.ca = ca;
			neighbourArray = getNeighbours(ca);
			
			for(Iterator<CurrentArea> it = neighbourArray.iterator();it.hasNext();){
				CurrentArea neighbour = it.next();
				if(neighbour.getMark() == 1) flags++;
			}			
		}
	}
	
	private ArrayList<CurrentArea> getNeighbours(CurrentArea ca){
		ArrayList<CurrentArea> al = new ArrayList<CurrentArea>();			
		int i = ca.getVx();
		int j = ca.getVy();
		
		for(int m = (i == 0 ? 0 : i-1); m <= (i == cas.length-1 ? cas.length-1:i+1); m++){
			for(int n = (j == 0 ? 0 : j-1); n <= (j == cas[i].length-1 ? cas[i].length-1:j+1); n++){
				if(m == i && n == j) continue;
				al.add(cas[m][n]);
			}
		}		
		return al;
	}
	
	private void setMine(int mineNum){
		unknowArea = this.ROWS * this.COLS - mineNum;
		Random random = new Random();
		int count = 0;
		
		//初始化并放入MineField
		for(int i = 0;i<cas.length;i++){
			for(int j = 0;j<cas[i].length;j++){
				cas[i][j] = new CurrentArea();
				cas[i][j].setVx(i);
				cas[i][j].setVy(j);
				cas[i][j].addMouseListener(new click());
				this.add(cas[i][j]);
			}
		}

		//初始化地雷，并放入mineArray，并初始化unknowArea
		for (int i = 0;i<mineNum;i++){ // 小于等于号导致多布一颗雷
			
			int x = random.nextInt(this.ROWS-1);
			int y = random.nextInt(this.ROWS-1);
			
			if(cas[x][y].getState()==9) {
				i-- ; //没有此处 导致判断胜利错误
				continue;	
			}
			
			else 
				cas[x][y].setState(9);
			    minesArray.add(cas[x][y]);
		}
		
		//初始化非雷的区域数字
		for(int i = 0;i<cas.length;i++){
			for(int j = 0;j<cas[i].length;j++){
				if(cas[i][j].getState()==9) continue;					
				else{
					ArrayList<CurrentArea> al =getNeighbours(cas[i][j]);
					for(Iterator<CurrentArea> it = al.iterator();it.hasNext();){
						CurrentArea neighbour = it.next();
						if(neighbour.getState()==9) count++;
					}			
				}
				
				cas[i][j].setState(count);
				count = 0;
			}			
		}
	}
	
	private void dugShow(CurrentArea ca){	
		ca.setBackground(Color.LIGHT_GRAY);				
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
				ca.setBackground(Color.RED);
				ca.setText("B");
				break;
			}			
		}
	}
	
	private void markShow(CurrentArea ca){			
		switch(ca.getMark()){			
			case 0 : {
				ca.setForeground(new Color(128,128,128));
				ca.setText("");
			}
			break;
			case 1 : {
				ca.setForeground(new Color(128,128,128));
				ca.setText("F");
			}
			break;
			case 2 :{
				ca.setForeground(new Color(128,128,128));
				ca.setText("?");
			}
			break;
		}
	}
	
	private void fall () {
		System.out.println("you are dead!");	
		for(Iterator<CurrentArea> it = minesArray.iterator();it.hasNext();){
			CurrentArea mine = it.next();
				dugShow(mine);
		}
		
	}
	
	private void win (){
		System.out.println("you are win!");	
	}
	
	private void checkWin(){
		unknowArea--;
		if (unknowArea == 0) {
			win();
		}else
			return;
	};

	private void sweeper (CurrentArea ca){
		ca.setDug(true);
		if(ca.getState() == 9){
			fall();
		}else if(ca.getState() == 0){
			checkWin();
			quickSweeper(ca);							
		}else{
			checkWin();
			ca.setText(String.valueOf(ca.getState()));						
		}
		dugShow(ca);		
	}

	private void quickSweeper(CurrentArea ca){
		AroundInfo ai = new AroundInfo (ca);
		if(ca.getState() == ai.flags){
			for(Iterator<CurrentArea> it = ai.neighbourArray.iterator();it.hasNext();){
				CurrentArea neighbour = it.next();
				if(neighbour.isDug() == true || neighbour.getMark() == 1) continue;
				sweeper(neighbour);			
			}
		}
	}
	
	private void setFlag (CurrentArea ca){		
		switch (ca.getMark()){
			case 0 : ca.setMark(1);
			break;
			case 1 : ca.setMark(2);
			break;
			case 2 : ca.setMark(0);
			break;
		}
		markShow(ca);
	}

	private class click extends MouseAdapter{
		public void mouseReleased(MouseEvent e){
			CurrentArea ca = (CurrentArea)e.getSource();
			if(ca.isDug()!=true){
				if (e.getButton() == MouseEvent.BUTTON3){				 
					 setFlag(ca);
			        }			 
				 else if (e.getButton() == MouseEvent.BUTTON1){
					 sweeper(ca);
				 }
			}
		}
		
		public void mouseClicked(MouseEvent e){
			CurrentArea ca = (CurrentArea)e.getSource();
			if(e.getClickCount() == 2 && ca.isDug() == true){ 
				quickSweeper(ca);
			} 
		} 
	}
}
