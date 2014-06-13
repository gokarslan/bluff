package com.icy.bluff.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import com.icy.bluff.Bluff;
import com.icy.bluff.Player;
import com.icy.bluff.Value;
import com.icy.bluff.Card;

/**
 * Handles hitting card(s) into table
 * 
 * @author Kerim Gokarslan <kerim.gokarslan@boun.edu.tr>
 * @version 0.1
 * 
 * 
 * 
 */
public class HitButton implements ActionListener {
	/**
	 * Gui instance
	 */
	private BluffGui bluffGui;

	/**
	 * Constructor
	 * 
	 * @param bluffGui
	 */
	public HitButton(BluffGui bluffGui) {
		this.bluffGui = bluffGui;
	}

	// TODO HITTING A CARD
	/**
	 * Handles hitting
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		Bluff bluff = this.bluffGui.bluff;
		Player player = bluff.players[0];
		System.err.println(Integer.parseInt(bluffGui.claimText.getText()));
		System.err.println(player.holding);
		if (player.holding.size() < 1) {

		} else if (bluff.table.size() == 0) {// it means that is a new turn
			Value claim = null;
			switch (Integer.parseInt(bluffGui.claimText.getText().substring(0,
					2))) {
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
				System.err.println("VOOOVVV");// TODO ERROR
				System.exit(-2);

			}
			if (claim == null) {

			} else {
				bluff.startANewTurn(claim, player.holding);
				player.hand.removeAll(player.holding);
				System.err.println(player.hand.toString());
				player.holding = new ArrayList<Card>();
			}

		}
		else{
			bluff.addToTable(player.holding);
			player.hand.removeAll(player.holding);
			player.holding = new ArrayList<Card>();
		}
		//bluffGui.drawHands();//call the repaint

	}

}
