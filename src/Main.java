import javax.swing.*;
import java.awt.*;
public class Main extends JFrame{
	static Home home ;
	Main(){
		setResizable(false);
		setSize(940,690);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Snake");
	}
	public static void main(String[]args){
		JFrame frame = new Main();
		home = new Home();
		home.setBackground(Color.RED);
		frame.add(home);
	}
}