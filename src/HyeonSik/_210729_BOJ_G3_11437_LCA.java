import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _210729_BOJ_G3_11437_LCA {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer>[] arr = new ArrayList[N + 1];
		int[] parent = new int[N + 1];
		int[] depth = new int[N + 1];
		for (int i = 1; i <= N; i++)
			arr[i] = new ArrayList<>();
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a].add(b);
			arr[b].add(a);
		}
		// BFS로 각 노드의 깊이 구하기
		Queue<Integer> queue = new LinkedList<>();
		queue.add(1);
		depth[1] = 1;
		while (!queue.isEmpty()) {
			int cur = queue.poll();

			for (int next : arr[cur]) {
				if (depth[next] != 0)
					continue;
				depth[next] = depth[cur] + 1;
				parent[next] = cur;
				queue.add(next);
			}
		}
		// 두 쌍의 공통 조상 찾기
		int M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			while (a != b) {
				if (depth[a] > depth[b]) {
					a = parent[a];
				} else if (depth[a] < depth[b]) {
					b = parent[b];
				} else {
					a = parent[a];
					b = parent[b];
				}
			}
			sb.append(a + "\n");
		}
		System.out.println(sb);
	}
}
