
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
 *  use the median of three technique to compare vs random pivot selection, etc.
 */
public class Quick_Sort_Inplace_M3<Type extends Comparable<Type>> extends Quick_Sort<Type> 
{
	/**
	 * Median of Three (choose the middle element position)
	 * 
	 * WARNING: this not only chooses the pivot, but modifies the position of the three elements.
	 * 
	 * 1) Choose 3 elements from the array (start, middle, end)
	 * 2) Place the median element at array[end-1]
	 * 3) Place low element at array[start]
	 * 4) Place high element at array[end]
	 * 
	 * You shouldn't call this method when the array is smaller than 3 elements
	 * 
	 * @param array the array with all the data (we sort a sub piece of the array)
	 * @param start  = index of start of array
	 * @param end    = index of end of array
	 */
	protected Type choose_pivot(ArrayList<Type> array, int start, int end )
	{
		if(array.size() < 3)
		{
			return null;
		}

		int middle = (start + end + 1) / 2;
		
		Type first = array.get(start);
		Type second = array.get(middle);
		Type third = array.get(end);
		
		ArrayList<Type> temp = new ArrayList<Type>();
		temp.add(first);
		temp.add(second);
		temp.add(third);
		
		Sort_Utils.insertion_sort(temp, 0, 2);
		
		array.set(start, temp.get(0));
		array.set(middle, temp.get(1));
		array.set(end, temp.get(2));
		
		//Relocate middle element to the second to last spot 
		Sorter.swap(array, end, middle);
		Sorter.swap(array, end - 1, middle);

		return array.get(end);	
	}

	/**
	 * Name the sort
	 */
	public String name_of_sort()
	{
		return "Quick_Sort_Inplace_M3 with insertion cutover cost " + super.GAP;
	}
}
