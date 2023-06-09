package amit_halaly_ben_aharoni;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class automaticExam implements Examable {
	private repository r;
	Scanner input = new Scanner(System.in);
	Date date = new Date();
	SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy-HH-mm");
	Random rand = new Random();

	@Override
	public void createExam(repository r) throws FileNotFoundException {
		PrintWriter pw = new PrintWriter(new File("AutomaticExam-" + (df.format(date)) + ".txt"));
		PrintWriter pwa = new PrintWriter(new File("AutomaticSolution-" + (df.format(date)) + ".txt"));
		int question_counter = 0;
		int num_of_question = 0;
		boolean is_valid_num = false;
		if (r.isNotEmpty()) {
			while (!is_valid_num) {
				System.out.println("please enter how many question do you want? (there is " + r.getCounter_question()
						+ "in that subject");
				try {
					num_of_question = input.nextInt();
					r.maxnumofquestions(num_of_question);
					is_valid_num = true;
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
			pw.println("the test:\n");
			pwa.println("the test with solutions:\n");
			while (question_counter < num_of_question) {
				int choose_test1 = 0;
				int choose_test2 = 0;
				int counter_answer = 0;
				boolean is_correct = true;
				choose_test1 = rand.nextInt(1, r.getCounter_question());
				pw.println("(Q" + (question_counter + 1) + ") " + r.toStringQuestion(choose_test1));
				pwa.println("(Q" + (question_counter + 1) + ") " + r.toStringQuestion(choose_test1));
				if (r.getQustion()[choose_test1 - 1] instanceof american_question) {
					for (int i = 0; i < 4; i++) {
						choose_test2 = rand.nextInt(1, r.getCounter_answers());
						is_correct = rand.nextBoolean();
						r.addAnswerToQuestion(choose_test2, choose_test1, is_correct);
					}
					int counter = 0;
					for (int i = 2; i < 6; i++) {
						if (((american_question) r.getQustion()[choose_test1 - 1]).getAnswers()[i].getIs_correct()) {
							counter++;
							if (counter > 1) {
								((american_question) r.getQustion()[choose_test1 - 1]).getAnswers()[i]
										.setIs_correct(false);
							}
						}
					}

					for (int i = 1; i < 6; i++) {
						((american_question) r.getQustion()[choose_test1 - 1]).booleanAnswer();
						pw.println((counter_answer + 1) + ") "
								+ ((american_question) r.getQustion()[choose_test1 - 1]).getAnswers()[i].getText()
										.getSolution());
						pwa.println((counter_answer + 1) + ") "
								+ ((american_question) r.getQustion()[choose_test1 - 1]).getAnswers()[i].getText()
										.getSolution()
								+ " ("
								+ ((american_question) r.getQustion()[choose_test1 - 1]).getAnswers()[i].getIs_correct()
								+ ")");
						counter_answer++;
					}
				} else {
					pwa.println(((open_question) r.getQustion()[choose_test1 - 1]).getAnswer().toString());
					pw.println("_________________________________________________.");
				}

				question_counter++;
				pw.println("------------------------------------------\n");
				pwa.println("-----------------------------------------\n");

			}
		} else {
			pw.println("you are wasting paper :(");
			pwa.println("you are wasting paper :(");
		}
		pw.println("End");
		pwa.println("End");
		pw.close();
		pwa.close();
	}

}
