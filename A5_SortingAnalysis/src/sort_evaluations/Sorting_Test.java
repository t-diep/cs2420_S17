
package sort_evaluations;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

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
public class Sorting_Test 
{
	ArrayList<Integer> smallIntsAList;
	ArrayList<String> smallStringAList;
	ArrayList<String> expectedStringAList;
	ArrayList<Integer> expectedIntAList;

	//Set up Insertion sorts
	Insertion_Sort<Integer> insertionSortInt;
	Insertion_Sort<String> insertionSortString;
	
	//Set up Java sorts
	Java_Sort<Integer> javaSortInt;
	Java_Sort<String> javaSortString;
	
	//Set up Merge sorts
	Merge_Sort<Integer> mergeSortInt;
	Merge_Sort<String> mergeSortString;
	
	//Set up Quick Sorts
	Quick_Sort_Inplace_First_Pivot<Integer> quickSortInplaceFirstPivotInt;
	Quick_Sort_Inplace_First_Pivot<String> quickSortInplaceFirstPivotString;
	Quick_Sort_Inplace_M3<Integer> quickSortInplaceM3Int;
	Quick_Sort_Inplace_M3<String> quickSortInplaceM3String;
	Quick_Sort_Inplace_Random_Pivot<Integer> quicksortInplaceRandomPivot;
	Quick_Sort_Naive<Integer> quickSortNaiveInt;
	Quick_Sort_Naive<String> quickSortNaiveString;
	Quick_Sort<Integer> quickSort;
	
