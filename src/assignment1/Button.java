package assignment1;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.util.gl2.GLUT;

//@author: Max Butchart S15904904
public class Button extends Activates{

	float xPos, buttonColour, textColour;
	
	public Button()
	{
		buttonColour = 0;
		textColour = 1;
	}
	
	//modified push method that also calls the changeColour method.
	public void push()
	{
		active = !active;
		
		this.changeColours();
	}
	
	//This method draws the button
	public void draw(GL2 gl, float width, float startPosition)
	{
		xPos = startPosition;
		
		gl.glColor3f(0, buttonColour, 0);
		gl.glBegin(GL2.GL_QUADS);
		
		gl.glVertex2f(startPosition, 0.86f);
		gl.glVertex2f(startPosition + width, 0.86f);
		gl.glVertex2f(startPosition + width, 0.99f);
		gl.glVertex2f(startPosition, 0.99f);
		
		gl.glEnd();
	}
	//this method sets the text for the button
	public void setText(GL2 gl, GLUT glut, String text)
	{
		gl.glColor3f(0, textColour, 0);
		glut.glutBitmapString(GLUT.BITMAP_HELVETICA_18, text);
		gl.glRasterPos2f((xPos + 0.01f), 0.9f);
	}
	
	//this method inverts the colour of the text and button
	public void changeColours()
	{
		if(buttonColour == 0)
		{
			buttonColour = 1;
			textColour = 0;
		}
		else
		{
			buttonColour = 0;
			textColour = 1;
		}
	}

}
