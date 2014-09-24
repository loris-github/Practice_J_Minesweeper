package otherway1;

import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Collection;

public class GameScene extends Frame {
	public static int GS_ROWS = 4; //
	public static int GS_COLS = 4; //
	public static int GS_HGAP = 1; //
	public static int GS_VGAP = 1; //
	
	GameScene(){
		Collection<SmallBox> c = new ArrayList<SmallBox>();

		setBackground(Color.black);
		setSize(800,600);
		setLocation(800,400);
		setLayout(new GridLayout(GS_ROWS,GS_COLS,GS_HGAP,GS_VGAP));
		
		SmallBox[][] sbs = new SmallBox[GS_ROWS][GS_COLS];
		
		for(int i = 0;i<GS_ROWS;i++){
			for(int j = 0;j<GS_COLS;j++){
				c.add(sbs[i][j]);	
			}
		}
/*		
		int countMine(SmallBox[][] sbs){
			SmallBox[][] sbx = sbs;
			int count = 0;
			int minX = 0;
			int maxX = 0;
			int minY = 0;
			int maxY = 0;
			
			for (int i = minX,i<=maxX,i++){
				for(int j = minY,j<=maxY,j++){
					if(sb[i][j].isMine == ture)
						count++;
				}
			}
			
			return count;
		}
	*/	
		// 放置雷，随机，指定个数
		
		//生成BButton显示
		
		//显示规则，数字，颜色，SP雷用0表示
		
		//判断胜负
		
		//判断是否爆炸
			
		for(SmallBox x : c){
			this.add(x);
		}
		
		this.pack();
		setResizable(false);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		GameScene gs = new GameScene();

	}

}
