package java_project;
import java.util.ArrayList;
import java.util.HashSet;

import java.util.*;

class Solution {
	
	
	public static void main(String[] args) {
		String[][] arr = {
				 {"100","ryan","music","2"},
				 {"200","apeach","math","2"},
				 {"300","tube","computer","3"},
				 {"400","con","computer","4"},
				 {"500","muzi","music","3"},
				 {"600","apeach","music","2"}
		};
		System.out.println(solution(arr));
    }
	
	
	
    public static int solution(String[][] relation) {
    	int X = relation[0].length;
    	int Y = relation.length;
        int N = 1 << X;

        ArrayList<Integer> candidate = new ArrayList<>();
        for (int i = 1; i < N; i++) {
            Set<String> set = new HashSet<>();
            boolean unique = true;
            
            
            for (int y = 0; y < Y; y++) {
                String key = "";

                for (int x = 0; x < X; x++)
                    if ((i & (1 << x)) > 0)
                        key += relation[y][x];

                if (set.contains(key)) {
                    unique = false;
                    break;
                }
                set.add(key);
            }
            
            
            if (unique) {
                boolean check = true;
                for (int j = 0; j < candidate.size(); j++)
                    if ((candidate.get(j) & i) == candidate.get(j))
                        check = false;

                if (check)
                    candidate.add(i);
            }
        }

        return candidate.size();
    }
}
