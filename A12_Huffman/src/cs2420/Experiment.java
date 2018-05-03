package cs2420;

import java.io.File;
import java.nio.file.Paths;

/**
 * The program that sets and tests our experiment for the Huffman Tree
 * 
 * The experiment will focus on the hint given on the specifications:
 * 
 * "What is the optimal number of 'word' symbols to get the best compression?"
 * 
 * @author Tony Diep, Alex Cervantes, last updated 4-25-17
 *
 */
public class Experiment 
{	
	public static void main(String[] args)
	{	
		System.out.printf("%20s\t%13s\t%20s", "# of Common Words", "Compress", "Decompress\n");

		int count ;
		String fileName = "";
		
		long startTimeCompress = 0;
		long endTimeCompress = 0;
		long elapsedTimeCompress = 0;
		
		long startTimeDecompress = 0;
		long endTimeDecompress = 0;
		long elapsedTimeDecompress = 0;
		
		for(count = 0; count <= 100; count++)
		{
			HuffmanTreeUsingWords huffmanTree = new HuffmanTreeUsingWords(count);
			
			// ignore . extensions
			String[] new_file_name = new String[0]; // file_name.split("\\.");

			if (new_file_name.length > 1)
			{
				fileName = new_file_name[0];
			}
			
			fileName = "Resources/simple";
			fileName = "Resources/a_few_letters";
			fileName = "Resources/alphabet";
			fileName = "Resources/alphabetplus";
			fileName = "Resources/decl_of_ind";
			fileName = "Resources/green_eggs_and_ham";
			fileName = "Resources/constitution";
			fileName = "Resources/two_cities";
			
			startTimeCompress = System.nanoTime();
			huffmanTree.compress_file(new File(fileName), new File(fileName + "." + huffmanTree.WORD_COUNT + ".huf"));
			endTimeCompress = System.nanoTime();
			
			elapsedTimeCompress += endTimeCompress - startTimeCompress;
			
			
			startTimeDecompress = System.nanoTime();
			huffmanTree.decompress_file(Paths.get(fileName + "." + huffmanTree.WORD_COUNT + ".huf"), new File(fileName + ".uncompress"));
			endTimeDecompress = System.nanoTime();
			
			elapsedTimeDecompress += endTimeDecompress - startTimeDecompress;
			
			System.out.printf("%10s\t%20s\t%20s\n", count, elapsedTimeCompress / 1_000_000, elapsedTimeDecompress / 1_000_000);
		}
	}
}
