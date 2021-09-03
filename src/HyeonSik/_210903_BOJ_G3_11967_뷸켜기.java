import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _210903_BOJ_G3_11967_뷸켜기 {
	static int[][] moveDir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		boolean[][] visited = new boolean[N + 1][N + 1];
		boolean[][] isTurnOn = new boolean[N + 1][N + 1];
		HashSet<Pos> set = new HashSet<>();
		ArrayList<Pos>[][] map = new ArrayList[N + 1][N + 1];
		for (int y = 1; y <= N; y++)
			for (int x = 1; x <= N; x++)
				map[y][x] = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			int x, y, a, b;
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			map[y][x].add(new Pos(b, a));
		}
		// (1, 1) 부터 탐색
		Queue<Pos> queue = new LinkedList<>();
		queue.add(new Pos(1, 1));
		visited[1][1] = true;
		isTurnOn[1][1] = true;
		// BFS
		while (!queue.isEmpty()) {
			// 현재 방 좌표
			Pos cur = queue.poll();
			int y = cur.y, x = cur.x;

			// 현재 방에서 불 켜기
			for (Pos next : map[y][x]) {
				// 이미 불이 켜져있으면, continue
				if (isTurnOn[next.y][next.x])
					continue;
				isTurnOn[next.y][next.x] = true;
				// 방에 불을 켬으로써 들어갈 수 있으면, 탐색
				if (visited[next.y][next.x]) {
					queue.add(new Pos(next.y, next.x));
				}
			}

			for (int dir = 0; dir < 4; dir++) {
				int ny = y + moveDir[dir][0];
				int nx = x + moveDir[dir][1];

				if (ny < 1 || nx < 1 || ny > N || nx > N || visited[ny][nx])
					continue;

				visited[ny][nx] = true;
				// 이미 방에 불이 켜진 경우, queue에 넣어서 탐색
				if (isTurnOn[ny][nx]) {
					queue.add(new Pos(ny, nx));
				}
			}
		}
		// 불 켜진 방 개수 구하기
		int result = 0;
		for (int y = 1; y <= N; y++)
			for (int x = 1; x <= N; x++)
				if (isTurnOn[y][x])
					result++;
		System.out.println(result);
	}

	public static class Pos {
		int y, x;

		Pos(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
}
