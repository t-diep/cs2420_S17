/**
 * 
 */
package cards;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Provides a collection of JUnit Tests for the Hand class
 * 
 * @author Tony Diep, Ashton Schmidt, last updated 3-24-17
 */
public class HandTest 
{
	//The field to be used for comparing Strings
	String expected;
	
	//Create all club cards
	static final Card twoClubs = new Card(0);
	static final Card threeClubs = new Card(1);
	static final Card fourClubs = new Card(2);
	static final Card fiveClubs = new Card(3);
	static final Card sixClubs = new Card(4);
	static final Card sevenClubs = new Card(5);
	static final Card eightClubs = new Card(6);
	static final Card nineClubs = new Card(7);
	static final Card tenClubs = new Card(8);
	static final Card jackClubs = new Card(9);
	static final Card queenClubs = new Card(10);
	static final Card kingClubs = new Card(11);
	static final Card aceClubs = new Card(12);
	
	//Create all diamond cards
	static final Card twoDiamonds = new Card(13);
	static final Card threeDiamonds = new Card(14);
	static final Card fourDiamonds = new Card(15);
	static final Card fiveDiamonds = new Card(16);
	static final Card sixDiamonds = new Card(17);
	static final Card sevenDiamonds = new Card(18);
	static final Card eightDiamonds = new Card(19);
	static final Card nineDiamonds = new Card(20);
	static final Card tenDiamonds = new Card(21);
	static final Card jackDiamonds = new Card(22);
	static final Card queenDiamonds = new Card(23);
	static final Card kingDiamonds = new Card(24);
	static final Card aceDiamonds = new Card(25);
	
	//Create all heart cards
	static final Card twoHearts = new Card(26);
	static final Card threeHearts = new Card(27);
	static final Card fourHearts = new Card(28);
	static final Card fiveHearts = new Card(29);
	static final Card sixHearts = new Card(30);
	static final Card sevenHearts = new Card(31);
	static final Card eightHearts = new Card(32);
	static final Card nineHearts = new Card(33);
	static final Card tenHearts = new Card(34);
	static final Card jackHearts = new Card(35);
	static final Card queenHearts = new Card(36);
	static final Card kingHearts = new Card(37);
	static final Card aceHearts = new Card(38);
	
	//Create all spade cards
	static final Card twoSpades = new Card(39);
	static final Card threeSpades = new Card(40);
	static final Card fourSpades = new Card(41);
	static final Card fiveSpades = new Card(42);
	static final Card sixSpades = new Card(43);
	static final Card sevenSpades = new Card(44);
	static final Card eightSpades = new Card(45);
	static final Card nineSpades = new Card(46);
	static final Card tenSpades = new Card(47);
	static final Card jackSpades = new Card(48);
	static final Card queenSpades = new Card(49);
	static final Card kingSpades = new Card(50);
	static final Card aceSpades = new Card(51);
	
	//Declare different hands
	
	Hand royalFlush5CardsClubsUnsorted;
	Hand royalFlush5CardsClubsSorted;
	Hand royalFlush5CardsDiamondsUnsorted;
	Hand royalFlush5CardsDiamondsSorted;
	Hand royalFlush5CardsHeartsUnsorted;
	Hand royalFlush5CardsHeartsSorted;
	Hand royalFlush5CardsSpadesUnsorted;
	Hand royalFlush5CardsSpadesSorted;

	Hand royalFlush7CardsClubsUnsorted;
	Hand royalFlush7CardsClubsSorted;
	Hand royalFlush7CardsDiamondsUnsorted;
	Hand royalFlush7CardsDiamondsSorted;
	Hand royalFlush7CardsHeartsUnsorted;
	Hand royalFlush7CardsHeartsSorted;
	Hand royalFlush7CardsSpadesUnsorted;
	Hand royalFlush7CardsSpadesSorted;

	Hand straightFlush5CardsClubsUnsorted;
	Hand straightFlush5CardsClubsSorted;
	Hand straightFlush5CardsDiamondsUnsorted;
	Hand straightFlush5CardsDiamondsSorted;
	Hand straightFlush5CardsHeartsUnsorted;
	Hand straightFlush5CardsHeartsSorted;
	Hand straightFlush5CardsSpadesUnsorted;
	Hand straightFlush5CardsSpadesSorted;
	
	Hand straightFlush7CardsClubsUnsorted;
	Hand straightFlush7CardsClubsSorted;
	Hand straightFlush7CardsDiamondsUnsorted;
	Hand straightFlush7CardsDiamondsSorted;
	Hand straightFlush7CardsHeartsUnsorted;
	Hand straightFlush7CardsHeartsSorted;
	Hand straightFlush7CardsSpadesUnsorted;
	Hand straightFlush7CardsSpadesSorted;
	
	Hand fourOfAKind5CardsUnsorted;
	Hand fourOfAKind5CardsSorted;
	Hand fourOfAKind7CardsUnsorted;
	Hand fourOfAKind7Cards;
	
	Hand fullHouse5CardsUnsorted;
	Hand fullHouse5CardsSorted;
	Hand fullHouse7CardsUnsorted;
	Hand fullHouse7CardsSorted;
	
	Hand flush5Cards;
	Hand flush7Cards;
	
	Hand straight5CardsUnsorted;
	Hand straight5CardsSorted;
	Hand straight7CardsUnsorted;
	Hand straight7CardsSorted;

	Hand threeOfAKind5Cards;
	Hand threeOfAKind7Cards;
	
	Hand twoPair5Cards;
	Hand twoPair7Cards;
	
