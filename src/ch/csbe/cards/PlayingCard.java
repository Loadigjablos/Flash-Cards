package ch.csbe.cards;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ch.csbe.flashcardMenu.DefaultFrame;
import ch.csbe.flashcardMenu.Gamestart;
import ch.csbe.flashcardMenu.InterimDisplay;

public class PlayingCard extends DefaultFrame implements ActionListener {

	private static final long serialVersionUID = 1060351151648035167L;
	
	private int whatCard; // What card should be Played

	private JPanel bottomContainer = new JPanel(); 
	private JTextField textField = new JTextField();
	private JButton button = new JButton("Confirm");
	
	private JLabel question; // If the instance is a TextCard, this will be used
	
	private BufferedImage img; // If the instance is a ImgCard, this will be used
	
	/*
	 * If the instance is a AudioCard, this will be used
	 */
	private JButton audioButton; // to play the sound
	Clip clip; // this will be The Audio Clip
	AudioInputStream stream; // a way to the Speakers
	
	/**
	 * This makes a Screen that can have either a Image, Audio or Text depending on the Instance.
	 * @param whatCard the Instance that will be used
	 */
	public PlayingCard(int whatCard) {
		this.whatCard = whatCard;
		this.bottomContainer.setLayout(new BorderLayout());
		this.bottomContainer.add(textField, BorderLayout.CENTER);
		this.bottomContainer.add(button, BorderLayout.LINE_END);
		this.add(bottomContainer, BorderLayout.PAGE_END);
		this.button.addActionListener(this);
		this.textField.addActionListener(this);
		this.revalidate();
		/*
		 * depending on the card Instance this will add either a text, a image or a button for sound the screen
		 */
		if (!(Gamestart.cardStack.get(whatCard).getQuestion().equals(""))) {
			question = new JLabel("<html> <p>" + Gamestart.cardStack.get(whatCard).getQuestion() + "<p/> <html/>");
			question.setFont(new Font("Verdana", Font.PLAIN, 30));
			this.add(question, BorderLayout.CENTER);
		} else if (!(Gamestart.cardStack.get(whatCard).getPathtoImg().equals(""))) {
			JLabel imageLabel = new JLabel("", JLabel.CENTER);
			this.add(imageLabel, BorderLayout.CENTER);
			try {
				img = ImageIO.read(new File(Gamestart.cardStack.get(whatCard).getPathtoImg()));
				imageLabel.setIcon(new ImageIcon(img));
				this.add(imageLabel);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if (!(Gamestart.cardStack.get(whatCard).getPathtoAudio().equals(""))) {
			audioButton = new JButton("Play Sound");
			this.add(audioButton, BorderLayout.CENTER);
			this.audioButton.addActionListener(this);
		}
	}
	/**
	 * Button or Text Field event
	 */
	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getSource().equals(this.button) || event.getSource().equals(this.textField)) {
			this.setVisible(false);
			if (this.textField.getText().equals(Gamestart.cardStack.get(whatCard).getAnswer())) {
				Gamestart.cardStack.get(whatCard).setDone(true);
				InterimDisplay win = new InterimDisplay(true);
			} else {
				Gamestart.fails++;
				InterimDisplay loss = new InterimDisplay(false);
			}
			
		} else if (event.getSource().equals(this.audioButton)) {
			
			File file = new File(Gamestart.cardStack.get(whatCard).getPathtoAudio());
			try {
				this.clip = AudioSystem.getClip();
				try {
					this.stream = AudioSystem.getAudioInputStream(file);
					this.clip.open(this.stream);
					this.clip.start();
				} catch (UnsupportedAudioFileException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} catch (LineUnavailableException e) {
				e.printStackTrace();
			}
		}
	}
}
