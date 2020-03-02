package assignment1;

import java.util.Random;

import com.jogamp.opengl.GL2;

//@author: Max Butchart S15904904
public class Meteor extends Activates{

	private float radius, xPos, yPos, x, y, speed;
	boolean direction;
	private Random rand = new Random();
	
	public Meteor()
	{
		xPos = (rand.nextFloat() * 2) - 1;
		yPos = 1.2f + (rand.nextFloat() / 2);
		direction = rand.nextBoolean();
		speed = rand.nextFloat() / 100;
	}
	
	//this method draws the meteor
	public void draw(GL2 gl)
	{
		gl.glBegin(GL2.GL_TRIANGLE_FAN);
		
		
		gl.glColor3f(0, 1, 0);
		
		
		for(int i = -180; i < 180; i += 20)
		{
			radius = 0.01f + (rand.nextFloat() / 150);
			x = xPos + (float) Math.cos(Math.toRadians(i)) * radius;
			y = yPos + (float) Math.sin(Math.toRadians(i)) * radius;
			gl.glVertex2f(x, y);
			
		}
		
		gl.glEnd();
	}
	
	/*this method makes the meteor move down the screen either left or right 
	and then puts the meteor at the top of the screen once it reaches the bottom*/
	public void think()
	{
		if (direction)
		{
			xPos += 0.004f + speed;
		}
		else
		{
			xPos -= 0.004f - speed;
		}
		yPos -= 0.02f;
		
		if(xPos > 1.2f || yPos < -0.35f)
		{
			xPos = (rand.nextFloat() * 2) - 1;
			yPos = 1.2f + (rand.nextFloat() / 2);
			direction = rand.nextBoolean();
			speed = rand.nextFloat() / 100;
		}
	}
}
