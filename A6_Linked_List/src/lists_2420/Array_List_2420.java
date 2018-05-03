package lists_2420;

import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * This array list implements the List_2420 interface, but will only be used to store Integers.
 * To obtain constant add first, add last, remove first, and remove last functionality
 * this array wraps values, and uses a backing array. The virtual array will derive
 * from values in the backing array.
 * 
 * Note: All calls to add first begin at this lists length-1 - (calls made to add first). 
 * 
 * Note: Values added using add last start at index 0 +  (call made to add last) and so on.
 * 
 * Visual aid:
 * 	Indices: 1 ... 5 6 7 8 9 0 1 2 3 4 ... the backing array's length
 *                         ^ ^
 *            Note: The carrots indicate pointers
 *            
 *  The starting pointer of the virtual array will move post add_first call
 *  
 *  Indices: 1 ... 5 6 7 8 9 0 1 2 3 4 ... the backing array's length
 *                       ^   ^
 * 
 * The pointers track where each half begins (or ends), they will not overlap as the list
 * expands before the list runs out of space to store elements.
 *  
 * @author Andrew Worley, Tony Diep
 * 
 * last update 2/23/17
 *
 */
public class Array_List_2420 implements List_2420<Integer> 
{	
	private int size;//size of the virtual array
	private int startPointer;//starting index of the virtual array
	private int endPointer;//ending index of the virtual array
	public Integer[] backingArray;//public for testing
	
	public Array_List_2420() 
	{
		this.backingArray = new Integer[1024];
		this.size = 0;
		this.startPointer = 0;
		this.endPointer = 0;
	}

	/**
	 * Checks if the size of this array is full
	 */
	private void checkSize()
	{
		if(size == backingArray.length)
		{
			expand();
		}
	}
	
	/**
	 * Expands the array when the current array is full 
	 */
	public void expand()
	{
		Integer[] newData = new Integer[backingArray.length * 2];
		
		for(int index = 0; index < backingArray.length; index++)
		{
			newData[index] = backingArray[wrapIndex(index + startPointer)];
		}
		
		startPointer = 0;
		endPointer = backingArray.length;
		backingArray = newData;
	}
	
	
	/**
	 * Converts the current index to an index that is in bounds
	 * of the array
	 */
	private int wrapIndex(int currIndex)
	{
		if(currIndex < 0)
		{
			return currIndex + backingArray.length;
		}
		
		return currIndex % backingArray.length;
	}
	
