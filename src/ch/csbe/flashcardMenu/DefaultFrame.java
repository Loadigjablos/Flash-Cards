package ch.csbe.flashcardMenu;

import javax.swing.JFrame;
/**
 * 
 * @author dominic
 */
public class DefaultFrame extends JFrame {

	private static final long serialVersionUID = 3911742967161339887L;
	/**
	 * This is to Configure all Screens
	 */
	public DefaultFrame() {
		this.setSize(700, 500);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit out of application
	}
}
