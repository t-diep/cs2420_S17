/**
 * 
 */
package assignment09;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * Represents our custom graph data structure with functionality
 * 
 * @author Tony Diep, Makenzie Peacock, last updated 3-30-17
 */
public class Graph 
{
	//The queue to hold the vertices
	ArrayDeque<Node> vertices;
	//Holds all of the nodes from our maze text file
	Node[] adjacencyList;
	//Start node; keeps track of the start 
	Node start;
	//Goal node; keeps track of the goal
	Node goal;
	//Number of rows 
	int numOfRows;
	//Number of columns
	int numOfColumns;
	//Number of nodes represented in the maze 
	int numOfNodes;
	//Holds all of the nodes that contribute to the shortest path
	Node[] backwardPath;

	/**
	 * Constructs a graph and takes an input maze text file
	 * 
	 * @param fileName -- the name of the maze text file
	 * @throws FileNotFoundException -- file is not found
	 * @throws NullPointerException -- if there are any nodes there are null
	 * @throws IOException -- if there are any issues regarding the BufferedReader
	 */
	Graph(String fileName) throws FileNotFoundException, NullPointerException, IOException
	{
		BufferedReader input = new BufferedReader(new FileReader(fileName));
		
		char[][] adjacencyMatrix = buildAdjacencyMatrix(input);
		
		findNeighbors(adjacencyMatrix);
	}
	

	/**
	 * Performs breadth first search to guarantee the shortest path 
	 * for the maze
	 * 
	 * @param start -- the starting node
	 * @param goal -- the goal node
	 */
	public void breadthFirstSearch(Node start, Node goal)
	{
		vertices = new ArrayDeque<Node>();
		
		backwardPath = new Node[numOfNodes];
		
		start.isVisited = true;
		
		Node current = start;
		
		vertices.offer(current);
		
		while(!vertices.isEmpty())
		{
			current = vertices.poll();
			
			if(current == goal)
			{
				int backwardPathCounter = 0;
				while(current.id != start.id)
				{
					if(current.id == goal.id)
					{
						current = adjacencyList[current.back];
						continue;
					}
					backwardPath[backwardPathCounter] = current;
					backwardPathCounter++;
					current = adjacencyList[current.back];
				}
				return;
			}
			
			for(Node node : current.neighbors)
			{
				if(node != null)
				{
					if(!node.isVisited)
					{
						node.isVisited = true;
						node.back = current.id;
						vertices.offer(node);
					}
				}
			}
		}
	}

	/**
	 * Created a two-dimensional array that represents the maze.
	 * 
	 * @param input -- A BufferedReader object of the .txt file.
	 * @return The adjacency matrix -- holds all of the characters from maze text file
	 * @throws IOException -- if there are issues with the BufferedReader
	 */
	public char[][] buildAdjacencyMatrix(BufferedReader input) throws IOException
	{
		String[] dimensions = input.readLine().split(" "); 

		char[][] adjacencyMatrix = new char[Integer.parseInt(dimensions[0])][Integer.parseInt(dimensions[1])];

		String line = "";

		int row = 0;

		while((line = input.readLine()) != null)
		{

			for(int col = 0; col < line.length(); col++)
			{
				char[] charsLine = line.toCharArray();

				if(charsLine[col] != 'X')
				{
					numOfNodes++;
				}
				adjacencyMatrix[row][col] = charsLine[col];
			}
			row++;

		}

		parseAdjacencyMatrix(adjacencyMatrix, numOfNodes);
		input.close();
		return adjacencyMatrix;
	}

	/**
	 * Parses all of the characters from the maze text file into an 
	 * adjacency matrix containing each char
	 * 
	 * @param adjacencyMatrix -- holds the characters from maze text file
	 * @param size -- how many nodes to make
	 */
	private void parseAdjacencyMatrix(char[][] adjacencyMatrix, int size) 
	{
		int row = 0; 
		int nodeId = 0;
		int listTracker = 0;

		adjacencyList = new Node[size];

		while(row < adjacencyMatrix.length)
		{
			int rowLength = adjacencyMatrix[0].length;

			for(int col = 0; col < rowLength; col++)
			{
				int posList = row * rowLength + col;


				if(adjacencyMatrix[row][col] == ' ')
				{
					adjacencyList[listTracker] = new Node(nodeId, posList);
					listTracker++;
					nodeId++;
				}
				else if(adjacencyMatrix[row][col] == 'S')
				{
					Node currNode = new Node(nodeId, posList);
					nodeId++;

					adjacencyList[listTracker] = currNode;
					listTracker++;

					start = currNode;
				}
				else if(adjacencyMatrix[row][col] == 'G')
				{
					Node currNode = new Node(nodeId, posList);
					nodeId++;

					adjacencyList[listTracker] = currNode;
					listTracker++;
					goal = currNode;
				}
			}

			row++;
		}
	}

