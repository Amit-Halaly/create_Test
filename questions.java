package amit_halaly_ben_aharoni;

import java.io.Serializable;

public class questions implements Serializable {

	protected enum edifficulty {
		hard, medium, easy
	}

	protected String question;
	protected edifficulty difficulty;
	protected static int counter;

	public questions(String question, edifficulty difficulty) {
		this.question = question;
		this.difficulty = difficulty;
		++counter;

	}

	public static int getserialnum() {
		return counter;
	}

	public String getQuestion() {
		return question;
	}

	public boolean setQuestion(String question) {

		return true;
	}

	public String toString() {
		return getQuestion() + "\n";
	}

}
