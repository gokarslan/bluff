package com.icy.bluff.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

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
		// super();
		this.bluffGui = bluffGui;
	}

	// TODO OPENING A CARD
	/**
	 * Handles opening
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Bluff bluff = this.bluffGui.bluff;
		if (bluff.table.size() < 1){
			new Error(this.bluffGui.frame,"ERROR TITLE", "There is no card to open!");
			return ;
		}
		if(bluff.lastClaimOwner==0){
			new Error(this.bluffGui.frame,"ERROR TITLE", "One does not simply open his own card!!");
			return ;
		}
		boolean flag = true;
		for (int i = 0; i < bluff.numberOfLastCards; ++i) {
			if (!bluff.table.get(bluff.table.size() -1- i)
					.equals(bluff.lastClaim)) {
				flag = false;

			}
		}
		for(int i = 0; i<bluff.numberOfLastCards; i++){
			System.out.println(bluff.table.get(bluff.table.size()-1-i).jcard);
			bluffGui.openCardsPanel.add(bluff.table.get(bluff.table.size()-1-i).jcard);
		}
		
		bluffGui.openCardsPanel.getComponent(0).setVisible(false);
		bluffGui.openCardsPanel.getComponent(0).setVisible(true);
		bluffGui.openCardsPanel.revalidate();
		bluffGui.openCardsPanel.repaint();
		bluffGui.refresh();
		
		
		/////////////////

		//BURAYA PROGRAMI BEKLETECEK B�R�EYLER YAZMAMIZ GEREK�YOR
		///Thread.sleep i�e yaramad�.
		
		///////////////////
		
		
		//bluffGui.openCardsPanel.removeAll(); //clear open cards panel
		
		if (flag) {
			bluff.players[0].addToHand(bluff.table);
			Collections.sort(bluff.players[0].hand);
			bluffGui.playerPanel.removeAll();
			for (int i = 0; i < bluff.players[0].hand.size(); i++) {
				//System.out.println("JEYKART : "+bluff.table.get(i).jcard);
				bluffGui.playerPanel.add(bluff.players[0].hand.get(i).jcard);
			}
			this.bluffGui.hitButton.setEnabled(false);

		} else {
			bluff.players[bluff.lastClaimOwner - 1].addToHand(bluff.table);
			this.bluffGui.hitButton.setEnabled(true);
		}
		bluff.table = new ArrayList<Card>();
		bluff.lastClaim = null;
		int temp = bluff.lastClaimOwner;
		bluff.lastClaimOwner = 0;
		bluff.numberOfLastCards = 0;


		bluffGui.updateTableInfo();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		// TODO RECHECK THE ENABILING
		this.bluffGui.openButton.setEnabled(false);
		this.bluffGui.foldButton.setEnabled(false);
		System.err.println("TABLE\n:" + this.bluffGui.bluff.table.toString());
		if (flag)
			this.bluffGui.bluff.players[0].play();
		else
			this.bluffGui.playComputers(temp - 1);


		bluffGui.updateTableInfo();
	}

}
