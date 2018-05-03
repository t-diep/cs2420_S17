package cs2420;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.io.File;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

/**
 * Provides a collection of JUnit tests for the Huffman Tree class
 * 
 * @author Tony Diep, Alex Cervantes, last updated 4-25-17
 */
public class HuffmanTreeUsingWordsTest 
{
	//Simple Huffman Tree
	ArrayList<Character> nodes;
	Hashtable<String, Node> commonWordsSymbolsSimple;
	Hashtable<String, Node> remainingSymbolsSimple;
	HuffmanTreeUsingWords simple;
	List<String> aList = new ArrayList<>();
	Node nodeSimple;
	
	//A few letters Huffman Tree
	ArrayList<Character> nodesForFewLetters;
	Hashtable<String, Node> commonWordsSymbolsFewLetters;
	Hashtable<String, Node> remainingSymbolsFewLetters;
	HuffmanTreeUsingWords fewLetters;
	Node nodeFewLetters;
	
	//Alphabet Huffman Tree
	ArrayList<Character> nodesForAlphabet;
	Hashtable<String, Node> commonWordsSymbolsAlphabet;
	Hashtable<String, Node> remainingSymbolsAlphabet;
	HuffmanTreeUsingWords alphabet;
	Node nodeAlphabet;
	
	//Alphabet Plus Huffman Tree
	ArrayList<Character> nodesForAlphabetPlus;
	Hashtable<String, Node> commonWordsSymbolsAlphabetPlus;
	Hashtable<String, Node> remainingSymbolsAlphabetPlus;
	HuffmanTreeUsingWords alphabetPlus;
	Node nodeAlphabetPlus;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception 
	{	
		simple = new HuffmanTreeUsingWords(1);
		nodes = HuffmanTreeUsingWords.read_file(new File("Resources/simple"));
		commonWordsSymbolsSimple = HuffmanTreeUsingWords.compute_most_common_word_symbols(nodes, 1);
		remainingSymbolsSimple = HuffmanTreeUsingWords.compute_remaining_single_character_symbols(nodes, commonWordsSymbolsSimple, aList);
		nodeSimple = HuffmanTreeUsingWords.create_tree(commonWordsSymbolsSimple.values());
	
		fewLetters = new HuffmanTreeUsingWords(1);
		nodesForFewLetters = HuffmanTreeUsingWords.read_file(new File("Resources/a_few_letters"));
		commonWordsSymbolsFewLetters = HuffmanTreeUsingWords.compute_most_common_word_symbols(nodesForFewLetters, 1);
		remainingSymbolsFewLetters = HuffmanTreeUsingWords.compute_remaining_single_character_symbols(nodesForFewLetters, commonWordsSymbolsFewLetters, aList);
		nodeFewLetters = HuffmanTreeUsingWords.create_tree(commonWordsSymbolsFewLetters.values());
		
		alphabet = new HuffmanTreeUsingWords(1);
		nodesForAlphabet = HuffmanTreeUsingWords.read_file(new File("Resources/alphabet"));
		commonWordsSymbolsAlphabet = HuffmanTreeUsingWords.compute_most_common_word_symbols(nodesForAlphabet, 1);
		remainingSymbolsAlphabet = HuffmanTreeUsingWords.compute_remaining_single_character_symbols(nodesForAlphabet, commonWordsSymbolsAlphabet, aList);
		nodeAlphabet = HuffmanTreeUsingWords.create_tree(commonWordsSymbolsAlphabet.values());
		
		alphabetPlus = new HuffmanTreeUsingWords(1);
		nodesForAlphabetPlus = HuffmanTreeUsingWords.read_file(new File("Resources/alphabetplus"));
		commonWordsSymbolsAlphabetPlus = HuffmanTreeUsingWords.compute_most_common_word_symbols(nodesForAlphabetPlus, 1);
		remainingSymbolsAlphabetPlus = HuffmanTreeUsingWords.compute_remaining_single_character_symbols(nodesForAlphabetPlus, commonWordsSymbolsAlphabetPlus, aList);
		nodeAlphabetPlus = HuffmanTreeUsingWords.create_tree(commonWordsSymbolsAlphabetPlus.values());
	}

	//////////////////////////////////////////////////////////////////////
	
	//Tests for the simple Huffman Tree 
	
	/**
	 * TEST 1
	 */
	@Test
	public void testReadFileSimple() 
	{
		assertEquals(13, nodes.size());
	}

