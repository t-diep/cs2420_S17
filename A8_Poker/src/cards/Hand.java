package cards;

import java.util.Arrays;

/**
 * Represents a hand in Poker
 * 
 * @author Tony Diep, Ashton Schmidt, last updated 3-24-17
 */
public class Hand implements Comparable<Hand>
{
	//Random generator
	static My_Best_Random_Generator generator = new My_Best_Random_Generator();
	
	public static void main(String[] args)
	{

	}
	
	//The hand to hold cards
	private Card[] hand;
	//Determines rank of a hand
	public Rank rank;
	//Determines whether the hand will have five or seven cards
	private int numberOfCards;
	
	/**
	 * Creates a hand of 5 cards
	 * 
	 * @param one -- first card
	 * @param two -- second card
	 * @param three -- third card
	 * @param four -- fourth card
	 * @param five -- fifth card
	 */
	Hand(Card one, Card two, Card three, Card four, Card five)
	{
		hand = new Card[5];
		
		hand[0] = one;
		hand[0].isAlreadyDealt = true;
		hand[1] = two;
		hand[1].isAlreadyDealt = true;
		hand[2] = three;
		hand[2].isAlreadyDealt = true;
		hand[3] = four;
		hand[3].isAlreadyDealt = true;
		hand[4] = five;
		hand[4].isAlreadyDealt = true;
		
		this.numberOfCards += 5;
		
		rank = determineRank();
	}
	
	/**
	 * Creates a hand of 7 cards 
	 * 
	 * @param one -- first card
	 * @param two -- second card
	 * @param three -- third card
	 * @param four -- fourth card
	 * @param five -- fifth card
	 * @param six -- sixth card
	 * @param seven -- seventh card
	 */
	Hand(Card one, Card two, Card three, Card four, Card five, Card six, Card seven)
	{
		hand = new Card[7];
		
		hand[0] = one;
		hand[0].isAlreadyDealt = true;
		hand[1] = two;
		hand[1].isAlreadyDealt = true;
		hand[2] = three;
		hand[2].isAlreadyDealt = true;
		hand[3] = four;
		hand[3].isAlreadyDealt = true;
		hand[4] = five;
		hand[4].isAlreadyDealt = true;
		hand[5] = six;
		hand[5].isAlreadyDealt = true;
		hand[6] = seven;
		hand[6].isAlreadyDealt = true;
		
		this.numberOfCards += 7;
		
		rank = determineRank();
	}
	
	/**
	 * Creates a 5 card hand based on deck positions
	 * 
	 * @param first -- first deck position
	 * @param second -- second deck position
	 * @param third -- third deck position
	 * @param fourth -- fourth deck position
	 * @param fifth -- fifth deck position
	 */
	Hand(int first, int second, int third, int fourth, int fifth)
	{
		this(new Card(first), new Card(second), new Card(third),
				new Card(fourth), new Card(fifth));
		
		rank = determineRank();
	}
	
	/**
	 * Creates a 7 card hand based on deck positions
	 * 
	 * @param first   --  first card
	 * @param second  --  second card
	 * @param third   --  third card
	 * @param fourth  --  fourth card
	 * @param fifth   --  fifth card
	 * @param sixth   --  sixth card
	 * @param seventh --  seventh card
	 */
	Hand(int first, int second, int third, int fourth, int fifth, int sixth, int seventh)
	{
		this(new Card(first), new Card(second), new Card(third), new Card(fourth),
				new Card(fifth), new Card(sixth), new Card(seventh));
		
//		this(Deck.deal(first), Deck.deal(second), Deck.deal(third), Deck.deal(fourth), Deck.deal(fifth));
		
		rank = determineRank();
	}
		
	/**
	 * Getter for the current hand
	 * 
	 * @return hand
	 */
	public Card[] getHand()
	{
		return hand;
	}
	
	/**
	 * Getter for the current number of cards in the hand
	 * 
	 * @return number of cards in the hand
	 */
	public int getNumberOfCards()
	{
		return numberOfCards;
	}
	
	/**
	 * Gets a random hand that will either have room for 5 or 7 cards
	 * 
	 * @return a hand with either 5 or 7 cards
	 */
	public Card[] getRandomHand()
	{
		if((int) (Math.random() * 1_000_000) % 2 == 0)
		{
			hand = new Card[5];
		}
		else
		{
			hand = new Card[7];
		}
		
		for(int index = 0; index < hand.length; index++)
		{
			hand[index] = Deck.deal(generator.next_int(52));
		
			while(hand[index] != null)
			{
				hand[index] = Deck.deal(generator.next_int(52));
			}
		}
		
		return hand;
	}
	
