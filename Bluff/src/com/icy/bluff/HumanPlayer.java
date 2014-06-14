package com.icy.bluff;


import com.icy.bluff.gui.BluffGui;

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
	public HumanPlayer(Card[] deck, int number, BluffGui bluffGui) {
		super(deck, number, bluffGui);
		// TODO Auto-generated constructor stub
	}

	// TODO EDIT HUMAN PLAY
	/**
	 * IT SHOULD BE EDITTED ACCORDING TO GUI, this version is for SYSTEM.OUT
	 * EDIT AFTER HANDLE THE GUI,(choosing cards and buttons etc.)
	 */
	@Override
	public void play() {
		if(!this.isFold){
			this.bluffGui.foldButton.setEnabled(true);
			this.bluffGui.hitButton.setEnabled(true);
		}
		this.bluffGui.playerPanel.setEnabled(true);
		this.bluffGui.openButton.setEnabled(true);

	}
}
