import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class TurtleCanvas extends JPanel{

	private int x, y; //The current pen coordinates
	private int width, height;
	private boolean NS;
	private int length;
	BufferedImage image;
	Graphics2D graphics;

	public TurtleCanvas(int initWidth, int initHeight){
		width = initWidth;
		height = initHeight;
		image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		graphics = image.createGraphics();
		//graphics.setBackground(Color.BLACK);
		graphics.setColor(Color.BLACK);
		x = 0;
		y = 0;
		NS = true;
		length = 0;
	}

	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(image, 0, 0, this);
     	System.out.println("x: " + x + " y: " + y);
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

	public void setX(int newX){
		x = newX;
	}

	public void setY(int newY){
		y = newY;
	}

	public void setLength(int newLength){
		length = newLength;
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

}
