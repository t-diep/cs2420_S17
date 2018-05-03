package lists_2420;

import static org.junit.Assert.*;


import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Random;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import lists_2420.Linked_List_2420;

/**
 * Before each set of tests is a "book mark".
 * The book mark will state "Test" followed by the exact name of the method to be tested.
 * 
 * Test method signature format: test_methodName_instanceObj_testDescription
 * 
 *                      Example: "test_validForRow_easyPuzzle_usingFirstRow."
 *                      		 This states, testing the validForRow method using the easyPuzzle instance
 *                      		 and checking the return value for using the first row.
 *                      
 *                         Note: The testDescription may be omitted, as long as the signature
 *                               clearly states the tests purpose. Also, if multiple classes are
 *                               tested then that class name may be included prior to the
 *                               method name being tested.
 *                               
 *                               Example: test_Node_to_ArrayList_post_recursive_withSmList
 *  
 * @author Andrew Worley
 * 
 * last update: 2/23/17
 *
 */
public class List_2420Test 
{
	Linked_List_2420<Integer> linkedTestList = new Linked_List_2420<Integer>();
	//smallList MUST contain 17, 17, 9, 9, 13, 10, 0, 13, 13, 8
	Linked_List_2420<Integer> linkedSmallList = new Linked_List_2420<Integer>();
	
	Array_List_2420 arrayTestList = new Array_List_2420();
	//arrayIntegerSmallList MUST contain 17, 17, 9, 9, 13, 10, 0, 13, 13, 8
	Array_List_2420 arraySmallList = new Array_List_2420();
	
	/**
	 * Some additional supplementary JUnit Tests
	 */
	
	List_2420<Integer> integerList;
	Linked_List_2420<Integer> linkedIntegerList;
	Array_List_2420 integerAList;
	

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * Allows changing between linked and array lists
	 */
	public List_2420<Integer> new_list()
	{
		return new Linked_List_2420<Integer>();
	}
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		
		//DO NOT change the seed
		Random ranNum = new Random(1234);//use seed for same random numbers
		
		for(int index = 0; index < 10; index++) { linkedSmallList.add_first(ranNum.nextInt(20)); }
		
		//RESET the random number sequence
		ranNum = new Random(1234);//use seed for same random numbers
		
		for(int index = 0; index < 10; index++) { arraySmallList.add_first(ranNum.nextInt(20)); }
	
		integerList = new_list();
		linkedIntegerList = new Linked_List_2420<Integer>();
		integerAList = new Array_List_2420();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	///////////////////////////////////
	//XXX Linked_List_2420 Testing
	
	//XXX Tests for the addFirst method
	
	@Test
	public void test_Linked_List_2420_add_first_testList_createSmList() 
	{
		linkedTestList.add_first(10);
		linkedTestList.add_first(11);
		linkedTestList.add_first(12);
		linkedTestList.add_first(13);
		linkedTestList.add_first(14);
		linkedTestList.add_first(15);
		linkedTestList.add_first(16);
		
		assertEquals("(7) [16]--> [15]--> [14]--> [13]--> [12]--> [11]--> [10]--> null", linkedTestList.toString());
	}

	//XXX Tests for the addLast method
	
	@Test
	public void test_Linked_List_2420_add_last_testList_createSmList()
	{
		linkedTestList.add_last(9);
		linkedTestList.add_last(8);
		linkedTestList.add_last(7);
		linkedTestList.add_last(6);
		linkedTestList.add_last(5);
		
		assertEquals("(5) [9]--> [8]--> [7]--> [6]--> [5]--> null",linkedTestList.toString());
	}
	
	//XXX Tests for contains (Iterative)
	
	@Test
	public void test_Linked_List_2420_contains_testList_iterativeNoElements() 
	{
		assertFalse(linkedTestList.contains(10));
	}
	
	@Test
	public void test_Linked_List_2420_contains_testList_iterativeSmListReturnfalse() {
		linkedTestList.add_first(13);
		linkedTestList.add_first(14);
		linkedTestList.add_last(7);
		linkedTestList.add_last(6);
		linkedTestList.add_first(15);
		linkedTestList.add_first(16);
		
		assertEquals("(6) [16]--> [15]--> [14]--> [13]--> [7]--> [6]--> null",linkedTestList.toString());
		assertFalse(linkedTestList.contains(1));
	}
	
	@Test
	public void test_Linked_List_2420_contains_testList_iterativeSmListTrueForMiddleItem() {
		linkedTestList.add_first(13);
		linkedTestList.add_first(14);
		linkedTestList.add_last(7);
		
		assertTrue(linkedTestList.contains(14));
	}
	
