/**
 * 
 */
package cs2420;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.NoSuchElementException;

/**
 * Represents a Binary Search Tree (BST)
 * 
 * @author Tony Diep, Gabbie Hoyer
 *
 */
public class BinarySearchTree<Type extends Comparable<? super Type>> implements SortedSet<Type> 
{
	public static void main(String[] args)
	{
		BinarySearchTree<Integer> ints = new BinarySearchTree<Integer>();
		
		ints.add(5);
		ints.add(4);
		ints.add(2);
		ints.add(3);
		ints.add(6);
		ints.add(8);
		ints.add(7);
		
		System.out.println("Inorder: " + ints.toArrayList().toString());
		
		ArrayList<Integer> preOrder = new ArrayList<Integer>();
		
		ints.preOrderTraversal(ints.root, preOrder);
		
		System.out.println("Preorder: " + preOrder.toString());
		
		ArrayList<Integer> postOrder = new ArrayList<Integer>();
		
		ints.postOrderTraversal(ints.root, postOrder);
		
		System.out.println("Postorder: " + postOrder.toString());
	}
	
	
	//Represents the root
	Node<Type> root;
	//Represents the size of the BST
	int size;
	
	/**
	 * Default constructor for BST; sets up an empty BST with empty root node
	 */
	BinarySearchTree() 
	{
		root = null;
	}
	
	/**
	 * Other constructor that inserts data onto the root node
	 * @param the_data -- the data
	 */
	BinarySearchTree(Type the_data)
	{
		root = new Node<Type>(the_data);
	}

