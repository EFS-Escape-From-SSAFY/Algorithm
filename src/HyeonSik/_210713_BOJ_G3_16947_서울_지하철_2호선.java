import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _210713_BOJ_G3_16947_서울_지하철_2호선 {
	static int N;
	static boolean hasCycle[], visited[];
	static ArrayList<Integer>[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		arr = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++)
			arr[i] = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a].add(b);
			arr[b].add(a);
		}
		hasCycle = new boolean[N + 1];
		visited = new boolean[N + 1];
		// 순환역인지 dfs로 확인
		for (int index = 1; index <= N; index++) {
			Arrays.fill(visited, false);
			dfs(index, index, 0);
		}
		// 순환역이면 0을, 순환역이 아니면 bfs로 길이 찾기
		for (int index = 1; index <= N; index++) {
			if (hasCycle[index])
				sb.append("0 ");
			else {
				sb.append(bfs(index) + " ");
			}
		}
		System.out.println(sb);
	}

	private static void dfs(int start, int cur, int count) {
		if (start == cur && count >= 2) {
			hasCycle[start] = true;
			return;
		}
		visited[cur] = true;
		for (int next : arr[cur]) {
			if (!visited[next])
				dfs(start, next, count + 1);
			else {
				if (start == next && count >= 2) {
					hasCycle[start] = true;
					return;
				}
			}
		}
	}

	private static int bfs(int start) {
		int result = 0;
		Arrays.fill(visited, false);
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		queue.add(0);
		visited[start] = true;
		while (!queue.isEmpty()) {
			int station = queue.poll();
			int depth = queue.poll();
			if (hasCycle[station]) {
				result = depth;
				break;
			}

			for (int next : arr[station]) {
				if (visited[next])
					continue;
				visited[next] = true;
				queue.add(next);
				queue.add(depth + 1);
			}
		}
		return result;
	}
}
