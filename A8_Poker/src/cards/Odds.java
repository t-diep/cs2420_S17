package cards;

/**
 * Represents a class containing static methods that compute
 * the chances of getting a desired Poker hand using 
 * the exhaustive method and stochastic method
 * 
 * @author Tony Diep, Ashton Schmidt, last updated 3-24-17
 */
public class Odds 
{
	/**
	 * Computes the percentage of winning Poker hands
	 * in Texas Hold'em between two hands
	 * 
	 * Hand value = Best hand is 0 worst hand or high card is 13
	 * 
	 * @param h1c1 -- first card in first hand
	 * @param h1c2 -- second card in first hand
	 * @param h2c1 -- first card in second hand
	 * @param h2c2 -- second card in second hand
	 * @param samples -- number of samples to conduct
	 * @return percentage
	 */
	static double odds_to_win(int h1c1, int h1c2, int h2c1, int h2c2, int samples)
	{
		Hand h1 = null;
		Hand h2 = null;

		double numberOfWinsHand1 = 0;
		
		for(int itterations = 0; itterations < samples; itterations++)
		{			
			My_Best_Random_Generator generator = new My_Best_Random_Generator();
			generator.set_constants(25214903917L, 11);
			generator.set_seed((int) (Math.random() * 1_000_000));
			
			int randIdx1 = generator.next_int(51);
			int randIdx2 = generator.next_int(51);
			int randIdx3 = generator.next_int(51);
			int randIdx4 = generator.next_int(51);
			int randIdx5 = generator.next_int(51);
		
			h2 = Hand.insertSevenCards(h2c1, h2c2, randIdx1, randIdx2, randIdx3, randIdx4, randIdx5);

			h1 = Hand.insertSevenCards(h1c1, h1c2, randIdx1, randIdx2, randIdx3, randIdx4, randIdx5);

			h1.rank.compareTo(h2.rank);

			int winner =  HandUtil.highestHand(h1,h2);

			if(winner < 0)
			{
				numberOfWinsHand1++;
			}
			
		}

		return numberOfWinsHand1/samples;
	}
	
