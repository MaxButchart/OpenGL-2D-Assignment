package assignment1;

import java.util.ArrayList;
import java.util.Random;

import com.jogamp.opengl.GL2;

//@author: Max Butchart S15904904
public class City extends Activates {

	
	float xPos;
	int i;
	Random rand = new Random();
	
	private ArrayList<Building> buildings = new ArrayList<Building>(); 
	
	//stores the width, height and position of each building for drawing later
	public void create(int heightx)
	{
		xPos = -1;
		
		while(xPos < 1.5)
		{
			xPos += rand.nextFloat() / 10;
			buildings.add(new Building(xPos, heightx));
		}
	}
	
	
	//this method draws a series of random buildings
	public void draw(GL2 gl, float r, float g, float b)
	{
		
		
		for(Building building : buildings)
		{
			building.draw(gl, r, g, b);
		}
	}
	
	//this method makes all buildings stored in the city move
	public void think(float speed)
	{
		if(active)
		{
			for(Building building : buildings)
			{
				building.think(speed);
			}
		}
	}
	
	
}
