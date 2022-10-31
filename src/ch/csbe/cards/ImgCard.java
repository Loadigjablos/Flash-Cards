package ch.csbe.cards;

public class ImgCard implements Card {
	
	private String pathtoImg = "";
	private String answer = "";
	private boolean done = false; // is the flashcard already done it will go to true
	/**
	 * @param pathtoImg The path to the Image
	 * @param answer The answer to the flashcard
	 */
	public ImgCard(String pathtoImg, String answer) {
		this.pathtoImg = pathtoImg;
		this.answer = answer;
	}
	
	@Override
	public String getPathtoImg() {
		return this.pathtoImg;
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
	 * needed to cheeck that its not a Question or a Audio
	 */
	@Override
	public String getQuestion() {
		return "";
	}
	@Override
	public String getPathtoAudio() {
		return "";
	}
}
