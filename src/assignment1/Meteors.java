package assignment1;

import java.util.ArrayList;

import com.jogamp.opengl.GL2;

//@author: Max Butchart S15904904
public class Meteors extends Activates {
	
	private final int MAX_METEORS = 15;
	
	private ArrayList<Meteor> meteorList = new ArrayList<Meteor>();
	
	//this constructor makes a specified amount of meteors in an arraylist
	public Meteors(int amount)
	{
		if (amount > MAX_METEORS)
		{
			amount = MAX_METEORS;
		}
				
		for(int i = 0; i < amount; i++)
		{
			meteorList.add(new Meteor());
		}
	}
	
	//this method draws all the meteors in the arraylist
	public void draw(GL2 gl)
	{
		for(Meteor meteor : meteorList)
		{
			meteor.draw(gl);
		}
	}
	
	//this method enables the think method for all meteors in the arraylist
	public void think()
	{
		if(active)
		{
			for(Meteor meteor : meteorList)
			{
				meteor.think();
			}
		}
	}
}
