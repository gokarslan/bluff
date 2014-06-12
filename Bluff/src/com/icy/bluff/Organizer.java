package com.icy.bluff;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.icy.bluff.gui.BluffGui;

/**
 * Handles the mouse click <br>
 * 
 * UNDERSTANDING THE CLICK AND CHOOSING THE CARDS SHOULD BE IMPLEMENTED HERE
 * 
 * @author Kerim Gokarslan <kerim.gokarslan@boun.edu.tr>
 * @version 0.1
 * 
 * 
 * 
 */

public class Organizer extends MouseAdapter {
	/**
	 * Instance of gui
	 */
	private BluffGui bluffGui;

	/**
	 * Constructor of organizer
	 * 
	 * @param bluffGui
	 *            Instance of gui
	 */
	public Organizer(BluffGui bluffGui) {
		super();
		this.bluffGui = bluffGui;
	}

	/**
	 * If mouse pressed
	 * 
	 * UNDERSTANDING THE CLICK AND CHOOSING THE CARDS SHOULD BE IMPLEMENTED HERE
	 * CHOOSING EFFECTS AS MOVING THE CARD ETC MIGHT BE GIVEN
	 */
	public void mousePressed(MouseEvent e) {
		// TODO CHOOSING CARDS
		Component k = bluffGui.playerPanel.getComponentAt(e.getX(),e.getY());
		
		if(k instanceof JLabel){
			String ho = ((JLabel)k).getIcon().toString();
			Card sel = detectCard(ho);
			bluffGui.drawSelection(sel,(JLabel)k);
		}
		
	}
	/**
	 * Determines the card based on its filename.
	 * @param s Filename of the card.
	 * @return An instance of given card.
	 */
	public Card detectCard(String s) {
		s = s.replaceFirst("img/", "").replaceFirst(".jpg", "");
		String suit = s.substring(s.length()-1);
		String value = s.substring(0,s.length()-1 );

		return new Card(suit, value);
	}

}
