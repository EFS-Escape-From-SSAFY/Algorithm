import java.util.Scanner;

public class _210919_BOJ_G3_1256_사전 {
	static int INF = 1000000000;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int K = sc.nextInt();
		long[][] dp = new long[N + M + 1][M + 1];
		dp[0][0] = 1;
		for (int i = 1; i <= N + M; i++) {
			dp[i][0] = 1;
			for (int j = 1; j <= M; j++) {
				dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
				// 값이 10억이 넘으면, 어짜피 갈 수 없음 -> INF
				if (dp[i][j] > INF)
					dp[i][j] = INF + 1;
			}
		}
		if (dp[N + M][M] < K)
			System.out.println(-1);
		else {
			StringBuilder sb = new StringBuilder();
			for (int index = N + M; index >= 1; index--) {
				// dp[index-1][M]: a를 선택했을 때 나올수 있는 개수
				// dp[index-1][M] >= K면 a를 선택했을때 원하는 단어로 갈 수 있음 -> M(z의 개수)값 그대로
				// dp[index-1][M] < K 면 z를 선택했을때 원하는 단어로 갈 수 없음
				if (dp[index - 1][M] >= K) {
					sb.append('a');
				} else {
					sb.append('z');
					K -= dp[index - 1][M];
					M--;
				}
			}
			System.out.println(sb);
		}
	}
}
