package amit_halaly_ben_aharoni;

import java.io.Serializable;

public class american_question extends questions implements Serializable {
	private answers[] answer;
	private final int max_numofanswers = 10;
	private int num_of_answers;

	public american_question(String question, edifficulty difficulty) {
		super(question, difficulty);
		answer = new answers[max_numofanswers];
		num_of_answers = 2;
		answer[0] = new answers(new answer_text("more then one answer is true"), false);
		answer[1] = new answers(new answer_text("all answers is wrong"), true);

	}

	public boolean canAddAnswer() {
		if (num_of_answers < max_numofanswers) {
			return true;
		} else
			return false;
	}

	public void addAnswer(answer_text answer_text, boolean is_correct) {
		answer[num_of_answers++] = new answers(answer_text, is_correct);
	}

	public void RemoveAnswers(int placeofanswer) {
		if (num_of_answers < placeofanswer) {
			System.out.println("no answer to remove");
			return;
		}
		answers temp = answer[placeofanswer];
		answer[placeofanswer] = answer[num_of_answers - 1];
		num_of_answers--;
	}

	public void booleanAnswer() {
		answer[0] = new answers(new answer_text("more then one answer is true"), false);
		answer[1] = new answers(new answer_text("all answers is wrong"), true);
		int counter = 0;
		for (int i = 2; i < answer.length; i++) {
			if (i == num_of_answers) {
				return;
			}
			if (answer[i].getIs_correct() == true) {
				counter++;
				if (counter == 1) {
					answer[1].setIs_correct(false);
				}
				if (counter >= 2) {
					answer[0].setIs_correct(true);
					answer[1].setIs_correct(false);
				}
			}

		}

	}

	public edifficulty getdifficulty() {
		return difficulty;
	}

	public answers[] getAnswers() {
		return answer;
	}

	public int getNumOfAnswers() {
		return num_of_answers;
	}

	public String toString() {
		System.out.println(super.toString());
		for (int j = 0; j < answer.length; j++) {
			if (j == num_of_answers) {
				System.out.println();
				return "";
			}
			System.out.print((j + 1) + ") ");
			System.out.print(answer[j].toString());
		}
		return "\n";
	}
}
