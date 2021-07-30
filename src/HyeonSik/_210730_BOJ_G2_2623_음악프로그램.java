import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _210730_BOJ_G2_2623_음악프로그램 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] depth = new int[N + 1];
		ArrayList<Integer>[] order = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++)
			order[i] = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int prev = Integer.parseInt(st.nextToken());
			while (st.hasMoreTokens()) {
				int next = Integer.parseInt(st.nextToken());
				depth[next]++;
				order[prev].add(next);
				prev = next;
			}
		}

		Queue<Integer> queue = new LinkedList<>();
		int visitCount = 0;
		for (int index = 1; index <= N; index++) {
			if (depth[index] == 0) {
				queue.add(index);
				visitCount++;
			}
		}
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			sb.append(cur + "\n");

			for (int next : order[cur]) {
				depth[next]--;
				if (depth[next] == 0) {
					visitCount++;
					queue.add(next);
				}
			}
		}
		if (visitCount == N)
			System.out.println(sb);
		else
			System.out.println(0);
	}
}