	/**
	 * Finds the neighboring nodes for every node in the adjacency matrix
	 * 
	 * @param adjacencyMatrix -- matrix
	 */
	private void findNeighbors(char[][] adjacencyMatrix)
	{
		Node[][] adjacencyNodes = new Node[adjacencyMatrix.length][adjacencyMatrix[0].length];

		for(Node node : adjacencyList)
		{
			int row =  node.position / adjacencyMatrix[0].length;
			int col = node.position % adjacencyMatrix[0].length;

			adjacencyNodes[row][col] = node;
		}

		for(int row = 1; row < adjacencyNodes.length - 1; row++)
		{
			for(int col = 1; col < adjacencyNodes[0].length - 1; col++)
			{
				//if the current position in not a node
				if(adjacencyNodes[row][col] == null)
				{
					continue;
				}
				
				//North neighbor
				if(adjacencyNodes[row - 1][col] != null)
				{
					adjacencyNodes[row][col].neighbors[0] = adjacencyNodes[row - 1][col];
				}
				//East neighbor
				if(adjacencyNodes[row][col + 1] != null)
				{
					adjacencyNodes[row][col].neighbors[1] = adjacencyNodes[row][col + 1];
				}
				//South neighbor
				if(adjacencyNodes[row + 1][col] != null)
				{
					adjacencyNodes[row][col].neighbors[2] = adjacencyNodes[row + 1][col];
				}
				//West neighbor
				if(adjacencyNodes[row][col - 1] != null)
				{
					adjacencyNodes[row][col].neighbors[3] = adjacencyNodes[row][col - 1];
				}
			}
		}	
	}

	/**
	 * Constructs a new adjacency matrix to prevent any resetting
	 * 
	 * @param fileName -- name of the maze text file
	 * @return a new adjacency matrix 
	 * @throws IOException -- if there are any issues with the BufferedReader
	 */
	public char[][] createOutputAdjacencyMatrix(String fileName) throws IOException
	{
		BufferedReader input = new BufferedReader(new FileReader(fileName));
		
		String[] dimensions = input.readLine().split(" "); 

		char[][] adjacencyMatrix = new char[Integer.parseInt(dimensions[0])][Integer.parseInt(dimensions[1])];

		String line = "";

		int row = 0;

		while((line = input.readLine()) != null)
		{

			for(int col = 0; col < line.length(); col++)
			{
				char[] charsLine = line.toCharArray();

				if(charsLine[col] != 'X')
				{
					numOfNodes++;
				}
				adjacencyMatrix[row][col] = charsLine[col];
			}
			row++;

		}
		input.close();
		return adjacencyMatrix;
	}

	/**
	 * Prints all of the available nodes in our graph
	 * 
	 * @return a list of all nodes in graph
	 */
	public String toString()
	{
		return Arrays.deepToString(adjacencyList);
	}
	
	/**
	 * Represents a single node 
	 * 
	 * @author Tony Diep, Makenzie Peacock, last updated 3-31-17
	 */
	public class Node
	{
		//The current node's neighbors
		Node[] neighbors;
		//Marker for already visited or not
		boolean isVisited;
		//Id number for this node
		int id;
		//Backing number referring to previous node
		int back;
		//Position of this node in the adjacency matrix
		int position;

		/**
		 * Constructs a new node 
		 * 
		 * @param id -- this node's id 
		 * @param position -- this node's position in adjacency matrix
		 */
		Node(int id, int position)
		{
			isVisited = false;
			this.position = position;
			this.id = id;
			this.neighbors = new Node[4];
			back = -1;
		}

		/**
		 * Prints this node's id 
		 * 
		 * @return the readable version of this node object
		 */
		public String toString()
		{
			return "Node " + this.id;
		}
	}
}