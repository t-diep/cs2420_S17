package hash_tables;

import static hash_tables.Primes.next_prime;

import java.util.ArrayList;
import java.util.LinkedList;

import cracking.My_String;

/**
 * Represents another hash table that utilizes a LinkedList inside
 * 
 * @author Tony Diep, Jocee Porter, last updated 4-7-17
 *
 * @param <KeyType>
 * @param <ValueType>
 */
public class Hash_Chaining <KeyType, ValueType> implements hash_tables.Hash_Map<KeyType, ValueType>
{
	//Table containing Linked Lists
	protected ArrayList<LinkedList<Pair<KeyType, ValueType>>> table;
	//Size of our hash table
	protected int capacity;
	//Number of non null pairs that are in this hash table
	protected int num_of_elements;
	//Counter for number of collisions
	protected int collisions;
	//Keeps track of total time to insert
	protected long insertionTime;
	//Keeps track of the time to find a key
	protected int find_time;
	//Counter for number of items
	protected int find_items;
	//Keeps track of the time to hash
	protected int hash_time;
	//Counter for number of hashes
	protected int num_hash;
	//Counter for the number of insertions 
	protected int total_insertions;
	//Flag to allow resizing for this hash table or not
	protected boolean status;
	
	/**
	 * Constructs a new hash table with the LinkedListss
	 * 
	 * @param capacity -- the size of this hash table
	 */
	public Hash_Chaining(int capacity)
	{
		status = true;
		this.capacity = next_prime(capacity);
		this.num_of_elements = 0;
		table = new ArrayList<LinkedList<Pair<KeyType, ValueType>>>();
		init_table();
	}
	
	/**
	 * Sets up a blank hash table with each bucket filled with empty LinkedLists
	 */
	public void init_table()
	{
		table.clear();
		for(int i = 0; i<capacity; i++)
		{
			table.add(new LinkedList<Pair<KeyType, ValueType>>());
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void insert(KeyType key, ValueType value) 
	{
		long start_time = System.nanoTime();
		My_String keyString = new My_String(key + "");

		long start_hash = System.nanoTime();
		int location = keyString.hashCode()%capacity;

		long end_hash = System.nanoTime();
		hash_time += end_hash - start_hash;
		num_hash++;
		Pair<KeyType, ValueType> pear = new Pair<>(key, value);


		if(collisions > 5 && status == true)
		{
			resize(next_prime(capacity*2));
		}
		boolean replaced = false;


		for(Pair<KeyType, ValueType> pair : table.get(location))
		{
			if(table.get(location).contains(pear.key))
			{
				pair.key = pear.key;
				collisions ++;
				replaced = true;
			}
		}
		if(!replaced)
		{
			if(table.get(location)!= null)
			{
				collisions++;
			}
			table.get(location).add(pear);
		}
		num_of_elements++;
		long end_time = System.nanoTime();
		insertionTime += end_time-start_time;
	}

	/**
	 * Don't use method unless you know that the key is indeed in the array.
	 * {@inheritDoc}
	 */
	@Override
	public ValueType find(KeyType key) 
	{
		long start_find = System.nanoTime();
		My_String keyString = new My_String(key + "");
		long start_hash = System.nanoTime();
		int location = keyString.hashCode()%capacity;
		long end_hash = System.nanoTime();
		hash_time += end_hash - start_hash;
		num_hash++;
		int pair_int = 0;
		for(Pair<KeyType, ValueType> pair : table.get(location))
		{
			if(pair.key.equals(key))
			{
				long end_find = System.nanoTime();
				find_time += end_find - start_find;
				find_items ++;
				return table.get(location).get(pair_int).value;
			}
			collisions++;
			pair_int++;
		}
		
		long end_find = System.nanoTime();
		find_time += end_find - start_find;
		find_items ++;
		
		return null;
	}

	/**
	 * {@inheritDoc} 
	 */
	@Override
	public void clear() 
	{
		table.clear();
		reset_stats();
	}

	/**
	 * {@inheritDoc}
	 */
	private void reset_stats() 
	{
		this.collisions = 0;
		this.num_of_elements = 0;
		this.insertionTime = 0;
		this.total_insertions = 0;
		find_time = 0;
		find_items = 0;
		hash_time = 0;
		num_hash = 0;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int capacity() 
	{
		return this.capacity;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int size() 
	{	
		return this.num_of_elements;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void set_resize_allowable(boolean status) 
	{
		this.status = status;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ArrayList<Double> print_stats() 
	{
		ArrayList<Double> stats = new ArrayList<Double>();
		stats.add((double)collisions);
		stats.add((double)num_of_elements);
		stats.add((double)capacity);
		return stats;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void resize(int new_size) 
	{
		int new_prime = next_prime(capacity*2); 
		ArrayList<LinkedList<Pair<KeyType, ValueType>>> temporary = new ArrayList<LinkedList<Pair<KeyType, ValueType>>>(new_prime);


		for(int i = 0; i< capacity; i++)
		{
			if(table.get(i) != null)
			{

				temporary.add(table.get(i));
			}
			else
			{
				temporary.add(new LinkedList<Pair<KeyType, ValueType>>());
			}		
		}

		this.capacity = new_prime;

		//replace with old elements
		for(LinkedList<Pair<KeyType, ValueType>> pear : temporary)
		{
			if(pear != null && pear.size()!=0)
			{
				int counter = 0;
				while(counter<pear.size())
				{
					this.insert(pear.get(counter).key, pear.get(counter).value);
					counter++;
				}
			}
		}
	}
	
	/**
	 * Fill in calculations to show some of the stats about the hash table
	 */
	public String toString()
	{
		String result = new String();
		result = "------------ Hash Table Info ------------\n"
				+ "  Average collisions: " + collisions + "\n" + "  Average Hash Function Time: " + get_hash_time() + "\n"+ "  Average Insertion Time: " + get_insertion_time() + "\n"
				+ "  Average Find Time: " + get_find_time() + "\n"+ "  Percent filled : " + this.percentfilled() + "\n" + "  Size of Table  : "+ this.capacity +"\n" + "  Elements       : " + num_of_elements
+ "\n"				+ "-----------------------------------------\n";

		return result;

	}

	/**
	 * Computes the time for this hash table to find a particular key
	 * 
	 * @return find time
	 */
	private long get_find_time() 
	{
		if(find_items > 0)
		{
			return find_time/find_items;
		}
		return 0;
	}

	/**
	 * Computes the time for this hash table to insert Pair Nodes onto LinkedList
	 * 
	 * @return insertion time
	 */
	private long get_insertion_time() 
	{
		if(total_insertions >0)
		{
			return insertionTime/total_insertions;
		}
		return 0;
	}

	/**
	 * Computes the time for this hash table to hash
	 * 
	 * @return hash time
	 */
	private long get_hash_time() 
	{
		if(num_hash>0)
		{
			return hash_time/num_hash;
		}
		return 0;
	}

	/**
	 * Computes the percentage that represents a ratio in which the
	 * hash table is full
	 * 
	 * @return percentage
	 */
	private double percentfilled() 
	{
		double empty = 0;
		for(int i = 0; i< table.size(); i++)
		{
			
			if(table.get(i) == null)
			{
				empty ++;
			}
		}
		return 100 - (empty/this.capacity) * 100;
	}

	/**
	 * Our own toString to print the contents of our table
	 * @return table in string form
	 */
	public String hashToString()
	{
		return table.toString();
	}

}
