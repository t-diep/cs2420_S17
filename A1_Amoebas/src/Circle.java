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
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Random;
import javax.swing.JComponent;
import javax.swing.SwingUtilities;

/**
 * Represents a circle Object to be drawn 
 * 
 * @author Tony Diep, last updated 1-19-17
 */
public class Circle extends JComponent implements MouseMotionListener, MouseListener
{
	//Serial ID
	private static final long serialVersionUID = 1L;
	//Represents a flag of whether a circle is selected by the user
	private boolean selected = false;
	//Represents a flag of whether the circle should be filled or not
	private boolean fill;
	//Represents a Point to keep track where the mouse was pressed for dragging
	private Point offset;
	
	/**
	 * The constructor with the user able to provide a name to add to the circle; makes the Circle object
	 * 
	 * @param width -- width for the circle
	 * @param height -- height for the circle
	 * @param aName -- a name to put on the circle
	 */
	public Circle(int width, int height, String aName)
	{				
		//Configure the location, size, name, and mouse capabilities of the circle
		this.setLocation((int) (Math.random() * 500), (int) (Math.random() * 500));
		this.setSize(width, height);
		this.setName("I am Circle " + aName);
		this.setOpaque(true);
		this.addMouseMotionListener(this);
		this.addMouseListener(this);
		
		//Generate a random chance of a this circle either being fill or non-filled
		fill = new Random().nextBoolean();
		
		//Randomly set the color of this circle to be red or blue
		if(fill)
		{
			setForeground(Color.RED);
		}
		else
		{
			setForeground(Color.BLUE);
		}
	}
	
	/**
	 * The second constructor, which calls the first constructor; does not take in a name
	 * 
	 * @param width -- width for the circle
	 * @param height -- height for the circle
	 */
	public Circle(int width, int height)
	{
		this(width, height, "");
	}
	
	/**
	 * Draws a circle
	 * @param graphics -- the Graphics object
	 */
	@Override
	public void paintComponent(Graphics graphics)
	{			
		super.paintComponent(graphics);
		
		Graphics2D circle = (Graphics2D) graphics.create();
	
		
		//Depending on the value of fill, draw a filled circle or a non-filled one
		if(fill)
		{	
			circle.drawOval(0, 0, this.getWidth() - 1 , this.getHeight() - 1);
		}
		else
		{
			circle.fillOval(0, 0, this.getWidth() - 1, this.getHeight() - 1);
		}
		
		circle.drawString(this.getName(), this.getWidth() - 1, this.getHeight() - 1);
		
	}
	
	/**
	 * Getter for whether the circle is selected
	 * @return true if it is selected and false otherwise
	 */
	public boolean isSelected()
	{
		return selected;
	}
	
	/**
	 * Setter for the selected state
	 * @param opposite 
	 */
	public void changeSelected(boolean opposite)
	{
		selected = opposite;
	}

	/**
	 * Listens for the event of mouse dragging triggered by the user
	 * @param event -- the MouseEvent
	 */
	@Override
	public void mouseDragged(MouseEvent event) 
	{	
		Point location2 = SwingUtilities.convertMouseEvent(this, event, this.getParent()).getPoint();
		
		setLocation(location2.x - offset.x, location2.y - offset.y);
		getParent().setComponentZOrder(this, 0);
	}
	
	/**
	 * Listens for the event of mouse pressing triggered by the user
	 * @param event -- the MouseEvent
	 */
	@Override
	public void mousePressed(MouseEvent event) 
	{
		this.changeSelected(true);
		
		offset = event.getPoint();
	}

	@Override
	public void mouseMoved(MouseEvent arg0) 
	{
		//Not used
	}

	@Override
	public void mouseClicked(MouseEvent arg0) 
	{
		//Not used
	}

	@Override
	public void mouseEntered(MouseEvent arg0) 
	{
		//Not used
	}

	@Override
	public void mouseExited(MouseEvent arg0) 
	{
		//Not used
	}

	/**
	 * Listens for the mouse press being released
	 * 
	 * @param e -- the Mousevent
	 */
	@Override
	public void mouseReleased(MouseEvent e) 
	{
		this.changeSelected(false);
	}
}
