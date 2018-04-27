
/**
 * Tony Diep
 * u0934661
 * 1/19/17
 * CS 2420
 * Assignment 1
 * The following text:
 * I pledge that the work done here was my own and that I have learned how to write this program, such that I could throw it out and restart and finish it in a timely manner. I am not 
 * turning in any work that I cannot understand, describe, or recreate. 
 *
 * -Tony Diep
 */
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Sets up the whole GUI program (i.e. the JFrame and other components)
 * 
 * @author Tony Diep, last updated 1-19-17
 */
public class Main extends JFrame implements ChangeListener
{		
	//Serial ID
	private static final long serialVersionUID = 1L;
	//Represents the number of circles to be drawn onto the frame
	private int numOfCircles;
	//Represents the JSlider being represented
	private JSlider circleSlider;
	//Represents the collection of JComponents
	private ArrayList<JComponent> components;
	//Represents the circle panel
	private JPanel circlePanel;
	//Represents the label to constantly update the frames per second
	private JLabel fpsLabel;
	
	/**
	 * The constructor; sets up JFrame and its components
	 * @param numOfCircles -- number of circles requested to be drawn
	 */
	public Main(int numOfCircles)
	{
		this.numOfCircles = numOfCircles;
		
		//One panel
		JPanel masterPanel = new JPanel();
		masterPanel.setLayout(new BorderLayout());
		
		//Second panel
		JPanel labelPanel = new JPanel();
		
		//Third panel
		circlePanel = new JPanel();
		circlePanel.setLayout(null);
		
		components = new ArrayList<JComponent>();
		
		circleSlider = new JSlider(JSlider.HORIZONTAL, 0, 2000, 1000);
   		circleSlider.setMajorTickSpacing(500);
   		circleSlider.setMinorTickSpacing(250);
   		circleSlider.setPaintTicks(true);
   		circleSlider.setPaintLabels(true);
   		circleSlider.addChangeListener(this);  
   		
   		labelPanel.add(circleSlider);
		
   		fpsLabel = new JLabel("Frames per second: ");
   		labelPanel.add(fpsLabel);
   		masterPanel.add(labelPanel, "North");
   		
   		//drawCircles(this.numOfCircles);
			
		masterPanel.add(circlePanel, "Center");
		
		for(int index = 0; index < this.numOfCircles; index++)
		{
			int randWidth = (int) (Math.random() * 100);
			int randHeight = (int) (Math.random() * 100);
			
			Circle circle = new Circle(randWidth, randHeight, "Tony"+ index); 
			circlePanel.add(circle);
			components.add(circle);		
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(600, 600));
		setContentPane(masterPanel);
		setTitle("Amoebas~");
		setVisible(true);
		pack();
		
		new Jiggler(components, fpsLabel).start();
	}
	
	public static void main(String[] args) 
	{		
		Main jiggles = new Main(100);
		jiggles.setVisible(true);
	}

	/**
	 * Takes in the different values from the user moving the slider and passes in to how 
	 * many circles that should be drawn 
	 */
	@Override
	public void stateChanged(ChangeEvent e) 
	{
		drawCircles(circleSlider.getValue());
	}
	
	/**
	 * Draws the desired amount of circles onto the panel contained in the frame
	 */
	public void drawCircles(int howManyCircles)
	{
		components.clear();
		
		for(int index = 0; index < this.numOfCircles; index++)
		{
			int randWidth = (int) (Math.random() * 100);
			int randHeight = (int) (Math.random() * 100);
			
			Circle circle = new Circle(randWidth, randHeight, "Tony"+ index); 
			circlePanel.add(circle);
			components.add(circle);
			
			new Jiggler(components, fpsLabel).start();
		}
	}
}
