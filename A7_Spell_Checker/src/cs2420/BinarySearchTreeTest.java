package cs2420;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import cs2420.BinarySearchTree.Node;

/**
 * Provides a collection of JUnit Tests for the Node class and the 
 * BinarySearchTree class
 * 
 * @author Tony Diep, Gabbie Hoyer, last updated 3-02-17
 */
public class BinarySearchTreeTest
{
	//Some Nodes
	
	// XXX Create Nodes
	Node<String> nullLeaf;
	Node<String> leaf;
	Node<String> nodeOnlyLeftChild;
	Node<String> nodeOnlyRightChild;
	Node<String> nodeBothLeftAndRight;
	
	//Some binarySearchTrees
	
	// XXX  
	BinarySearchTree<String> empty;
	BinarySearchTree<String> standardBST;
	BinarySearchTree<String> smallBSTOneNode;
	BinarySearchTree<String> smallBSTFourNodes;
	BinarySearchTree<String> smallBalancedBSTSevenNodes;
	
	BinarySearchTree<String> letters;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception 
	{
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception 
	{
	}

	/**
	 *  //XXX 
	 * Sets up nodes and the BinarySearchTrees
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception 
	{	
		nullLeaf = new Node<String>(null);
		
		leaf = new Node<String>("tony");
		
		nodeOnlyLeftChild = new Node<String>("Big Boi");
		nodeOnlyLeftChild.leftChild = new Node<String>("Left Boi");
		
		nodeOnlyRightChild = new Node<String>("Asian");
		nodeOnlyRightChild.rightChild = new Node<String>("Chinese");
		
		nodeBothLeftAndRight = new Node<String>("Pikachu");
		nodeBothLeftAndRight.leftChild = new Node<String>("Pichu");
		nodeBothLeftAndRight.rightChild = new Node<String>("Raichu");
		
		empty = new BinarySearchTree<String>();
		
		letters = new BinarySearchTree<String>();
		letters.add("c");
		letters.add("d");
		letters.add("ce");
		letters.add("b");
		letters.add("bc");
		letters.add("a");
		letters.add("e");
		letters.remove("d");
		
		
		standardBST = new BinarySearchTree<String>();
		
		smallBSTOneNode = new BinarySearchTree<String>();
		smallBSTOneNode.add("Tony");
		
		smallBSTFourNodes = new BinarySearchTree<String>();
		smallBSTFourNodes.add("Tony");
		smallBSTFourNodes.add("Andrew");
		smallBSTFourNodes.add("Yinqi");
		smallBSTFourNodes.add("Wes");
		
		smallBalancedBSTSevenNodes = new BinarySearchTree<String>();
		smallBalancedBSTSevenNodes.add("Lebouf");
		smallBalancedBSTSevenNodes.add("Damon");
		smallBalancedBSTSevenNodes.add("Spacey");
		smallBalancedBSTSevenNodes.add("Cumberbatch");
		smallBalancedBSTSevenNodes.add("Johansson");
		smallBalancedBSTSevenNodes.add("Legend");
		smallBalancedBSTSevenNodes.add("Stone");
	}

	@After
	public void tearDown() throws Exception 
	{
	}

	//Tests for the Node class

	
	//Test the Node constructor
	
	/**
	 *  //XXX TEST 1
	 */
	@Test
	public void testNullLeafNodeCheckData()
	{
		assertEquals(null, nullLeaf.the_data);
	}
	
	/**
	 *  //XXX TEST 2
	 */
	@Test
	public void testNullLeafForNoLeftChild()
	{
		assertEquals(null, nullLeaf.leftChild);
	}
	
	/**
	 *  //XXX TEST 3
	 */
	@Test
	public void testNullLeafForRightChild()
	{
		assertEquals(null, nullLeaf.rightChild);
	}
	
	//Tests that check for height 
	
	/**
	 *  //XXX TEST 1
	 */
	@Test
	public void testCheckHeightForLeafNode() 
	{
		assertEquals(1, leaf.height());
	}
	
	/**
	 *  //XXX TEST 2
	 */
	@Test
	public void testCheckHeightForLeafNodeWithFourNodes()
	{
		leaf.insert("tina");
		leaf.insert("you");
		leaf.insert("someone");
		leaf.insert("star");
		
		assertEquals(3, leaf.leftChild.height());
	}
	
	/**
	 *  //XXX TEST 3
	 */
	@Test
	public void testLongHeightForNode()
	{
		leaf.the_data = "Anthony";
		leaf.insert("Sandra");
		leaf.insert("Richard");
		leaf.insert("Quagmire");
		leaf.insert("Patrick");
		leaf.insert("Ozzy");
		leaf.insert("Nadine");
		leaf.insert("Mallory");
		
		assertEquals(8, leaf.height());
	}
	
	//Tests for checking an element exists in a node
	
	/**
	 *  //XXX TEST 1
	 */
	@Test(expected = NullPointerException.class)
	public void testContainsNullInLeafNode()
	{
		assertFalse(leaf.contains(null));
	}
	
	/**
	 *  //XXX TEST 2
	 */
	@Test
	public void testContainsForADataThatDoesNotExistInNodeAlready()
	{
		assertFalse(leaf.contains("abcdefghijklmnopqrstuvwxyz"));
	}
	
	/**
	 *  //XXX TEST 3
	 */
	@Test
	public void testContainsForADataThatExistsInANode()
	{
		assertTrue(leaf.contains("tony"));
	}
	
	//Tests that check on the leaf node and whether the leaf node
	//contains any other children nodes
	
	/**
	 *  //XXX TEST 1
	 */
	@Test
	public void testLeafNodeThatDoesNotHaveALeftChild()
	{
		assertEquals(null, leaf.leftChild);
	}
	
	/**
	 *  //XXX TEST 2
	 */
	@Test
	public void testLeafNodeThatDoesNotHaveARightChild()
	{
		assertEquals(null, leaf.rightChild);
	}
	
	/**
	 *  //XXX TEST 3
	 */
	@Test
	public void testLeafNodeContainsDataThatIsNotNull()
	{
		assertTrue(leaf.contains("tony"));
	}
	
	/**
	 *  //XXX TEST 4
	 */
	@Test(expected = NullPointerException.class)
	public void testLeafNodeThatContainsNullAsItsData()
	{
		assertTrue(leaf.contains(null));
	}

	//Tests for the insert method for a leaf node
	
	/**
	 *  //XXX TEST 1
	 */
	@Test
	public void testInsertOneNodeAsTheLeafNodesLeftChild()
	{	
		leaf.insert("tina");
		
		assertTrue(leaf.leftChild.contains("tina"));
	}
	
	/**
	 *  //XXX TEST 2
	 */
	@Test
	public void testInsertOneNodeAsTheLeafNodesRightChild()
	{
		leaf.insert("you");
		
		assertTrue("you", leaf.rightChild.contains("you"));
	}
	
	/**
	 *  //XXX TEST 3
	 */
	@Test
	public void testInsertingLeftChildAndRightChildToLeafNode()
	{
		leaf.insert("tina");
		leaf.insert("you");
		
		assertEquals(2, leaf.height());
		assertTrue(leaf.leftChild.contains("tina"));
		assertTrue(leaf.rightChild.contains("you"));
	}
	
	/**
	 *  //XXX TEST 4
	 */
	@Test
	public void testInsertANodeThatHasADataEqualToTheLeafNodesData()
	{
		leaf.insert("tony");
		
		assertTrue(leaf.contains("tony"));
		assertEquals(1, leaf.height());
	} 
	
	/**
	 *  //XXX TEST 5
	 */
	@Test
	public void testInsertingThreeMoreNodesToTheLeafNodeThatNowHasLeftAndChildrenNodes()
	{
		leaf.insert("tina");
		leaf.insert("you");
		leaf.insert("someone");
		leaf.insert("star");
		
		assertEquals(4, leaf.height());
		assertTrue(leaf.contains("tina"));
		assertTrue(leaf.contains("you"));
		assertTrue(leaf.contains("someone"));
		assertTrue(leaf.contains("star"));
	}
	
	//Tests for the node that has only has a left child and no right child
	
	/**
	 *  //XXX TEST 1
	 */
	@Test
	public void testVerifyThatTheRootHasTheCorrectDataInThere()
	{
		assertTrue(nodeOnlyLeftChild.contains("Big Boi"));
	}
	
	/**
	 *  //XXX TEST 2
	 */
	@Test
	public void testHeightFromNodeToLeftChild()
	{
		assertEquals(2, nodeOnlyLeftChild.height());
	}
	
	/**
	 *  //XXX TEST 3
	 */
	@Test
	public void testTheNodeTrulyDoesHaveALeftChild()
	{
		assertTrue(nodeOnlyLeftChild.leftChild != null);
	}
	
	/**
	 *  //XXX TEST 4
	 */
	@Test
	public void testTheNodeTrulyDoesNotHaveARightChild()
	{
		assertTrue(nodeOnlyLeftChild.rightChild == null);
	}
	
	/**
	 *  //XXX TEST 5
	 */
	@Test
	public void testVerifyTheLeftChildHasTheCorrectData()
	{
		assertTrue(nodeOnlyLeftChild.leftChild.contains("Left Boi"));
	}
	
	//Tests for the node with only a right child and no left chlid
	
	/**
	 *  //XXX TEST 1
	 */
	@Test
	public void testVerifyThatTheRootHasTheCorrectDataInThere2()
	{
		assertTrue(nodeOnlyRightChild.contains("Asian"));
	}
	
	/**
	 *  //XXX TEST 2
	 */
	@Test
	public void testHeightFromNodeToRightChild()
	{
		assertEquals(2, nodeOnlyRightChild.height());
	}
	
	/**
	 *  //XXX TEST 3
	 */
	@Test
	public void testTheNodeTrulyDoesNotHaveALeftChild()
	{
		assertTrue(nodeOnlyRightChild.leftChild == null);
	}
	
	/**
	 *  //XXX TEST 4
	 */
	@Test
	public void testTheNodeTrulyDoesHaveARightChild()
	{
		assertTrue(nodeOnlyRightChild.rightChild != null);
	}
	
	/**
	 *  //XXX TEST 5
	 */
	@Test
	public void testVerifyTheRightChildHasTheCorrectData()
	{
		assertTrue(nodeOnlyRightChild.rightChild.contains("Chinese"));
	}
	
	//Tests for the node that has both a left and right child
	
	/**
	 *  //XXX TEST 1
	 */
	@Test
	public void testVerifyThatTheRootHasTheCorrectDataInThere3()
	{
		assertTrue(nodeBothLeftAndRight.contains("Pikachu"));
	}
	
	/**
	 *  //XXX TEST 2
	 */
	@Test
	public void testHeightFromRootNode()
	{
		assertEquals(2, nodeBothLeftAndRight.height());
	}
	
	/**
	 *  //XXX TEST 3
	 */
	@Test
	public void testTheNodeTrulyHasALeftChild()
	{
		assertTrue(nodeBothLeftAndRight.leftChild != null);
	}
	
	/**
	 *  //XXX TEST 4
	 */
	@Test
	public void testTheNodeTrulyHasARightChild()
	{
		assertTrue(nodeBothLeftAndRight.rightChild != null);
	}
	
	/**
	 *  //XXX TEST 5
	 */
	@Test
	public void testHeightFromRootNodesLeftChild()
	{
		assertEquals(1, nodeBothLeftAndRight.leftChild.height());
	}
	
	/**
	 *  //XXX TEST 6
	 */
	@Test
	public void testHeightFromRootNodesRightChild()
	{
		assertEquals(1, nodeBothLeftAndRight.rightChild.height());
	}
	
	/**
	 *  //XXX TEST 7
	 */
	@Test
	public void testVerifyCorrectDataForLeftChild()
	{
		assertTrue(nodeBothLeftAndRight.leftChild.contains("Pichu"));
	}
	
	/**
	 *  //XXX TEST 8
	 */
	@Test
	public void testVerifyCorrectDataForRightChild()
	{
		assertTrue(nodeBothLeftAndRight.rightChild.contains("Raichu"));
	}
	
	 //Basic test for a standard BST
	
	 /**
	  * TEST 1
	  */
	 @Test 
	 public void testRemoveOneElementFromStandardBST()
	 {
		 BinarySearchTree<Integer> standardBST = new BinarySearchTree<Integer>();
		 standardBST.add(15);
		 standardBST.add(14);
		 standardBST.add(19);
		 standardBST.add(1);
		 standardBST.add(5);
		 standardBST.add(13);
		 standardBST.add(7);
		 standardBST.add(32);
		 
		 assertTrue(standardBST.remove(13));
	 }
	
	//Tests for the empty BST
	
	/**
	 *  //XXX TEST 1
	 */
	@Test
	public void testSizeOfEmptyBST()
	{
		assertEquals(0, empty.size());
	}
	
	/**
	 *  //XXX TEST 2
	 */
	@Test
	public void testEmptyBSTRootNodeIsNull()
	{
		assertTrue(empty.root == null);
	}
	
	/**
	 *  //XXX TEST 3
	 */
	@Test(expected = NoSuchElementException.class)
	public void testGetFirstElementFromEmptyBST()
	{
		empty.first();
	}
	
	/**
	 *  //XXX TEST 4
	 */
	@Test(expected = NoSuchElementException.class)
	public void testLastElementFromEmptyBST()
	{
		empty.last();
	}
	
	/**
	 *  //XXX TEST 5
	 */
	@Test(expected = NullPointerException.class)
	public void testRemoveElementAsNullFromEmptyBST()
	{
		empty.remove(null);
	}
	
	/**
	 *  //XXX TEST 6
	 */
	@Test(expected = NullPointerException.class)
	public void testRemoveAllAsNullFromEmptyBST()
	{
		empty.removeAll(null);
	}
	
	/**
	 *  //XXX TEST 7
	 */
	@Test(expected = NullPointerException.class)
	public void testContainsNullOnEmptyBST()
	{
		empty.contains(null);
	}
	
	/**
	 *  //XXX TEST 8
	 */
	@Test(expected = NullPointerException.class)
	public void testContainsAllOnEmptyBST()
	{
		empty.containsAll(null);
	}
	
	//Tests for a small BST consisting of one node (that is, only the root node)
	
	/**
	 *  //XXX TEST 1
	 */
	@Test
	public void testSizeOfBSTWithOneNode()
	{
		assertEquals(1, smallBSTOneNode.size());
	}
	
	/**
	 *  //XXX TEST 2
	 */
	@Test
	public void testRootNodeThatDoesNotHaveALeftChild()
	{
		assertTrue(smallBSTOneNode.root.leftChild == null);
	}
	
	/**
	 *  //XXX TEST 3
	 */
	@Test
	public void testRootNodeThatDoesNotHaveARightChild()
	{
		assertTrue(smallBSTOneNode.root.rightChild == null);
	}
	
	/**
	 *  //XXX TEST 4
	 */
	@Test
	public void testCheckTheCorrectDataInRootNode()
	{
		assertTrue(smallBSTOneNode.contains("Tony"));
	}
	
	/**
	 *  //XXX TEST 5
	 */
	@Test
	public void testCheckSizeAfterRemovingRootNodeFromBSTOfSizeOne()
	{
		smallBSTOneNode.remove("Tony");
		
		assertEquals(0, smallBSTOneNode.size());
	}
	
	/**
	 *  //XXX TEST 6
	 */
	@Test
	public void testCheckSizeAfterRemovingRootNodeDataFromBSTOfSizeOne()
	{
		smallBSTOneNode.remove("Tony");
		assertEquals(0, smallBSTOneNode.size());
	}
	
	/**
	 *  //XXX TEST 7
	 */
	@Test
	public void testCheckRootIsNullAfterRemovingRootNodeFromBSTOfSizeOne()
	{
		smallBSTOneNode.remove("Tony");
		assertTrue(smallBSTOneNode.root == null);
	}
	
	/**
	 *  //XXX TEST 8
	 */
	@Test
	public void testOneNodeBSTToArrayList()
	{
		assertEquals("[Tony]", smallBSTOneNode.toArrayList().toString());
	}
	
	//Tests for a small BST consisting of 4 nodes (including the root node)
	
	/**
	 *  //XXX TEST 1
	 */
	@Test
	public void testSmallBSTSize()
	{	
		
		assertEquals(4, smallBSTFourNodes.size());
	}
	
	/**
	 *  //XXX TEST 2
	 */
	@Test
	public void testVerifyThatTheRootNodeHasALeftChild()
	{
		assertTrue(smallBSTFourNodes.root.leftChild != null);
	}
	
	/**
	 *  //XXX TEST 3
	 */
	@Test
	public void testVerifyThatTheRootNodeHasARightChild()
	{
		assertTrue(smallBSTFourNodes.root.rightChild != null);
	}

	/**
	 *  //XXX TEST 4
	 */
	@Test
	public void testCheckTheRootNodesData()
	{
		assertTrue("Tony", smallBSTFourNodes.root.contains("Tony"));
	}
	
	/**
	 *  //XXX TEST 5
	 */
	@Test
	public void testCheckTheRootNodesLeftChildData()
	{
		assertTrue("Andrew", smallBSTFourNodes.root.leftChild.contains("Andrew"));
	}
	
	/**
	 *  //XXX TEST 6
	 */
	@Test
	public void testCheckTheRootNodesRightChildData()
	{
		assertTrue("Yinqi", smallBSTFourNodes.root.rightChild.contains("Yinqi"));
	}
	
	/**
	 *  //XXX TEST 7
	 */
	@Test
	public void testCheckTheRootsRightChildsLeftChildNodesData()
	{
		assertTrue("Wes", smallBSTFourNodes.root.rightChild.leftChild.contains("Wes"));
	}
	
	/**
	 *  //XXX TEST 8
	 */
	@Test
	public void testHeightForBSTsRootNodeToLeafNode()
	{
		assertEquals(3, smallBSTFourNodes.root.height());
	}
	
	/**
	 *  //XXX TEST 9
	 */
	@Test
	public void testHeightForRootNodesLeftChild()
	{
		assertEquals(1, smallBSTFourNodes.root.leftChild.height());
	}
	
	/**
	 *  //XXX TEST 10
	 */
	@Test
	public void testHeightForRootNodesRightChildToLeafNode()
	{
		assertEquals(2, smallBSTFourNodes.root.rightChild.height());
	}
	
	/**
	 *  //XXX TEST 11
	 */
	@Test
	public void testHeightForRootNodesRightChildsLeftChildNode()
	{
		assertEquals(1, smallBSTFourNodes.root.rightChild.leftChild.height());
	}
	
	/**
	 *  //XXX TEST 12
	 */
	@Test
	public void testCheckSizeOfBSTAfterClearingTheWholeBST()
	{
		smallBSTFourNodes.clear();
		
		assertEquals(0, smallBSTFourNodes.size());
	}
	
	/**
	 *  //XXX TEST 13
	 */
	@Test
	public void testCheckNoDataExistsAfterClearingTheWholeBST()
	{
		smallBSTFourNodes.clear();
		
		assertTrue(smallBSTFourNodes.isEmpty());
	}
	
	/**
	 *  //XXX TEST 14
	 */
	@Test
	public void testSmallBSTCheckSizeAfterRemovingTheRootsRightsLeftChildNodeFromIt()
	{
		smallBSTFourNodes.remove("Wes");
		
		assertEquals(3, smallBSTFourNodes.size());
	}
	
	/**
	 *  //XXX TEST 15
	 */
	@Test
	public void testSmallBSTCheckDataIsNullAfterRemovingTheMostDepthLeafNode()
	{
		assertTrue(smallBSTFourNodes.root.rightChild.rightChild == null);
	}
	
	/**
	 *  //XXX TEST 16
	 */
	@Test
	public void testSmallBSTOneNodeToArrayList()
	{
		assertEquals("[Andrew, Tony, Wes, Yinqi]", smallBSTFourNodes.toArrayList().toString());
	}
	
	//Tests for a balanced BST with 5 nodes (4 children + the root)
	
	/**
	 *  //XXX TEST 1
	 */
	@Test
	public void testBalancedBSTSize()
	{
		assertEquals(7, smallBalancedBSTSevenNodes.size());
	}
	
	/**
	 *  //XXX TEST 2
	 */
	@Test
	public void testVerifyThatTheRootNodeHasALeftChildSevenNodeBST()
	{
		assertTrue(smallBalancedBSTSevenNodes.root.leftChild != null);
	}
	
	/**
	 *  //XXX TEST 3
	 */
	@Test
	public void testVerifyThatTheRootHasARightChildSevenNodeBST()
	{
		assertTrue(smallBalancedBSTSevenNodes.root.rightChild != null);
	}

	/**
	 *  //XXX TEST 4
	 */
	@Test
	public void testVerifyCorrectDataInRootNodeBSTSevenNodes()
	{
		assertTrue(smallBalancedBSTSevenNodes.root.contains("Lebouf"));
	}
	
	/**
	 *  //XXX TEST 5
	 */
	@Test
	public void testVerifyCorrectDataInRootLeftsChildBSTSevenNodes()
	{
		assertTrue(smallBalancedBSTSevenNodes.root.leftChild.contains("Damon"));
	}
	
	/**
	 *  //XXX TEST 6
	 */
	@Test
	public void testVerifyCorrectDataInRootRightChildBSTSevenNodes()
	{
		assertTrue(smallBalancedBSTSevenNodes.root.rightChild.contains("Spacey"));
	}
	
	/**
	 *  //XXX TEST 7
	 */
	 @Test
	 public void testVerifyCorrectDataInRootLeftsLeftChildBSTSevenNodes()
	 {
		 assertTrue(smallBalancedBSTSevenNodes.root.leftChild.leftChild.contains("Cumberbatch"));
	 }
	 
	 /**
	  *  //XXX TEST 8
	  */
	 @Test
	 public void testVerifyCorrectDataInRootLeftsRightChildBSTSevenNodes()
	 {
		 assertTrue(smallBalancedBSTSevenNodes.root.leftChild.rightChild.contains("Johansson"));
	 }
	 
	 /**
	  *  //XXX TEST 9
	  */
	 @Test
	 public void testVerifyCorrectDataInRootRightsLeftChildBSTSevenNodes()
	 {
		 assertTrue(smallBalancedBSTSevenNodes.root.rightChild.leftChild.contains("Legend"));
	 }
	
	 /**
	  *  //XXX TEST 10
	  */
	 @Test
	 public void testVerifyCorrectDataInRootRightsRightChildBSTSevenNodes()
	 {
		 assertTrue(smallBalancedBSTSevenNodes.root.rightChild.rightChild.contains("Stone"));
	 }
	 
	 /**
	  *  //XXX TEST 11
	  */
	 @Test
	 public void testMaximumHeightOfSevenNodeBSTsRootNode()
	 {
		 assertEquals(3, smallBalancedBSTSevenNodes.root.height());
	 }
	 
	 /**
	  *  //XXX TEST 12
	  */
	 @Test
	 public void testCheckSizeAfterClearingWholeBSTSevenNodes()
	 {
		 smallBalancedBSTSevenNodes.clear();
		 
		 assertEquals(0, smallBalancedBSTSevenNodes.size());
	 }
	 
	 /**
	  *  //XXX TEST 13
	  */
	 @Test
	 public void testCheckNoDataExistsInSevenNodeBST()
	 {
		 smallBalancedBSTSevenNodes.clear();
		 
		 assertTrue(smallBalancedBSTSevenNodes.isEmpty());
	 }
	 
	 /**
	  *  //XXX TEST 14
	  */
	 @Test
	 public void testVerifySizeOfBSTAfterRemovingRootNode()
	 {
		 smallBalancedBSTSevenNodes.remove("Lebouf");
		 
		 assertEquals(6, smallBalancedBSTSevenNodes.size());
	 }
	 
	 /**
	  *  //XXX TEST 15
	  */
	 @Test
	 public void testVerifyInorderPredecessorAsTheNewRootNode()
	 {
		 smallBalancedBSTSevenNodes.remove("Lebouf");
		 
		 assertTrue(smallBalancedBSTSevenNodes.root.contains("Johansson"));
	 }
	 
	 /**
	  *  //XXX TEST 16
	  */
	 @Test
	 public void testSmallBSTSevenNodesToArrayList()
	 {
		 assertEquals("[Cumberbatch, Damon, Johansson, Lebouf, Legend, Spacey, Stone]", smallBalancedBSTSevenNodes.toArrayList().toString());
	 }
	 
	 //Tests for the addAll, removeAll, and containsAll methods for a standard BST
	 
	 /**
	  *  // XXX TEST 1
	  */
	 @Test
	 public void testAddAllElementsToBSTFromCollection()
	 {
		 ArrayList<String> languages = new ArrayList<String>();
		 
		 languages.add("english");
		 languages.add("spanish");
		 languages.add("chinese");
		 languages.add("russian");
		 languages.add("japanese");
		 
		 standardBST.addAll(languages);
		 
		 assertEquals(5, standardBST.size());
	 }
	 
	 /**
	  *  // XXX TEST 2
	  */
	 @Test
	 public void testRemoveAllElementsToBST()
	 {
		 ArrayList<String> languages = new ArrayList<String>();
		 
		 languages.add("english");
		 languages.add("spanish");
		 languages.add("chinese");
		 languages.add("russian");
		 languages.add("japanese");
		 
		 standardBST.addAll(languages);
		 standardBST.removeAll(languages);
		 assertEquals(0, standardBST.size());
	 }
	 
	 /**
	  *  // XXX TEST 3
	  */
	 @Test
	 public void testContainsAllElementsInBST()
	 {
		 ArrayList<String> languages = new ArrayList<String>();
		 
		 languages.add("english");
		 languages.add("spanish");
		 languages.add("chinese");
		 languages.add("russian");
		 languages.add("japanese");
		 
		 standardBST.addAll(languages);
		 
		 assertTrue(standardBST.containsAll(languages));
	 } 
}