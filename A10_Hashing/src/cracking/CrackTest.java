/**
 * 
 */
package cracking;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;

/**
 * Provides a collection of JUnit Tests for the Crack class
 * 
 * @author Tony Diep, Jocee Porter, last updated 4-7-17
 */
public class CrackTest 
{
	ArrayList<String> fewHashesArray;
	ArrayList<String> fewWordsArray;
	ArrayList<String> commonPasswordsCainArray;
	ArrayList<String> commonPasswordsCainDownloadArray;
	ArrayList<String> hashWordsLongArray;
	ArrayList<String> hashWordsShortArray;
	ArrayList<String> JoCeeWords = new ArrayList<String>();
	ArrayList<String> JoCeeWords2 = new ArrayList<String>();
	
	HashSet<String> fewHashesHashSet;
	HashSet<String> fewWordsHashSet;
	HashSet<String> commonPasswordsCainHashSet;
	HashSet<String> commonPasswordsCainDownloadHashSet;
	HashSet<String> hashWordsLongHashSet;
	HashSet<String> hashWordsShortHashSet;


	/**
	 * Sets up ArrayLists and HashSets
	 * 
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp()
	{
		fewWordsArray = Crack.read_file_into_array("Resources/a_few_words");
		fewHashesArray = Crack.read_file_into_array("Resources/a_few_hashes");
		commonPasswordsCainArray = Crack.read_file_into_array("Resources/common_passwords_cain");
		commonPasswordsCainDownloadArray = Crack.read_file_into_array("Resources/common_passwords_cain.crdownload");
		hashWordsLongArray = Crack.read_file_into_array("Resources/hashwords_long");
		hashWordsShortArray = Crack.read_file_into_array("Resources/hashwords_short");
		
		fewWordsHashSet = Crack.read_file_into_hash_set("Resources/a_few_words");
		fewHashesHashSet = Crack.read_file_into_hash_set("Resources/a_few_hashes");
		commonPasswordsCainHashSet = Crack.read_file_into_hash_set("Resources/common_passwords_cain");
		commonPasswordsCainDownloadHashSet = Crack.read_file_into_hash_set("Resources/common_passwords_cain.crdownload");
		hashWordsLongHashSet = Crack.read_file_into_hash_set("Resources/hashwords_long");
		hashWordsShortHashSet = Crack.read_file_into_hash_set("Resources/hashwords_short");
		JoCeeWords = new ArrayList<String>(5);
		JoCeeWords.add("a");
		JoCeeWords.add("e");
		JoCeeWords.add("i");
		JoCeeWords.add("o");
		JoCeeWords2.add("to");
		JoCeeWords2.add("ny");
		JoCeeWords2.add("at");
		JoCeeWords2.add("ox");
		
	}

	/**
	 * @throws java.lang.Exception
	 */

	//Tests for the readFileIntoArray method
	
	/**
	 * TEST 1
	 * 
	 * Verifies the size to ensure that every word in the text file is added to the 
	 * resulting ArrayList
	 */
	@Test
	public void testReadFileIntoArrayWordsSize() 
	{
		assertEquals(10, fewWordsArray.size());
	}

	/**
	 * TEST 2
	 * 
	 * Verifies each word is in the array
	 */
	@Test
	public void testReadFileIntoArrayWordContents()
	{
		assertEquals("[a, cat, and, dog, went, for, ride, on, green, van]", fewWordsArray.toString());
	}
	
	/**
	 * TEST 3
	 * 
	 * Verifies the size to ensure that every hash in the text file is added to the
	 * resulting ArrayList
	 */
	@Test
	public void testReadFileIntoArrayHashesSize()
	{
		assertEquals(10, fewHashesArray.size());
	}
	
	/**
	 * TEST 4
	 * 
	 * Verifies each hash is in the array
	 */
	@Test
	public void testReadFileIntoArrayHashesContents()
	{
		ArrayList<String> expectedHashes = new ArrayList<String>();
		
		expectedHashes.add("0cc175b9c0f1b6a831c399e269772661");
		expectedHashes.add("d077f244def8a70e5ea758bd8352fcd8");
		expectedHashes.add("be5d5d37542d75f93a87094459f76678");
		expectedHashes.add("06d80eb0c50b49a509b49f2424e8c805");
		expectedHashes.add("dd22b70914cd2243e055d2e118741186");
		expectedHashes.add("d55669822f1a8cf72ec1911e462a54eb");
		expectedHashes.add("059763450f095b4973b450eaf58399c1");
		expectedHashes.add("ed2b5c0139cec8ad2873829dc1117d50");
		expectedHashes.add("9f27410725ab8cc8854a2769c7a516b8");
		expectedHashes.add("957d2fa52c19a5aff4ccf5d9a959adab");
		
		for(int index = 0; index < expectedHashes.size(); index++)
		{
			assertEquals(expectedHashes.get(index), fewHashesArray.get(index));
		}
	}
	
	//Tests for the readFileIntoHashSet method
	
	/**
	 * TEST 1
	 * 
	 * Verifies the size to ensure that every word in the text file is added to the 
	 * resulting HashSet 
	 */
	@Test
	public void testReadFileIntoHashSetWordsSize()
	{
		assertEquals(10, fewWordsHashSet.size());
	}
	
	/**
	 * TEST 2
	 * 
	 * Verifies each word is in the hash set
	 */
	@Test
	public void testReadFileIntoHashSetWordsContents()
	{
		for(int index = 0; index < fewWordsHashSet.size(); index++)
		{
			assertTrue(fewWordsHashSet.contains(fewWordsArray.get(index)));
		}
	}
	
	/**
	 * TEST 3
	 * 
	 * Verifies the size to ensure that every hash in the text file is added to the
	 * resulting HashSet
	 */
	@Test
	public void testReadFileIntoHashSetHashesSize()
	{
		assertEquals(10, fewHashesHashSet.size());
	}
	
	/**
	 * TEST 4
	 * 
	 * Verifies that every hash is added to the HashSet
	 */
	@Test
	public void testReadFileIntoHashSetHashesContents()
	{
		for(int index = 0; index < fewHashesHashSet.size(); index++)
		{
			assertTrue(fewHashesHashSet.contains(fewHashesArray.get(index)));
		}
	}
	
	@Test
	public void testBruteForce() throws NoSuchAlgorithmException
	{
		ArrayList<String> JoCeeHash = new ArrayList<String>(JoCeeWords.size());
		for(int i = 0; i< JoCeeWords.size(); i++)
		{
			JoCeeHash.add(i, Crack.md5(JoCeeWords.get(i)) + "");
		}
			System.out.println(Crack.brute_force_attack(JoCeeHash, 1).toString());
		
	}
	
	@Test
	public void testBruteForceTwo() throws NoSuchAlgorithmException
	{
		ArrayList<String> JoCeeHash2 = new ArrayList<String>(JoCeeWords2.size());
		for(int i = 0; i< JoCeeWords2.size(); i++)
		{
			JoCeeHash2.add(i, Crack.md5(JoCeeWords2.get(i)) + "");
		}
		
		@SuppressWarnings("unused")
		ArrayList<String> success = Crack.brute_force_attack(JoCeeHash2, 2);
		System.out.println(Crack.brute_force_attack(JoCeeHash2, 2).toString());
		
	}

}
