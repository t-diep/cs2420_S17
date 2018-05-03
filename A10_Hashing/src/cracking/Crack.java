package cracking;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Contains a library full of static methods and static fields
 * used for cracking passwords and hashing algorithms
 * 
 * @author Tony Diep, Jocee Porter, last updated 4-7-17
 */
public class Crack 
{
	//Flag for setting our collection to an ArrayList or a HashSet
	public static final boolean I_DID_NOT_STUDY_ALGORITHMS = true;
	//Stores all lowercased 26 letters in alphabet; a helper field for concatenating chars to StringBuilder
	static char[] letters = {'a','b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y','z'};

	/**
	 * Adds all words in a text file to an array 
	 * 
	 * @param file_name -- the String url of the file name
	 * @return the list containing all of the words in a text file
	 */
	static public ArrayList<String> read_file_into_array( String file_name )
	{
		ArrayList<String> words = new ArrayList<String>();
		BufferedReader inputReader = null;
		int counter =0;

		String line = "";

		try 
		{
			inputReader = new BufferedReader(new FileReader(file_name));

			while((line = inputReader.readLine()) != null && counter < 79)
			{
				words.add(line);
				counter++;
			}

			inputReader.close();

		} catch (FileNotFoundException fileNotFound) {
			System.out.println("File could not be found...");
		} catch (IOException ioException) {
			System.out.println("BufferedReader error occurred...");
		}

		return words;
	}

	/**
	 * Adds all words in a text file to a hash set
	 * 
	 * @param file_name -- the String url of the file name
	 * @return the hash set containing all of the words in a text file
	 */
	static public HashSet<String> read_file_into_hash_set( String file_name )
	{
		HashSet<String> words = new HashSet<String>();
		BufferedReader inputReader = null;

		String line = "";

		try 
		{
			inputReader = new BufferedReader(new FileReader(file_name));

			while((line = inputReader.readLine()) != null)
			{
				words.add(line);
			}

			inputReader.close();

		} catch (FileNotFoundException fileNotFound) {
			System.out.println("File could not be found...");
		} catch (IOException ioException) {
			System.out.println("BufferedReader error occurred...");
		}

		return words;
	}

	/**
	 * Driver method to perform a brute force attack for password cracking
	 * 
	 * @param hashes
	 *            - hashes that you are seeing if you can find matches to
	 * @param max_length
	 *            - how many characters the passwords can be (in length)
	 * @return the list of found passwords and their corresponding md5 hashes (e.g., [ "cat :
	 *         d077f244def8a70e5ea758bd8352fcd8AB3293292CEF2342ACD32342" ])
	 * @throws NoSuchAlgorithmException -- if the algorithm trying to implement does not exist
	 */
	static public ArrayList<String> brute_force_attack( Collection<String> hashes, int max_length ) 
	{
		ArrayList<String> successes = new ArrayList<String>();
		StringBuilder so_far = new StringBuilder();
		
		try {
			Crack.brute_force_attack(hashes, successes, so_far, 0, max_length);
		} catch (NoSuchAlgorithmException e) 
		{
			System.out.println("The algorithm does not exist...");
		}
		return successes;

	}

	/**
	 * Generates all possible permutations of words with a desired max length 
	 * to crack passwords
	 * 
	 * @param hashes -- collection of hashes
	 * @param successes -- collection of words that have been successfully cracked
	 * @param so_far -- the permutation builder
	 * @param depth -- pointer for the current length of our permutation
	 * @param max_length -- the boundary to stop generating a permutation of that length
	 * @throws NoSuchAlgorithmException -- if a certain algorithm implemented does not exist
	 */
	static public void brute_force_attack(
			Collection<String> hashes, ArrayList<String> successes, StringBuilder so_far,
			int depth, int max_length ) throws NoSuchAlgorithmException
	{
		if(hashes.contains(md5(so_far.toString())))
		{
			successes.add(so_far.toString() + " : " + md5(so_far.toString()));
		}
		if(depth >= max_length)
		{
			return;
		}
		
		for(char lett : letters)
		{
			
			so_far.append(lett);
			brute_force_attack(hashes, successes, so_far, depth + 1, max_length);
			so_far.deleteCharAt(so_far.length()-1);
			
		}
	}

	/**
	 * Compares all words in the given list (dictionary) to the password collection we wish to crack
	 *
	 * @param dictionary
	 *            - The list of likely passwords
	 * @param hashes
	 *            - Collection of the hashwords we are trying to break
	 * @return the list of found passwords and their corresponding md5 hashes (e.g., "cat :
	 *         d077f244def8a70e5ea758bd8352fcd8AB3293292CEF2342ACD32342")
	 * @throws NoSuchAlgorithmException  -- if a certain algorithm implemented does not exist
	 */
	static public ArrayList<String> dictionary_attack( ArrayList<String> dictionary, Collection<String> hashes) throws NoSuchAlgorithmException
	{
		ArrayList<String> foundPasswords = new ArrayList<String>();
		for( String word : dictionary)
		{
			String hashWord = md5(word);
			if(hashes.contains(hashWord))
			{
				word+= " : " + hashWord;
				foundPasswords.add(word);
			}
		}
		return foundPasswords;
	}

	/**
	 * Computes the md5 hashed version of a given word
	 * 
	 * @param perm -- the word 
	 * @return the hash version of the word
	 * @throws NoSuchAlgorithmException  if a certain algorithm implemented does not exist
	 */
	static public String md5(String perm) throws NoSuchAlgorithmException{
		MessageDigest hash_generator = java.security.MessageDigest.getInstance("MD5");
		StringBuffer hashword_hex_code = null;
		// build MD5 hash of a permutation
		hash_generator.update(perm.toString().getBytes());
		byte[] digest = hash_generator.digest();

		hashword_hex_code = new StringBuffer();
		for (byte b : digest)
		{
			hashword_hex_code.append(String.format("%02x", b & 0xff));
		}
		return hashword_hex_code.toString();
	}

	// use hashword_hex_code to compare to already encrypted/hashed words

	/**
	 * Begin a brute for attack on the password hashfile
	 * 
	 * Use up to 8 threads
	 * 
	 * compute all permutations of strings and compare them to a list of already hashed passwords
	 * to see if there is a match
	 * 
	 * @param max_permutation_length
	 *            - how long of passwords to attempt (suggest 6 or less)
	 * @return a list of successfully cracked passwords
	 */
	public static ArrayList<ArrayList<String>> multi_thread_brute_force_attack( int max_permutation_length, Collection<String> hashes )
	{
		long start_time = System.nanoTime();
		System.out.println("starting computation");

		int AVAILABLE_THREADS = 1;

		ExecutorService thread_pool = Executors.newFixedThreadPool( AVAILABLE_THREADS );
		ArrayList<ArrayList<String>> successes = new ArrayList<ArrayList<String>>();

		for (int i=0; i<26; i++)
		{
			successes.add( new ArrayList<>() );
		}

		for (int i=0; i<26; i++)
		{
			int temp = i; 

			thread_pool.execute(
					new Runnable()
					{

						@Override
						public void run()
						{
							System.out.println("working on permutation " + temp);
							try {
								brute_force_attack(hashes, successes.get(temp), new StringBuilder("" + (char) ('a' + temp + 1)),
										1, max_permutation_length);
							} catch (NoSuchAlgorithmException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					});;
		}

		try
		{
			thread_pool.shutdown();
			thread_pool.awaitTermination(1, TimeUnit.DAYS);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		long total_time = System.nanoTime() - start_time;
		System.out.println("done: ( " + (total_time / 1000000000.0) + " seconds )");

		return successes;
	}
}
