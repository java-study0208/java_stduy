package java_data_structure;

import java.util.ArrayList;

public class test2 {
	public test2() {

	}

	public int combination(int a, int b) {

		int num = 0;
		int up = 1, down = 1;

		for (int i = 1; i <= b; i++) {
			down = down * i;
			up = up * (a - i + 1);
		}
		num = up / down;

		return num;
	}

	public int solution(String[][] relation) {

		String[][] array = relation;

		int score = 0; // 후보키 개수

		ArrayList<Integer> g = new ArrayList<Integer>();

			for (int i = 0; i < array[0].length; i++) {
				int evaluation = 0;
				for (int k = 0; k < array.length - 1; k++) {
					for (int j = k + 1; j < array.length; j++) {
						if (array[k][i].equals(array[j][i])) {
							evaluation = 1;
						}
					}
				}
				if (evaluation == 0) {
					g.add(i);
					score += 1;
				}
			}

			for (int k = 0; k < g.size(); k++) {
				String[][] newArray = new String[array.length][array[0].length - 1];
				for (int p = 0; p < array.length; p++) {
					for (int q = 0, r = 0; q < array[0].length && r < array[0].length - 1; q++) {
						if (q != g.get(k)) {
							newArray[p][r++] = array[p][q];
						}
					}
				}
				array = newArray;
			}
			
			
			
			

		
		return score;
	}

	public static void main(String[] args) {

		String[][] b = { { "100", "ryan", "music", "2" }, { "200", "apeach", "math", "2" },
				{ "300", "tube", "computer", "3" }, { "400", "con", "computer", "4" }, { "500", "muzi", "music", "3" },
				{ "600", "apeach", "music", "2" } };
		test2 a = new test2();

		int c = a.solution(b);
		System.out.print(c);
	}

}
