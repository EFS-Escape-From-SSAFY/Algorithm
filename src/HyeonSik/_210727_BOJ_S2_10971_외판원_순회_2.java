import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _210727_BOJ_S2_10971_외판원_순회_2 {
	static int N;
	static int[][] dp;
	static int[][] map;
	static int INF = 1000000000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		dp = new int[1 << N][N];
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		System.out.println(travel(1, 0));
	}

	public static int travel(int visited, int city) {
		// 전부 방문한 경우
		if (visited == (1 << N) - 1) {
			if (map[city][0] == 0)
				return INF;
			else
				return map[city][0];
		}
		if (dp[visited][city] != 0)
			return dp[visited][city];
		dp[visited][city] = INF;
		for (int next = 0; next < N; next++) {
			if (map[city][next] != 0 && (visited & (1 << next)) == 0) {
				dp[visited][city] = Math.min(dp[visited][city], travel(visited | (1 << next), next) + map[city][next]);
			}
		}
		return dp[visited][city];
	}
}
