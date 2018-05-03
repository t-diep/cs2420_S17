package cs2420;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

/**
 * Provides a collection of JUnit Tests for the Heap
 * 
 * @author Tony Diep, last updated 4-14-17
 *
 */
public class HeapTest 
{
	static final Comparator<Integer> intComparator = new Comparator<Integer>()
			{
				@Override
				public int compare(Integer first, Integer second) 
				{
					return first.compareTo(second);
				}
			};
	
	//Random number generator
	Random generator;
	//Empty heap
	Heap<Integer> emptyHeap;
	//Heap of size one
	Heap<Integer> heapSizeOne;
	//Heap of size five
	Heap<Integer> heapSizeTen;
	//Simple heap
	Heap<Integer> simpleHeap;
	//Heap with all duplicates
	Heap<Integer> duplicates;
	
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception
	{	
		simpleHeap = new Heap<>();
		simpleHeap.add(5);
		simpleHeap.add(6);
		simpleHeap.add(3);
		simpleHeap.add(7);
		simpleHeap.add(8);
		simpleHeap.add(1);
		simpleHeap.generateDotFile("Resources/simpleHeapDOT");
		
		emptyHeap = new Heap<>();
		
		heapSizeOne = new Heap<>();
		heapSizeOne.add(123456789);
		
		generator = new Random(100);
		
		heapSizeTen = new Heap<>();
		for(int index = 1; index <= 10; index++)
		{
			heapSizeTen.add(generator.nextInt(11));
		}
		
		duplicates = new Heap<>();
		for(int index = 0; index < 6; index++)
		{
			duplicates.add(8);
		}
	}
	
	//Preliminary tests
	
	// sample simple test you can use
    @Test
    public void test_basic_insertion()
    {
            Heap<Integer> heap = new Heap<>();
            
            heap.add( 5 );
            heap.add( 6 );
            heap.add( 3 );
            heap.add( 7 );
            heap.add( 8 );
            heap.add( 1 );
            
            assertEquals(6, heap.size());
            
            Object[] temp = heap.toArray();
            
            assertArrayEquals(new Integer[]{null, 1,6,3,7,8,5}, temp);
    }


    // sample advanced test you might want to implement
    @Test
    public void test_lots_of_insertions_deletions_peeks()
    {
            Heap<Integer> heap = new Heap<>();
            
            final int COUNT = 1000;
    
            for(int index = 1; index <= 1000; index++)
            {
            	heap.add(index);
            }
            
            assertEquals(COUNT, heap.size());

           int smallest = heap.dequeue(); 
               
           while(heap.size() != 0)
           {
        	   int other = heap.dequeue();
        	   assertTrue(other > smallest);
           }
    }
	

	//Helper method tests
	
	
    //Swap method tests
	
	/**
	 * TEST 1
	 */
	@Test
	public void testSwapFirstAndLastNodesFromArraySimpleHeap()
	{
		assertArrayEquals(new Integer[]{null, 1, 6, 3, 7, 8, 5}, simpleHeap.toArray());
		
		simpleHeap.swap(1, 6);
		
		assertEquals(5, simpleHeap.toArray()[1]);
		assertEquals(1, simpleHeap.toArray()[6]);
	}
	
	/**
	 * TEST 2
	 */
	@Test
	public void testSwapNullWithAnyOfTheOtherElementsSimpleHeap()
	{	
		assertArrayEquals(new Integer[]{null, 1, 6, 3, 7, 8, 5}, simpleHeap.toArray());
		
		simpleHeap.swap(0, 6);
		
		assertEquals(null, simpleHeap.toArray()[0]);
		assertEquals(1, simpleHeap.toArray()[1]);
	}
	
