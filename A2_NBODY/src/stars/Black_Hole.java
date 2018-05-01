package stars;

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
public class Black_Hole extends Satellite 
{
	/**
	 * 
	 * The black hole constructor
	 * @param x  - where (in 2D) we are in the solar system
	 * @param y  - where (in 2D) we are in the solar system
	 * @param velocity_x - how fast in 2D we are moving in meters per second
	 * @param velocity_y - how fast in 2D we are moving in meters per second
	 * @param mass - how big we are (in kilograms)
	 * 
	 */
	public Black_Hole(double x, double y, double this_mass, String this_name) 
	{
		super(x, y, 0, 0, this_mass, 0, this_name); 
	}
	/**
	 * 
	 * Draws black hole to the GUI.
	 * 
	 */
	@Override
	public void paintComponent(Graphics g) 
	{	
		g.fillOval(0, 0, getWidth(), getHeight());
	}
	/**
	 * 
	 * Sets the default size of black hole.
	 * 
	 */
	@Override
	protected void update_display_size(double raidus_of_system)
	{
		this.setSize(10,10);
	}
}
