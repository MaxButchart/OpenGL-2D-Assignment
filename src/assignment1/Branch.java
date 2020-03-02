package assignment1;

import java.util.Random;

import com.jogamp.opengl.GL2;

//@author: Max Butchart S15904904
public class Branch {

	float x, y, width, height, scale;
	
	Random rand = new Random();
	
	/*Constructor class that generates a random width and height for the branch and scales
	it down to the correct size*/
	public Branch(float xPos, float yPos, float trunkHeight, float scale)
	{
		x = xPos;
		y = yPos + rand.nextFloat() / 6 + 0.01f;
		
		this.scale = scale;
		
		width = (rand.nextFloat() / 75 + 0.02f) * this.scale;
		height = (rand.nextFloat() / 75 + 0.03f) * this.scale;
		
		while(y > yPos + trunkHeight)
		{
			y -= 0.15 * scale;
		}
			
		if(rand.nextBoolean())
		{
			width = width * -1;
		}
	}
	
	//this method draws the branch
	public void draw(GL2 gl)
	{

		gl.glLineWidth(3 * scale);
		gl.glBegin(GL2.GL_LINE_STRIP);
		gl.glVertex2f(x, y);
		gl.glVertex2f(x + width, y);
		gl.glVertex2f(x + width, y + height);
		gl.glEnd();
		
	}
	
	/*this method makes the branch move and resets the x position to the right side of the screen 
	if the branch has gone past the left side of the screen*/
	public void think(float dx)
	{
		x -= dx;
		
		if(x < -1.1f)
		{
			x = 1.1f;
		}
	}
	
}
