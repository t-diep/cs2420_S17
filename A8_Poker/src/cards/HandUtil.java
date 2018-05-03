package cards;

/**
 * Represents a collection of methods that can be extensively 
 * use for comparing Poker hands
 * 
 * @author Tony Diep, last updated 3-24-17
 */
public class HandUtil 
{	
	public static final int[] histogram = new int[10];
	
	/**
	 * Determines if a Poker hand is indeed a royal flush 
	 * 
	 * NOTE: A royal flush is a hand that contains the following sequence
	 * with all with the same suits:
	 * 
	 * Ten, jack, queen, king, ace 					(for 5 cards)
	 * Eight, nine, ten, jack, queen, king, ace 	(for 7 cards)
	 * 
	 * @return true if a royal flush hand and false otherwise 
	 */
	public static boolean isRoyalFlush(Card[] hand)
	{		
		return isStraight(hand) && isFlush(hand) && getHighestCard(hand).value == 14;
	}
	
	/** 
	 * Determines if a hand is indeed a straight flush
	 * 
	 * NOTE: A straight flush is a hand that containing a sequence
	 * of cards with all the same suit
	 * 
	 * @return true if the hand is a straight flush and false otherwise
	 */
	public static boolean isStraightFlush(Card[] hand)
	{
		return isStraight(hand) && isFlush(hand);
	}
	
	/**
	 * Determines whether this hand contains a four of a kind
	 * 
	 * NOTE: Four of a kind is a hand that contains four cards 
	 * that have the same value in a row, regardless of different suits
	 * 
	 * @return true if the hand contains a four of a kind and false otherwise
	 */
	public static boolean isFourOfAKind(Card[] hand)
	{
		sortByValue(hand);
		
		int match = 0;
		int numMatches = 0;
		int breakIndex = 0;
		
		for(int index = 1; index < hand.length; index++)
		{
			if(hand[index].value == hand[index -1].value && !(hand[index].suit.equals(hand[index-1].suit)))
				{
					match = hand[index].value;
					numMatches = 1;
					breakIndex = index;
					break;
				}
		}
		
		for(int index = breakIndex; index < hand.length; index++)
		{
			if(hand[index].value == match)
			{
				numMatches++;
			}
		}
			
		return numMatches == 4; //fourOfAKind.size() == 4;
	}
	
	/**
	 * Determines whether the hand is indeed a full house
	 * 
	 * NOTE: A full house is a hand that contains three cards with the
	 * same value and two other cards containing the same different value, 
	 * regardless of suit.
	 * 
	 * @param hand -- the hand 
	 * @return true if the hand is a full house and false otherwise
	 */
	public static boolean isFullHouse(Card[] hand)
	{	
		sortByValue(hand);
		
		int middle = hand.length / 2;
		
		if(isThreeOfAKind(hand))
		{
			int index = 0;
			
			if(hand.length == 5)
			{
				if(hand[middle].value == hand[middle - 1].value && hand[middle].value != hand[middle + 1].value)
				{
					index = 3;
				}
				
				return hand[index].value == hand[index + 1].value;
			}
			
			
			if(hand.length == 7)
			{	
				for(int end = hand.length - 2; end > 0; end-= 2)
				{
					if(hand[end].value == hand[end - 1].value || hand[end].value == hand[end + 1].value)
					{
						if(hand[end].value == hand[end - 1].value && hand[end].value == hand[end + 1].value)
						{
							
						}
						else 
						{
							return true;
						}

					}
				}
			}
		}
		
		return false;
	}
	
	/**
	 * Determines if a hand is a flush
	 * 
	 * NOTE: A flush is a hand that has all cards containing the same
	 * suit, regardless of the values and the sequence of those values
	 * 
	 * @param hand -- the hand
	 * @return true if a hand is a flush and false otherwise
	 */
	public static boolean isFlush(Card[] hand)
	{
		sortBySuit(hand);
		
		for(int index = 1; index < hand.length; index++)
		{
			if(!(hand[index].suit.equals(hand[index-1].suit)))
			{
				return false;
			}
		}
		
		return true;
	}
	
