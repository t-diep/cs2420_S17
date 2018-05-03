package hash_tables;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collection;

import cracking.Crack;

/**
 * The main program to test our Hash Tables and our Crack class methods
 * The main program also contains timing experiments for the Hash Tables
 * 
 * @author Tony Diep, Jocee Porter, last updated 4-7-17
 */
public class Main 
{
	public static void main(String[] args) 
	{
		Hash_Table_Linear_Probing<String, String> hashTable = new Hash_Table_Linear_Probing<String, String>(79);
		Hash_Table_Quadratic_Probing<String, String> quadTable = new Hash_Table_Quadratic_Probing<String, String>(79);
		Hash_Chaining<String, String> chainTable = new Hash_Chaining<String, String>(79);
		ArrayList<String> dictionary = Crack.read_file_into_array("Resources/common_passwords_cain");
		ArrayList<String> names = Crack.read_file_into_array("Resources/names");
		ArrayList<String> passwords = new ArrayList<String>();
		
		Collection<String> hashes = null;
		
		//hashTable.set_resize_allowable(true);
		//quadTable.set_resize_allowable(false);
		chainTable.set_resize_allowable(false);
		for(int i = 0; i< names.size(); i++)
		{
			//hashTable.insert(names.get(i), i+"");
			//quadTable.insert(names.get(i), i+"");
			chainTable.insert(names.get(i), i+"");
		}
		//System.out.println(hashTable.toStringHash());
		//System.out.println(quadTable.toStringHash());
		System.out.println(chainTable.hashToString());
		//System.out.println(hashTable.toString());
		//System.out.println(quadTable.toString());
		System.out.println(chainTable.toString());
		
		
		for(int i =0; i< 100; i++)
		{
			hashTable.insert(i + "", i + "");
		}
		for(int i = 10; i<100; i+=9)
		{
			hashTable.find("i");
		}
		for(int i = 2; i< 5; i++)
		{
			hashTable.insert(i+ "", i + "");
		}
		System.out.println(hashTable.print_stats());
		System.out.println(hashTable.toString());
		
	
//		passwords = Crack.brute_force_attack(dictionary, 8);
//		
//		System.out.println(passwords.toString());
//		
//		if (Crack.I_DID_NOT_STUDY_ALGORITHMS)
//	    {
//			hashes = Crack.read_file_into_array("Resources/hashwords_long");
//	    }
//	    else
//	    {
//	        hashes = Crack.read_file_into_hash_set("Resources/hashwords_long");
//	    }
//		 
//		Crack.multi_thread_brute_force_attack(4, hashes);
//		 
//		System.out.println(hashes.toString());
//		 
//		try {
//			System.out.println(Crack.dictionary_attack(dictionary, hashes));
//		} catch (NoSuchAlgorithmException e) 
//		{
//			System.out.println("No such algorithm exists...");
//		} 
	}
}
