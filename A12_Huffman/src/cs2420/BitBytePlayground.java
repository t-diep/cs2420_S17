package cs2420;

/**
 * This class helps us understand how bits and bytes work in Java
 * and how we can conceptually understand how to do bit shifting
 * 
 * @author Tony Diep, Alex Cervantes, last updated 4-25-17
 */
public class BitBytePlayground 
{
	public static void main(String[] args) 
	{
		byte[] theSameOne = {0 ,0 , 1, 8};
	
		byte[] bitOperations = Bit_Operations.convert_integer_to_bytes(264);
	
		for(byte b : bitOperations)
		{
			System.out.println(Integer.toBinaryString(b));
		}
		
		for(byte b : theSameOne)
		{
			System.out.println(Integer.toBinaryString(b));
		}
		
		System.out.println(Integer.toBinaryString((byte) (theSameOne[0]) << 32));
		System.out.println(Integer.toBinaryString((byte) (theSameOne[1]) << 16));
		System.out.println((theSameOne[2]) << 8);
		System.out.println(Integer.toBinaryString((byte) (theSameOne[3]) << 0));
		
		int first = theSameOne[0] << 32;
		int second = theSameOne[1] << 16;
		int third = theSameOne[2] << 8;
		int fourth = theSameOne[3];
		
		System.out.println(first | second | third | fourth);
		
		System.out.println(convertBytesBackToInteger(theSameOne[0], theSameOne[1], theSameOne[2], theSameOne[3]));
	}

	/**
	 * Converts one four byte piece from a ByteBuffer back to its decimal form
	 * 
	 * @param first -- first byte
	 * @param second -- second byte
	 * @param third -- third byte
	 * @param fourth -- fourth byte
	 * @return the sum of the four bytes resulting in a base 10 number (decimal form)
	 */
	public static int convertBytesBackToInteger(byte first, byte second, byte third, byte fourth)
	{
		return first << 32 | second << 16 | third << 8 | fourth;
	}
}
