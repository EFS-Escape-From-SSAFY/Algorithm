import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _210826_BOJ_S2_1890_점프 {
	static int moveDir[][] = { { 1, 0 }, { 0, 1 } };
	static int N;
	static int[][] map;
	static long[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		dp = new long[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = -1;
			}
		}
		dp[N - 1][N - 1] = 1;
		System.out.println(dfs(0, 0));
	}

	private static long dfs(int y, int x) {
		// 이미 방문한 경우, return
		if (dp[y][x] != -1)
			return dp[y][x];
		// 초기화
		dp[y][x] = 0;
		// 아래로
		int ny = y + moveDir[0][0] * map[y][x], nx = x + moveDir[0][1] * map[y][x];
		if (ny < N && nx < N) {
			dp[y][x] += dfs(ny, nx);
		}
		// 오른쪽으로
		ny = y + moveDir[1][0] * map[y][x];
		nx = x + moveDir[1][1] * map[y][x];
		if (ny < N && nx < N) {
			dp[y][x] += dfs(ny, nx);
		}
		return dp[y][x];
	}
}
