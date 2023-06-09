package amit_halaly_ben_aharoni;

import java.io.Serializable;
import java.util.Arrays;

public class Subjects implements Serializable {
	private repository[] allrepositories = new repository[10];
	private int counter = 0;

	public Subjects() {

	}

	public void addRepository(repository repositories) {
		this.allrepositories[counter++] = repositories;
		this.allrepositories = Arrays.copyOf(allrepositories, counter + 10);
	}

	public int getcounter() {
		return counter;
	}

	public repository[] getRepositories() {
		return allrepositories;
	}

	public String toString() {
		System.out.println("subjects:");
		for (int i = 0; i < counter; i++) {
			System.out.println();
			System.out.println((i + 1) + ")" + allrepositories[i].getSubject());
		}
		return "";
	}
}