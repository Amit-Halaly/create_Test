package amit_halaly_ben_aharoni;

import java.io.Serializable;

public class open_question extends questions implements Serializable {
	private answer_text answer;

	public open_question(String question, answer_text answer, edifficulty difficulty) {
		super(question, difficulty);
		this.answer = answer;

	}

	public answer_text getAnswer() {
		return answer;
	}

	public edifficulty getdifficulty() {
		return difficulty;
	}

	public String toString() {
		return super.toString();
	}

}
