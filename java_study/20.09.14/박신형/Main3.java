import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
    	Queue<Truck> Bridge = new LinkedList<Truck>();
    	Queue<Integer> WaitingBridge = new LinkedList<Integer>(Arrays.asList(Arrays.stream(truck_weights).boxed().toArray(Integer[] :: new)));
    	int time=0;
    	int WeightSum=0;
    	while((!WaitingBridge.isEmpty())||(!Bridge.isEmpty())) {
    		time++;
    		if (!Bridge.isEmpty()) { // 시간이 지날때마다 앞에 있는 것을 꺼내서 점검해주는 것
    			if (time -Bridge.peek().t>=bridge_length) {
    				WeightSum -= Bridge.poll().w;
    			}
    		}
    		if (!WaitingBridge.isEmpty()) {
    			if (WeightSum+WaitingBridge.peek()<=weight) {
    				Bridge.offer(new Truck(WaitingBridge.peek(), time));
    				WeightSum+=WaitingBridge.poll();
    			}
    		}
    		Iterator<Truck> it = Bridge.iterator();
        	System.out.print("시간 ["+time+"] ");
        	while(it.hasNext()) {
        		System.out.print(it.next().w+" ");
        	}
        	System.out.println();
    	}
        int answer = 0;
        return answer;
    }
}
class Truck{
	int w;
	int t;
	public Truck(int we, int ti) {
		this.w = we;
		this.t = ti;
	}
}

public class Main3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		s.solution(2, 10, new int[] {7,4,5,6} );
		//s.solution(100, 100, new int[] {10} );

	}

}
