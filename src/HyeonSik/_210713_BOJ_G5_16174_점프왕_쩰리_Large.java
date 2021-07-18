import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _210713_BOJ_G5_16174_점프왕_쩰리_Large {
	static String success = "HaruHaru";
	static String fail = "Hing";
	// 아래, 오른쪽 순서
	static int[][] moveDir = { { 1, 0 }, { 0, 1 } };
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		boolean[][][] visited = new boolean[2][N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		Queue<info> queue = new LinkedList<>();
		queue.add(new info(0, 0, 0));
		queue.add(new info(0, 0, 1));

		while (!queue.isEmpty()) {
			info cur = queue.poll();
			// 젤리 끝에 도달한 경우, 성공 출력 후 끝내기
			if (cur.y == N - 1 && cur.x == N - 1) {
				System.out.println(success);
				System.exit(0);
			}
			// 이미 방문한 경우, 탐색 중지
			if (visited[cur.dir][cur.y][cur.x])
				continue;
			visited[cur.dir][cur.y][cur.x] = true;
			// 젤리의 다음 칸 구하기
			int ny = cur.y + map[cur.y][cur.x] * moveDir[cur.dir][0];
			int nx = cur.x + map[cur.y][cur.x] * moveDir[cur.dir][1];
			// 범위 벗어나는 경우, 탐색 중지
			if (ny >= N || nx >= N)
				continue;
			queue.add(new info(ny, nx, 0));
			queue.add(new info(ny, nx, 1));
		}
		System.out.println(fail);
	}

	static class info {
		int y, x, dir;

		info(int y, int x, int dir) {
			this.y = y;
			this.x = x;
			this.dir = dir;
		}
	}
}
