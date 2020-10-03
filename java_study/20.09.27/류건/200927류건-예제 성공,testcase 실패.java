package java_data_structure;

import java.util.ArrayList;

class test1 {

	public test1() {

	}

	public String[] solution(String[] files) {
		String[] answer = {};

		// arraylist 배열 생성
		ArrayList<String> c[] = new ArrayList[files.length];
		for (int i = 0; i < files.length; i++) {
			c[i] = new ArrayList<String>();
		}

		// head(Lowercase)와 number(0 trim) 부분 나누기
		for (int j = 0; j < files.length; j++) {
			String head = "";
			String number = "";
			int switchnum = 0;

			for (int k = 0;; k++) {
				if (switchnum == 0) {
					if ((files[j].charAt(k) >= 48) && (files[j].charAt(k) <= 57)) {
						c[j].add(head.toLowerCase());
						head = "";
						switchnum = 1;
						k = k - 1;
					} else {
						head += files[j].charAt(k);
					}
				} else {
					if (((files[j].charAt(k) < 48) || (files[j].charAt(k) > 57)) || number.length() >= 5) {
						String temp = "";
						int g = -1;
						for (int l = 0; l < 5; l++) {
							if (number.charAt(l) != '0') {
								g = l;
								break;
							}
						}
						if (g == -1) {
							c[j].add("0");
						} else {
							temp = number.substring(g);
							c[j].add(temp);
							number = "";
							break;
						}

					} else {
						number += files[j].charAt(k);
					}
				}
			}

		}

		// 버블 정렬 사용
		for (int i = files.length - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				int h = c[j].get(0).compareTo(c[j + 1].get(0));
				if (h > 0) {
					String temp = files[j];
					files[j] = files[j + 1];
					files[j + 1] = temp;

					ArrayList<String> temper = c[j];
					c[j] = c[j + 1];
					c[j + 1] = temper;
				}
				if (h == 0) {
					if (Integer.parseInt(c[j].get(1)) > Integer.parseInt(c[j + 1].get(1))) {
						String temp = files[j];
						files[j] = files[j + 1];
						files[j + 1] = temp;

						ArrayList<String> temper = c[j];
						c[j] = c[j + 1];
						c[j + 1] = temper;

					}
				}
			}
		}
		return files;
	}

	public static void main(String[] args) {
		test1 a = new test1();
		String z[] = { "img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG" };
		String b[] = a.solution(z);

		for (int i = 0; i < z.length; i++) {
			System.out.print(b[i] + "\n");
		}
	}

}