	/**
	 * Determines if a hand is a straight
	 * 
	 * NOTE: A straight is a hand that contains cards in sequential 
	 * order
	 * 
	 * @param hand -- the hand
	 * @return true if the hand is a straight and false otherwise
	 */
	public static boolean isStraight(Card[] hand)
	{
		sortByValue(hand);
		
		for(int index = 1; index < hand.length; index++)
		{
			int valueDiff = hand[index].value - hand[index-1].value;
			
			if(valueDiff != 1)
			{
				return false;
			}
		}
		
		return true;
	}
	
	/**
	 * Determines whether if a hand is a three of a kind
	 * 
	 * NOTE: A three of a kind is a hand that contains three cards of the
	 * same value in a row, regardless of suit
	 * 
	 * @param hand -- the hand
	 * @return true if the hand is a three of a kind and false otherwise
	 */
	public static boolean isThreeOfAKind(Card[] hand)
	{	
		sortByValue(hand);
		
		int match = 0;
		int numMatches = 0;
		int breakIndex = 0;
		
		for(int index = 1; index < hand.length; index++)
		{
			if(hand[index].value == hand[index -1].value && !(hand[index].suit.equals(hand[index-1].suit)))
				{
					match = hand[index].value;
					numMatches = 1;
					breakIndex = index;
					break;
				}
		}
		
		for(int index = breakIndex; index < hand.length; index++)
		{
			if(hand[index].value == match)
			{
				numMatches++;
			}
		}
			
		return numMatches == 3; 
	}
	
	/**
	 * Determines if a hand contains is indeed a two pair 
	 * 
	 * NOTE: A two pair is a hand that contains one pair of the same denomination
	 * plus another pair of another denomination, regardless of suit
	 * 
	 * @param hand -- the hand 
	 * @return true if the hand is a two pair and false otherwise
	 */
	public static boolean isTwoPair(Card[] hand)
	{
		sortByValue(hand);

		int numMatches = 0;
		
		for(int index = 1; index < hand.length; index++)
		{
			if(hand[index].value == hand[index -1].value)
			{
					numMatches++;
			}
		}
			
		return numMatches == 2; 
	}
	
	/**
	 * Determines if a hand is indeed an one pair 
	 * 
	 * NOTE: One pair is a hand that contains two cards with the same value
	 * in a row, regardless of suit
	 * 
	 * @param hand -- the hand
	 * @return true if the hand contains one pair and false otherwise
	 */
	public static boolean isOnePair(Card[] hand)
	{
		sortByValue(hand);
		
		int numMatches = 0;
		
		for(int index = 1; index < hand.length; index++)
		{
			if(hand[index].value == hand[index -1].value)
			{
				numMatches++;
			}
		}
		
		return numMatches == 1;
	}
	
	/**
	 * Gets the highest card (in terms of value) from the hand
	 * 
	 * @param hand -- the hand
	 * @return the highest card
	 */
	public static Card getHighestCard(Card[] hand)
	{
		sortByValue(hand);
		return hand[hand.length - 1];
	}
	
	/**
	 * Sorts all the cards in the hand based on suits in ascending order 
	 * 
	 * @param hand -- the hand
	 */
	public static void sortBySuit(Card[] hand)
	{
		int outer;
		int inner;
		
		for(outer = 1; outer < hand.length; outer++)
		{
			Card current = hand[outer];
			
			for(inner = outer - 1; (inner >= 0 && hand[inner].suit.compareTo(current.suit) > 0); inner--)
			{
				hand[inner + 1] = hand[inner];
			}
			
			hand[inner + 1] = current;
		}
	}
	
	/**
	 * Sorts all of the cards in the hand based on values in ascending order
	 * 
	 * @param hand -- hand
	 */
	public static void sortByValue(Card[] hand)
	{
		int outer;
		int inner;
		
		for(outer = 1; outer < hand.length; outer++)
		{
			Card current = hand[outer];
			
			for(inner = outer - 1; (inner >= 0 && hand[inner].value > current.value); inner--)
			{
				hand[inner + 1] = hand[inner];
			}
			
			hand[inner + 1] = current;
		}
	}
	
