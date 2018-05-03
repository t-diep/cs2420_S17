package hash_tables;

/**
 * @author germain, Tony Diep, Jocee Porter, last updated 4-7-17
 *
 * some helper methods dealing with prime numbers.  These methods can be "brute force"
 */
public class Primes
{
	/**
	 * Verifies whether a number is prime (that is, a number that only contains 
	 * the factors of 1 and itself)
	 * 
	 * @param value
	 *            - to check if prime
	 * @return - return true if value is prime
	 */
	public static boolean is_prime( int value )
	{
		int absValue = Math.abs(value);
		
		if(absValue == 0 || absValue == 1) return false;
	    if(absValue % 2 == 0 && absValue > 2)	return false;
		
		for (int index = 3; index < absValue / 2; index++) 
	    {
	        if (absValue % index == 0) 
	        {
	            return false;
	        }
	    }
	    
	    return true;
	}

	/**
	 * Returns the next prime number given an initial value
	 * 
	 * next_prime
	 * 
	 * Note: static function
	 * 
	 * @param value
	 *            - the starting point to search for a prime
	 * @return - the value if prime, otherwise the next prime after value
	 */
	public static int next_prime( int value )
	{
		for(int nextPrime = value + 1; nextPrime < 2*nextPrime; nextPrime++)
		{
			if(is_prime(nextPrime))
			{
				return nextPrime;
			}
		}
		return value;
	}
}
