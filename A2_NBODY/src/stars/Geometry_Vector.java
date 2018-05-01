
/**
 * 
 */
package stars;

import java.awt.geom.Point2D;

/**
 * @author germain
 *
 */

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
public class Geometry_Vector extends Point2D.Double
{	
  /**
   *
   * Constructor
   *
   * @param x - the X 
   * @param y - and Y values
   */
  public  Geometry_Vector(double xx, double yy)
  {
	  this.x = xx;
	  this.y = yy;
  }

  /**
   *
   * A "Copy" constructor. Create ourself based on the given vector
   * @param the_copy 
   */
   public  Geometry_Vector(Geometry_Vector the_copy)
   {
	   this.x = the_copy.x;
	   this.y = the_copy.y;
   }

  /**
   * Add the components of the given vector to me.
   *
   * @param vector
   */
  public void add_to_me(Geometry_Vector vector)
  {
	  this.x += vector.getX();
	  this.y += vector.getY();
  }

  /**
   * Subtract the components of the given vector from me.
   * @param vector
   */
  public void subtract_from_me(Geometry_Vector vector)
  {
	 this.x -= vector.getX();
	 this.y -= vector.getY();
	 
  }

  /**
   * Divide my components by the scalar
   * @param scalar
   */
  public void divide_by( double scalar )
  {
	 if(scalar == 0)
	 {
		 return;
	 }
	  
	 this.x /= scalar;
	 this.y /= scalar;	 
  }

  /**
   * Multiply my components by the scalar
   * @param scalar
   */
  public  void   multiply_me_by(double scalar)
  {
	  this.x *= scalar;
	  this.y *= scalar;
  }

  /**
   * @return my magnitude (the distance from the origin to my X,Y)
   * Think Pythagoras
   */
  public  double  magnitude()
  {
	  return Math.sqrt(Math.pow(this.x, 2.0) + Math.pow(this.y, 2.0));
  }

  /**
   * @return an informative (but concise) description of this object
   */
  public  String toString()
  {
	  return "<" + this.x + ", " + this.y + ">";
  }

  /**
   * Take this vector and turn it into a vector of length 1.  This is done by
   * dividing each component (i.e., x,y)  by the magnitude.
   */
  public   void   normalize()
  {
	  this.divide_by(magnitude());
  }
  
}