	/**
	 * TEST 2
	 */
	@Test
	public void testMostCommonWordsSymbolsSimple()
	{
		assertEquals(1, commonWordsSymbolsSimple.size());
	}
	
	/**
	 * TEST 3
	 */
	@Test
	public void testMostCommonWordsSymbolSimpleContainsAwesomeSauce()
	{
		assertTrue(commonWordsSymbolsSimple.containsKey("awesomesauce"));
	}
	
	/**
	 * TEST 4
	 */
	@Test
	public void testComputeRemainingSingleCharacterSymbolsSimple()
	{
		assertEquals(3, remainingSymbolsSimple.size());
	}
	
	/**
	 * TEST 5
	 */
	@Test
	public void testComputeRemainingSingleCharacterSymbolsSimpleContainsAwesomesauce()
	{
		assertTrue(remainingSymbolsSimple.containsKey("awesomesauce"));
	}
	
	/**
	 * TEST 6
	 */
	@Test
	public void testComputeRemainingSingleCharacterSymbolsSimpleContainsNewLine()
	{
		assertTrue(remainingSymbolsSimple.containsKey("\n"));
	}
	
	/**
	 * TEST 7
	 */
	@Test
	public void testComputeRemainingSingleCharacterSymbolsSimpleContainsEOF()
	{
		assertTrue(remainingSymbolsSimple.containsKey("EOF"));
	}
	
	/**
	 * TEST 8 
	 */
	@Test
	public void testCreateTreeSimpleCheckFrequency()
	{
		assertEquals(1, nodeSimple.get_frequency());
	}
	
	/**
	 * TEST 9
	 */
	@Test
	public void testCreateTreeSimpleCheckSymbol()
	{
		assertEquals("awesomesauce", nodeSimple.get_symbol());
	}
	
	/**
	 * TEST 10
	 */
	@Test
	public void testCreateTreeSimpleVerifyThisNodeIsALeaf()
	{
		assertTrue(nodeSimple.leaf());
	}
	
	/**
	 * TEST 11
	 */
	@Test
	public void testCreateTreeSimpleVerifyNoParent()
	{
		assertTrue(nodeSimple.get_parent() == null);
	}
		
	//////////////////////////////////////////////////////////////////////
	
	//Tests for the "A Few Letters" Huffman Tree
	
	/**
	 * TEST 1
	 */
	@Test
	public void testReadFileAFewLetters()
	{
		assertEquals(11, nodesForFewLetters.size());
	}
	
	/**
	 * TEST 2
	 */
	@Test
	public void testMostCommonWordsSymbolsAFewLetters()
	{
		assertEquals(1, commonWordsSymbolsFewLetters.size());
	}
	
	/**
	 * TEST 3
	 */
	@Test
	public void testMostCommonWordsSymbolsAFewLettersContainsAAAABBBCCD()
	{
		assertTrue(commonWordsSymbolsFewLetters.containsKey("aaaabbbccd"));
	}
	
	/**
	 * TEST 4
	 */
	@Test
	public void testComputeRemainingSymbolsSingleCharacterAFewLetters()
	{
		assertEquals(3, remainingSymbolsFewLetters.size());
	}
	
	/**
	 * TEST 5
	 */
	@Test
	public void testComputeRemainingSymbolsSingleCharacterSymbolsContainsNewLine()
	{
		assertTrue(remainingSymbolsFewLetters.containsKey("\n"));
	}
	
	/**
	 * TEST 6
	 */
	@Test
	public void testComputeRemainingSymbolsSingleCharacterSymbolsContainsEOF()
	{
		assertTrue(remainingSymbolsFewLetters.containsKey("EOF"));
	}
	
	/**
	 * TEST 7
	 */
	@Test
	public void testCreateTreeFewLettersCheckFrequency()
	{
		assertEquals(1, nodeFewLetters.get_frequency());
	}
	
	/**
	 * TEST 8
	 */
	@Test
	public void testCreateTreeFewLettersCheckSymbol()
	{
		assertEquals("aaaabbbccd", nodeFewLetters.get_symbol());
	}
	
	/**
	 * TEST 9
	 */
	@Test
	public void testCreateTreeVerifyNoParent()
	{
		assertTrue(nodeFewLetters.get_parent() == null);
	}
	
	/**
	 * TEST 10
	 */
	@Test
	public void testCreateTreeVerifyThisNodeIsALeaf()
	{
		assertTrue(nodeFewLetters.leaf());
	}
	
	//////////////////////////////////////////////////////////////////////
	
	
	//////////////////////////////////////////////////////////////////////
	
	//Tests for the "Alphabet" Huffman Tree
	
