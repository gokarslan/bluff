package com.icy.bluff.gui;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
/**
 * Handles errors
 * 
 * @author Kerim Gokarslan <kerim.gokarslan@boun.edu.tr>
 * @version 0.2
 * 
 */
public class Error {
	public Error(JFrame frame, String title, String message){
		JOptionPane.showMessageDialog(frame,
			    message,
			    title,
		    JOptionPane.ERROR_MESSAGE);
		
	}

}
