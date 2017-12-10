import javax.swing.*;
public class Home extends JPanel {
	static JLabel start,exit;
	public Home(){
		setLayout(null);
		start = new JLabel();
		start.setText("Start");
		start.setLocation(0,0);
		start.setSize(263,66);
		add(start);
	}
}