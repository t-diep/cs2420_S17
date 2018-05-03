
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
 * This code is an abstract base class for all versions of quicksort.
 * 
 * 
 * Write Quick sort using a single array(list) and doing it in place
 * 
 * Instrument it to allow the changing of the Insertion Sort Switch over
 * 
 */
public abstract class Quick_Sort<Type extends Comparable<? super Type>> implements Sorter<Type> 
{
	double GAP = 4; // must be greater than 3...

	/**
	 * create a field for the insertion sort switchover level
	 */

	/**
	 * Choose a Pivot (return it's value in the array) Modify array as
	 * appropriate (e.g., median of three will move smallest value to front of
	 * array)
	 *
	 * @param array
	 *            - the array of all values (we only sort a sub piece of the
	 *            array)
	 * @param start
	 *            - the start position in the (sub) array
	 * @param end
	 *            - the end position in the (sub) array
	 * @return the pivot value
	 */
	protected abstract Type choose_pivot(ArrayList<Type> array, int start, int end);	
	
	/**
	 * Given an array, partition the array such that all the elements lower than
	 * or equal to the pivot are on the left, all the elements greater than the
	 * pivot are on the right.
	 * 
	 * @param array
	 *            - data data to sort
	 * @param left
	 *            - the start index of the sub array (inclusive)
	 * @param right
	 *            - the end index of the sub array (inclusive)
	 * 
	 * @return the location of the pivot
	 */
	protected int partition(ArrayList<Type> array, int left, int right) 
	{  
		Type pivot = choose_pivot(array,left,right);
		
		int leftIndex = left;
		int rightIndex = right - 1;
		
		while (leftIndex <= rightIndex) 
		{ 
			while (array.get(leftIndex).compareTo(pivot) < 0) 
			{ 
				leftIndex++;
			}
			while (array.get(rightIndex).compareTo(pivot) >= 0 && rightIndex > 0) 
			{ 
				rightIndex--;
			}
			
			if (leftIndex < rightIndex) 
			{
				Sorter.swap(array, leftIndex, rightIndex);
				leftIndex++;
				rightIndex--;
			}
			
			if(leftIndex == rightIndex)	break;
		}
		
		Sorter.swap(array, leftIndex, right);
		return leftIndex;
	}

	/**
	 * The actual Quick Sort on an Array routine.
	 * 
	 * Algorithm: 1) choose a pivot (store in first bucket for convenience) 2)
	 * o) move all elements higher than the pivot to the right side of the array
	 * o) move all elements lower than the pivot to the left side of the array
	 * 3) put the pivot back between upper and lower group 4) sort left side 5)
	 * sort right side (WARNING: don't sort pivot again)
	 * 
	 * @param array
	 *            - data to be sorted
	 * @param start
	 *            is the index of the beginning element
	 * @param end
	 *            is the index of the last element
	 * 
	 * 
	 */
	private void quick_sort(ArrayList<Type> array, int start, int end) {
		// 1) partition array
		// 2) sort left
		// 3) sort right (again, don't resort the pivot
		
		if (end - start <= GAP) {
			Sort_Utils.insertion_sort(array, start, end);
		} else {
			int Mid_position = partition(array, start, end);
			quick_sort(array, start, Mid_position - 1); // quick_sort is
														// recursive
			quick_sort(array, Mid_position + 1, end);
		}

		// If size <= Insertion point
		// • Sort_Utils.insertion_sort(array,start,end)
		// •Mid_position = partition(array, start, end)
		// •Quick_sort( array, start, mid-1)
		// •Quick_sort( array, mid+1, end)
	}

	/**
	 * the sort interface method.
	 * 
	 * call quicksort on the array
	 * 
	 */
	public void sort(ArrayList<Type> array) {
		quick_sort(array, 0, array.size() - 1); // correct that it is -1?
	}

	/**
	 * Name the sort
	 */
	public String name_of_sort() {
		return "Quick Sort";
	}

	/**
	 * The constant in this case is the insertion sort cutoff level... always
	 * greater than 3
	 */
	public void set_constant(double constant) {
		if(constant < 2)
		{
			constant = 2;
		}
		
		this.GAP = constant;
	}

	/**
	 * @return the expected complexity for quick sort
	 */
	public Complexity_Class get_expected_complexity_class() {
		return Complexity_Class.NLOGN;
	}

}
