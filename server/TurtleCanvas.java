import javax.swing.*;
import java.awt.*;

public class TurtleCanvas extends JPanel{

	//private JPanel canvas;
	private int x, y; //The current pen coordinates
	private int posX, posY; //The position to move the pen to
	private boolean penDown;
	private boolean NS;
	private int length;

	public TurtleCanvas(){
		//canvas = new Canvas();
		posX = 100;
		posY = 100;
		penDown = false;
		NS = true;
		length = 0;
	}

	@Override
	public void paintComponent(Graphics g){
		//
		super.paintComponent(g);
		if(NS){
			g.drawLine(x,y,x,y-length);
		}
		else{
			g.drawLine(x,y,x-length,y);
		}
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
