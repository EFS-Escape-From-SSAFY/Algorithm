import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _210716_BOJ_G3_1958_LCS_3 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String word1 = br.readLine();
		String word2 = br.readLine();
		String word3 = br.readLine();
		int len1 = word1.length();
		int len2 = word2.length();
		int len3 = word3.length();
		int[][][] dp = new int[len1 + 1][len2 + 1][len3 + 1];
		// 탐색
		for (int i = 1; i <= len1; i++) {
			for (int j = 1; j <= len2; j++) {
				for (int k = 1; k <= len3; k++) {
					// 세 문자가 모두 같다면
					if (word1.charAt(i - 1) == word2.charAt(j - 1) && word2.charAt(j - 1) == word3.charAt(k - 1)) {
						dp[i][j][k] = dp[i - 1][j - 1][k - 1] + 1;
					} else {
						dp[i][j][k] = Math.max(dp[i - 1][j][k], Math.max(dp[i][j - 1][k], dp[i][j][k - 1]));
					}
				}
			}
		}
		System.out.println(dp[len1][len2][len3]);
	}
}
