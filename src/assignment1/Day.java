package assignment1;

import com.jogamp.opengl.GL2;

//@author: Max Butchart S15904904
public class Day extends Activates{

	private float blue, alpha;
	private boolean ascending;
	
	
	public Day()
	{
		blue = -0.2f;
		alpha = -0.2f;
		ascending = true;
	}
	//this method draws the day channel
	public void draw(GL2 gl)
	{
		gl.glColor4f(1, 1, blue, alpha + 0.2f);
		gl.glBegin(GL2.GL_QUADS);
		gl.glVertex2f(-1, -0.41f);
		gl.glVertex2f(1, -0.41f);
		gl.glColor4f(0, 0, blue, alpha);
		gl.glVertex2f(1, 1);
		gl.glVertex2f(-1, 1);
		gl.glEnd();
		
	}
	
	//this method changes the colour of the sky from blue to orange and back
	public void think()
	{
		
		if(active)
		{
			if(blue > 1.5f)
			{
				ascending = false;
			}
			if(blue < -0.7)
			{
				ascending = true;
			}
			if(blue < 1.5 && ascending)
			{
				blue += 0.01f;
			}
			else if(blue > -0.7f && !ascending)
			{
				blue -= 0.01f;
			}
			if(alpha < 1.5 && ascending)
			{
				alpha += 0.01f;
			}
			else if(alpha > -0.7f && !ascending)
			{
				alpha -= 0.01f;
			}
		}
		else
		{
			if(blue > -0.2)
			{
				blue-= 0.01f;
			}
			if(alpha > -0.2)
			{
				alpha -= 0.01f;
			}
		}
		
	}
	
}