	/**
	 * TEST 3
	 */
	@Test
	public void testMultipleSwapsSimpleHeap()
	{
		assertArrayEquals(new Integer[]{null, 1, 6, 3, 7, 8, 5}, simpleHeap.toArray());
		
		simpleHeap.swap(1, 2);
		
		assertEquals(6, simpleHeap.toArray()[1]);
		assertEquals(1, simpleHeap.toArray()[2]);
		assertArrayEquals(new Integer[]{null, 6, 1, 3, 7, 8, 5}, simpleHeap.toArray());
		
		simpleHeap.swap(2, 3);
		
		assertArrayEquals(new Integer[]{null, 6, 3, 1, 7, 8, 5}, simpleHeap.toArray());
		assertEquals(3, simpleHeap.toArray()[2]);
		assertEquals(1, simpleHeap.toArray()[3]);
		
		simpleHeap.swap(3, 4);
		
		assertArrayEquals(new Integer[]{null, 6, 3, 7, 1, 8, 5}, simpleHeap.toArray());
		assertEquals(7, simpleHeap.toArray()[3]);
		assertEquals(1, simpleHeap.toArray()[4]);
	
		simpleHeap.swap(4, 5);
		
		assertArrayEquals(new Integer[]{null, 6, 3, 7, 8, 1, 5}, simpleHeap.toArray());
		assertEquals(8, simpleHeap.toArray()[4]);
		assertEquals(1, simpleHeap.toArray()[5]);
		
		simpleHeap.swap(5, 6);
		
		assertArrayEquals(new Integer[]{null, 6, 3, 7, 8, 5, 1}, simpleHeap.toArray());
		assertEquals(5, simpleHeap.toArray()[5]);
		assertEquals(1, simpleHeap.toArray()[6]);
	}
	
	//percolateUp method tests
	
	/**
	 * TEST 1
	 */
	@Test
	public void testPercolateUpTheLastNodeOnSimpleHeap()
	{
		assertArrayEquals(new Integer[]{null, 1, 6, 3, 7, 8, 5}, simpleHeap.toArray());
	
		simpleHeap.percolateUp(6);
		
		assertArrayEquals(new Integer[]{null, 1, 6, 3, 7, 8, 5}, simpleHeap.toArray());
		assertEquals(5, simpleHeap.toArray()[6]);
		
		simpleHeap.generateDotFile("Resources/simpleHeappercolateUpLastNodeDOT");
	}
	
	//percolateDown method tests
	
	/**
	 * TEST 1
	 */
	@Test
	public void testPercolateDownSimpleHeap()
	{
		//Verify the original heap first
		assertArrayEquals(new Integer[]{null, 1, 6, 3, 7, 8, 5}, simpleHeap.toArray());
		
		//percolate the simple heap
		simpleHeap.percolateDown(1);
		
		//Verify the new root node
		assertEquals(1, simpleHeap.toArray()[1]);
		//Verify the heap array making sure the perlocating down was correct
		assertArrayEquals(new Integer[]{null, 1, 6, 3, 7, 8, 5}, simpleHeap.toArray());
		
		simpleHeap.generateDotFile("Resources/simpleHeapPercolateDownDOT");
	}
	
	/**
	 * TEST 2
	 */
	@Test
	public void testPercolateDownDescendingOrder()
	{
		Heap<Integer> descending = new Heap<>();
		descending.add(7);
		descending.add(6);
		descending.add(5);
		descending.add(4);
		descending.add(3);
		
		descending.percolateDown(1);
	}
	
	//build_heap_from_array
	
	/**
	 * TEST 1
	 */
	@Test
	public void testBuildArrayFromHeap()
	{
		Integer[] intArray = new Integer[]{null, 5,4,3,2,1};
		
		emptyHeap.build_heap_from_array(intArray);
		
		assertArrayEquals(intArray, emptyHeap.toArray());
	}
	
	/**
	 * TEST 2
	 */
	@Test
	public void testBuildArrayFromHeapSomeDuplicates()
	{
		Integer[] intArray = new Integer[]{null, 9, 9, 2, 3, 7, 7};
		
		emptyHeap.build_heap_from_array(intArray);
	}
	
	//Tests for the empty heap
	
	/**
	 * TEST 1
	 */
	@Test
	public void testVerifySizeEmptyHeap()
	{
		assertEquals(0, emptyHeap.size());
	}
	
	/**
	 * TEST 2
	 */
	@Test(expected = NoSuchElementException.class)
	public void testPeekAtEmptyHeap()
	{
		emptyHeap.peek();
	}
	
	/**
	 * TEST 3
	 */
	@Test(expected = NoSuchElementException.class)
	public void testDequeueEmptyHeap()
	{
		emptyHeap.dequeue();
	}
	
	/**
	 * TEST 4
	 */
	@Test
	public void testClearElementsInEmptyHeap()
	{
		emptyHeap.clear();
		
		assertEquals(0, emptyHeap.size());
		assertArrayEquals(new Integer[]{null}, emptyHeap.toArray());
	}
	
