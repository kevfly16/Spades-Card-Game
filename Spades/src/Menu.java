import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Menu extends JFrame {
	
	JPanel panel;
	JPanel titlePanel;
	JPanel newGamePanel;
	JPanel helpPanel;
	JPanel blank;
	JPanel blank1;
	JButton newGame;
	JButton help;
	JLabel title;

	public Menu() {
		setSize(1375,735);
		panel = new JPanel();
		titlePanel = new JPanel();
		newGamePanel = new JPanel();
		helpPanel = new JPanel();
		blank = new JPanel();
		newGame = new JButton("New Game");
		help = new JButton("Help");
		title = new JLabel();
		panel.setLayout(new GridLayout(4,0));
		panel.add(titlePanel);
		panel.add(blank);
		panel.add(newGamePanel);
		panel.add(helpPanel);
		newGamePanel.add(newGame);
		helpPanel.add(help);
		titlePanel.add(title);
		title.setText("Spades");
		title.setFont(new Font("Serif", Font.PLAIN, 100));
		add(panel);
		setVisible(true);
		repaint();
		
		newGame.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new Game();
			}
			
		});
		
		help.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new Help();
			}
			
		});
	}
}
