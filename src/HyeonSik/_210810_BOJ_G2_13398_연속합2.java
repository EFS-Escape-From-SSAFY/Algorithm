import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _210810_BOJ_G2_13398_연속합2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N + 1];
		int[][] dp = new int[2][N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		// 한 번도 숫자를 선택하지 않는 것 방지
		dp[0][0] = dp[1][0] = -1000000000;
		// dp[0][index] : 수를 제거하지 않았을 때
		// dp[1][index] : 이미 수를 제거했을 때
		for (int index = 1; index <= N; index++) {
			dp[0][index] = Math.max(dp[0][index - 1] + arr[index], arr[index]);
			dp[1][index] = Math.max(dp[1][index - 1] + arr[index], dp[0][index - 1]);
		}
		int result = Integer.MIN_VALUE;
		for (int index = 1; index <= N; index++) {
			result = Math.max(result, dp[0][index]);
			result = Math.max(result, dp[1][index]);
		}
		System.out.println(result);
	}
}
