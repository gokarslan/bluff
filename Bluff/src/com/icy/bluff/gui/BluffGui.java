package com.icy.bluff.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;

import com.icy.bluff.Bluff;
import com.icy.bluff.Organizer;
import com.icy.bluff.Player;

/**
 * GUI of the game
 * 
 * @author Kerim Gokarslan <kerim.gokarslan@boun.edu.tr>
 * @version 0.1
 * 
 */
public class BluffGui extends JPanel {
	/**
	 * Version id
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Bluff instance
	 */

	public Bluff bluff;

	/**
	 * PANELS
	 */
	public JPanel topPanel = new JPanel();
	public JPanel secondPanel = new JPanel();
	public JPanel thirdPanel = new JPanel();
	public JPanel fourthPanel = new JPanel();
	public JPanel playerPanel = new JPanel();

	/** The box to write the value of claim */
	public JTextPane claimText = new JTextPane();

	/** BUTTONS */
	public JButton openButton = new JButton();
	public JButton hitButton = new JButton();
	public JButton foldButton = new JButton();

	/** LABELS */
	public JLabel secondLabel = new JLabel();
	public JLabel thirdLabel = new JLabel();
	public JLabel fourthLabel = new JLabel();
	public JLabel playerLabel = new JLabel();

	/**
	 * Constructor
	 * 
	 * @param bluff
	 *            The game instance
	 */
	public BluffGui(Bluff bluff) {
		this.bluff = bluff;
		this.topPanel.setBackground(new Color(0, 122, 0));
		this.secondPanel.setBackground(new Color(0, 122, 0));
		this.thirdPanel.setBackground(new Color(0, 122, 0));
		this.fourthPanel.setBackground(new Color(0, 122, 0));
		this.playerPanel.setBackground(new Color(0, 122, 0));
		this.topPanel.setLayout(new FlowLayout());
		this.claimText.setText(" ");
		this.claimText.setFont(new java.awt.Font("Helvetica Bold", 1, 20));
		this.openButton.setText("  Open");
		this.openButton.addActionListener(new OpenButton(this));
		this.hitButton.setText("  Hit");
		this.hitButton.addActionListener(new HitButton(this));
		this.foldButton.setText("  Fold");
		this.foldButton.addActionListener(new FoldButton(this));

		this.secondLabel.setText("  Second Player:  ");
		this.thirdLabel.setText("  Third Player:  ");
		this.fourthLabel.setText(" Fourth Player: ");
		this.playerLabel.setText("  You:  ");

		this.topPanel.add(this.claimText);
		this.topPanel.add(this.openButton);
		this.topPanel.add(this.hitButton);
		this.topPanel.add(this.foldButton);

		this.secondPanel.add(this.secondLabel);
		this.thirdPanel.add(this.thirdLabel);
		this.fourthPanel.add(this.fourthLabel);
		this.playerPanel.add(this.playerLabel);
		this.playerPanel.addMouseListener(new Organizer(this));
		this.setLayout(new BorderLayout());
		this.add(topPanel, BorderLayout.NORTH);
		this.add(this.secondPanel, BorderLayout.EAST);
		this.add(this.thirdPanel, BorderLayout.CENTER);
		this.add(this.fourthPanel, BorderLayout.WEST);
		this.add(this.playerPanel, BorderLayout.SOUTH);
		this.drawHands();

	}

	/**
	 * Displays the gui
	 */
	public void display() {
		JFrame myFrame = new JFrame("Bluff");
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.setContentPane(this);
		myFrame.setPreferredSize(new Dimension(700, 550));
		myFrame.pack();
		myFrame.setVisible(true);

	}

	/**
	 * Draws the hands into gui, it should be called in the game loop
	 */
	public void drawHands() {
		Player[] players = this.bluff.players;
		for (int i = 0; i < players[0].hand.size(); ++i) {
			this.playerPanel.add(new JLabel(players[0].hand.get(i).getImage()));
		}
		// TODO The cars of second and fourth player should be horizontal
		/*
		 * for(int i=0;i<players[1].hand.size()-10;++i){
		 * this.secondPanel.add(new JLabel(new ImageIcon("back.jpg"))); }
		 */
		for (int i = 0; i < players[2].hand.size(); ++i) {
			this.thirdPanel.add(new JLabel(new ImageIcon("img/back.jpg")));
		}
		/*
		 * for(int i=0;i<players[3].hand.size();++i){ this.fourthPanel.add(new
		 * JLabel(new ImageIcon("back.jpg"))); }
		 */
	}

}