	Hand onePair5Cards;
	Hand onePair7Cards;
	
	Hand highCard5Cards;
	Hand highCard7Cards;
	
	Hand almostRoyalFlush5Cards;
	Hand almostRoyalFlush7Cards;
	Hand almostStraightFlush5Cards;
	Hand almostStraightFlush7Cards;
	
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
		//Create royal flush hands for 5 and 7 cards
		royalFlush5CardsClubsUnsorted = new Hand(kingClubs, jackClubs, tenClubs, aceClubs, queenClubs);
		royalFlush5CardsClubsSorted = new Hand(tenClubs, jackClubs, queenClubs, kingClubs, aceClubs);
		royalFlush5CardsDiamondsUnsorted = new Hand(queenDiamonds, aceDiamonds, kingDiamonds, jackDiamonds, tenDiamonds);
		royalFlush5CardsDiamondsSorted = new Hand(tenDiamonds, jackDiamonds, queenDiamonds, kingDiamonds, aceDiamonds);
		royalFlush5CardsHeartsUnsorted = new Hand(aceHearts, jackHearts, queenHearts, tenHearts, kingHearts);
		royalFlush5CardsHeartsSorted = new Hand(tenHearts, jackHearts, queenHearts, kingHearts, aceHearts);
		royalFlush5CardsSpadesUnsorted = new Hand(tenSpades, queenSpades, aceSpades, kingSpades, jackSpades);
		royalFlush5CardsSpadesSorted = new Hand(tenSpades, jackSpades, queenSpades, kingSpades, aceSpades);
		
		royalFlush7CardsClubsUnsorted = new Hand(kingClubs, tenClubs, aceClubs, jackClubs, nineClubs, queenClubs, eightClubs);
		royalFlush7CardsClubsSorted = new Hand(eightClubs, nineClubs, tenClubs, jackClubs, queenClubs, kingClubs, aceClubs);
		royalFlush7CardsDiamondsUnsorted = new Hand(jackDiamonds, eightDiamonds, kingDiamonds, tenDiamonds, nineDiamonds, queenDiamonds, aceDiamonds);
		royalFlush7CardsDiamondsSorted = new Hand(eightDiamonds, nineDiamonds, tenDiamonds, jackDiamonds, queenDiamonds, kingDiamonds, aceDiamonds);
		royalFlush7CardsHeartsUnsorted = new Hand(aceHearts, tenHearts, kingHearts, eightHearts, jackHearts, nineHearts, queenHearts);
		royalFlush7CardsHeartsSorted = new Hand(eightHearts, nineHearts, tenHearts, jackHearts, queenHearts, kingHearts, aceHearts);
		royalFlush7CardsSpadesUnsorted = new Hand(tenSpades, aceSpades, jackSpades, kingSpades, queenSpades, nineSpades, eightSpades);
		royalFlush7CardsSpadesSorted = new Hand(eightSpades, nineSpades, tenSpades, jackSpades, queenSpades, kingSpades, aceSpades);
		
		//Create straight flush hands for 5 and 7 cards
		straightFlush5CardsClubsUnsorted = new Hand(fiveClubs, threeClubs, twoClubs, sixClubs, fourClubs);
		straightFlush5CardsClubsSorted = new Hand(twoClubs, threeClubs, fourClubs, fiveClubs, sixClubs);
		straightFlush5CardsDiamondsUnsorted = new Hand(fiveDiamonds, threeDiamonds, twoDiamonds, sixDiamonds, fourDiamonds);
		straightFlush5CardsDiamondsSorted = new Hand(twoDiamonds, threeDiamonds, fourDiamonds, fiveDiamonds, sixDiamonds);
		straightFlush5CardsHeartsUnsorted = new Hand(twoHearts, sixHearts, threeHearts, fourHearts, fiveHearts);
		straightFlush5CardsHeartsSorted = new Hand(twoHearts, threeHearts, fourHearts, fiveHearts, sixHearts);
		straightFlush5CardsSpadesUnsorted = new Hand(fourSpades, twoSpades, fiveSpades, sixSpades, threeSpades);
		straightFlush5CardsSpadesSorted = new Hand(twoSpades, threeSpades, fourSpades, fiveSpades, sixSpades);
		
		straightFlush7CardsClubsUnsorted = new Hand(sixClubs, eightClubs, twoClubs, fiveClubs, sevenClubs, threeClubs, fourClubs);
		straightFlush7CardsClubsSorted = new Hand(twoClubs, threeClubs, fourClubs, fiveClubs, sixClubs, sevenClubs, eightClubs);
		straightFlush7CardsDiamondsUnsorted = new Hand(sixDiamonds, threeDiamonds, fourDiamonds, sevenDiamonds, fiveDiamonds, twoDiamonds, eightDiamonds);
		straightFlush7CardsDiamondsSorted = new Hand(twoDiamonds, threeDiamonds, fourDiamonds, fiveDiamonds, sixDiamonds, sevenDiamonds, eightDiamonds);
		straightFlush7CardsHeartsUnsorted = new Hand(eightHearts, twoHearts, fourHearts, sixHearts, threeHearts, sevenHearts, fiveHearts);
		straightFlush7CardsHeartsSorted = new Hand(twoHearts, threeHearts, fourHearts, fiveHearts, sixHearts, sevenHearts, eightHearts);
		straightFlush7CardsSpadesUnsorted = new Hand(threeSpades, twoSpades, sevenSpades, fiveSpades, sixSpades, fourSpades,eightSpades);
		straightFlush7CardsSpadesSorted = new Hand(twoSpades, threeSpades, fourSpades, fiveSpades, sixSpades, sevenSpades, eightSpades);
	
