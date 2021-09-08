import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _210908_BOJ_G4_13905_세부_크루스칼 {
	static int N, M, s, e, h1, h2, k, answer = 0;
	static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		s = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		PriorityQueue<Node> pq = new PriorityQueue<>();
		// root 설정
		parent = new int[N + 1];
		for (int index = 1; index <= N; index++)
			parent[index] = index;
		for (int index = 0; index < M; index++) {
			st = new StringTokenizer(br.readLine());
			h1 = Integer.parseInt(st.nextToken());
			h2 = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			pq.add(new Node(h1, h2, k));
		}

		// 모든 간선 보기
		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			// 사이클이 없는 경우
			if (!isSameParent(cur.from, cur.to)) {
				// 합치기
				union(cur.from, cur.to);
				// s와 e가 이어진 경우(현재 간선이 s와 e를 잇는 최솟값임), break
				if (isSameParent(s, e)) {
					answer = cur.distance;
					break;
				}
			}
		}
		System.out.println(answer);
	}

	static int getParent(int num) {
		if (parent[num] == num)
			return num;
		return parent[num] = getParent(parent[num]);
	}

	static void union(int a, int b) {
		a = getParent(a);
		b = getParent(b);
		if (a < b)
			parent[a] = b;
		else
			parent[b] = a;
	}

	static boolean isSameParent(int a, int b) {
		if (getParent(a) == getParent(b))
			return true;
		return false;
	}

	static class Node implements Comparable<Node> {
		int from, to, distance;

		Node(int from, int to, int distance) {
			this.from = from;
			this.to = to;
			this.distance = distance;
		}

		@Override
		public int compareTo(Node o) {
			return o.distance - this.distance;
		}
	}
}
