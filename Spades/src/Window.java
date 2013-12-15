import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class Window extends JFrame {
	JPanel playerPanel, teammatePanel, opponent1Panel, opponent2Panel,
			panelBottom, panelTop, panelMiddle, playerBid, teammateBid,
			opponent1Bid, opponent2Bid, playerPanelCards, teammatePanelCards,
			opponent1PanelCards, opponent2PanelCards, playerPanelField,
			teammatePanelField, opponent1PanelField, opponent2PanelField;
	JButton bid0, bid1, bid2, bid3, bid4, bid5, bid6, bid7, bid8, bid9, bid10,
			bid11, bid12, bid13, bid;
	JLabel playerLabel, teammateLabel, opponent1Label, opponent2Label,
			playerScoreLabel, opponentScoreLabel, playerBagsLabel,
			opponentBagsLabel;

	// constructor for the Window class used to create the GUI
	public Window(int x, int y) {
		this.setSize(x, y);
		this.setLayout(new GridLayout(2, 1));
		playerPanel = new JPanel();
		teammatePanel = new JPanel();
		opponent1Panel = new JPanel();
		opponent2Panel = new JPanel();
		playerPanelCards = new JPanel();
		teammatePanelCards = new JPanel();
		opponent1PanelCards = new JPanel();
		opponent2PanelCards = new JPanel();
		playerPanelField = new JPanel();
		teammatePanelField = new JPanel();
		opponent1PanelField = new JPanel();
		opponent2PanelField = new JPanel();
		playerBid = new JPanel();
		teammateBid = new JPanel();
		opponent1Bid = new JPanel();
		opponent2Bid = new JPanel();
		panelBottom = new JPanel();
		panelTop = new JPanel();
		playerLabel = new JLabel();
		teammateLabel = new JLabel();
		opponent1Label = new JLabel();
		opponent2Label = new JLabel();
		playerScoreLabel = new JLabel();
		opponentScoreLabel = new JLabel();
		playerBagsLabel = new JLabel();
		opponentBagsLabel = new JLabel();
		bid0 = new JButton("0");
		bid1 = new JButton("1");
		bid2 = new JButton("2");
		bid3 = new JButton("3");
		bid4 = new JButton("4");
		bid5 = new JButton("5");
		bid6 = new JButton("6");
		bid7 = new JButton("7");
		bid8 = new JButton("8");
		bid9 = new JButton("9");
		bid10 = new JButton("10");
		bid11 = new JButton("11");
		bid12 = new JButton("12");
		bid13 = new JButton("13");
		bid = new JButton("ok");
		playerPanel.setLayout(new GridLayout(2, 0));
		teammatePanel.setLayout(new GridLayout(2, 0));
		opponent1Panel.setLayout(new GridLayout(2, 0));
		opponent2Panel.setLayout(new GridLayout(2, 0));
		playerPanelCards.setLayout(new FlowLayout());
		playerPanelField.setLayout(new GridLayout(2, 0));
		teammatePanelField.setLayout(new GridLayout(2, 0));
		opponent1PanelField.setLayout(new GridLayout(2, 0));
		opponent2PanelField.setLayout(new GridLayout(2, 0));
		panelBottom.setLayout(new GridLayout(0, 2));
		panelTop.setLayout(new GridLayout(0, 2));
		panelBottom.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		panelTop.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		playerBid.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		teammateBid.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		opponent1Bid.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		opponent2Bid.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		playerPanel.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		teammatePanel.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		opponent1Panel.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		opponent2Panel.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		playerPanelCards.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		teammatePanelCards.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		opponent1PanelCards.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		opponent2PanelCards.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		playerPanelField.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		teammatePanelField.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		opponent1PanelField.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		opponent2PanelField.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		playerPanel.add(playerPanelField);
		teammatePanel.add(teammatePanelCards);
		opponent1Panel.add(opponent1PanelField);
		opponent2Panel.add(opponent2PanelCards);
		playerPanel.add(playerPanelCards);
		teammatePanel.add(teammatePanelField);
		opponent1Panel.add(opponent1PanelCards);
		opponent2Panel.add(opponent2PanelField);
		playerPanelField.add(playerBid);
		teammatePanelField.add(teammateBid);
		opponent1PanelField.add(opponent1Bid);
		opponent2PanelField.add(opponent2Bid);
		playerBid.add(playerLabel);
		teammateBid.add(teammateLabel);
		opponent1Bid.add(opponent1Label);
		opponent2Bid.add(opponent2Label);
		teammateBid.add(playerScoreLabel);
		opponent2Bid.add(opponentScoreLabel);
		teammateBid.add(playerBagsLabel);
		opponent2Bid.add(opponentBagsLabel);
		panelTop.add(teammatePanel);
		panelTop.add(opponent2Panel);
		panelBottom.add(opponent1Panel);
		panelBottom.add(playerPanel);
		this.add(panelTop);
		this.add(panelBottom);
		setVisible(true);
		repaint();
	}
}