		fourOfAKind5CardsUnsorted = new Hand(sixDiamonds, fourClubs, sixSpades, sixClubs, sixHearts);
		fourOfAKind5CardsSorted = new Hand(nineClubs, nineDiamonds, nineHearts, nineSpades, tenHearts);
		fourOfAKind7CardsUnsorted = new Hand(sixDiamonds, fourClubs, sixClubs, kingDiamonds, sixHearts, sixSpades, aceClubs);
		fourOfAKind7Cards = new Hand(nineClubs, nineDiamonds, nineHearts, nineSpades, tenHearts, kingSpades, queenDiamonds);
	
		fullHouse5CardsUnsorted = new Hand(threeHearts, queenDiamonds, threeClubs, threeSpades, queenClubs);
		fullHouse5CardsSorted = new Hand(threeSpades, threeClubs, threeHearts, queenClubs, queenDiamonds);
		fullHouse7CardsUnsorted = new Hand(aceSpades, threeClubs, twoSpades, threeSpades, queenClubs, threeHearts, queenDiamonds);
		fullHouse7CardsSorted = new Hand(threeSpades, threeClubs, threeHearts, queenClubs, queenDiamonds, aceSpades, twoSpades);
	
		flush5Cards = new Hand(kingDiamonds, eightDiamonds, fiveDiamonds, jackDiamonds, fourDiamonds);
		flush7Cards = new Hand(kingDiamonds, eightDiamonds, fiveDiamonds, jackDiamonds, fourDiamonds, sevenDiamonds, queenDiamonds);
	
		straight5CardsUnsorted = new Hand(eightSpades, fiveDiamonds, sevenClubs, nineDiamonds, sixHearts);
		straight5CardsSorted = new Hand(fiveDiamonds, sixHearts, sevenClubs, eightSpades, nineDiamonds);
		straight7CardsUnsorted = new Hand(tenHearts, fiveDiamonds, sevenClubs, jackClubs, nineDiamonds, sixHearts, eightSpades);
		straight7CardsSorted = new Hand(fiveDiamonds, sixHearts, sevenClubs, eightSpades, nineDiamonds, tenHearts, jackClubs);
	
		threeOfAKind5Cards = new Hand(twoDiamonds, twoSpades, twoClubs, fiveSpades, sixClubs);
		threeOfAKind7Cards = new Hand(twoDiamonds, twoSpades, twoClubs, fiveSpades, sixClubs, jackHearts, queenDiamonds);
		
		twoPair5Cards = new Hand(nineSpades, nineHearts, jackClubs, jackDiamonds, fourSpades);
		twoPair7Cards = new Hand(nineSpades, nineHearts, jackClubs, jackDiamonds, fourSpades, fiveSpades, aceHearts);
		
		onePair5Cards = new Hand(aceClubs, aceHearts, sixDiamonds, nineClubs, threeDiamonds);
		onePair7Cards = new Hand(aceClubs, aceHearts, sixDiamonds, nineClubs, threeDiamonds, eightClubs, jackDiamonds);
		
		highCard5Cards = new Hand(fiveDiamonds, threeSpades, queenHearts, eightDiamonds, twoClubs);
		highCard7Cards = new Hand(fiveDiamonds, threeSpades, queenHearts, eightDiamonds, twoClubs, kingSpades, aceDiamonds);
		almostRoyalFlush5Cards = new Hand(tenSpades, jackSpades, queenSpades, kingSpades, aceHearts);
		almostRoyalFlush7Cards = new Hand(eightSpades, nineSpades, tenSpades, jackSpades, queenSpades, kingSpades, aceClubs);
		almostStraightFlush5Cards = new Hand(sixClubs, sevenClubs, eightClubs, nineClubs, tenHearts);
		almostStraightFlush7Cards = new Hand(threeHearts, fourHearts, fiveHearts, sixHearts, sevenHearts, eightHearts, nineClubs);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception 
	{
	}

	// XXX Tests for determining rank of a Poker hand

	//Royal flush tests	
	
	/**
	 * TEST 1
	 * 
	 * King of clubs, jack of clubs, ten of clubs, ace of clubs, queen of clubs
	 */
	@Test
	public void testRankRoyalFlush5CardsClubsUnsorted()
	{
		assertEquals(Rank.royalFlush, royalFlush5CardsClubsUnsorted.determineRank());
	}
	
	
	/**
	 * TEST 2
	 * 
	 * Ten of clubs, jack of clubs, queen of clubs, king of clubs, ace of clubs
	 */
	@Test
	public void testRankRoyalFlush5CardsClubsSorted()
	{
		assertEquals(Rank.royalFlush, royalFlush5CardsClubsSorted.determineRank());
	}	
	
	/**
	 * TEST 3
	 * 
	 * Queen of diamonds, ace of diamonds, king of diamonds, jack of diamonds, ten of diamonds
	 */
	@Test
	public void testRankRoyalFlush5CardsDiamondsUnsorted()
	{
		assertEquals(Rank.royalFlush, royalFlush5CardsDiamondsUnsorted.determineRank());
	}
	
	/**
	 * TEST 4
	 * 
	 * ten of diamonds, jack of diamonds, queen of diamonds, king of diamonds, ace of diamonds
	 */
	@Test
	public void testRankRoyalFlush5CardsDiamondsSorted()
	{
		assertEquals(Rank.royalFlush, royalFlush5CardsDiamondsSorted.determineRank());
	}
	
