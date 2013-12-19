import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Help extends JFrame {

	JPanel panel;
	JPanel buttonPanel;
	JButton back;
	JLabel instructions;

	public Help() {
		setSize(900, 600);
		panel = new JPanel();
		buttonPanel = new JPanel();
		back = new JButton("Back");
		String a = "Instructions:\n Spades is trick-taking card game played with up to four players with "
				+ "a 52 card deck. To win the game a combination of points of a player and a teammate or an opponent and "
				+ "a teammate must be equal to or greater than 500. In order to accumulate points players must acquire bids. "
				+ "Before the start of the game players go in a clockwise order calling the amount of bids that they will take "
				+ "that game. Acquiring an amount of bids higher than the one called will result in a number of points equal to "
				+ "the number of bids called multiplied by 10 with 1 extra point added for each extra bid taken. In addition to "
				+ "the 1 point added a bag is also added to the player's score for each extra bid taken. A bag does not influence a player's score directly, "
				+ "instead, once a total of 10 bags have been accumulated 100 points are deducted from the player's score. If a player "
				+ "takes an amount of bids below the one he called the player loses an amount of points equal to the amount he would gain "
				+ "if the bid were fulfilled. If a bid of 0 is called and achieved the player is awarded 100 points, however, if failed "
				+ "100 points are deducted from the player's score. Tricks are taken based on card and suit value. Cards rank in ascending "
				+ "order of 2 to Ace. Spades is the highest suit in the game considered to be a trump while all other suits are of equal value. "
				+ "Players may only play cards that are of the same suit as the card played first. Only if a player does not have the required suit "
				+ "may the player choose to play a card of a different suit. If the player plays a suit of spades regardless of it's value, the spades "
				+ "beats all suits other than itself. If there is another spade then the cards are ranked based on card value. "
				+ "If a card other "
				+ "then a spade is played when a card of the required suit is not in possession the card's value is neglected and only values of the "
				+ "same suit and spades are considered. The first turn of the first round is determined at random, all subsequent turns are determined by the "
				+ "person sitting in the clockwise direction of the player who went first in the previous round. "
				+ "During the rounds the player "
				+ "that takes the trick places the card of their liking first after which all others follow. At the end of each round the bids "
				+ "are counted and the points earned by each player are allotted to their total scores, which includes their score and their teammate's added together.";
		instructions = new JLabel("<html>" + a + "</html>");
		panel.setLayout(new GridLayout(2, 1));
		panel.add(instructions);
		panel.add(buttonPanel);
		buttonPanel.add(back);
		add(panel);
		setLocationRelativeTo(null);
		setVisible(true);
		repaint();

		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Menu();
			}

		});

	}
}
