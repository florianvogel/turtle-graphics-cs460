/**
 * Author: Jayden Urch
 * Student No: 5388406
 * Email: jsu22@nau.edu
 *
 * Author: Florian Vogel
 * Student No: 5373720
 * Email: fv69@nau.edu
 *
 * Date: 12/01/2016
 */
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class TurtleCanvas extends JPanel{

	private int x, y; //The current pen coordinates
	private int width, height; //whiteboard dimensions
	BufferedImage image; //image to draw
	Graphics2D graphics; //graphics of the image

	//constructor
	public TurtleCanvas(int initWidth, int initHeight){
		width = initWidth;
		height = initHeight;
		image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		graphics = image.createGraphics();
		graphics.setColor(Color.BLACK);
		x = 0;
		y = 0;
	}

	//Drawing the image on the JPanel
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(image, 0, 0, this);
     	System.out.println("x: " + x + " y: " + y);
	}

	//Drawing the graphics on the image
	//NorS is true if the direction to move is north or south
	//Length is the distance to move the pen
	public void draw(boolean NorS, int length){
		if(NorS){
			y += length;
			graphics.drawLine(x,y,x,y-length);
		}
		else{
			x += length;
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

	public int getX(){
		return x;
	}

	public int getY(){
		return y;
	}
}
