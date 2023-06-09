package amit_halaly_ben_aharoni;

import java.io.Serializable;
import java.util.Arrays;

public class repository implements Serializable {
	private questions[] allQuestions = new questions[10];
	private answer_text[] allanswers = new answer_text[10];
	private int counter_answertext;
	private int counter_question;
	private String subject;

	public repository(String subject) {
		this.subject = subject;

	}

	public String getSubject() {
		return subject;
	}

	public int getCounter_question() {
		return counter_question;
	}

	public int getCounter_answers() {
		return counter_answertext;
	}

	public answer_text[] getanswers() {
		return allanswers;
	}

	public questions[] getQustion() {
		return allQuestions;
	}

	public boolean isNotEmpty() {
		if (counter_question == 0)
			return false;
		return true;
	}

	public void addanswer(answer_text answertext) {
		this.allanswers[counter_answertext++] = answertext;
		this.allanswers = Arrays.copyOf(allanswers, counter_answertext + 10);
	}

	public void addquestion(questions questions) {
		allQuestions[counter_question++] = questions;
		allQuestions = Arrays.copyOf(allQuestions, counter_question + 10);
	}

	public void addAnswerToQuestion(int place_of_answer, int place_of_qustion, boolean is_correct) {

		if (((american_question) allQuestions[place_of_qustion - 1]).canAddAnswer()) {
			((american_question) allQuestions[place_of_qustion - 1]).addAnswer(allanswers[place_of_answer - 1],
					is_correct);

		} else
			System.out.println("can't add more answer");

	}

	public void removeAnswer(int place_of_qustion, int place_of_answer) {
		((american_question) allQuestions[place_of_qustion - 1]).RemoveAnswers(place_of_answer - 1);
	}

	public void removeQuestion(int place_of_qustion) {
		questions temp = allQuestions[place_of_qustion - 1];
		allQuestions[place_of_qustion - 1] = allQuestions[counter_question - 1];
		counter_question--;
	}

	public String toStringAnswers() {
		for (int i = 0; i < counter_answertext; i++) {
			System.out.println("(" + (i + 1) + ") " + allanswers[i].toString());

		}
		return "";
	}

	public String toStringQuestions() {
		int count = 1;
		for (int i = 0; i < counter_question; i++) {
			if (allQuestions[i] instanceof american_question) {
				System.out.println("(" + count++ + ") " + allQuestions[i].getQuestion());
			}
		}
		return "";
	}

	public String toStringAllQuestions() {
		for (int i = 0; i < counter_question; i++) {
			{
				System.out.println("(" + (i + 1) + ") " + allQuestions[i].getQuestion());
			}
		}
		return "";
	}

	public String toStringQuestion(int place_of_qustion) {

		return allQuestions[place_of_qustion - 1].getQuestion();
	}

	public String toStringAll() {
		for (int i = 0; i < counter_question; i++) {
			if (allQuestions[i] instanceof american_question) {
				((american_question) allQuestions[i]).booleanAnswer();
				System.out.print("Q" + (i + 1) + ": ");
				System.out.println(((american_question) allQuestions[i]).getdifficulty().name());
				((american_question) allQuestions[i]).toString();
				System.out.println();
			} else {
				System.out.print("Q" + (i + 1) + ": ");
				System.out.println(((open_question) allQuestions[i]).getdifficulty());
				System.out.println(((open_question) allQuestions[i]).toString());
				System.out.println();
			}
		}
		return "";
	}

	public String toStringSingelQuestion(int place_of_question) {

		return allQuestions[place_of_question - 1].toString();

	}

	public void maxnumofquestions(int num_of_questions) throws Exception {
		if (num_of_questions > 10) {
			throw new QuestionsExceptions();
		}
	}

	public void minnumofanswers(int answer_to_add, int numofanswers) throws Exception {
		if (answer_to_add > numofanswers) {
			answer_to_add = answer_to_add - numofanswers;
			throw new answersException(answer_to_add);
		}
	}
}
