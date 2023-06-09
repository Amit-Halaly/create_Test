package amit_halaly_ben_aharoni;

public class answersException extends Exception {

	public answersException(int answers_to_add) {
		super("you need to add at least " + answers_to_add + " more answers");

	}
}
