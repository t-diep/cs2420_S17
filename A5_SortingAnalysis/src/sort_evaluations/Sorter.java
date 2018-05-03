package sort_evaluations;

import java.util.ArrayList;

/**
 * Tony Diep
 * u0934661
 * 2/19/17 
 * 2420 
 * Assignment 5
 * Partner: Cindy Liao
 * u0627241 
 * 
 * I pledge that the work done here was my own and that I have learned how to
 * write this program, such that I could throw it out and restart and finish it
 * in a timely manner. I am not turning in any work that I cannot understand,
 * describe, or recreate. I further acknowledge that I contributed substantially
 * to all code handed in and vouch for it's authenticity. 
 * 
 * Tony Diep
 * 
 * @author Tony Diep, Cindy Liao
 *
 */

/**
 * @author H. James de St. Germain
 * @date   Spring 2007
 * 
 * This interface allows a sort routine to be tested by turning the
 * sort into a "functor".  All the sorts of interest must
 * be created to follow the functions required by this interface. 
 *
 */
public interface Sorter<Type extends Comparable<? super Type>>
{
  /**
   * put the array list in order from smallest to largest
   * @param array - an array of comparable objects
   */
  public abstract void sort(ArrayList<Type> array);
  
  /**
   * for testing purposes, get the name of the sort
   * @return the name of the sort
   */
  public abstract String name_of_sort();
  
  /**
   * If you want to change the behavior of the sort, such as for
   * quicksort, changing, the insertion sort cutoff or for 
   * shell sort, the gap size.
   * 
   * @param constant - any one constant in an algorithm
   */
  public default void set_constant(double constant)
  {
	// the default case is to do nothing....
  }

  /**
   * @return the expected complexity class of the sort
   * 
   * For example, NLogN, NSquared, etc.
   */
  public abstract Complexity_Class get_expected_complexity_class();


  /**
   * Swaps two given values in an ArrayList
   * 
   * @param array -- the ArrayList
   * @param from -- the first index 
   * @param to -- the other index
   */
  public static <Type> void swap(ArrayList<Type> array, int from, int to)
  {
	  //Swapping
	  Type temp = array.get(from);
	  array.set(from, array.get(to));
	  array.set(to, temp);
  }
}
