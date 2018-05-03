package cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Random;

/**
 * Represents a 52-card deck
 * 
 * @author Tony Diep, Ashton Schmidt, last updated 3-24-17
 */
public class Deck 
{	
	HashSet<Integer> alreadyGeneratedNums;
	
	public static void main(String[] args)
	{
		for(int index = 1; index <= 51; index++)
		{
			Random generator = new Random();
			System.out.println(deal(generator.nextInt(index)));
		}
	}
	
	static Card[] deck = new Card[52];
	
	//The deck
	static 
	{
	  for (int i= 0; i < 52; i++)
	  {
	      deck[i] = new Card(i);
	  }
	}
	
	/**
	 * Deals a playing card from a deck
	 * 
	 * @return the playing card
	 */
	public static Card deal(int deckPosition)
	{	
		if(deck[deckPosition].isAlreadyDealt)
		{
			return null;
		}
		
		deck[deckPosition].isAlreadyDealt = true;
		return deck[deckPosition];
	}
	
	/**
	 * Gets the first card in the deck
	 * 
	 * @return first card
	 */
	public static Card getFirstCardInDeck()
	{
		deck[0].isAlreadyDealt = true;
		return deck[0];
	}
	
	/**
	 * Shuffles the deck 
	 */
	public static void shuffle()
	{
		ArrayList<Card> copyDeck = new ArrayList<Card>();
		
		for(int index = 0; index < deck.length; index++)
		{
			copyDeck.add(deck[index]);
		}
		
		Collections.shuffle(copyDeck);
		
		for(int index = 0; index < deck.length; index++)
		{
			deck[index] = copyDeck.get(index);
		}
	}
	
	/**
	 * Gets the last card in the deck
	 * 
	 * @return last card
	 */
	public static Card getLastCardInDeck()
	{
		deck[51].isAlreadyDealt = true;
		return deck[51];
	}
	
	/**
	 * Gets a specific Card in the deck based on an index
	 * 
	 * @param deckPosition -- position relating to a specific card
	 * @return specified card
	 */
	public static Card getSpecifiedCard(int deckPosition)
	{
		return new Card(deckPosition);
	}
}
