package assignment1;

import com.jogamp.opengl.GL2;

//@author: Max Butchart S15904904
public class LightningRod {
	
	//this method draws the lightning rod
	public void draw(GL2 gl)
	{
		gl.glColor3f(1, 0, 0);
		gl.glLineWidth(2);
		gl.glBegin(GL2.GL_LINE_STRIP);
		gl.glVertex2f(-0.1f, -0.41f);
		gl.glVertex2f(0, 0.075f);
		gl.glVertex2f(0.1f, -0.41f);
		gl.glVertex2f(-0.05f, -0.1675f);
		gl.glVertex2f(0.05f, -0.1675f);
		gl.glVertex2f(-0.025f, -0.07f);
		gl.glVertex2f(0.025f, -0.07f);
		gl.glVertex2f(-0.05f, -0.1675f);
		gl.glVertex2f(0.05f, -0.1675f);
		gl.glVertex2f(-0.1f, -0.41f);
		gl.glEnd();
	}

}
