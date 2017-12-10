import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class play extends JPanel implements ActionListener{
   private final int B_WIDTH = 620;
   private final int B_HEIGHT = 540;
   private final int DOT_SIZE = 10;
   private final int ALL_DOTS = 900; 
   private final int x[] = new int[ALL_DOTS]; 
   private final int y[] = new int[ALL_DOTS];
   private final int p4_x[] = new int[20];
   private final int p4_y[] = new int[20];
   private final int p6_x[] = new int[15];
   private final int p6_y[] = new int[15];
   private int Delay = 200;
   private int dots;
   private int apple_x;	
   private int apple_y;
   static boolean leftDirection = false; 
   static boolean rightDirection = true;
   static boolean upDirection = false;
   static boolean downDirection = false;
   private boolean inGame = true;
   private Timer timer;
   private Image ball;
   private Image apple;
   private Image head;
   private Image p4;
   private Image p6;
   private int count=0;
   private int n4,n6,xx,yy;
   play(){
       setBackground(Color.black);
       setFocusable(true);
       setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
       problem();
       loadImages();
       initGame();
   }
   private void problem(){
	   if(count<7){
		   n4=10;
		   n6=5;
		   for(int i=0;i<n4;i++){
			   xx= (int)(Math.random()*58);
			   yy= (int)(Math.random()*50);
			   p4_x[i] = (int)(xx*DOT_SIZE);
			   p4_y[i] = (int)(yy*DOT_SIZE);
		   }
		   for(int i=0;i<n6;i++){
			   xx= (int)(Math.random()*58);
			   yy= (int)(Math.random()*50);
			   p6_x[i] = (int)(xx*DOT_SIZE);
			   p6_y[i] = (int)(yy*DOT_SIZE);
		   }
	   }
	   else if(count<15){
		   n4=15;
		   n6=10;
		   Delay-=70;
		   for(int i=0;i<n4;i++){
			   xx= (int)(Math.random()*58);
			   yy= (int)(Math.random()*50);
			   p4_x[i] = (int)(xx*DOT_SIZE);
			   p4_y[i] = (int)(yy*DOT_SIZE);
		   }
		   for(int i=0;i<n6;i++){
			   xx= (int)(Math.random()*58);
			   yy= (int)(Math.random()*50);
			   p6_x[i] = (int)(xx*DOT_SIZE);
			   p6_y[i] = (int)(yy*DOT_SIZE);
		   }
	   }
	   else{
		   n4=20;
		   n6=15;
		   Delay-=70;
		   for(int i=0;i<n4;i++){
			   xx= (int)(Math.random()*58);
			   yy= (int)(Math.random()*50);
			   p4_x[i] = (int)(xx*DOT_SIZE);
			   p4_y[i] = (int)(yy*DOT_SIZE);
		   }
		   for(int i=0;i<n6;i++){
			   xx= (int)(Math.random()*58);
			   yy= (int)(Math.random()*50);
			   p6_x[i] = (int)(xx*DOT_SIZE);
			   p6_y[i] = (int)(yy*DOT_SIZE);
		   }

	   }
	   
   }
   
    private void loadImages() {//ãÊèÃÙ» ËÑÇ µÑÇ áÍ»à»ÔÅ
       ImageIcon iib = new ImageIcon("snake.png");
       ball = iib.getImage();
       ImageIcon iia = new ImageIcon("apple.png");
       apple = iia.getImage();
       ImageIcon iih = new ImageIcon("snake.h.png");
       head = iih.getImage();
       ImageIcon iip4 = new ImageIcon("D4.jpg");
       p4 = iip4.getImage();
       ImageIcon iip6 = new ImageIcon("D6.jpg");
       p6 = iip6.getImage();
   }
   private void initGame() {
       dots = 3;
       for (int z = 0; z < dots; z++) { //¨Ø´àÃÔèÁµé¹
           x[z] = 50 - z * 10;
           y[z] = 50;
       }
       locateApple(); //ÊÃéÒ§µÓáË¹è§
       timer = new Timer(Delay, this);
       timer.start();
   }
   @Override
   public void paintComponent(Graphics g) {
       super.paintComponent(g);
       doDrawing(g);
   }   
   private void doDrawing(Graphics g) {   //ÇÒ´µÑÇ§Ù   áÍ»à»ÔÅ
       if (inGame) { 
           g.drawImage(apple, apple_x, apple_y, this); 
           for (int z = 0; z < dots; z++) { 
               if (z == 0) {
                   g.drawImage(head, x[z], y[z], this); 
               } else {
                   g.drawImage(ball, x[z], y[z], this); 
               }
           }
           for(int i=0;i<n4;i++){
			   g.drawImage(p4, p4_x[i], p4_y[i], this);
		   }
		   for(int i=0;i<n6;i++){
			   g.drawImage(p6, p6_x[i], p6_y[i], this);
		   }
           Toolkit.getDefaultToolkit().sync(); 
       } else {
           gameOver(g);
       }
   }
   private void gameOver(Graphics g) {       
       String msg = "Game Over";
       String msg2 = "Your score is";
       String score= Integer.toString(count*10);
       
       Font small = new Font("Helvetica", Font.BOLD, 60);
       FontMetrics metr = getFontMetrics(small);
       g.setColor(Color.white);
       g.setFont(small);
       g.drawString(msg, (B_WIDTH - metr.stringWidth(msg)) / 2, B_HEIGHT / 2);
       Font small2 = new Font("Helvetica", Font.BOLD, 30);
       FontMetrics metr2 = getFontMetrics(small2);
       g.setColor(Color.white);
       g.setFont(small2);
       g.drawString(msg2, (B_WIDTH - metr.stringWidth(msg2)) / 2+60, B_HEIGHT / 2+50);
       Font small3 = new Font("Helvetica", Font.BOLD, 30);
       FontMetrics metr3 = getFontMetrics(small3);
       g.setColor(Color.white);
       g.setFont(small3);
       g.drawString(score, (B_WIDTH - metr.stringWidth(score)) / 2+110, B_HEIGHT / 2+50);
   }
   private void check() { 
       if ((x[0] == apple_x) && (y[0] == apple_y)) { //àªç¤ËÑÇ§Ù 
           dots++;
           count++;
           if(count==8||count==16)
               problem();
           locateApple();
       }
       for(int k=0;k<n4;k++){
    	   if ((x[0] == p4_x[k]) && (y[0] == p4_y[k]))  
    		   inGame = false;
           
	   }
	   for(int l=0;l<n6;l++){
		   if ((x[0] == p6_x[l]) && (y[0] == p6_y[l]))  
    		   inGame = false;
	   }
   }
   private void move() {
       for (int z = dots; z > 0; z--) { 
           x[z] = x[(z - 1)];
           y[z] = y[(z - 1)];
       }
       if (leftDirection) {
           x[0] -= DOT_SIZE; 
       }
       if (rightDirection) {
           x[0] += DOT_SIZE;
       }
       if (upDirection) {
           y[0] -= DOT_SIZE;
       }
       if (downDirection) {
           y[0] += DOT_SIZE;
       }
   }
   private void checkCollision() {
       for (int z = dots; z > 0; z--) { 
           if ((z > 4) && (x[0] == x[z]) && (y[0] == y[z])) { 
               inGame = false;
           }
       }
       if (y[0] > B_HEIGHT-(DOT_SIZE+5)) { 
           inGame = false;
       }
       if (y[0] < 0) {
           inGame = false;
       }
       if (x[0] > B_WIDTH-(DOT_SIZE+5)) {
           inGame = false;
       }
       if (x[0] < 0) {
           inGame = false;
       }   
       if(!inGame) { 
           timer.stop(); 
       }
   }
   private void locateApple() {
       int r = (int) (Math.random() * 58); 
       apple_x = ((r * DOT_SIZE));
       r = (int) (Math.random() * 50);
       apple_y = ((r * DOT_SIZE));
   }
   @Override
   public void actionPerformed(ActionEvent e) {
       if (inGame) {
           check();
           checkCollision();
           move();
       }
       repaint();
   }
   
}
