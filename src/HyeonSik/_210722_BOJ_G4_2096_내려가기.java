import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _210722_BOJ_G4_2096_내려가기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());
		int[][] minDP = new int[2][3];
		int[][] maxDP = new int[2][3];
		int[] arr = new int[3];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++)
				arr[j] = Integer.parseInt(st.nextToken());
			// 최대
			maxDP[1][0] = Math.max(maxDP[0][0], maxDP[0][1]) + arr[0];
			maxDP[1][1] = Math.max(maxDP[0][0], Math.max(maxDP[0][1], maxDP[0][2])) + arr[1];
			maxDP[1][2] = Math.max(maxDP[0][1], maxDP[0][2]) + arr[2];
			// 최소
			minDP[1][0] = Math.min(minDP[0][0], minDP[0][1]) + arr[0];
			minDP[1][1] = Math.min(minDP[0][0], Math.min(minDP[0][1], minDP[0][2])) + arr[1];
			minDP[1][2] = Math.min(minDP[0][1], minDP[0][2]) + arr[2];
			// 옮기기
			for (int j = 0; j < 3; j++) {
				minDP[0][j] = minDP[1][j];
				maxDP[0][j] = maxDP[1][j];
			}
		}
		System.out.print(Math.max(maxDP[1][0], Math.max(maxDP[1][1], maxDP[1][2])) + " ");
		System.out.print(Math.min(minDP[1][0], Math.min(minDP[1][1], minDP[1][2])) + " ");
	}
}
