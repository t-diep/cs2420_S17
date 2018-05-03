package cs2420;

import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;

/**
 * Timing class to test how many the BST reacts to varying N size collections,
 * and the cost to find all elements within a BST of varying sizes.
 * 
 * @author Tony Diep, Gabbie Hoyer, last updated 3-3-17
 *
 *         last update: 3/3/17
 */
public class Timing {
	static long startTime;
	static long totalTime;

	// turn each test on or off
	static boolean getSortedAddTiming = true;
	static boolean getContainsSortedTiming = true;
	static boolean getRandomAddTiming = true;
	static boolean getContainsRandomTiming = true;
	static boolean startTreeSetRandom = true;
	static boolean startTreeSetSorted = true;

	static final int POWER = 10;// 2^10 is the initial size to test
	static final int TESTS = 11;// How many tests shall we do?
	static final int ITERATIONS = 1;// How many times per test shall we do
									// something

	public static void main(String[] args) 
	{

		// Create two BST's for experimenting
		BinarySearchTree<Integer> rightHeavy = new BinarySearchTree<Integer>();
		BinarySearchTree<Integer> randomBST = new BinarySearchTree<Integer>();

		//
		TreeSet<Integer> theTreeSet = new TreeSet<Integer>();

		System.out.println("\t\tContains");
		System.out.println("Size\t\t\tSorted order\t\t\tRandom order");

		startTime = System.nanoTime();
		while (System.nanoTime() - startTime < 1_000_000_000)
			;

		for (int test = 0; test < TESTS; test++) 
		{
			int size = (int) Math.pow(2, POWER + test);
			int index = 0;// used for elements in adding all to sorted
			long timetoAddSorted = 0;
			long timetoFindAllItemsSorted = 0;
			long timetoFindAllItemsRandom = 0;
			long timetoAddRandom = 0;
			long timeTreeSetSorted = 0;
			long timeTreeSetUnsorted = 0;

			ArrayList<Integer> randomList = getRandomList(size);

			for (int iter = 0; iter < ITERATIONS; iter++) 
			{
				// Tests for adding sorted data to a BST
				if (getSortedAddTiming) 
				{
					try {
						index = 0;
						for (; index < size; index++) 
						{

							// Using recursion for the nodes insert will
							// overflow after 32768 elements
							if (size >= 32768) 
							{
								getContainsSortedTiming = false; // no need for
																	// this test
																	// with an
																	// empty BST
								break;
							}

							startTime = System.nanoTime();
							{
								rightHeavy.add(index);
							}
							totalTime = System.nanoTime() - startTime;

							timetoAddSorted += totalTime;
						}
					} catch (StackOverflowError e) 
					{
						System.out.println(
								"StackOverFlow Error: Target size - " + size + ", Size before overflow - " + index);
					}

					// add all random
					if (getRandomAddTiming) 
					{
						try 
						{
							index = 0;
							for (; index < size; index++)
							{
								int item = randomList.get(index);

								startTime = System.nanoTime();
								{
									randomBST.add(item);
								}
								totalTime = System.nanoTime() - startTime;

								timetoAddRandom += totalTime;
							}
							randomBST.clear();
						} catch (StackOverflowError e) {
							System.out.println("StackOverFlow Error when adding " + size + " elements to a randomBST");
						}
					}
					
					// must be a sub test, so we can make use of the created
					// BST
				if (getContainsSortedTiming) 
				{
						index = 0;
						for (; index < size; index++) 
						{

							startTime = System.nanoTime();
							{
								rightHeavy.contains(index);
							}
							totalTime = System.nanoTime() - startTime;

							timetoFindAllItemsSorted += totalTime;
						}
					}

					rightHeavy.clear();
				}

				if (getRandomAddTiming) 
				{
					try {
						index = 0;
						for (; index < size; index++) {
							int item = randomList.get(index);

							startTime = System.nanoTime();
							{
								randomBST.contains(item);
							}
							totalTime = System.nanoTime() - startTime;

							timetoAddRandom += totalTime;
						}
						randomBST.clear();
					} catch (StackOverflowError e) {
						System.out.println("StackOverFlow Error when adding " + size + " elements to a randomBST");
					}
				}
			
				
				if (startTreeSetSorted) 
				{
					try 
					{
						index = 0;
						for (; index < size; index++) 
						{
							// Using recursion for the nodes insert will
							// overflow after 32768 elements
							if (size >= 32768) 
							{
								getContainsSortedTiming = false; // no need for
																	// this test
																	// with an
																	// empty BST
								break;
							}

							startTime = System.nanoTime();
							{
								theTreeSet.add(index);
							}
							totalTime = System.nanoTime() - startTime;

							timeTreeSetSorted += totalTime;
						}

						theTreeSet.clear();
					} 
					catch (StackOverflowError e)
					{
						System.out.println(
								"StackOverFlow Error: Target size - " + size + ", Size before overflow - " + index);
					}
				}

				// add all random
				if (startTreeSetRandom) 
				{
					try 
					{
						index = 0;
						for (; index < size; index++) 
						{
							int item = randomList.get(index);

							startTime = System.nanoTime();
							{
								theTreeSet.add(item);
							}
							totalTime = System.nanoTime() - startTime;

							timeTreeSetUnsorted += totalTime;
						}
						randomBST.clear();
					} 
					catch (StackOverflowError e) 
					{
						System.out.println("StackOverFlow Error when adding " + size + " elements to a randomBST");
					}
				}

			}
			timeTreeSetSorted /= ITERATIONS;
			timeTreeSetUnsorted /= ITERATIONS;
			timetoAddSorted /= ITERATIONS;
			timetoFindAllItemsSorted /= ITERATIONS;
			timetoAddRandom /= ITERATIONS;
			timetoFindAllItemsRandom /= ITERATIONS;

			System.out.println(size + "\t\t\t" + timetoFindAllItemsSorted + "\t\t\t" + timetoFindAllItemsRandom);
		}
	}

	/**
	 * Creates a sorted array list
	 * 
	 * @param size
	 *            - desired size of the list
	 * @return - array list with items in order
	 */
	private static ArrayList<Integer> getSortedList(int size) 
	{
		ArrayList<Integer> result = new ArrayList<Integer>();

		for (int index = 0; index < size; index++) {
			result.add(index);
		}

		return result;
	}

	/**
	 * Creates a random sorted array
	 * 
	 * @param size
	 *            - specified size of the list
	 * @return - array of shuffled unique elements
	 */
	private static ArrayList<Integer> getRandomList(int size) 
	{
		ArrayList<Integer> result = getSortedList(size);

		Collections.shuffle(result);

		return result;
	}
}
