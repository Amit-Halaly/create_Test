package amit_halaly_ben_aharoni;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import amit_halaly_ben_aharoni.questions.edifficulty;

public class create_test {

	public static void writeRepository(repository r) throws IOException, FileNotFoundException {
		ObjectOutputStream outFile = new ObjectOutputStream(new FileOutputStream("binaryRfile.dat"));
		outFile.writeObject(r);
		outFile.close();
	}

	public static repository readRepository() throws IOException, ClassNotFoundException {
		ObjectInputStream inFile = new ObjectInputStream(new FileInputStream("binaryRfile.dat"));
		repository r = (repository) inFile.readObject();
		inFile.close();
		return r;
	}

	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		Date date = new Date();
		SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy-HH-mm");
		Subjects s = new Subjects();
		/*
		 * repository r = new repository("general knowledge"); r.addquestion(new
		 * american_question("1 + 1 ?", edifficulty.easy)); r.addquestion(new
		 * american_question("2 + 2 ?", edifficulty.easy)); r.addquestion(new
		 * american_question("4 + 4 ?", edifficulty.medium)); r.addquestion(new
		 * american_question("2 - 1 ?", edifficulty.medium)); r.addquestion(new
		 * american_question("4 + 5 ?", edifficulty.easy)); r.addquestion(new
		 * american_question("3 + 3 ?", edifficulty.hard)); r.addquestion(new
		 * american_question("4 + 8 ?", edifficulty.hard)); r.addquestion(new
		 * american_question("7 + 7 ?", edifficulty.medium)); r.addquestion(new
		 * american_question("7 - 5 ?", edifficulty.hard)); r.addquestion(new
		 * american_question("10 - 9 ?", edifficulty.hard)); r.addquestion(new
		 * american_question("9 - 9 ?", edifficulty.hard)); r.addquestion(new
		 * american_question("7 - 4 ?", edifficulty.hard)); r.addquestion(new
		 * american_question("6 + 6 ?", edifficulty.easy)); r.addquestion(new
		 * american_question("10 + 1 ?", edifficulty.hard)); r.addquestion(new
		 * open_question("who is the most amazing person in world ?", new
		 * answer_text("ben aharoni kallll!!!!!"), edifficulty.easy)); r.addquestion(new
		 * open_question("who is the most amazing lecturer in world ?", new
		 * answer_text("keren kalif kallll!!!!!"), edifficulty.medium));
		 * r.addquestion(new open_question("who's gonna get 100 in the final test ?",
		 * new answer_text("ben and amit for sure"), edifficulty.easy));
		 * r.addquestion(new
		 * open_question("who said the famous quote ''ini thi bininging'' ?", new
		 * answer_text("jacob zuma"), edifficulty.hard)); r.addquestion(new
		 * open_question("which singer is nicknamed ''the king'' ?", new
		 * answer_text("zohar argov"), edifficulty.medium)); r.addquestion(new
		 * open_question("what is the best course in afeka ?", new
		 * answer_text("development tools"), edifficulty.easy));
		 * 
		 * r.addanswer(new answer_text("89")); r.addanswer(new answer_text("1000"));
		 * r.addanswer(new answer_text("0")); r.addanswer(new answer_text("1"));
		 * r.addanswer(new answer_text("3")); r.addanswer(new answer_text("4"));
		 * r.addanswer(new answer_text("5")); r.addanswer(new answer_text("6"));
		 * r.addanswer(new answer_text("7")); r.addanswer(new answer_text("8"));
		 * r.addanswer(new answer_text("9")); r.addanswer(new answer_text("10"));
		 * r.addanswer(new answer_text("11")); r.addanswer(new answer_text("12"));
		 * r.addanswer(new answer_text("13")); r.addanswer(new answer_text("14"));
		 * r.addanswer(new answer_text("15")); r.addanswer(new answer_text("16"));
		 * r.addanswer(new answer_text("17")); r.addanswer(new answer_text("18"));
		 * writeRepository(r);
		 */
		repository r = readRepository();
		s.addRepository(r);

