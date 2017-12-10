import java.awt.*;
import javax.swing.*;
public class howto extends JPanel {
	JLabel BG2 = new JLabel(new ImageIcon("BG2.jpg"));
	JLabel BT2 = new JLabel(new ImageIcon("BT2.png"));
	howto(){
		setBackground(Color.black);
		this.setSize(620,540);
		setLayout(new BorderLayout());
		setLayout(null);
		BG2.setBounds(100, 20, 400, 400);
		add(BG2);
		BT2.setBounds(250,430,120,40);
		add(BT2);
	}
	
}
