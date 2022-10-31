package ch.csbe.cards;

public class AudioCard implements Card {

	private String pathtoAudio = "";
	private String answer = "";
	private boolean done = false; // is the flashcard already done it will go to true
	/**
	 * @param pathtoAudio The Path to the Audio
	 * @param answer The answer to the flashcard
	 */
	public AudioCard(String pathtoAudio, String answer) {
		this.pathtoAudio = pathtoAudio;
		this.answer = answer;
	}

	@Override
	public String getPathtoAudio() {
		return this.pathtoAudio;
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
	 * needed to cheeck that its not a Question or a image
	 */
	@Override
	public String getQuestion() {
		return "";
	}
	@Override
	public String getPathtoImg() {
		return "";
	}
}
