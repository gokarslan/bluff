package com.icy.bluff;

import com.icy.bluff.gui.BluffGui;

/**
 * Starting of the game
 * 
 * @author Kerim Gokarslan <kerim.gokarslan@boun.edu.tr>
 * @version 0.1
 * 
 * 
 */
public class Main {
	/**
	 * Initialize the game
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bluff bluff = new Bluff();
		BluffGui gui = new BluffGui(bluff);
		gui.display();

	}

}
