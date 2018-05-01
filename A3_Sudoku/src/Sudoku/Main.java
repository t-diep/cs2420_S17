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
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * The main program; sets up Sudoku text file and the Sudoku object
 * 
 * @author Tony Diep, and Milad Bazzazi, last updated 2-3-17
 */
public class Main 
{
	public static void main(String[] args) 
	{	
		BufferedReader readSudokuPuzzle = null;
		try 
		{
			readSudokuPuzzle = new BufferedReader(new FileReader("Resources/puzzle1"));
			Sudoku firstPuzzle = new Sudoku(readSudokuPuzzle);

			System.out.println("Enter 0 for solve by elimination or 1 for recursive method for solving the Sudoku puzzle");
			
			Scanner input = new Scanner(System.in);
			int choice = Integer.parseInt(input.next());
			
			if(choice == 0)
			{
				firstPuzzle.solve_by_elimination();
			}
			else
			{
				firstPuzzle.solve_sudoku();
			}
			
			input.close();		
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("File cannot be found");
		}
	}
}

