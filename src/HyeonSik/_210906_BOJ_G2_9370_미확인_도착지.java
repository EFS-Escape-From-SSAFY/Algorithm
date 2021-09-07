import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class _210906_BOJ_G2_9370_미확인_도착지 {
	static int n, m, t, s, g, h, a, b, d, lengthGtoH;
	static int INF = 1000000000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		while (TC-- > 0) {
			// Input
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			t = Integer.parseInt(st.nextToken());
			// 경로 저장
			ArrayList<Info>[] arr = new ArrayList[n + 1];
			TreeSet<Integer> candidates = new TreeSet<>();
			for (int index = 1; index <= n; index++)
				arr[index] = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			s = Integer.parseInt(st.nextToken());
			g = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				d = Integer.parseInt(st.nextToken());
				arr[a].add(new Info(b, d));
				arr[b].add(new Info(a, d));
				// g -> h로 가는 거리
				if ((a == g && b == h) || (b == g && a == h))
					lengthGtoH = d;
			}
			for (int index = 0; index < t; index++)
				candidates.add(Integer.parseInt(br.readLine()));
			// 다익스트라
			int[] dist = new int[n + 1];
			int[] distG = new int[n + 1];
			int[] distH = new int[n + 1];
			// s로부터 모든 최단 거리
			dist = dijkstra(s, arr);
			// g로부터 모든 최단 거리
			distG = dijkstra(g, arr);
			// h로부터 모든 최단 거리
			distH = dijkstra(h, arr);

			for (int target : candidates) {
				if (canBeCandidate(dist, distG, distH, target))
					sb.append(target + " ");
			}
			// 마지막 공백 없애기
			sb.setLength(sb.length() - 1);
			sb.append("\n");
		}
		System.out.println(sb);
	}

	public static boolean canBeCandidate(int[] dist, int[] distG, int[] distH, int target) {
		// s -> target으로 최단 거리가 s->g->h->target과 같은 경우
		if (dist[target] == lengthGtoH + distG[s] + distH[target])
			return true;
		// s -> target으로 최단 거리가 s->h->g->target과 같은 경우
		if (dist[target] == lengthGtoH + distG[target] + distH[s])
			return true;
		return false;
	}

	public static int[] dijkstra(int start, ArrayList<Info>[] arr) {
		int[] dist = new int[n + 1];
		PriorityQueue<Info> pq = new PriorityQueue<>();
		Arrays.fill(dist, INF);
		pq.add(new Info(start, 0));
		dist[start] = 0;

		while (!pq.isEmpty()) {
			Info cur = pq.poll();

			if (cur.distance > dist[cur.destination])
				continue;

			for (Info next : arr[cur.destination]) {
				int nextDest = next.destination;
				int nextDist = next.distance + cur.distance;

				if (nextDist >= dist[nextDest])
					continue;
				dist[nextDest] = nextDist;
				pq.add(new Info(nextDest, nextDist));
			}
		}
		return dist;
	}

	public static class Info implements Comparable<Info> {
		int destination, distance;

		Info(int destination, int distance) {
			this.destination = destination;
			this.distance = distance;
		}

		@Override
		public int compareTo(Info o) {
			return this.distance - o.distance;
		}
	}
}
