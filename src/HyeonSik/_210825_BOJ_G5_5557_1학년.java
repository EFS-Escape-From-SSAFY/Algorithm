import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _210825_BOJ_G5_5557_1학년 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int[] numbers = new int[N + 1];
		long[][] dp = new long[N + 1][21];
		for (int index = 1; index <= N; index++)
			numbers[index] = Integer.parseInt(st.nextToken());
		// 초기 값
		dp[1][numbers[1]] = 1;
		for (int index = 2; index < N; index++) {
			int number = numbers[index];
			for (int sum = 0; sum <= 20; sum++) {
				// 덧셈
				if (sum - number >= 0 && dp[index - 1][sum - number] > 0) {
					dp[index][sum] += dp[index - 1][sum - number];
				}
				// 뺄셈
				if (sum + number <= 20 && dp[index - 1][sum + number] > 0) {
					dp[index][sum] += dp[index - 1][sum + number];
				}
			}
		}
		System.out.println(dp[N - 1][numbers[N]]);
	}
}
