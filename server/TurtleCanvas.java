import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class TurtleCanvas extends JPanel{

	//private JPanel canvas;
	private int x, y; //The current pen coordinates
	private int posX, posY; //The position to move the pen to
	private boolean penDown;
	private boolean NS;
	private int length;
	BufferedImage image;
	Graphics2D graphics;

	public TurtleCanvas(){
		//canvas = new Canvas();
		image = new BufferedImage(450, 335, BufferedImage.TYPE_INT_ARGB);
		graphics = image.createGraphics();
		//graphics.setBackground(Color.BLACK);
		graphics.setColor(Color.BLACK);
		//graphics.drawLine(0,0,20,20);
		posX = 0;
		posY = 0;
		x = 0;
		y = 0;
		penDown = false;
		NS = true;
		length = 0;
	}

	@Override
	public void paintComponent(Graphics g){
		//
		super.paintComponent(g);
		g.drawImage(image, 0, 0, this);
		//g.drawLine(0,0,20,20);
		//g.drawString("BLAH", 20, 20);
         //   g.drawRect(200, 200, 200, 200);
         System.out.println("x: " + x + " y: " + y + " posx " + posX + " posy " + posY);
         //x = posX;
         //y = posY;
     	 System.out.println("x: " + x + " y: " + y + " posx " + posX + " posy " + posY);
	}

	public void draw(boolean NorS, int newLength){
		NS = NorS;
		length = newLength;
		if(NS){
			y += length;
		}
		else{
			x += length;
		}

		if(NS){
			graphics.drawLine(x,y,x,y-length);
		}
		else{
			graphics.drawLine(x,y,x-length,y);
		}
		
		repaint();
	}

	//Getters and Setters
	public void setPosX(int newX){
		posX = newX;
	}

	public void setPosY(int newY){
		posY = newY;
	}

	public void setX(int newX){
		x = newX;
	}

	public void setY(int newY){
		y = newY;
	}

	public void setLength(int newLength){
		length = newLength;
	}

	public void setPenDown(boolean newPenDown){
		penDown = newPenDown;
	}

	public int getPosX(){
		return posX;
	}

	public int getPosY(){
		return posY;
	}

	public int getX(){
		return x;
	}

	public int getY(){
		return y;
	}

	public int getLength(){
		return length;
	}

	public boolean isPenDown(){
		return penDown;
	}
}