	/**
	 * Driver for writing this tree to a dot file
	 * @param filename
	 */
	public void writeDot(String filename)
	{
		try 
		{
			// PrintWriter(FileWriter) will write output to a file
			PrintWriter output = new PrintWriter(new FileWriter(filename));

			// Set up the dot graph and properties
			output.println("digraph BST {");
			output.println("node [shape=record]");

			if(root != null)
				writeDotRecursive(root, output);
			// Close the graph
			output.println("}");
			output.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Prints out the Dot diagram to draw the different nodes contained in this class
	 *
	 * @param node -- single Node in the BST
	 * @param output -- the diagram
	 * @throws Exception
	 */
	private void writeDotRecursive(Node<Type> node, PrintWriter output) throws Exception
	{
		output.println(node.the_data + "[label=\"<L> |<D> " + node.the_data + "|<R> \"]");
		
		if(node.leftChild != null)
		{
			// write the left subtree
			writeDotRecursive(node.leftChild, output);

			//Construct the link between the node and left subtree
			output.println(node.the_data + ":L -> " + node.leftChild.the_data + ":D" );
		}
		
		if(node.rightChild != null)
		{
			// write the left subtree
			writeDotRecursive(node.rightChild, output);

			// then make a link between n and the right subtree
			output.println(node.the_data + ":R -> " + node.rightChild.the_data + ":D" );
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean add(Type item) 
	{
		if(root == null)
		{
			root = new Node<Type>(item);
			size++;
			return true;
		}
		
		if(item == null)
		{
			throw new NullPointerException();
		}
		
		root.insert(item);
		size++;
		return true;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void clear() 
	{
		root = null;
		size = 0;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean contains(Type item) 
	{
		Node<Type> currNode = root;
		
		int compar = item.compareTo(currNode.the_data);
		if (item.compareTo(currNode.the_data)== 0) {
			return true;
		}
		if (compar < 0 && currNode.leftChild != null && currNode.leftChild.contains((Type) item)) {
			return true;
		}
		if (compar > 0 && currNode.rightChild != null && currNode.rightChild.contains((Type) item)) {
			return true;
		}

		return false;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean containsAll(Collection<? extends Type> items) 
	{	
		if(items == null)
		{
			throw new NullPointerException();
		}
		
		boolean isContained = false;
		
		for(Type item: items)
		{
			this.contains(item);
			isContained = true;
		}

		return isContained;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Type first() throws NoSuchElementException 
	{
		if (root == null) {
			throw new NoSuchElementException();
		}
		
		return elementAt(root.getLeftmostNode());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isEmpty() 
	{
		// TODO Auto-generated method stub
		return this.size() == 0;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Type last() throws NoSuchElementException 
	{
		if (root == null) {
			throw new NoSuchElementException();
		}
		return elementAt(root.getRightmostNode());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean addAll(Collection<? extends Type> items) 
	{
		if(items == null)
		{
			throw new NullPointerException();
		}
		
		boolean isAdded = false;
		
		for(Type item: items)
		{
			this.add(item);
			isAdded = true;
		}

		return isAdded;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean remove(Type item) 
	{	
		size--;
		Node<Type> currNode = root;
		Node<Type> parent = root;
		
		boolean isALeftChild = true;
		
		while(currNode.the_data != item)
		{
			parent = currNode;
			
			if(item.compareTo(currNode.the_data) < 0)
			{
				isALeftChild = true;
				
				currNode = currNode.leftChild;
			}
			else
			{
				isALeftChild = false;
				currNode = currNode.rightChild;
			}
			
			if(currNode == null)
			{
				return false;
			}
		}
		
		//No child
		if(currNode.leftChild == null && currNode.rightChild == null)
		{
			if(currNode == root)
			{
				root = null;
			}
			else if(isALeftChild)
			{
				parent.leftChild = null;
			}
			else
			{
				parent.rightChild = null;
			}
		}
		//No right child
		else if(currNode.rightChild == null)
		{
			if(currNode == root)
			{
				root = currNode.leftChild;
			}
			else if(isALeftChild)	
			{
				parent.leftChild = currNode.leftChild;
			}
			else
			{
				parent.rightChild = currNode.rightChild;
			}
		}
		//No left child
		else if(currNode.leftChild == null)
		{
			if(currNode == root)
			{
				root = currNode.rightChild;
			}
			else if(isALeftChild)
			{
				parent.leftChild = currNode.leftChild;
			}
			else
			{
				parent.rightChild = currNode.rightChild;
			}
		}
		//Two children
		else 
		{
			Node<Type> temp = getTempNode(currNode);
			
			if(currNode == root)
			{
				root = temp;
			}
			else if(isALeftChild)
			{
				parent.leftChild = temp;
			}
			else
			{
				parent.rightChild = temp;
			}
			
			temp.leftChild = currNode.leftChild;
		}
	
		return true;
	}
	
	/**
	 * ~HELPER METHOD~
	 * 
	 * Generates the new parent of the BST after removal
	 */
	private Node<Type> getTempNode(Node<Type> currNode)
	{
		//Replaced parent
		Node<Type> tempParent = currNode;
		//Replacement
		Node<Type> temp = currNode;
		
		Node<Type> target = currNode.rightChild;
		
		while(target != null)
		{
			tempParent = temp;
			temp = target;
			target = target.leftChild;
		}
		
		if(temp != currNode.rightChild)
		{
			tempParent.leftChild = temp.rightChild;
			temp.rightChild = currNode.rightChild;
		}
		
		return temp;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean removeAll(Collection<? extends Type> items) 
	{
		if(items == null)
		{
			throw new NullPointerException();
		}
		
		boolean isRemoved = false;
		
		for(Type item: items)
		{
			this.remove(item);
			isRemoved = true;
		}

		return isRemoved;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int size() 
	{	
		return size;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ArrayList<Type> toArrayList() 
	{
		ArrayList<Type> arrayList = new ArrayList<Type>();	
		inorderTraversal(root, arrayList);
			
		return arrayList;
	}
	
	/**
	 * ~HELPER METHOD~
	 * 
	 * Traverses each node in the BST using inorder
	 *
	 * @param node -- the starting node in which to start traversing
	 */
	private void inorderTraversal(Node<Type> node, ArrayList<Type> list)
	{
		if(this.root.the_data == null)
		{
			return;
		}
		
		if(node.leftChild != null)
		{		
			inorderTraversal(node.leftChild, list);
		}
		
		list.add(node.the_data);
		
		if(node.rightChild != null)
		{
			inorderTraversal(node.rightChild, list);
		}
	}
	
	
	/**
	 * ~HELPER METHOD~
	 * 
	 * Traverses each node in the BST using inorder
	 *
	 * @param node -- the starting node in which to start traversing
	 */
	private void preOrderTraversal(Node<Type> node, ArrayList<Type> list)
	{
		if(this.root.the_data == null)
		{
			return;
		}
		
		list.add(node.the_data);
		
		if(node.leftChild != null)
		{		
			preOrderTraversal(node.leftChild, list);
		}
		
		if(node.rightChild != null)
		{
			preOrderTraversal(node.rightChild, list);
		}
	}
	
	/**
	 * ~HELPER METHOD~
	 * 
	 * Traverses each node in the BST using inorder
	 *
	 * @param node -- the starting node in which to start traversing
	 */
	private void postOrderTraversal(Node<Type> node, ArrayList<Type> list)
	{
		if(this.root.the_data == null)
		{
			return;
		}
	
		if(node.leftChild != null)
		{		
			inorderTraversal(node.leftChild, list);
		}
		
		if(node.rightChild != null)
		{
			inorderTraversal(node.rightChild, list);
		}
		
		list.add(node.the_data);
	}
	
	
	/**
	 * Obtains the data from a specific node
	 * 
	 * @param node -- the node of interest
	 * @return the data contained in the node of interest
	 */
	private Type elementAt(Node<Type> node) 
	{
		if (node == null) 
		{
			return null;
		}
		return node.the_data;
	}
	
	/**
	 * 
	 * Represents a Node from a binary search tree; contains a possible reference 
	 * to a left child and/or right child or none at all
	 * 
	 * Pictorially, a node is:
	 *
	 * left data right --------------- <--+ | 5 | +---> ---------------
	 * 
	 * Note, while a 5 is used above any "Type" could be contained in the node
	 */
	static class Node<Type extends Comparable<? super Type>> 
	{
		//The data contained in the node
		Type the_data;
		//The left child
		Node<Type> leftChild;
		//The right child
		Node<Type> rightChild;

		/**
		 * Creates a new node
		 * 
		 * @param the_data
		 */
		Node(Type the_data) 
		{
			this.the_data = the_data;
			this.leftChild = null;
			this.rightChild = null;
		}

		/**
		 * 
		 * This function must be written recursively.
		 *
		 * Height is defined as the 1 plus the maximum height of the left vs
		 * right sub tree
		 * 
		 * @return the height from this node to its leaves
		 * 
		 * 
		 */
		int height() 
		{
			int countLeft = 1;
			int countRight = 1;
			
			if (this.leftChild != null) 
			{
				countLeft = 1 + leftChild.height();
			}

			if (this.rightChild != null) 
			{
				countRight = 1 + rightChild.height();
			}

			return Math.max(countLeft, countRight);
		}

		/**
		 * recursive determine if the item is in this node or the nodes after
		 * 
		 * @param item
		 *            - needle
		 * @return true if item in tree
		 */
		boolean contains(Type item) 
		{	
			if(this.the_data == null)
			{
				throw new NullPointerException();
			}
			
			//We found our item!
			if(item.equals(this.the_data))
			{
				return true;
			}
			
			if(this.leftChild != null && item.compareTo(this.the_data) < 0)
			{
				return this.leftChild.contains(item);
			}

			if(this.rightChild != null && item.compareTo(this.the_data) > 0)
			{
				return this.rightChild.contains(item);
			}
				
			return false;
		}

		/**
		 * recursive - add a node
		 * 
		 * @param item
		 *            - data to add
		 * @return
		 */
		void insert(Type item) 
		{
			if (item.compareTo(this.the_data) < 0) 
			{
				if (leftChild != null) 
				{
					leftChild.insert(item);
				} else {
					leftChild = new Node<Type>(item);
					leftChild.the_data = item;
				}
			}  
			
			if (item.compareTo(this.the_data) > 0) 
			{
				if (rightChild != null) 
				{
					rightChild.insert(item);
				} 
				else 
				{
					rightChild = new Node<Type>(item);
					rightChild.the_data = item;
				}
			}
			
			if(item.compareTo(this.the_data) == 0)
			{
				return;
			}
		}
		
		//helper methods for first and last methods of BST above
		
		/**
		 * Gets the leftmost node in the BST; the leftmost node is 
		 * in other words the node that contains the lesser data value
		 * 
		 * @return leftmost node
		 */
		protected Node<Type> getLeftmostNode() 
		{
			if(leftChild == null) 
			{
				return this;
			}
			return leftChild.getLeftmostNode();
		}
		
		/**
		 * Gets the rightmost node in the BST; the rightmost node is
		 * the node containing the great data value
		 * 
		 * @return rightmost node
		 */
		protected Node<Type> getRightmostNode() 
		{
			Node<Type> currNode = this;
			
			while(currNode.rightChild != null)
			{
				currNode = currNode.rightChild;
			}
			return currNode;
		}
	}
}
