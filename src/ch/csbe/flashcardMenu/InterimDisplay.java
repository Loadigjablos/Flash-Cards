package ch.csbe.flashcardMenu;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

public class InterimDisplay extends DefaultFrame implements ActionListener {
	
	private static final long serialVersionUID = 6182644439617769554L;

	private JButton button = new JButton("Continue");
	/** 
	 * Just a Normal JFrame.
	 * @param winOrLoss Wenn this is true the user won and the label "Congrats" will be added, if he lost the panel will show that he lost.
	 */
	public InterimDisplay(boolean winOrLoss) {
		this.add(button, BorderLayout.PAGE_END);
		this.button.addActionListener(this);
		
		if (winOrLoss == true) {
			JLabel label = new JLabel("Congrats");
			this.add(label, BorderLayout.CENTER);
		} else {
			JLabel label = new JLabel("Next Time you got it");
			this.add(label, BorderLayout.CENTER);
		}
	}
	/**
	 * if button is pressed, event will happen.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		this.setVisible(false);
		Gamestart.playTheCards();
	}
	
}
