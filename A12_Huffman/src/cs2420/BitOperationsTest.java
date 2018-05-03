package cs2420;

import static org.junit.Assert.*;

import java.util.BitSet;

import org.junit.Test;

/**
 * Provides a collection of JUnit tests for the BitOperations class
 * 
 * @author Tony Diep, Alex Cervantes, last updated 4-25-17
 */
public class BitOperationsTest 
{
	// Tests for the getBytes method

	/**
	 * TEST 1
	 */
	@Test
	public void bitStreamSingleByteTest() 
	{
		byte num128 = (byte) 0b1000_0000;

		BitSet input = BitSet.valueOf(new byte[] { num128 });
		byte[] output = Bit_Operations.get_bytes(input);

		assertArrayEquals(new byte[] { 0b0000_0001 }, output);
	}

	/**
	 * TEST 2
	 */
	@Test
	public void bitStreamMultipleBytesTest() 
	{
		byte[] bytes = new byte[] { (byte) 0b0101_1111, 0b0001_1000 };
		BitSet input = BitSet.valueOf(bytes);
		byte[] output = Bit_Operations.get_bytes(input);

		assertArrayEquals(new byte[] { (byte) 0b1111_1010, 0b0001_1000 }, output);
	}

	// Tests for the getBit method

	/**
	 * TEST 1
	 */
	@Test
	public void testGetBitFromBinaryNumber7AtPosition0() 
	{
		assertFalse(Bit_Operations.get_bit((byte) 000000_0111, 0));
	}

	/**
	 * TEST 2
	 */
	@Test
	public void testGetBitFromBinaryNumber7AtPosition1() 
	{
		assertTrue(Bit_Operations.get_bit((byte) 000000_0111, 1));
	}

	/**
	 * TEST 3
	 */
	@Test
	public void testGetBitFromBinaryNumber7AtPosition2() 
	{
		assertFalse(Bit_Operations.get_bit((byte) 000000_0111, 2));
	}

	/**
	 * TEST 4
	 */
	@Test
	public void testGetBitFromBinaryNumber7AtPosition3() 
	{
		assertFalse(Bit_Operations.get_bit((byte) 000000_0111, 3));
	}

	/**
	 * TEST 5
	 */
	@Test
	public void testGetBitFromBinaryNumber7AtPosition4() 
	{
		assertFalse(Bit_Operations.get_bit((byte) 0x000000_0111, 4));
	}

	/**
	 * TEST 6
	 */
	@Test
	public void testGetBitFromBinaryNumber7AtPosition5() 
	{
		assertFalse(Bit_Operations.get_bit((byte) 0x000000_0111, 5));
	}

	/**
	 * TEST 7
	 */
	@Test
	public void testGetBitFromBinaryNumber7AtPosition6()
	{
		assertFalse(Bit_Operations.get_bit((byte) 0x000000_0111, 6));
	}

	/**
	 * TEST 8
	 */
	@Test
	public void testGetBitFromBinaryNumber7AtPosition7() 
	{
		assertTrue(Bit_Operations.get_bit((byte) 0x000000_0111, 7));
	}
}
