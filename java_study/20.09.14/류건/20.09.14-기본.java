package java_data_structure;

import java.util.ArrayList;

class test3{

	ArrayList<int[]> list = new ArrayList<int[]>(); // truck_weights의 순열을 저장할 배열

	public test3() {

	}

	public int solution(int bridge_length, int weight, int[] truck_weights) {

		ArrayList<Integer> bridge = new ArrayList<Integer>();

		for (int i = 0; i < bridge_length; i++) {
			bridge.add(0);
		} // 다리 길이만큼 0넣기

		int truck_num = 0;
		int p;
		for (p = 0; p < 10000; p++) {

			if (truck_num == truck_weights.length) {
				break;
			}

			for (int e = bridge_length - 1; e >= 0; e--) {
				if (e == 0) {
					bridge.set(0, 0);
				} else {
					bridge.set(e, bridge.get(e - 1));
				}
			}

			int add = 0;
			for (int l = 0; l < bridge.size(); l++) {
				add = add + bridge.get(l);
			}

			if (add + truck_weights[truck_num] <= weight) {
				bridge.set(0, truck_weights[truck_num]);
				truck_num += 1;
			}

		}
	
	return p+bridge_length;
	}

	public static void main(String[] args) {

		int bridge_length = 2;
		int weight = 10;
		int[] truck_weights = { 7,4,5,6 };

		test3 a = new test3();

		int c = a.solution(bridge_length, weight, truck_weights);
		
		System.out.print(c);

	}

}
