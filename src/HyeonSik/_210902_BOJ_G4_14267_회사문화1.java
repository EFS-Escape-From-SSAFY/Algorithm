import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _210902_BOJ_G4_14267_회사문화1 {
	// boss[index] = index번 사람의 상사
	static int[] boss;
	// dp[index] = 탐색된 직원의 총 칭찬 수치
	static int[] dp;
	// score[index] = index번 직원이 받은 칭찬 수치
	static int[] score;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		boss = new int[n + 1];
		dp = new int[n + 1];
		score = new int[n + 1];
		st = new StringTokenizer(br.readLine());
		for (int index = 1; index <= n; index++) {
			int num = Integer.parseInt(st.nextToken());
			boss[index] = num;
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int person = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			score[person] += w;
		}
		// dp 탐색
		for (int index = 1; index <= n; index++)
			dfs(index);
		// output
		for (int index = 1; index <= n; index++)
			sb.append(dp[index] + " ");
		sb.setLength(sb.length() - 1);
		System.out.println(sb);
	}

	private static int dfs(int index) {
		// 사장은 칭찬을 받지 않으므로, 0리턴
		if (index == 1)
			return 0;
		// 이미 탐색된 직원이면, return
		if (dp[index] != 0)
			return dp[index];
		// 자기 점수 + 상사로부터 얻은 점수
		return dp[index] = score[index] + dfs(boss[index]);
	}
}
