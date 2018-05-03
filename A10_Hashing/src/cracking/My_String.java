/**
 * 
 */
package cracking;

/**
 * @author H. James de St. Germain
 * @date   Spring 2007
 * 
 * a dummy wrapper for a string to allow us experiment with hash functions
 */
public class My_String implements Comparable<My_String> 
{
  public String value;
  
  /**
   * @param name
   */
  public My_String(String name)
  {
    this.value = name;
  }

  /**
   * Our hash code algorithm
   * 
   * Accumulates each character in a string moded by 3
   * 
   * @return the hash code for the "value" field of the My_String
   */

  @Override
  public int hashCode()
  {
	  int temp = 0;
	  for(int i=0; i<value.length(); i++)
	  {
		  temp += (value.charAt(i))%3;
	  }
	  return temp;
	  
  }
  
  /**
   * string value equality
   */
  @Override
  public boolean equals( Object other )
  {
    if ( other instanceof My_String)
      {
        return this.value.equals(((My_String)other).value);
      }
    return false;
  }

  /* (non-Javadoc)
   * @see java.lang.Comparable#compareTo(java.lang.Object)
   */
  public int compareTo(My_String o)
  {
    return this.value.compareTo(o.value);
  }
  
  public String toString()
  {
    return this.value;
  }
  
}
