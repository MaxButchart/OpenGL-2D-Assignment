package assignment1;

import java.util.ArrayList;
import java.util.Random;

import com.jogamp.opengl.GL2;

//@author: Max Butchart S15904904
public class Plant {
	
	private Random rand = new Random();
	
	private float x, y, height, scale, dx;
	private int branchNum;
	private ArrayList<Branch> branches = new ArrayList<Branch>();

	//constructor method that generates the plants location and calculates the scale size for that plant
	public Plant()
	{
		x = rand.nextFloat()* 2 -1;
		y = rand.nextFloat() / 2 -1;
		
		
		scale = Math.abs(y);
		
		height = 0.15f * scale; 
		
		dx = 0.0017f * scale;
		
		
		
		branchNum = rand.nextInt(2) + 1;
		
	}
	
	//this method draws the plant and its branches
	public void draw(GL2 gl)
	{
		gl.glColor3f(0, 1, 0);
		gl.glLineWidth(5 * scale);
		
		gl.glBegin(GL2.GL_LINES);
		gl.glVertex2f(x, y);
		gl.glVertex2f(x, y + height);
		gl.glEnd();
		
		for(int i = 0; i < branchNum; i++)
		{
			branches.add(new Branch(x, y, height, scale));
			branches.get(i).draw(gl);
		}
		
	}
	//this method makes the plant and its branches move
	public void think()
	{
		x -= dx;
		
		for(int i = 0; i < branchNum; i++)
		{
			branches.get(i).think(dx);
		}
		
		if(x < -1.1f)
		{
			x = 1.1f;
		}
	}
	

	
}
