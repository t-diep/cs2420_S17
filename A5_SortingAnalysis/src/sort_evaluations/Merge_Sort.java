
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
 * @author Tony Diep
 *
 */

/**
 * @author H. James de St. Germain, Cindy Liao, Tony Diep
 * @date Spring 2017
 * 
 *       regular merge sort
 */
public class Merge_Sort<Type extends Comparable<? super Type>> implements Sorter<Type>																	
{
	/**
	 * FIXME: have a value for switching over to insertion sort
	 */
	boolean isInsertionSort;

	double cutoff;

	/**
	 * Returns the name of the sort
	 */
	public String name_of_sort() 
	{
		return "Merge Sort";
	}

	/**
	 * Merge Sort
	 * 
	 * split array in half sort left sort right combine
	 * 
	 * 
	 * @param array
	 *            the values to sort from small to high
	 * @param low
	 *            the index of the starting value in the "virtual array"
	 * @param high
	 *            the index of the ending value in the "virtual array"
	 * 
	 */
	private void merge_sort(ArrayList<Type> array, ArrayList<Type> auxillary, int low, int high) {
		if (high - low < cutoff) {
			Sort_Utils.insertion_sort(array, low, high);
			return;
		}

		if(low < high)
		{
			int mid = low + ((high - low) / 2);

			merge_sort(array, auxillary, low, mid);
			merge_sort(array, auxillary, mid + 1, high);
			combine(array, auxillary, low, mid, high);
		}
	}

	/**
	 * combine the values in array into the auxiliary
	 * 
	 * @param array
	 *            - original values (the entire array)
	 * @param auxillary
	 *            - spare space
	 * @param low
	 *            - low,mid are the lower array
	 * @param mid
	 *            - mid,high are the upper array
	 * @param high
	 * 
	 *            combine the sub arrays in the _array_ parameter. use the
	 *            _auxillary_ parameter for scratch space
	 */
	protected void combine(ArrayList<Type> array, ArrayList<Type> auxillary, int low, int mid, int high) {
		int leftPointer = low;
		int rightPointer = mid + 1;
		
		for(int index = low; index <= high; index++)
		{
			auxillary.add(index, array.get(index));
		}
		
		while(leftPointer <= mid && rightPointer <= high)
		{
			if(auxillary.get(leftPointer).compareTo(auxillary.get(rightPointer)) <= 0)
			{
				array.set(low, auxillary.get(leftPointer));
				leftPointer++;
			}
			else
			{
				array.set(low, auxillary.get(rightPointer));
				rightPointer++;
			}
			
			low++;
		}
		
		while(leftPointer <= mid)
		{
			array.set(low, auxillary.get(leftPointer));
			low++;
			leftPointer++;
		}
	}
	
	/**
	 * Allow the insertion sort cut off to be changed
	 */
	public void set_constant(double cutoff) 
	{
		this.cutoff = cutoff;
	}

	/**
	 * Returns the expected big o complexity of merge sort
	 */
	@Override
	public Complexity_Class get_expected_complexity_class() 
	{
		return Complexity_Class.NLOGN;
	}

	/**
	 * Calls the respective sorting algorithm
	 */
	@Override
	public void sort(ArrayList<Type> array) 
	{
		ArrayList<Type> auxillary = new ArrayList<Type>();
		merge_sort(array, auxillary, 0, array.size() - 1);
	}
}
