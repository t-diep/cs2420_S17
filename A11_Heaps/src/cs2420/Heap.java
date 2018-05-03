package cs2420;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.NoSuchElementException;

/**
 * Represents a priority queue of generically-typed items.
 * The queue is implemented as a min heap.
 * 
 * The min heap is implemented implicitly as an array.
 * 
 * @author Tony Diep, last udpated 4-14-17
 */
public class Heap<Type> implements Priority_Queue<Type>
{
	/** 
	 * The number of elements in the heap (NOT: the capacity of the array)
	 */
	private int							size;

	/**
	 * The implementation array used to store heap values.
	 * 
	 * NOTE: the capacity of the array will be larger (or equal) to the size (of the heap).
	 * 
	 * WARNING: to simplify math, you are to use a 1 INDEXED array. (this means you ignore 0 bucket) and
	 * the capacity of the array has to be 1 larger
	 */
	private Type[]					heap_array;

	/**
	 * If the user provides a comparator, use it instead of default comparable
	 */
	private Comparator<? super Type>	comparator;
	
	/**
	 * The capacity of the heap
	 * 
	 */
	private int 						capacity;
	
	/**
	 * Counter for the number of swaps
	 */
	protected int						numOfSwaps;
	
	/**
	 * Constructs an empty priority queue. Orders elements according
	 * to their natural ordering (i.e., AnyType is expected to be Comparable)
	 * 
	 * AnyType is not forced to be Comparable.
	 */
	@SuppressWarnings("unchecked")
	public Heap()
	{
		size = 0;
		comparator = null;
		heap_array = (Type[]) new Object[10];
		capacity = heap_array.length;
	}

