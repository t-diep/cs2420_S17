/**
 * 
 */
package cards;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * Provides an immense collection of JUnit Tests
 * 
 * @author Tony Diep, Ashton Schmidt last updated 3-24-17
 */
public class CardTest 
{
	//All Club cards
	Card twoClubs;
	Card threeClubs;
	Card fourClubs;
	Card fiveClubs;
	Card sixClubs;
	Card sevenClubs;
	Card eightClubs;
	Card nineClubs;
	Card tenClubs;
	Card jackClubs;
	Card queenClubs;
	Card kingClubs;
	Card aceClubs;
	
	//All Diamond cards
	Card twoDiamonds;
	Card threeDiamonds;
	Card fourDiamonds;
	Card fiveDiamonds;
	Card sixDiamonds;
	Card sevenDiamonds;
	Card eightDiamonds;
	Card nineDiamonds;
	Card tenDiamonds;
	Card jackDiamonds;
	Card queenDiamonds;
	Card kingDiamonds;
	Card aceDiamonds;
	
	//All Heart cards
	Card twoHearts;
	Card threeHearts;
	Card fourHearts;
	Card fiveHearts;
	Card sixHearts;
	Card sevenHearts;
	Card eightHearts;
	Card nineHearts;
	Card tenHearts;
	Card jackHearts;
	Card queenHearts;
	Card kingHearts;
	Card aceHearts;
	
	//All Spades cards
	Card twoSpades;
	Card threeSpades;
	Card fourSpades;
	Card fiveSpades;
	Card sixSpades;
	Card sevenSpades;
	Card eightSpades;
	Card nineSpades;
	Card tenSpades;
	Card jackSpades;
	Card queenSpades;
	Card kingSpades;
	Card aceSpades;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception 
	{
		//Create all club cards
		twoClubs = new Card(0);
		threeClubs = new Card(1);
		fourClubs = new Card(2);
		fiveClubs = new Card(3);
		sixClubs = new Card(4);
		sevenClubs = new Card(5);
		eightClubs = new Card(6);
		nineClubs = new Card(7);
		tenClubs = new Card(8);
		jackClubs = new Card(9);
		queenClubs = new Card(10);
		kingClubs = new Card(11);
		aceClubs = new Card(12);
		
		//Create all diamond cards
		twoDiamonds = new Card(13);
		threeDiamonds = new Card(14);
		fourDiamonds = new Card(15);
		fiveDiamonds = new Card(16);
		sixDiamonds = new Card(17);
		sevenDiamonds = new Card(18);
		eightDiamonds = new Card(19);
		nineDiamonds = new Card(20);
		tenDiamonds = new Card(21);
		jackDiamonds = new Card(22);
		queenDiamonds = new Card(23);
		kingDiamonds = new Card(24);
		aceDiamonds = new Card(25);
		
		//Create all heart cards
		twoHearts = new Card(26);
		threeHearts = new Card(27);
		fourHearts = new Card(28);
		fiveHearts = new Card(29);
		sixHearts = new Card(30);
		sevenHearts = new Card(31);
		eightHearts = new Card(32);
		nineHearts = new Card(33);
		tenHearts = new Card(34);
		jackHearts = new Card(35);
		queenHearts = new Card(36);
		kingHearts = new Card(37);
		aceHearts = new Card(38);
		
		//Create all spade cards
		twoSpades = new Card(39);
		threeSpades = new Card(40);
		fourSpades = new Card(41);
		fiveSpades = new Card(42);
		sixSpades = new Card(43);
		sevenSpades = new Card(44);
		eightSpades = new Card(45);
		nineSpades = new Card(46);
		tenSpades = new Card(47);
		jackSpades = new Card(48);
		queenSpades = new Card(49);
		kingSpades = new Card(50);
		aceSpades = new Card(51);
	}
	
	// XXX Tests for the toString() method
	
	/**
	 * TEST 1
	 */
	@Test
	public void testTwoClubsToString() 
	{
		assertEquals("2 of clubs at position 0", twoClubs.toString());
	}
	
	/**
	 * TEST 2
	 */
	@Test
	public void testThreeClubsToString() 
	{
		assertEquals("3 of clubs at position 1", threeClubs.toString());
	}
	
	/**
	 * TEST 3
	 */
	@Test
	public void testFourClubsToString() 
	{
		assertEquals("4 of clubs at position 2", fourClubs.toString());
	}
	
	/**
	 * TEST 4
	 */
	@Test
	public void testFiveClubsToString() 
	{
		assertEquals("5 of clubs at position 3", fiveClubs.toString());
	}
	
	/**
	 * TEST 5
	 */
	@Test
	public void testSixClubsToString() 
	{
		assertEquals("6 of clubs at position 4", sixClubs.toString());
	}
	
	/**
	 * TEST 6
	 */
	@Test
	public void testSevenClubsToString() 
	{
		assertEquals("7 of clubs at position 5", sevenClubs.toString());
	}
	
	/**
	 * TEST 7
	 */
	@Test
	public void testEightClubsToString() 
	{
		assertEquals("8 of clubs at position 6", eightClubs.toString());
	}
	
