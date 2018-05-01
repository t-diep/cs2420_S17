
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

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

/**
 * Represents a sudoku 9x9 puzzle
 * @author Tony Diep, and Milad Bazzazi, last updated 2-3-17
 *
 */
public class Sudoku 
{		
	// Represents the number of guesses for the solver to solve the puzzle
	int guessCount;
	// Represents a 1D version of our Sudoku puzzle
	int[][] sudokuPuzzle;	
	// Represents the whole Sudoku puzzle 
	ArrayList<HashSet<Integer>> wholeSudoku;

	/**
	 * Default constructor: creates an empty Sudoku grid
	 */
	public Sudoku() 
	{
		guessCount = 0;
    	sudokuPuzzle = new int[9][9];
    	wholeSudoku = new ArrayList<HashSet<Integer>>();
    }

	/**
	 * Create a new puzzle by reading a file
	 *
	 * the file should be 9 rows of 9 numbers separated by whitespace the
	 * numbers should be 1-9 or 0 representing an empty square
	 *
	 * Improper format (too many numbers per line, no numbers, too many total
	 * numbers, etc) should result in a runtime exception being thrown.
	 *
	 */
	public Sudoku(BufferedReader reader) 
	{
    	sudokuPuzzle = new int[9][9];
    	guessCount = 0;
    	wholeSudoku = new ArrayList<HashSet<Integer>>();
    	
    	String line = null;
    	int anotherRow = 0;
    	int howManyLinesSoFar = 0;
    	
    	try
    	{	
    		while((line = reader.readLine()) != null)
    		{		
    			System.out.println(line);
    			howManyLinesSoFar++;
    			String[] lineNums = line.split(" ");
    			
    			if(lineNums.length != 9 || howManyLinesSoFar > 9)
    			{
    				throw new RuntimeException();
    			}
    			
    			for(int col = 0; col < lineNums.length; col++)
    			{	
    				sudokuPuzzle[anotherRow][col] = Integer.parseInt(lineNums[col]); 
    			}

    			anotherRow++;
    			
    			if(anotherRow == 9)
    			{
    				break;
    			}
    		}
    		
    		reader.close();
    	}
    	catch(IOException e)
    	{
    		System.out.println("ERROR 404: Cannot read file...");
    		System.exit(0);
    	}
    }
	
    /**
     * Getter for the current Sudoku puzzle
     * 
     * @return a copy of the puzzle as a 1D matrix
     */
    public int [] get_puzzle_1D()
    {
    	int[] theWholeBox = new int[81];
    	
    	for(int index = 0; index < 81; index++)
    	{
    		theWholeBox[index] = sudokuPuzzle[index / 9][index % 9];		
    	}
    	
    	return theWholeBox;
    }


	/**
	 * Getter for the current Sudoku puzzle
	 * 
	 * @return a copy of the puzzle as a 2D matrix
	 */
	public int[][] get_puzzle_2D() 
	{
    	return sudokuPuzzle;
    }

	/**
	 * Getter for the number of guesses to solve the current Sudoku puzzle
	 * 
	 * @return how many guesses it took to recursively solve the problem.
	 */
	public int get_guess_count() 
	{
		return guessCount;
	}

	/**
	 * Function: valid_for_row
	 *
	 * Description: Determine if the given number can be placed in the given row
	 * without violating the rules of sudoku
	 *
	 * Inputs:
	 * 
	 * @input row : which row to see if the number can go into
	 * @input number: the number of interest
	 *
	 *        Outputs:
	 *
	 *        true if it is possible to place that number in the row without
	 *        violating the rule of 1 unique number per row.
	 *
	 *        In other words, if the given number is already present in the row,
	 *        it is not possible to place it again (return false), otherwise it
	 *        is possible to place it (return true);
	 * 
	 *        WARNING: call this function before placing the number in the
	 *        puzzle...
	 *
	 */
	public boolean valid_for_row(int row, int number) 
	{ 	
		if(number == 0)
		{
			return true;
		}
		
		for(int column = 0; column < 9; column++)
    	{    		
    		if(number == sudokuPuzzle[row][column])
    		{
    			return false;
    		}
    	}
    	return true;
    }

	/**
	 * Function: valid_for_col (see above)
	 */
	public boolean valid_for_column(int col, int number) 
	{	
		if(number == 0)
		{
			return true;
		}
		
		for (int row = 0; row < 9; row++) 
		{	
			if (sudokuPuzzle[row][col] == number) 
			{
				return false;
			}
		}
		return true;
	}

