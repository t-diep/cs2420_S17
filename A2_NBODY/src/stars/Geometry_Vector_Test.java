/**
 *@author Anthony Diep
 *@uid u0934661
 *@date 26 January 2017
 *@classnumber (2420)
 *@assignmentnumber 2
 *@partner Ed Stephen Ancajas
 *	I pledge that the work done here was my own and that I have learned how to write this program, 
 *	such that I could throw it out and restart and finish it in a timely manner. I am not turning 
 *	in any work that I cannot understand, describe, or recreate. I further acknowledge that I contributed 
 *	substantially to all code handed in and vouch for it's authenticity. (Anthony Diep)
 */
package stars;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * The tester class for Geometry_Vectors
 * 
 * @author Tony Diep, last updated 1-26-17
 */
public class Geometry_Vector_Test 
{
	//Represents a general positive vector
	Geometry_Vector vector;
	//Represents a zero vector
	Geometry_Vector zeroVector;
	//Represents a negative vector
	Geometry_Vector negativeVector;
	//Represents a trigonometric vector
	Geometry_Vector trigVector;
	//Represents a big vector
	Geometry_Vector bigVector;
	
	Geometry_Vector positiveVector1;
	Geometry_Vector positiveVector1A;
	Geometry_Vector positiveVector2;
	Geometry_Vector positiveVector2A;
	Geometry_Vector positiveNegativeVector3;
	Geometry_Vector positiveNegativeVector3A;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception 
	{
		
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception 
	{
		
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception 
	{
		vector = new Geometry_Vector(4, 3);
		zeroVector = new Geometry_Vector(0,0);
		negativeVector = new Geometry_Vector(-10, -10);
		trigVector = new Geometry_Vector(Math.cos(Math.PI), Math.sin(Math.PI / 2));
		bigVector = new Geometry_Vector(5465.23, 1908.57);
		
		
		positiveVector1= new Geometry_Vector(50, 100);
		positiveVector1A = new Geometry_Vector(32, 25);
		
		positiveVector2= new Geometry_Vector(1078.347, 84372.3);
		positiveVector2A = new Geometry_Vector(1.23, 98.32);
		
		positiveNegativeVector3= new Geometry_Vector(21, -21);
		positiveNegativeVector3A = new Geometry_Vector(-21, 21);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception 
	{
	
	}
	
	//Tests for the first and second constructors
	
	
	/**
	 * Test 1: Tests for the first and second constructors for the zero vector
	 */
	@Test
	public void testFirstAndSecondConstructorsZeroVector()
	{
		//First constructor
		assertEquals(new Geometry_Vector(0,0), zeroVector);
		//Second constructor
		assertEquals(new Geometry_Vector(0,0), new Geometry_Vector(zeroVector));
	}
	
	/**
	 * Test 2: Tests for the first and second constructors for the negative vector
	 */
	@Test
	public void testFirstConstructorandSecondConstructorsNegativeVector()
	{
		//First constructor
		assertEquals(new Geometry_Vector(-10,-10), negativeVector);
		//Second constructor
		assertEquals(new Geometry_Vector(-10,-10), new Geometry_Vector(negativeVector));
	}
	
	/**
	 * Test 3: Tests for the first and second constructors for the trigonometric vector
	 */
	@Test
	public void testFirstConstructorandSecondConstructorsTrigVector()
	{
		//First constructor
		assertEquals(new Geometry_Vector(-1,1), trigVector);
		//Second constructor
		assertEquals(new Geometry_Vector(-1,1), new Geometry_Vector(trigVector));
	}
	
	/**
	 * Test 4: Tests for the first and second constructors for the big vector
	 */
	@Test
	public void testFirstConstructorandSecondConstructorsBigVector()
	{
		//First constructor
		assertEquals(new Geometry_Vector(5465.23, 1908.57), bigVector);
		//Second constructor
		assertEquals(new Geometry_Vector(5465.23, 1908.57), new Geometry_Vector(bigVector));
	}
	
	
	//Tests for the add_to_me method
	
	
	/**
	 * Test 1: Add two vectors with positive components
	 */
	@Test
	public void testAddPositiveComponents() 
	{
		positiveVector1.add_to_me(positiveVector1A);
		assertEquals(new Geometry_Vector(82, 125), positiveVector1);
	}
	
	/**
	 * Test 2: Add two vectors with decimal components
	 */
	@Test
	public void testAddDecimalComponents() 
	{
		positiveVector2.add_to_me(positiveVector2A);
		assertEquals(new Geometry_Vector(1079.577, 84470.62000000001), positiveVector2);
	}
	
	/**
	 * Test 3: Add two zero vectors
	 */
	@Test
	public void testAddForZeroComponent() 
	{
		positiveNegativeVector3.add_to_me(positiveNegativeVector3A);
		assertEquals(zeroVector, positiveNegativeVector3);
	}
	
	//Tests for the subtract_from_me method
	
	
	/**
	 * Test 1: Subtract two vectors with positive components
	 */
	@Test
	public void testSubtractPositiveComponents() 
	{
		positiveVector1.add_to_me(positiveVector1A);
		assertEquals(new Geometry_Vector(82, 125), positiveVector1);
	}
	
	/**
	 * Test 2: Subtract two vectors with decimal components
	 */
	@Test
	public void testSubtractDecimalComponents() 
	{
		positiveVector2.subtract_from_me(positiveVector2A);
		assertEquals(new Geometry_Vector(1077.117, 84273.98), positiveVector2);
	}
	
	/**
	 * Test 3: Subtract two zero vectors
	 */
	@Test
	public void testSubtractForZeroComponent() 
	{
		zeroVector.subtract_from_me(zeroVector);
		assertEquals(new Geometry_Vector(0,0), zeroVector);
	}
	
	//Tests for the multiply_me_by method
	
	
	/**
	 * Test 1: Multiply a positive vector by 0
	 */
	@Test
	public void testPositiveVectorMultipliedBy0() 
	{
		positiveVector1.multiply_me_by(0);
		assertEquals(zeroVector, positiveVector1);
	}
	
	/**
	 * Test 2: Multiply a positive vector by a negative scalar
	 */
	@Test
	public void testPositiveVectorMultipliedByNegative() 
	{		
		positiveVector2.multiply_me_by(-1.344831);
		assertEquals(new Geometry_Vector(-1450.194, -113466.484).x, positiveVector2.x, .001);
		assertEquals(new Geometry_Vector(-1450.194, -113466.484).y, positiveVector2.y, .001);
	}
	
	/**
	 * Test 3: Multiply a trigonometric vector by a trigonometric scalar
	 */
	@Test
	public void testTrigVectorMultipliedByTrigValue() 
	{
		trigVector.multiply_me_by(3 * Math.PI / 8);
		assertEquals(new Geometry_Vector(1078.347, 84372.3).x, positiveVector2.x, .001);
		assertEquals(new Geometry_Vector(1078.347, 84372.3).y, positiveVector2.y, .001);
	}
	
	
	/**
	 * Test 2: Test for dividing each component by a decimal
	 */
	@Test
	public void testDivideVectorByDecimalScalar()
	{
		vector.divide_by(-45.34848);
		assertEquals(-0.08820582, vector.x, .001);
		assertEquals(-0.06615437, vector.y, .001);
	}
	
	/**
	 * Test 3: Test for dividing each component by a huge integer
	 */
	@Test 
	public void testDivideVectorByHugeInteger()
	{
		vector.divide_by(854092808);
		assertEquals(4.683331790799953E-9, vector.x, .000000000000001);
		assertEquals(3.5124988430999642E-9, vector.y, .000000000000001);
	}
	
	
	//Tests for the magnitude method
	
	
	/**
	 * Test 1: Positive vector magnitude
	 */
	@Test
	public void testPositiveVector()  
	{
		assertEquals(5.0, vector.magnitude(), .001);
	}
	
	/**
	 * Test 2: Zero magnitude
	 */
	@Test
	public void testMagnitudeZeroVector()
	{
		assertEquals(0, zeroVector.magnitude(), .001);
	}
	
	/**
	 * Test 3: Magnitude of negative vector
	 */
	@Test
	public void testMagnitudeNegativeVector()
	{
		assertEquals(14.142, negativeVector.magnitude(), .001);
	}
	
	/**
	 * Test 4: Magnitude of a trigonometric vector
	 */
	@Test
	public void testMagnitudeTrigVector()
	{
		assertEquals(Math.sqrt(2), trigVector.magnitude(), .001);
	}
	
	/**
	 * Test 5: Magnitude of a big vector
	 */
	@Test
	public void testMagnitudeBigVector()
	{	
		assertEquals(5788.901311803475, bigVector.magnitude(), .001);
	}
	
	//Tests for the normalize method
	
	/**
	 * Test 2: Test for normalizing a vector with positive components
	 */
	@Test
	public void testNormalizePositiveVector()
	{
		vector.normalize();
		assertEquals((double) 4/5, vector.x, .001);
		assertEquals((double) 3/5, vector.y, .001);
	}
	
	/**
	 * Test 3: Test for normalizing a vector with negative components
	 */
	@Test
	public void testNormalizeNegativeVector()
	{
		negativeVector.normalize();
		assertEquals(-0.7071067811865475, negativeVector.x, .001);
		assertEquals(-0.7071067811865475, negativeVector.y, .001);
	}
	
	/**
	 * Test 4: Test for normalizing a trigonometric vector
	 */
	@Test
	public void testNormalizeTrigonometricVector()
	{
		trigVector.normalize();
		assertEquals(-1/Math.sqrt(2), trigVector.x, .001);
		assertEquals(1/Math.sqrt(2), trigVector.y, .001);
	}

	
	/**
	 * Test 5: Test for normalizing a big vector
	 */
	@Test
	public void testNormalizeBigVector()
	{
		bigVector.normalize();
		
		assertEquals(0.9440876093113705, bigVector.x, .001);
		assertEquals(0.32969468595162554, bigVector.y, .001);
	}
	
	//Tests for the toString method
	
	
	/**
	 * Test 1: Test for printing a string with positive x and y 
	 */
	@Test
	public void testVectorString()
	{
		assertEquals("<4.0, 3.0>", vector.toString());
	}
	
	/**
	 * Test 2: Test for printing a string of a zero vector
	 */
	@Test
	public void testZeroVectorString()
	{
		assertEquals("<0.0, 0.0>", zeroVector.toString());
	}
	
	/**
	 * Test 3: Test for printing a string of a vector with either a negative x or y coordinate
	 */
	@Test
	public void testNegativeVectorString()
	{
		assertEquals("<-10.0, -10.0>", negativeVector.toString());
	}
	
	/**
	 * Test 4: Test for printing a string of a vector containing trigonometric values
	 */
	@Test
	public void testTrigVectorString()
	{
		assertEquals("<-1.0, 1.0>", trigVector.toString());
	}
	
	/**
	 * Test 5: Print a vector with long decimal components
	 */
	@Test
	public void testLongDecimalVectorString()
	{
		vector.divide_by(854092808);
		
		assertEquals("<4.683331790799953E-9, 3.5124988430999642E-9>", vector.toString());
	}
	
}
