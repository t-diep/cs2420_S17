package hash_tables;

import java.util.ArrayList;

import cracking.My_String;

import static hash_tables.Primes.next_prime;

/**
 * @author H. James de St. Germain, April 2007
 *         # Adapted by Erin Parker to accept generic items for keys and values
 *
 *         Represents a hash table of key-value pairs.
 *         Linear probing is used to handle conflicts.
 */
public class Hash_Table_Linear_Probing<KeyType, ValueType> implements Hash_Map<KeyType, ValueType>
{
	//The table for inserting hashes
	protected ArrayList<Pair<KeyType, ValueType>>	table;
	//Size for this hash table
	protected int								capacity;
	//Counter for how many current hashes are in the hash table
	protected int								num_of_entries;
	//Records the total time to insert
	protected long 								insertionTime;
	//Keeps track of the number of insertions
	protected long 								total_insertions;
	//Records the total time to find a key
	protected long 								find_time;
	//Keeps track of the number of items found
	protected int 								find_items;
	//Records the total time to hash
	protected long 								hash_time;
	//Records number of hashes 
	protected int 								num_hash;
	//Flag for to enable resizing or not
	protected boolean 							status;
	//Keeps track of the number of collisions 
	protected double 							collisions;
	

	/**
	 * Hash Table Constructor
	 * @param initial_capacity - try to make this equal to twice the expected number of values
	 */
	public Hash_Table_Linear_Probing( int initial_capacity )
	{
		this.capacity = next_prime(initial_capacity);
		status = true;
		init_table();
		reset_stats();
	}
	

	/**
	 * Puts the given "value" into the hash table under the given "key".
	 * On a duplicate entry, replace the old data with the new "value".
	 * 
	 * For Probing Tables: This method will double* the size of the table if the number
	 *                     of elements is > 1/2 the capacity
	 * For Chaining Tables: double* the size of the table if the average number of collisions
	 *                      is greater than 5.
	 *           *double --> double then choose next greatest prime 
	 * 
	 */
	public void insert( KeyType key, ValueType value )
	{
		long start_time = System.nanoTime();
		
		if(num_of_entries >= this.capacity / 2 && this.status == true)
		{
			doubling_behavior(true);
		}
		My_String key_string = new My_String(key + "");
		long start_time_hash = System.nanoTime();
		int location = (key_string.hashCode()%capacity);
		long end_time_hash = System.nanoTime();
		hash_time += (end_time_hash - start_time_hash);
		num_hash ++;
		int k=0;
		
		while(table.get(location) != null)
		{
			
			if(table.get(location).key.equals(key))
			{
				table.get(location).value = value;
				break;
			}
			this.collisions++;
			k++;
			location = nextHash(location, k);
			
		}
		table.set(location, new Pair<KeyType, ValueType>(key, value));

		num_of_entries ++;
		total_insertions++;
		long end_time = System.nanoTime();
		insertionTime += end_time-start_time;
	}

	/**
	 * Computes the next hashing index
	 * @param location -- current hashing index
	 * @param incrementer -- counter to advance by one every time
	 * @return the next hashing index
	 */
	public int nextHash(int location, int incrementer)
	{
		return advance(location, incrementer);
	}

	/**
	 * ~HELPER METHOD~
	 * 
	 * Advances to the next hash 
	 * 
	 * @param location -- current hashing index
	 * @param incrementer -- counter to advance by one every time
	 * @return the next hashing index
	 */
	private int advance(int location, int incrementer) 
	{
		return (location + incrementer)%capacity;
	}

	/**
	 * if doubling is off, then do not change table size in insert method
	 * 
	 * @param on - turns doubling on (the default value for a hash table should be on)
	 */
	public void doubling_behavior(boolean on)
	{
		if(on)
		{
		
		int new_prime = next_prime(capacity*2); 
		ArrayList<Pair<KeyType, ValueType>> temporary = new ArrayList<Pair<KeyType, ValueType>>(capacity);

		
		for(int i = 0; i< capacity; i++)
		{
			if(table.get(i) != null){
				
				temporary.add(table.get(i));
			}
			else
			{
				temporary.add(null);
			}		
		}
		
		this.capacity = new_prime;
		init_table();

			//replace with old elements
			for(Pair<KeyType, ValueType> pear : temporary)
			{
				if(pear != null){
					this.insert(pear.key, pear.value);
				}
			}
		} 
	}

