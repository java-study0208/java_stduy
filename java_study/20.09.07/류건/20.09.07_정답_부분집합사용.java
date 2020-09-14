package java_data_structure;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

class test3 {
	public test3() {
		
	}
	
    public int solution(String[][] relation) {
        int n = relation.length;        // n개의 데이터
        int m = relation[0].length;     // m개의 컬럼
        ArrayList<Integer> list = new ArrayList<Integer>();

        // 완전 탐색을 돈다.
        for(int i=1; i<(1<<m); i++) {
            Set<String> s = new HashSet<String>();
            // n개의 데이터
            for(int j=0; j<n; j++) {
                String now = "";
                // m개의 컬럼
                for(int k=0; k<m; k++) {
                    // 모든 경우의 수 & 해당 라인 데이터 조합.
                    if( (i&(1<<k)) > 0 ) {
                        now+=relation[j][k];
                    }
                }
                s.add(now);
            }
            int size = s.size();
            boolean b = (possi(list,i));
            
            if(s.size()==n&&possi(list,i)) list.add(i);
        }
        //System.out.println(list.size());
        return list.size();
    }
    public static boolean possi(ArrayList<Integer> list, int now) {
        for(int i=0; i<list.size(); i++) {
            // 같으면 최소성을 만족하지 못함.
            if((list.get(i)&now)==list.get(i)) {
                return false;
            }
        }
        return true;
    }


    
	public static void main(String[] args) {

		String[][] b = { { "100", "ryan", "music", "2" }, { "200", "apeach", "math", "2" },
				{ "300", "tube", "computer", "3" }, { "400", "con", "computer", "1" }, { "500", "muzi", "music", "3" },
				{ "600", "apeach", "music", "2" } };
		test3 a = new test3();

		int c = a.solution(b);
		System.out.print(c);
	}
}


