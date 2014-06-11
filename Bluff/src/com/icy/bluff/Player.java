package com.icy.bluff;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Superclass for players
 * 
 * @author Kerim Gokarslan <kerim.gokarslan@boun.edu.tr>
 * @version 0.1
 * 
 * 
 */
public abstract class Player {
	/**
	 * The cards of the player
	 */
	public ArrayList<Card> hand = new ArrayList<Card>();
	/**
	 * The number of the player
	 */
	protected final int number;
	/**
	 * The instance of game
	 */
	protected Bluff bluff;
	/**
	 * The flag of fold
	 */
	public boolean isFold;

	/**
	 * Constructor for a player
	 * 
	 * @param deck
	 *            The total deck
	 * @param number
	 *            The number of the player
	 * @param bluff
	 *            The bluff object
	 */
	public Player(Card[] deck, int number, Bluff bluff) {
		this.number = number;
		this.bluff = bluff;
		this.isFold = false;
		for (int i = 0; i < 13; ++i)
			this.hand.add(deck[13 * (number - 1) + i]);
		Collections.sort(this.hand);
	}

	/**
	 * Adds to given card list to player's hand
	 * 
	 * @param cards
	 *            The list of cards
	 */
	public void addToHand(ArrayList<Card> cards) {
		for (int i = 0; i < cards.size(); ++i)
			this.hand.add(cards.get(i));
		Collections.sort(this.hand);

	}

	/**
	 * this method is called in the game-loop
	 */
	public abstract void play();

}