	/**
	 * Construct an empty priority queue with a specified comparator.
	 * 
	 * Orders elements according to the input Comparator (i.e., AnyType need not be Comparable).
	 */
	@SuppressWarnings("unchecked")
	public Heap( Comparator<? super Type> c )
	{
		this();
		comparator = c;
		heap_array = (Type[]) new Object[10];
		capacity = heap_array.length;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Type peek() 
	{	
		if(size == 0) throw new NoSuchElementException();
		
		return heap_array[1];
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
	@SuppressWarnings("unchecked")
	@Override
	public void clear() 
	{
		size = 0;
		heap_array = (Type[]) new Object[10]; 
		capacity = heap_array.length;
		numOfSwaps = 0;
	}

	/*
	 * 
	 * Removes and returns the minimum item in this priority queue.
	 * 
	 * @throws NoSuchElementException if this priority queue is empty.
	 * (Runs in logarithmic time.)
	 */
	public Type dequeue() throws NoSuchElementException
	{
		if(size == 0)	throw new NoSuchElementException();
		if(size == 1)
		{
			size--;
			return heap_array[1];
		}
		
		Type smallest = heap_array[1];
		heap_array[1] = heap_array[size];
		size--;
		percolateDown(size);
		return smallest;
	}
	
	/**
	 * Gets the smallest node in this heap
	 */
	public Type getSmallestNode()
	{
		if(size == 0) throw new NoSuchElementException();
		
		return heap_array[1];
	}
	
	/**
	 * Gets the parent node from the current node
	 * 
	 * @return parent
	 */
	public Type getParent(int index)
	{
		if(index <= 0 || index > size)	throw new IndexOutOfBoundsException();
		
		return heap_array[index / 2];
	}
	
	/**
	 * Gets the left child from the current node
	 * 
	 * @return left child
	 */
	public Type getLeftChild(int index)
	{
		if(index <= 0 || index > size)	throw new IndexOutOfBoundsException();
		
		return heap_array[index * 2];
	}
	
	/**
	 * Gets the right child from the current node
	 * 
	 * @return right child
	 */
	public Type getRightChild(int index)
	{
		if(index <= 0 || index > size)	throw new IndexOutOfBoundsException();
		
		return heap_array[index * 2 + 1];
	}
	
	/**
	 * Adds an item to this priority queue.
	 * (Runs in logarithmic time.) Can sometimes terminate early.
	 * 
	 * WARNING: make sure you use the compare method defined for you below
	 * 
	 * @param x
	 *            -- the item to be inserted
	 */
	public void add( Type x )
	{
		if(size == capacity - 1)
		{	
			@SuppressWarnings("unchecked")
			Type[] backingHeapArray = (Type[]) new Object[capacity * 2];
			
			//Copy all elements over from old array to backing array
			for(int index = 1; index < heap_array.length; index++)
			{
				backingHeapArray[index] = heap_array[index];
			}
			
			heap_array = backingHeapArray;
			capacity = heap_array.length;
		}

		heap_array[++size] = x;
		percolateUp(size);
	}
	
	/**
	 * "Bubbles up" the current node 
	 * 
	 * @param index -- the index corresponding to the current node 
	 */
	protected void percolateUp(int index)
	{
		if(size > 1)
		{
			while(compare(heap_array[index], heap_array[index / 2]) < 0)
			{
				swap(index, index / 2);
				index = index / 2;
				
				if(index == 1)
				{
					break;
				}
			}
		}
	}
	
	/**
	 * "Bubbles down" the current node
	 * 
	 * @param index
	 *            -- the index corresponding to the current node
	 */
	protected void percolateDown(int index) 
	{
		int left = 2 * index;
		int right = 2 * index + 1;
		int indexOfSmallest = 0;
		
		while(left <= size)
		{			
			if(right <= size) // there are two children
			{
				if(compare(heap_array[left], heap_array[right]) < 0)
				{
					indexOfSmallest = left;
				}
				else
				{
					indexOfSmallest = right;
				}
			}
			//No right child
			else
			{
				indexOfSmallest = left;
			}
			
			if(compare(heap_array[index], heap_array[indexOfSmallest]) <= 0)
			{
				return;
			}
				
			index = indexOfSmallest;
			swap(index, indexOfSmallest);
		}
	}
	
	/**
	 * Swaps two elements in an array
	 * 
	 * @param array -- array that has the elements to swap
	 * @param firstIndex -- index corresponding to first element to swap
	 * @param secondIndex -- other index corresponding to second element to swap
	 */
	protected void swap(int firstIndex, int secondIndex)
	{
		Type temporary = heap_array[firstIndex];
		heap_array[firstIndex] = heap_array[secondIndex];
		heap_array[secondIndex] = temporary;
		numOfSwaps++;
	}

	/**
	 * Generates a DOT file for visualizing the binary heap.
	 * 
	 * @param filename -- the named file to save the dot file as
	 */
	public void generateDotFile( String filename )
	{
		try (PrintWriter out = new PrintWriter(filename))
		{
			out.println(this);
			out.close();
		}
		catch (IOException e)
		{
			System.out.println(e);
		}
	}

	/**
	 * Internal method for comparing lhs and rhs using Comparator if provided by the
	 * user at construction time, or Comparable, if no Comparator was
	 * provided.
	 */
	@SuppressWarnings("unchecked")
	private int compare( Type lhs, Type rhs )
	{
		if (comparator == null)
		{
			return ((Comparable<? super Type>) lhs).compareTo(rhs); 
		}

		return comparator.compare(lhs, rhs);
	}

	/**
	 * Converts this heap to an array
	 * 
	 * @return a copy of the array used in the heap
	 */
	public Object[] toArray()
	{
		Object[] copy_of_array = new Object[size + 1];

		for (int i = 1; i <= size; i++)
		{
			copy_of_array[i] = heap_array[i];
		}

		return copy_of_array;
	}

	/**
	 * @return a string representing the DOT data of the heap 
	 * 
	 * This can be further augmented to print out any instrumented values that you think
	 * are important.  Note: To allow them not to conflict with the DOT notation, simply
	 * preface them with the // comment characters: e.g., "// numbers of insertions: 1234"
	 */
	@Override
	public String toString()
	{
		String result = "digraph Heap {\n\tnode [shape=record]\n";
		for (int i = 1; i <= size; i++)
		{
			result += "\tnode" + i + " [label = \"<f0> |<f1> " + heap_array[i] + "|<f2> \"]\n";
			if (((i * 2)) <= size) result += "\tnode" + i + ":f0 -> node" + ((i * 2)) + ":f1\n";
			if (((i * 2) + 1) <= size) result += "\tnode" + i + ":f2 -> node" + ((i * 2) + 1) + ":f1\n";
		}
		result += "}";

		result += "\n--------------------------------------------\n"
				+ "Array Version: " + Arrays.toString(this.toArray())
				+ "\nSize: " + size + ", Capacity: " + capacity + ", Number of Swaps: " + numOfSwaps;

		return result;
	}

	/**
	 * 1) copy data from array into heap storage
	 * 2) do an "in place" creation of the heap
	 * 
	 * @param array
	 *            - random data (unordered)
	 */
	public void build_heap_from_array(Type[] array )
	{	
		clear();
		
		size = array.length - 1;
		
		heap_array = array;
		
		//Copy elements over
		for(int index= 1; index <= size; index++)
		{
			heap_array[index] = array[index];
		}
		
		//Percolate down
		for(int halfWay = (array.length / 2); halfWay > 1; halfWay--)
		{
			percolateDown(halfWay);
		}
	}

	/**
	 * convert the heap array into a sorted array from largest to smallest
	 * 
	 * Note: this destroys the heap property of the array and should be a terminal operation, which
	 *       is not what we would likely do in a real program, but is appropriate to for our purposes (i.e.,
	 *       understanding how heap sort works in place).
	 * 
	 */
	@SuppressWarnings("unchecked")
	public void heap_sort()
	{
		// WARNING: advanced work only worth 2.5% of grade
		// If you do not fully implement this code, leave it blank
		build_heap_from_array((Type[]) toArray());
		
		for(int index = size; index > 1; index--)
		{
			swap(index, 1);
			percolateDown(size);
		}
	}
}