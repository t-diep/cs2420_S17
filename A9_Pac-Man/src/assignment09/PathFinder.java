/**
 * 
 */
package assignment09;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import assignment09.Graph.Node;

/**
 * The main program; solves the Pac-Man maze text file mazes
 * 
 * @author Tony Diep, Makenzie Peacock, last updated 3-30-17
 */
public class PathFinder 
{	
	/**
	 * Takes an unsolved maze text file and outputs the passed in output text file, 
	 * and downloads it as a file saved onto the computer drive
	 * 
	 * @param inputFileName -- unsolved maze text file
	 * @param outputFileName -- solved maze text file
	 * @throws IOException 
	 * @throws NullPointerException 
	 * @throws FileNotFoundException 
	 */
	public static void solveMaze(String inputFileName, String outputFileName)
	{
		Graph maze;
		BufferedReader input;
		char[][] output;
		
		try
		{
			maze = new Graph(inputFileName);
			input = new BufferedReader(new FileReader(inputFileName));
			output = maze.createOutputAdjacencyMatrix(inputFileName);
			maze.breadthFirstSearch(maze.start, maze.goal);
			
			for(Node node: maze.backwardPath)
			{
				if(node == null)
				{
					break;
				}
				int row =  node.position / output[0].length;
				int col = node.position % output[0].length;

				output[row][col] = '.';

			}

			try(PrintWriter printer = new PrintWriter(new FileWriter(outputFileName)))
			{
				printer.println(output.length + " " + output[0].length);
				printer.print(mazeToString(output));
				printer.close();
			}

			input.close();
		}
		catch(FileNotFoundException fileNotFoundException)
		{
			System.out.println("File does not exist");
			return;
		}
		catch(NullPointerException nullPointerException)
		{
			System.out.println("Node containing null");
			return;
		}
		catch(IOException ioexception)
		{
			System.out.println("BufferedReader error occurred");
			return;
		}
	}

	/**
	 * Outputs the solved maze text file
	 * 
	 * @param output -- our adjacency matrix containing the characters 
	 * @return the solved maze text file in a String form
	 */
	public static String mazeToString(char[][] output)
	{
		String result = "";

		for(int row = 0; row < output.length; row++)
		{
			for(int col = 0 ; col < output[0].length; col++)
			{
				result += output[row][col];
			}

			result+= "\n";
		}

		return result;
	}
}
