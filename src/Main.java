import java.awt.event.*;
import javax.swing.*;
public class main extends JFrame implements MouseListener{
	static Home ohome=  new Home();
	static play oplay;
	static howto ohowto=new howto();
    main(){
    	addKeyListener(new TAdapter());
    	this.add(ohome);
    	ohome.BT.addMouseListener(this);
    	ohowto.BT2.addMouseListener(this);
    }
	public static void main(String[] args) {
		main frame = new main();
        frame.setTitle("SMOOTH SNAKE");
        frame.setSize(620,540);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
	}
	public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {} 
   
    public void windows(){
		this.setSize(620,540);
		this.setLocationRelativeTo(null);
	}
    public void mouseClicked(MouseEvent e){
    	if(e.getSource() == ohome.BT) {
    		this.remove(ohome);
    		this.add(ohowto);
    		windows();
        }
    	if(e.getSource() == ohowto.BT2) {
    		this.remove(ohowto);
    		oplay= new play();
    		this.add(oplay);
    		windows();
    		validate();
        }
    	repaint();
    }
    public class TAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
     	   int key = e.getKeyCode();
            if ((key == KeyEvent.VK_LEFT) && (!play.rightDirection)) {
                play.leftDirection = true;
                play.upDirection = false;
                play.downDirection = false;
            }
            if ((key == KeyEvent.VK_RIGHT) && (!play.leftDirection)) {
            	play.rightDirection = true;
            	play.upDirection = false;
            	play.downDirection = false;
            }
            if ((key == KeyEvent.VK_UP) && (!play.downDirection)) {
            	play.upDirection = true;
            	play.rightDirection = false;
            	play.leftDirection = false;
            }
            if ((key == KeyEvent.VK_DOWN) && (!play.upDirection)) {
            	play.downDirection = true;
            	play.rightDirection = false;
            	play.leftDirection = false;
            }
        }
    }
}