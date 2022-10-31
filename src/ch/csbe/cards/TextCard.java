package ch.csbe.cards;

public class TextCard implements Card {

	private String question = "";
	private String answer = "";
	private boolean done = false; // is the flashcard already done it will go to true
	/**
	 * @param question The question of the flashcard
	 * @param answer The answer to the flashcard
	 */
	public TextCard(String question, String answer) {
		this.question = question;
		this.answer = answer;
	}
	
	@Override
	public String getQuestion() {
		return this.question;
	}
	@Override
	public String getAnswer() {
		return this.answer;
	}	
	@Override
	public void setDone(boolean maek) {
		this.done = maek;
	}
	@Override
	public boolean isDone() {
		return this.done;
	}
	
	/*
	 * needed to cheeck that its not a image or a Audio
	 */
	@Override
	public String getPathtoImg() {
		return "";
	}
	@Override
	public String getPathtoAudio() {
		return "";
	}
}
