package com.icy.bluff;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

/**
 * This class handles the game
 * 
 * @author Kerim Gokarslan <kerim.gokarslan@boun.edu.tr>
 * @version 0.2
 * 
 * 
 * 
 */
public class Bluff {
	/** The number of the players */
	public static int NUMBEROFPLAYERS = 4;
	/** Frame rate */
	public static int frameRate = 1;
	/** It is the first deck, shared between four players */
	public Card[] deck = new Card[Card.SIZE];
	/** The array of players */
	public Player[] players = new Player[Bluff.NUMBEROFPLAYERS];
	/** The list of cards in the table, initially it is empty */
	public ArrayList<Card> table = new ArrayList<Card>();
	/**
	 * The value of last claim, it is used for checking whether the claim is
	 * true or not
	 */
	public Value lastClaim;
	/** The number of the last thrown cards */
	public int numberOfLastCards;
	/** The owner of the last cards */
	public int lastClaimOwner;
	/** Flag of fold, if it is true, the next one can open a new turn */
	public boolean isAllFold = true;

	/**
	 * Construct a bluff object
	 */
	public Bluff() {
		LinkedList<Integer> randomList = new LinkedList<Integer>();
		for (int i = 0; i < Card.SIZE; ++i)
			randomList.add(i);
		Random rand = new Random();
		for (int i = Card.SIZE - 1; i >= 0; --i) {
			deck[Card.SIZE - i - 1] = new Card(randomList.remove(rand
					.nextInt(i + 1)));
		}
		this.players[0] = new HumanPlayer(deck, 1, null);
		for (int i = 1; i < Bluff.NUMBEROFPLAYERS; ++i)
			this.players[i] = new ComputerPlayer(deck, i + 1, null);

	}

	/**
	 * Adds the given cards into table
	 * 
	 * @param cards
	 *            The cards that thrown
	 */
	public void addToTable(ArrayList<Card> cards) {
		// this.lastClaim = claim;
		this.numberOfLastCards = cards.size();
		for (int i = 0; i < this.numberOfLastCards; ++i)
			this.table.add(cards.get(i));
	}

	/**
	 * Gives whether all players are fold or not
	 * 
	 * @return <code>TRUE</code> if all is fold
	 */
	public boolean isAllFold() {
		return this.isAllFold;
	}

	/**
	 * Starts a new turn
	 * 
	 * @param claim
	 * 
	 *            The value of claim
	 * 
	 * @param cards
	 *            The cards that thrown
	 */
	public void startANewTurn(Value claim, ArrayList<Card> cards) {
		this.lastClaim = claim;
		this.addToTable(cards);
	}

	/**
	 * Adds the cards into table
	 * 
	 * @param cards
	 *            The cards that thrown
	 */
	public void playCurrentTurn(Card[] cards) {
		this.numberOfLastCards = cards.length;
		for (int i = 0; i < cards.length; ++i)
			this.table.add(cards[i]);

	}

}
