package assignment1;

import com.jogamp.opengl.GL2;

//@author: Max Butchart S15904904
public class Atmosphere extends Activates {
	
	private float transparency = 0;
	
	
	//This method draws the atmosphere
	public void draw(GL2 gl)
	{
		gl.glColor4f(0, 1, 0, transparency);
		gl.glBegin(GL2.GL_QUADS);
		gl.glVertex2d(-1, -0.41);
		gl.glVertex2d(1, -0.41);
		gl.glColor4f(0, 1, 0, 0);
		gl.glVertex2d(1, 0.2);
		gl.glVertex2d(-1, 0.2);
		gl.glEnd();
	}
	
	//this method modifies the transparency of the atmosphere to make it appear and disappear
	public void think()
	{
		if(active)
		{
			if(transparency < 1)
			{
				transparency += 0.01f;
			}
		}
		if(!active)
		{
			if (transparency > 0)
			{
				transparency -= 0.01f;
			}
		}
	}

}
