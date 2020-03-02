package assignment1;

import java.util.Random;

import com.jogamp.opengl.GL2;

//@author: Max Butchart S15904904
public class Lightning extends Activates{

	private final double[] ROD_LOCATION = {0, 0.075f};
	private final int SEGMENTS = 15;
	private double[][] coords = new double[SEGMENTS][2];
	private double[][] reference = new double[SEGMENTS][2];
	private double angle, hyp;
	
	
	Random rand = new Random();
	
	public Lightning()
	{
		this.aim();
	}
	
	/*this method creates a set of coordinates to make a series of lines going from a random point at the
	top of the screen to the location of the lightning rod*/
	public void aim()
	{
		coords[0][0] = rand.nextFloat() * 2 - 1;
		coords[0][1] = 1;
		
		reference[0][0] = coords[0][0];
		reference[0][1] = coords[0][1];
		
		angle = Math.atan2(coords[0][1] - ROD_LOCATION[1], 
				coords[0][0] - ROD_LOCATION[0]);
		
		hyp = Math.sqrt(Math.pow((coords[0][0] - ROD_LOCATION[0]), 2) + 
				Math.pow((coords[0][1] - ROD_LOCATION[1]), 2)) / SEGMENTS;
		
		for(int i = 1; i < SEGMENTS; i++)
		{	
			coords[i][0] = coords[i-1][0] - (Math.cos(angle) * hyp);
			coords[i][1] = coords[i-1][1] - Math.sin(angle) * hyp;
			
			reference[i][0] = coords[i][0];
			reference[i][1] = coords[i][1];
			
		}
		
		
	}
	
	//this method draws the lightning
	public void draw(GL2 gl)
	{
		if(active)
		{	
			gl.glColor3f(1, 1, 1);
			gl.glBegin(GL2.GL_LINE_STRIP);
			
			for(int i = 0; i < SEGMENTS; i++)
			{	
				coords[i][0] = reference[i][0] - (rand.nextDouble() * 2 - 1) / 10;
				gl.glVertex2dv(coords[i], 0);
			}
			
			
			gl.glVertex2dv(ROD_LOCATION, 0);
			gl.glEnd();
		}
		
	}
	
	//overridden push method that also re-aims the lightning every time lightning is activated 
	public void push()
	{
		active = !active;
		
		if(active)
		{
			this.aim();
		}
	}
	
}
