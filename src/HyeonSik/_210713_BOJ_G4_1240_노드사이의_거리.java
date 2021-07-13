import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _210713_BOJ_G4_1240_노드사이의_거리 {
	static int N, M;
	static ArrayList<info>[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++)
			arr[i] = new ArrayList<>();
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int length = Integer.parseInt(st.nextToken());
			arr[a].add(new info(b, length));
			arr[b].add(new info(a, length));
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			sb.append(getLength(a, b) + "\n");
		}
		System.out.println(sb);
	}

	private static int getLength(int a, int b) {
		boolean[] visited = new boolean[N + 1];
		int distance = 0;
		visited[a] = true;
		Queue<info> queue = new LinkedList<>();
		queue.add(new info(a, 0));
		while (!queue.isEmpty()) {
			info cur = queue.poll();
			if (cur.dest == b) {
				distance = cur.weight;
				break;
			}
			for (info next : arr[cur.dest]) {
				if (visited[next.dest])
					continue;
				visited[next.dest] = true;
				queue.add(new info(next.dest, cur.weight + next.weight));
			}
		}
		return distance;
	}

	static class info {
		int dest, weight;

		info(int dest, int weight) {
			this.dest = dest;
			this.weight = weight;
		}
	}
}
