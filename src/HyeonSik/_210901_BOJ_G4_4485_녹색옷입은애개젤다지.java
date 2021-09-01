import java.util.PriorityQueue;
import java.util.StringTokenizer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _210901_BOJ_G4_4485_녹색옷입은애개젤다지 {
	static int moveDir[][] = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static int INF = 1000000000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int TC = 1;
		while (true) {
			// Input
			int N = Integer.parseInt(br.readLine());
			if (N == 0)
				break;
			int[][] arr = new int[N][N];
			int[][] dist = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					dist[i][j] = INF;
				}
			}
			// 다익스트라
			PriorityQueue<Node> pq = new PriorityQueue<>();
			dist[0][0] = arr[0][0];
			pq.add(new Node(0, 0, arr[0][0]));

			while (!pq.isEmpty()) {
				Node cur = pq.poll();
				int y = cur.y, x = cur.x, weight = cur.weight;

				if (weight > dist[y][x])
					continue;
				for (int dir = 0; dir < 4; dir++) {
					int ny = y + moveDir[dir][0];
					int nx = x + moveDir[dir][1];
					if (ny < 0 || nx < 0 || ny >= N || nx >= N)
						continue;
					int nextWeight = weight + arr[ny][nx];
					if (nextWeight < dist[ny][nx]) {
						dist[ny][nx] = nextWeight;
						pq.add(new Node(ny, nx, nextWeight));
					}
				}
			}

			sb.append("Problem " + TC + ": " + dist[N - 1][N - 1] + "\n");
			TC++;
		}
		System.out.println(sb);
	}

	public static class Node implements Comparable<Node> {
		int y, x, weight;

		Node(int y, int x, int weight) {
			this.y = y;
			this.x = x;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return this.weight - o.weight;
		}
	}
}