	@Test
	public void test_Linked_List_2420_contains_testList_iterativeSmListTrueForLastItem() {
		linkedTestList.add_first(13);
		linkedTestList.add_first(14);
		linkedTestList.add_last(7);
		
		assertTrue(linkedTestList.contains(7));
	}
	
	@Test
	public void test_Linked_List_2420_contains_testList_iterativeSingleElementReturnTrue() {
		linkedTestList.add_first(13);
		
		assertTrue(linkedTestList.contains(13));
	}
	
	@Test
	public void test_Linked_List_2420_contains_testList_iterativeSingleElementReturnfalse() {
		linkedTestList.add_first(13);
		
		assertFalse(linkedTestList.contains(10));
	}
	
	//XXX Tests for contains (Recursive)
	
	@Test
	public void test_Linked_List_2420_contains_testList_recursiveNoElements() {
		assertFalse(linkedTestList.contains_recursive(10));
	}
	
	@Test
	public void test_Linked_List_2420_contains_testList_recursiveSmListReturnFalse() {
		linkedTestList.add_first(13);
		linkedTestList.add_first(14);
		linkedTestList.add_last(7);
		linkedTestList.add_last(6);
		linkedTestList.add_first(15);
		linkedTestList.add_first(16);
		
		assertEquals("(6) [16]--> [15]--> [14]--> [13]--> [7]--> [6]--> null",linkedTestList.toString());
		assertFalse(linkedTestList.contains_recursive(1));
	}
	
	@Test
	public void test_Linked_List_2420_contains_testList_recursiveSmallListTrueForMiddleItem() {
		linkedTestList.add_first(13);
		linkedTestList.add_first(14);
		linkedTestList.add_last(7);
		
		assertTrue(linkedTestList.contains_recursive(14));
	}
	
	@Test
	public void test_Linked_List_2420_contains_testList_recursiveSmListTrueForLastItem() {
		linkedTestList.add_first(13);
		linkedTestList.add_first(14);
		linkedTestList.add_last(7);
		
		assertTrue(linkedTestList.contains_recursive(7));
	}
	
	@Test
	public void test_Linked_List_2420_contains_testList_recursiveSingleElementReturntrue() {
		linkedTestList.add_first(13);
		
		assertTrue(linkedTestList.contains_recursive(13));
	}
	
	@Test
	public void test_Linked_List_2420_contains_testList_recursiveSingleElementReturnFalse() {
		linkedTestList.add_first(13);
		
		assertFalse(linkedTestList.contains_recursive(10));
	}
	
	// XXX Test to_ArrayList
	
	@Test
	public void test_Linked_List_2420_to_ArrayList_testList_withSmList() {
		assertEquals("[17, 17, 9, 9, 13, 10, 0, 13, 13, 8]",linkedSmallList.to_ArrayList().toString());
		assertEquals("(10) [17]--> [17]--> [9]--> [9]--> [13]-->"
				  + " [10]--> [0]--> [13]--> [13]--> [8]--> null",linkedSmallList.toString());
	}
	
	// XXX Test to_ArrayList_post_recurse
	
	@Test 
	public void test_Linked_List_2420_to_ArrayList_post_recurse_testList_noElements() {
		assertEquals("[]", linkedTestList.to_ArrayList_post_recurse().toString());
	}
	
	@Test 
	public void test_Linked_List_2420_to_ArrayList_post_recurse_testList_oneElement() {
		linkedTestList.add_first(10);
		
		assertEquals("[10]", linkedTestList.to_ArrayList_post_recurse().toString());
	}
	
	@Test 
	public void test_Linked_List_2420_to_ArrayList_post_recurse_testList_multipleElements() {
		linkedTestList.add_first(3);
		linkedTestList.add_first(7);
		linkedTestList.add_first(6);
		linkedTestList.add_first(15);
		
		assertEquals("[3, 7, 6, 15]", linkedTestList.to_ArrayList_post_recurse().toString());
	}
	
	// XXX Test add_middle
	
	@Test
	public void test_Linked_List_2420_add_middle_smallList_addAfterStart() {
		linkedSmallList.add_middle(0, 66);
		
		assertEquals("(11) [17]--> [66]--> [17]--> [9]--> [9]--> [13]--> "
				   + "[10]--> [0]--> [13]--> [13]--> [8]--> null",
				      linkedSmallList.toString());
	}
	
	@Test
	public void test_Linked_List_2420_add_middle_smallList_addToMiddle() {
		linkedSmallList.add_middle(5, 66);
		
		assertEquals("(11) [17]--> [17]--> [9]--> [9]--> [13]--> "
				   + "[10]--> [66]--> [0]--> [13]--> [13]--> [8]--> null",
				   linkedSmallList.toString());
	}
	
