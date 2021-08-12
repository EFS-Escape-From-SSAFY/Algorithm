import java.util.*;
public class bj_11497 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t=0;t<tc;t++) {
			int n = sc.nextInt();
			int num[] = new int[n];
			int result=0;
			PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
			for(int i=0;i<n;i++){
				pq.add(sc.nextInt());
			}
			int start = pq.poll();
			int left = pq.poll();
			int right = pq.poll();
			result = start-right;
			while(true) {
				if(pq.isEmpty())
					break;
				int lt = pq.poll();
				result = Math.max(left-lt, result);
				left = lt;
				if(pq.isEmpty())
					break;
				int rt = pq.poll();
				result = Math.max(right-rt, result);
				right = rt;
			}
			System.out.println(result);
		}
	}
}
