package cs2420;

import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

/**
 * Provides a collection of JUnit tests for the Utility class
 * 
 * @author Tony Diep, Alex Cervantes, last updated 4-25-17
 */
public class UtilityTest 
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

	//Tests for the increment method
	
	/**
	 * TEST 1
	 */
	@Test
	public void testIncrementSimple()
	{
		Utility.increment("awesomesauce", commonWordsSymbolsSimple);
		
		assertEquals(2, commonWordsSymbolsSimple.get("awesomesauce").get_frequency());
	}
	
	/**
	 * TEST 2
	 */
	@Test
	public void testIncrementAFewLetters()
	{
		Utility.increment("aaaabbbccd", commonWordsSymbolsFewLetters);
		
		assertEquals(2, commonWordsSymbolsFewLetters.get("aaaabbbccd").get_frequency());
	}
	
	/**
	 * TEST 3
	 */
	@Test
	public void testIncrementAlphabet()
	{
		Utility.increment("abcdefghijklmnopqrstuvwxyz", commonWordsSymbolsAlphabet);
		
		assertEquals(2, commonWordsSymbolsAlphabet.get("abcdefghijklmnopqrstuvwxyz").get_frequency());
	}
	
	/**
	 * TEST 4
	 */
	@Test
	public void testIncrementAlphabetPlus()
	{
		Utility.increment("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ", commonWordsSymbolsAlphabetPlus);
	
		assertEquals(12, commonWordsSymbolsAlphabetPlus.get("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ").get_frequency());
	}
	
	//Tests for the printable_symbol method
	
	/**
	 * TEST 1
	 */
	@Test
	public void testPrintableSymbolSingleAlphabeticalLetter() 
	{
		assertEquals("a", Utility.printable_symbol("a"));
	}
	
	/**
	 * TEST 2
	 */
	@Test
	public void testPrintableSymbolSingleNumericalLetter()
	{
		assertEquals("1", Utility.printable_symbol("1"));
	}
	
	/**
	 * TEST 3
	 */
	@Test
	public void testPrintableSymbolWord()
	{
		assertEquals("alphabet", Utility.printable_symbol("alphabet"));
	}
	
	/**
	 * TEST 4
	 */
	@Test(expected = RuntimeException.class)
	public void testPrintableSymbolJustDoubleQuotes()
	{
		Utility.printable_symbol("");
	}
	
	/**
	 * TEST 5
	 */
	@Test(expected = RuntimeException.class)
	public void testPrintableSymbolNullElement()
	{
		Utility.printable_symbol(null);
	}
	
	/**
	 * TEST 6
	 */
	@Test
	public void testPrintableSymbolSpace()
	{
		assertEquals("SPACE", Utility.printable_symbol(" "));
	}
	
	/**
	 * TEST 7
	 */
	@Test
	public void testPrintableSymbolOctothorpe()
	{
		assertEquals("OCTOTHORPE", Utility.printable_symbol("#"));
	}
	
	/**
	 * TEST 8
	 */
	@Test
	public void testPrintableSymbolQuote()
	{
		assertEquals("QUOTE", Utility.printable_symbol("\""));
	}
}
