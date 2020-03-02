package assignment1;



import com.jogamp.nativewindow.util.Dimension;
import com.jogamp.newt.event.MouseEvent;
import com.jogamp.newt.event.WindowAdapter;
import com.jogamp.newt.event.WindowEvent;
import com.jogamp.newt.event.MouseListener;
import com.jogamp.newt.opengl.GLWindow;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.util.FPSAnimator;
import com.jogamp.opengl.util.gl2.GLUT;


//@author: Max Butchart S15904904
public class Planet implements GLEventListener, MouseListener {

	static Dimension screenSize = new Dimension();
	private static int screenWidth;
	private static int screenHeight;
	
	private int base;
	
	City city1 = new City();
	City city2 = new City();
	City city3 = new City();
	Grid grid = new Grid();
	Meteors meteors = new Meteors(10);
	Lightning lightening = new Lightning();
	LightningRod rod = new LightningRod();
	SpaceShip ship = new SpaceShip();
	Plants plants = new Plants();
	Atmosphere atmosphere = new Atmosphere();
	Day day = new Day();
	ButtonManager bttnMgr = new ButtonManager(city1, city2, city3, grid, 
			meteors, lightening, ship, plants, atmosphere, day);
	
	
	
	@Override
	public void display(GLAutoDrawable drawable) {
		
		
		GL2 gl = drawable.getGL().getGL2();
		GLUT glut = new GLUT();
		gl.glClear(GL2.GL_COLOR_BUFFER_BIT);
		
		gl.glEnable(GL2.GL_BLEND);
		gl.glBlendFunc(GL2.GL_SRC_ALPHA, GL2.GL_ONE_MINUS_SRC_ALPHA);
		
		
		
		
		
		grid.draw(gl);
		grid.think();
		
		gl.glCallList(base);
		
		atmosphere.draw(gl);
		atmosphere.think();
		day.draw(gl);
		day.think();
		
		meteors.draw(gl);
		meteors.think();
		
		rod.draw(gl);
		
		lightening.draw(gl);

		
		city1.draw(gl, 1, 0, 0);
		city2.draw(gl, 0, 0, 1);
		city3.draw(gl, 0, 1, 0);
		city1.think(0.001f);
		city2.think(0.0011f);
		city3.think(0.0012f);
		
		ship.draw(gl);
		ship.think();
		
		plants.draw(gl);
		plants.think();
		
		bttnMgr.draw(gl, glut);
		
		gl.glFlush();

	}

	@Override
	public void dispose(GLAutoDrawable arg0) {
		

	}

	@Override
	public void init(GLAutoDrawable drawable) {
		

		GL2 gl = drawable.getGL().getGL2();
		
		base = gl.glGenLists(1);
		
		Stars stars = new Stars();
		stars.createStarList(gl, base);
		
		city1.create(5);
		city2.create(2);
		city3.create(0);
		
	}

	@Override
	public void reshape(GLAutoDrawable arg0, int arg1, int arg2, int arg3, int arg4) {
		
	}

	public static void main(String[] args) {
		

		GLProfile profile = GLProfile.get(GLProfile.GL2);
		GLCapabilities capabilities = new GLCapabilities(profile);
		GLWindow window = GLWindow.create(capabilities);
		window.setTitle("Alien Planet");
		
		final FPSAnimator animator = new FPSAnimator(window, 60, true);
		
		
		window.addWindowListener(new WindowAdapter(){
			
			public void windowDestroyed(WindowEvent e)
			{
				new Thread() {
					public void run() {
						if (animator.isStarted()) animator.stop();
						System.exit(0);
					}
				}.start();
			}
		});
		
		Planet planetEL = new Planet();
		window.addGLEventListener(planetEL);
		window.addMouseListener(planetEL);
		
		window.setSize(640, 480);
		window.setVisible(true);
		
		screenWidth = screenSize.getWidth() / 2;
		screenHeight = screenSize.getHeight() / 2;
		
		window.setPosition(screenWidth, screenHeight);
		animator.start();
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		bttnMgr.push(e.getX(), e.getY());
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		//System.out.println("pressed");
	}

	@Override
	public void mouseWheelMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
