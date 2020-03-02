package assignment1;

import java.util.ArrayList;
import java.util.Random;

import com.jogamp.opengl.GL2;

//@author: Max Butchart S15904904
public class Plants extends Activates {

	private ArrayList<Plant> plantList = new ArrayList<Plant>();
	private Random rand = new Random();
	private int plantNum;
	
	
	public Plants()
	{
		plantNum = rand.nextInt(10) + 10;
	}
	
	//this method creates and draws  a random number of plants
	public void draw(GL2 gl)
	{
		for(int i = 0; i < plantNum; i++)
		{
			plantList.add(new Plant());
			plantList.get(i).draw(gl);
		}
	}
	
	//this method makes all the plants move
	public void think()
	{
		
		if(active)
		{
			for(int i = 0; i < plantNum; i++)
			{
				plantList.get(i).think();
			}
		}
	
	}
	
}
