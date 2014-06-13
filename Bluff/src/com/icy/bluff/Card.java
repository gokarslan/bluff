package com.icy.bluff;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
;



/**
 * This class holds the information of a card
 * 
 * @author Kerim Gokarslan <kerim.gokarslan@boun.edu.tr>
 * @version 0.1
 * 
 */
public class Card implements Comparable<Card> {
	/**
	 * The size of deck
	 */
	public static int SIZE = 52;
	/**
	 * Suit of the card
	 */
	private Suit suit;
	/**
	 * Value of the card
	 */
	private Value value;
	
	/**
	 * Indicator of selected card.
	 */
	private boolean isSelected = false;
	/**
	 * JLabel instance associated with that card.
	 */
	public JLabel jcard ;
	/**
	 * Construct a card with given value
	 * 
	 * @param val
	 *            The value of the card
	 */
	public Card(int val) {
		switch (val % 4) {// suit
		case 0:
			this.suit = Suit.HEARTS;
			break;
		case 1:
			this.suit = Suit.DIAMONDS;
			break;
		case 2:
			this.suit = Suit.SPADE;
			break;
		case 3:
			this.suit = Suit.CLUBS;
			break;
		}
		switch (val % 13) {// value
		case 0:
			this.value = Value.TWO;
			break;
		case 1:
			this.value = Value.THREE;
			break;
		case 2:
			this.value = Value.FOUR;
			break;
		case 3:
			this.value = Value.FIVE;
			break;
		case 4:
			this.value = Value.SIX;
			break;
		case 5:
			this.value = Value.SEVEN;
			break;
		case 6:
			this.value = Value.EIGHT;
			break;
		case 7:
			this.value = Value.NINE;
			break;
		case 8:
			this.value = Value.TEN;
			break;
		case 9:
			this.value = Value.JACK;
			break;
		case 10:
			this.value = Value.QUEEN;
			break;
		case 11:
			this.value = Value.KING;
			break;
		case 12:
			this.value = Value.ACE;
			break;
		}

	}
	
	public Card(String suit, String val) {
		
		switch (suit) {// suit
		case "h":
			this.suit = Suit.HEARTS;
			break;
		case "d":
			this.suit = Suit.DIAMONDS;
			break;
		case "s":
			this.suit = Suit.SPADE;
			break;
		case "c":
			this.suit = Suit.CLUBS;
			break;
		}
		
		switch (val) {// value
		case "2":
			this.value = Value.TWO;
			break;
		case "3":
			this.value = Value.THREE;
			break;
		case "4":
			this.value = Value.FOUR;
			break;
		case "5":
			this.value = Value.FIVE;
			break;
		case "6":
			this.value = Value.SIX;
			break;
		case "7":
			this.value = Value.SEVEN;
			break;
		case "8":
			this.value = Value.EIGHT;
			break;
		case "9":
			this.value = Value.NINE;
			break;
		case "10":
			this.value = Value.TEN;
			break;
		case "jack":
			this.value = Value.JACK;
			break;
		case "queen":
			this.value = Value.QUEEN;
			break;
		case "king":
			this.value = Value.KING;
			break;
		case "ace":
			this.value = Value.ACE;
			break;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Card arg0) {
		return this.value.compareTo(arg0.value);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String string = "";
		switch (this.value) {
		case ACE:
			string += "A";
			break;
		case EIGHT:
			string += 8;
			break;
		case FIVE:
			string += 5;
			break;
		case FOUR:
			string += 4;
			break;
		case JACK:
			string += "J";
			break;
		case KING:
			string += "K";
			break;
		case NINE:
			string += 9;
			break;
		case QUEEN:
			string += "Q";
			break;
		case SEVEN:
			string += 7;
			break;
		case SIX:
			string += 6;
			break;
		case TEN:
			string += 10;
			break;
		case THREE:
			string += 3;
			break;
		case TWO:
			string += 2;
			break;

		}
		switch (this.suit) {
		case CLUBS:
			string += "-C";
			break;
		case DIAMONDS:
			string += "-D";
			break;
		case HEARTS:
			string += "-H";
			break;
		case SPADE:
			string += "-S";
			break;
		}
		return string;
	}

	/**
	 * Check whether the cards are equal by value or not
	 * 
	 * @param claim
	 *            The claim
	 * @return <code>TRUE</code> if the cards are equal by value
	 */
	public boolean equals(Value claim) {
		return this.value == claim;
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(obj instanceof Card){
			return ((Card) obj).value==this.value &&  ((Card) obj).suit == this.suit;
		}
		return false;
	}
	/**
	 * Gives the <code>ImageIcon</code> of the card, in order to draw it in gui
	 * 
	 * @return The <code>ImageIcon</code> object of it
	 */
	public ImageIcon getImage() {
		String fileName = "img/";
		switch (this.value) {
		case ACE:
			fileName += "ace";
			break;
		case EIGHT:
			fileName += 8;
			break;
		case FIVE:
			fileName += 5;
			break;
		case FOUR:
			fileName += 4;
			break;
		case JACK:
			fileName += "jack";
			break;
		case KING:
			fileName += "king";
			break;
		case NINE:
			fileName += 9;
			break;
		case QUEEN:
			fileName += "queen";
			break;
		case SEVEN:
			fileName += 7;
			break;
		case SIX:
			fileName += 6;
			break;
		case TEN:
			fileName += 10;
			break;
		case THREE:
			fileName += 3;
			break;
		case TWO:
			fileName += 2;
			break;

		}
		switch (this.suit) {
		case CLUBS:
			fileName += "c";
			break;
		case DIAMONDS:
			fileName += "d";
			break;
		case HEARTS:
			fileName += "h";
			break;
		case SPADE:
			fileName += "s";
			break;
		}
		fileName += ".jpg";
		return new ImageIcon(fileName);

	}
	
	public void setSelected(){
		this.isSelected = !isSelected;
	}
	public boolean isSelected() {
		return isSelected;
	}
}
