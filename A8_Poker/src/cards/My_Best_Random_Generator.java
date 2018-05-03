package cards;

/**
 * Represents our custom random number generator
 * 
 * @author Tony Diep, Ashton Schmidt, last updated 3-24-17
 */
public class My_Best_Random_Generator implements Random_Generator
{
	//Previous number
	private long prev;
	//Multiplier
	private long mult;
	//Incrementer
	private long increment;
	//Java mask value
	private static long mask = ( 1L << 48)-1;

	/**
	 * Retrieves the next integer
	 * 
	 * @param max -- upper bound
	 */
	@Override
	public int next_int(int max) 
	{
		prev = (mult * prev + increment) & mask;
		return(int) (prev % max);
	}

	/**
	 * Sets the seed of this random number generator to a new seed
	 * 
	 * @param seed -- new seed
	 */
	@Override
	public void set_seed(long seed) 
	{
		prev  = seed;
	}

	/**
	 * Sets the multiplier and incrementer to different values
	 * 
	 * @param mult -- new multiplier
	 * @param increment -- new incrementer
	 */
	@Override
	public void set_constants(long mult, long increment) 
	{
		this.mult = mult;
		this.increment = increment;
	}

}
