import java.util.ArrayList;
import java.util.HashSet;

class Solution {
    public int solution(String[][] relation) {
    	int column = relation[0].length; // 총 열의 갯수
    	//ArrayList<HashSet<String>> arr = new ArrayList<>();
    	ArrayList<Integer> arr = new ArrayList<>(); // 식별자 ID를 담아내는 곳
    	ArrayList<ArrayList<String>> com = new ArrayList<>(column);
    	//ArrayList<String> com2 = new ArrayList<>();
    	ArrayList<ArrayList<String>> com2 = new ArrayList<>();
    	// 열 단위로 일단 비교
    	/*for (int i=0; i<column;i++) {
    		for (int j=0; j<relation.length;j++) {
    			ArrayList<String> list1 = new ArrayList<>();
				list1.add(relation[j][i]);
				if (!com.contains(list1)) {
					com.add(list1);
					com2.add(relation[j][i]);
				}
    		}
    		arr.add(i);
    		if (com.size()==relation.length) System.out.println("완성됨");
    		System.out.println(com);
    		com.clear();
    	}*/
    	boolean flag = true;
    	for (int i=0; i<2;i++) {
    		flag = true;
    		int index = i;
    		ArrayList<String> ex = new ArrayList<>();
    		com2.add(ex);
    		while(flag) {
    			System.out.println(index);
    			for (int j=0; j<relation.length;j++) {
    				if (index==i) {
    					ArrayList<String> list1 = new ArrayList<>();
    					list1.add(relation[j][index]);
    					com2.get(i).add(relation[j][index]);
    					if (!com.contains(list1)) {
        					com.add(list1);
        				}
    				}
    				else {
    					ArrayList<String> list2 = new ArrayList<>();
    					list2.addAll(com.get(j));
    					list2.add(relation[j][index]);
    					com2.get(i).add(relation[j][index]);
    					if (!com.contains(list2)) {
    						com.get(j).add(relation[j][index]);
        				}
    				}
    				System.out.println(com2);
    			}
    			if (com.size()==relation.length) {
    				flag = false; arr.add(index); System.out.println("완성됨"); System.out.println(com); com.clear(); break;
    			}
    			com.clear();
    			com.addAll(com2);
    			index++;
    			System.out.println(com);
    		}
    	}
    	
        int answer = 0;
        return answer;
    }
}
public class Main2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		s.solution(new String[][] {{"100","ryan","music","2"},{"200","apeach","math","2"},{"300","tube","computer","3"},{"400","con","computer","4"},{"500","muzi","music","3"},{"600","apeach","music","2"}});
	}

}
