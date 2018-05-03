/**
 *@author Tony Diep
 *@uid u0934661
 *@date 9 February 2017
 *@classnumber (2420)
 *@assignmentnumber 4
 *@partner Gabbie Hoyer
 *	I pledge that the work done here was my own and that I have learned how to write this program, 
 *	such that I could throw it out and restart and finish it in a timely manner. I am not turning 
 *	in any work that I cannot understand, describe, or recreate. I further acknowledge that I contributed 
 *	substantially to all code handed in and vouch for it's authenticity. (Tony Diep)
 */
package assignment04;

import java.util.Random;

/**
 * The main application; performs timing experiments
 * 
 * @author Tony Diep, Gabbie Hoyer, last updated 2-9-17
 */
public class Main 
{
	//The billion constant
	static final int BILLION = 1_000_000_000;
	//The million constant
	static final int MILLION = 1_000_000;
	
	public static void main(String[] args)
	{
		//Warm up the computer before performing timing experiments
		long startComputerTime = System.nanoTime();
		while(System.nanoTime() - startComputerTime < BILLION)
		{
			
		}
	
		//Timing variables for each timing experiment
		long totalTime = 0;
		long totalTimeInsertionSortInts = 0;
		long totalTimeInsertionSortStrings = 0;
		
		//Print header
		System.out.println("getLargestAnagramGroup \t" + "insertionSortInt \t" + "insertionSortString \t");
		
		for(int iter = 0; iter < 100; iter++)
		{
			//Timing experiment for getLargestAnagramGroup
			long start = System.nanoTime();
			String[] words = AnagramUtil.getLargestAnagramGroup("Resources/moderate_word_list");
			long stop = System.nanoTime();
			totalTime += stop - start;
			
			//Timing experiment for insertion sort for Integers
			long startInsertionSort = System.nanoTime();
			AnagramUtil.insertionSort(generateRandomInts(20), AnagramUtil.intComparator);
			long stopInsertionSort = System.nanoTime();
			totalTimeInsertionSortInts += stopInsertionSort - startInsertionSort;
			
			//Timing experiment for insertion sort for Strings
			long startInsertionSortStrings = System.nanoTime();
			AnagramUtil.insertionSort(words, AnagramUtil.stringComparator);
			long stopInsertionSortStrings = System.nanoTime();
			totalTimeInsertionSortStrings += stopInsertionSortStrings - startInsertionSortStrings;
		}
		
		//Variables to hold the average time 
		double averageTimeInNanoSeconds = (totalTime) / (double) 1_000_000;
		double averageTimeInsertionSort = (totalTimeInsertionSortInts) / (double) 1_000_000;
		double averageTimeInsertionSortStrings = (totalTimeInsertionSortStrings) / (double) 1_000_000;
		
		//Print results from timing experiments
		System.out.println(averageTimeInNanoSeconds + "\t\t" + averageTimeInsertionSort + "\t\t" + averageTimeInsertionSortStrings); 
	}
	
	/**
	 * Creates a String array holding random words
	 * 
	 * @param numOfWords -- number of words we want to add to our array
	 * @return a string array containing all of the random words
	 */
	public static String[] generateRandomWords(int numOfWords)
	{
		String[] someRandomWords = new String[numOfWords];
		Random generator = new Random();
		
		for(int index = 0; index < someRandomWords.length; index++)
		{
			char[] charArray = new char[generator.nextInt(9) + 3];
			for(int chars = 0; chars < someRandomWords.length; chars++)
			{
				charArray[chars] = (char) ('a' + generator.nextInt(26));
			}
			someRandomWords[index] = new String(charArray);
		}
		
		return someRandomWords;
	}
	
	/**
	 * Creates a Integer array holding random integers
	 * 
	 * @param numOfInts -- number of integers 
	 * @return a string array containing all of the random words
	 */
	public static Integer[] generateRandomInts(int numOfInts)
	{
		Integer[] someRandomInts = new Integer[numOfInts];
		Random generator = new Random();
		
		for(int index = 0; index < someRandomInts.length; index++)
		{
			int[] intArray = new int[someRandomInts.length];
			for(int num = 0; num < someRandomInts.length; num++)
			{
				intArray[num] = generator.nextInt(numOfInts);
			}
			someRandomInts[index] = new Integer(intArray[index]);
		}
		
		return someRandomInts;
	}
}
