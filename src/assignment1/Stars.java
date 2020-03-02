package assignment1;

import com.jogamp.opengl.GL2;

//@author: Max Butchart S15904904
public class Stars {
	
	private int pointList;
	

	
	public void createStarList(GL2 gl, int DLindex)
	{
		pointList = DLindex;
		
		gl.glNewList(pointList, GL2.GL_COMPILE);
		
		//stars
		for(int i = 0; i < 200; i++)
		{
			gl.glPointSize((float) (Math.random()* 2));
			gl.glColor4f(1, 1, 1, (float) Math.random());
			gl.glBegin(GL2.GL_POINTS);
			gl.glVertex2f(2 * (float)Math.random() - 1, 2 * (float)Math.random() - 0.4f);
			gl.glEnd();
		}
		
		gl.glEndList();
	}

}
