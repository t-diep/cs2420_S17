package lists_2420;

import java.util.Random;

/**
 * Tony Diep
 * u0934661
 * 2/23/17 
 * 2420 
 * Assignment 6
 * Partner: Andrew Worley
 * 
 * 
 * I pledge that the work done here was my own and that I have learned how to
 * write this program, such that I could throw it out and restart and finish it
 * in a timely manner. I am not turning in any work that I cannot understand,
 * describe, or recreate. I further acknowledge that I contributed substantially
 * to all code handed in and vouch for it's authenticity. 
 * 
 * Tony Diep
 * 
 * @author germain, Tony Diep, Andrew Worley
 *
 * Performs timing experiments on ArrayList and LinkedList	
 */
public class Timing 
{
	static long startTime;
	static long endTime;
	static int howManyElements = 10;
	
	public static void main(String[] args) 
	{
		Linked_List_2420<Integer> linkedListInt = new Linked_List_2420<Integer>();
		Array_List_2420 arrayListInt = new Array_List_2420();
		
		Random generator = new Random();
		
		int randomIndexLinkedList = generator.nextInt(linkedListInt.size() + 1);
		int randomIndexArrayList = generator.nextInt(arrayListInt.size() + 1);
		
		System.out.println("Num of Elements \t\tTime for Linked List  \t\t Time for Array List");
		
		while(howManyElements < 10_000_000)
		{
			for(int index = 0; index < howManyElements; index++)
			{		
				//Timing experiment for Linked List
				long startTimeLinkedList = timer_on();
				linkedListInt.add_first(randomIndexLinkedList);
				//linkedListInt.add_middle(randomIndexLinkedList, index);
				linkedListInt.add_last(randomIndexLinkedList);
				//linkedListInt.remove_first();
				linkedListInt.remove_last();
				
				linkedListInt.clear();
			}
			long endTimeLinkedList = timer_off();
			
			double totalTimeLinkedList = get_time();
			
			for(int index = 0; index < howManyElements; index++)
			{
				//Timing experiment for Array List
				long startTimeArrayList = timer_on();
				arrayListInt.add_first(randomIndexArrayList);
				arrayListInt.add_last(randomIndexArrayList);
				//arrayListInt.add_middle(randomIndexArrayList, index);
				//arrayListInt.remove_first();
				arrayListInt.remove_last();
				
				arrayListInt.clear();
			}
			long endTimeArrayList = timer_off();
			
			double totalTimeArrayList = get_time();
			
			
			System.out.println("   " + howManyElements + "     \t\t\t  " + totalTimeLinkedList + "\t\t\t  " + totalTimeArrayList);
			
			howManyElements *= 10;
		}
	}
	
	/**
	 * start the timer
	 */
	public static long timer_on() 
	{
		startTime = System.nanoTime();
		
		return startTime;
	}

	/**
	 * turn off the timer
	 */
	public static long timer_off() 
	{
		endTime = System.nanoTime();
		
		return endTime;
	}

	/**
	 * get the time in seconds between on and off.
	 */
	public static double get_time() 
	{
		return (double) (endTime - startTime)/ 1_000_000_000;
	}
}