	/**
	 * TEST 8
	 */
	@Test
	public void testNineClubsToString() 
	{
		assertEquals("9 of clubs at position 7", nineClubs.toString());
	}
	
	/**
	 * TEST 9
	 */
	@Test
	public void testTenClubsToString() 
	{
		assertEquals("10 of clubs at position 8", tenClubs.toString());
	}
	
	/**
	 * TEST 10
	 */
	@Test
	public void testJackClubsToString() 
	{
		assertEquals("jack of clubs at position 9", jackClubs.toString());
	}
	
	/**
	 * TEST 11
	 */
	@Test
	public void testQueenClubsToString() 
	{
		assertEquals("queen of clubs at position 10", queenClubs.toString());
	}
	
	/**
	 * TEST 12
	 */
	@Test
	public void testKingClubsToString() 
	{
		assertEquals("king of clubs at position 11", kingClubs.toString());
	}
	
	/**
	 * TEST 13
	 */
	@Test
	public void testAceClubsToString() 
	{
		assertEquals("ace of clubs at position 12", aceClubs.toString());
	}
	
	//Diamond cards
	
	/**
	 * TEST 1
	 */
	@Test
	public void testTwoDiamondsToString()
	{
		assertEquals("2 of diamonds at position 13", twoDiamonds.toString());
	}
	
	/**
	 * TEST 2
	 */
	@Test
	public void testThreeDiamondsToString()
	{
		assertEquals("3 of diamonds at position 14", threeDiamonds.toString());
	}
	
	/**
	 * TEST 3
	 */
	@Test
	public void testFourDiamondsToString()
	{
		assertEquals("4 of diamonds at position 15", fourDiamonds.toString());
	}
	
	/**
	 * TEST 4
	 */
	@Test
	public void testFiveDiamondsToString()
	{
		assertEquals("5 of diamonds at position 16", fiveDiamonds.toString());
	}
	
	/**
	 * TEST 5
	 */
	@Test
	public void testSixDiamondsToString()
	{
		assertEquals("6 of diamonds at position 17", sixDiamonds.toString());
	}
	
	/**
	 * TEST 6
	 */
	@Test
	public void testSevenDiamondsToString()
	{
		assertEquals("7 of diamonds at position 18", sevenDiamonds.toString());
	}
	
	/**
	 * TEST 7
	 */
	@Test
	public void testEightDiamondsToString()
	{
		assertEquals("8 of diamonds at position 19", eightDiamonds.toString());
	}
	
	/**
	 * TEST 8
	 */
	@Test
	public void testNineDiamondsToString()
	{
		assertEquals("9 of diamonds at position 20", nineDiamonds.toString());
	}
	
	/**
	 * TEST 9
	 */
	@Test
	public void testTenDiamondsToString()
	{
		assertEquals("10 of diamonds at position 21", tenDiamonds.toString());
	}
	
	/**
	 * TEST 10
	 */
	@Test
	public void testJackDiamondsToString()
	{
		assertEquals("jack of diamonds at position 22", jackDiamonds.toString());
	}
	
	/**
	 * TEST 11
	 */
	@Test
	public void testQueenDiamondsToString()
	{
		assertEquals("queen of diamonds at position 23", queenDiamonds.toString());
	}
	
	/**
	 * TEST 12
	 */
	@Test
	public void testKingDiamondsToString()
	{
		assertEquals("king of diamonds at position 24", kingDiamonds.toString());
	}
	
	/**
	 * TEST 13
	 */
	@Test
	public void testAceDiamondsToString()
	{
		assertEquals("ace of diamonds at position 25", aceDiamonds.toString());
	}
	
	//Heart cards
	
	/**
	 * TEST 1
	 */
	@Test
	public void testTwoHeartsToString()
	{
		assertEquals("2 of hearts at position 26", twoHearts.toString());
	}
	
	/**
	 * TEST 2
	 */
	@Test
	public void testThreeHeartsToString()
	{
		assertEquals("3 of hearts at position 27", threeHearts.toString());
	}
	
	/**
	 * TEST 3
	 */
	@Test
	public void testFourHeartsToString()
	{
		assertEquals("4 of hearts at position 28", fourHearts.toString());
	}
	
	/**
	 * TEST 4
	 */
	@Test
	public void testFiveHeartsToString()
	{
		assertEquals("5 of hearts at position 29", fiveHearts.toString());
	}
	
	/**
	 * TEST 5
	 */
	@Test
	public void testSixHeartsToString()
	{
		assertEquals("6 of hearts at position 30", sixHearts.toString());
	}
	
	/**
	 * TEST 6
	 */
	@Test
	public void testSevenHeartsToString()
	{
		assertEquals("7 of hearts at position 31", sevenHearts.toString());
	}
	
	/**
	 * TEST 7
	 */
	@Test
	public void testEightHeartsToString()
	{
		assertEquals("8 of hearts at position 32", eightHearts.toString());
	}
	
	/**
	 * TEST 8
	 */
	@Test
	public void testNineHeartsToString()
	{
		assertEquals("9 of hearts at position 33", nineHearts.toString());
	}
	
