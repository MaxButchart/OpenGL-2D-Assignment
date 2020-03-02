package assignment1;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.util.gl2.GLUT;

/* This Class is for displaying and managing interactions with the buttons*/
//@author: Max Butchart S15904904
public class ButtonManager {
	
	Button[] buttons = new Button[6];
	float width, startPosition, glX, glY;
	City city1;
	City city2;
	City city3;
	Grid grid;
	Meteors meteors;
	Lightning lightening;
	SpaceShip ship;
	Plants plants;
	Atmosphere atmosphere;
	Day day;

	/*This method initialises the button manager with 
	all references to the different objects in the scene*/
	public ButtonManager(City city1, City city2, City city3, 
			Grid grid, Meteors meteors, Lightning lightening, 
			SpaceShip ship, Plants plants, Atmosphere atmosphere, Day day)
	{
		width = 0.322f;
		
		this.city1 = city1;
		this.city2 = city2;
		this.city3 = city3;
		this.grid = grid;
		this.meteors = meteors;
		this.lightening = lightening;
		this.ship = ship;
		this.plants = plants;
		this.atmosphere = atmosphere;
		this.day = day;
		
		for(int i = 0; i < buttons.length; i++)
		{
			buttons[i] = new Button();
		}
	}
	
	//This method draws the button area and all the buttons
	public void draw(GL2 gl, GLUT glut)
	{
		gl.glColor3f(0.6f, 0.6f, 0.6f);
		gl.glBegin(GL2.GL_QUADS);
		
		gl.glVertex2f(-1, 0.85f);
		gl.glVertex2f(1, 0.85f);
		gl.glVertex2f(1, 1);
		gl.glVertex2f(-1, 1);
		
		gl.glEnd();
		
		startPosition = -0.99f;
		
		for(int i = 0; i < buttons.length; i++)
		{
			buttons[i].draw(gl, width, startPosition);
			startPosition = (float) (startPosition + width + 0.01f);
		}
		
		buttons[0].setText(gl, glut, "Meteors");
		buttons[1].setText(gl, glut, "Move");
		buttons[2].setText(gl, glut, "Lightning");
		buttons[3].setText(gl, glut, "Atmosphere");
		buttons[4].setText(gl, glut, "Day/Night");
		buttons[5].setText(gl, glut, "SpaceShip");
		
		
	}
	
	/*This method checks the location of the mouse click and 
	converts it to openGL coordinates. The method then checks 
	the location of the click, if the click is on a button the
	method activates the functionality of the button */
	public void push(float x, float y)
	{
		glX = 2.0f * (x / 640) - 1.0f;
		glY = (2.0f * (y / 480) - 1.0f) * -1;
		
		if(glX < -0.66 && glY > 0.85f)
		{
			buttons[0].push();
			city1.push();
			city2.push();
			city3.push();
			plants.push();
			grid.push();
		}
		if(glX < -0.33 && glX > -0.66 && glY > 0.85f)
		{
			buttons[1].push();
			lightening.push();
		}
		if(glX < 0 && glX > -0.33 && glY > 0.85f)
		{
			buttons[2].push();
			atmosphere.push();
		}
		if(glX < 0.33 && glX > 0 && glY > 0.85f)
		{
			buttons[3].push();
			day.push();
		}
		if(glX < 0.66 && glX > 0.33 && glY > 0.85f)
		{
			buttons[4].push();
			ship.push();
		}
		if(glX < 1 && glX > 0.66 && glY > 0.85f)
		{
			buttons[5].push();
			meteors.push();
		}
		
	}
	
}
