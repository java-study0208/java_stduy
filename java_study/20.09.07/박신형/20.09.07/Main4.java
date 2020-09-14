import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;

class Solution {
	int sum=0;
	Vector<ArrayList<Integer>> key = new Vector<>();
    public int solution(String[][] relation) {
    	/* �ᱹ�� ������ ���ϴ� ���� */
    	this.dfs(0, relation[0].length, new ArrayList<>(), relation);
    	return key.size();
    }
    public void dfs(int start, int end, ArrayList<Integer> arr, String[][] relation) {
    	if (start==end) {
    		this.verify(arr, relation);
    		return;
    	}
    	ArrayList<Integer> ar = new ArrayList<>(arr);
    	this.dfs(start+1, end, ar,relation);
    	ar.add(start);
    	this.dfs(start+1, end, ar,relation);
    }
    public void verify (ArrayList<Integer> arr, String[][] relation) {
		/* ���Ⱑ ���� �ܰ� */
    	System.out.println(arr+"#####"+key+"����"+key.size());
		for (int t=0; t<key.size();t++) {
			if (arr.containsAll(key.get(t))) {
				return;
			}
		}
    	Vector<ArrayList<String>> v = new Vector<>();
    	for (int i=0; i<relation.length;i++ ) {
    		ArrayList<String> arr1 = new ArrayList<>();
    		for (int j=0; j<arr.size();j++) {
    			arr1.add(relation[i][arr.get(j)]);
    		}
    		if (!v.contains(arr1)) {
    			v.add(arr1);
    		}
    	}
    	if (v.size()==relation.length) {
    		sum++;
    		System.out.println("�� ���� ������");
    		//System.out.println(v);
    		ArrayList<Integer> arr2 = new ArrayList<>(arr);
    		Collections.copy(arr2, arr);
    		key.add(arr2);
    		//System.out.println(key+"������������������"+key.size());
    		// ���࿡ ����ִٸ� out ���Ѿ� �ϴ� ������ ¥����
    	}
    }
}
public class Main4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		String[][] str = {{"100","ryan","music","2"},{"200","apeach","math","2"},{"300","tube","computer","3"},{"400","con","computer","4"},{"500","muzi","music","3"},{"600","apeach","music","2"}};
		String[][] str1 = {{"b","2","a","a","b"},{"b","2","7","1","b"},{"1","0","a","a","8"}};
		String[][] str2 = {{"ryan","music","2"},{"apeach","math","2"},{"tube","computer","3"},{"con","computer","4"},{"muzi","music","3"},{"apeach","music","3"}};
		String[][] str3 = {{"100","ryan","music","2"},{"200","apeach","math","2"},{"300","tube","computer","3"},{"400","con","computer","4"},{"500","muzi","music","3"},{"600","apeach","music","3"}};
		System.out.println(s.solution(str2));

	}

}