	@Test
	public void test_Linked_List_2420_add_middle_smallList_addToEnd() {
		linkedSmallList.add_middle(10, 66);
		
		assertEquals("(11) [17]--> [17]--> [9]--> [9]--> [13]--> "
				   + "[10]--> [0]--> [13]--> [13]--> [8]--> [66]--> null",
				     linkedSmallList.toString());
	}
	
	//experimental massive test case
	@Test
	public void test_Linked_List_2420_add_middle_smallList_addToAllPositions() {
		ArrayList<String> results = new ArrayList<String>();
		
		//after 0
		results.add("(11) [17]--> [66]--> [17]--> [9]--> [9]--> [13]--> [10]--> [0]--> [13]--> [13]--> [8]--> null");
		//after 1
		results.add("(11) [17]--> [17]--> [66]--> [9]--> [9]--> [13]--> [10]--> [0]--> [13]--> [13]--> [8]--> null");
		//after 2
		results.add("(11) [17]--> [17]--> [9]--> [66]--> [9]--> [13]--> [10]--> [0]--> [13]--> [13]--> [8]--> null");
		//after 3
		results.add("(11) [17]--> [17]--> [9]--> [9]--> [66]--> [13]--> [10]--> [0]--> [13]--> [13]--> [8]--> null");
		//after 4
		results.add("(11) [17]--> [17]--> [9]--> [9]--> [13]--> [66]--> [10]--> [0]--> [13]--> [13]--> [8]--> null");
		//after 5
		results.add("(11) [17]--> [17]--> [9]--> [9]--> [13]--> [10]--> [66]--> [0]--> [13]--> [13]--> [8]--> null");
		//after 6
		results.add("(11) [17]--> [17]--> [9]--> [9]--> [13]--> [10]--> [0]--> [66]--> [13]--> [13]--> [8]--> null");
		//after 7
		results.add("(11) [17]--> [17]--> [9]--> [9]--> [13]--> [10]--> [0]--> [13]--> [66]--> [13]--> [8]--> null");
		//after 8
		results.add("(11) [17]--> [17]--> [9]--> [9]--> [13]--> [10]--> [0]--> [13]--> [13]--> [66]--> [8]--> null");
		//after 9
		results.add("(11) [17]--> [17]--> [9]--> [9]--> [13]--> [10]--> [0]--> [13]--> [13]--> [8]--> [66]--> null");
		//after 10 (equal to size)
		results.add("(11) [17]--> [17]--> [9]--> [9]--> [13]--> [10]--> [0]--> [13]--> [13]--> [8]--> [66]--> null");
		//after 11 (greater than size)
		results.add("(11) [17]--> [17]--> [9]--> [9]--> [13]--> [10]--> [0]--> [13]--> [13]--> [8]--> [66]--> null");
		
		for(int index = 0; index < 12; index++)
		{
			linkedSmallList.add_middle(index, 66);
			assertEquals(results.get(index), linkedSmallList.toString());
			linkedSmallList.clear();
			
			//recreate same smallList
			Random ranNum = new Random(1234);//use seed for same random numbers
			for(int node = 0; node < 10; node++) { linkedSmallList.add_first(ranNum.nextInt(20)); }
		}
	}
	
	
	///////////////////////////////////
	//XXX NODE Testing
	
	// XXX Test length
	
	@Test
	public void test_Node_length_testList_noElements() {
		assertEquals(1, linkedTestList.head.length());
	}
	
	@Test
	public void test_Node_length_testList_oneElement() {
		linkedTestList.add_first(1);
		
		assertEquals(1, linkedTestList.head.length());
	}
	
	@Test
	public void test_Node_length_testList_twoElements() {
		linkedTestList.add_first(1);
		linkedTestList.add_first(2);
		
		assertEquals(2, linkedTestList.head.length());
	}
	
	@Test
	public void test_Node_length_testList_multipleElements() {
		linkedTestList.add_first(2);
		linkedTestList.add_first(7);
		linkedTestList.add_first(3);
		linkedTestList.add_first(5);
		
		assertEquals(4, linkedTestList.head.length());
	}
	
	// XXX Test to_ArrayList_post_recursive
	
	@Test
	public void test_Node_to_ArrayList_post_recursive_withNoElementList() {
		ArrayList<Integer> testArrayList = new ArrayList<Integer>();
		
		assertEquals("[]",linkedTestList.head.to_ArrayList_post_recursive(testArrayList).toString());
	}
	
	@Test
	public void test_Node_to_ArrayList_post_recursive_withOneElement() {
		linkedTestList.add_first(1);
		
		ArrayList<Integer> testArrayList = new ArrayList<Integer>();
		
		assertEquals("[1]",linkedTestList.head.to_ArrayList_post_recursive(testArrayList).toString());
	}
	