	/**
	 * Function: valid_for_box (see above)
	 *
	 * The sudoku boxes are:
	 *
	 * 0 | 1 | 2
	 *---+---+--- 
	 * 3 | 4 | 5 
	 *---+---+---
	 * 6 | 7 | 8
	 *
	 * where each box represents a 3x3 square in the game.
	 *
	 */
	public boolean valid_for_box(int box, int number) 
	{		
		if (number == 0) 
		{
			return true;
		}

		
		if(sudokuPuzzle[box / 9][box % 9] == number)
		{
			return false;
		}
		
		return true;
	}
	

	/**
	 *
	 * Function is_valid( position, value )
	 *
	 * Determine if the given value is valid in the puzzle at that position.
	 *
	 * Inputs:
	 * 
	 * @param position
	 *            - which bucket in the puzzle to check for validity - should be
	 *            empty
	 * @param possible_value
	 *            - the value to check (1-9)
	 * 
	 * @return true if valid
	 */
	protected boolean is_valid(int position, int possible_value) 
	{
		int row = position / 9;
		int col = position % 9;
		int box = getBox(row, col);

		return this.valid_for_row(row, possible_value) && this.valid_for_column(col, possible_value)
				&& this.valid_for_box(box, possible_value);
	}

	/**
	 * Gets a specific box based on a given row, column, and value
	 * 
	 * @param row -- specified row
	 * @param col -- specified column
	 * @param value -- specified value
	 * @return a specified box in the sudoku puzzle
	 */
	private int getBox(int row, int col) 
	{	
		//Box 0
		if(col < 3 && row < 3)
		{
			return 0;
		}
		//Box 1
		if(col > 2 && col < 6 && row < 3)
		{
			return 1;
		}
		//Box 2
		if(col > 5 && row < 3)
		{
			return 2;
		}
		//Box 3
		if(row > 2 && row < 6 && col < 3)
		{
			return 3;
		}
		//Box 4
		if(col > 2 && col < 6 && row > 2 && row < 6)
		{
			return 4;
		}
		//Box 5
		if(col > 5 && row > 2 && row < 6)
		{
			return 5;
		}
		//Box 6
		if(row > 5 && col < 3)
		{
			return 6;
		}
		//Box 7
		if(col > 2 && col < 6 && row > 5)
		{
			return 7;
		}
		
		//Box 8
		return 8;
	}

	/**
	 * solve the sudoku problem
	 * 
	 * @return true if successful
	 */
	public boolean solve_sudoku() 
	{
		return solve_sudoku(0);
	}

	/**
	 *
	 * Function solve_sudoku( puzzle, position )
	 *
	 * Recursively check to see if the puzzle can be solved following class
	 * algorithm
	 *
	 * Inputs: position - the index of the "current" box in the array (should be
	 * set to 0 by initial call)
	 *
	 */
	protected boolean solve_sudoku(int position) 
	{	
		if(position == 81)
		{
			return true;
		}
		
		if(sudokuPuzzle[position / 9][position % 9] != 0)
		{
			return solve_sudoku(position + 1);
		}
		
		for(int guessIndex = 1; guessIndex <= 9; guessIndex++)
		{
			guessCount++;
			if(is_valid(position, guessIndex))
			{
				return true;
			}
			sudokuPuzzle[position / 9][position % 9] = 0;
		}
		
		return false;
	}

	/**
	 * Function: toString( )
	 *
	 * @return a string showing the state of the board
	 *
	 */
	@Override
	public String toString() 
	{
		String result = "";

		for (int index = 0; index < 81; index++) 
		{
			result += "pos " + index + " " + wholeSudoku.toString();
		}

		return result;
	}

	/**
	 * Given a puzzle (filled or partial), verify that every element does not
	 * repeat in row, col, or box.
	 * 
	 * @return true if a validly solved puzzle
	 */
	public boolean verify() 
	{
	 	for(int position = 0; position < 9; position++)
	 	{
	 		if(is_valid(position, sudokuPuzzle[position / 9][position % 9]))
	 		{
	 			return true;
	 		}
	 	}
	 	return false;
    }