	/**
	 * TEST 5
	 * 
	 * Ace of hearts, jack of hearts, queen of hearts, ten of hearts, king of hearts
	 */
	@Test
	public void testRankRoyalFlush5CardsHeartsUnsorted()
	{
		assertEquals(Rank.royalFlush, royalFlush5CardsHeartsUnsorted.determineRank());
	}
	
	/**
	 * TEST 6
	 * 
	 * Ten of spades, queen of spades, ace of spades, king of spades, jack of spades
	 */
	@Test
	public void testRankRoyalFlush5CardsSpadesUnsorted()
	{
		assertEquals(Rank.royalFlush, royalFlush5CardsSpadesUnsorted.determineRank());
	}
	
	/**
	 * TEST 7
	 * 
	 * Ten of hearts, jack of hearts, queen of hearts, king of hearts, ace of hearts
	 */
	@Test
	public void testRankRoyalFlush5CardsHearts()
	{
		assertEquals(Rank.royalFlush, royalFlush5CardsHeartsSorted.determineRank());
	}
	
	/**
	 * TEST 8 
	 * 
	 * Ten of spades, jack of spades, queen of spades, king of spades, ace of spades  
	 */
	@Test
	public void testRankRoyalFlush5CardsSpades() 
	{
		assertEquals(Rank.royalFlush, royalFlush5CardsSpadesSorted.determineRank());
	}
		
	/**
	 * TEST 9
	 * 
	 * King of clubs, ten of clubs, ace of clubs, jack of clubs, nine of clubs, 
	 * queen of clubs, eight of clubs
	 */
	@Test
	public void testRankFlush7CardsClubsUnsorted()
	{
		assertEquals(Rank.royalFlush, royalFlush7CardsClubsUnsorted.determineRank());
	}
	
	/**
	 * TEST 10
	 * 
	 * Eight of clubs, nine of clubs, ten of clubs, jack of clubs, queen of clubs, king of clubs, ace of clubs
	 */
	@Test
	public void testRankRoyalFlush7CardsClubsSorted()
	{
		assertEquals(Rank.royalFlush, royalFlush7CardsClubsSorted.determineRank());
	}
	
	/**
	 * TEST 11
	 * 
	 * Jack of diamonds, eight of diamonds, king of diamonds, ten of diamonds, nine of diamonds, 
	 * queen of diamonds, ace of diamonds
	 */
	@Test
	public void testRankRoyalFlush7CardsDiamondsUnsorted()
	{
		assertEquals(Rank.royalFlush, royalFlush7CardsDiamondsUnsorted.determineRank());
	}
	
	/**
	 * TEST 12
	 * 
	 * eight of diamonds, nine of diamonds, ten of diamonds, jack of diamonds, queen of diamonds,
	 * king of diamonds, ace of diamonds
	 */
	@Test
	public void testRankRoyalFlush7CardsDiamondsSorted()
	{
		assertEquals(Rank.royalFlush, royalFlush7CardsDiamondsSorted.determineRank());
	}
	
	/**
	 * TEST 13
	 * Ace of hearts, ten of hearts, king of hearts, eight of hearts, jack of hearts, nine of hearts, queen of hearts	
	 */
	@Test
	public void testRankRoyalFlush7CardsHeartsUnsorted()
	{
		assertEquals(Rank.royalFlush, royalFlush7CardsHeartsUnsorted.determineRank());
	}
	
	/**
	 * TEST 14
	 * 
	 * Eight of hearts, nine of hearts, ten of hearts, jack of hearts, queen of hearts, 
	 * king of hearts, ace of hearts
	 */
	@Test
	public void testRankRoyalFlush7CardsHeartsSorted()
	{
		assertEquals(Rank.royalFlush, royalFlush7CardsHeartsSorted.determineRank());
	}
	
	/**
	 * TEST 15
     *
	 * Ten of spades, ace of spades, jack of spades, king of spades, queen of spades, 
	 * nine of spades, eight of spades
	 */
	@Test
	public void testRankRoyalFlush7CardsSpadesUnsorted()
	{
		assertEquals(Rank.royalFlush, royalFlush7CardsSpadesUnsorted.determineRank());
	}
	
	/**
	 * TEST 16
	 * 
	 * Eight of spades, nine of spades, ten of spades, jack of spades, queen of spades, 
	 * king of spades, ace of spades 
	 */
	@Test
	public void testRankRoyalFlush7CardsSpades()
	{
		assertEquals(Rank.royalFlush, royalFlush7CardsSpadesSorted.determineRank());
	}
	
	
	//Straight flush tests
	
	/**
	 * TEST 1
	 * 
	 * Five of clubs, three of clubs, two of clubs, six of clubs, four of clubs
	 */
	@Test
	public void testRankStraightFlush5CardsClubsUnsorted()
	{
		assertEquals(Rank.straightFlush, straightFlush5CardsClubsUnsorted.determineRank());
	}
	
	/**
	 * TEST 2
	 * 
	 * Two of clubs, three of clubs, four of clubs, five of clubs, six of clubs
	 */
	@Test
	public void testRankStraightFlush5CardsClubsSorted()
	{
		assertEquals(Rank.straightFlush, straightFlush5CardsClubsSorted.determineRank());
	}

	/**
	 * TEST 3
	 * 
	 * Five of diamonds, three of diamonds, two of diamonds, six of diamonds, four of diamonds
	 */
	@Test
	public void testRankStraightFlush5CardsDiamondsUnsorted()
	{
		assertEquals(Rank.straightFlush, straightFlush5CardsDiamondsUnsorted.determineRank());
	}
		
