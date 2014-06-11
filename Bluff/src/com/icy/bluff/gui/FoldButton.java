package com.icy.bluff.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.icy.bluff.Bluff;

/**
 * Handles folding
 * 
 * @author Kerim Gokarslan <kerim.gokarslan@boun.edu.tr>
 * @version 0.1
 * 
 */
public class FoldButton implements ActionListener {
	/**
	 * Gui instance
	 */
	private BluffGui bluffGui;

	/**
	 * Constructor
	 * 
	 * @param bluffGui
	 *            Gui instance
	 */
	public FoldButton(BluffGui bluffGui) {
		this.bluffGui = bluffGui;
	}

	// TODO HANDLE FOLDING
	/**
	 * handles folding
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Bluff bluff = this.bluffGui.bluff;
		bluff.players[0].isFold = true;
		this.bluffGui.hitButton.setEnabled(false);
		this.bluffGui.foldButton.setEnabled(false);

	}

}
