import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Panel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;


public class SmallBox extends Panel {
	Button tButton = new Button("T"); //top Button
	Button bButton = new Button("B"); //bottom Button
	CardLayout card = new CardLayout();
	public boolean isMine = false;

	SmallBox (){
		setSize(10, 10);
		setBackground(Color.DARK_GRAY);
		setForeground(Color.BLUE);		 
		setLayout(card);		
		add(tButton,"top");
		add(bButton,"bottom");
		//tButton.addMouseListener(new dig(this));
		setVisible(true);
	}
	//
	
	public HashMap<Button,Integer> setMines(int total,Collection<SmallBox> cSB){
		
		HashMap<Button,Integer> mineMap = null;
		Iterator it = cSB.iterator();
		Integer value = null;
		
		for (int i = total;i>0;i--){
			while(it.hasNext()){

				
			}
		}
		
		
		
		
		
		return null;
		
	}
	
	//挖雷
	class dig extends MouseAdapter{
		SmallBox sb = null;
		
		dig(SmallBox sb){
			this.sb = sb;
		}
		
		@Override
		public void mouseReleased(MouseEvent e) {
			sb.card.show(sb,"bottom");
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
