package com.icy.bluff.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import com.icy.bluff.Bluff;
import com.icy.bluff.Card;
import com.icy.bluff.Organizer;
import com.icy.bluff.Player;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import java.awt.TextField;
import java.awt.Label;
import javax.swing.JTextField;
import java.awt.CardLayout;

public class BluffGui extends JPanel {
	/**
	 * Version id
	 */
	private static final long serialVersionUID = 1L;
	public JFrame frame;
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

	/** BUTTONS */
	public JButton openButton = new JButton();
	public JButton hitButton = new JButton();
	public JButton foldButton = new JButton();
	public ButtonGroup buttonGroup = new ButtonGroup();
	public final JPanel tablePanel = new JPanel();
	public final JRadioButton rdb2 = new JRadioButton("2");
	public final JRadioButton rdb3 = new JRadioButton("3");
	public final JRadioButton rdb4 = new JRadioButton("4");
	public final JRadioButton rdb5 = new JRadioButton("5");
	public final JRadioButton rdb6 = new JRadioButton("6");
	public final JRadioButton rdb7 = new JRadioButton("7");
	public final JRadioButton rdb8 = new JRadioButton("8");
	public final JRadioButton rdb9 = new JRadioButton("9");
	public final JRadioButton rdb10 = new JRadioButton("10");
	public final JRadioButton rdbj = new JRadioButton("J");
	public final JRadioButton rdbq = new JRadioButton("Q");
	public final JRadioButton rdbk = new JRadioButton("K");
	public final JRadioButton rdba = new JRadioButton("A");
	public final JPanel infoPanel = new JPanel();
	public final JLabel ccount = new JLabel("Number of cards on table:");
	public final JTextField lastCardCount = new JTextField();
	public final JLabel lcowner = new JLabel("Last Claim owner:");
	public final JLabel lccount = new JLabel("Number of Last Card count:");
	public final JTextField lastClaimOwner = new JTextField();
	public final JLabel lclaim = new JLabel("Last Claim:");
	public final JTextField cardCount = new JTextField();
	public final JTextField lastClaimVal = new JTextField();
	public final JPanel cardPanel = new JPanel();
	public final JPanel openCardsPanel = new JPanel();
	public final JPanel tableCardsPanel = new JPanel();

	/**
	 * Constructor
	 * 
	 * @param bluff
	 *            The game instance
	 */
	public BluffGui(Bluff bluff) {
		lastClaimVal.setEditable(false);
		lastClaimVal.setColumns(10);
		cardCount.setEditable(false);
		cardCount.setColumns(10);
		lastClaimOwner.setEditable(false);
		lastClaimOwner.setColumns(10);
		lccount.setLabelFor(lastCardCount);
		lastCardCount.setEditable(false);
		lastCardCount.setColumns(10);
		
		setBorder(null);
		this.bluff = bluff;
		for (int i = 0; i < Bluff.NUMBEROFPLAYERS; ++i)
			bluff.players[i].setBluffGui(this);
		this.drawHands();
		this.updateTableInfo();
		// ///////////
		this.buttonGroup.add(rdb2);
		this.buttonGroup.add(rdb3);
		this.buttonGroup.add(rdb4);
		this.buttonGroup.add(rdb5);
		this.buttonGroup.add(rdb6);
		this.buttonGroup.add(rdb7);
		this.buttonGroup.add(rdb8);
		this.buttonGroup.add(rdb9);
		this.buttonGroup.add(rdb10);
		this.buttonGroup.add(rdbj);
		this.buttonGroup.add(rdbq);
		this.buttonGroup.add(rdbk);
		this.buttonGroup.add(rdba);
	}

	/**
	 * Displays the gui
	 */
	public void display() {
		JFrame myFrame = new JFrame("Bluff");
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.setContentPane(this);
		myFrame.setResizable(false);
		Dimension d = new Dimension(1200, 850);
		myFrame.setPreferredSize(d);
		myFrame.pack();
		myFrame.setVisible(true);
		this.frame = myFrame;
		// TODO GAME LOOP
		this.bluff.players[0].play();

	}

