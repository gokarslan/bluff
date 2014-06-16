package com.icy.bluff;

import java.util.ArrayList;
import java.util.Iterator;

import com.icy.bluff.gui.BluffGui;

/**
 * THE AI SHOULD BE IMPLEMENTED HERE!
 * 
 * @author Kerim Gokarslan <kerim.gokarslan@boun.edu.tr>
 * @version 0.1
 * 
 */
public class ComputerPlayer extends Player {
	/**
	 * Constructor for a computer player
	 * 
	 * @param deck
	 *            The total deck
	 * @param number
	 *            The number of the player
	 * @param bluff
	 *            The bluff object
	 */
	public ComputerPlayer(Card[] deck, int number, BluffGui bluffGui) {
		super(deck, number, bluffGui);
	}

	// TODO AI IMPLEMENTATION
	/**
	 * THE AI OF COMPUTER, IT SHOULD BE HERE, THE PLAY METHOD WILL BE CALLED IN
	 * THE GAME LOOP!
	 */
	@Override
	public void play() {
		this.bluffGui.foldButton.setEnabled(false);
		this.bluffGui.hitButton.setEnabled(false);
		this.bluffGui.playerPanel.setEnabled(false);
		Iterator<Card> iterator = this.hand.iterator();
		while (iterator.hasNext()) {
			Card current = iterator.next();
			if (current.equals(this.bluffGui.bluff.lastClaim)) {
				iterator.remove();
				ArrayList<Card> list = new ArrayList<Card>();
				list.add(current);
				this.bluffGui.bluff.addToTable(list);
				this.bluffGui.bluff.lastClaimOwner = this.number;
				this.bluffGui.bluff.numberOfLastCards = 1;// simdilik sadece
															// elinde varsa
															// dogru 1 kart
															// atiyo deneme
															// amacli
				
				
				switch (number) {
				case 2:
					bluffGui.secondPanel.remove(0);
					break;
				case 3:
					bluffGui.thirdPanel.remove(0);
					break;
				case 4:
					bluffGui.fourthPanel.remove(0);
					break;
				default:
					break;
				}
				
				
				break;
			}
		}
		// TODO AI PLAYS IN HERE
		/*
		 * try {//waits sleep atmak oyunu kasiyo sanirim onun yerine timerli
		 * falan kart atma animasyonu koyarsak hallolur Thread.sleep(1000); }
		 * catch (InterruptedException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */
		
		bluffGui.refresh();
		
		//
		System.out.println("I AM A COMPUTER BITCH!");
		/*
		 * if(this.number!=4){
		 * this.bluffGui.bluff.players[this.number].play();//the next ai-player
		 * } else this.bluffGui.bluff.players[0].play();//the human player
		 */

	}

}
