package com.icy.bluff;

import java.util.Scanner;

/**
 * It handles the play of the human
 * 
 * @author Kerim Gokarslan <kerim.gokarslan@boun.edu.tr>
 * @version 0.1
 * 
 * 
 * 
 */
public class HumanPlayer extends Player {
	/**
	 * Constructor for a human player
	 * 
	 * @param deck
	 *            The total deck
	 * @param number
	 *            The number of the player(Usually 1)
	 * @param bluff
	 *            The bluff object
	 */
	public HumanPlayer(Card[] deck, int number, Bluff bluff) {
		super(deck, number, bluff);
		// TODO Auto-generated constructor stub
	}

	// TODO EDIT HUMAN PLAY
	/**
	 * IT SHOULD BE EDITTED ACCORDING TO GUI, this version is for SYSTEM.OUT
	 * EDIT AFTER HANDLE THE GUI,(choosing cards and buttons etc.)
	 */
	@Override
	public void play() {
		/*System.out.println(this.hand.toString());
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		if (this.bluff.isAllFold()) {
			System.out.println("Please open the new hand:");
			System.out
					.println("Enter the starting index(1 to+"
							+ this.hand.size()
							+ ") of cards, how many cards you want to play and your claim(1-13 inc.)");
			int index = input.nextInt();
			int numberOfCards = input.nextInt();
			Value claim = null;
			index--;
			if (index + numberOfCards >= this.hand.size()) {
				System.err.println("IMPOSSIBLE");
				this.play();
			}
			switch (input.nextInt()) {
			case 2:
				claim = Value.TWO;
				break;
			case 3:
				claim = Value.THREE;
				break;
			case 4:
				claim = Value.FOUR;
				break;
			case 5:
				claim = Value.FIVE;
				break;
			case 6:
				claim = Value.SIX;
				break;
			case 7:
				claim = Value.SEVEN;
				break;
			case 8:
				claim = Value.EIGHT;
				break;
			case 9:
				claim = Value.NINE;
				break;
			case 10:
				claim = Value.TEN;
				break;
			case 11:
				claim = Value.JACK;
				break;
			case 12:
				claim = Value.QUEEN;
				break;
			case 13:
				claim = Value.KING;
				break;
			case 1:
				claim = Value.ACE;
				break;
			default:
				System.exit(-2);
			}
			Card[] cards = new Card[numberOfCards];
			for (int i = 0; i < numberOfCards; ++i)
				cards[i] = this.hand.remove(index);
			this.isFold = false;
			this.bluff.startANewTurn(cards, claim);

		} else if (!this.isFold) {
			System.out
					.println("Enter the starting index(1 to "
							+ this.hand.size()
							+ ") of cards, how many cards you want to play (for passing please enter index=-1");
			int index = input.nextInt();
			if (index == -1) {
				this.isFold = true;
				return;
			}
			int numberOfCards = input.nextInt();
			index--;
			if (index + numberOfCards >= this.hand.size()) {
				System.err.println("IMPOSSIBLE");
				this.play();
			}
			Card[] cards = new Card[numberOfCards];
			for (int i = 0; i < numberOfCards; ++i)
				cards[i] = this.hand.remove(index);
			this.bluff.playCurrentTurn(cards);

		}
		// input.close();*/

	}
}