	@Test
	public void test_Node_to_ArrayList_post_recursive_withSmList() {
		ArrayList<Integer> testArrayList = new ArrayList<Integer>();
		
		assertEquals("[8, 13, 13, 0, 10, 13, 9, 9, 17, 17]",linkedSmallList.head.to_ArrayList_post_recursive(testArrayList).toString());
	}
	
	///////////////////////////////////
	//XXX Array_List_2420 Testing
	
	//XXX Tests for the addFirst method
	
	@Test
	public void test_Array_List_2420_add_first_testList_createSmList() 
	{
		arrayTestList.add_first(10);
		arrayTestList.add_first(11);
		arrayTestList.add_first(12);
		arrayTestList.add_first(13);
		arrayTestList.add_first(14);
		arrayTestList.add_first(15);
		arrayTestList.add_first(16);
		
		assertEquals("[10, 11, 12, 13, 14, 15, 16]", arrayTestList.toString());
	}
	
	//XXX Tests for the addLast method
	
	@Test
	public void test_Array_List_2420_add_last_testList_createSmList()
	{
		arrayTestList.add_last(9);
		arrayTestList.add_last(8);
		arrayTestList.add_last(7);
		arrayTestList.add_last(6);
		arrayTestList.add_last(5);
		
		assertEquals("[9, 8, 7, 6, 5]",arrayTestList.toString());
	}
	
	//XXX Tests for contains (Iterative)
	
	@Test
	public void test_Array_List_2420_contains_testList_iterativeNoElements() {
		assertFalse(arrayTestList.contains(10));
	}
	
	@Test
	public void test_Array_List_2420_contains_testList_iterativeSmListReturnfalse() {
		arrayTestList.add_first(13);
		arrayTestList.add_first(14);
		arrayTestList.add_last(7);
		arrayTestList.add_last(6);
		arrayTestList.add_first(15);
		arrayTestList.add_first(16);
		
		assertEquals("[16, 15, 14, 13, 7, 6]",arrayTestList.toString());
		assertFalse(arrayTestList.contains(1));
	}
	
	@Test
	public void test_Array_List_2420_contains_testList_iterativeSmListTrueForMiddleItem() {
		arrayTestList.add_first(13);
		arrayTestList.add_first(14);
		arrayTestList.add_last(7);
		
		assertTrue(arrayTestList.contains(14));
	}
	
	@Test
	public void test_Array_List_2420_contains_testList_iterativeSmListTrueForLastItem() {
		arrayTestList.add_first(13);
		arrayTestList.add_first(14);
		arrayTestList.add_last(7);
		
		assertTrue(arrayTestList.contains(7));
	}
	
	@Test
	public void test_Array_List_2420_contains_testList_iterativeSingleElementReturnTrue() {
		arrayTestList.add_first(13);
		
		assertTrue(arrayTestList.contains(13));
	}
	
	@Test
	public void test_Array_List_2420_contains_testList_iterativeSingleElementReturnfalse() {
		arrayTestList.add_first(13);
		
		assertFalse(arrayTestList.contains(10));
	}
	
	//XXX Tests for contains (Recursive)
	
	@Test
	public void test_Array_List_2420_contains_testList_recursiveNoElements() {
		assertFalse(arrayTestList.contains_recursive(10));
	}
	
	@Test
	public void test_Array_List_2420_contains_testList_recursiveSmListReturnFalse() {
		arrayTestList.add_first(13);
		arrayTestList.add_first(14);
		arrayTestList.add_last(7);
		arrayTestList.add_last(6);
		arrayTestList.add_first(15);
		arrayTestList.add_first(16);
		
		assertEquals("[16, 15, 14, 13, 7, 6]",arrayTestList.toString());
		assertFalse(arrayTestList.contains_recursive(1));
	}
	
	@Test
	public void test_Array_List_2420_contains_testList_recursiveSmallListTrueForMiddleItem() {
		arrayTestList.add_first(13);
		arrayTestList.add_first(14);
		arrayTestList.add_last(7);
		
		assertTrue(arrayTestList.contains_recursive(14));
	}
	
	@Test
	public void test_Array_List_2420_contains_testList_recursiveSmListTrueForLastItem() {
		arrayTestList.add_first(13);
		arrayTestList.add_first(14);
		arrayTestList.add_last(7);
		
		assertTrue(arrayTestList.contains_recursive(7));
	}
	
	@Test
	public void test_Array_List_2420_contains_testList_recursiveSingleElementReturntrue() {
		arrayTestList.add_first(13);
		
		assertTrue(arrayTestList.contains_recursive(13));
	}
	
	@Test
	public void test_Array_List_2420_contains_testList_recursiveSingleElementReturnFalse() {
		arrayTestList.add_first(13);
		
		assertFalse(arrayTestList.contains_recursive(10));
	}
	
