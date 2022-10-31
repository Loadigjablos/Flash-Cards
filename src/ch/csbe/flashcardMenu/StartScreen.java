package ch.csbe.flashcardMenu;

import java.awt.BorderLayout;
import java.awt.FileDialog;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.*;

public class StartScreen extends DefaultFrame implements ActionListener {
	
	private static final long serialVersionUID = -4984059755573943238L;
	
	private JButton buttonStart = new JButton("Play");
	private JButton buttonload = new JButton("Create");
	private JLabel label = new JLabel("<html> <p>Do You want to Create a Flashcard Set, or do You want to choose a Flashcard Set<p/> <html/>");
	private JPanel panel = new JPanel();
	/**
	 * Adds buttons an labels to the JFrame 
	 */
	public StartScreen() {
		label.setFont(new Font("Verdana", Font.PLAIN, 30));
		this.panel.setLayout(new FlowLayout());
		this.panel.add(buttonStart, BorderLayout.LINE_START);
		this.panel.add(buttonload, BorderLayout.LINE_END);
		this.add(panel, BorderLayout.PAGE_END);
		this.add(label, BorderLayout.CENTER);
		this.buttonStart.addActionListener(this);
		this.buttonload.addActionListener(this);
		this.revalidate();
	}
	/**
	 * The user can choose where he wants his Game Files
	 */
	public void makeFile() {
		FileDialog chooser = new FileDialog(this);
		chooser.setMode(FileDialog.SAVE);
		chooser.setVisible(true);
		File[] selectedFile = chooser.getFiles();
		/*
		 * To check if he choose a File
		 */
		if (selectedFile.length > 0) {
			/*
			 * Makes Important directory's
			 */
			File file = selectedFile[0];
			file.mkdir();
			File Card = new File(file.getAbsolutePath(), "1");
			Card.mkdir();
			try {
				/*
				 * Makes Important Files
				 */
				File makeLoadFile = new File(file, "load.txt");
				File makeTutorialFile = new File(file, "Tutorial.txt");
				File makeQuestionFile = new File(Card, "F.txt");
				File makeAnswerFile = new File(Card, "L.txt");
				FileWriter writer1 = new FileWriter(makeLoadFile);
				writer1.write(file.getAbsolutePath());
				writer1.close();
				FileWriter writer2 = new FileWriter(makeQuestionFile);
				writer2.write("What does a Vacume Cleaner do?");
				writer2.close();
				FileWriter writer3 = new FileWriter(makeAnswerFile);
				writer3.write("Suck");
				writer3.close();
				FileWriter writer4 = new FileWriter(makeTutorialFile);
				writer4.write("Every Card is a Directory, you can make a Directory inside this directory, Do Not Move The Directory!\n The answer File is 'L.txt'. the Question can be either 'F.png', 'F.wav' or 'F.txt'. There can be Problems if a File is empty");
				writer4.write("\n hello");
				writer4.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			DefaultFrame makeFile = new MakeFile();
			this.setVisible(false);
		} else {
			JOptionPane.showMessageDialog(this, "Unsuccsesful", " ", JOptionPane.ERROR_MESSAGE);
		}
	}
	/**
	 * The User will choose a file that will have a path to a directory
	 */
	public void getFile() {
		FileDialog chooser = new FileDialog(this);
		chooser.setMode(FileDialog.LOAD);
		chooser.setVisible(true);
		File[] selectedFile = chooser.getFiles();
		if (selectedFile.length > 0) {
			try {
				File file = selectedFile[0];
				if (file.getName().equals("load.txt")) {
					Scanner reader = new Scanner(file);
					this.setVisible(false);
					String Container = reader.nextLine();
					reader.close();
					Gamestart newGame = new Gamestart(Container);
				} else {
					JOptionPane.showMessageDialog(this, "Not a Load File!", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * Action Event when a button is Pressed
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(this.buttonStart)) {
			getFile();
		} else if (e.getSource().equals(this.buttonload)) {
			makeFile();
		}
	}
}
