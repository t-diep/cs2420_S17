package stars;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

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
public class Star extends Satellite
{	
  boolean telling;
  Color color;

	public Star(double x, double y, double velocity_x, double velocity_y, double mass, double radius, String name) 
	{
		super(x, y, velocity_x, velocity_y, mass, radius, name);
		telling = !telling;
	}
	/**
	 * 
	 * Is a method that sets colors
	 * and changes after an action its called.
	 * 
	 */
	@SuppressWarnings("static-access")
	public void super_nova()
	{
		if ( telling == true )
		{
			color = color.red;	
		} else {
			color = color.YELLOW;
		}		
		telling = !telling;
	}
	/**
	 * 
	 * Composes super nova. When super_nova is called the
	 * color will flicker red.
	 * 
	 */
	@Override
	public void paintComponent( Graphics g )
	{
		if( telling == true)
		{
			g.setColor(color);
			g.fillOval(0, 0, this.getWidth(), this.getHeight());
		} else {
			g.setColor(color);
			g.fillOval(0, 0, this.getWidth(), this.getHeight() * new Random().nextInt(2));
		}
	}
	/**
	 * 
	 * Sets the size of the sun in respect to the radius of the 
	 * solar system.
	 * 
	 */
	protected void update_display_size(double radius_of_system)
	{
		double newRadius = this.radius / (radius_of_system / 60_000);
		this.setSize((int)newRadius, (int)(newRadius));
			
	}
}