	/**
	 * Search for an item in the hash table, using the given "key".
	 * Return the item if it exists in the hash table.
	 * Otherwise, returns null.
	 * 
	 * @param key -- the key to use to search
	 * @return value associated with our key
	 * 
	 */
	public ValueType find( KeyType key )
	{
		long start_time = System.nanoTime();
		//I fixed this I think, still need to test.
		My_String keyString = new My_String(key + "");
		
		
		long start_time_hash = System.nanoTime(); 
		int location = keyString.hashCode()%capacity;
		long end_time_hash = System.nanoTime();
		hash_time+=(end_time_hash - start_time_hash);
		num_hash ++;
		
		int k=0;
		while(location < capacity)
		{
			if(table.get(location)==null)
			{
				long end_time = System.nanoTime();
				find_items++;
				this.find_time+=(end_time-start_time);
				return null;
			}
				if(table.get(location).key.equals(key))
				{
					long end_time = System.nanoTime();
					this.find_time+=(end_time-start_time);
					find_items++;
					return table.get(location).value;
				}
				else
				{
					collisions ++;
					k++;
					location = nextHash(location, k);
				}
		}
		
		long end_time = System.nanoTime();
		find_items++;
		this.find_time+=(end_time-start_time);
		return null;
	}

	/**
	 * Remove all items from the hash table (and resets stats).
	 */
	public void clear()
	{
		init_table();
		this.num_of_entries = 0;
		reset_stats();
	}

	/**
	 * Returns the capacity of the hash table.
	 * @return capacity
	 */
	public int capacity()
	{
		return this.capacity;
	}

	/**
	 * Returns the number of entries in the hash table (i.e., the number of stored key-value pairs).
	 * @return size of this hash table
	 */
	public int size()
	{
		return num_of_entries;
	}


	/**
	 * Returns a list containing the statistics of the hash table
	 * 
	 * @return arrayList containing our statistics
	 */
	public ArrayList<Double> print_stats()
	{
		ArrayList<Double> stats = new ArrayList<Double>();

		stats.add(collisions);
		stats.add((double)num_of_entries);
		stats.add((double)capacity);
		this.toString();
		return stats;
	}

	/**
	 * Fill in calculations to show some of the stats about the hash table
	 */
	public String toString()
	{
		String result = new String();
		result = "------------ Hash Table Info ------------\n"
				+ "  Average collisions: " + collisions + "\n" + "  Average Hash Function Time: " + get_hash_time() + "\n"+ "  Average Insertion Time: " + get_insertion_time() + "\n"
				+ "  Average Find Time: " + get_find_time() + "\n"+ "  Percent filled : " + this.percentfilled() + "\n" + "  Size of Table  : "+ this.capacity +"\n" + "  Elements       : " + num_of_entries
+ "\n"				+ "-----------------------------------------\n";

		return result;

	}

	/**
	 * Computes the time for this hash table to find a key
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
	 * Computes the time for this hash table to insert a Pair
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
	 * Computes the time for this hash table to hash a key
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
	 * Computes the percentage of this hash table being filled
	 * with Pairs
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
	 * Resets the hash table stats.
	 *
	 */
	public void reset_stats()
	{
		this.collisions = 0;
		this.num_of_entries = 0;
		this.insertionTime = 0;
		this.total_insertions = 0;
		find_time = 0;
		find_items = 0;
		hash_time = 0;
		num_hash = 0;
	}

	/**
	 * Clear the hash table array and initializes all of the entries in the table to null.
	 */
	private void init_table()
	{
		//table.clear();
		table = new ArrayList<Pair<KeyType, ValueType>>(this.capacity);
		for(int objectsInside = 0; objectsInside < this.capacity; objectsInside++)
		{
			table.add(null);
		}

		this.num_of_entries = 0;
	}

	/**
	 * Enables or disables current flag to allow resizing
	 * 
	 * @param status -- flag for resizing
	 */
	public void set_resize_allowable( boolean status )
	{
		this.status = status;
	}

	/**
	 * Expand the hash table to the new size, IF the new_size is GREATER than the current size
	 * (if not, doesn't do anything)
	 * 
	 * NOTE: The new hash table should have buckets equal in number the next prime number
	 * greater than or equal to the given "new_size". All the data in the original hash
	 * table must be maintained in the recreated hash table.
	 * 
	 * Note: make sure if you change the size, you rebuild your statistics...
	 */
	public void resize( int new_size )
	{
		if(new_size > this.capacity)
		{
			this.capacity = next_prime(new_size);
			reset_stats();
			doubling_behavior(true);
		}
	}
	
	/**
	 * Our own toString method that just prints the contents of our table
	 * 
	 * @return table in a string form
	 */
	public String toStringHash()
	{
		return table.toString();

	}
}