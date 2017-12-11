import java.applet.*;
import java.awt.*;
import java.awt.event.*;
public class test extends Applet 
  {
  public void paint(Graphics g){
  g.setColor(Color.black);      g.drawRect(140,285,220,5);
  g.drawOval(240,180,20,20);    g.drawOval(210,130,40,60);
  g.drawLine(240,210,180,200);  g.drawLine(260,210,320,200);
  g.drawLine(245,300,255,300);  g.drawLine(250,300,250,310);
  g.drawArc(255,165,10,10,30,120);
  g.drawArc(150,50,200,200,240,60);
  g.setColor(Color.red);
  g.drawString("Good Luck", 180,350);
  }
}