package assignment1;

import java.util.ArrayList;

import com.jogamp.opengl.GL2;

//@author: Max Butchart S15904904
public class Grid extends Activates{
	
	private ArrayList<GridLine> lines = new ArrayList<GridLine>(); 
	
	//this constructor creates the horizontal lines of the grid and puts them in an arraylist
	public Grid()
	{
		for(int i = -20; i < 20; i++)
		{
			lines.add(new GridLine(i));
		}
	}
	
	//this method draws the lines of the grid
	public void draw(GL2 gl)
	{
		
		gl.glColor4f(0, 1, 0, 0.75f);
		gl.glLineWidth(1);
		//horizontal lines
		for(int i = 4; i < 20; i++ )
		{
			gl.glBegin(GL2.GL_LINES);
			gl.glVertex2f(-1f, (float) (Math.exp(i * -0.1)) * -1.5f);
			gl.glVertex2f(1f, (float) (Math.exp(i * -0.1)) * -1.5f);
			gl.glEnd();
			
		}
		
		gl.glColor3f(0, 1, 0);
		
		//vertical lines
		for(GridLine line : lines)
		{
			line.draw(gl);
		}
		
		//black background
		gl.glColor4f(0, 0, 0, 1);
		gl.glBegin(GL2.GL_QUADS);
		gl.glVertex2f(-1f, -0.41f);
		gl.glVertex2f(1f, -0.41f);
		gl.glVertex2f(1f, 1f);
		gl.glVertex2f(-1f, 1f);
		gl.glEnd();
		
		
	}
	
	//this method goes through each vertical line in the arraylist and starts their think method
	public void think()
	{
		if(active)
		{
			for(GridLine Lines : lines)
			{
				Lines.think();
			}
		}
	}
	
	
}
