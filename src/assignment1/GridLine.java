package assignment1;

//@author: Max Butchart S15904904
import com.jogamp.opengl.GL2;

public class GridLine {
	
	private float xPos, dx;
	
	public GridLine(int index)
	{
		xPos = index * -0.1f;
	}
	
	//this method draws the vertical grid line
	public void draw(GL2 gl)
	{
		gl.glBegin(GL2.GL_LINES);
		gl.glVertex2f(xPos, -1f); 
		gl.glVertex2f(0, 1);
		gl.glEnd();
	
	}
	
	/*this method makes the bottom point of the line move across the screen and resets the position 
	to the right hand side of the screen once it is off screen*/
	public void think()
	{

		dx = 0.0017f;
		xPos-= dx;
		
		if(xPos < - 2)
		{
			xPos = 2;
		}
	}


}