	/**
	 * Given two hands, returns the highest hand based on ranks
	 * 
	 * @param first -- first hand
	 * @param second -- second hand
	 * @return highest hand ||-1 = first hand  0= draw 1= second hand
	 */
	public static int highestHand(Hand first, Hand second)
	{
		int result = first.compareTo(second);

		if(result == 0) // if they are the same
		{
			int handValue = first.determineRank().ordinal();

			switch(handValue)
			{
			//Royal flush
			case 0:
				return 0; //draw for royal flush
			
				//Straight flush
			case 1:
				result = getHighestCard(first.getHand()).compareTo(getHighestCard(second.getHand()));
				if(result == 0)
				{
					return 0; //draw
				}
				else if (result < 0)
				{
					return -1; //first is bigger
				}
				else
				{
					return 1; //second is bigger
				}
				

				//Four of a kind
			case 2:
				int end = first.getHand().length-1;
				int hand1HighFour = 0;
				int hiCardHand1 = 0;
				int hand2HighFour = 0;
				int hiCardHand2 = 0;

				// first hand
				if (first.getHand()[end].value == first.getHand()[end-1].value)
				{
					hand1HighFour = first.getHand()[end].value;
					hiCardHand1 = first.getHand()[0].value;

				}
				else
				{
					hiCardHand1 = first.getHand()[end].value;
					hand1HighFour = first.getHand()[0].value;
				}

				//second hand

				if (second.getHand()[end].value == second.getHand()[end-1].value)
				{
					hand2HighFour = second.getHand()[end].value;
					hiCardHand2 = second.getHand()[0].value;

				}
				else
				{
					hiCardHand2 = second.getHand()[end].value;
					hand2HighFour = second.getHand()[0].value;
				}

				if(hand1HighFour<hand2HighFour)
				{
					return 1; //second four of a kind bigger
				}
				if(hand1HighFour>hand2HighFour)		
				{
					return -1; //first four of a kind bigger
				}
				if(hand1HighFour ==  hand2HighFour)
				{
					//check for the high card
					if(hiCardHand1< hiCardHand2)
					{
						return 1;// second is bigger
					}
					if(hiCardHand1> hiCardHand2)
					{
						return -1;//first is bigger
					}
					else
					{
						return 0; //draw
					}
				}
				



				//full house	
			case 3:
				
				int[] histogramFirst = createHistogramOfHand(first);
				int[] histogramSecond = createHistogramOfHand(second);
				
				for(int index = 13; index>= 0; index--) //???
				{
					if(histogramFirst[index] ==3 && histogramSecond[index] != 3)
					{
						return -1; // first is winner
					}
					if(histogramFirst[index] != 3 && histogramSecond[index] == 3)
					{
						return 1; //second is winner
					}
					if (histogramFirst[index] == 3 && histogramSecond[index] == 3) //find the two pair
					{
						histogramFirst[index] = 0; //decrement so that we dont enter an infinite loop and can start over
						histogramSecond[index] = 0;
						int samePairs = 0;
						for(int index2 = 13; index2 >= 0; index2-- )
						{

							if(histogramFirst[index2] == 2 || histogramSecond[index2] == 2)
							{

								if( histogramFirst[index2] > histogramSecond[index2])
								{
									return -1; // first is winner
								}
								if(histogramFirst[index2] < histogramSecond[index2])
								{
									return 1; //second is winner
								}
								if(histogramFirst[index2] == histogramSecond[index2] && histogramFirst[index2]!=0)
								{
									histogramFirst[index2] = 0; //if pair again decrement and start over
									histogramSecond[index2] = 0;
									samePairs++;

									if(samePairs == 2)
									{
										for(int indexInner = 13; indexInner >= 0; indexInner-- )
										{
											if( histogramFirst[indexInner] > histogramSecond[indexInner])
											{
												return -1; // first winner
											}
											if(histogramFirst[indexInner] < histogramSecond[indexInner])
											{
												return 1; //second winner
											}

											else
											{
												if( indexInner == 0)
												{
													return 0; //draw
												}
												else
												{
													indexInner--;
												}
											}
										}

									}

									else
									{
										if(index == 0)
										{
											return 0; //draw
										}
										
									}
								}
							}
						}
						
						
						
					}
					if(index == 0)
					{
						return 0; //draw
					}
				
				}

				// flush
			case 4:
				//sorted in low - hi order (5)
				int lastCard1 = first.getHand().length -1;
				int firstHi = first.getHand()[lastCard1].value;

				int lastCard2 = second.getHand().length-1;
				int secondHi = second.getHand()[lastCard2].value;

				if(firstHi > secondHi)
				{
					return -1;//fist is winner
				}
				if(firstHi < secondHi)
				{
					return 1; //second is winner
				}
				else
				{
					return 0;//draw
				}
			

				//straight 
			case 5:
				lastCard1 = first.getHand().length -1;
				firstHi = first.getHand()[lastCard1].value; //gets highest value

				lastCard2 = second.getHand().length-1;
				secondHi = second.getHand()[lastCard2].value; //gets highest value

				if(firstHi > secondHi)
				{
					return -1; //first is bigger
				}
				if(firstHi < secondHi)
				{
					return 1; //second is bigger
				}
				else
				{
					return 0; //draw
				}
				

				// 3 of a kind	
			case 6:
				int ofAKindMid = first.getHand().length/2;
				int ofAKindMid2 = second.getHand().length/2;
				int firstHand3KindHi = first.getHand()[ofAKindMid].value;
				int secondHand3KindHi = second.getHand()[ofAKindMid2].value;
				int firstHandPair = 0;
				int secondHandPair = 0;

				if(firstHand3KindHi>secondHand3KindHi)
				{
					return -1; //fist is bigger
				}
				if(firstHand3KindHi<secondHand3KindHi)
				{
					return 1; //second is bigger
				}		
				else // 0 or equal get pair value
				{
					//first hand
					if(firstHand3KindHi != first.getHand()[ofAKindMid-1].value)
					{
						firstHandPair = first.getHand()[ofAKindMid-1].value;
					}
					else
					{
						firstHandPair = first.getHand()[ofAKindMid+1].value;

					}
					//second hand

					if(secondHand3KindHi != second.getHand()[ofAKindMid2-1].value)
					{
						secondHandPair = second.getHand()[ofAKindMid2-1].value;
					}
					else
					{
						secondHandPair = first.getHand()[ofAKindMid2+1].value;

					}

					if(firstHandPair > secondHandPair)
					{
						return -1; //first is bigger
					}
					if (firstHandPair < secondHandPair)
					{
						return 1; //second is bigger
					}
					else
					{
						return 0; //draw
					}

				}
				

				//two pair

			case 7:

				
				int[] histogramFirst2 = createHistogramOfHand(first);
				int[] histogramSecond2 = createHistogramOfHand(second);
				int samePairs = 0;

				for(int index2 = 13; index2 >= 0; index2-- ) //start at the end work our way back
				{

					if(histogramFirst2[index2] == 2 || histogramSecond2[index2] == 2)
					{

						if( histogramFirst2[index2] > histogramSecond2[index2])
						{
							return -1; //first
						}
						if(histogramFirst2[index2] < histogramSecond2[index2])
						{
							return 1; //second
						}
						if(histogramFirst2[index2] == histogramSecond2[index2] && histogramFirst2[index2]!=0)
						{
							histogramFirst2[index2] = 0; //decrement and restart at end of histogram
							histogramSecond2[index2] = 0;
							samePairs++; // add so we know if they are two pair

							if(samePairs == 2) //search for high card
							{
								for(int indexInner = 13; indexInner >= 0; indexInner-- )
								{
									if( histogramFirst2[indexInner] > histogramSecond2[indexInner])
									{
										return -1; //first
									}
									if(histogramFirst2[indexInner] < histogramSecond2[indexInner])
									{
										return 1; //second
									}

									else
									{
										if( indexInner == 0)
										{
											return 0;//draw
										}
										
									}
								}

							}

							else
							{
								if(index2 == 0)
								{
									return 0;//draw
								}
							
							}
						}

					}
					
				}
				
				//one pair done
			case 8:
				int[] histogramFirst3 = createHistogramOfHand(first);
				int[] histogramSecond3 = createHistogramOfHand(second);
				int same = 0;
				for(int index = 13; index >= 0; index-- )
				{
					if(histogramFirst3[index] == 2 || histogramSecond3[index] == 2)
					{
						//beacuse it has one pair for sure
						if( histogramFirst3[index] > histogramSecond3[index])
						{
							return -1; //first
						}
						if(histogramFirst3[index] < histogramSecond3[index])
						{
							return 1; //second
						}
						if(histogramFirst3[index] == histogramSecond3[index])
						{
								
							histogramFirst3[index] = 0; //decrement so we can start over
							histogramSecond3[index] = 0;							
							same++;
							
							if(same == 1) //pairs have been found look for high card
							{
								for(int indexInner = 13; indexInner >= 0; indexInner-- )
								{
									if( histogramFirst3[indexInner] > histogramSecond3[indexInner])
									{
										return -1; //first
									}
									if(histogramFirst3[indexInner] < histogramSecond3[indexInner])
									{
										return 1;//second
									}

									else
									{
										if( indexInner == 0)
										{
											return 0;//draw
										}
										
									}
								}
							}
						}
					
					}
					
				}

				
				//hi card 
			case 9:
				
				int[] histogramFirst4 = createHistogramOfHand(first);
				int[] histogramSecond4 = createHistogramOfHand(second);
				
				for(int index = 13; index >= 0; index-- )
				{
					if (histogramFirst4[index] == 0 && histogramSecond4[index] == 0 ||
							histogramFirst4[index] == histogramSecond4[index])
					{
						if(index == 0)
						{
							return 0;//draw
						}
						else
						{
							index--;
						}
					}
					if(histogramFirst4[index] != 0 && histogramSecond4[index] == 0)
					{
						return -1;//first
					}
					if(histogramFirst4[index] ==0 && histogramSecond4[index] != 0)
					{
						return 1;//second
					}
					
				}
				
					
			}


		}

		if(result < 0)
		{
			return 1;
		}
		else
		{
			return -1;
		}
	}
	
	
	/**
	 * Gets the card that is between the two desired indexes
	 * 
	 * @param hand -- a hand
	 * @param begin -- the start boundary
	 * @param end -- the end boundary
	 */
	public static Card getParticularCard(Card[] hand, int begin, int end)
	{
		return hand[end - begin];
	}
	
