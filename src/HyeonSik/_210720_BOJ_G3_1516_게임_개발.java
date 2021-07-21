import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _210720_BOJ_G3_1516_게임_개발 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer>[] arr = new ArrayList[N + 1];

		int[] time = new int[N + 1];
		int[] degree = new int[N + 1];
		int[] result = new int[N + 1];
		for (int i = 1; i <= N; i++)
			arr[i] = new ArrayList<>();
		for (int index = 1; index <= N; index++) {
			st = new StringTokenizer(br.readLine());
			time[index] = Integer.parseInt(st.nextToken());
			while (st.hasMoreTokens()) {
				int cur = Integer.parseInt(st.nextToken());
				if (cur != -1) {
					arr[cur].add(index);
					degree[index]++;
				}
			}
		}
		Queue<Integer> queue = new LinkedList<>();
		for (int index = 1; index <= N; index++) {
			if (degree[index] == 0) {
				queue.add(index);
				result[index] = time[index];
			}
		}
		while (!queue.isEmpty()) {
			int curNode = queue.poll();

			for (int next : arr[curNode]) {
				result[next] = Math.max(result[next], result[curNode] + time[next]);
				degree[next]--;
				if (degree[next] == 0) {
					queue.add(next);
				}
			}
		}

		for (int index = 1; index <= N; index++)
			sb.append(result[index] + "\n");
		System.out.println(sb);
	}
}
