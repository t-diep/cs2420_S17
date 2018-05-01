package stars;

import java.awt.Color;
import java.awt.Graphics;

/**
 *@author Anthony Diep
 *@uid u0934661
 *@date 26 January 2017
 *@classnumber (2420)
 *@assignmentnumber 2
 *@partner Ed Stephen Ancajas
 *	I pledge that the work done here was my own and that I have learned how to write this program, 
 *	such that I could throw it out and restart and finish it in a timely manner. I am not turning 
 *	in any work that I cannot understand, describe, or recreate. I further acknowledge that I contributed 
 *	substantially to all code handed in and vouch for it's authenticity. (Anthony Diep)
 */
@SuppressWarnings("serial")
public class Flotsam extends Satellite
{

	/**
	 *  
	 * A constructor for Flotsam.
	 * 
	 * @param x - the x location of this Flotsom
	 * @param y - the y location of this Flotsom
	 * @param velocity_x - how fast in 2D we are moving per second
	 * @param velocity_y - how fast in 2D we are moving per second.
	 */
	public Flotsam(int x, int y, int velocity_x, int velocity_y)
	{
		super(x, y, velocity_x, velocity_y, 100, 100, "Flotsam");
		this.setForeground(Color.gray);
	}
	/**
	 * 
	 * Paints the Flotsom to the GUI.
	 */
	@Override
	public void paintComponent( Graphics g )
	{
		g.fillOval(0, 0, getWidth(), getHeight());
	}
	/** 
	 * Sets the size of the Flotsom.
	 */
	@Override
	protected void update_display_size(double radius_of_system) 
	{
		this.setSize(6, 6);
	}
}
