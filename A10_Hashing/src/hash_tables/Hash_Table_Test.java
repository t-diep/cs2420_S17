package hash_tables;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import cracking.My_String;

/**
 * Provides a list of JUnit Tests for our Hash Tables
 * 
 * @author Tony Diep, Jocee Porter, last updated 4-7-17
 *
 * @param <KeyType>
 * @param <ValueType>
 */
public class Hash_Table_Test<KeyType, ValueType>  
{
	Hash_Table_Linear_Probing<Integer, Integer> threeNumbers;
	Hash_Chaining<Integer, Integer> size5;
	Hash_Table_Quadratic_Probing<Integer, Integer> quad;
	ArrayList<Pair<Integer, Integer>>	resultTable;
	
	@Before
	public void testBefore()
	{
		threeNumbers = new Hash_Table_Linear_Probing<>(3);
		threeNumbers.insert(1, 1);
		threeNumbers.insert(2, 2);
		threeNumbers.insert(3, 3);
		
		resultTable = new ArrayList<Pair<Integer, Integer>>();
		for(int i =0; i< 5; i++)
		{
			resultTable.add(null);
		}
		
		quad = new Hash_Table_Quadratic_Probing<Integer, Integer>(10);
		
		My_String key_string = new My_String(1 + "");
		int location = (key_string.hashCode()%threeNumbers.capacity);
		Pair<Integer, Integer> one = new Pair<>(1, 1);
		
		My_String key_string1 = new My_String(2 + "");
		int location1 = (key_string1.hashCode()%threeNumbers.capacity);
		Pair<Integer, Integer> two = new Pair<>(2,2);
		
		My_String key_string2 = new My_String(3 + "");
		int location2 = (key_string2.hashCode()%threeNumbers.capacity);
		Pair<Integer, Integer> three = new Pair<>(3,3);
		
		
		resultTable.set(location, one);
		resultTable.set(location1, two);
		resultTable.set(location2, three);
		
		size5 = new Hash_Chaining<Integer, Integer>(27);
		
		
		for(int i = 7; i<10; i++)
		{
			size5.insert(i, i);
		}
		
		quad.insert(1, 1);
		quad.insert(2, 2);
		quad.insert(3, 3);
	}

	@Test
	public void chainingTestNull()
	{
		System.out.println(size5.table.get(5).toString());
		assertEquals(null, size5.find(22));
	}
	
	@Test
	public void chainingFind3()
	{
		System.out.println(size5.hashToString());
		assertEquals((Integer)7, (Integer)size5.find(7));
	}
	
	
	@Test
	public void chainingTestCollisions()
	{
		System.out.println(quad.toStringHash());
		assertEquals(new Pair<>(1,1).toString(), quad.table.get(5).toString());
	}
	
	@Test
	public void chainingtestCollisionNumber()
	{
		assertEquals(3, (int)quad.collisions);
	}
	
	@Test
	public void chainingTestFindNull()
	{
		assertEquals(null, quad.find(4));
	}
	
	@Test
	public void QuadTestFind3()
	{
		assertEquals((Integer)3, (Integer)quad.find(3));
	}
	
	@Test
	public void doublingBehavior()
	{
		//quad size = 11 to start;
		//22 ->23 next_prime
		for(int i = 9; i< 13; i++)
		{
			quad.insert(i, i);
		}
		System.out.println(quad.toStringHash());
		assertEquals(23, quad.capacity);
	}
	
	@Test
	public void repeatingEntries()
	{
		quad.insert(1, 5);
		System.out.println(quad.toStringHash());
		assertEquals((Integer) 5, (Integer)quad.find(1));
	}

}
