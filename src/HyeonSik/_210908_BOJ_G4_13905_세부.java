import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _210908_BOJ_G4_13905_세부 {
	static int N, M, s, e, h1, h2, k;
	static int INF = 1000000000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		s = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		ArrayList<Info>[] arr = new ArrayList[N + 1];
		for (int index = 1; index <= N; index++)
			arr[index] = new ArrayList<>();
		for (int index = 0; index < M; index++) {
			st = new StringTokenizer(br.readLine());
			h1 = Integer.parseInt(st.nextToken());
			h2 = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			arr[h1].add(new Info(h2, k));
			arr[h2].add(new Info(h1, k));
		}
		// 프림
		PriorityQueue<Info> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[N + 1];
		int[] distance = new int[N + 1];
		Arrays.fill(distance, INF);
		// s부터 시작
		for(Info next: arr[s])
			pq.add(new Info(s, next.dest, next.weight));
		visited[s] = true;

		while (!pq.isEmpty()) {
			Info cur = pq.poll();
			// 이미 방문한 경우
			if (visited[cur.dest])
				continue;
			visited[cur.dest] = true;
			distance[cur.dest] = Math.min(distance[cur.prev], cur.weight);

			for (Info next : arr[cur.dest]) {
				if (visited[next.dest])
					continue;
				pq.add(new Info(cur.dest, next.dest, next.weight));
			}
		}
		if(distance[e] == INF)
			System.out.println(0);
		else
			System.out.println(distance[e]);
	}

	public static class Info implements Comparable<Info> {
		int prev, dest, weight;

		Info(int dest, int weight) {
			this.dest = dest;
			this.weight = weight;
		}

		Info(int prev, int dest, int weight) {
			this.prev = prev;
			this.dest = dest;
			this.weight = weight;
		}

		@Override
		public int compareTo(Info o) {
			return o.weight - this.weight;
		}
	}
}
