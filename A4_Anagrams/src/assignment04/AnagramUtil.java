
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
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Sets the program to be an anagram checker
 * 
 * @author Tony Diep, Gabbie Hoyer, last updated 2-9-17
 */
public class AnagramUtil 
{		
	// The String comparator field
	static Comparator<String> stringComparator = new Comparator<String>()
	{
		@Override
		public int compare(String string1, String string2) 
		{		
			String firstStringLowercased = string1.toLowerCase();
			String secondStringLowercased = string2.toLowerCase();
			return firstStringLowercased.compareTo(secondStringLowercased);
		}
	};
	// The Character comparator field
	static Comparator<Character> charComparator = new Comparator<Character>()
	{
		@Override
		public int compare(Character firstChar, Character secondChar) 
		{
			return firstChar.compareTo(secondChar);
		}	
	};
	// The Integer comparator field
	static Comparator<Integer> intComparator = new Comparator<Integer>()
	{
		@Override
		public int compare(Integer firstNum, Integer secondNum) 
		{
			return firstNum.compareTo(secondNum);
		}	
	};
		
	/**
	 * Given an input String, this method sorts the input string using insertion sort
	 * 
	 * @param string -- input String
	 * @return the sorted version of the input String
	 */
	public static String sort(String inputString)
	{
		String toBeSorted = "";
		
		if(inputString.length() < 2 || inputString == null)
		{
			return inputString;
		}
		
		String[] strArray = inputString.split("");
		
		insertionSort(strArray, stringComparator);
		
		for(int index = 0; index < strArray.length; index++)
		{
			toBeSorted += strArray[index];
		}
		
		return toBeSorted;
	}
	
	/**
	 * A generic method using the insertion sorting algorithm
	 * 
	 * @param generic -- any object type array
	 * @param comparator -- a comparator with a custom way to compare elements
	 */
	public static <T> void insertionSort(T[] generic, Comparator<? super T> comparator)
	{		
		int arrayLength = generic.length;
		
		for(int index = 1; index < arrayLength; index++)
		{
			T element = generic[index];
			
			int sortIndex = index - 1;
			
			while(sortIndex >= 0 && comparator.compare(generic[sortIndex], element) >= 0)
			{
				generic[sortIndex + 1] = generic[sortIndex];
				sortIndex = sortIndex - 1;
			}
			
			generic[sortIndex + 1] = element;
		}
	}
	
	/**
	 * Checks whether two given strings are anagrams of each other
	 * 
	 * @param firstWord -- the first String to compare
	 * @param secondWord -- the other String to compare to the first String
	 * @return true if the two String are anagrams and false othewise
	 */
	public static boolean areAnagrams(String firstWord, String secondWord) 
	{
		return sort(firstWord).equals(sort(secondWord));
	}

	/**
	 * Obtains all of the largest anagrams from a list of words in no particular
	 * order.  If there are no words in the list, then this method returns an
	 * empty array
	 *
	 * @param inputStringArray -- the String array containing words
	 * @return an array that finds all of the largest anagrams 
	 */
	public static String[] getLargestAnagramGroup(String[] inputStringArray)
	{	
		//Check if the input string array is empty 
		if(inputStringArray.length < 2 || inputStringArray == null)
		{
			return new String[0];
		}
		
		//Create a copy of the input string array
		String[] copyInputStringArray = inputStringArray.clone();
		
		//Alphabetically sort the input string array using insertion sort
		insertionSort(copyInputStringArray, stringComparator);
				
		//Get the first element from the input string array
		String currentWord = copyInputStringArray[0];
		
		//Create indexing to track strings in the array
		int anagramCount = 1;
		int largestAnagramLength = 1;
		int indexForLargeGroup = 0;
		int endIndexForLargeGroup = 0;
		int groupIndex = 0;
		
		//Go through the entire clone of the input string array
		for(int index = 1; index < copyInputStringArray.length; index++)
		{	
			//Compare the current word with the previous word if the two are anagrams
			if(areAnagrams(currentWord, copyInputStringArray[index]))
			{
				anagramCount++;
				
				if(anagramCount > largestAnagramLength)
				{
					indexForLargeGroup = groupIndex;
					largestAnagramLength = anagramCount;
					endIndexForLargeGroup = index;
				}	
			}
			else
			{
				currentWord = copyInputStringArray[index];
				anagramCount = 1;
				groupIndex = index;
			}		
		}
		
		//Create a separate array for the anagram groups
		String[] largestAnagrams;
		
		if(largestAnagramLength > 1)
		{
			largestAnagrams = new String[endIndexForLargeGroup - indexForLargeGroup + 1];
		
			for(int index = 0; index < largestAnagrams.length; index++)
			{
				largestAnagrams[index] = copyInputStringArray[index + indexForLargeGroup];  
			}
		}
		else
		{
			largestAnagrams = new String[0];
		}
		
		return largestAnagrams;
	}
	
	/**
	 * Obtains all of the largest anagrams from a file that contains a list of words in no particular
	 * order.  If there are no words in the file, then this method returns an
	 * empty array
	 *
	 * @param fileName -- the url to a text file containing a list of words
	 * @return an array that finds all of the largest anagrams 
	 */
	public static String[] getLargestAnagramGroup(String fileName)
	{		
		if(fileName == null || fileName == "")
		{
			return new String[0];
		}
		
		String[] listOfWords;
		Scanner scanner = null;
		ArrayList<String> wordsFromFile = new ArrayList<String>();
		File textFile = new File(fileName);
		
		try
		{
			scanner = new Scanner(textFile);
			
			while(scanner.hasNextLine())
			{
				String currentToken = scanner.nextLine();
				wordsFromFile.add(currentToken);
			}
		}
		catch(FileNotFoundException fnfe)
		{
			System.out.println("File not found");
		}
		
		listOfWords = new String[wordsFromFile.size()];
		for(int index = 0; index < listOfWords.length; index++)
		{
			listOfWords[index] = wordsFromFile.get(index);
		}
		
		return getLargestAnagramGroup(listOfWords);
	}
}
