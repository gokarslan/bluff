package com.icy.bluff.gui;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonModel;
import javax.swing.JEditorPane;
import javax.swing.JRadioButton;

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
		System.out.println(bluffGui.buttonGroup.getSelection());

		// System.err.println(Integer.parseInt(bluffGui.claimText.getText()));
		System.err.println(player.holding);

		if (player.holding.size() < 1) {
			new Error(this.bluffGui.frame,"ERROR TITLE", "There is no card to hit!");
			return ;

		} else if (bluff.table.size() == 0) {// it means that is a new turn
			Value claim = null;
			ButtonModel a = bluffGui.buttonGroup.getSelection();

			if (bluffGui.rdb2.isSelected()) {
				claim = Value.TWO;
			} else if (bluffGui.rdb3.isSelected()) {
				claim = Value.THREE;
			} else if (bluffGui.rdb4.isSelected()) {
				claim = Value.FOUR;
			} else if (bluffGui.rdb5.isSelected()) {
				claim = Value.FIVE;
			} else if (bluffGui.rdb6.isSelected()) {
				claim = Value.SIX;
			} else if (bluffGui.rdb7.isSelected()) {
				claim = Value.SEVEN;
			} else if (bluffGui.rdb8.isSelected()) {
				claim = Value.EIGHT;
			} else if (bluffGui.rdb9.isSelected()) {
				claim = Value.NINE;
			} else if (bluffGui.rdb10.isSelected()) {
				claim = Value.TEN;
			} else if (bluffGui.rdbj.isSelected()) {
				claim = Value.JACK;
			} else if (bluffGui.rdbq.isSelected()) {
				claim = Value.QUEEN;
			} else if (bluffGui.rdbq.isSelected()) {
				claim = Value.KING;
			} else if (bluffGui.rdba.isSelected()) {
				claim = Value.ACE;
			}
			if (claim == null) {

			} else {
				bluff.startANewTurn(claim, player.holding);
				player.hand.removeAll(player.holding);
				for (int i = 0; i < player.holding.size(); i++) {
					bluffGui.playerPanel.remove(player.holding.get(i).jcard);
				}
				// System.err.println(player.hand.toString());
				player.holding = new ArrayList<Card>();
			}

		} else {
			bluff.addToTable(player.holding);
			player.hand.removeAll(player.holding);
			for (int i = 0; i < player.holding.size(); i++) {
				bluffGui.playerPanel.remove(player.holding.get(i).jcard);
			}
			player.holding = new ArrayList<Card>();
		}

		// repainti tam beceremedim ama bunu yapýnca repaint gibi oluyor.
		bluffGui.topPanel.getComponent(0).setVisible(false);
		bluffGui.topPanel.getComponent(0).setVisible(true);
		bluffGui.playerPanel.repaint();
		bluffGui.repaint();
		System.err.println("TABLE\n:" + this.bluffGui.bluff.table.toString());
		this.bluffGui.playComputers(1);

	}

}
