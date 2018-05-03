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

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Provides a collection of JUnit Tests for the AnagramUtil class
 * 
 * @author Tony Diep, Gabbie Hoyer, last updated 2-9-17
 */
public class AnagramUtilTest 
{
	// Some String fields
	String emptyString;
	String lotsOfAChars;
	String twoLetterWord;
	String intermediateWord;
	String longWord;
	String someUpperandLowerCases;
	String wordWithMultipleAnagrams;
	String wordWithEndPunctuation;
	
	// Some Integer array fields
	Integer[] smallArrayInt;
	Integer[] alreadySortedArrayInt;
	Integer[] notSortedArrayInt;
	
	// Some Character array fields
	Character[] emptyCharArray;
	Character[] smallArrayChar;
	Character[] notSortedArrayChar;
	Character[] thousandCharArray;

	// Some String array constants
	String[] emptyStringArray;
	String[] smallArrayString;
	String[] alreadySortedArrayString;
	String[] notSortedArrayString;
	String[] thousandStringArray;
	
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
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception 
	{
		emptyString = "";
		twoLetterWord = "no";
		lotsOfAChars = "aaaaaaaa";
		intermediateWord = "cinema";
		longWord = "conversationalists";
		someUpperandLowerCases = "ReSERve";
		wordWithMultipleAnagrams = "saltier";
		wordWithEndPunctuation = "treason!";
		
		smallArrayInt = new Integer[10];
		alreadySortedArrayInt = new Integer[1000];
		notSortedArrayInt = new Integer[1000];
		
		emptyCharArray = new Character[0];
		smallArrayChar = new Character[4];
		notSortedArrayChar = new Character[10];
		thousandCharArray = new Character[1000];
		
		emptyStringArray = new String[0];
		smallArrayString = new String[10];
		alreadySortedArrayString = new String[1000];
		notSortedArrayString = new String[1000];
		thousandStringArray = new String[1000];
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception 
	{
	
	}

	//Tests for the sort method
	
	/**
	 * TEST 1
	 */
	@Test
	public void testSortEmptyString() 
	{
		assertEquals("", AnagramUtil.sort(emptyString));
	}
	
	/**
	 * TEST 2
	 */
	@Test
	public void testSortTwoLetterWord()
	{
		assertEquals("no", AnagramUtil.sort(twoLetterWord));
	}
	
	/**
	 * TEST 3
	 */
	@Test
	
	public void testSortStringWithOnlyAChars()
	{
		assertEquals("aaaaaaaa", AnagramUtil.sort(lotsOfAChars));
	}
	
	/**
	 * TEST 4
	 */
	@Test
	public void testSortTheWordCinema()
	{
		assertEquals("aceimn", AnagramUtil.sort(intermediateWord));
	}
	
	/**
	 * TEST 5
	 */
	@Test
	public void testSortALongWord()
	{
		assertEquals("aaceiilnnoorsssttv", AnagramUtil.sort(longWord));
	}

	/**
	 * TEST 6
	 */
	@Test
	public void testSortAWordWithSomeUppercaseAndLowercase()
	{
		assertEquals("eEeRRSv", AnagramUtil.sort(someUpperandLowerCases));
	}
	
	/**
	 * TEST 7
	 */
	@Test
	public void testSortAWordThatHasMoreThanOnePossibleAnagram()
	{
		assertEquals("aeilrst", AnagramUtil.sort(wordWithMultipleAnagrams));
	}
	
	/**
	 * TEST 8
	 */
	@Test
	public void testSortAWordThatHasAnEndPunctuation()
	{
		assertEquals("!aenorst", AnagramUtil.sort(wordWithEndPunctuation));
	}
	
	//Tests for the insertion method for the Integer[] array
	
	/**
	 * TEST 1
	 */
	@Test
	public void testInsertionSortForSortedIntegerArray()
	{
		Integer[] expectedArray = new Integer[1000];
		
		for(int index = 0; index < 1000; index++)
		{
			alreadySortedArrayInt[index] = index;
			expectedArray[index] = index;
		}	
		
		//AnagramUtil.insertionSort(alreadySortedArray, comparator);
		assertArrayEquals(expectedArray, alreadySortedArrayInt);
	}
	
	/**
	 * TEST 2
	 */
	@Test
	public void testInsertionSortForNonSortedIntegerArray()
	{
		Integer[] expectedArray = new Integer[1000];
		
		Random generator = new Random();
		
		int randValue = 0;
		
		for(int index = 0; index < 1000; index++)
		{
			randValue = generator.nextInt(1000);
			
			expectedArray[index] = randValue;
			notSortedArrayInt[index] = randValue;
		}
		
		Arrays.sort(expectedArray);
		
		AnagramUtil.insertionSort(notSortedArrayInt, AnagramUtil.intComparator);
		
		
		assertArrayEquals(expectedArray, notSortedArrayInt);
	}
	
	//Tests for the insertion sort method for the Character[] array
	
	/**
	 * TEST 1
	 */
	@Test
	public void testInsertionSortForAnEmptyCharacterArray()
	{
		AnagramUtil.insertionSort(emptyCharArray, AnagramUtil.charComparator);
		assertArrayEquals(new Character[0], emptyCharArray);
	}
	
	/**
	 * TEST 2
	 */
	@Test
	public void testInsertionSortForASmallCharacterArray()
	{
		smallArrayChar[0] = 't';
		smallArrayChar[1] = 'o';
		smallArrayChar[2] = 'n';
		smallArrayChar[3] = 'y';
		
		AnagramUtil.insertionSort(smallArrayChar, AnagramUtil.charComparator);
	
		assertEquals((Character)'n', smallArrayChar[0]);
		assertEquals((Character) 'o', smallArrayChar[1]);
		assertEquals((Character) 't', smallArrayChar[2]);
		assertEquals((Character) 'y', smallArrayChar[3]);
	}
	
	/**
	 * TEST 3
	 */
	@Test
	public void testInsertionSortForAnUnsortedCharacterArray()
	{	
		Character[] expected = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j'};
		
		notSortedArrayChar[0] = 'g';
		notSortedArrayChar[1] = 'a';
		notSortedArrayChar[2] = 'h';
		notSortedArrayChar[3] = 'b';
		notSortedArrayChar[4] = 'j';
		notSortedArrayChar[5] = 'i';
		notSortedArrayChar[6] = 'f';
		notSortedArrayChar[7] = 'c';
		notSortedArrayChar[8] = 'e';
		notSortedArrayChar[9] = 'd';
		
		AnagramUtil.insertionSort(notSortedArrayChar, AnagramUtil.charComparator);
		
		assertArrayEquals(expected, notSortedArrayChar);
	}
	
	//Tests for the insertionSort method for Strings
	
	/**
	 * TEST 1
	 */
	@Test
	public void testInsertionSortEmptyStringArray()
	{
		AnagramUtil.insertionSort(emptyStringArray, AnagramUtil.stringComparator);
		assertArrayEquals(new String[]{}, emptyStringArray);
	}
	
	/**
	 * TEST 2
	 */
	@Test
	public void testInsertionSortSmallStringArray()
	{
		smallArrayString[0] = "eggs";;
		smallArrayString[1] = "sausage";
		smallArrayString[2] = "carrot";
		smallArrayString[3] = "olives";
		smallArrayString[4] = "sushi";
		smallArrayString[5] = "brussels";
		smallArrayString[6] = "guacamole";
		smallArrayString[7] = "zucchini";
		smallArrayString[8] = "anchovies";
		smallArrayString[9] = "daquiri";
		
		AnagramUtil.insertionSort(smallArrayString, AnagramUtil.stringComparator);
		
		String[] expected = {"anchovies", "brussels", "carrot", "daquiri", "eggs", "guacamole", "olives", "sausage", "sushi", "zucchini"};
		
		assertArrayEquals(expected, smallArrayString);
	}
	
	/**
	 * TEST 3
	 */
	@Test
	public void testInsertionSortThousandStringArray()
	{
		for(int index = 0; index < 1000; index++)
		{
			thousandStringArray[index] = index + "";
		}
		
		AnagramUtil.insertionSort(thousandStringArray, AnagramUtil.stringComparator);
		
		assertEquals("0", thousandStringArray[0]);
		assertEquals("10", thousandStringArray[2]);
		assertEquals(1000, thousandStringArray.length);
		
	}
	
	//Tests for the areAnagrams method
	
	/**
	 * TEST 1
	 */
	@Test
	public void testAreAnagrams1()
	{
		assertTrue(AnagramUtil.areAnagrams("no", "on"));
	}
	
	/**
	 * TEST 2
	 */
	@Test
	public void testAreAnagrams2()
	{
		assertFalse(AnagramUtil.areAnagrams("pencil", "penzoil"));
	}
	
	/**
	 * TEST 3 
	 */
	@Test
	public void testAreAnagrams3()
	{
		assertTrue(AnagramUtil.areAnagrams(lotsOfAChars, "aaaaaaaa"));
	}
	
	/**
	 * TEST 4
	 */
	@Test
	public void testAreAnagrams4()
	{
		assertFalse(AnagramUtil.areAnagrams("abababababa", "babababababa"));
	}
	
	/**
	 * TEST 5
	 */
	@Test
	public void testAreAnagrams5()
	{
		assertTrue(AnagramUtil.areAnagrams("teaching", "teaching"));
	}
	
	
	//Tests for the getLargestAnagramGroup method
	
	/**
	 * TEST 1
	 */
	@Test
	public void testFirstGetLargestAnagramGroupMethodEmptyStringInputArray()
	{
		//Verify the size of the output array
		assertEquals(0, AnagramUtil.getLargestAnagramGroup(emptyStringArray).length);
		//Verify that the empty input string array will return an empty string array
		assertArrayEquals(new String[]{}, AnagramUtil.getLargestAnagramGroup(emptyStringArray));
	}
	
	/**
	 * TEST 2
	 */
	@Test
	public void testFirstGetLargestAnagramGroupWithInputStringArrayContainingAllSameWord()
	{
		for(int index = 0; index < 10; index++)
		{
			smallArrayString[index] = "java";
		}
		
		String[] allJavaNothingElse = {"java", "java", "java", "java", "java", "java", "java", "java", "java", "java"};
		
		assertArrayEquals(allJavaNothingElse, AnagramUtil.getLargestAnagramGroup(smallArrayString));
	}
	
	/**
	 * TEST 3
	 */
	@Test
	public void testFirstGetLargestAnagramGroupMethodWithInputArrayContainingNoAnagrams()
	{
		for(int wordNum = 0; wordNum < 1000; wordNum++)
		{
			thousandStringArray[wordNum] = wordNum + "w";
		}
		
		assertArrayEquals(new String[]{}, AnagramUtil.getLargestAnagramGroup(thousandStringArray));
	}
	
	
	//Tests for the other getLargestAnagramGroup method
	
	/**
	 * TEST 1
	 */
	@Test
	public void testSecondGetLargestAnagramGroupMethodEmptyTextFile()
	{
		//Verify the size of the output array
		assertEquals(0, AnagramUtil.getLargestAnagramGroup("Resources/empty_text_file").length);
		//Verify that the empty text file should return an empty String array
		assertArrayEquals(new String[]{}, AnagramUtil.getLargestAnagramGroup("Resources/empty_text_file"));
	}
	
	/**
	 * TEST 2
	 */
	@Test
	public void testSecondGetLargestAnagramGroupWithTheDocumentNamedWords()
	{
		String[] largestAnagramGroup = AnagramUtil.getLargestAnagramGroup("Resources/words");
		
		//Test the size of the largest anagram group
		assertEquals(2, largestAnagramGroup.length);
	
		HashSet<String> anagrams = new HashSet<String>();
		
		//Add all of the anagrams from the largest group to the HashSet
		for(int index = 0; index < largestAnagramGroup.length; index++)
		{
			anagrams.add(largestAnagramGroup[index]);
		}
		
		//Check if the largest anagram group contains the token(s) we are expecting
		assertFalse(anagrams.contains("diapers"));
		assertFalse(anagrams.contains("despair"));
	}
	
	/**
	 * TEST 3
	 */
	@Test
	public void testSecondGetLargestAnagramGroupMethodWithASmallWordList()
	{
		String[] largestAnagramGroup = AnagramUtil.getLargestAnagramGroup("Resources/small_word_list");
		
		//Verify for the size of the largest anagrams group array
		assertEquals(3, largestAnagramGroup.length);
		
		HashSet<String> anagrams = new HashSet<String>();
		
		for(int index = 0; index < largestAnagramGroup.length; index++)
		{
			anagrams.add(largestAnagramGroup[index]);
		}
		
		assertTrue(anagrams.contains("carets"));
		assertTrue(anagrams.contains("caster"));
		assertTrue(anagrams.contains("caters"));
	}
	
	/**
	 * TEST 4
	 */
	@Test
	public void testSecondGetLargestAnagramGroupMethodWithAWordListContainingNoAnagrams()
	{
		String[] noAnagrams = AnagramUtil.getLargestAnagramGroup("Resources/no_anagrams");
		
		//Verify the length of the output string array
		assertEquals(0, noAnagrams.length);
	}
}
