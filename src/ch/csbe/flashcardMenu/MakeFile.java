package ch.csbe.flashcardMenu;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MakeFile extends DefaultFrame implements ActionListener {

	private static final long serialVersionUID = -4512196930678893470L;
	
	private JLabel label = new JLabel("<html><p>there is a tutorial in the directory you just created. Do Not Move That Directory! The Load File Containes the Path to your Card set.<p/><html/>");
	
	private JFrame Container = new JFrame();
	private JButton b1 = new JButton("Add The Card");
	private JTextField text = new JTextField("Name of the card");
	/**
	 * A Frame that has Text
	 */
	public MakeFile() {
		this.add(label, BorderLayout.PAGE_START);
		
		this.b1.addActionListener(this);
		this.Container.add(b1, BorderLayout.LINE_END);
		this.Container.add(text, BorderLayout.CENTER);
		this.add(Container, BorderLayout.PAGE_END);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
}
