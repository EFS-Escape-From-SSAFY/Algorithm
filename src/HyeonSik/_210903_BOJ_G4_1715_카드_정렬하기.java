import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class _210903_BOJ_G4_1715_카드_정렬하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int result = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < N; i++)
			pq.add(Integer.parseInt(br.readLine()));
		while (pq.size() != 1) {
			int temp = pq.poll() + pq.poll();
			result += temp;
			pq.add(temp);
		}
		System.out.println(result);
	}
}
