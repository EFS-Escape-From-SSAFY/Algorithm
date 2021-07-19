import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _210719_BOJ_G4_1774_우주신과의_교감 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		double result = 0;
		// positions[index]: index번 우주신의 (x, y) 좌표
		pos[] positions = new pos[N + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			long x = Long.parseLong(st.nextToken());
			long y = Long.parseLong(st.nextToken());
			positions[i] = new pos(x, y);
		}
		// arr에 각 우주신 사이의 거리 전부 넣기
		ArrayList<info>[] arr = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++)
			arr[i] = new ArrayList<>();
		// 이미 연결된 통로일 경우
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			// 이미 연결된 통로의 거리를 0으로 만듬
			arr[a].add(new info(b, 0));
			arr[b].add(new info(a, 0));
		}
		// 두 우주신 사이의 가능한 모든 통로 거리 설정
		for (int i = 1; i <= N; i++) {
			for (int j = i + 1; j <= N; j++) {
				double length = getDistance(positions[i], positions[j]);
				arr[i].add(new info(j, length));
				arr[j].add(new info(i, length));
			}
		}
		PriorityQueue<info> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[N + 1];
		// 1번 우주신에서 탐색 가능한 모든 정보 넣기
		visited[1] = true;
		for (info cur : arr[1])
			pq.add(cur);
		// 탐색
		while (!pq.isEmpty()) {
			info cur = pq.poll();
			if (visited[cur.dest])
				continue;
			visited[cur.dest] = true;
			result += cur.weight;
			for (info next : arr[cur.dest]) {
				if (visited[next.dest])
					continue;
				pq.add(next);
			}
		}
		// String.format 통해서 소수점 둘째 자리까지 출력
		System.out.println(String.format("%.2f", result));
	}

	static double getDistance(pos a, pos b) {
		return Math.sqrt(Math.pow((a.y - b.y), 2) + Math.pow((a.x - b.x), 2));
	}

	static class pos {
		long y, x;

		pos(long y, long x) {
			this.y = y;
			this.x = x;
		}
	}

	static class info implements Comparable<info> {
		int dest;
		double weight;

		info(int dest, double weight) {
			this.dest = dest;
			this.weight = weight;
		}

		@Override
		public int compareTo(info o) {
			return Double.compare(this.weight, o.weight);
		}
	}
}
