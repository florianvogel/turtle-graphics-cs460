import java.awt.Canvas;
import java.awt.Graphics;

public class TurtleCanvas extends Canvas{

	private Canvas canvas;
	private int x, y; //The current pen coordinates
	private int posX, posY; //The position to move the pen to
	private boolean penDown;
	private int length;

	public TurtleCanvas(){
		canvas = new Canvas();
		posX = 0;
		posY = 0;
		penDown = false;
		length = 0;
	}

	@Override
	public void paint(Graphics g){
		g.drawLine(x,y,posX,posY);
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