	/**
	 * Generates two hands with random cards and stores them for 
	 * computing stochastically the probability of one hand with a 
	 * given two cards beating a random hand
	 * 
	 * @param h1 -- first hand
	 * @param h2 -- second hand
	 * @param h1c1 -- deck position for first card for first hand
	 * @param h1c2 -- deck position for second card for first hand
	 * @param h2c1 -- deck position for first card for second hand
	 * @param h2c2 -- deck position for second card for second hand
	 */
	public static Hand[] getTwoRandomHands(Hand h1, Hand h2, int h1c1, int h1c2, int h2c1, int h2c2)
	{
		Hand[] twoHands = new Hand[2];
		
		h1.hand = new Card[7];
		h2.hand = new Card[7];
		
		Hand.insertSevenCards(h1c1, h1c2, generator.next_int(52), generator.next_int(52), generator.next_int(52), generator.next_int(52), generator.next_int(52));
		Hand.insertSevenCards(h2c1, h2c2, generator.next_int(52), generator.next_int(52), generator.next_int(52), generator.next_int(52), generator.next_int(52));
		
		twoHands[0] = h1;
		twoHands[1] = h2;
		
		return twoHands;
	}
	
	/**
	 * Determines the correct rank based for this hand
	 */
	public Rank determineRank()
	{		
		//Royal flush
		if(HandUtil.isRoyalFlush(hand))
		{
			return Rank.royalFlush;
		}
		//Straight flush
		else if(HandUtil.isStraightFlush(hand))
		{
			return Rank.straightFlush;
		}
		//Four of a kind
		else if(HandUtil.isFourOfAKind(hand))
		{
			return Rank.fourOfAKind;
		}
		//Full house
		else if(HandUtil.isFullHouse(hand))
		{
			return Rank.fullHouse;
		}
		//Flush
		else if(HandUtil.isFlush(hand))
		{
			return Rank.flush;
		}
		//Straight
		else if(HandUtil.isStraight(hand))
		{
			return Rank.straight;
		}
		//Three of a kind
		else if(HandUtil.isThreeOfAKind(hand))
		{
			return Rank.threeOfAKind;
		}
		//Two pairs
		else if(HandUtil.isTwoPair(hand))
		{
			return Rank.twoPair;
		}
		//One pair
		else if(HandUtil.isOnePair(hand))
		{
			return Rank.onePair;
		}
		//High card
		return Rank.highCard;
	}

	/**
	 * Creates a hand of 5 cards based on locations in the deck
	 * 
	 * @param first -- first card
	 * @param second -- second card
	 * @param third -- third card
	 * @param fourth -- fourth card
	 * @param fifth -- fifth card
	 */
	public void insertFiveCards(int first, int second, int third, int fourth, int fifth)
	{	
		hand[0] = new Card(first);
		hand[0].isAlreadyDealt = true;
		hand[1] = new Card(second);
		hand[1].isAlreadyDealt = true;
		hand[2] = new Card(third);
		hand[2].isAlreadyDealt = true;
		hand[3] = new Card(fourth);
		hand[3].isAlreadyDealt = true;
		hand[4] = new Card(fifth);
		hand[4].isAlreadyDealt = true;
	}

	/**
	 * Creates a hand of 7 cards based on locations in the deck
	 * 
	 * @param first -- first card
	 * @param second -- second card
	 * @param third -- third card
	 * @param fourth -- fourth card
	 * @param fifth -- fifth card
	 * @param sixth -- sixth card
	 * @param seventh -- seventh card
	 */
	public static Hand insertSevenCards(int first, int second, int third, int fourth, int fifth,
			int sixth, int seventh)
	{	
		Card[] hand1;
	
		hand1 = new Card[7];
		
		hand1[0] = new Card(first);
		hand1[0].isAlreadyDealt = true;
		hand1[1] = new Card(second);
		hand1[1].isAlreadyDealt = true;
		hand1[2] = new Card(third);
		hand1[2].isAlreadyDealt = true;
		hand1[3] = new Card(fourth);
		hand1[3].isAlreadyDealt = true;
		hand1[4] = new Card(fifth);
		hand1[4].isAlreadyDealt = true;
		hand1[5] = new Card(sixth);
		hand1[5].isAlreadyDealt = true;
		hand1[6] = new Card(seventh);
		hand1[6].isAlreadyDealt = true;
		
		Hand h1 = new Hand(hand1[0],hand1[1],hand1[2],hand1[3],hand1[4],hand1[5],hand1[6]);
		return h1;
	}
		
	/**
	 * Deletes all the cards in the hand
	 */
	public void clear()
	{
		for(int index = 0; index < hand.length; index++)
		{
			hand[index] = null;
		}
		
		numberOfCards = 0;
	}
	
	/**
	 * Prints out the current cards in the hand
	 * 
	 * @return a textual representation the cards in the hand
	 */
	public String toString()
	{				
		return this.rank + " : " + Arrays.toString(hand);
	}
	
	/**
	 * Compares two hands 
	 */
	@Override
	public int compareTo(Hand other) 
	{
		return this.determineRank().compareTo(other.determineRank()); 
	}
}
