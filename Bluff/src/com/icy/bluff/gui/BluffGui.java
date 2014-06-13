package com.icy.bluff.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;

import com.icy.bluff.Bluff;
import com.icy.bluff.Card;
import com.icy.bluff.ComputerPlayer;
import com.icy.bluff.HumanPlayer;
import com.icy.bluff.Organizer;
import com.icy.bluff.Player;

import javax.swing.JSeparator;

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
	private final JSeparator separator = new JSeparator();

	/**
	 * Constructor
	 * 
	 * @param bluff
	 *            The game instance
	 */
	public BluffGui(Bluff bluff) {
		this.bluff = bluff;
		for (int i = 0; i < Bluff.NUMBEROFPLAYERS; ++i)
			bluff.players[i].setBluffGui(this);
		this.drawHands();

	}

	/**
	 * Displays the gui
	 */
	public void display() {
		JFrame myFrame = new JFrame("Bluff");
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.setContentPane(this);
		myFrame.setResizable(true);
		myFrame.setPreferredSize(new Dimension(1024, 768));
		myFrame.pack();
		myFrame.setVisible(true);
		//TODO GAME LOOP
		this.bluff.players[0].play();

	}
	//TODO Should be turned into paint, which is a method of JPanel
	/**
	 * Draws the hands into gui, it should be called in the game loop
	 */
	public void drawHands() {
		this.topPanel.setBackground(new Color(0, 122, 0));
		secondPanel.setAutoscrolls(true);
		this.secondPanel.setBackground(new Color(0, 122, 0));
		this.thirdPanel.setBackground(new Color(0, 122, 0));
		this.fourthPanel.setBackground(new Color(0, 122, 0));
		FlowLayout flowLayout = (FlowLayout) playerPanel.getLayout();
		flowLayout.setVgap(20);
		this.playerPanel.setBackground(new Color(0, 122, 0));
		this.topPanel.setLayout(new FlowLayout());
		this.claimText.setText("");
		this.claimText.setFont(new java.awt.Font("Helvetica Bold", 1, 20));
		this.openButton.setText("  Open");
		this.openButton.addActionListener(new OpenButton(this));
		this.hitButton.setText("  Hit");
		this.hitButton.addActionListener(new HitButton(this));
		this.foldButton.setText("  Fold");
		this.foldButton.addActionListener(new FoldButton(this));
		this.thirdLabel.setText("  Third Player:  ");
		this.fourthLabel.setText(" Fourth Player: ");
		this.playerLabel.setText("  You:  ");
		this.topPanel.add(this.claimText);
		this.topPanel.add(this.openButton);
		this.topPanel.add(this.hitButton);
		this.topPanel.add(this.foldButton);
								
		this.secondLabel.setText("  Second Player:  ");
						
							
		this.thirdPanel.add(this.thirdLabel);
		fourthPanel.setLayout(new BoxLayout(fourthPanel, BoxLayout.Y_AXIS));
		
		this.fourthPanel.add(this.fourthLabel);
		this.playerPanel.add(this.playerLabel);
		this.playerPanel.addMouseListener(new Organizer(this));
		
		this.setLayout(new BorderLayout());
		
		this.add(topPanel, BorderLayout.NORTH);
		this.add(this.secondPanel, BorderLayout.EAST);
		secondPanel.setLayout(new BoxLayout(secondPanel, BoxLayout.Y_AXIS));
		secondPanel.add(secondLabel);
		this.add(this.thirdPanel, BorderLayout.CENTER);
		this.add(this.fourthPanel, BorderLayout.WEST);
		this.add(this.playerPanel, BorderLayout.SOUTH);
		
		playerPanel.add(separator);
		//this.add(new JPanel(),BorderLayout.SOUTH );
		Player[] players = this.bluff.players;
		for (int i = 0; i < players[0].hand.size(); ++i) {
			JLabel cd = new JLabel(players[0].hand.get(i).getImage());
			this.playerPanel.add(cd);
			players[0].hand.get(i).jcard = cd;
		}

		for(int i=0;i<players[1].hand.size();++i){
			this.secondPanel.add(new JLabel(new ImageIcon("img/backr.jpg"))); 
		}

		for (int i = 0; i < players[2].hand.size(); ++i) {
			this.thirdPanel.add(new JLabel(new ImageIcon("img/back.jpg")));

		}

		for (int i = 0; i < players[3].hand.size(); ++i) {
			this.fourthPanel.add(new JLabel(new ImageIcon("img/backr.jpg")));
		}
		
		 
	}
	/**
	 * Shifts the card that is selected.
	 * @param sel - Card instance of the selected card.
	 * @param k - JLabel instance of the selected card.
	 */
	public void drawSelection(Card sel, JLabel k) {
		// TODO Selection animation FIX half display when clicked
		int ind = this.bluff.players[0].hand.indexOf(sel);
		Card cur = this.bluff.players[0].hand.get(ind);
		cur.setSelected();
		
		if(cur.isSelected() ){
			k.setLocation(k.getX(), k.getY()-10);
			this.bluff.players[0].holding.add(cur);
		} else {
			k.setLocation(k.getX(), k.getY()+10);
			this.bluff.players[0].holding.remove(cur);
		}

	}
		
}
