import java.awt.*;
import javax.swing.*;
public class Home extends JPanel{
	ImageIcon BG1 = new ImageIcon("BG1.png");
	JLabel BT = new JLabel(new ImageIcon("button.png"));
	Home(){
		this.setSize(620,540);
		setLayout(new BorderLayout());
		setLayout(null);
		BT.setBounds(150,300,300,300);
		add(BT);
	}
	public void paintComponent (Graphics g){
		g.drawImage(BG1.getImage(),0,0,this);
	}
}