	/**
	 * TEST 4
	 * 
	 * Two of clubs, three of clubs, four of clubs, five of clubs, six of clubs, seven of clubs, eight of clubs
	 */
	@Test
	public void testRankStraightFlush5CardsDiamondsSorted()
	{
		assertEquals(Rank.straightFlush, straightFlush5CardsDiamondsSorted.determineRank());
	}

	/**
	 * TEST 5
	 *
	 * Two of hearts, six of hearts, three of hearts, four of hearts, five of hearts
	 */
	@Test
	public void testRankStraightFlush5CardsHeartsUnsorted()
	{
		assertEquals(Rank.straightFlush, straightFlush5CardsHeartsUnsorted.determineRank());
	}
	
	/**
	 * TEST 6
	 * 
	 * Two of hearts, three of hearts, four of hearts, five of hearts, six of hearts
	 */
	@Test
	public void testRankStraightFlush5CardsHeartsSorted()
	{
		assertEquals(Rank.straightFlush, straightFlush5CardsHeartsSorted.determineRank());
	}

	/**
	 * TEST 7
	 * 
	 * Four of spades, two of spades, five of spades, six of spades, three of spades
	 */
	@Test
	public void testRankStraightFlush5CardsSpadesUnsorted()
	{
		assertEquals(Rank.straightFlush, straightFlush5CardsSpadesUnsorted.determineRank());
	}
	
	/**
	 * TEST 8
	 * 
	 * Two of spades, three of spades, four of spades, five of spades, six of spades
	 */
	@Test
	public void testRankStraightFlush5CardsSpadesSorted()
	{
		assertEquals(Rank.straightFlush, straightFlush5CardsSpadesSorted.determineRank());
	}
	
	/**
	 * TEST 9
	 * 
	 * Six of clubs, eight of clubs, two of clubs, five of clubs, seven of clubs, three of clubs,
	 * four of clubs
	 */
	@Test
	public void testRankStraightFlush7CardsClubsUnsorted()
	{
		assertEquals(Rank.straightFlush, straightFlush7CardsClubsUnsorted.determineRank());
	}
	
	/**
	 * TEST 10
	 * 
	 * Two of clubs, three of clubs, four of clubs, five of clubs, six of clubs, 
	 * seven of clubs, eight of clubs
	 */
	@Test
	public void testRankStraightFlush7CardsClubsSorted()
	{
		assertEquals(Rank.straightFlush, straightFlush7CardsClubsSorted.determineRank());
	}
	
	/**
	 * TEST 11
	 * 
	 * Six of diamonds, three of diamonds, four of diamonds, seven of diamonds, five of diamonds,
	 * two of diamonds, eight of diamonds
	 */
	@Test
	public void testRankStraightFlush7CardsDiamondsUnsorted()
	{
		assertEquals(Rank.straightFlush, straightFlush7CardsDiamondsUnsorted.determineRank());
	}
	
	/**
	 * TEST 12
	 * 
	 * Two of diamonds, three of diamonds, four of diamonds, five of diamonds, 
	 * six of diamonds, seven of diamonds, eight of diamonds
	 */
	@Test
	public void testRankStraightFlush7CardsDiamondsSorted()
	{
		assertEquals(Rank.straightFlush, straightFlush7CardsDiamondsSorted.determineRank());
	}
	
	/**
	 * TEST 13
	 * 
	 * Eight of hearts, two of hearts, four of hearts, six of hearts, three of hearts, 
	 * seven of hearts, five of hearts
	 */
	@Test
	public void testRankStraightFlush7CardsHeartsUnsorted()
	{
		assertEquals(Rank.straightFlush, straightFlush7CardsHeartsUnsorted.determineRank());
	}
	
	/**
	 * TEST 14
	 * 
	 * Two of hearts, three of hearts, four of hearts, five of hearts, six of hearts,
	 * seven of hearts, eight of hearts
	 */
	@Test
	public void testRankStraightFlush7CardsHeartsSorted()
	{
		assertEquals(Rank.straightFlush, straightFlush7CardsHeartsSorted.determineRank());
	}
	
	/**
	 * TEST 15
	 * 
	 * Three of spades, two of spades, seven of spades, five of spades, six of spades,
	 * four of spades, eight of spades
	 */
	@Test
	public void testRankStraightFlush7CardsSpadesUnsorted()
	{
		assertEquals(Rank.straightFlush, straightFlush7CardsSpadesUnsorted.determineRank());
	}
	
	/**
	 * TEST 16
	 * 
	 * Two of spades, three of spades, four of spades, five of spades, six of spades,
	 * seven of spades, eight of spades
	 */
	@Test
	public void testRankStraightFlush7CardsSpadesSorted()
	{
		assertEquals(Rank.straightFlush, straightFlush7CardsSpadesSorted.determineRank());
	}
	
	//Four of a kind tests
	
	/**
	 * TEST 1
	 * 
	 * Six of diamonds, four of clubs, six of spades, six of clubs, six of hearts
	 */
	@Test
	public void testRankFourOfAKind5CardsUnsorted()
	{
		assertEquals(Rank.fourOfAKind, fourOfAKind5CardsUnsorted.determineRank());
	}
	
	/**
	 * TEST 2
	 * 
	 * Nine of clubs, nine of diamonds, nine of hearts, nine of spades, ten of hearts
	 */
	@Test
	public void testRankFourOfAKind5CardsSorted()
	{
		assertEquals(Rank.fourOfAKind, fourOfAKind5CardsSorted.determineRank());
	}
	
