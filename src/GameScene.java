import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collection;

class Think implements MouseListener{
	SmallBox sb = null;
	
	Think(SmallBox sb){
		this.sb = sb;
	}

	public void actionPerformed(ActionEvent e) {
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		sb.card.next(sb);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}
}

class SmallBox extends Panel{
	Button tButton = new Button("T"); //top Button
	Button bButton = new Button("B"); //bottom Button
	CardLayout card = new CardLayout();
	
	SmallBox (){
		setSize(10, 10);
		setBackground(Color.DARK_GRAY);
		setForeground(Color.BLUE);		 
		setLayout(card);		
		add(tButton,"top");
		add(bButton,"bottom");
		tButton.addMouseListener(new Think(this));
		tButton.addMouseListener(new Think(this));
		setVisible(true);		
	}
}

public class GameScene extends Frame {
	public static int GS_ROWS = 4; //
	public static int GS_COLS = 4; //
	public static int GS_HGAP = 1; //
	public static int GS_VGAP = 1; //
	
	GameScene(){
		Collection<SmallBox> c = new ArrayList<SmallBox>();
		
		
		for(int i = 0;i<16;i++){
			SmallBox sb = new SmallBox();
			c.add(sb);
		}
		setBackground(Color.black);
		setSize(800,600);
		setLocation(400,800);
		setLayout(new GridLayout(GS_ROWS,GS_COLS,GS_HGAP,GS_VGAP));

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