	/**
	 * Attempt to solve a sudoku by eliminating obviously wrong values Algorithm
	 *
	 * 1) build a 81 (representing 9x9) array of sets 
	 * 2) put a set of 1-9 ineach of the 81 spots 
	 * 3) do initial elimination for each known value,
	 * eliminate numbers from sets in same row, col, box eliminate all values in
	 * the given square 
	 * 4) while progress is being made (initially true) find a
	 * non-processed square with one possible answer and eliminate this number
	 * from row, col, box
	 */
	public void solve_by_elimination() 
	{
		int value = 0;
		
		for(int setIndex = 0; setIndex < 81; setIndex++)
		{
			//Create a bin and add it to the ArrayList
			HashSet<Integer> set = new HashSet<Integer>();
			
			//Add the numbers 1 - 9 to each hashSet
			for(int randNum = 1; randNum < 10; randNum++)
			{
				set.add(randNum);
				wholeSudoku.add(set);
			}	
		}
		
		
		for (int row = 0; row < 9; row++) 
		{		
			for(int col = 0; col < 9; col++)
			{
				if(sudokuPuzzle[row][col] == 0)
				{
					continue;
				}
				else
				{
					value = sudokuPuzzle[row][col];
					prune_row(wholeSudoku, row, value);
					prune_column(wholeSudoku, col, value);
					prune_box(wholeSudoku, getBox(row, col), value);
					
					guessCount++;
				}
			}	
		}
	}
	
	/**
	 * print a grid showing all possible valid answers This should be a 27x27
	 * matrix.
	 *
	 * I would suggest you do this first to get good debugging help
	 * 
	 * @param possibilities
	 *            - array list of all the sets of 1-9s
	 */
	protected void print_possibilities(ArrayList<HashSet<Integer>> possibilities) 
	{
		String sudokuAnswerString = " ";

		for (int row = 0; row <= 8; row++) {
			for (int box = 0; box < 3; box++) {
				for (int column = 0; column <= 8; column++) {
					HashSet<Integer> eliminateSet = possibilities.get((row) + (column));
					for (int index = box; index <= 9; index++) {
						if (eliminateSet.contains(index)) {
							sudokuAnswerString += index;
						} else {
							sudokuAnswerString += " ";
						}
					}
					if (column <= 8 && column >= 0 && column % 3 == 2) {
						sudokuAnswerString += "|";
					} else {
						sudokuAnswerString += "";
					}
				}

				if (box == 2 && row % 3 == 2) {
					sudokuAnswerString += "\n			|			|			";
				}
			}
			if (row < 8 && row % 3 == 2) {
				sudokuAnswerString += "\n";
			}
		}
		System.out.println(sudokuAnswerString);
	}
	
	
	/**
	 * Given a possibility constraint matrix (81 sets of [1-9]) remove the given
	 * number from every matrix in the given box
	 * 
	 * @param possibilities
	 *            - 81 sets of [1-9]
	 * @param position
	 *            - where the value exists (transform to row,col)
	 * @param value
	 *            - the value to prune
	 */
	protected void prune_box(ArrayList<HashSet<Integer>> possibilities, int position, Integer value) 
	{
		int row = position / 9;
		int col = position % 9;
		
		int box = (row / 9) * value *(col % 27);
		

		for(int boxIndex = 0; boxIndex < 81; box++)
		{
			possibilities.get(box).remove(value);
		}
	}

	/**
	 * Remove the current known value from the other bins of the same column
	 * 
	 * @param possibilities -- the sudoku puzzle
	 * @param position -- the bin of the sudoku puzzle
	 * @param value -- the value contained inside the bin
	 */
	protected void prune_column(ArrayList<HashSet<Integer>> possibilities, int position, Integer value) {
	
		int col = position % 9;
				
		for(int colIndex = col; colIndex < 81; colIndex+= 9)
		{
			possibilities.get(colIndex).remove(value);
		}
	}

	/**
	 * Remove the current known value from the other bins of the same row
	 * 
	 * @param possibilities -- the sudoku puzzle
	 * @param position -- the bin of the sudoku puzzle
	 * @param value -- the value contained inside the bin
	 */
	protected void prune_row(ArrayList<HashSet<Integer>> possibilities, int position, Integer value) 
	{
		int row = position / 9;
		
		for(int rowIndex = row * 9; rowIndex < rowIndex + 9; rowIndex++)
		{
			possibilities.get(rowIndex).remove(value);
		}	
	}
}
