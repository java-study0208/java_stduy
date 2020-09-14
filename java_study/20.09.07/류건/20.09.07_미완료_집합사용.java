package java_data_structure;

import java.util.ArrayList;

class test1 {

	public test1() {

	}

	public int solution(String[][] relation) {
		ArrayList<ArrayList<ArrayList<Integer>>> data1 = new ArrayList<ArrayList<ArrayList<Integer>>>();

		int score = 0; // 후보키 개수

		for (int i = 0; i < relation[0].length; i++) {
			data1.add(new ArrayList<ArrayList<Integer>>());
			int data_size = data1.size();
			for (int k = 0; k < relation.length - 1; k++) {
				if (relation[k][i] != null) {
				data1.get(data1.size() - 1).add(new ArrayList<Integer>());
				}
				for (int j = k+1; j < relation.length; j++) {
					if (relation[k][i] != null) {
						if (relation[k][i].equals(relation[j][i])) {
							data1.get(data_size-1).get(data1.get(data_size-1).size() - 1).add(k);
							data1.get(data_size-1).get(data1.get(data_size-1).size() - 1).add(j);
							relation[j][i] = null;
						}
					}
				}
				if(data1.get(data_size-1).get(data1.get(data_size-1).size()-1).isEmpty()) {
					data1.get(data_size-1).remove(data1.get(data_size-1).size()-1);
				}
			}
			if (!(data1.isEmpty())) {
				if (data1.get(data1.size() - 1).isEmpty()) {
					data1.remove(data1.size() - 1);
					score += 1;
				}
			}
			else {
				score += 1;
			}
		}
		
		
		int Array_size = data1.size();
		int evaluation = 0;	
		
		for(int a = 0; a<Array_size-1;a++) {
			for(int b = a+1; b<Array_size ; b++) {
				evaluation = 0;
				int set_size_1 = data1.get(a).size();
				int set_size_2 = data1.get(b).size();
				for(int c = 0; c < data1.get(set_size_1-1).size();c++) {
					for(int d = 0; d< data1.get(set_size_2).size();d++) {
						
				
						for(int e = 0; e<data1.get(a).get(c).size();e++) {
						}
						if(data1.get(a).get(c).containsAll(data1.get(b).get(d))){
							evaluation = 1;
						}
						if(data1.get(b).get(d).containsAll(data1.get(a).get(c))) {
							evaluation = 1;
						}
					}
				}
				if(evaluation == 0) {
					score +=1;
				}
			}
		}
		
		
		return score;
	}

	public static void main(String[] args) {

		String[][] b = {{"100","ryan","music","2"},
				{"200","apeach","math","2"},
				{"300","tube","computer","3"},
				{"400","con","computer","4"},
				{"500","muzi","music","3"},
				{"600","apeach","music","2"}};
		test1 a = new test1();

		int c = a.solution(b);
		System.out.print(c);
		
	}

}
