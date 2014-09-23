import java.awt.Button;
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
	public void actionPerformed(ActionEvent e) {
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		Button bb = (Button)e.getSource();
		bb.setVisible(false);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}

class SmallBox extends Panel{
	Button boxButton = null;
	Label boxLabel = null;
	SmallBox (String str){
		setSize(10, 10);
		setBackground(Color.DARK_GRAY);
		setForeground(Color.BLUE);
		add(boxLabel = new Label(str));
		add(boxButton = new Button());
		boxButton.addMouseListener(new Think());
		boxButton.addMouseListener(new Think());
		setVisible(true);		
	}
}

public class GameScene extends Frame {
	GameScene(){
		Collection<SmallBox> c = new ArrayList<SmallBox>();
		for(int i = 0;i<16;i++){
			SmallBox sb = new SmallBox(""+i+"");
			//sb.addMouseListener(new Think());
			c.add(sb);
		}
		
		setSize(800,600);
		setLocation(400,800);
		setLayout(new GridLayout(4,4));
		
		for(SmallBox x : c){
			this.add(x);
		}
		
		this.pack();
		setVisible(true);
	}
	
	public static void main(String[] args) {
		GameScene gs = new GameScene();

	}

}
