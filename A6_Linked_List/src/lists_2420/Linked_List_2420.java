package lists_2420;

import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * This linked list implements the List_2420 interface. It is a unidirectional
 * implementation. 
 * 
 * @author Andrew Worley, Tony Diep
 * 
 * last update: 2/23/17
 *
 * @param <Type> Generic identifier for elements contained in this list
 */
public class Linked_List_2420<Type> implements List_2420<Type> 
{
	Node<Type> head;
	Node<Type> tail;
	private int size;
	
	/**
	 * Creates a new list with containing no values	
	 */
	public Linked_List_2420()
	{
		this.head = new Node<Type>(null,null);
		this.size = 0;
		this.tail = head;//tail in use for add_last and remove_last O(C)
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void add_first(Type data) 
	{
		if (this.size == 0) 
		{
			this.head.data = data;
		}
		else {
			Node<Type> nodeChain = new Node<Type>(this.head.data, this.head.next);//save a chain of nodes
			this.head.data = data;
			this.head.next = nodeChain; //re-attach said chain
			
			if (size == 1) 
			{
				this.tail = head.next;
			}
		}
		
		this.size++;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void add_last(Type data) 
	{
		/*
		 * Adding last to a list of 0 elements is nearly same 
		 * as adding first to a list of 0 elements;
		 */
		if (this.size == 0) {
			this.head.data = data;
		}
		else {
			//for all other cases
			this.tail.next = new Node<Type>(data,null);//add the new node to the end
			this.tail = tail.next;//update tail identifier
		}
		
		this.size++;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void add_middle(int after, Type data) {
		if (after == 0 && this.size > 0) {
			Node<Type> tempChain = new Node<Type>(head.next.data, head.next.next);
			
			this.head.next.data = data;
			this.head.next.next = tempChain;
			this.size++;
		}
		else if (after >= this.size-1) {
			this.add_last(data);
		}
		else {
			Node<Type> currentNode = this.head.next;//start with the node after the head
			
			//start at one, we always add after the current node or specified after value
			for (int nodeIndex = 1; nodeIndex < after; nodeIndex++) {
				currentNode = currentNode.next;
			}
			
			/* 
			 * once we break the loop we can make our node chain.
			 * The data is of the currentNode.next (skipped our gap) and its next is the next
			 * next of the the original found node found post for loop break.
			 */
			Node<Type> tempChain = new Node<Type>(currentNode.next.data, currentNode.next.next);
			
			//make our new node and attach our chain for a complete list
			currentNode.next = new Node<Type>(data, tempChain);
			this.size++;
		}
		
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void clear() {
		//reset size and null our references
		this.size = 0;
		this.head.data = null;
		this.head.next = null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean contains(Type item) 
	{
		Node<Type> currentNode = head;
		
		//iterate through the list until the node is null and contains no data
		while (currentNode != null && currentNode.data != null) 
		{
			if (currentNode.data.equals(item)) 
			{
				return true;
			}
			
			currentNode = currentNode.next;
		}
		
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean contains_recursive(Type item) 
	{
		if (this.size == 0) {
			return false;
		}
		
		return this.head.contains_recursive(item);//start with the head node of this list
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Type get_first() throws NoSuchElementException 
	{
		if (this.head.data == null) {
			throw new NoSuchElementException();
		}
		
		return this.head.data;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Type get_last() throws NoSuchElementException 
	{
		if (this.tail.data == null) {
			throw new NoSuchElementException();
		}
		
		return this.tail.data;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Type remove_first() throws NoSuchElementException 
	{
		if (this.size == 0) 
		{
			throw new NoSuchElementException();
		}
		
		Type removedData = this.head.data;
		
		this.head = this.head.next;//reassign a new head and loose the old head
		this.size--;
		
		return removedData;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Type remove_last() throws NoSuchElementException 
	{
		if (this.size <= 0) {
			throw new NoSuchElementException();
		}
		
		Node<Type> currentNode = this.head;
		
		while(currentNode.next != this.tail) {
			currentNode = currentNode.next;
		}
		
		Type removedData = currentNode.next.data;
		this.tail = currentNode;
		
		this.size--;
		
		return removedData;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int size() 
	{
		return this.size;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void reverse() 
	{
		Node<Type> temp = new Node<Type>(null,null);//create a new chain of node
		int listSize = this.size;
		
		/* add all elements from the original list to the new chain of links
		 * by calling remove last from the list
		 */
		while (this.size > 0) {
			temp.data = this.remove_last();
			temp.next = new Node<Type>(null,null);
			temp = temp.next;
		}
		
		this.head = temp;//reassign the head node our temp. list
		this.size = listSize;//reset the size since it was decremented from removing elements
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int compute_size_recursive() 
	{
		//if nothing is contained in the head data then the lenght is 0
		if (this.head.data == null) {
			return 0;
		}
		
		/*
		 * By ensuring there is data in the head we can
		 * use our nodes recursive length method. Without the 
		 * check prior to this call a chain of 1, will return 1, but if
		 * that chain contains nothing then the list should be 0 and not 1. 
		 */
		return this.head.length();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ArrayList<Type> to_ArrayList_post_recurse() {
		ArrayList<Type> result = new ArrayList<Type>();
		
		return this.head.to_ArrayList_post_recursive(result);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ArrayList<Type> to_ArrayList() {
		ArrayList<Type> result = new ArrayList<Type>();
		int listSize = this.size;
		
		/*
		 * This loops treats the nodes like they're on
		 * a wheel. As the wheel spins we read a value. Once we
		 * do one full rev. we stop and the list was only traversed once
		 * and no changes were made to original list.
		 */
		for(int index = listSize; index > 0; index--) {
			Type item = this.remove_first();
			result.add(item);
			this.add_last(item);
		}
		
		return result;
	}
	
	public String toString() {
		String chainLine = "("+ this.size + ") ";
		
		if(this.size == 0) {
			return "empty";
		}
		
		Node<Type> currentNode = this.head;
		
		while (currentNode != null) {
			chainLine += "["+ currentNode.data + "]--> ";
			currentNode = currentNode.next;
		}
		
		return chainLine + "null";
	}
	
	/**
	 *
	 * Pictorially, a node is:
	 *
	 * data next ---------- | 5 |---+---> ----------
	 * 
	 * Note, while a 5 is used above any "Type" could be contained in the node
	 */
	static class Node<Type> {
		Node<Type> next;
		Type data;
	
		public Node(Type the_data, Node<Type> after_me) 
		{
			this.data = the_data;
			this.next = after_me;
		}

		/**
		 * 
		 * This function must be written recursively.
		 * 
		 * @return the length of this "chain of nodes", including self.
		 * 
		 *         Note: 1) it doesn't matter if something (or multiple
		 *         somethings) points to this node, 
		 *         2) if this node doesn't
		 *         point at anything, then the size would be 1.
		 */
		public int length() {
			if (this.next == null) {
				return 1;
			}

			return 1 + this.next.length();
		}

		/**
		 * recursive determine if the item is in this node or the nodes after
		 * 
		 * @param item - needle
		 * @return - true if item in chain
		 */
		public boolean contains_recursive(Type item) {
			if (this.data.equals(item)) {
				return true;
			}
			if (this.data == null || this.next == null) {
				return false;
			}
			
			return this.next.contains_recursive(item);
		}

		/**
		 * This function must be written recursively 
		 * (using a helper method, with the arraylist as a parameter, to do the recursion)
		 * 
		 * Create an array list containing the data from this node and all nodes
		 * after it.
		 * 
		 * In the helper method, add the data to the array list after the
		 * recursive call, thus "reversing" the list.
		 *
		 */
		public ArrayList<Type> to_ArrayList_post_recursive(ArrayList<Type> arrayList) {	
			if (this.data == null) {
				return arrayList;
			}
			
			return to_ArrayList_post_recursive(arrayList, this);
		}
		
		/**
		 * Recursive method to return elements stored in this node, and the following nodes,
		 * in reverse order using post order rescusion.
		 * 
		 * @param arrayList - list to contain values stored in nodes
		 * @param node - contains data and and next node value
		 * 
		 * @return - an arrayList containing elements stored in this node, and the following nodes,
		 * in reverse order
		 */
		private ArrayList<Type> to_ArrayList_post_recursive(ArrayList<Type> arrayList, Node<Type> node) {
			if (node == null) {
				return arrayList;
			}
			
			to_ArrayList_post_recursive(arrayList, node.next);
	        arrayList.add(node.data);
			
			return arrayList;
		}

		/**
		 *
		 * Creates a string that describes the current node and all following
		 * nodes, for example, a list of the nubmers 0, 1, 2, 3 would print as:
		 * 
		 * "[0]--> [1]--> [2]--> [3]--> null"
		 *
		 * WARNING: the syntax must be exact. "open square bracket, data, close
		 * square bracket, hyphen, hyphen, greater than space, ... null"
		 *
		 * @return a string representation of this chain of nodes
		 */
		public String toString() {
			if (this.data == null && this.next == null) {
				return "null";
			}
			if (this.data != null && this.next == null) {
				return "["+ this.data.toString() +"]--> " + "null";
			}
			else {
				return "["+ this.data.toString() +"]--> " + this.next.toString();
			}
		}
	}
}