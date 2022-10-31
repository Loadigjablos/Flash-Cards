package ch.csbe.flashcardMenu;

import java.awt.BorderLayout;

import javax.swing.JLabel;

public class EndScreen extends DefaultFrame {

	private static final long serialVersionUID = -1414187133526687625L;
	
	private JLabel theEnd = new JLabel();
	/**
	 * Depending if the user did things right or wrong. This will show you how well you've done.
	 */
	public EndScreen() {
		this.theEnd.setText("You Failed " + Gamestart.fails + " Out of " + Gamestart.cardStack.size() + " Cards");
		this.add(theEnd, BorderLayout.CENTER);
		if (Gamestart.fails > (Gamestart.cardStack.size() / 3)) {
			JLabel bad = new JLabel("Next Time you got it");
			this.add(bad, BorderLayout.LINE_END);
		} else {
			JLabel good = new JLabel("Congrats");
			this.add(good, BorderLayout.LINE_END);
		}
		this.add(theEnd);
	}
}
