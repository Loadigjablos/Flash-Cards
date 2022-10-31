package ch.csbe.flashcardMenu;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JOptionPane;

import ch.csbe.cards.*;

public class Gamestart {
	/*
	 * To get a Random number
	 */
	static Random random = new Random(1);
	/*
	 * All the cards will be there
	 */
	public static ArrayList<Card> cardStack = new ArrayList<Card>();
	/*
	 * How many times the user did a wrong input in the Flash card game
	 */
	public static int fails = 0;
	/**
	 * Here it adds real files into objects, Also the game will start
	 * @param container is the root file of the whole card game
	 */
	public Gamestart(String container) {
		boolean succsesful = true;
		/*
		 * it tries to add file information into Instances
		 */
		try {
			File dir = new File(container);
			File[] selectedFile = dir.listFiles();
			for (int i = 0; i < selectedFile.length; i++) {
				if (selectedFile[i].isFile()) {
					continue;
				}
				File[] dirInsides = selectedFile[i].listFiles();
				
				String answer = "";
				String pathToImg = "";
				String pathToAudio = "";
				String question = "";
				
				for (int x = 0; x < dirInsides.length; x++) {
					String cheek = dirInsides[x].getAbsolutePath();
					
					if (cheek.endsWith("F.png")) {
						pathToImg = cheek;
					} else if (cheek.endsWith("F.txt")) {
						File file = new File(cheek);
						question = readTheFile(file);
					}  else if (cheek.endsWith("F.wav")) {
						pathToAudio = cheek;
					} else if (cheek.endsWith("L.txt")) {
						File file = new File(cheek);
						answer = readTheFile(file);
					}
				}
				/*
				 * after its done reading the Directory. It will 
				 */
				if (!answer.equals("")) {
					if (!pathToImg.equals("")) {
						cardStack.add(new ImgCard(pathToImg, answer));
					} else if (!pathToAudio.equals("")) {
						cardStack.add(new AudioCard(pathToAudio, answer));
					} else if (!question.equals("")) {
						cardStack.add(new TextCard(question, answer));
					}
				}
			}
		} catch(Exception e) {
			succsesful = false;
		}
		if (succsesful == true) {
			playTheCards();
		} else {
			JOptionPane.showMessageDialog(null, "There has been a Problem! Cheek if there are empty Files! or you choose the right load File!");
			DefaultFrame startMenu = new StartScreen();
		}
	}
	/**
	 * This goes trough all the Instances that have the Variable Done to false.
	 * If the user Answer the card correctly the Variable Done goes to true.
	 */
	public static void playTheCards() {		
		boolean isThereaCard = false;
		for (int x = 0; x < cardStack.size(); x++) {
			if (cardStack.get(x).isDone() == false) {
				isThereaCard = true;
			}
		}
		if(isThereaCard == true) {
			boolean alredyUp = false;
			int randomNummber = random.nextInt(0, cardStack.size());
			if (cardStack.get(randomNummber).isDone() == false) {
				PlayingCard card = new PlayingCard(randomNummber);
				alredyUp = true;
			}
			/*
			 * If Random didn't get a Card it will get through all and takes the last one
			 */
			if (alredyUp == false) {
				int playcard = 0;
				for (int i = 0; i < cardStack.size(); i++) {
					if (cardStack.get(i).isDone() == false) {
						playcard = i;
					}
				}
				PlayingCard card = new PlayingCard(playcard);
				/*
				 * If all cards are Done the loop will end
				 */
			}
		} else {
			EndScreen end = new EndScreen();
		}
	}
	/**
	 * The first line of a File will be read
	 * @param File is the File that wants to be read
	 * @return Container insides of the File
	 */
	public String readTheFile(File file) {
		Scanner reader;
		String Container = "";
		try {
			reader = new Scanner(file);
			Container = reader.nextLine();
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return Container;
	}
}