	/**
	 * TEST 3
	 * 
	 * Six of diamonds, four of clubs, six of clubs, king of diamonds, six of hearts, 
	 * six of spades, ace of clubs
	 */
	@Test
	public void testRankFourOfAKind7CardsUnsorted()
	{
		assertEquals(Rank.fourOfAKind, fourOfAKind7CardsUnsorted.determineRank());
	}
	
	/**
	 * TEST 4
	 * 
	 * Nine of clubs, nine of diamonds, nine of hearts, nine of spades, ten of hearts,
	 * king of spades, queen of diamonds
	 */
	@Test
	public void testRankFourOfAKind7CardsSorted()
	{
		assertEquals(Rank.fourOfAKind, fourOfAKind7Cards.determineRank());
	}
	
	//Full house tests

	/**
	 * TEST 1
	 * 
	 * Three of hearts, queen of diamonds, three of clubs, three of spades, queen of clubs
	 */
	@Test
	public void testFullHouse5CardsUnsorted()
	{
		assertEquals(Rank.fullHouse, fullHouse5CardsUnsorted.determineRank());
	}
	
	/**
	 * TEST 2
	 * 
	 * Three of spades, three of clubs, three of hearts, queen of clubs, queen of diamonds
	 */
	@Test
	public void testFullHouse5CardsSorted()
	{
		assertEquals(Rank.fullHouse, fullHouse5CardsSorted.determineRank());
	}
	
	/**
	 * TEST 3
	 * 
	 * Ace of spades, three of clubs, two of spades, three of spades, queen of clubs, 
	 * three of hearts, queen of diamonds
	 */
	@Test
	public void testFullHouse7CardsUnsorted()
	{
		assertEquals(Rank.fullHouse, fullHouse7CardsUnsorted.determineRank());
	}
	
	/**
	 * TEST 4
	 *
	 * Three of spades, three of clubs, three of hearts, queen of clubs, queen of diamonds,
	 * ace of spades, two of spades
	 */
	@Test
	public void testFullHouse7CardsSorted()
	{
		assertEquals(Rank.fullHouse, fullHouse7CardsSorted.determineRank());
	}
	
	//Flush tests
	
	/**
	 * TEST 1
	 * 
	 * King of diamonds, eight of diamonds, five of diamonds, jack of diamonds, four of diamonds
	 */
	@Test
	public void testFlush5Cards()
	{		
		assertEquals(Rank.flush, flush5Cards.determineRank());
	}
	
	/**
	 * TEST 2
	 * 
	 * King of diamonds, eight of diamonds, five of diamonds, jack of diamonds, four of diamonds,
	 * seven of diamonds, queen of diamonds
	 */
	@Test
	public void testFlush7Cards()
	{
		assertEquals(Rank.flush, flush7Cards.determineRank());
	}
		
	
	//Straight tests

	/**
	 * TEST 1
	 * 
	 * Eight of spades, five of diamonds, seven of clubs, nine of diamonds, six of hearts
	 */
	@Test
	public void testStraight5CardsUnsorted()
	{
		assertEquals(Rank.straight, straight5CardsUnsorted.determineRank());
	}
	
	/**
	 * TEST 2
	 * 
	 * Five of diamonds, six of hearts, seven of clubs, eight of spades, nine of diamonds
	 */
	@Test
	public void testStraight5CardsSorted()
	{
		assertEquals(Rank.straight, straight5CardsSorted.determineRank());
	}
	
	/**
	 * TEST 3
	 * 
	 * Ten of hearts, five of diamonds, seven of clubs, jack of clubs, nine of diamonds,
	 * six of hearts, eight of spades
	 */
	@Test
	public void testStraight7CardsUnsorted()
	{
		assertEquals(Rank.straight, straight7CardsUnsorted.determineRank());
	}
	
	/**
	 * TEST 4
	 * 
	 * Five of diamonds, six of hearts, seven of clubs, eight of spades, nine of diamonds,
	 * ten of hearts, jack of clubs
	 */
	@Test
	public void testStraight7CardsSorted()
	{
		assertEquals(Rank.straight, straight7CardsSorted.determineRank());
	}
	
	/**
	 * TEST 5
	 * 
	 * tenSpades, jackSpades, queenSpades, kingSpades, aceHearts
	 */
	@Test
	public void testAlmostRoyalFlush5CardsButItIsAStraightInstead()
	{
		assertEquals(Rank.straight, almostRoyalFlush5Cards.determineRank());
	}
	
	/**
	 * TEST 6
	 * 
	 * Six of clubs, seven of clubs, eight of clubs, nine of clubs, ten of hearts
	 */
	@Test
	public void testAlmostStraightFlush5Cards()
	{
		assertEquals(Rank.straight, almostStraightFlush5Cards.determineRank());
	}
	
	/**
	 * TEST 7
	 * 
	 * Eight of spades, nine of spades, ten of spades, jack of spades, queen of spades, king of spades, 
	 * ace of hearts
	 */
	@Test
	public void testAlmostRoyalFlush7Cards()
	{
		assertEquals(Rank.straight, almostRoyalFlush7Cards.determineRank());
	}
	
	/**
	 * TEST 8
	 * 
	 * Three of hearts, four of hearts, five of hearts, six of hearts, seven of hearts,
	 * eight of hearts, nine of clubs
	 */
	@Test
	public void testAlmostStraightFlush7Cards()
	{
		assertEquals(Rank.straight, almostStraightFlush7Cards.determineRank());
	}
	
	//Three of a kind tests
	
	/**
	 * TEST 1
	 */
	@Test
	public void testThreeOfAKind5Cards()
	{
		assertEquals(Rank.threeOfAKind, threeOfAKind5Cards.determineRank());
	}
	