	// XXX Test to_ArrayList
	
	@Test
	public void test_Array_List_2420_to_ArrayList_testList_withSmList() {
		assertEquals("[17, 17, 9, 9, 13, 10, 0, 13, 13, 8]",arraySmallList.to_ArrayList().toString());
		assertEquals("[17, 17, 9, 9, 13, 10, 0, 13, 13, 8]",arraySmallList.toString());
	}
	
	// XXX Test to_ArrayList_post_recurse
	
	@Test 
	public void test_Array_List_2420_to_ArrayList_post_recurse_testList_noElements() {
		assertEquals("[]", arrayTestList.to_ArrayList_post_recurse().toString());
	}
	
	@Test 
	public void test_Array_List_2420_to_ArrayList_post_recurse_testList_oneElement() {
		arrayTestList.add_first(10);
		
		assertEquals("[10]", arrayTestList.to_ArrayList_post_recurse().toString());
	}
	
	@Test 
	public void test_Array_List_2420_to_ArrayList_post_recurse_testList_multipleElements() {
		arrayTestList.add_first(3);
		arrayTestList.add_first(7);
		arrayTestList.add_first(6);
		arrayTestList.add_first(15);
		
		assertEquals("[3, 7, 6, 15]", arrayTestList.to_ArrayList_post_recurse().toString());
	}
	
	// XXX Test add_middle
	
	@Test
	public void test_Array_List_2420_add_middle_smallList_addAfterStart() {
		arraySmallList.add_middle(0, 66);
		
		assertEquals("[17, 66, 17, 9, 9, 13, 10, 0, 13, 13, 8]",
		arraySmallList.toString());
	}
	
	@Test
	public void test_Array_List_2420_add_middle_smallList_addToMiddle() {
		arraySmallList.add_middle(5, 66);
		
		assertEquals("[17, 17, 9, 9, 13, 10, 66, 0, 13, 13, 8]",
		arraySmallList.toString());
	}
	
	@Test
	public void test_Array_List_2420_add_middle_smallList_addToEnd() {
		arraySmallList.add_middle(10, 66);
		
		assertEquals("[17, 17, 9, 9, 13, 10, 0, 13, 13, 8, 66]",arraySmallList.toString());
	}
	
