/**
 * 
 */
package sort_evaluations;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.Before;
import org.junit.Test;

/**
 * Provides a collection of JUnit Tests for the different sorting algorithms
 * 
 * @author Tony Diep, last updated 4-30-17 
 */
public class SortingTest 
{
	//Expected sorted arrayLists
	ArrayList<Integer> expectedSortedSimpleAList;
	ArrayList<Integer> expectedAlreadySortedAList;
	ArrayList<Integer> expectedSomeDuplicatesAList;
	ArrayList<Integer> expectedReverseArrayList;
	
	//Some array lists to test
	ArrayList<Integer> simpleIntArrayList;
	ArrayList<Integer> alreadySortedArrayList;
	ArrayList<Integer> someDuplicatesArrayList;
	ArrayList<Integer> reverselySortedArrayList;
	 
	//Different sortings
	Insertion_Sort<Integer> insertionSortInteger;
	Shell_Sort<Integer> shellSortInteger;
	Merge_Sort<Integer> mergeSortInteger;
	Quick_Sort_Inplace_First_Pivot<Integer> quickSortFirstPivot;
	Quick_Sort_Inplace_M3<Integer> quickSortM3;
	Quick_Sort_Naive<Integer> quickSortNaive;
	
	/**
	 * @throws java.lang.Exception
	 */
	@SuppressWarnings("unchecked")
	@Before
	public void setUp() throws Exception 
	{
		simpleIntArrayList = new ArrayList<>();
		simpleIntArrayList.add(9);
		simpleIntArrayList.add(0);
		simpleIntArrayList.add(1);
		simpleIntArrayList.add(3);
		simpleIntArrayList.add(5);
		simpleIntArrayList.add(2);
		simpleIntArrayList.add(4);
		simpleIntArrayList.add(8);
		
		alreadySortedArrayList = new ArrayList<>();
		for(int index = 0; index <= 8; index++)
		{
			alreadySortedArrayList.add(index);
		}
		
		someDuplicatesArrayList = new ArrayList<>();
		someDuplicatesArrayList.add(6);
		someDuplicatesArrayList.add(9);
		someDuplicatesArrayList.add(2);
		someDuplicatesArrayList.add(2);
		someDuplicatesArrayList.add(8);
		someDuplicatesArrayList.add(1);
		someDuplicatesArrayList.add(6);
		someDuplicatesArrayList.add(9);
		
		reverselySortedArrayList = new ArrayList<>();
		for(int index = 7; index >= 0; index--)
		{
			reverselySortedArrayList.add(index);
		}
		
		expectedAlreadySortedAList = alreadySortedArrayList;
		Collections.sort(expectedAlreadySortedAList);
		
		expectedSortedSimpleAList = (ArrayList<Integer>) simpleIntArrayList.clone();
		Collections.sort(expectedSortedSimpleAList);
		
		expectedSomeDuplicatesAList = (ArrayList<Integer>) someDuplicatesArrayList.clone();
		Collections.sort(expectedSomeDuplicatesAList);
		
		expectedReverseArrayList = new ArrayList<>();
		for(int index = 7; index >= 0; index--)
		{
			expectedReverseArrayList.add(index);
		}
		Collections.sort(expectedReverseArrayList);
		
		insertionSortInteger = new Insertion_Sort<>();
		shellSortInteger = new Shell_Sort<>();
		mergeSortInteger = new Merge_Sort<>();
		quickSortFirstPivot = new Quick_Sort_Inplace_First_Pivot<>();
		quickSortM3 = new Quick_Sort_Inplace_M3<>();
		quickSortNaive = new Quick_Sort_Naive<>();
	}

	//Tests for the swap helper method from the Sorter class
	
	/**
	 * TEST 1 
	 */
	@Test
	public void testSwapFirstTwoElements()
	{
		Sorter.swap(simpleIntArrayList, 0, 1);
		
		if(simpleIntArrayList.get(0) != 0 && simpleIntArrayList.get(1) != 9)
		{
			System.err.println("Swapping executed incorrectly... \nFirst element was actually " + simpleIntArrayList.get(0) + "\nSecond element was actually " + simpleIntArrayList.get(1));
		}
	}
	