	/**
	 * Takes the top five highest cards from a seven card hand
	 * 
	 * @param sevenHand -- a seven card Poker hand
	 * @return a five card hand containing the best 5 cards
	 */
	public static Card[] getBest5CardsFrom7CardHand(Card[] sevenHand)
	{
		Card[] best5 = new Card[5];
		
		sortByValue(sevenHand);
		
		for(int index = 0; index < 5; index++)
		{
			best5[index] = sevenHand[index];
		}
		
		return best5;
	}
	
	/**
	 * Rearranges the cards from one given index to another given index
	 * 
	 * @param hand -- hand
	 * @param from -- the starting point
	 * @param to -- the ending point
	 */
	public static void swap(Card[] hand, int from, int to)
	{
		Card temp = hand[from];
		hand[from] = hand[to];
		hand[to] = temp;
	}
	
	/**
	 * Takes in a hand and then creates an int array for the card values of 
	 * 1-13. It then adds the values of the 5 cards to their correct spaces
	 * in the histogram.
	 * 
	 * @param h1
	 * @return returns an int [] histogramOfValues
	 */
	public static int[] createHistogramOfHand (Hand h1)
	{
		int[] histogramOfValues = new int[14];
		
		for(int histo = 0; histo < histogramOfValues.length-1; histo++)
		{
			for(int cards = 0; cards < h1.getHand().length - 1; cards++)
			{
				if(h1.getHand()[cards].value == histo)
				histogramOfValues[histo] ++;
			}
		}

		return histogramOfValues;
	}
}
