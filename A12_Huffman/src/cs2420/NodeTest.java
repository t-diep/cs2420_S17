package cs2420;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Provides a collection of JUnit Tests for the Node class
 * 
 * @author Tony Diep, Alex Cervantes, last updated 4-25-17
 */
public class NodeTest 
{
	//Declare different nodes
	Node leafNodeBlankSymbol;
	Node simpleRootNode;
	Node root;
	Node leftChild; 
	Node rightChild; 
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception 
	{
		//Instantiate the different nodes
		leafNodeBlankSymbol = new Node("", 1);
		leftChild = new Node("alex", 2);
		rightChild = new Node("andrew", 3);
		simpleRootNode = new Node("abc", leftChild, rightChild);
		
	}

	//Tests for the node with a new line symbol with a frequency of 0
	
	/**
	 * TEST 1
	 */
	@Test
	public void testNodeNewLineSymbolConstructorGetSymbol() 
	{
		//Verify the symbol is correct
		assertEquals("", leafNodeBlankSymbol.get_symbol());
	}
	
	/**
	 * TEST 2
	 */
	@Test
	public void testNodeNewLineSymbolConstructorGetFrequency()
	{
		//Verify the frequency of this node's symbol
		assertEquals(1, leafNodeBlankSymbol.get_frequency());
	}
	
	/**
	 * TEST 3
	 */
	@Test
	public void testNodeNewLineSymbolConstructorToString()
	{
		//Verify the string version of this node
		assertEquals("<, 1>", leafNodeBlankSymbol.toString());
	}

	/**
	 * TEST 4
	 */
	@Test
	public void testNodeNewLineSymbolConstructorIsLeaf()
	{
		//Verify this node is a leaf node
		assertTrue(leafNodeBlankSymbol.leaf());
	}
	
	/**
	 * TEST 5
	 */
	@Test
	public void testGetParentNodeNewLineSymbol()
	{
		assertEquals(null, leafNodeBlankSymbol.get_parent());
	}
	
	/**
	 * TEST 6
	 */
	@Test(expected = NullPointerException.class)
	public void testGetParentsLeftChildOfNodeNewLineSymbol()
	{
		leafNodeBlankSymbol.parents_left();
	}
	
	/**
	 * TEST 7
	 */
	@Test
	public void changeParentNodeNewLineSymbol()
	{
		Node tonyNode = new Node("tony", 100);
		
		leafNodeBlankSymbol.set_parent(tonyNode);
		
		//Verify the symbol is correct
		assertEquals("tony", leafNodeBlankSymbol.get_parent().get_symbol());
	}
	
	
	/**
	 * TEST 8
	 */
	@Test
	public void testChangeParentNodeGetFrequency()
	{
		Node tonyNode = new Node("tony", 100);
		leafNodeBlankSymbol.set_parent(tonyNode);
		
		//Verify the frequency of this node's symbol
		assertEquals(101, leafNodeBlankSymbol.get_parent().get_frequency());
	}
	
	/**
	 * TEST 9
	 */
	@Test
	public void testChangeParentNodeToString()
	{
		Node tonyNode = new Node("tony", 100);
		leafNodeBlankSymbol.set_parent(tonyNode);
		
		//Verify the string version of this node
		assertEquals("<tony, 101>", leafNodeBlankSymbol.get_parent().toString());
	}
	

	
	/**
	 * TEST 10
	 */
	@Test
	public void testIncrementByOneNodeNewLineSymbol()
	{
		leafNodeBlankSymbol.increment_frequency();
		
		assertEquals(2, leafNodeBlankSymbol.get_frequency());
	}
	
	/**
	 * TEST 11
	 */
	@Test
	public void testCompareToSameSymbolButDifferentFrequenciesNodeNewLineSymbol()
	{
		leafNodeBlankSymbol.increment_frequency();
		
		assertTrue(leafNodeBlankSymbol.compareTo(new Node("", 2)) == 0);
		assertTrue(leafNodeBlankSymbol.compareTo(new Node("", 100)) < 0);
		assertTrue(leafNodeBlankSymbol.compareTo(new Node("", 0)) > 0);
	}
	
	/**
	 * TEST 12
	 */
	@Test
	public void testCompareToDifferentSymbolsNodeNewLineSymbol()
	{
		assertTrue(leafNodeBlankSymbol.compareTo(new Node("a", 0)) > 0);
		assertFalse(leafNodeBlankSymbol.compareTo(new Node("z", 0)) < 0);
	}
	
	//Tests for a node to be the simple root node; this node will have a left
	//child and a right child but no parent node

	/**
	 * TEST 1
	 */
	@Test
	public void testRootNodeConstructor()
	{
		//Verify the symbol is correct
		assertEquals("abc", simpleRootNode.get_symbol());
		//Verify the frequency of this node's symbol
		assertEquals(0, simpleRootNode.get_frequency());
		//Verify the string version of this node
		assertEquals("<abc, 0>", simpleRootNode.toString());
		//Verify this node is a leaf node
		assertFalse(simpleRootNode.leaf());
	}
	
	/**
	 * TEST 2
	 */
	@Test
	public void testGetParentRootNode()
	{
		assertEquals(null, simpleRootNode.get_parent());
	}
	
	/**
	 * TEST 3
	 */
	@Test(expected = NullPointerException.class)
	public void testGetParentsLeft()
	{
		assertEquals(leftChild, simpleRootNode.parents_left());
	}
	
}