	/**
	 * Converts an index that is outside of the bounds of the
	 * array to an equivalent index that is in bounds of the array
	 * 
	 * @param currIndex -- an offset index
	 * @return an in bounds index equivalent to current index
	 */
	private int convertOffsetToIndex(int currIndex)
	{
		return wrapIndex(startPointer + currIndex);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void add_first(Integer data) 
	{
		checkSize();
		startPointer = wrapIndex(startPointer - 1);	
		this.backingArray[startPointer] = data;
		size++;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void add_last(Integer data) 
	{
		this.backingArray[endPointer] = data;
		endPointer = wrapIndex(endPointer + 1);
		size++;
	}

	/**
	 * Add an element after the specified index within the array list
	 * 
	 * If the list contains no data, then this will data will be the first
	 * item in the list.
	 * 
	 * @param after - the index in which data will be added after
	 * @param data - value to be added to the list
	 */
	@Override
	public void add_middle(int after, Integer data) 
	{
		int insertIndex = convertOffsetToIndex(after + 1);
		
		if(after >= size)
		{
			after = size;
			insertIndex = convertOffsetToIndex(after);
		}
		
		addAt(insertIndex, data);
	}
	
	/**
	 * Adds a value to a specified index location 
	 */
	public void addAt(int insertIndex, int value)
	{
		checkSize();
		
		for(int index = wrapIndex(endPointer - 1); index != insertIndex; index = wrapIndex(--index))
		{
			backingArray[wrapIndex(index + 1)] = backingArray[index];
		}
		
		backingArray[insertIndex] = value;
		endPointer = wrapIndex(endPointer + 1);
		size++;
	}
	
	/**
	 * Clear the list and reset the size
	 * 
	 * Note: list retains current length
	 */
	@Override
	public void clear() 
	{
		startPointer = 0;
		endPointer = 0;
		size = 1;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean contains(Integer item) 
	{
		for(int offset = 0; offset < size; offset++)
		{
			if(backingArray[convertOffsetToIndex(offset)] == item)
			{
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean contains_recursive(Integer item) 
	{
		if (size == 0) 
		{
			return false;
		}
		
		//check the left hand side of the virtual array for our item
		if (contains_recursive(this.startPointer, this.backingArray.length-1, item) != null) {
			return true;
		}
		//check the right hand side of the virtual array for our item
		if (contains_recursive(0, this.endPointer, item) != null) {
			return true;
		}
		
		//didn't find it
		return false;
	}
	
	/**
	 * The recursive method to find an element within an array section.
	 * The index given will increment to the bound given.
	 * 
	 * @param index - the starting search point
	 * @param bound - where we stop (inclusive)
	 * @param item - the item we are looking for
	 * 
	 * @return - the item if found, null if not
	 */
	private Integer contains_recursive(int index, int bound, Integer item) {
		if (index > bound) {
			return null;
		}
		
		if (this.backingArray[index] != null &&
		    this.backingArray[index].equals(item)) {
			return item;
		}
		
		return contains_recursive(index+1, bound, item);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer get_first() throws NoSuchElementException
	{
		if (size == 0) 
		{
			throw new NoSuchElementException();
		}
		
		return backingArray[startPointer];
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer get_last() throws NoSuchElementException 
	{
		if (size == 0) 
		{
			throw new NoSuchElementException();
		}
		
		return backingArray[endPointer];
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer remove_first() throws NoSuchElementException 
	{
		if (size == 0) 
		{
			throw new NoSuchElementException();
		}
		
		Integer removedValue = backingArray[startPointer];
		startPointer = wrapIndex(startPointer + 1);
		size--;
		return removedValue;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer remove_last() throws NoSuchElementException 
	{
		if (size == 0) 
		{
			throw new NoSuchElementException();
		}
		
		Integer removedValue = backingArray[endPointer];
		endPointer = wrapIndex(endPointer - 1);
		this.size--;
		return removedValue;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int size() 
	{
		return this.size;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void reverse() 
	{
		
	}
	
	/**
	 * Implementation requires to just return the size of 
	 * this list.
	 * 
	 * @return - the size of the array list
	 */
	@Override
	public int compute_size_recursive() 
	{	
		return this.size;
	}

	/**
	 * Get an array list of values contained in this list, in reverse
	 * 
	 * @return - an array list containing values, in reverse, of this
	 * list.
	 */
	@Override
	public ArrayList<Integer> to_ArrayList_post_recurse() 
	{
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		if (size == 0) 
		{
			return result;
		}
		
		for (int index = this.endPointer; index <= 0; index--) 
		{
			if (this.backingArray[index] == null) {
				break;
			}
			
			result.add(this.backingArray[index]);
		}
		for (int index = this.backingArray.length-1; index >= this.startPointer; index--) {
			if (this.backingArray[index] == null) {
				break;
			}
			
			result.add(this.backingArray[index]);
		}
		
		return result;
	}
	
	/**
	 * Get an array list of values contained in this list
	 * 
	 * @return - an array list containing the value in this list
	 */
	@Override
	public ArrayList<Integer> to_ArrayList() 
	{
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		for(int offset = 0; offset < size; offset++)
		{
			result.add(backingArray[convertOffsetToIndex(offset)]);
		}
		
		return result;
	}
	
	/**
	 * Method gets the content of a virtual array derived from
	 * the elements in the backing array of this list.
	 * 
	 * @return - user friendly string displaying elements contained in list
	 */
	@Override
	public String toString() {
		String result = "[";
		
		if(size == 0) {
			return result += "]";
		}
		
		/* The following for loops are used to traverse the virtual array contained
		 * in the backing array.
		 */
		for (int index = this.startPointer; index < this.backingArray.length; index++) {
			if (this.backingArray[index] == null) {
				break;
			}
			
			result += this.backingArray[index] + ", ";
		}
		for (int index = 0; index <= this.endPointer; index++) {
			if (this.backingArray[index] == null) {
				break;
			}
			
			if (index < this.endPointer) {
				result += this.backingArray[index]+", ";
			}
			else {
				result += this.backingArray[index];
			}
		}
		
		//used for cases when add_last was never called
		if (result.endsWith(", ")) {
			result = result.substring(0, result.length()-2);
		}
		
		result += "]";
		
		return result;
	}
}
