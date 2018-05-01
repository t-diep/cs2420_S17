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
public class Planet extends Satellite 
{
	/**
	 * @param x - where (in 2D) we are in the solar system
	 * @param y   - where (in 2D) we are in the solar system
	 * @param velocity_x - how fast in 2D we are moving in meters per second
	 * @param velocity_y - how fast in 2D we are moving in meters per second
	 * @param mass  - how big we are (in kilograms)
	 */
	public Planet(double x, double y, double velocity_x, double velocity_y, double mass, double radius, String name) 
	{
			super(x, y, velocity_x, velocity_y, mass, radius, name);
	}	
	/**
	 * 
	 * Draws the planets to the GUI
	 * 
	 */
	@Override
	public void paintComponent(Graphics g) 
	{
			g.fillOval(0, 0, this.getWidth(), this.getHeight());
	}
	/**
	 * 
	 * Sets the size of the planets. Special if and else function to compensate for 
	 * Saturn's and Neptune's mass.
	 * 
	 */
	protected void update_display_size(double radius_of_system) 
	{
		if (Solar_System_Facts.saturn_radius < radius_of_system) 
		{
			int newRadius = (int) (this.radius / radius_of_system * 2_000_000);
			this.setSize(newRadius, newRadius);
		} else {
			int newRadius = (int) (this.radius / radius_of_system * 1_000_000);
			this.setSize(newRadius, newRadius);
		}
	}
}
