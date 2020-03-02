package assignment1;

import java.util.Random;

import com.jogamp.opengl.GL2;

//@author: Max Butchart S15904904
public class Building {

	float x, y, xPos, width, height, dx;
	Random rand = new Random();
	
	//Constructor class that generates the width and height of the building
	public Building(float xPosition, int heightX)
	{
		width = rand.nextFloat() / 10 + 0.02f;
		height = rand.nextFloat() / (10 - heightX) + 0.03f;
		xPos = xPosition;
		dx = 1;
		
	}
	
	/*this method draws the builing
	@params
	r: the red value
	g: the green value
	b: the blue value*/
	public void draw(GL2 gl, float r, float g, float b)
	{
		
		
		//draws a black rectangle
		gl.glColor3f(0, 0, 0);
		gl.glBegin(GL2.GL_QUADS);
		
		
		x = xPos;
	
		y = -0.41f;
		
		
		gl.glVertex2f(x, y);
		x += width;
		gl.glVertex2f(x, y);
		y += height;
		gl.glVertex2f(x, y);
		x -= width;
		gl.glVertex2f(x, y);
		
		gl.glEnd();
		
		//draws a colored line around the rectangle
		gl.glColor3f(r, g, b);
		
		
		gl.glBegin(GL2.GL_LINE_STRIP);
		
		x = xPos;
		y = -0.41f;
		
		
		gl.glVertex2f(x, y);
		y += height;
		gl.glVertex2f(x, y);
		x += width;
		gl.glVertex2f(x, y);
		y -= height;
		gl.glVertex2f(x, y);
		
		gl.glEnd();
	}
	
	//method to make the building move
	public void think(float speed)
	{
		
		dx = speed;
		
		xPos -= dx;
		
		if(xPos < -1.5)
		{
			xPos = 1.1f + (rand.nextFloat() / 10);
		}
	}
}