	//experimental massive test case
	@Test
	public void test_Array_List_2420_add_middle_smallList_addToAllPositions() {
		/* store a list of results that indicate how the array should
		 *  look after adding 66 after each index 
		 */
		ArrayList<String> results = new ArrayList<String>();
		
		//after 0
		results.add("[17, 66, 17, 9, 9, 13, 10, 0, 13, 13, 8]");
		//after 1
		results.add("[17, 17, 66, 9, 9, 13, 10, 0, 13, 13, 8]");
		//after 2
		results.add("[17, 17, 9, 66, 9, 13, 10, 0, 13, 13, 8]");
		//after 3
		results.add("[17, 17, 9, 9, 66, 13, 10, 0, 13, 13, 8]");
		//after 4
		results.add("[17, 17, 9, 9, 13, 66, 10, 0, 13, 13, 8]");
		//after 5
		results.add("[17, 17, 9, 9, 13, 10, 66, 0, 13, 13, 8]");
		//after 6
		results.add("[17, 17, 9, 9, 13, 10, 0, 66, 13, 13, 8]");
		//after 7
		results.add("[17, 17, 9, 9, 13, 10, 0, 13, 66, 13, 8]");
		//after 8
		results.add("[17, 17, 9, 9, 13, 10, 0, 13, 13, 66, 8]");
		//after 9
		results.add("[17, 17, 9, 9, 13, 10, 0, 13, 13, 8, 66]");
		//after 10 (equal to size)
		results.add("[17, 17, 9, 9, 13, 10, 0, 13, 13, 8, 66]");
		//after 11 (greater than size)
		results.add("[17, 17, 9, 9, 13, 10, 0, 13, 13, 8, 66]");
		
		for(int index = 0; index < 12; index++) {
			arraySmallList.add_middle(index, 66);
			assertEquals(results.get(index), arraySmallList.toString());
			arraySmallList.clear();
			
			//recreate same smallList
			Random ranNum = new Random(1234);//use seed for same random numbers
			for(int node = 0; node < 10; node++) { arraySmallList.add_first(ranNum.nextInt(20)); }
		}
	}
	
	
	/**
	 * Addtional JUnit tests for Linked List and ArrayList
	 */
	
	
	/**
	 * Test for a basic linked list and a basic arraylist
	 */
	@Test
	public void baseTestArrayListAndLinkedList()
	{
    	//Add an element 
    	integerList.add_first(6);
  
    	//Verify if the first element is in the first spot
    	assertEquals((Integer) 6, integerList.get_first());
    	//Verify if the recently added element exists in the list
    	assertTrue(integerList.contains(6));
    	//Verify the size of the list
    	assertEquals(1, integerList.size());
    	
    	//Add a couple of more elements
    	integerList.add_first((Integer) 4);
    	integerList.add_first((Integer) 8);
    	integerList.add_first((Integer) 2); 
    	integerList.add_first((Integer) 10);
    	
    	//Verify if all of the recently added elements exist in the list
    	assertTrue(integerList.contains((Integer) 4));
    	assertTrue(integerList.contains((Integer) 8));
    	assertTrue(integerList.contains((Integer) 2));
    	assertTrue(integerList.contains((Integer) 10));
    	//Verify the element at the first and last positions
    	assertEquals((Integer) 10, integerList.get_first());
    	assertEquals((Integer) 6, integerList.get_last());

    	//Delete all of the existing elements in the list
    	integerList.clear();
    	
    	//Verify if the elements no longer exist in the list after clearing
    	assertFalse(integerList.contains((Integer) 6));
    	assertFalse(integerList.contains((Integer) 4));
    	assertFalse(integerList.contains((Integer) 8));
    	assertFalse(integerList.contains((Integer) 12));
    	assertFalse(integerList.contains((Integer) 10));
    	//Verify the list is empty
    	assertEquals(0, integerList.size());
    	
    	//Linked List
    	if(integerList instanceof Linked_List_2420)
    	{
    		integerList = new Linked_List_2420<Integer>();
    		
    	   	//Add an element 
        	integerList.add_first(6);
      
        	//Verify if the first element is in the first spot
        	assertEquals((Integer) 6, integerList.get_first());
        	//Verify if the recently added element exists in the list
        	assertTrue(integerList.contains(6));
        	//Verify the size of the list
        	assertEquals(1, integerList.size());
        	
        	//Add a couple of more elements
        	integerList.add_first((Integer) 4);
        	integerList.add_first((Integer) 8);
        	integerList.add_first((Integer) 2); 
        	integerList.add_first((Integer) 10);
        	
        	//Verify if all of the recently added elements exist in the list
        	assertTrue(integerList.contains(4));
        	assertTrue(integerList.contains(8));
        	assertTrue(integerList.contains(2));
        	assertTrue(integerList.contains(10));
        	//Verify the element at the first and last positions
        	assertEquals((Integer) 10, integerList.get_first());
        	assertEquals((Integer) 6, integerList.get_last());

        	//Delete all of the existing elements in the list
        	integerList.clear();
        	
        	//Verify if the elements no longer exist in the list after clearing
        	assertFalse(integerList.contains(6));
        	assertFalse(integerList.contains(4));
        	assertFalse(integerList.contains(8));
        	assertFalse(integerList.contains(12));
        	assertFalse(integerList.contains(10));
        	//Verify the list is empty
        	assertEquals(0, integerList.size());
    	}
    	//ArrayList
    	else
    	{
    		integerList = new Array_List_2420();
    		
    		//Add an element 
        	integerList.add_first(6);
      
        	//Verify if the first element is in the first spot
        	assertEquals((Integer) 6, integerList.get_first());
        	//Verify if the recently added element exists in the list
        	assertTrue(integerList.contains(6));
        	//Verify the size of the list
        	assertEquals(1, integerList.size());
        	
        	//Add a couple of more elements
        	integerList.add_first((Integer) 4);
        	integerList.add_first((Integer) 8);
        	integerList.add_first((Integer) 2); 
        	integerList.add_first((Integer) 10);
        	
        	//Verify if all of the recently added elements exist in the list
        	assertTrue(integerList.contains(4));
        	assertTrue(integerList.contains(8));
        	assertTrue(integerList.contains(12));
        	assertTrue(integerList.contains(10));
        	//Verify the element at the first and last positions
        	assertEquals((Integer) 10, integerList.get_first());
        	assertEquals((Integer) 0, integerList.get_last());

        	//Delete all of the existing elements in the list
        	integerList.clear();
        	
        	//Verify if the elements no longer exist in the list after clearing
        	assertFalse(integerList.contains(6));
        	assertFalse(integerList.contains(4));
        	assertFalse(integerList.contains(8));
        	assertFalse(integerList.contains(12));
        	assertFalse(integerList.contains(10));
        	//Verify the list is empty
        	assertEquals(0, integerList.size());
    	}
     }
    
    /**
     *  Test for getting an empty data spot at the head of the LinkedList
     */
    @Test(expected = NoSuchElementException.class)
    public void testGetFirstExceptionLinkedList()
    {
    	linkedIntegerList.head.data = null;
    	linkedIntegerList.get_first();
    }
    
