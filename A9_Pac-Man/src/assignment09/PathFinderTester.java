package assignment09;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * The program to test our maze solver
 * 
 * @author Tony Diep, Makenzie Peacock, last updated 3-30-17
 */
public class PathFinderTester 
{
	public static void main(String[] args) throws FileNotFoundException, NullPointerException, IOException
	{
		PathFinder.solveMaze("Resources/mazes/bigMaze.txt", "Resources/Testing_Solutions/bigMazeTest.txt");
		PathFinder.solveMaze("Resources/mazes/classic.txt", "Resources/Testing_Solutions/classicTest.txt");
		PathFinder.solveMaze("Resources/mazes/demoMaze.txt", "Resources/Testing_Solutions/demoMazeTest.txt");
		PathFinder.solveMaze("Resources/mazes/mediumMaze.txt", "Resources/Testing_Solutions/mediumMazeTest.txt");
		PathFinder.solveMaze("Resources/mazes/minisculeMaze.txt", "Resources/Testing_Solutions/minisculeMazeTest.txt");
		PathFinder.solveMaze("Resources/mazes/randomMaze.txt", "Resources/Testing_Solutions/randomMazeTest.txt");
		PathFinder.solveMaze("Resources/mazes/straight.txt", "Resources/Testing_Solutions/staightTest.txt");
		PathFinder.solveMaze("Resources/mazes/tinyMaze.txt", "Resources/Testing_Solutions/tinyMazeTest.txt");
		PathFinder.solveMaze("Resources/mazes/tinyOpen.txt", "Resources/Testing_Solutions/tinyOpenTest.txt");
		PathFinder.solveMaze("Resources/mazes/turn.txt", "Resources/Testing_Solutions/turnTest.txt");
		PathFinder.solveMaze("Resources/mazes/unsolvable.txt", "Resources/Testing_Solutions/unsolvableTest.txt");
		PathFinder.solveMaze("Resources/mazes/snake.txt", "Resources/Testing_Solutions/snakeTest.txt");
	}
}