	/**
	 * TEST 2
	 */
	@Test
	public void testThreeOfAKind7Cards()
	{
		assertEquals(Rank.threeOfAKind, threeOfAKind7Cards.determineRank());
	}
	
	//Two pair tests
	
	/**
	 * TEST 1
	 */
	@Test
	public void testTwoPair5Cards()
	{
		assertEquals(Rank.twoPair, twoPair5Cards.determineRank());
	}

	/**
	 * TEST 2
	 */
	@Test
	public void testTwoPair7Cards()
	{
		assertEquals(Rank.twoPair, twoPair7Cards.determineRank());
	}
	
	//One pair tests	
	
	/**
	 * TEST 1
	 */
	@Test
	public void testOnePair5Cards()
	{
		assertEquals(Rank.onePair, onePair5Cards.determineRank());
	}
	
	/**
	 * TEST 2
	 */
	@Test
	public void testOnePair7Cards()
	{
		assertEquals(Rank.onePair, onePair7Cards.determineRank());
	}
	
	//High card tests
	
	/**
	 * TEST 1
	 */
	@Test
	public void testHighCard5Cards()
	{
		assertEquals(Rank.highCard, highCard5Cards.determineRank());
	}
	
	/**
	 * TEST 2
	 */
	@Test
	public void testHighCard7Cards()
	{
		assertEquals(Rank.highCard, highCard7Cards.determineRank());
	}

	// XXX Tests for the toString() method
	
	/**
	 * TEST 1
	 */
	@Test
	public void testRoyalFlush5CardsSpadesToString()
	{
		expected = "royalFlush : [10 of spades at position 47, jack of spades at position 48, queen of spades at position 49, king of spades at position 50, "
				+ "ace of spades at position 51]";
		
		assertEquals(expected, royalFlush5CardsSpadesSorted.toString());
	}
	
	/**
	 * TEST 2
	 */
	@Test
	public void testRoyalFlush7SpadesCardsToString()
	{
		expected = "royalFlush : [8 of spades at position 45, 9 of spades at position 46, 10 of spades at position 47, jack of spades at position 48, "
				+ "queen of spades at position 49, king of spades at position 50, ace of spades at position 51]";
		
		assertEquals(expected, royalFlush7CardsSpadesSorted.toString());
	}
	
	/**
	 * TEST 3
	 */
	@Test
	public void testStraightFlush5CardsHeartsToString()
	{
		expected = "straightFlush : [2 of hearts at position 26, 3 of hearts at position 27, 4 of hearts at position 28, " 
				+ "5 of hearts at position 29, 6 of hearts at position 30]";
	
		assertEquals(expected, straightFlush5CardsHeartsSorted.toString());
	}
	
	/**
	 * TEST 4
	 */
	@Test
	public void testStraightFlush7HeartsCardsToString()
	{
		expected = "straightFlush : [2 of hearts at position 26, 3 of hearts at position 27, 4 of hearts at position 28, " 
				+ "5 of hearts at position 29, 6 of hearts at position 30, 7 of hearts at position 31, "
				+ "8 of hearts at position 32]";
	
		assertEquals(expected, straightFlush7CardsHeartsSorted.toString());
	}

	/**
	 * TEST 5
	 */
	@Test
	public void testFourOfAKind5CardsToString()
	{
		expected = "fourOfAKind : [9 of clubs at position 7, 9 of diamonds at position 20, 9 of hearts at position 33, " 
				+ "9 of spades at position 46, 10 of hearts at position 34]";
		
		assertEquals(expected, fourOfAKind5CardsSorted.toString());
	}
	
	/** 
	 * TEST 6
	 */
	@Test
	public void testFourOfAKind7CardsToString()
	{
		expected = "fourOfAKind : [9 of clubs at position 7, 9 of diamonds at position 20, 9 of hearts at position 33, " 
				+ "9 of spades at position 46, 10 of hearts at position 34, queen of diamonds at position 23, "
				+ "king of spades at position 50]";
		
		assertEquals(expected, fourOfAKind7Cards.toString());
	}
	
	/**
	 * TEST 7
	 */
	@Test
	public void testFullHouse5CardsToString()
	{
		expected = "fullHouse : [3 of spades at position 40, 3 of clubs at position 1, 3 of hearts at position 27, "
				+ "queen of clubs at position 10, queen of diamonds at position 23]";
		
		assertEquals(expected, fullHouse5CardsSorted.toString());
	}
	
	/**
	 * TEST 8
	 */
	@Test
	public void testFullHouse7CardsToString()
	{
		expected = "fullHouse : [2 of spades at position 39, 3 of spades at position 40, 3 of clubs at position 1, 3 of hearts at position 27, "
				+ "queen of clubs at position 10, queen of diamonds at position 23, ace of spades at position 51]";
		
		assertEquals(expected, fullHouse7CardsSorted.toString());
	}
	
	/**
	 * TEST 9
	 */
	@Test
	public void testFlush5CardsToString()
	{		
		expected = "flush : [4 of diamonds at position 15, 5 of diamonds at position 16, 8 of diamonds at position 19, "
				+ "jack of diamonds at position 22, king of diamonds at position 24]";
		
		assertEquals(expected, flush5Cards.toString());
	}
	
