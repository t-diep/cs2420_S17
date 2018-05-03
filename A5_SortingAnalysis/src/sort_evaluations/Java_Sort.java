
package sort_evaluations;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * @author Tony Diep
 * @uid u0934661
 * @date 19 February 2017
 * @classnumber (2420)
 * @assignmentnumber 5
 * @partner Cindy Lao
 * I pledge that the work done here was my own and that I have learned how to write this program, 
 * such that I could throw it out and restart and finish it in a timely manner. I am not turning 
 * in any work that I cannot understand, describe, or recreate. I further acknowledge that I contributed 
 * substantially to all code handed in and vouch for it's authenticity. (Tony Diep)
 * 
 * Represents Java's build in sorting algorithm for Collections such as ArrayLists 
 * This class will be used to compare our other implementations of the different sorting algorithms
 */
public class Java_Sort<Type extends Comparable<? super Type>> implements Sorter<Type>
{
	/**
	 * Sorts using Java's sort
	 */
	public void sort( ArrayList<Type> array )
	{
		array.sort(Comparator.naturalOrder());
	}

	/**
	 * Returns the name of this sort
	 */
	public String name_of_sort()
	{
		return "Java's Sort";
	}

	/**
	 * Prints a message that says that the Java's sort algorithm cannot be modified
	 * @param constant -- input value that doesn't do anything
	 */
	public void set_constant( double constant )
	{
		System.out.println("Sorry, your constant " + constant +  " could not modify Java's sorting algorithm");
	}

	/**
	 * Gets the expected complexity for Java's sorting algorithm
	 * @return the expected complexity for java's sorts
	 */
	@Override
	public Complexity_Class get_expected_complexity_class()
	{
		return Complexity_Class.NLOGN;
	}
}