	/**
	 * TEST 2
	 */
	@Test
	public void testSwapFirstElementWithItself()
	{
		Sorter.swap(simpleIntArrayList, 0, 0);
		
		assertEquals("First element not 9", (Integer) 9, simpleIntArrayList.get(0));
	}
	
	/**
	 * TEST 3
	 */
	@Test
	public void testSwapFirstAndLastElements()
	{
		Sorter.swap(simpleIntArrayList, 0, 7);
		
		assertEquals((Integer) 8, simpleIntArrayList.get(0));
		assertEquals((Integer) 9, simpleIntArrayList.get(7));
	}
	
	//Test the different sorting algorithms by using a simple array list
	
	// [9][0][1][3][5][2][4][8]
	
	/**
	 * TEST 1
	 */
	@Test
	public void testInsertionSortIntegerSimpleArrayList() 
	{	
		insertionSortInteger.sort(simpleIntArrayList);
		
		assertEquals(expectedSortedSimpleAList, simpleIntArrayList);
	}
	
	/**
	 * TEST 2
	 */
	@Test
	public void testShellSortIntegerSimpleArrayList()
	{		
		shellSortInteger.sort(simpleIntArrayList);
		
		assertEquals(expectedSortedSimpleAList, simpleIntArrayList);
	}
	
	/**
	 * TEST 3
	 */
	@Test
	public void testMergeSortIntegerSimpleArrayList()
	{		
		mergeSortInteger.sort(simpleIntArrayList);
		
		assertEquals(expectedSortedSimpleAList, simpleIntArrayList);
	}
	
	/**
	 * TEST 4
	 */
	@Test
	public void testQuickSortFirstPivotSimpleArrayList()
	{
		quickSortFirstPivot.sort(simpleIntArrayList);
		
		assertEquals(expectedSortedSimpleAList, simpleIntArrayList);
	}
	
	/**
	 * TEST 5
	 */
	@Test
	public void testQuickSortMedianThreeSimpleArrayList()
	{
		quickSortM3.sort(simpleIntArrayList);
		
		assertEquals(expectedSortedSimpleAList, simpleIntArrayList);
	}
	
	/**
	 * TEST 6
	 */
	@Test
	public void testQuickSortNaiveSimpleArrayList()
	{
		quickSortNaive.sort(simpleIntArrayList);
		
		assertEquals(expectedSortedSimpleAList, simpleIntArrayList);
	}
	
	//Test the different sorting algorithms by using an already sorted array list
	
	//[0][1][2][3][4][5][8][9]
	
	/**
	 * TEST 1
	 */
	@Test
	public void testInsertionSortAlreadySortedArrayList()
	{
		insertionSortInteger.sort(alreadySortedArrayList);
		
		assertEquals(expectedAlreadySortedAList, alreadySortedArrayList);
	}
	
	/**
	 * TEST 2
	 */
	@Test
	public void testShellSortAlreadySortedArrayList()
	{
		shellSortInteger.sort(alreadySortedArrayList);
		
		assertEquals(expectedAlreadySortedAList, alreadySortedArrayList);
	}
	
	/**
	 * TEST 3
	 */
	@Test
	public void testMergeSortAlreadySortedArrayList()
	{
		mergeSortInteger.sort(alreadySortedArrayList);
		
		assertEquals(expectedAlreadySortedAList, alreadySortedArrayList);
	}
	
	/**
	 * TEST 4
	 */
	@Test
	public void testQuickSortFirstPivotAlreadySortedArrayList()
	{
		quickSortFirstPivot.sort(alreadySortedArrayList);
		
		assertEquals(expectedAlreadySortedAList, alreadySortedArrayList);
	}
	
	/**
	 * TEST 5
	 */
	@Test
	public void testQuickSortMedianThreeAlreadySortedArrayList()
	{
		quickSortM3.sort(alreadySortedArrayList);
		
		assertEquals(expectedAlreadySortedAList, alreadySortedArrayList);
	}
	
