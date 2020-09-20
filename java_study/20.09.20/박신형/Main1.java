import java.util.ArrayList;
import java.util.Collections;

class Solution {
	// 그냥 다 노가다
    public String solution(int n, int t, int m, int p) {
    	char[] Number = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
    	int count=0;
    	int totalcount = t*m;
    	int index=0;
    	StringBuilder answer = new StringBuilder();
    	ArrayList<String> store = new ArrayList<>();
    	while(count<totalcount) {
    		int portion = index; // 몫
    		int remain=0; // 나머지
    		if (portion>=n) {
    			ArrayList<String> list = new ArrayList<>();
    			while(portion>=n) { // 이때까지 하는 거니까
        			remain = portion % n;
        			portion = portion / n;
        			list.add(Number[remain]+"");
        		}
    			list.add(Number[portion]+"");
    			Collections.reverse(list);
    			store.addAll(list);
    		}
    		else {
    			store.add(Number[portion]+"");
    		}
    		
    		index++;
    		count = store.size();
    		//System.out.println(store);
    	}
    	for (int i=(p-1); i<totalcount ;i+=m ) {
    		answer.append(store.get(i));
    	}
    	System.out.println(answer);
        return answer.toString();
    }
}
public class Main1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		s.solution(2, 4, 2, 1);

	}

}
