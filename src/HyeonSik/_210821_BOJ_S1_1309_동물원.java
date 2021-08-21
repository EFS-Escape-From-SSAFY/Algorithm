import java.util.Scanner;

public class _210821_BOJ_S1_1309_동물원 {
	static int MOD = 9901;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] dp = new int[N + 1][2];
		// N = 1일 때
		int result = 3, sum = 2;
		// sum = index번 칸 까지의 모든 dp 합
		dp[1][0] = dp[1][1] = 1;
		for (int index = 2; index <= N; index++) {
			// 다음 dp 값 = 이전의 모든 dp 합 - 한칸 위에 있는 우리 + 현재 칸만 사용하는 경우
			int calc = sum - dp[index - 1][0] + 1;
			if (calc < 0)
				calc = MOD + calc;
			dp[index][0] = dp[index][1] = calc;
			sum = (sum + dp[index][0] * 2) % MOD;
			result = (result + dp[index][0] * 2) % MOD;
		}
		System.out.println(result);
	}
}