    /**
     * Test for getting an empty data spot at the tail of the LinkedList
     */
    @Test(expected = NoSuchElementException.class)
    public void testGetLastExceptionLinkedList()
    {
    	linkedIntegerList.tail.data = null;
    	linkedIntegerList.get_last();
    }
    
    /**
     * Test for removing an empty data spot at the head of the LinkedList
     */
    @Test(expected = NoSuchElementException.class)
    public void testRemoveFirstExceptionLinkedList()
    {
    	linkedIntegerList.remove_first();
    }
    
    /**
     * Test for removing an empty data spot at the tail of the LinkedList
     */
    @Test(expected = NoSuchElementException.class)
    public void testRemoveLastExceptionLinkedList()
    {
    	linkedIntegerList.remove_last();
    }
    
    /**
     * Test for empty LinkedList and ArrayList
     */
	@Test
    public void edgeTestArrayListAndLinkedList()
    {
    	if(integerList instanceof Linked_List_2420)
    	{
    		integerList = new Linked_List_2420<Integer>();       	
        	assertEquals("empty", integerList.toString());
    	}
    	else
    	{
    		integerList = new Array_List_2420();     	
        	assertEquals("[]", integerList.toString());
    	}
    	
    	assertEquals(0, integerList.size());
    	assertFalse(integerList.contains(56));
    }
    
   //Supplementary tests for the Array_List_2420 class
    
    /**
     * 
     */
    @Test
    public void testHelperMethodExpandSmallArray()
    {
    	integerList = new Array_List_2420();
    	
    	integerList.add_first(3);
    	integerList.add_first(10);
    	integerList.add_first(2);
    	integerList.add_first(4);
    	integerList.add_first(5);
    	integerList.add_first(9);
    	integerList.add_first(8);
    	integerList.add_first(0);
    	integerList.add_first(3);
    }
    
    /**
     * Test if the expand method doubles the size of the backing array when full
     */
    @Test
    public void testHelperMethodExpand()
    {
    	Array_List_2420 array = new Array_List_2420();
    	
    	for(int index = 0; index < 1024; index++)
    	{
    		array.add_first(index);
    	}
    	
    	assertEquals(2048, array.backingArray.length);
    	
    	array.expand(); 
    	
    	for(int index = 1024; index < 2048; index++)
    	{
    		array.add_first(index);
    	}
    	
    	assertEquals(4096, array.backingArray.length);
    }
    
    /**
     * Test for the method to shift elements correctly
     */
    @Test
    public void testHelperMethodShift()
    {
    	Integer[] shiftElementsLeft = new Integer[4];
    	
    	shiftElementsLeft[0] = 7;
    	shiftElementsLeft[1] = 3;
    	shiftElementsLeft[2] = 9;
    }
    
    /**
     * TEST 1: Test for adding 3 elements
     */
    @Test
    public void testAddFirstElementAtFirstPosition()
    {
    	integerList = new Array_List_2420();
    	
    	for(int index = 0; index < 1024; index++)
    	{
    		integerList.add_first(index);
    	}
    	
    	integerList.add_first(10000);
    	
    	assertEquals((Integer) 10000, integerList.get_first());
    	assertEquals(1025, integerList.size());
    }
    
    /**
     * TEST 2: Test for adding 3 elements the end of the Array_List
     */
    @Test
    public void testAddLastElementAtLastPosition()
    {	
    	integerList = new Array_List_2420();
    	
    	for(int index = 0; index < 1024; index++)
    	{
    		integerList.add_first(index);
    	}
    	
    	integerList.add_last(99999);
    	
    	assertTrue(integerList.contains(99999));
    	assertEquals((Integer) 99999, integerList.get_last());
    	assertEquals(1025, integerList.size());
    }
    
    /**
     * TEST 3: Test for adding 3 elements to the middle of the ArrayList
     */
    @Test
    public void testAddThreeElementsMiddle()
    {
    	integerList = new Array_List_2420();
    	
    	for(int index = 0; index < 1024; index++)
    	{
    		integerList.add_first(index);
    	}
    	
    	integerList.add_middle(integerList.size() / 2, 101010);
    	
    	assertTrue(integerList.contains(101010));
    	assertEquals(1025, integerList.size());
    }
    
    /**
     * TEST 1: Clear an empty arrayList
     */
    @Test
    public void testClearEmptyArrayList()
    {
    	integerList = new Array_List_2420();
    	
    	integerList.clear();
    	
    	assertFalse(integerList.contains(1));
    	assertEquals(1, integerList.size());
    }
    
