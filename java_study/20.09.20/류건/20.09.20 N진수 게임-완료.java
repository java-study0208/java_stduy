package java_data_structure;

import java.util.ArrayList;

class test1 {

	public test1() {
		
	}
	
	public String notation(int n, int num) {
		
		String nota = "";
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		int number = num;//숫지
		
		int remain; //나머지
		int value=number;; //몫
		
		
		
		for(;;) {
			if(value<n) {
				list.add(value);
				break;
			}
			remain = number%n;
			value = number/n;
			list.add(remain);
			number = value;
			}
		
		
		
		for(int i = list.size()-1; i>=0;i--) {
			if(list.get(i)==10) {
				nota += "A";
			}
			else if(list.get(i) == 11) {
				nota += "B";
			}
			else if(list.get(i) == 12) {
				nota += "C";
			}
			else if(list.get(i) == 13) {
				nota += "D";
			}
			else if(list.get(i) == 14) {
				nota += "E";
			}
			else if(list.get(i) == 15) {
				nota += "F";
			}
			else {
				nota += list.get(i);
			}
			
		}
		
		
		return nota;
	}

	public String solution(int n, int t, int m, int p) {
		String Answer ="";
		String notation_changed;
		if(p==m) {
			p = 0;
		}
		
		for(int i = 0,j=0;;) {
			notation_changed=notation(n,j);
			j = j+1;
			for(int k = 0; k<notation_changed.length();k++) {
				i = i+1;
				if((i%m)==p) {
					Answer +=notation_changed.charAt(k);
					if(Answer.length()==t) {
						return Answer;
					}
					
				}
			}
		}
		
    }

	public static void main(String[] args) {
		test1 a = new test1();
		String b = a.solution(16,16,2,2);
		System.out.print(b);
	}

}
