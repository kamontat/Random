package Code;

import java.util.*;

/**
 * Created by kamontat on 20/4/59.
 */
public class Random {
	private ArrayList<Number> historys = new ArrayList<>();
	private double randNum;
	private double[] randDouble = null;
	private int[] randInt = null;

	public Random(double st, double nd) {
		if (st % 1 == 0 && nd % 1 == 0) {
			randInt = new int[2];
			randInt[0] = (int) st;
			randInt[1] = (int) nd;
		} else {
			randDouble = new double[2];
			randDouble[0] = st;
			randDouble[1] = nd;
		}
	}

	public int randomWith(int first, int second) {

		int rand = (int) Math.ceil(Math.random() * second);
		while (rand < first) {
			rand = (int) Math.ceil(Math.random() * second);
		}
		return rand;
	}

	public double randomWith(double first, double second) {
		double rand = Math.random() * second;
		while (rand < first) {
			rand = Math.random() * second;
		}
		return rand;
	}

	public int randomNotSameWith(int first, int second) {
		if (historys.size() >= (second - first) + 1) return -99;
		int rand = (int) Math.ceil(Math.random() * second);
		while (rand < first || checkDuplicate(rand)) {
			rand = (int) Math.ceil(Math.random() * second);
		}
		return rand;
	}

	public double randomNotSameWith(double first, double second) {
		if (historys.size() >= (second - first) + 1) return -99;
		double rand = Math.random() * second;
		while (rand < first || checkDuplicate(rand)) {
			rand = Math.random() * second;
		}
		return rand;
	}

	public void randomSame() {
		if (randDouble == null) randNum = randomWith(randInt[0], randInt[1]);
		else if (randInt == null) randNum = randomWith(randDouble[0], randDouble[1]);
		else System.err.println("Program error");

		recordToHistory();
	}

	public void randomNotSame() {
		if (randDouble == null) randNum = randomNotSameWith(randInt[0], randInt[1]);
		else if (randInt == null) randNum = randomNotSameWith(randDouble[0], randDouble[1]);
		else System.err.println("Program error");

		recordToHistory();
	}

	public Boolean checkDuplicate(int rand) {
		for (Number history : historys) {
			if (history.equals(rand)) {
				return true;
			}
		}
		return false;
	}

	public Boolean checkDuplicate(double rand) {
		for (Number history : historys) {
			if (history.equals(rand)) {
				return true;
			}
		}
		return false;
	}

	public void recordToHistory() {
		if (randNum % 1 == 0) historys.add((int) randNum);
		else historys.add(randNum);
		randNum = 0;
	}

	public String[] getHistoryList() {
		String[] history = new String[this.historys.size()];
		for (int i = 0; i < history.length; i++) {
			history[i] = String.format("%-3d) ", i + 1) + this.historys.get(i);
		}
		return history;
	}
}