	/**
	 * TEST 10
	 */
	@Test
	public void testFlush7CardsToString()
	{
		flush7Cards = new Hand(kingDiamonds, eightDiamonds, fiveDiamonds, jackDiamonds, fourDiamonds, eightHearts, tenClubs);
		
		expected = "onePair : [4 of diamonds at position 15, 5 of diamonds at position 16, 8 of diamonds at position 19, "
				+ "8 of hearts at position 32, 10 of clubs at position 8, jack of diamonds at position 22, "
				+ "king of diamonds at position 24]";
		
		assertEquals(expected, flush7Cards.toString());
	}

	/**
	 * TEST 11
	 */
	@Test
	public void testStraight5CardsToString()
	{	
		expected = "straight : [5 of diamonds at position 16, 6 of hearts at position 30, 7 of clubs at position 5, "
				+ "8 of spades at position 45, 9 of diamonds at position 20]";
		
		assertEquals(expected, straight5CardsSorted.toString());
	}
	
	/**
	 * TEST 12
	 */
	@Test
	public void testStraight7CardsToString()
	{		
		expected = "straight : [5 of diamonds at position 16, 6 of hearts at position 30, 7 of clubs at position 5, "
				+ "8 of spades at position 45, 9 of diamonds at position 20, 10 of hearts at position 34, "
				+ "jack of clubs at position 9]";
		
		assertEquals(expected, straight7CardsSorted.toString());
	}
	
	/**
	 * TEST 13
	 */
	@Test
	public void testThreeOfAKind5CardsToString()
	{
		threeOfAKind7Cards = new Hand(twoDiamonds, twoSpades, twoClubs, fiveSpades, sixClubs, jackHearts, queenDiamonds);
	
		expected = "threeOfAKind : [2 of clubs at position 0, 2 of diamonds at position 13, 2 of spades at position 39, "
				+ "5 of spades at position 42, 6 of clubs at position 4]";
		
		assertEquals(expected, threeOfAKind5Cards.toString());
	}
	
	/**
	 * TEST 14
	 */
	@Test
	public void testThreeOfAKind7CardsToString()
	{
		expected = "threeOfAKind : [2 of clubs at position 0, 2 of diamonds at position 13, 2 of spades at position 39, "
				+ "5 of spades at position 42, 6 of clubs at position 4, jack of hearts at position 35, "
				+ "queen of diamonds at position 23]";
		
		assertEquals(expected, threeOfAKind7Cards.toString());
	}
	
	/**
	 * TEST 15
	 */
	@Test
	public void testTwoPair5CardsToString()
	{
		expected = "twoPair : [4 of spades at position 41, 9 of hearts at position 33, 9 of spades at position 46, jack of clubs at position 9, "
				+ "jack of diamonds at position 22]";
		
		assertEquals(expected, twoPair5Cards.toString());
	}
	
	/**
	 * TEST 16
	 */
	@Test
	public void testTwoPair7CardsToString()
	{
		expected = "twoPair : [4 of spades at position 41, 5 of spades at position 42, 9 of hearts at position 33, "
				+ "9 of spades at position 46, jack of clubs at position 9, jack of diamonds at position 22, "
				+ "ace of hearts at position 38]";
		
		assertEquals(expected, twoPair7Cards.toString());
	}
	
	/**
	 * TEST 17
	 */
	@Test
	public void testOnePair5CardsToString()
	{
		expected = "onePair : [3 of diamonds at position 14, 6 of diamonds at position 17, 9 of clubs at position 7, "
				+ "ace of clubs at position 12, ace of hearts at position 38]";
		
		assertEquals(expected, onePair5Cards.toString());
	}
	
	/**
	 * TEST 18
	 */
	@Test
	public void testOnePair7CardsToString()
	{	
		expected = "onePair : [3 of diamonds at position 14, 6 of diamonds at position 17, 8 of clubs at position 6, "
				+ "9 of clubs at position 7, jack of diamonds at position 22, ace of clubs at position 12, "
				+ "ace of hearts at position 38]";
		
		assertEquals(expected, onePair7Cards.toString());
	}
	
	/**
	 * TEST 19
	 */
	@Test
	public void testHighCard5CardsToString()
	{
		expected = "highCard : [2 of clubs at position 0, 3 of spades at position 40, 5 of diamonds at position 16, "
				+ "8 of diamonds at position 19, queen of hearts at position 36]";
		
		assertEquals(expected, highCard5Cards.toString());
	}
	
	/**
	 * TEST 20
	 */
	@Test
	public void testHighCard7CardsToString()
	{	
		expected = "highCard : [2 of clubs at position 0, 3 of spades at position 40, 5 of diamonds at position 16, "
				+ "8 of diamonds at position 19, queen of hearts at position 36, king of spades at position 50, "
				+ "ace of diamonds at position 25]";
		
		assertEquals(expected, highCard7Cards.toString());
	}
	
	// XXX Tests for the clear method
	
	/**
	 * TEST 1
	 */
	@Test
	public void testClearFiveCardHand()
	{
		royalFlush5CardsClubsSorted.clear();
		
		for(int index = 0; index < royalFlush5CardsClubsSorted.getHand().length; index++)
		{
			assertTrue(royalFlush5CardsClubsSorted.getHand()[index] == null);
		}
		
		assertEquals(0, royalFlush5CardsClubsSorted.getNumberOfCards());
	}
	
	/**
	 * TEST 2
	 */
	@Test
	public void testClearSevenCardHand()
	{
		royalFlush7CardsClubsSorted.clear();
		
		for(int index = 0; index < royalFlush7CardsClubsSorted.getHand().length; index++)
		{
			assertTrue(royalFlush7CardsClubsSorted.getHand()[index] == null);
		}
		
		assertEquals(0, royalFlush7CardsClubsSorted.getNumberOfCards());
	}
}

