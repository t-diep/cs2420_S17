package cards;

/**
 * Represents a single playing card in Poker
 * 
 * @author Tony Diep, Ashton Schimdt, last updated 3-24-17
 */
public class Card implements Comparable<Card>
{
	//Represents this card's suit
	protected Suit suit;
	//Represents this card's value
	protected int value;
	//The current position of this card in a deck
	protected int deckPosition;
	//Indicator of whether this card has already been dealt or not
	protected boolean isAlreadyDealt;
	
	/**
	 * Creates a playing card
	 * 
	 * @param suit -- card's suit
	 * @param value -- card's value
	 * @param deckPosition -- the card's position in the deck
	 */
	Card(Suit suit, int value, int deckPosition)
	{
		if(deckPosition < 0 || deckPosition > 51)
		{
			throw new IndexOutOfBoundsException();
		}
		
		this.suit = suit;
		this.value = value;
		this.deckPosition = deckPosition;
		this.isAlreadyDealt = false;
	}
	
	/**
	 * Determining on a given deck position, this constructor creates the respective card
	 * @param deckPosition -- deck position
	 */
	Card(int deckPosition)
	{
		if(deckPosition < 0 || deckPosition > 51)
		{
			throw new IndexOutOfBoundsException();
		}
		
		this.deckPosition = deckPosition;
		this.isAlreadyDealt = false;
		
		switch(deckPosition)
		{	
			//Club cards
			case 0: this.suit = Suit.clubs; this.value = 2;   	  break;
			case 1: this.suit = Suit.clubs; this.value = 3;   	  break;
			case 2: this.suit = Suit.clubs; this.value = 4;   	  break;
			case 3: this.suit = Suit.clubs; this.value = 5;   	  break;
			case 4: this.suit = Suit.clubs; this.value = 6;   	  break;
			case 5: this.suit = Suit.clubs; this.value = 7;   	  break;
			case 6: this.suit = Suit.clubs; this.value = 8;   	  break;		
			case 7: this.suit = Suit.clubs; this.value = 9;   	  break;
			case 8: this.suit = Suit.clubs; this.value = 10;  	  break;
			case 9: this.suit = Suit.clubs; this.value = 11;  	  break;
			case 10: this.suit = Suit.clubs; this.value = 12; 	  break;
			case 11: this.suit = Suit.clubs; this.value = 13; 	  break;
			case 12: this.suit = Suit.clubs; this.value = 14; 	  break;
			
			
			//Diamond cards
			case 13: this.suit = Suit.diamonds; this.value = 2;   break;
			case 14: this.suit = Suit.diamonds; this.value = 3;   break;
			case 15: this.suit = Suit.diamonds; this.value = 4;   break;
			case 16: this.suit = Suit.diamonds; this.value = 5;   break;
			case 17: this.suit = Suit.diamonds; this.value = 6;   break;
			case 18: this.suit = Suit.diamonds; this.value = 7;   break;
			case 19: this.suit = Suit.diamonds; this.value = 8;   break;
			case 20: this.suit = Suit.diamonds; this.value = 9;   break;
			case 21: this.suit = Suit.diamonds; this.value = 10;  break;
			case 22: this.suit = Suit.diamonds; this.value = 11;  break;
			case 23: this.suit = Suit.diamonds; this.value = 12;  break;
			case 24: this.suit = Suit.diamonds; this.value = 13;  break;
			case 25: this.suit = Suit.diamonds; this.value = 14;  break;
			
			
			//Heart cards
			case 26: this.suit = Suit.hearts; this.value = 2;     break;
			case 27: this.suit = Suit.hearts; this.value = 3;     break;
			case 28: this.suit = Suit.hearts; this.value = 4;     break;
			case 29: this.suit = Suit.hearts; this.value = 5;     break;
			case 30: this.suit = Suit.hearts; this.value = 6;     break;
			case 31: this.suit = Suit.hearts; this.value = 7;     break;
			case 32: this.suit = Suit.hearts; this.value = 8;     break;
			case 33: this.suit = Suit.hearts; this.value = 9;     break;
			case 34: this.suit = Suit.hearts; this.value = 10; 	  break;
			case 35: this.suit = Suit.hearts; this.value = 11; 	  break;
			case 36: this.suit = Suit.hearts; this.value = 12; 	  break;
			case 37: this.suit = Suit.hearts; this.value = 13; 	  break;
			case 38: this.suit = Suit.hearts; this.value = 14; 	  break;
			
			
			//Spade cards
			case 39: this.suit = Suit.spades; this.value = 2;     break;
			case 40: this.suit = Suit.spades; this.value = 3;     break;
			case 41: this.suit = Suit.spades; this.value = 4;     break;
			case 42: this.suit = Suit.spades; this.value = 5;     break;
			case 43: this.suit = Suit.spades; this.value = 6;     break;
			case 44: this.suit = Suit.spades; this.value = 7;     break;
			case 45: this.suit = Suit.spades; this.value = 8;     break;
			case 46: this.suit = Suit.spades; this.value = 9;     break;
			case 47: this.suit = Suit.spades; this.value = 10; 	  break;
			case 48: this.suit = Suit.spades; this.value = 11; 	  break;
			case 49: this.suit = Suit.spades; this.value = 12; 	  break;
			case 50: this.suit = Suit.spades; this.value = 13; 	  break;
			case 51: this.suit = Suit.spades; this.value = 14; 	  break;
		}
	}
	
	/**
	 * Compares two cards if they are the same cards
	 * 
	 * @param other -- other Object
	 * @return true if two cards contain same suit and value and false otherwise
	 */
	public boolean equals(Object other)
	{
		if(other instanceof Card)
		{
			Card otherCard = (Card) other;
			
			if(this.suit.compareTo(otherCard.suit) == 0)
			{
				if(this.value == otherCard.value)
				{
					return true;
				}
			}	
		}
		return false;
	}
	
	/**
	 * Prints the String representation of this playing card
	 * 
	 * @return the String representation of this card
	 */
	public String toString()
	{	
		String result = "";
		
		if(value == 11)
		{
			result += "jack of " + this.suit;
		}
		else if(value == 12)
		{
			result += "queen of " + this.suit;
		}
		else if(value == 13)
		{
			result += "king of " + this.suit;
		}
		else if(value == 14)
		{
			result += "ace of " + this.suit;
		}
		else
		{
			result += this.value + " of " + this.suit;
		}
		
		return result + " at position " + this.deckPosition;
	}

	/**
	 * Compares this card and another card based on their suits and values
	 * 
	 * @param other -- other card
	 */
	@Override
	public int compareTo(Card other) 
	{
		int result = this.suit.compareTo(other.suit);
		
		if(result == 0)
		{
			result = this.value - other.value;
		}
		
		return result;
	}
}
