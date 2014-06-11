package com.icy.bluff;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
		System.err.println(e.toString());
	}

}
