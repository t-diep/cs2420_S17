package hash_tables;

/**
 * Represents a hash table utilizing the quadratic probing mechanism
 * 
 * @author Tony Diep, last updated 4-7-17
 *
 * @param <KeyValue>
 * @param <TypeValue>
 */
public class Hash_Table_Quadratic_Probing<KeyValue, TypeValue> extends Hash_Table_Linear_Probing<KeyValue, TypeValue>
{
	/**
	 * Creates a hash table with quadratic probing
	 * 
	 * @param initial_capacity -- starting size for this hash table
	 */
	public Hash_Table_Quadratic_Probing(int initial_capacity) 
	{
		super(initial_capacity);
	}

	/**
	 * Computes the next hash code 
	 * 
	 * @param originalHash -- original hash code to use
	 * @param numExtraProbes -- number of extra probes
	 * @return next hash code
	 */
	public int nextHash(int originalHash, int numExtraProbes)
	{
		return (originalHash + numExtraProbes*numExtraProbes) % this.capacity;
	}
}
