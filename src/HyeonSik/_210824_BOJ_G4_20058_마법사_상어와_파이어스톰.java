import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _210824_BOJ_G4_20058_마법사_상어와_파이어스톰 {
	static int[][] moveDir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static int[][] map;
	static int N, Q;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		N = (1 << N);
		map = new int[N][N];
		for (int i = 0; i < (N); i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < (N); j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		// Q번 파이어스톰 실행
		while (st.hasMoreTokens()) {
			int L = Integer.parseInt(st.nextToken());

			// rotate
			rotate(L);

			// 2칸 이상 인접해있지 않으면, 얼음 1 줄어듬
			Queue<Integer> queue = new LinkedList<>();
			for (int y = 0; y < N; y++) {
				for (int x = 0; x < N; x++) {
					if (map[y][x] > 0 && !hasIce(y, x)) {
						queue.add(y);
						queue.add(x);
					}
				}
			}
			while (!queue.isEmpty()) {
				int y = queue.poll();
				int x = queue.poll();
				map[y][x]--;
			}
		}
		// 남아있는 얼음 구하기
		int total = 0, maxValue = 0;
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++) {
				total += map[i][j];
			}
		// BFS로 덩어리 구하기
		boolean[][] visited = new boolean[N][N];
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < N; x++) {
				if (map[y][x] != 0) {
					Queue<Integer> queue = new LinkedList<>();
					int count = 1;
					visited[y][x] = true;
					queue.add(y);
					queue.add(x);
					while (!queue.isEmpty()) {
						int cury = queue.poll();
						int curx = queue.poll();

						for (int dir = 0; dir < 4; dir++) {
							int ny = cury + moveDir[dir][0];
							int nx = curx + moveDir[dir][1];

							if (ny < 0 || nx < 0 || ny >= N || nx >= N || map[ny][nx] == 0 || visited[ny][nx])
								continue;
							visited[ny][nx] = true;
							queue.add(ny);
							queue.add(nx);
							count++;
						}
					}
					maxValue = Math.max(maxValue, count);
				}
			}
		}
		System.out.println(total);
		System.out.println(maxValue);
	}

	static void rotate(int level) {
		int weight = 1 << level;
		// 복사
		int[][] temp = new int[N][N];
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++)
				temp[i][j] = map[i][j];
		// 각 칸에 대해 rotate 실행
		for (int y = 0; y < N; y += weight) {
			for (int x = 0; x < N; x += weight) {

				for (int ny = 0; ny < weight; ny++) {
					for (int nx = 0; nx < weight; nx++) {
						map[y + ny][x + nx] = temp[y + weight - nx - 1][x + ny];
					}
				}
			}
		}
	}

	static boolean hasIce(int y, int x) {
		int count = 0;
		for (int dir = 0; dir < 4; dir++) {
			int ny = y + moveDir[dir][0];
			int nx = x + moveDir[dir][1];
			if (ny < 0 || nx < 0 || ny >= N || nx >= N || map[ny][nx] == 0)
				continue;
			count++;
		}
		return count > 2 ? true : false;
	}
}
