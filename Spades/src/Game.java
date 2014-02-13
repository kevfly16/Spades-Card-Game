import java.awt.FlowLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class Game implements ActionListener {
	Timer timer = new Timer(1, this);
	static int turn = (int) (Math.random() * 4);
	static int scorePlayer = 0;
	static int scoreOpponent = 0;
	static int playerBags = 0;
	static int opponentBags = 0;
	boolean playerGo = false;
	boolean playerGoFirst = false;
	JFrame frame = new JFrame();
	Window window;
	int[][] previousCards = new int[52][1];
	int[][] cardsRemoved = new int[52][1];
	int[][] playerHand, teammateHand, opponent1Hand, opponent2Hand;
	int[][] cardsViewed = new int[13][1];
	int bid, noCards = 0, cardsOut = 0, noTurn = 0, bidTakenPlayer = 0,
			bidTakenTeammate = 0, bidTakenOpponent1 = 0, bidTakenOpponent2 = 0,
			moves = 1;
	int[][] currentCards = new int[4][2];
	double bidTeammate = 0, bidOpponent1 = 0, bidOpponent2 = 0;
	JLabel[] cardsViewPlayer = new JLabel[13];
	JLabel[] cardsViewTeammate = new JLabel[13];
	JLabel[] cardsViewOpponent1 = new JLabel[13];
	JLabel[] cardsViewOpponent2 = new JLabel[13];
	JLabel cardsViewPlayerField = new JLabel();
	JLabel cardsViewTeammateField = new JLabel();
	JLabel cardsViewOpponent1Field = new JLabel();
	JLabel cardsViewOpponent2Field = new JLabel();
	JButton[] cardsButton;

	// constructor for the Game class which uses the Window class to create the
	// GUI for
	// the game
	public Game() {
		if (scorePlayer == 500 || scoreOpponent == 500) {
			if (scorePlayer > scoreOpponent) {
				JFrame frame = new JFrame();
				JOptionPane.showMessageDialog(frame, "Game Over. Player Wins.");
				System.exit(0);
			} else {
				JFrame frame = new JFrame();
				JOptionPane.showMessageDialog(frame,
						"Game Over. Opponent Wins.");
				System.exit(0);
			}
		}
		window = new Window(1375, 735);
		timer.setInitialDelay(1900);
		playerHand = new int[13][1];
		teammateHand = new int[13][1];
		opponent1Hand = new int[13][1];
		opponent2Hand = new int[13][1];
		playerHand = generateCard(previousCards, noCards, 0, playerHand);
		teammateHand = generateCard(previousCards, noCards, 0, teammateHand);
		opponent1Hand = generateCard(previousCards, noCards, 0, opponent1Hand);
		opponent2Hand = generateCard(previousCards, noCards, 0, opponent2Hand);
		window.playerScoreLabel.setText("Score: " + scorePlayer);
		window.opponentScoreLabel.setText("Score: " + scoreOpponent);
		window.playerBagsLabel.setText("Bags: " + playerBags);
		window.opponentBagsLabel.setText("Bags: " + opponentBags);
		window.playerLabel.setText("Bid: " + bidTakenPlayer + "/" + bid);

		window.bid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bidButton("bid");
			}
		});
		window.bid0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bidButton("bid0");
			}
		});
		window.bid1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bidButton("bid1");
			}
		});
		window.bid2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bidButton("bid2");
			}
		});
		window.bid3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bidButton("bid3");
			}
		});
		window.bid4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bidButton("bid4");
			}
		});
		window.bid5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bidButton("bid5");
			}
		});
		window.bid6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bidButton("bid6");
			}
		});
		window.bid7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bidButton("bid7");
			}
		});
		window.bid8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bidButton("bid8");
			}
		});
		window.bid9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bidButton("bid9");
			}
		});
		window.bid10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bidButton("bid10");
			}
		});
		window.bid11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bidButton("bid11");
			}
		});
		window.bid12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bidButton("bid12");
			}
		});
		window.bid13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bidButton("bid13");
			}
		});

		backCardIcons();
		startGame();
	}

	// generates the 13 cards for a player given all previous cards and an array
	// that holds values for each card
	public int[][] generateCard(int[][] previous, int noCards, int j,
			int[][] cards) {
		boolean duplicate = false;
		if (j == 13) {
			this.previousCards = previous;
			return cards;
		} else {

			do {
				duplicate = false;

				cards[j][0] = (int) (Math.random() * 52 + 1);

				for (int i = 0; i < noCards; i++) {
					if (cards[j][0] == previousCards[i][0])
						duplicate = true;
				}
			} while (duplicate);

			previous[noCards][0] = cards[j][0];
			this.noCards++;
			generateCard(previous, this.noCards, j + 1, cards);
			return cards;
		}
	}

	// creates the back card icons for all players
	public void backCardIcons() {

		for (int i = 0; i < 13; i++) {
			cardsViewPlayer[i] = new JLabel();
			cardsViewPlayer[i].setSize(30, 30);
			cardsViewPlayer[i].setIcon(new ImageIcon("cards/b1fv.png"));
			window.playerPanelCards.add(cardsViewPlayer[i]);
			window.setVisible(true);
			window.repaint();
		}
		for (int i = 0; i < 13; i++) {
			cardsViewTeammate[i] = new JLabel();
			cardsViewTeammate[i].setSize(30, 30);
			cardsViewTeammate[i].setIcon(new ImageIcon("cards/b1fv.png"));
			window.teammatePanelCards.add(cardsViewTeammate[i]);
			window.setVisible(true);
			window.repaint();
		}
		for (int i = 0; i < 13; i++) {
			cardsViewOpponent1[i] = new JLabel();
			cardsViewOpponent1[i].setSize(30, 30);
			cardsViewOpponent1[i].setIcon(new ImageIcon("cards/b1fv.png"));
			window.opponent1PanelCards.add(cardsViewOpponent1[i]);
			window.setVisible(true);
			window.repaint();
		}
		for (int i = 0; i < 13; i++) {
			cardsViewOpponent2[i] = new JLabel();
			cardsViewOpponent2[i].setSize(30, 30);
			cardsViewOpponent2[i].setIcon(new ImageIcon("cards/b1fv.png"));
			window.opponent2PanelCards.add(cardsViewOpponent2[i]);
			window.setVisible(true);
			window.repaint();
		}
	}

	// creates the frame containing all possible bid calls for the player
	public void bidFrame() {
		frame.setLayout(new FlowLayout());
		frame.setLocationRelativeTo(null);
		frame.setSize(275, 175);
		frame.add(window.bid0);
		frame.add(window.bid1);
		frame.add(window.bid2);
		frame.add(window.bid3);
		frame.add(window.bid4);
		frame.add(window.bid5);
		frame.add(window.bid6);
		frame.add(window.bid7);
		frame.add(window.bid8);
		frame.add(window.bid9);
		frame.add(window.bid10);
		frame.add(window.bid11);
		frame.add(window.bid12);
		frame.add(window.bid13);
		frame.add(window.bid);

		frame.setVisible(true);
		frame.repaint();
	}

	// determines the button pressed to determine the bid called by the player
	public void bidButton(String bid) {
		if (bid.equals("bid")) {
			frame.dispose();
			if (turn == 0) {
				window.opponent1Label.setText("Bid: 0/" + bidOpponent1);
				window.teammateLabel.setText("Bid: 0/" + bidTeammate);
				window.opponent2Label.setText("Bid: 0/" + bidOpponent2);
				playerGoFirst();
			}
			if (turn == 1) {
				opponent1Go();
			}

			if (turn == 2) {
				window.opponent1Label.setText("Bid: 0/" + bidOpponent1);
				teammateGo();
			}
			if (turn == 3) {
				window.opponent1Label.setText("Bid: 0/" + bidOpponent1);
				window.teammateLabel.setText("Bid: 0/" + bidTeammate);
				opponent2Go();
			}
		}
		if (bid.equals("bid0")) {
			this.bid = 0;
			window.playerLabel.setText("Bid: " + bidTakenPlayer + "/"
					+ this.bid);
		}
		if (bid.equals("bid1")) {
			this.bid = 1;
			window.playerLabel.setText("Bid: " + bidTakenPlayer + "/"
					+ this.bid);
		}
		if (bid.equals("bid2")) {
			this.bid = 2;
			window.playerLabel.setText("Bid: " + bidTakenPlayer + "/"
					+ this.bid);
		}
		if (bid.equals("bid3")) {
			this.bid = 3;
			window.playerLabel.setText("Bid: " + bidTakenPlayer + "/"
					+ this.bid);
		}
		if (bid.equals("bid4")) {
			this.bid = 4;
			window.playerLabel.setText("Bid: " + bidTakenPlayer + "/"
					+ this.bid);
		}
		if (bid.equals("bid5")) {
			this.bid = 5;
			window.playerLabel.setText("Bid: " + bidTakenPlayer + "/"
					+ this.bid);
		}
		if (bid.equals("bid6")) {
			this.bid = 6;
			window.playerLabel.setText("Bid: " + bidTakenPlayer + "/"
					+ this.bid);
		}
		if (bid.equals("bid7")) {
			this.bid = 7;
			window.playerLabel.setText("Bid: " + bidTakenPlayer + "/"
					+ this.bid);
		}
		if (bid.equals("bid8")) {
			this.bid = 8;
			window.playerLabel.setText("Bid: " + bidTakenPlayer + "/"
					+ this.bid);
		}
		if (bid.equals("bid9")) {
			this.bid = 9;
			window.playerLabel.setText("Bid: " + bidTakenPlayer + "/"
					+ this.bid);
		}
		if (bid.equals("bid10")) {
			this.bid = 10;
			window.playerLabel.setText("Bid: " + bidTakenPlayer + "/"
					+ this.bid);
		}
		if (bid.equals("bid11")) {
			this.bid = 11;
			window.playerLabel.setText("Bid: " + bidTakenPlayer + "/"
					+ this.bid);
		}
		if (bid.equals("bid12")) {
			this.bid = 12;
			window.playerLabel.setText("Bid: " + bidTakenPlayer + "/"
					+ this.bid);
		}
		if (bid.equals("bid13")) {
			this.bid = 13;
			window.playerLabel.setText("Bid: " + bidTakenPlayer + "/"
					+ this.bid);
		}

	}

	// reveals the player cards and adds mouse listeners to each card
	public void revealCards() {
		playerHand = playerSort();
		for (int i = playerHand.length - 1; i >= 0; i--) {
			cardsViewed[i][0] = playerHand[i][0];
			String a = playerHand[i][0] + "";
			cardsViewPlayer[i].setIcon(new ImageIcon("cards/" + a + ".png"));
			window.setVisible(true);
			window.repaint();
		}

		cardsViewPlayer[0].addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				playerClick(cardsViewed[0][0]);
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

		});
		cardsViewPlayer[1].addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				playerClick(cardsViewed[1][0]);
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

		});
		cardsViewPlayer[2].addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				playerClick(cardsViewed[2][0]);
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

		});
		cardsViewPlayer[3].addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				playerClick(cardsViewed[3][0]);
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

		});
		cardsViewPlayer[4].addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				playerClick(cardsViewed[4][0]);
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

		});
		cardsViewPlayer[5].addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				playerClick(cardsViewed[5][0]);
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

		});
		cardsViewPlayer[6].addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				playerClick(cardsViewed[6][0]);
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

		});
		cardsViewPlayer[7].addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				playerClick(cardsViewed[7][0]);
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

		});
		cardsViewPlayer[8].addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				playerClick(cardsViewed[8][0]);
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

		});
		cardsViewPlayer[9].addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				playerClick(cardsViewed[9][0]);
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

		});
		cardsViewPlayer[10].addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				playerClick(cardsViewed[10][0]);
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

		});
		cardsViewPlayer[11].addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				playerClick(cardsViewed[11][0]);
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

		});
		cardsViewPlayer[12].addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				playerClick(cardsViewed[12][0]);
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

		});
	}

	// sorts the cards in the player's hand
	public int[][] playerSort() {
		int currentMin = 0;
		int currentIndex = 0;
		for (int i = playerHand.length - 1; i >= 0; i--) {
			currentMin = 0;
			currentIndex = 0;
			for (int j = i; j >= 0; j--) {
				if (compareCards(playerHand[j][0], currentMin)) {
					currentMin = playerHand[j][0];
					currentIndex = j;
				}
			}

			if (currentIndex != i) {
				playerHand[currentIndex][0] = playerHand[i][0];
				playerHand[i][0] = currentMin;
			}
		}

		return playerHand;
	}

	public boolean compareCards(int a, int b) {
		if ((a - 1) % 4 == 0) {
			a *= 2600;
		} else if ((a - 2) % 4 == 0) {
			a *= 1;
		} else if ((a - 3) % 4 == 0) {
			a *= 51;
		} else {
			a *= 32000;
		}
		if ((b - 1) % 4 == 0) {
			b *= 2600;
		} else if ((b - 2) % 4 == 0) {
			b *= 1;
		} else if ((b - 3) % 4 == 0) {
			b *= 51;
		} else {
			b *= 32000;
		}

		return (a > b) ? true : false;
	}

	// starts the game
	public void startGame() {
		bidCountTeammate();
		bidCountOpponent1();
		bidCountOpponent2();
		revealCards();
		bidFrame();
	}

	// determines the bid teammate calls
	public void bidCountTeammate() {
		int clubsCount = 0;
		int spadesCount = 0;
		int heartsCount = 0;
		int diamondsCount = 0;

		for (int i = 0; i < teammateHand.length; i++) {
			if ((teammateHand[i][0] - 1) % 4 == 0) {
				clubsCount++;
			} else if ((teammateHand[i][0] - 2) % 4 == 0) {
				spadesCount++;
			} else if ((teammateHand[i][0] - 3) % 4 == 0) {
				heartsCount++;
			} else {
				diamondsCount++;
			}

			if (teammateHand[i][0] == 1 || teammateHand[i][0] == 2
					|| teammateHand[i][0] == 3 || teammateHand[i][0] == 4) {
				bidTeammate++;
			}

			if (teammateHand[i][0] == 5 || teammateHand[i][0] == 6
					|| teammateHand[i][0] == 7 || teammateHand[i][0] == 8) {
				bidTeammate++;
			}
		}
		if (heartsCount > 7 || diamondsCount > 7 || clubsCount > 7) {
			bidTeammate--;
		}
		if (spadesCount == 4) {
			bidTeammate++;
		}
		if (spadesCount == 5) {
			bidTeammate++;
		}
		if (spadesCount == 6) {
			bidTeammate += 3;
		}
		if (spadesCount == 7 || spadesCount == 8) {
			bidTeammate += 5;
		}
		if (spadesCount == 9 || spadesCount == 10) {
			bidTeammate += 7;
		}
		if (spadesCount == 11 || spadesCount == 12) {
			bidTeammate += 9;
		}
		if (spadesCount == 13) {
			bidTeammate += 13;
		}

		bidTeammate = (int) bidTeammate;
		if (bidTeammate < 0) {
			bidTeammate = 0;
		}

		if (turn == 1 || turn == 2)
			window.teammateLabel.setText("Bid: 0/" + bidTeammate);
	}

	// determines the bid opponent1 calls
	public void bidCountOpponent1() {
		int clubsCount = 0;
		int spadesCount = 0;
		int heartsCount = 0;
		int diamondsCount = 0;

		for (int i = 0; i < opponent1Hand.length; i++) {
			if ((opponent1Hand[i][0] - 1) % 4 == 0) {
				clubsCount++;
			} else if ((opponent1Hand[i][0] - 2) % 4 == 0) {
				spadesCount++;
			} else if ((opponent1Hand[i][0] - 3) % 4 == 0) {
				heartsCount++;
			} else {
				diamondsCount++;
			}

			if (opponent1Hand[i][0] == 1 || opponent1Hand[i][0] == 2
					|| opponent1Hand[i][0] == 3 || opponent1Hand[i][0] == 4) {
				bidOpponent1++;
			}

			if (opponent1Hand[i][0] == 5 || opponent1Hand[i][0] == 6
					|| opponent1Hand[i][0] == 7 || opponent1Hand[i][0] == 8) {
				bidOpponent1++;
			}
		}
		if (heartsCount > 7 || diamondsCount > 7 || clubsCount > 7) {
			bidOpponent1--;
		}
		if (spadesCount == 4) {
			bidOpponent1++;
		}
		if (spadesCount == 5) {
			bidOpponent1++;
		}
		if (spadesCount == 6) {
			bidOpponent1 += 3;
		}
		if (spadesCount == 7 || spadesCount == 8) {
			bidOpponent1 += 5;
		}
		if (spadesCount == 9 || spadesCount == 10) {
			bidOpponent1 += 7;
		}
		if (spadesCount == 11 || spadesCount == 12) {
			bidOpponent1 += 9;
		}
		if (spadesCount == 13) {
			bidOpponent1 += 13;
		}

		bidOpponent1 = (int) bidOpponent1;
		if (bidOpponent1 < 0) {
			bidOpponent1 = 0;
		}

		if (turn == 1)
			window.opponent1Label.setText("Bid: 0/" + bidOpponent1);
	}

	// determines the bid opponent2 calls
	public void bidCountOpponent2() {
		int clubsCount = 0;
		int spadesCount = 0;
		int heartsCount = 0;
		int diamondsCount = 0;

		for (int i = 0; i < opponent2Hand.length; i++) {
			if ((opponent2Hand[i][0] - 1) % 4 == 0) {
				clubsCount++;
			} else if ((opponent2Hand[i][0] - 2) % 4 == 0) {
				spadesCount++;
			} else if ((opponent2Hand[i][0] - 3) % 4 == 0) {
				heartsCount++;
			} else {
				diamondsCount++;
			}

			if (opponent2Hand[i][0] == 1 || opponent2Hand[i][0] == 2
					|| opponent2Hand[i][0] == 3 || opponent2Hand[i][0] == 4) {
				bidOpponent2++;
			}

			if (opponent2Hand[i][0] == 5 || opponent2Hand[i][0] == 6
					|| opponent2Hand[i][0] == 7 || opponent2Hand[i][0] == 8) {
				bidOpponent2++;
			}
		}
		if (heartsCount > 7 || diamondsCount > 7 || clubsCount > 7) {
			bidOpponent2--;
		}
		if (spadesCount == 4) {
			bidOpponent2++;
		}
		if (spadesCount == 5) {
			bidOpponent2++;
		}
		if (spadesCount == 6) {
			bidOpponent2 += 3;
		}
		if (spadesCount == 7 || spadesCount == 8) {
			bidOpponent2 += 5;
		}
		if (spadesCount == 9 || spadesCount == 10) {
			bidOpponent2 += 7;
		}
		if (spadesCount == 11 || spadesCount == 12) {
			bidOpponent2 += 9;
		}
		if (spadesCount == 13) {
			bidOpponent2 += 13;
		}

		bidOpponent2 = (int) bidOpponent2;
		if (bidOpponent2 < 0) {
			bidOpponent2 = 0;
		}

		if (turn >= 1)
			window.opponent2Label.setText("Bid: 0/" + bidOpponent2);
	}

	// determines the card played if teammate goes first
	public void teammateGo() {
		int index = 0;
		for (int i = 0; i < teammateHand.length; i++) {
			if (teammateHand[i][0] == 1 || teammateHand[i][0] == 2
					|| teammateHand[i][0] == 3 || teammateHand[i][0] == 4) {
				index = i;
				break;
			}

			else if (teammateHand[i][0] == 5 || teammateHand[i][0] == 6
					|| teammateHand[i][0] == 7 || teammateHand[i][0] == 8) {
				index = i;
				break;
			} else if (teammateHand[i][0] > 0) {
				index = i;
				break;
			}

		}
		cardsOut++;
		int a = teammateHand[index][0];
		teammateHand[index][0] = 0;
		currentCards[noTurn][0] = a;
		currentCards[noTurn][1] = 2;
		window.teammatePanelCards.remove(cardsViewTeammate[index]);
		cardsViewTeammateField.setIcon(new ImageIcon("cards/" + a + ".png"));
		window.teammatePanelField.add(cardsViewTeammateField);
		window.setVisible(true);
		window.repaint();
		move("opponent2");
	}

	// determines the card played if opponent1 goes first
	public void opponent1Go() {
		int index = 0;
		for (int i = 0; i < opponent1Hand.length; i++) {
			if (opponent1Hand[i][0] == 1 || opponent1Hand[i][0] == 2
					|| opponent1Hand[i][0] == 3 || opponent1Hand[i][0] == 4) {
				index = i;
				break;
			}

			else if (opponent1Hand[i][0] == 5 || opponent1Hand[i][0] == 6
					|| opponent1Hand[i][0] == 7 || opponent1Hand[i][0] == 8) {
				index = i;
				break;
			}

			else if (opponent1Hand[i][0] > 0) {
				index = i;
				break;
			}

		}
		cardsOut++;
		int a = opponent1Hand[index][0];
		opponent1Hand[index][0] = 0;
		currentCards[noTurn][0] = a;
		currentCards[noTurn][1] = 3;
		window.opponent1PanelCards.remove(cardsViewOpponent1[index]);
		cardsViewOpponent1Field.setIcon(new ImageIcon("cards/" + a + ".png"));
		window.opponent1PanelField.add(cardsViewOpponent1Field);
		window.setVisible(true);
		window.repaint();
		move("teammate");
	}

	// determines the card played if opponent2 goes first
	public void opponent2Go() {
		int index = 0;
		for (int i = 0; i < opponent2Hand.length; i++) {
			if (opponent2Hand[i][0] == 1 || opponent2Hand[i][0] == 2
					|| opponent2Hand[i][0] == 3 || opponent2Hand[i][0] == 4) {
				index = i;
				break;
			}

			else if (opponent2Hand[i][0] == 5 || opponent2Hand[i][0] == 6
					|| opponent2Hand[i][0] == 7 || opponent2Hand[i][0] == 8) {
				index = i;
				break;
			}

			else if (opponent2Hand[i][0] > 0) {
				index = i;
				break;
			}

		}
		cardsOut++;
		int a = opponent2Hand[index][0];
		opponent2Hand[index][0] = 0;
		currentCards[noTurn][0] = a;
		currentCards[noTurn][1] = 4;
		window.opponent2PanelCards.remove(cardsViewOpponent2[index]);
		cardsViewOpponent2Field.setIcon(new ImageIcon("cards/" + a + ".png"));
		window.opponent2PanelField.add(cardsViewOpponent2Field);
		window.setVisible(true);
		window.repaint();
		move("player");
	}

	// the action performed due to a player click
	public void playerClick(int a) {
		int suit;
		boolean hasCard = false;
		if (playerGoFirst) {
			for (int i = 0; i < playerHand.length; i++) {
				if (playerHand[i][0] == a) {
					playerGoFirst = false;
					cardsOut++;
					currentCards[noTurn][0] = playerHand[i][0];
					currentCards[noTurn][1] = 1;
					window.playerPanelCards.remove(cardsViewPlayer[i]);
					cardsViewPlayerField.setIcon(new ImageIcon("cards/" + a
							+ ".png"));
					playerHand[i][0] = 0;
					window.playerPanelField.add(cardsViewPlayerField);
					window.setVisible(true);
					window.repaint();
					break;

				}
			}
			move("opponent1");

		} else if (playerGo) {
			if ((currentCards[0][0] - 1) % 4 == 0)
				suit = 1;
			else if ((currentCards[0][0] - 2) % 4 == 0)
				suit = 2;
			else if ((currentCards[0][0] - 3) % 4 == 0)
				suit = 3;
			else
				suit = 4;

			for (int i = 0; i < playerHand.length; i++) {
				if (((playerHand[i][0] - suit) % 4 == 0)
						&& (playerHand[i][0] > 0))
					hasCard = true;
			}

			if (hasCard) {
				if ((a - suit) % 4 == 0) {
					for (int i = 0; i < playerHand.length; i++) {
						if (playerHand[i][0] == a) {
							playerGo = false;
							cardsOut++;
							currentCards[noTurn][0] = playerHand[i][0];
							currentCards[noTurn][1] = 1;
							window.playerPanelCards.remove(cardsViewPlayer[i]);
							cardsViewPlayerField.setIcon(new ImageIcon("cards/"
									+ a + ".png"));
							playerHand[i][0] = 0;
							window.playerPanelField.add(cardsViewPlayerField);
							window.setVisible(true);
							window.repaint();
							break;

						}
					}

					move("opponent1");

				} else {
					JFrame frame = new JFrame();
					JOptionPane.showMessageDialog(frame,
							"You Must Place a Card of the Same Suit.", "Error",
							JOptionPane.WARNING_MESSAGE);
				}
			}

			else if (!hasCard) {
				for (int i = 0; i < playerHand.length; i++) {
					if (playerHand[i][0] == a) {
						playerGo = false;
						cardsOut++;
						currentCards[noTurn][0] = playerHand[i][0];
						currentCards[noTurn][1] = 1;
						window.playerPanelCards.remove(cardsViewPlayer[i]);
						cardsViewPlayerField.setIcon(new ImageIcon("cards/" + a
								+ ".png"));
						playerHand[i][0] = 0;
						window.playerPanelField.add(cardsViewPlayerField);
						window.setVisible(true);
						window.repaint();
						break;

					}
				}

				move("opponent1");
			}
		}
	}

	// method used to allow player to go
	public void playerGo() {
		boolean a = true;
		for(int i = 0; i < playerHand.length; i++){
			if(playerHand[i][0] != 0)
				a = false;
		}
		
		if(a){
			moves = 14;
			move("p");
		} else
			playerGo = true;
	}

	public void playerGoFirst() {
		playerGoFirst = true;
	}

	// method used to find card of the same suit as the first card played
	public int sameSuit(int[][] array) {
		int index = -1;
		int mod = currentCards[0][0] % 4;
		for (int i = 0; i < array.length; i++) {
			if (((array[i][0] - mod) % 4 == 0) && (array[i][0] > 0)) {
				index = i;
				break;
			}
		}
		return index;
	}

	// method used to find a spade in hand
	public int spade(int[][] array) {
		int index = -1;
		for (int i = 0; i < array.length; i++) {
			if ((array[i][0] - 2) % 4 == 0) {
				index = i;
				break;
			}
		}
		return index;
	}

	// method used to find the smallest card in a hand
	public int anySmallCard(int[][] array) {
		int index = -1;
		int currentMin = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i][0] > currentMin) {
				currentMin = array[i][0];
				index = i;
			}
		}
		return index;
	}

	// method used to find the last card in hand
	public int lastCard(int[][] array) {
		int index = -1;
		for (int i = 0; i < array.length; i++) {
			if (array[i][0] > 0) {
				index = i;
				break;
			}
		}
		return index;
	}

	// determines the card to play after the first has already been played for
	// teammate
	public void teammateContinue() {
		int index;
		if (sameSuit(teammateHand) != -1) {
			index = sameSuit(teammateHand);
		} else if (spade(teammateHand) != -1) {
			index = spade(teammateHand);
		} else if (anySmallCard(teammateHand) != -1) {
			index = anySmallCard(teammateHand);
		} else {
			index = lastCard(teammateHand);
		}
		cardsOut++;
		int a = teammateHand[index][0];
		teammateHand[index][0] = 0;
		currentCards[noTurn][0] = a;
		currentCards[noTurn][1] = 2;
		window.teammatePanelCards.remove(cardsViewTeammate[index]);
		cardsViewTeammateField.setIcon(new ImageIcon("cards/" + a + ".png"));
		window.teammatePanelField.add(cardsViewTeammateField);
		window.setVisible(true);
		window.repaint();
		move("opponent2");
	}

	// determines the card to play after the first has already been played for
	// opponent1
	public void opponent1Continue() {
		int index;
		if (sameSuit(opponent1Hand) != -1) {
			index = sameSuit(opponent1Hand);
		} else if (spade(opponent1Hand) != -1) {
			index = spade(opponent1Hand);
		} else if (anySmallCard(opponent1Hand) != -1) {
			index = anySmallCard(opponent1Hand);
		} else {
			index = lastCard(opponent1Hand);
		}
		cardsOut++;
		int a = opponent1Hand[index][0];
		opponent1Hand[index][0] = 0;
		currentCards[noTurn][0] = a;
		currentCards[noTurn][1] = 3;
		window.opponent1PanelCards.remove(cardsViewOpponent1[index]);
		cardsViewOpponent1Field.setIcon(new ImageIcon("cards/" + a + ".png"));
		window.opponent1PanelField.add(cardsViewOpponent1Field);
		window.setVisible(true);
		window.repaint();
		move("teammate");
	}

	// determines the card to play after the first has already been played for
	// opponent2
	public void opponent2Continue() {
		int index;
		if (sameSuit(opponent2Hand) != -1) {
			index = sameSuit(opponent2Hand);
		} else if (spade(opponent2Hand) != -1) {
			index = spade(opponent2Hand);
		} else if (anySmallCard(opponent2Hand) != -1) {
			index = anySmallCard(opponent2Hand);
		} else {
			index = lastCard(opponent2Hand);
		}
		cardsOut++;
		int a = opponent2Hand[index][0];
		opponent2Hand[index][0] = 0;
		currentCards[noTurn][0] = a;
		currentCards[noTurn][1] = 4;
		window.opponent2PanelCards.remove(cardsViewOpponent2[index]);
		cardsViewOpponent2Field.setIcon(new ImageIcon("cards/" + a + ".png"));
		window.opponent2PanelField.add(cardsViewOpponent2Field);
		window.setVisible(true);
		window.repaint();
		move("player");
	}

	// determines the next move after a card is played
	public void move(String a) {
		noTurn++;
		if (moves == 14) {
			if ((turn + 1) > 3)
				turn = 0;
			else {
				turn += 1;
			}
			scorePlayer += getScorePlayer() + getScoreTeammate()
					+ getPlayerBags();
			scoreOpponent += getScoreOpponent1() + getScoreOpponent2()
					+ getOpponentBags();
			window.dispose();
			new Game();

		}

		else if (noTurn == 4) {
			for (int i = 0; i < currentCards.length; i++) {
				cardsRemoved[cardsOut - i - 1][0] = currentCards[i][0];
			}
			timer.start();
		} else {
			if (a.equals("player"))
				playerGo();
			else if (a.equals("teammate"))
				teammateContinue();
			else if (a.equals("opponent1"))
				opponent1Continue();
			else {
				opponent2Continue();
			}
		}
	}

	// begins a new turn
	public void newTurn() {
		noTurn = 0;
		moves++;
		int[][] array = new int[4][2];
		window.playerPanelField.remove(cardsViewPlayerField);
		window.teammatePanelField.remove(cardsViewTeammateField);
		window.opponent1PanelField.remove(cardsViewOpponent1Field);
		window.opponent2PanelField.remove(cardsViewOpponent2Field);
		window.setVisible(true);
		window.repaint();
		int player = max(currentCards);
		if (player == 1) {
			currentCards = array;
			bidTakenPlayer++;
			window.playerLabel.setText("Bid: " + bidTakenPlayer + "/" + bid);
			window.setVisible(true);
			window.repaint();
			playerGoFirst();
		} else if (player == 2) {
			currentCards = array;
			bidTakenTeammate++;
			window.teammateLabel.setText("Bid: " + bidTakenTeammate + "/"
					+ bidTeammate);
			window.setVisible(true);
			window.repaint();
			teammateGo();
		} else if (player == 3) {
			currentCards = array;
			bidTakenOpponent1++;
			window.opponent1Label.setText("Bid: " + bidTakenOpponent1 + "/"
					+ bidOpponent1);
			window.setVisible(true);
			window.repaint();
			opponent1Go();
		} else {
			currentCards = array;
			bidTakenOpponent2++;
			window.opponent2Label.setText("Bid: " + bidTakenOpponent2 + "/"
					+ bidOpponent2);
			window.setVisible(true);
			window.repaint();
			opponent2Go();
		}
	}

	// checks for the max card in play based on the first suit and calls the max
	// spade method
	public int max(int[][] array) {
		int a = array[0][0] % 4;
		int currentMax = array[0][0];
		int index = 0;
		;
		if (maxSpades(array) != -1) {
			index = maxSpades(array);
		} else {
			for (int i = 0; i < array.length; i++) {
				if ((array[i][0] - a) % 4 == 0) {
					if (array[i][0] < currentMax) {
						currentMax = array[i][0];
						index = i;
					}
				}
			}
		}

		return array[index][1];
	}

	// checks for the max spade suit currently played, if none returns -1
	public int maxSpades(int[][] array) {
		int currentMax = 54;
		int index = -1;
		for (int i = 0; i < array.length; i++) {
			if ((array[i][0] - 2) % 4 == 0) {
				if (array[i][0] < currentMax) {
					currentMax = array[i][0];
					index = i;
				}
			}
		}
		return index;
	}

	// gets score after end of round for player
	public int getScorePlayer() {
		if (bidTakenPlayer >= bid) {
			if (bid == 0) {
				if (bidTakenPlayer == 0)
					return 100;
				else {
					playerBags += bidTakenPlayer - (int) bid;
					return -100;
				}
			} else {
				playerBags += bidTakenPlayer - (int) bid;
				return bid * 10 + (bidTakenPlayer - (int) bid);
			}
		} else {
			return -bid * 10;
		}

	}

	// gets score after end of round for teammate
	public int getScoreTeammate() {
		if (bidTakenTeammate >= bidTeammate) {
			if (bidTeammate == 0) {
				if (bidTakenTeammate == 0)
					return 100;
				else {
					playerBags += bidTakenTeammate - (int) bidTeammate;
					return -100;
				}
			} else {
				playerBags += bidTakenTeammate - (int) bidTeammate;
				return (int) bidTeammate * 10
						+ (bidTakenTeammate - (int) bidTeammate);
			}
		} else {
			return (int) -bidTeammate * 10;
		}
	}

	// gets score after end of round for opponent1
	public int getScoreOpponent1() {
		if (bidTakenOpponent1 >= bidOpponent1) {
			if (bid == 0) {
				if (bidTakenOpponent1 == 0)
					return 100;
				else {
					opponentBags += bidTakenOpponent1 - (int) bidOpponent1;
					return -100;
				}
			} else {
				opponentBags += bidTakenOpponent1 - (int) bidOpponent1;
				return (int) bidOpponent1 * 10
						+ (bidTakenOpponent1 - (int) bidOpponent1);
			}
		} else {
			return (int) -bidOpponent1 * 10;
		}
	}

	// gets score after end of round for opponent2
	public int getScoreOpponent2() {
		if (bidTakenOpponent2 >= bidOpponent2) {
			if (bidOpponent2 == 0) {
				if (bidTakenOpponent2 == 0)
					return 100;
				else {
					opponentBags += bidTakenOpponent2 - (int) bidOpponent2;
					return -100;
				}
			} else {
				opponentBags += bidTakenOpponent2 - (int) bidOpponent2;
				return (int) bidOpponent2 * 10
						+ (bidTakenOpponent2 - (int) bidOpponent2);
			}
		} else {
			return (int) -bidOpponent2 * 10;
		}
	}

	// decreases score of player if more than 10 bags
	public int getPlayerBags() {
		if (playerBags >= 10) {
			playerBags = playerBags - 10;
			return -100;
		} else
			return 0;
	}

	// decreases score of opponent if more than 10 bags
	public int getOpponentBags() {
		if (opponentBags >= 10) {
			opponentBags = opponentBags - 10;
			return -100;
		} else
			return 0;
	}

	// action for delay in new turns
	@Override
	public void actionPerformed(ActionEvent arg0) {
		newTurn();
		timer.stop();

	}
}