import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class _210907_BOJ_G4_1744_수묶기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Integer[] arr = new Integer[N + 1];
		for (int index = 1; index <= N; index++)
			arr[index] = Integer.parseInt(br.readLine());
		Arrays.sort(arr, 1, N + 1, Collections.reverseOrder());
		int[] dp = new int[N + 1];
		dp[1] = arr[1];
		for (int index = 2; index <= N; index++) 
			dp[index] = Math.max(dp[index - 2] + arr[index - 1] * arr[index], dp[index - 1] + arr[index]);
		System.out.println(dp[N]);
	}
}
