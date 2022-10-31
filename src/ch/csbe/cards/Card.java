package ch.csbe.cards;
/**
 * Is only here to make a Array list. ImgCard, AudioCard and TextCard aren't the same, but have three things in common:
 * - They have a answer
 * - They have a boolean to cheek if its already done
 * - They have some sort of Problem that can be described in either a Image, Audio or a Question
 * @author dominic
 */
public interface Card {

	public String getQuestion();
	public String getPathtoImg();
	public String getPathtoAudio();
	public String getAnswer();
	public void setDone(boolean maek);
	public boolean isDone();
	
}
