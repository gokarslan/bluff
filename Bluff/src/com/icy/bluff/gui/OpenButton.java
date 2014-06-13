package com.icy.bluff.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import com.icy.bluff.Bluff;
import com.icy.bluff.Card;

/**
 * Handles the opening a card in the tabl
 * 
 * @author Kerim Gokarslan <kerim.gokarslan@boun.edu.tr>
 * @version 0.1
 * 
 *          e
 * 
 */
public class OpenButton implements ActionListener {
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
	public OpenButton(BluffGui bluffGui) {
		//super();
		this.bluffGui = bluffGui;
	}
	//TODO OPENING A CARD
	/**
	 * Handles opening
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Bluff bluff = this.bluffGui.bluff;
		if (bluff.table.size() < 1)
			;// TODO ERROR
		boolean flag = true;
		for (int i = 0; i < bluff.numberOfLastCards; ++i) {
			if (!bluff.table.get(bluff.table.size() - i)
					.equals(bluff.lastClaim)) {
				flag = false;

			}
		}
		if (flag) {
			bluff.players[0].addToHand(bluff.table);
			this.bluffGui.hitButton.setEnabled(false);

		} else {
			bluff.players[bluff.lastClaimOwner - 1].addToHand(bluff.table);
			this.bluffGui.hitButton.setEnabled(true);
		}
		bluff.table = new ArrayList<Card>();
		bluff.lastClaim = null;
		int temp=bluff.lastClaimOwner ;
		bluff.lastClaimOwner = 0;
		bluff.numberOfLastCards = 0;
		bluffGui.topPanel.getComponent(0).setVisible(false);
		bluffGui.topPanel.getComponent(0).setVisible(true);		
		bluffGui.playerPanel.repaint();
		bluffGui.repaint();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(flag)
			this.bluffGui.bluff.players[0].play();
		else
			this.bluffGui.bluff.players[temp-1].play();
		
		//TODO RECHECK THE ENABILING 
		this.bluffGui.openButton.setEnabled(false);
		this.bluffGui.foldButton.setEnabled(false);

	}

}
