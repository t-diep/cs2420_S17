
/**
 *@author Anthony Diep
 *@uid u0934661
 *@date 3 February 2017
 *@classnumber (2420)
 *@assignmentnumber 3
 *@partner Milad Bazzazi
 *	I pledge that the work done here was my own and that I have learned how to write this program, 
 *	such that I could throw it out and restart and finish it in a timely manner. I am not turning 
 *	in any work that I cannot understand, describe, or recreate. I further acknowledge that I contributed 
 *	substantially to all code handed in and vouch for it's authenticity. (Anthony Diep)
 */
package Sudoku;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.FileReader;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Provides JUnit Tests for the Sudoku class
 * 
 * @author Tony Diep, Milad Bazzazi, last updated 2-3-17
 */
public class SudokuTest 
{
	Sudoku puzzle1;
	Sudoku blankPuzzle;
	Sudoku mostlyBlankPuzzle;
	BufferedReader readSudoku1;
	BufferedReader readSudoku2;
	
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
		readSudoku1 = new BufferedReader(new FileReader("Documents/puzzle1"));
		readSudoku2 = new BufferedReader(new FileReader("Documents/mostlyBlankPuzzle"));
		blankPuzzle = new Sudoku();
		puzzle1 = new Sudoku(readSudoku1);
		mostlyBlankPuzzle = new Sudoku(readSudoku2);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception 
	{
	
	}

	/**
	 * Test for the setups of this blank Sudoku puzzle 
	 * 
	 * ~Test for the guessCount (should be 0)
	 * ~Test for the 1D array (each element in that 1D array should be 0)
	 */
	@Test
	public void testFirstSudokuConstructor() 
	{
		assertEquals(0, blankPuzzle.get_guess_count());
		assertArrayEquals(new int[9][9], blankPuzzle.get_puzzle_2D());
	}
	
	/**
	 * Test for the second constructor of the Sudoku class
	 */
	@Test 
	public void testSecondSudokuConstructor()
	{
		assertEquals(0, mostlyBlankPuzzle.get_guess_count());
		
	}
	
	
	//Tests for the valid_for_row method
	
	/**
	 * Initial tests 
	 * 
	 * Test "puzzle1" sudoku text file
	 */
	@Test
	public void testValidForRow1()
	{	
		//Test for at a specific row at the last row that has 0 in it
		assertTrue(puzzle1.valid_for_row(8, 0));
		//Test for at row 6 with the value 6 in one of the columns
		assertFalse(puzzle1.valid_for_row(6, 6));
		//Test for at row 7 with the value 8 
		assertFalse(puzzle1.valid_for_row(7, 8));
	}
	
	/**
	 * Test "puzzle1" sudoku text file
	 */
	@Test
	public void testValidForRow2()
	{	
		//Test for every column at row 5; all columns should pass except for columns 0 and 8 
		for(int col = 1; col <= 8; col++)
		{
			assertEquals((col != 7 && col != 8), puzzle1.valid_for_row(4, col));
		}	
	}
	
	
	//Tests for the valid_for_row method
	
	/**
	 * Initial tests
	 */
	@Test
	public void testValidForColumn1()
	{	
		//Test for column 0 with the value 9
		assertFalse(puzzle1.valid_for_column(0, 9));
		//Test for column 4 with the value 3
		assertTrue(puzzle1.valid_for_column(4, 3));
		//Test for column 8 with the value 0
		assertTrue(puzzle1.valid_for_column(8, 0));
	}
	
	/**
	 * Test every value (1-9) for column 1
	 */
	@Test
	public void testValidForColumn2()
	{
		for(int value = 1; value <= 9; value++)
		{
			assertEquals((value != 2 && value != 1), puzzle1.valid_for_column(4, value));
		}
	}
	
	
	//Tests for the valid_for_box method
	
	/**
	 * Initial tests
	 */
	@Test
	public void testValidForBox1()
	{
		//Test for box 3 whether the value 0 is valid 
		assertTrue(puzzle1.valid_for_box(3, 0));
		//Test for box 6 whether the value 9 is valid
		assertTrue(puzzle1.valid_for_box(6, 9));
		//Test for box 9 whether the value 1 is valid
		assertTrue(puzzle1.valid_for_box(8, 1));
	}
	
	/**
	 * Test for all boxes whether the value 0 is valid
	 */
	@Test
	public void testValidForBox2()
	{
		for(int box = 0; box <=8; box++)
		{
			assertTrue(puzzle1.valid_for_box(box, 0));
		}
	}
	
	/**
	 * Test for all boxes whether the value 5 is valid
	 */
	@Test
	public void testValidForBox3()
	{
		for(int box = 0; box <= 8; box++)
		{
			assertEquals((box != 1 || box != 6 || box != 8), puzzle1.valid_for_box(box, 5));
		}
	}
	
	/**
	 * Test for the validity of all values for all boxes
	 */
	@Test
	public void testValidForBox4()
	{
		//Test all boxes for the value 1
		for(int box = 0; box <= 8; box++)
		{
			assertEquals((box != 1 || box != 3 || box != 5 || box != 6 || box != 8), puzzle1.valid_for_box(box, 1));
		}
	}
	
	//Tests for the is_Valid method
	
	/**
	 * Initial tests
	 */
	@Test
	public void testIsValid1()
	{
		//Test at the first position of the Sudoku puzzle with value 0
		assertTrue(puzzle1.is_valid(0, 0));
		//Test at the last position of the Sudoku puzzle with value 3
		assertFalse(puzzle1.is_valid(80, 3));
		//Test at the middle position of the Sudoku puzzle with value 7
		assertFalse(puzzle1.is_valid(40, 7));
	}
	
	/**
	 * Test for the 1D array conversion of a blank sudoku puzzle
	 */
	@Test
	public void testGet1DBlankPuzzle1()
	{
		assertArrayEquals(new int[81], blankPuzzle.get_puzzle_1D());
	}
	
	/**
	 * Test for the 2D array conversion of a blank sudoku puzzle
	 */
	@Test
	public void testGet2DBlankPuzzle1()
	{
		assertArrayEquals(new int[9][9], blankPuzzle.get_puzzle_2D());
	}
	
	
	//Tests for the solve_sudoku method (with no parameters)
	
	@Test
	public void testSolveSudokuMethodWithNoParameters1()
	{
		//assertTrue(puzzle1.solve_sudoku());
	
		for(int row = 0; row < 9; row++)
		{
			for(int col = 0; col < 9; col++)
			{
				assertTrue(puzzle1.sudokuPuzzle[row][col] != 0);
			}
		}
	}
	
	//Tests for the solve_sudoku method (with parameter(s))
	
	@Test
	public void testSolveSudokuMethodWithParameters()
	{
		assertTrue(puzzle1.solve_sudoku());
	}
	
	
	//Tests for the verify method
	
	@Test
	public void testVerify1()
	{
		
	}
	
	//Tests for the solve_by_elimination method
	
	@Test
	public void testSolveByElimination1()
	{
		puzzle1.solve_by_elimination();
	}
	
	//Tests for the prune_row method
	
	@Test
	public void testPruneRow1()
	{
		puzzle1.prune_row(puzzle1.wholeSudoku, 9, 9);
		
	}
	
	
	//Tests for the prune_column method
	
	@Test
	public void testPruneColumn1()
	{
		puzzle1.prune_column(puzzle1.wholeSudoku, 9,9);
	}
	
	
	//Tests for the prune_box method
	
	@Test
	public void testPruneBox1()
	{
		puzzle1.prune_box(puzzle1.wholeSudoku, 9 , 9);
	}
	
	
}