	/**
	 * TEST 5
	 */
	@Test
	public void testHeapSortInEmptyHeap()
	{
		emptyHeap.heap_sort();
		
		assertArrayEquals(new Integer[]{null}, emptyHeap.toArray());
	}
	
	//Tests for the simple heap
	
	/**
	 * TEST 1
	 */
	@Test
	public void testVerifySizeSimpleHeap()
	{
		assertEquals(6, simpleHeap.size());
	}
	
	/**
	 * TEST 2
	 */
	@Test
	public void testPeekOnceSimpleHeap()
	{
		assertEquals((Integer) 1, simpleHeap.peek());
	}
	
	/**
	 * TEST 3
	 */
	@Test
	public void testDequeueOnceSimpleHeap()
	{
		assertEquals((Integer) 1, simpleHeap.dequeue());
	}
	
	/**
	 * TEST 4
	 */
	@Test
	public void testClearElementsInSimpleHeap()
	{
		simpleHeap.clear();
		
		assertEquals(0, simpleHeap.size());
		assertArrayEquals(new Integer[]{null}, simpleHeap.toArray());
	}
	
	/**
	 * TEST 5
	 */
	@Test
	public void testBuildHeapFromArraySimpleHeap()
	{
		Integer[] intArray = {null, 1, 2, 3, 4, 5};
		
		simpleHeap.build_heap_from_array(intArray);
	
		assertArrayEquals(intArray, simpleHeap.toArray());
	}
		
	//Tests for the heap of size one 
	
	/**
	 * TEST 1
	 */
	@Test
	public void testVerifySizeHeapOfSizeOne()
	{
		assertEquals(1, heapSizeOne.size());
	}
	
	/**
	 * TEST 2
	 */
	@Test
	public void testPeekOnceHeapOfSizeOne()
	{
		assertEquals((Integer) 123456789, heapSizeOne.peek());
	}
	
	/**
	 * TEST 3
	 */
	@Test
	public void testDequeueOnceHeapOfSizeOne()
	{
		assertEquals((Integer) 123456789, heapSizeOne.dequeue());
	}
	
	/**
	 * TEST 4
	 */
	@Test
	public void clearHeapOfSizeOne()
	{
		heapSizeOne.clear();
		
		assertEquals(0, heapSizeOne.size());
		assertArrayEquals(new Integer[]{null}, heapSizeOne.toArray());
	}
	
	//Tests for the heap of size ten
	
	/**
	 * TEST 1
	 */
	@Test
	public void testVerifySizeHeapOfSizeTen()
	{
		assertEquals(10, heapSizeTen.size());
	}
	
	/**
	 * TEST 2
	 */
	@Test
	public void testPeekOnceHeapOfSizeTen()
	{
		assertEquals((Integer) 2, heapSizeTen.peek());
	}
	
	/**
	 * TEST 3
	 */
	@Test
	public void testDequeueOnceHeapOfSizeTen()
	{
		assertEquals((Integer) 2, heapSizeTen.dequeue());
	}
	
	/**
	 * TEST 4
	 */
	@Test
	public void testClearHeapOfSizeTen()
	{
		heapSizeTen.clear();
		assertEquals(0, heapSizeTen.size());
		assertArrayEquals(new Integer[]{null}, heapSizeTen.toArray());
	}
	
	//Tests for the heap with all duplicates
	
	/**
	 * TEST 1
	 */
	@Test
	public void testClearHeapWithAllDuplicates()
	{
		duplicates.clear();
		
		assertEquals(0, duplicates.size());
	}
	
	/**
	 * TEST 2
	 */
	@Test
	public void testAddNonDuplicateToHeapWithDuplicates()
	{
		duplicates.add(4);
		
		assertEquals(7, duplicates.size());
		
		assertArrayEquals(new Integer[]{null, 4, 8, 8, 8, 8, 8, 8}, duplicates.toArray());
	}
	
	/**
	 * TEST 3
	 */
	@Test
	public void testPeekInHeapWithDuplicates()
	{
		assertEquals((Integer) 8, duplicates.peek());
		
		duplicates.add(4);
		
		assertEquals((Integer) 4, duplicates.peek());
	}
	
	/**
	 * TEST 4
	 */
	@Test
	public void testDequeueHeapWithDuplicates()
	{	
		assertEquals((Integer) 8, duplicates.dequeue());
		assertEquals(5, duplicates.size());
	}
	
	/**
	 * 
	 */
}