	/**
	 * TEST 6
	 */
	@Test
	public void testQuickSortNaiveAlreadySortedArrayList()
	{
		quickSortNaive.sort(alreadySortedArrayList);
		
		assertEquals(expectedAlreadySortedAList, alreadySortedArrayList);
	}
	
	//Test the different sorting algorithms using an arraylist with some duplicates in them
	
	//[6][9][2][2][8][1][6][9]
	
	/**
	 * TEST 1
	 */
	@Test
	public void testInsertionSortSomeDuplicatesArrayList()
	{
		insertionSortInteger.sort(someDuplicatesArrayList);
		
		assertEquals(expectedSomeDuplicatesAList, someDuplicatesArrayList);
	}
	
	/**
	 * TEST 2
	 */
	@Test
	public void testShellSortSomeDuplicatesArrayList()
	{
		shellSortInteger.sort(someDuplicatesArrayList);
		
		assertEquals(expectedSomeDuplicatesAList, someDuplicatesArrayList);
	}
	
	/**
	 * TEST 3
	 */
	@Test
	public void testMergeSortSomeDuplicatesArrayList()
	{
		mergeSortInteger.sort(someDuplicatesArrayList);
		
		assertEquals(expectedSomeDuplicatesAList, someDuplicatesArrayList);
	}
	
	/**
	 * TEST 4
	 */
	@Test
	public void testQuickSortFirstPivotSomeDuplicatesArrayList()
	{
		quickSortFirstPivot.sort(someDuplicatesArrayList);
		
		assertEquals(expectedSomeDuplicatesAList, someDuplicatesArrayList);
	}
	
	/**
	 * TEST 5
	 */
	@Test
	public void testQuickSortMedianThreeSomeDuplicatesArrayList()
	{
		quickSortM3.sort(someDuplicatesArrayList);
		
		assertEquals(expectedSomeDuplicatesAList, someDuplicatesArrayList);
	}
	
	/**
	 * TEST 6
	 */
	@Test
	public void testQuickSortNaiveSomeDuplicatesArrayList()
	{
		quickSortM3.sort(someDuplicatesArrayList);
		
		assertEquals(expectedSomeDuplicatesAList, someDuplicatesArrayList);
	}
	
	//Test the different sorting algorithms using a reversely sorted array list
	
	//[7][6][5][4][3][2][1][0]
	
	/**
	 * TEST 1
	 */
	@Test
	public void testInsertionSortReverselySortedArrayList()
	{
		insertionSortInteger.sort(reverselySortedArrayList);
		
		assertEquals(expectedReverseArrayList, reverselySortedArrayList);
	}
	
	/**
	 * TEST 2
	 */
	@Test
	public void testShellSortReverselySortedArrayList()
	{
		shellSortInteger.sort(reverselySortedArrayList);
		
		assertEquals(expectedReverseArrayList, reverselySortedArrayList);
	}
	
	/**
	 * TEST 3
	 */
	@Test
	public void testMergeSortReverselySortedArrayList()
	{
		mergeSortInteger.sort(reverselySortedArrayList);
		
		assertEquals(expectedReverseArrayList, reverselySortedArrayList);
	}
	
	/**
	 * TEST 4
	 */
	@Test
	public void testQuickSortFirstPivotReverselySortedArrayList()
	{
		quickSortFirstPivot.sort(reverselySortedArrayList);
		
		assertEquals(expectedReverseArrayList, reverselySortedArrayList);
	}
	
	/**
	 * TEST 5
	 */
	@Test
	public void testQuickSortMedian3ReverselySortedArrayList()
	{
		quickSortM3.sort(reverselySortedArrayList);
		
		assertEquals(expectedReverseArrayList, reverselySortedArrayList);
	}
	
	/**
	 * TEST 6
	 */
	@Test
	public void testQuickSortNaiveReverselySortedArrayList()
	{
		quickSortNaive.sort(reverselySortedArrayList);
		
		assertEquals(expectedReverseArrayList, reverselySortedArrayList);
	}
}
