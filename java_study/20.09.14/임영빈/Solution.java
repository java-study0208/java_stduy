package java_tutorials.test;

import java.util.Queue;
import java.util.LinkedList;

class Solution {
	
	public static void main(String[] args) {
		int bridge_length=100;
		int weight=100;
		int[] truck_weights = {10,10,10,10,10,10,10,10,10,10};
		int answer = solution(bridge_length, weight, truck_weights);
		System.out.println(answer);
		
	}
	
    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int truck_num = truck_weights.length;
        int sum = 0;
        
        Queue<Integer> queue = new LinkedList<>();
        
        for(int i = 0; i< bridge_length; i++)
        	queue.offer(0);
        
        
        for(int j = 0; j< truck_num; j++) {
        	sum -= queue.poll();
        	
        	if(sum + truck_weights[j] <= weight) {
        		//한계무게보다 적으면 queue에 자동차 추가 후, 무게 sum에 더함
        		queue.offer(truck_weights[j]);
        		sum += truck_weights[j];
        	}
        	else {
        		//한계무게보다 크면 queue에 0만 추가 후, j추가한거 다시 빼기
        		queue.offer(0);
        		j--;
        	}
        	
        	answer ++;
        }
        
        answer += bridge_length;	//위의 for문이 끝나는 순간이 자동차가 들어간 순간이기 때
        return answer;
    }
}