	/**
	 * This creates two histograms first is the rankings of all of the different
	 * cards that are possible throughout the deck, and then adds the hand values of 
	 * each to the histogram.
	 * The second takes the ammounts from the histogram and makes them into a percentage
	 * 
	 * Hand value = Best hand is 0 worst hand or high card is 13
	 * 
	 * @param hand_size
	 * @return double[] percent of types of hands
	 */
	static double[] percentage_per_hand_category_exhaustive(int hand_size)
	{
		double[] percentage = new double[10];
		int [] histOfRank = new int[10];
		
		if(hand_size == 5)
		{
			for(int card1 = 0 ; card1 <= 48; card1++)
			{
				for(int card2 = card1+1; card2 <= 48; card2++)
				{
					for(int card3 = card2+1 ; card3 <= 48; card3++)
					{
						for(int card4 = card3+1 ; card4 <= 48; card4++)
						{
							for(int card5 = card4+1 ; card5 <= 48; card5++)
							{
								Hand newHand = new Hand(card1,card2,card3,card4,card5);
								Rank newRank = newHand.determineRank();

								
									if (newRank.equals(Rank.royalFlush))
									{
										histOfRank[0]++;
									}
									if (newRank.equals(Rank.straightFlush))
									{
										histOfRank[1]++;
									}
									if (newRank.equals(Rank.fourOfAKind))
									{
										histOfRank[2]++;
									}
									if (newRank.equals(Rank.fullHouse))
									{
										histOfRank[3]++;
									}
									if (newRank.equals(Rank.flush))
									{
										histOfRank[4]++;
									}
									if (newRank.equals(Rank.straight))
									{
										histOfRank[5]++;
									}
									if (newRank.equals(Rank.threeOfAKind))
									{										
										histOfRank[6]++;
									}
									if (newRank.equals(Rank.twoPair))
									{
										histOfRank[7]++;
									}
									if (newRank.equals(Rank.onePair))
									{
										histOfRank[8]++;
									}
									if (newRank.equals(Rank.highCard))
									{
										histOfRank[9]++;
									}
							}
						}
					}
				}
			}
		}
		
		if(hand_size == 7)
		{
			for(int card1 = 0 ; card1 <= 48; card1++)
			{
				for(int card2 = card1+1 ; card2 <= 48; card2++)
				{
					for(int card3 = card2+1 ; card3 <= 48; card3++)
					{
						for(int card4 = card3+1 ; card4 <= 48; card4++)
						{
							for(int card5 = card4+1 ; card5 <= 48; card5++)
							{
								for(int card6 = card5+1 ; card6 <= 48; card6++)
								{
									for(int card7 = card6+1 ; card7 <= 48; card7++)
									{
										Hand newHand = new Hand(card1,card2,card3,card4,card5);
										Rank newRank = newHand.determineRank();
										
										for(int index = 0; index < histOfRank.length; index++)
										{
											

											if (newRank.equals(Rank.royalFlush))
											{
												histOfRank[0]++;
											}
											if (newRank.equals(Rank.straightFlush))
											{
												histOfRank[1]++;
											}
											if (newRank.equals(Rank.fourOfAKind))
											{
												histOfRank[2]++;
											}
											if (newRank.equals(Rank.fullHouse))
											{
												histOfRank[3]++;
											}
											if (newRank.equals(Rank.flush))
											{
												histOfRank[4]++;
											}
											if (newRank.equals(Rank.straight))
											{
												histOfRank[5]++;
											}
											if (newRank.equals(Rank.threeOfAKind))
											{
												histOfRank[6]++;
											}
											if (newRank.equals(Rank.twoPair))
											{
												histOfRank[7]++;
											}
											if (newRank.equals(Rank.onePair))
											{
												histOfRank[8]++;
											}
											if (newRank.equals(Rank.highCard))
											{
												histOfRank[9]++;
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		
		int total = 0;
		for (int index = 0; index< histOfRank.length; index++)
		{
			total += histOfRank[index];
		}
		for (int value = 0; value< histOfRank.length; value++)
		{
			percentage[value] = histOfRank[value] / (double) total;
		}
		
		return percentage;
	}
			
	/**
	 * does the same as above but it uses random numbers rather than 
	 * calculating each hand for every card in the deck.
	 * 
	 * This is more allong the lines of a real life senario.
	 * 
	 * Hand value = Best hand is 0 worst hand or high card is 13
	 * 
	 * @param hand_size
	 * @param random_samples
	 * @return double[] percentage of each rank
	 */
	static double[] percentage_per_hand_category_stochastic(int hand_size, int random_samples)
	{
		double[] percentage = new double[10];
		int [] histOfRank = new int[10];


		for (int index1 = 0; index1 < 10_000_000; index1++)
		{
			Hand randHand = null;
			
			if(hand_size == 5)
			{
				
				//random 5 cards
				int randNum1 =(int) (Math.random()*51);
				int randNum2 =(int) (Math.random()*51);
				int randNum3 =(int) (Math.random()*51);
				int randNum4 =(int) (Math.random()*51);
				int randNum5 =(int) (Math.random()*51);
				
				
				randHand = new Hand(randNum1,randNum2,randNum3,randNum4,randNum5);
			}
			else
			{
				//random 7 cards
				int randNum1 =(int) (Math.random()*51);
				int randNum2 =(int) (Math.random()*51);
				int randNum3 =(int) (Math.random()*51);
				int randNum4 =(int) (Math.random()*51);
				int randNum5 =(int) (Math.random()*51);
				int randNum6 =(int) (Math.random()*51);
				int randNum7 =(int) (Math.random()*51);
				
				randHand = new Hand(randNum1, randNum2, randNum3, randNum4, randNum5, randNum6, randNum7);
			}

			Rank randHandRank= randHand.determineRank();

			for(int index = 0; index < histOfRank.length - 1; index++)
			{

				if (randHandRank.equals(Rank.royalFlush))
				{
					histOfRank[0]++;
				}
				if (randHandRank.equals(Rank.straightFlush))
				{
					histOfRank[1]++;
				}
				if (randHandRank.equals(Rank.fourOfAKind))
				{
					histOfRank[2]++;
				}
				if (randHandRank.equals(Rank.fullHouse))
				{
					histOfRank[3]++;
				}
				if (randHandRank.equals(Rank.flush))
				{
					histOfRank[4]++;
				}
				if (randHandRank.equals(Rank.straight))
				{
					histOfRank[5]++;
				}
				if (randHandRank.equals(Rank.threeOfAKind))
				{
					histOfRank[6]++;
				}
				if (randHandRank.equals(Rank.twoPair))
				{
					histOfRank[7]++;
				}
				if (randHandRank.equals(Rank.onePair))
				{
					histOfRank[8]++;
				}
				if (randHandRank.equals(Rank.highCard))
				{
					histOfRank[9]++;
				}
			}
		}
		
		int total = 0;
		for (int index = 0; index< histOfRank.length; index++)
		{
			total += histOfRank[index];
		}
		for (int value = 0; value< histOfRank.length; value++)
		{
			percentage[value] = histOfRank[value] / (double) total;
		}
		return percentage;
	}
}
