/**
 * 
 */
package hash_tables;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Provides some supplementary JUnit tests for the Primes class
 * 
 * @author Tony Diep, last updated 4-1-17 
 */
public class PrimesTest 
{
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	//Tests for the is_prime() method
	
	/**
	 * TEST 1
	 */
	@Test
	public void testIsZeroPrime()
	{
		assertFalse(Primes.is_prime(0));
	}

	/**
	 * TEST 2
	 */
	@Test
	public void testIsOnePrime()
	{
		assertFalse(Primes.is_prime(1));
	}
	
	/**
	 * TEST 3
	 */
	@Test
	public void testIsTwoPrime()
	{
		assertTrue(Primes.is_prime(2));
	}
	
	/**
	 * TEST 4
	 */
	@Test
	public void testIsNinetyNinePrime()
	{
		assertFalse(Primes.is_prime(99));
	}
	
	/**
	 * TEST 5
	 */
	@Test
	public void testIsEightySevenPrime()
	{
		assertFalse(Primes.is_prime(87));
	}
	
	/**
	 * TEST 6
	 */
	@Test
	public void testIsThirtySevenPrime()
	{
		assertTrue(Primes.is_prime(37));
	}
	
	/**
	 * TEST 7
	 *
	 */
	public void testNegative2IsPrimeException()
	{
		assertTrue(Primes.is_prime(-2));
	}
	
	//Tests for the next_prime() method
	
	/**
	 * TEST 1
	 */
	@Test
	public void testNextPrimeStartValueAs1()
	{
		assertEquals(3, Primes.next_prime(2));
	}
	
	/**
	 * TEST 2
	 */
	@Test
	public void testNextPrimeStartValueAs3()
	{
		assertEquals(5, Primes.next_prime(3));
	}
	
	/**
	 * TEST 3
	 */
	@Test
	public void testNextPrimeStartValueAs0()
	{
		assertEquals(2, Primes.next_prime(0));
	}
	
	/**
	 * TEST 4
	 */
	@Test
	public void testNextPrimeStartValueAs100()
	{
		assertEquals(101, Primes.next_prime(100));
	}
}