		int choose = 0;
//create a repository
		do {
			System.out.println("press:\n 1) to view all the questions and the answers for each question \n "
					+ "2) to add a new answer to repository \n"
					+ " 3) to add a new answer for an american question only \n " + "4) to add a new question \n"
					+ " 5) to remove a certain answer for a question \n" + " 6) to remove a question \n"
					+ " 7) to create a new repositry \n" + "-1) to exit  \n");

			choose = input.nextInt();
			switch (choose) {
			case 1:
				System.out.println("choose the subject that you want to view all the questions and the answers");
				s.toString();
				int choose_subject = input.nextInt();
				if (s.getRepositories()[choose_subject - 1].isNotEmpty()) {
					System.out.println(s.getRepositories()[choose_subject - 1].toStringAll());
				} else
					System.out.println("there are not any questions in that subject");

				break;

			case 2:
				System.out.println("choose a subject:");
				s.toString();
				int choose_subject1 = input.nextInt();
				String answertext;
				System.out.println("write your answer:");
				answertext = input.next();
				s.getRepositories()[choose_subject1 - 1].addanswer(new answer_text(answertext));
				break;

			case 3:

				int choose1 = 0, choose2 = 0;
				boolean iscorrect = true;
				System.out.println("choose a subject:");
				s.toString();
				int choose_subject2 = input.nextInt();
				if (s.getRepositories()[choose_subject2 - 1].isNotEmpty()) {
					System.out.println("choose a question from the list:");
					System.out.println(s.getRepositories()[choose_subject2 - 1].toStringQuestions());
					choose1 = input.nextInt();
					System.out.println("choose an answer from the list: ");
					System.out.println(s.getRepositories()[choose_subject2 - 1].toStringAnswers());
					choose2 = input.nextInt();
					System.out.println("enter if true or false:");
					iscorrect = input.nextBoolean();
					s.getRepositories()[choose_subject2 - 1].addAnswerToQuestion(choose2, choose1, iscorrect);
				} else
					System.out.println("there is no questions in that repository");
				break;

			case 4:
				System.out.println("choose a subject:");
				s.toString();
				int choose_subject3 = input.nextInt();
				String newquestion = "";
				System.out.println("what type of question do you want to add? 1-american/2-open");
				int q_type = input.nextInt();

				if (q_type == 1) {
					System.out.println("write your question : ");
					newquestion = input.next();
					System.out.println("what level of difficulty is the question? (easy-e/medium-m/hard-h");
					char choice = input.next().charAt(0);

					if (choice == 'e') {
						s.getRepositories()[choose_subject3 - 1]
								.addquestion(new american_question(newquestion, edifficulty.easy));
					} else if (choice == 'm') {
						s.getRepositories()[choose_subject3 - 1]
								.addquestion(new american_question(newquestion, edifficulty.medium));
					} else {
						s.getRepositories()[choose_subject3 - 1]
								.addquestion(new american_question(newquestion, edifficulty.hard));
					}
				} else {
					System.out.println("write your question : ");
					newquestion = input.next();
					System.out.println("write the answer for your question : ");
					String newanswer = input.next();
					System.out.println("what level of difficulty is the question? (easy-e/medium-m/hard-h");
					char choice2 = input.next().charAt(0);

					if (choice2 == 'e') {
						s.getRepositories()[choose_subject3 - 1].addquestion(
								new open_question(newquestion, new answer_text(newanswer), edifficulty.easy));
					} else if (choice2 == 'm') {
						s.getRepositories()[choose_subject3 - 1].addquestion(
								new open_question(newquestion, new answer_text(newanswer), edifficulty.medium));
					} else {
						s.getRepositories()[choose_subject3 - 1].addquestion(
								new open_question(newquestion, new answer_text(newanswer), edifficulty.hard));
					}
				}
				break;

			case 5:
				int choose4 = 0, choose6 = 0;
				System.out.println("choose a subject:");
				s.toString();
				int choose_subject4 = input.nextInt();
				if (s.getRepositories()[choose_subject4 - 1].isNotEmpty()) {
					System.out.println("choose a question from the list:");
					System.out.println(r.toStringQuestions());
					choose4 = input.nextInt();
					s.getRepositories()[choose_subject4 - 1].toStringSingelQuestion(choose4);
					System.out.println("choose an answer to remove");
					choose6 = input.nextInt();
					s.getRepositories()[choose_subject4 - 1].removeAnswer(choose4, choose6);
				} else
					System.out.println("there is no questions in that repository");
				break;

			case 6:
				int choose3 = 0;
				System.out.println("choose a subject:");
				s.toString();
				int choose_subject5 = input.nextInt();
				if (s.getRepositories()[choose_subject5 - 1].isNotEmpty()) {
					System.out.println("choose a question to remove from the list:");
					System.out.println(s.getRepositories()[choose_subject5 - 1].toStringQuestions());
					choose3 = input.nextInt();
					s.getRepositories()[choose_subject5 - 1].removeQuestion(choose3);
				} else
					System.out.println("there is no questions in that repository");
				break;
			case 7:
				input.nextLine();
				System.out.println("enter the subject of the repository");
				String subject = input.nextLine();
				s.addRepository(new repository(subject));
				break;

			default:
				if (choose != -1)
					System.out.println("invalid case please try again");
			}

		} while (choose != -1);
		System.out.println("goodbye :(");
//create a test file
		int choose3 = 0;
		System.out.println("choose a subject that you want to create a test with:");
		s.toString();
		int choose_subject = input.nextInt();
		do {
			System.out.println("press:\n 1) for manual exam \n " + "2) for automatic exam \n" + "-1) to exit");
			choose3 = input.nextInt();
			switch (choose3) {
			case 1:
				manualExam m = new manualExam();
				m.createExam(s.getRepositories()[choose_subject - 1]);
				System.out.println("created!");
				break;
			case 2:
				automaticExam a = new automaticExam();
				a.createExam(s.getRepositories()[choose_subject - 1]);
				System.out.println("created!");
				break;

			default:
				if (choose3 != -1)
					System.out.println("invalid case please try again");
			}
		} while (choose3 != -1);
		System.out.println("goodbye!");

	}
}