	// TODO Should be turned into paint, which is a method of JPanel
	/**
	 * Draws the hands into gui, it should be called in the game loop
	 */
	public void drawHands() {
		// /////////
		topPanel.setBounds(0, 0, 1233, 76);
		this.topPanel.setBackground(new Color(0, 122, 0));
		secondPanel.setBounds(1048, 76, 185, 736);
		this.secondPanel.setBackground(new Color(0, 122, 0));
		thirdPanel.setBounds(185, 76, 863, 192);
		this.thirdPanel.setBackground(new Color(0, 122, 0));
		fourthPanel.setBounds(0, 76, 185, 736);
		this.fourthPanel.setBackground(new Color(0, 122, 0));
		playerPanel.setBounds(185, 562, 863, 250);
		this.playerPanel.setBackground(new Color(0, 122, 0));
		this.openButton.setText("  Open");

		this.openButton.addActionListener(new OpenButton(this));

		topPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		this.topPanel.add(this.openButton);
		this.foldButton.setText("  Fold");
		this.foldButton.addActionListener(new FoldButton(this));
		this.hitButton.setText("  Hit");
		this.hitButton.addActionListener(new HitButton(this));
		// //////////////////////////////////
		this.topPanel.add(this.hitButton);
		this.topPanel.add(this.foldButton);
		topPanel.add(rdb2);
		topPanel.add(rdb3);
		topPanel.add(rdb4);
		topPanel.add(rdb5);
		topPanel.add(rdb6);
		topPanel.add(rdb7);
		topPanel.add(rdb8);
		topPanel.add(rdb9);
		topPanel.add(rdb10);
		topPanel.add(rdbj);
		topPanel.add(rdbq);
		topPanel.add(rdbk);
		topPanel.add(rdba);
		thirdPanel.setLayout(new FlowLayout(FlowLayout.CENTER, -20, 5));
		fourthPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, -20));
		this.playerPanel.addMouseListener(new Organizer(this));
		setLayout(null);
		secondPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, -20));
		playerPanel.setLayout(new FlowLayout(FlowLayout.CENTER, -30, 11));
		tablePanel.setBounds(185, 265, 863, 297);
		add(tablePanel);
		tablePanel.setBackground(Color.ORANGE);
		tablePanel.setLayout(new BorderLayout(0, 0));
		
		tablePanel.add(infoPanel, BorderLayout.WEST);
		infoPanel.setLayout(new GridLayout(4, 2, 0, 0));
		ccount.setVerticalTextPosition(SwingConstants.TOP);
		
		infoPanel.add(ccount);
		
		infoPanel.add(cardCount);
		
		infoPanel.add(lccount);
		
		infoPanel.add(lastCardCount);
		
		infoPanel.add(lcowner);
		
		infoPanel.add(lastClaimOwner);
		
		infoPanel.add(lclaim);
		
		infoPanel.add(lastClaimVal);
		
		tablePanel.add(cardPanel, BorderLayout.CENTER);
		cardPanel.setLayout(new BorderLayout(0, 0));
		
		cardPanel.add(openCardsPanel, BorderLayout.NORTH);
		
		cardPanel.add(tableCardsPanel, BorderLayout.CENTER);
		tableCardsPanel.setLayout(new CardLayout(0, 0));
		// this.add(new JPanel(),BorderLayout.SOUTH );

		this.add(topPanel);
		this.add(this.secondPanel);
		this.add(this.thirdPanel);
		this.add(this.fourthPanel);
		this.add(this.playerPanel);

		Player[] players = this.bluff.players;
		for (int i = 0; i < players[0].hand.size(); ++i) {

			//JLabel jc = new JLabel(players[0].hand.get(i).getImage());
			//players[0].hand.get(i).jcard = jc;
			this.playerPanel.add(players[0].hand.get(i).jcard);
			

		}

		for (int i = 0; i < players[1].hand.size(); ++i) {
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
	 * 
	 * @param sel
	 *            - Card instance of the selected card.
	 * @param k
	 *            - JLabel instance of the selected card.
	 */
	public void drawSelection(Card sel, JLabel k) {
		// TODO Selection animation FIX half display when clicked
		int ind = this.bluff.players[0].hand.indexOf(sel);
		Card cur = this.bluff.players[0].hand.get(ind);
		cur.setSelected();
		System.out.println("JKART ins : " + sel.jcard);
		if (cur.isSelected()) {
			k.setLocation(k.getX(), k.getY() - 10);
			this.bluff.players[0].holding.add(cur);
		} else {
			k.setLocation(k.getX(), k.getY() + 10);
			this.bluff.players[0].holding.remove(cur);
		}

	}

	public void playComputers(int index) {
		for (int i = index; i < 4; ++i) {
			this.bluff.players[i].play();
			//this.drawHands();
			System.err.println("TABLE\n:" + this.bluff.table.toString());
		}
		this.bluff.players[0].play();
		this.updateTableInfo();

	}
	/**
	 * Repaints the changes on the board.Should be called after any change on the board.
	 */
	public void refresh (){
		
		for(int i = 0; i<this.getComponentCount();i++){
			if (this.getComponent(i)!=null) {
				this.getComponent(i).setVisible(false);
				this.getComponent(i).setVisible(true);
			}
			this.getComponent(i).repaint();
		}
		
		this.repaint();
	}
	/**
	 * Updates the card info on the table.
	 */
	public void updateTableInfo(){
		this.cardCount.setText(""+bluff.table.size());
		this.lastCardCount.setText(""+bluff.numberOfLastCards);
		this.lastClaimOwner.setText("Player - "+bluff.lastClaimOwner);
		this.lastClaimVal.setText(""+bluff.lastClaim);
		JPanel jjj = (JPanel)(this.tablePanel.getComponent(1));
		JPanel crds = (JPanel)( jjj.getComponent(1) );
		if(bluff.table.size()==0){
			crds.removeAll();
		} else  {	
			crds.add(new JLabel(new ImageIcon("img/back.jpg")));
		}
		this.refresh();
	}
	
}
