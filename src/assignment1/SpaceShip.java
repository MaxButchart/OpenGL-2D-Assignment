package assignment1;

import java.util.Random;

import com.jogamp.opengl.GL2;

//@author: Max Butchart S15904904
public class SpaceShip extends Activates {

	private float[] x = {0, 0.1f, 0.1f, 0.05f, 0, -0.05f, -0.1f, -0.1f, -0.1f, -0.05f, 0, 0.05f, 0.1f};
	private float[] dx = new float[13];
	private float alpha = 0;
	private final float SPEED = 0.005f;
	
	Random rand = new Random();
	
	public SpaceShip()
	{
		for(int i = 0; i < dx.length; i++)
		{
			dx[i] = SPEED;
		}
	}
	
	//this method draws the spaceship
	public void draw(GL2 gl)
	{
		gl.glColor4f(0.5f, 1, 0, alpha);	
		gl.glBegin(GL2.GL_POLYGON);
		gl.glVertex2f(x[0], 0.7f);
		gl.glColor4f(0, 1, 0, alpha);
		gl.glVertex2f(x[1], 0.65f);
		gl.glVertex2f(x[2], 0.63f);
		gl.glVertex2f(x[3], 0.61f);
		gl.glColor4f(0.5f, 1, 0, alpha);
		gl.glVertex2f(x[4], 0.6f);
		gl.glColor4f(0, 1, 0, alpha);
		gl.glVertex2f(x[5], 0.61f);
		gl.glVertex2f(x[6], 0.63f);
		gl.glVertex2f(x[7], 0.65f);
		gl.glEnd();
		
		gl.glColor4f(1, 1, 1, alpha);
		gl.glLineWidth(1);
		
		gl.glBegin(GL2.GL_LINE_STRIP);
		gl.glVertex2f(x[8], 0.64f);
		gl.glVertex2f(x[9], (rand.nextFloat() * 2 - 1) / 50 + 0.64f);
		gl.glVertex2f(x[10], (rand.nextFloat() * 2 - 1) / 50 + 0.64f);
		gl.glVertex2f(x[11], (rand.nextFloat() * 2 - 1) / 50 + 0.64f);
		gl.glVertex2f(x[12], 0.64f);
		gl.glEnd();
	}
	
	/*this method makes the spaceship move across the screen 
	and change directions when the spaceship reaches the edges of the screen*/
	public void think()
	{
		for(int i = 0; i < x.length; i++)
		{
			
			if(x[i] < -1.5f)
			{
				dx[i] = Math.abs(dx[i]);
				
			}

			else if(x[i] > 1.5f)
			{
				dx[i] = -dx[i];
			}
			
			x[i] += dx[i];
			
			
		}
		
		if(active)
		{
			if(alpha < 1)
			{
				alpha += 0.05;
			}

		}
		else
		{
			if (alpha > 0)
			{
				alpha -= 0.05;
			}
		}
		
	}
	
}
