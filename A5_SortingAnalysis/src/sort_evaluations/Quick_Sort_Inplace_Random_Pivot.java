
package sort_evaluations;
import java.util.ArrayList;
import java.util.Random;

/**
 * Tony Diep
 * u0934661
 * 2/17/17 
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
 * @author Tony Diep
 *
 */
/**
 * Represents the quick sort algorithm using random pivot
 */
public class Quick_Sort_Inplace_Random_Pivot<Type extends Comparable<Type>> extends Quick_Sort<Type>
{
	/**
	 * Random_Pivot
	 * 
	 * 1) Choose an element at random in the array and use it as pivot 2) Place
	 * this element at array[end]
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
		Random generator = new Random();
		
		int randomIndex = generator.nextInt(end-start +1) + start;
		
		Sorter.swap(array, randomIndex, end);

		return array.get(end);
	}

	/**
	 * Name the sort
	 */
	public String name_of_sort() 
	{
		return "Quick_Sort_Inplace_Random_Pivot";
	}
}