	//Set up Shell Sorts
	Shell_Sort<Integer> shellSortInt;
	Shell_Sort<String> shellSortString;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception 
	{
	
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception 
	{
	
	}

	/**
	 * Sets up arrays, ArrayLists, and all of the sorting classes for testing
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception 
	{		
		/**
		 * The String ArrayList used to test the different sorts 
		 * 
		 * ["word2", "word9", "word1", "word6", "word8", "word4", "word10", "word7", "word5", "word0", "word3"]
		 */
		smallStringAList = new ArrayList<String>();
		smallStringAList.add("word2");
		smallStringAList.add("word9");
		smallStringAList.add("word1");
		smallStringAList.add("word6");
		smallStringAList.add("word8");
		smallStringAList.add("word4");
		smallStringAList.add("word10");
		smallStringAList.add("word7");
		smallStringAList.add("word5");
		smallStringAList.add("word0");
		smallStringAList.add("word3");
		
		/**
		 * The Integer ArrayList used to test the different sorts
		 * 
		 * [5, 2, 4, 6, 1, 3, 8, 7, 0]
		 */
		smallIntsAList = new ArrayList<Integer>();
		smallIntsAList.add(5);
		smallIntsAList.add(2);
		smallIntsAList.add(4);
		smallIntsAList.add(6);
		smallIntsAList.add(9);
		smallIntsAList.add(1);
		smallIntsAList.add(3);
		smallIntsAList.add(8);
		smallIntsAList.add(7);
		smallIntsAList.add(0);
		
		//The expected String ArrayList used for testing
		expectedStringAList = new ArrayList<String>();
		expectedStringAList.add("word0");
		expectedStringAList.add("word1");
		expectedStringAList.add("word10");
		expectedStringAList.add("word2");
		expectedStringAList.add("word3");
		expectedStringAList.add("word4");
		expectedStringAList.add("word5");
		expectedStringAList.add("word6");
		expectedStringAList.add("word7");
		expectedStringAList.add("word8");
		expectedStringAList.add("word9");
		
		//The expected Integer ArrayList used for testing
		expectedIntAList = new ArrayList<Integer>();
		for(int index = 0; index < 10; index++)
		{
			expectedIntAList.add(index);
		}
		
		//Set up insertion sort for integers and strings
		insertionSortInt = new Insertion_Sort<Integer>();
		insertionSortString = new Insertion_Sort<String>();
		//Set up java sort for integers and strings
		javaSortInt = new Java_Sort<Integer>();
		javaSortString = new Java_Sort<String>();
		//Set up merge sort for integers and strings
		mergeSortInt = new Merge_Sort<Integer>();
		mergeSortString = new Merge_Sort<String>();
		//Set up quick sorts
		
		quickSortInplaceFirstPivotInt = new Quick_Sort_Inplace_First_Pivot<Integer>();
		quickSortInplaceFirstPivotString = new Quick_Sort_Inplace_First_Pivot<String>();
		quickSortInplaceM3Int = new Quick_Sort_Inplace_M3<Integer>();
		quickSortInplaceM3String = new Quick_Sort_Inplace_M3<String>();
		quicksortInplaceRandomPivot = new Quick_Sort_Inplace_Random_Pivot<Integer>();
		quickSortNaiveInt = new Quick_Sort_Naive<Integer>();
		quickSortNaiveString = new Quick_Sort_Naive<String>();
		quickSort = new Quick_Sort<Integer>()
				{

					@Override
					protected Integer choose_pivot(ArrayList<Integer> array, int start, int end) {
						// TODO Auto-generated method stub
						return new Integer(3);
					}

					@Override
					public String name_of_sort() {
						// TODO Auto-generated method stub
						return "Quick Sort";
					};		
				
				};
		//Set up shell sorts for Integers and Strings
		shellSortInt = new Shell_Sort<Integer>();		
		shellSortString = new Shell_Sort<String>();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception 
	{
	
	}
	
	//Tests for insertion sort for Integers and Strings

	/**
	 * TEST 1: Test for a small Integer ArrayList using our insertion sort
	 */
	@Test
	public void testInsertionSortIntegers() 
	{
		insertionSortInt.sort(smallIntsAList);
		
		assertEquals(expectedIntAList, smallIntsAList);
	}
	
	
	//Test for Java sort for Integers and Strings
	
	/**
	 * TEST 1: Test for a small arraylist of Integers using Java's sort
	 */
	@Test
	public void testJavaSortStrings()
	{
		javaSortString.sort(smallStringAList);
		
		assertEquals(expectedStringAList, smallStringAList);
	}
	
	/**
	 * TEST 2: Test for a small Integer ArrayList using Java's sort
	 */
	@Test
	public void testJavaSortIntegers()
	{
		javaSortInt.sort(smallIntsAList);
		
		assertEquals(expectedIntAList, smallIntsAList);
	}
	
	//Tests for the Merge Sort for Integers and Strings
	
	/**
	 * TEST 1: Test for a small String ArrayList using Merge Sort
	 */
	@Test
	public void testMergeSortString()
	{
		ArrayList<String> expectedStringAList = new ArrayList<String>();
		expectedStringAList.add("word0");
		expectedStringAList.add("word1");
		expectedStringAList.add("word10");
		expectedStringAList.add("word2");
		expectedStringAList.add("word3");
		expectedStringAList.add("word4");
		expectedStringAList.add("word5");
		expectedStringAList.add("word6");
		expectedStringAList.add("word7");
		expectedStringAList.add("word8");
		expectedStringAList.add("word9");

		javaSortString.sort(smallStringAList);
		
		assertEquals(expectedStringAList, smallStringAList);
	}
	
	/**
	 * TEST 2
	 */
	@Test
	public void testMergeSortInt()
	{
		mergeSortInt.sort(smallIntsAList);
		
		assertEquals(expectedIntAList, smallIntsAList);
	}
	
	//Tests for the Quick Sort Inplace First Pivot for Integers and Strings

	
	/**
	 * TEST 1: Test for a small Integer ArrayList using First Pivot Quick Sort
	 */
	@Test
	public void testQuickSortInplaceFirstPivotIntegers()
	{
		quickSortInplaceFirstPivotInt.sort(smallIntsAList);
		
		assertEquals(expectedIntAList, smallIntsAList);
	}
	
	/**
	 * TEST 2: Test for a small String ArrayList using First Pivot Quick Sort
	 */
	@Test
	public void testQuickSortInplaceFirstPivotStrings()
	{
		quickSortInplaceFirstPivotString.sort(smallStringAList);
	}
	
	//Tests for the Quick Sort Inplace Median 3 for Integers and Strings
	
	/**
	 * TEST 1: Test for a small Integer ArrayList using Median 3 Quick Sort
	 */
	@Test
	public void testQuickSortInplaceM3Integers()
	{
		quickSortInplaceM3Int.sort(smallIntsAList);
	}
	
	/**
	 * TEST 2: Test for a small String ArrayList using Median 3 Quick Sort
	 */
	@Test
	public void testQuickSortInplaceM3Strings()
	{
		quickSortInplaceM3String.sort(smallStringAList);
		
		assertEquals(expectedStringAList, smallStringAList);
	}
	
	//Tests for the Quick Sort Inplace Random Pivot for Integers and Strings
	
	/**
	 * TEST 1: Test for a small Integer ArrayList using random pivoting quick sort
	 */
	@Test
	public void testQuickSortRandomPivotIntegers()
	{
		quicksortInplaceRandomPivot.sort(smallIntsAList);
		
		assertEquals(expectedIntAList, smallIntsAList);
	}
	
	/**
	 * TEST 2: Test for a small String ArrayList using random pivoting quick sort
	 */
	@Test
	public void testQuickSortPivotStrings()
	{
		quickSortInplaceFirstPivotString.sort(smallStringAList);
		
		assertEquals(expectedStringAList, smallStringAList);
	}
	
	//Tests for the Quick Sort Naive for Integers and Strings
	
	/**
	 * TEST 1: Test for a small Integer ArrayList using naive quick sort
	 */
	@Test
	public void testQuickSortNaiveIntegers()
	{
		quickSortNaiveInt.sort(smallIntsAList);
		
		assertEquals(expectedIntAList, smallIntsAList);
	}
	
	/**
	 * TEST 2: Test for a small String ArrayList using naive quick sort
	 */
	@Test
	public void testQuickSortNaiveStrings()
	{
		quickSortNaiveString.sort(smallStringAList);
		
		assertEquals(expectedStringAList, smallStringAList);
	}
	
	/**
	 * TEST 1: Test for a small Integer ArrayList using shell sort
	 * 
	 * 
	 * [5, 2, 4, 6, 1, 3, 2, 6, 0]
	 *
	 * Sorted
	 * [0, 1, 2, 2, 3, 4, 5, 6, 6]
	 */
	@Test
	public void testShellSortIntegers()
	{
		shellSortInt.sort(smallIntsAList);
		
		assertEquals(expectedIntAList, smallIntsAList);
	}
	
	/**
	 * TEST 2: Test for a small String ArrayList using shell sort
	 */
	@Test
	public void testShellSortStrings()
	{
		shellSortString.sort(smallStringAList);
		
		assertEquals(expectedStringAList, smallStringAList);
	}
}

