import java.util.StringTokenizer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _210727_BOJ_G2_17182_우주_탐사선 {
	static int INF = 1000000000;
	static int[][] dp;
	static int[][] arr;
	static int N, K;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N][N];
		dp = new int[1 << N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++)
				arr[i][j] = Integer.parseInt(st.nextToken());
			arr[i][i] = INF;
		}
		// 플로이드 와샬로 i->j로 가는 최단길이 찾기
		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
				}
			}
		}
		// 찾은 최단길이로 탐색
		System.out.println(travel(1 << K, K));
	}

	public static int travel(int visited, int cur) {
		// 전부 방문한 경우, 최솟값 확인
		if (visited == (1 << N) - 1) {
			return 0;
		}
		if (dp[visited][cur] == 0)
			dp[visited][cur] = INF;
		for (int next = 0; next < N; next++) {
			if ((visited & (1 << next)) == 0) {
				dp[visited][cur] = Math.min(dp[visited][cur], travel(visited | (1 << next), next) + arr[cur][next]);
			}
		}
		return dp[visited][cur];
	}
}
