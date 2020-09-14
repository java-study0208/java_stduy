package java_data_structure;

import java.util.ArrayList;

class test1 {
	
	ArrayList<int[]> list = new ArrayList<int[]>(); // truck_weights의 순열을 저장할 배열

	public test1() {
		
	}

	public int soon(int length) {

		int a = 1;
		for (int j = 1; j <= length; j++) {
			a = a * j;
		}

		return a;
	}

	public void perm(int[] arr, int[] output, boolean[] visited, int depth, int n, int r) {
		if (depth == r) {
			int[] arr_list  = new int[r];
			for(int t = 0; t<r;t++) {
				arr_list[t] = output[t];
			}
						 
			this.list.add(arr_list);
			return;
		}

		for (int i = 0; i < n; i++) {
			if (visited[i] != true) {
				visited[i] = true;
				output[depth] = arr[i];
				perm(arr, output, visited, depth + 1, n, r);
				visited[i] = false;
			}
		}
	}

	public int solution(int bridge_length, int weight, int[] truck_weights) {

		ArrayList<Integer> bridge = new ArrayList<Integer>();

		for (int i = 0; i < bridge_length; i++) {
			bridge.add(0);
		} // 다리 길이만큼 0넣기

		int size = soon(truck_weights.length);

		int[] output = new int[truck_weights.length];
		boolean[] visited = new boolean[truck_weights.length];

		perm(truck_weights, output, visited, 0, truck_weights.length, truck_weights.length);
		
		ArrayList<Integer> time_arr = new ArrayList<Integer>();
		for(int k = 0; k<size;k++) {
			int truck_num = 0;
			for(int p = 0; p<10000;p++) {
				
				if(truck_num==truck_weights.length-1) {
					time_arr.add(p);
					break;
				}
				
				for(int e = bridge_length-1; e>=0;e-- ) {
					if(e==0) {
						bridge.set(0, 0);
					}
					else {
					bridge.set(e,bridge.get(e-1));
					}
				}
				
				int add = 0;
				for(int l = 0; l< bridge.size();l++) {
					add = add + bridge.get(l);
				}
				
				if(add+this.list.get(k)[truck_num]<=weight) {
					bridge.set(0,this.list.get(k)[truck_num]);
					truck_num +=1;
				}
				
			}
		}
		
		int min = 1000;
		for(int r = 0; r<time_arr.size();r++) {
			if(min>time_arr.get(r)) {
				min = time_arr.get(r);
			}
		}
	
		return min+bridge_length;
	}

	public static void main(String[] args) {

		int bridge_length = 2;
		int weight = 10;
		int[] truck_weights = { 7,4,5,6 };

		test1 a = new test1();

		int c = a.solution(bridge_length, weight, truck_weights);
		
		System.out.print(c);

	}

}