	/**
	 * TEST 9
	 */
	@Test
	public void testTenHeartsToString()
	{
		assertEquals("10 of hearts at position 34", tenHearts.toString());
	}
	
	/**
	 * TEST 10
	 */
	@Test
	public void testJackHeartsToString()
	{
		assertEquals("jack of hearts at position 35", jackHearts.toString());
	}
	
	/**
	 * TEST 11
	 */
	@Test
	public void testQueenHeartsToString()
	{
		assertEquals("queen of hearts at position 36", queenHearts.toString());
	}
	
	/**
	 * TEST 12
	 */
	@Test
	public void testKingHeartsToString()
	{
		assertEquals("king of hearts at position 37", kingHearts.toString());
	}
	
	/**
	 * TEST 13
	 */
	@Test
	public void testAceHeartsToString()
	{
		assertEquals("ace of hearts at position 38", aceHearts.toString());
	}
	
	//Spade cards
	
	/**
	 * TEST 1
	 */
	@Test
	public void testTwoSpadesToString()
	{
		assertEquals("2 of spades at position 39", twoSpades.toString());
	}
	
	/**
	 * TEST 2
	 */
	@Test
	public void testThreeSpadesToString()
	{
		assertEquals("3 of spades at position 40", threeSpades.toString());
	}
	
	/**
	 * TEST 3
	 */
	@Test
	public void testFourSpadesToString()
	{
		assertEquals("4 of spades at position 41", fourSpades.toString());
	}
	
	/**
	 * TEST 4
	 */
	@Test
	public void testFiveSpadesToString()
	{
		assertEquals("5 of spades at position 42", fiveSpades.toString());
	}
	
	/**
	 * TEST 5
	 */
	@Test
	public void testSixSpadesToString()
	{
		assertEquals("6 of spades at position 43", sixSpades.toString());
	}
	
	/**
	 * TEST 6
	 */
	@Test
	public void testSevenSpadesToString()
	{
		assertEquals("7 of spades at position 44", sevenSpades.toString());
	}
	
	/**
	 * TEST 7
	 */
	@Test
	public void testEightSpadesToString()
	{
		assertEquals("8 of spades at position 45", eightSpades.toString());
	}
	
	/**
	 * TEST 8
	 */
	@Test
	public void testNineSpadesToString()
	{
		assertEquals("9 of spades at position 46", nineSpades.toString());
	}
	
	/**
	 * TEST 9
	 */
	@Test
	public void testTenSpadesToString()
	{
		assertEquals("10 of spades at position 47", tenSpades.toString());
	}
	
	/**
	 * TEST 10
	 */
	@Test
	public void testJackSpadesToString()
	{
		assertEquals("jack of spades at position 48", jackSpades.toString());
	}
	
	/**
	 * TEST 11
	 */
	@Test
	public void testQueenSpadesToString()
	{
		assertEquals("queen of spades at position 49", queenSpades.toString());
	}
	
	/**
	 * TEST 12
	 */
	@Test
	public void testKingSpadesToString()
	{
		assertEquals("king of spades at position 50", kingSpades.toString());
	}
	
	/**
	 * TEST 13
	 */
	@Test
	public void testAceSpadesToString()
	{
		assertEquals("ace of spades at position 51", aceSpades.toString());
	}
	
	
	// XXX Tests for the equals method
	
	/**
	 * TEST 1
	 */
	@Test
	public void testACardEqualToItself()
	{
		assertTrue(aceSpades.equals(aceSpades));
	}
	
	/**
	 * TEST 2
	 */
	@Test
	public void testSameSuitDifferentValueCards()
	{
		assertFalse(twoSpades.equals(twoClubs));
	}
	
	/**
	 * TEST 3
	 */
	@Test
	public void testSameSuitSameValueCards()
	{
		assertTrue(twoClubs.equals(new Card(0)));
	}
	
	// XXX Tests for the compareTo method
	
	/**
	 * TEST 1
	 */
	@Test
	public void testCompareToTwoCardsWithSameSuitsAndValues()
	{
		assertEquals(0, aceSpades.compareTo(new Card(51)));
	}
	
	/**
	 * TEST 2
	 */
	@Test
	public void testCompareToTwoCardsWithSameSuitButDifferentValues()
	{
		assertEquals(1, nineClubs.compareTo(eightClubs));
	}
	
	/**
	 * TEST 3
	 */
	@Test
	public void testCompareToTwoCardsWithDifferentSuitsAndSameValues()
	{
		assertEquals(-1, tenClubs.compareTo(tenDiamonds));
	}
	
	// XXX Tests for cards that have invalid deck positions
	
	/**
	 * TEST 1
	 */
	@Test(expected = IndexOutOfBoundsException.class)
	public void testCardWithNegativeIndex()
	{
		new Card(-1);
	}
	
	/**
	 * TEST 2
	 */
	@Test(expected = IndexOutOfBoundsException.class)
	public void testCardWithIndexGreaterThan51()
	{
		new Card(52);
	}
}
