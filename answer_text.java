package amit_halaly_ben_aharoni;

import java.io.Serializable;

public class answer_text implements Serializable {

	private String solution;

	public answer_text(String solution) {
		setsolution(solution);
	}

	public boolean setsolution(String solution) {
		this.solution = solution;
		return true;

	}

	public String getSolution() {
		return solution;
	}

	public String toString() {
		return solution;
	}

}
