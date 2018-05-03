
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
 * @author germain, Tony Diep
 *
 */
public class Insertion_Sort<Type extends Comparable<? super Type>> implements Sorter<Type>
{	
	/**
	 * Returns the name of the sort
	 */
	public String name_of_sort()
	{
		return "Insertion Sort";
	}

	/**
	 * No effect on insertion sort
	 * Prints a debug message saying this is ignored 
	 */
	public void set_constant( double constant )
	{
		System.out.println("The constant " + constant + " is ignored");
	}

	/**
	 * Utilizes the insertion sort 
	 */
	@Override
	public void sort(ArrayList<Type> array) 
	{
		Sort_Utils.insertion_sort(array, 0, array.size()-1);
	}

	/**
	 * Returns the big O complexity of insertion sort
	 * @return the expected complexity of this algorithm
	 */
	public Complexity_Class get_expected_complexity_class()
	{
		return Complexity_Class.NSQUARED;
	}
}