    /**
     * TEST 2: Clear an arrayList of small size
     */
    @Test
    public void testClearArrayListWithAFewElements()
    {
    	integerList = new Array_List_2420();
    	
    	integerList.add_first(21);
    	integerList.add_middle(0, 54);
    	integerList.add_last(100);
    	
    	assertTrue(integerList.contains(21));
    	assertTrue(integerList.contains(54));
    	assertTrue(integerList.contains(100));
    	assertEquals(3, integerList.size());
    	
    	integerList.clear();
    	
    	assertFalse(integerList.contains(21));
    	assertFalse(integerList.contains(54));
    	assertFalse(integerList.contains(100));
    	assertEquals(0, integerList.size());
    }
    
    @Test
    public void confirm_arrayListAddMiddle() {
    	arrayTestList.add_first(21);
    	arrayTestList.add_middle(0, 54);
    	arrayTestList.add_first(100);
    	
    	assertTrue(arrayTestList.contains(21));
    	assertTrue(arrayTestList.contains(54));
    	assertTrue(arrayTestList.contains(100));
    	assertEquals(3, arrayTestList.size());
    }
    
    /**
     * TEST 1: Test for getting an empty spot at the first spot from empty ArrayList
     */
    @Test(expected = NoSuchElementException.class)
    public void testGetFirstException()
    {
    	integerList = new Array_List_2420();
    	
    	integerList.get_first();
    }
    
    /**
     * TEST 2: Test for getting an empty spot at the last spot from empty ArrayList
     */
    @Test(expected = NoSuchElementException.class)
    public void testGetLastException()
    {
    	integerList = new Array_List_2420();
    	
    	integerList.get_last();
    }
    
    /**
     * TEST 1: Test for removing an empty spot at the first spot from empty ArrayList
     */
    @Test(expected = NoSuchElementException.class)
    public void testRemoveFirstException()
    {
    	integerList = new Array_List_2420();
    	
    	integerList.remove_first();
    }
 
    /**
     * TEST 2: Test for removing an empty spot at the last spot from empty ArrayList
     */
    @Test(expected = NoSuchElementException.class)
    public void testRemoveLastException()
    {
    	integerList = new Array_List_2420();
    	integerList.remove_last();
    }
    
    /**
     * TEST 1: Test for reversing an empty arrayList
     */
    @Test
    public void testReverseEmptyArrayList()
    {
    	integerList = new Array_List_2420();
    	
    	integerList.reverse();
    	
    	assertEquals(0, integerList.size());
    }
    
    /**
     * TEST 2: Test for reversing a small ArrayList
     */
    @Test
    public void testReverseSmallArrayList()
    {
    	integerList = new Array_List_2420();
    	
    	integerList.add_last(1000);
    	integerList.add_first(1001);
    	
    	integerList.reverse();
    	
    	assertEquals((Integer) 1001, integerList.get_first());
    	assertEquals((Integer) 1000, integerList.get_last());
    }
    
    @Test
    public void confirm_arrayList_reverse() {
    	arrayTestList.add_last(1000);
    	arrayTestList.add_first(1001);
    	
    	arrayTestList.reverse();
    	
    	assertEquals((Integer) 1000, integerList.get_first());
    	assertEquals((Integer) 1001, integerList.get_last());
    }
	
	//XXX Test expand
	
	@Test
	public void test_Array_List_2420_expand_testList_addFirstOnlyThenAddLastOnce() {
		ArrayList<Integer> compareList = new ArrayList<Integer>();
		
		for (int index = 2999; index >= 0; index--) {
			compareList.add(index);
		}
		
		compareList.add(66);
		
		for (int index = 0; index < 3000; index++) {
			arrayTestList.add_first(index);
		}
		
		arrayTestList.add_last(66);
		
		assertEquals(compareList.toString(), arrayTestList.toString());
	}
	
	@Test
	public void test_Array_List_2420_expand_testList_addLastOnlyThenAddFirstOnce() {
		ArrayList<Integer> compareList = new ArrayList<Integer>();
		
		compareList.add(66);
		
		for (int index = 0; index < 3000; index++) {
			compareList.add(index);
		}
		
		for (int index = 0; index < 3000; index++) {
			arrayTestList.add_last(index);
		}
		
		arrayTestList.add_first(66);
		
		assertEquals(compareList.toString(), arrayTestList.toString());
	}
	
	@Test
	public void test_Array_List_2420_expand_testList_mixedAddFirstAddLast() {
		ArrayList<Integer> compareList = new ArrayList<Integer>();
		
		for (int index = 2999; index >= 0; index--) {
			compareList.add(index);
		}
		
		for (int index = 0; index < 3000; index++) {
			compareList.add(index);
		}
		
		for (int index = 0; index < 3000; index++) {
			arrayTestList.add_last(index);
			arrayTestList.add_first(index);
		}
		
		assertEquals(compareList.toString(), arrayTestList.toString());
	}
}
