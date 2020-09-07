import java.util.ArrayList;
import java.util.HashSet;

class Solution {
    public int solution(String[][] relation) {
		int answer = 0;
		ArrayList<ArrayList<HashSet<Integer>>> a = new ArrayList<ArrayList<HashSet<Integer>>>(); // arraylist 안에
																									// arraylist 안에
																									// HashSet안에 Integer

		for (int i = 0; i < relation[0].length; i++) {
			a.add(new ArrayList<HashSet<Integer>>()); // ArrayList
		}

		for (int k = 0; k < relation[0].length; k++) { // 열 비교
			for (int i = 0; i < relation.length - 1; i++) { // 위의 행부터
				a.get(k).add(new HashSet<Integer>());
				int size_of_array = a.get(k).size();
				a.get(k).get(size_of_array - 1).add(i);
				for (int j = 1; j < relation.length; j++) {// 아래 행으로 비교
					if (relation[i][k] != null && relation[j][k] != null) { //둘다 null이 아니어야 비교
						if (relation[i][k].equals(relation[j][k])) { // 둘이 문자열이 같으면,
							a.get(k).get(size_of_array - 1).add(j);
							relation[j][i] = null; //같은게 생기면 null로 초기화

						}
					}
				}
				if (a.get(k).get(size_of_array - 1).size() == 1) {
					a.get(k).remove(size_of_array - 1); // 같은게 없으면 삭제

				}
			}
		}
		
		for(int i = 0;i<relation[0].length;i++) { //들어있는 set가 없으면, 모든 string이 다른 string
			if(a.get(i).isEmpty()) {
				answer +=1;
			}
		}
		
		//모든 string이 다른 경우의 행을 제외하고, 순서대로 집합이 겹치지 않는 경우를 찾으면 answer을 구할 수 있다.

		return answer;

	}
}
