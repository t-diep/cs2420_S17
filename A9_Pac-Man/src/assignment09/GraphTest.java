/**
 * 
 */
package assignment09;

import static org.junit.Assert.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.junit.Before;
import org.junit.Test;

/**
 * Provides supplementary test cases for the Graph's build adjacency matrices method
 * 
 * @author Tony Diep, Makenzie Peacock, last updated 3-30-17
 */
public class GraphTest 
{
	BufferedReader threeByFour;
	BufferedReader fourByThree;
	BufferedReader fourByFour;
	
	/**
	 * Sets up the buffered readers for the different mazes
	 * 
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception 
	{
		threeByFour = new BufferedReader(new FileReader("Resources/mazes/threeByFour.txt"));
		fourByThree = new BufferedReader(new FileReader("Resources/mazes/fourByThree.txt"));
		fourByFour = new BufferedReader(new FileReader("Resources/mazes/fourByFour.txt"));
	}

	//Adjacency matrix tests
	
	/**
	 * Test for a 3 x 4 maze
	 * 
 	 * @throws IOException -- if there are any issues with the BufferedReader
	 * @throws NullPointerException -- if any nodes are null
	 * @throws FileNotFoundException -- if not files are nowhere to be found
	 */
	@Test
	public void testThreeByFourAdjacencyMatrix() throws FileNotFoundException, NullPointerException, IOException 
	{
		Graph firstOne = new Graph("Resources/mazes/threeByFour.txt");
		
		char[][] threeByFour = firstOne.buildAdjacencyMatrix(this.threeByFour);
		
		char[][] expected = new char[3][4];
		
		expected[0][0] = 'X';
		expected[0][1] = 'X';
		expected[0][2] = 'X';
		expected[0][3] = 'X';
		expected[1][0] = 'X';
		expected[1][1] = 'S';
		expected[1][2] = 'G';
		expected[1][3] = 'X';
		expected[2][0] = 'X';
		expected[2][1] = 'X';
		expected[2][2] = 'X';
		expected[2][3] = 'X';
		
		assertArrayEquals(expected, threeByFour);
	}

	/**
	 * Test for a 4 x 3 maze
	 * 
 	 * @throws IOException -- if there are any issues with the BufferedReader
	 * @throws NullPointerException -- if any nodes are null
	 * @throws FileNotFoundException -- if not files are nowhere to be found
	 */
	@Test
	public void testFourByThreeAdjacencyMatrix() throws FileNotFoundException, NullPointerException, IOException 
	{
		Graph secondOne = new Graph("Resources/mazes/threeByFour.txt");
		
		char[][] fourByThree = secondOne.buildAdjacencyMatrix(this.fourByThree);
		
		char[][] expected = new char[4][3];
		
		expected[0][0] = 'X';
		expected[0][1] = 'X';
		expected[0][2] = 'X';
		expected[1][0] = 'X';
		expected[1][1] = 'S';
		expected[1][2] = 'X';
		expected[2][0] = 'X';
		expected[2][1] = 'G';
		expected[2][2] = 'X';
		expected[3][0] = 'X';
		expected[3][1] = 'X';
		expected[3][2] = 'X';
		
		assertArrayEquals(expected, fourByThree);
	}
	
	/**
	 * Test for a 4 x 4 maze
	 * 
	 * @throws IOException -- if there are any issues with the BufferedReader
	 * @throws NullPointerException -- if any nodes are null
	 * @throws FileNotFoundException -- if not files are nowhere to be found
	 */
	@Test
	public void testFourByFourAdjacencyMatrix() throws FileNotFoundException, NullPointerException, IOException 
	{
		Graph lastOne = new Graph("Resources/mazes/fourByFour.txt");
		
		char[][] fourByFour= lastOne.buildAdjacencyMatrix(this.fourByFour);
		
		char[][] expected = new char[4][4];
		
		expected[0][0] = 'X';
		expected[0][1] = 'X';
		expected[0][2] = 'X';
		expected[0][3] = 'X';
		expected[1][0] = 'X';
		expected[1][1] = 'S';
		expected[1][2] = ' ';
		expected[1][3] = 'X';
		expected[2][0] = 'X';
		expected[2][1] = ' ';
		expected[2][2] = 'G';
		expected[2][3] = 'X';
		expected[3][0] = 'X';
		expected[3][1] = 'X';
		expected[3][2] = 'X';
		expected[3][3] = 'X';

		assertArrayEquals(expected, fourByFour);
	}
}
