
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
 * test quick sort just choosing the first value as the pivot.
 */
public class Quick_Sort_Inplace_First_Pivot <Type extends Comparable<Type>> extends Quick_Sort<Type>
{
	/**
	 * First_Pivot
	 * 
	 * 1) choose the first element in the array as the pivot 2) Place this
	 * element at array[end]
	 * 
	 * @param array
	 *            = the array with all the data (we sort a sub piece of the
	 *            array)
	 * @param start
	 *            = index of start of array
	 * @param end
	 *            = index of end of array
	 */
	protected Type choose_pivot(ArrayList<Type> array, int start, int end) 
	{	
		Sorter.swap(array, end, start);
		return array.get(end);
	}

	/**
	 * Name the sort
	 */
	public String name_of_sort() 
	{
		return "Quick_Sort_Inplace_First_Pivot, with insertion cutoff " + super.GAP;
	}
}