	/**
	 * TEST 1
	 */
	@Test
	public void testReadFileAlphabet()
	{
		assertEquals(27, nodesForAlphabet.size());
	}
	
	/**
	 * TEST 2
	 */
	@Test
	public void testMostCommonWordsSymbolsAlphabetContainsAlphabetString()
	{
		assertTrue(commonWordsSymbolsAlphabet.containsKey("abcdefghijklmnopqrstuvwxyz"));
	}
	
	/**
	 * TEST 3
	 */
	@Test
	public void testRemainingSingleCharacterSymbolsAlphabet()
	{
		assertEquals(3, remainingSymbolsAlphabet.size());
	}
	
	/**
	 * TEST 4
	 */
	@Test
	public void testRemainingSingleCharacterSymbolsAlphabetNewLine()
	{
		assertTrue(remainingSymbolsAlphabet.containsKey("\n"));
	}
	
	/**
	 * TEST 5
	 */
	@Test
	public void testRemainingSingleCharacterSymbolsAlphabetEOF()
	{
		assertTrue(remainingSymbolsAlphabet.containsKey("EOF"));
	}
	
	/**
	 * TEST 6
	 */
	@Test
	public void testCreateTreeAlphabetCheckFrequency()
	{
		assertEquals(1, nodeAlphabet.get_frequency());
	}
	
	/**
	 * TEST 7
	 */
	@Test
	public void testCreateTreeAlphabetCheckSymbol()
	{
		assertEquals("abcdefghijklmnopqrstuvwxyz", nodeAlphabet.get_symbol());
	}
	
	/**
	 * TEST 8
	 */
	@Test
	public void testCreateTreeAlphabetVerifyNoParent()
	{
		assertTrue(nodeAlphabet.get_parent() == null);
	}
	
	/**
	 * TEST 9
	 */
	@Test
	public void testCreateTreeAlphabetVerifyThisNodeIsALeaf()
	{
		assertTrue(nodeAlphabet.leaf());
	}
	
	//////////////////////////////////////////////////////////////////////

	
	
	//////////////////////////////////////////////////////////////////////
	
	//Tests for the "Alphabet Plus" Huffman Tree
	
	/**
	 * TEST 1
	 */
	@Test
	public void testReadFileAlphabetPlus()
	{
		assertEquals(63, nodesForAlphabetPlus.size());
	}
	
	/**
	 * TEST 2
	 */
	@Test
	public void testMostCommonWordsSymbolsAlphabetPlus()
	{
		assertEquals(1, commonWordsSymbolsAlphabetPlus.size());
	}
	
	/**
	 * TEST 3
	 */
	@Test
	public void testComputeRemainingSingleCharacterSymbolsAlphabetPlus()
	{
		assertEquals(13, remainingSymbolsAlphabetPlus.size());
	}
	
	/**
	 * TEST 4
	 */
	@Test
	public void testComputeRemainingSingleCharacterSymbolsAlphabetPlusContainsLetterA()
	{
		assertTrue(remainingSymbolsAlphabetPlus.containsKey("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"));
	}
	
	/**
	 * TEST 5
	 */
	@Test
	public void testComputeRemainingSingleCharacterSymbolsAlphabetPlusContainsNewLine()
	{
		assertTrue(remainingSymbolsAlphabetPlus.containsKey("\n"));
	}
	
	/**
	 * TEST 6
	 */
	@Test
	public void testComputeRemainingSingleCharactersSymbolsAlphabetPlusContainsEOF()
	{
		assertTrue(remainingSymbolsAlphabetPlus.containsKey("EOF"));
	}
	
	/**
	 * TEST 7
	 */
	@Test
	public void testCreateTreeAlphabetPlusCheckFrequency()
	{
		assertEquals(11, nodeAlphabetPlus.get_frequency());
	}
	
	/**
	 * TEST 8
	 */
	@Test
	public void testCreateTreeAlphabetPlusCheckSymbol()
	{
		assertEquals("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ", nodeAlphabetPlus.get_symbol());
	}
	
	/**
	 * TEST 9
	 */
	@Test
	public void testCreateTreeAlphabetPlusVerifyNoParent()
	{
		assertTrue(nodeAlphabetPlus.get_parent() == null);
	}
	
	/**
	 * TEST 10
	 */
	@Test
	public void testCreateTreeAlphabetPlusVerifyThisNodeIsALeaf()
	{
		assertTrue(nodeAlphabetPlus.leaf());
	}
	
	/////////////////////////////////////////////////////////////////////	
}