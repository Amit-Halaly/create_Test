package amit_halaly_ben_aharoni;

import java.io.Serializable;

public class answers implements Serializable {

	private answer_text text;
	private boolean is_correct;

	public answers(answer_text text, boolean is_correct) {
		setText(text);
		setIs_correct(is_correct);
	}

	public answer_text getText() {
		return text;
	}

	public void setText(answer_text text) {
		this.text = text;
	}

	public boolean getIs_correct() {
		return is_correct;
	}

	public void setIs_correct(boolean is_correct) {
		this.is_correct = is_correct;
	}

	public String toString() {
		System.out.println(text.toString() + " (" + getIs_correct() + ")");
		return "";
	}

}
