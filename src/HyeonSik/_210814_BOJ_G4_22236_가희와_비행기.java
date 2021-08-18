import java.util.Scanner;

public class _210814_BOJ_G4_22236_가희와_비행기 {
	static int d, m;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		d = sc.nextInt();
		m = sc.nextInt();
		long[][] dp = new long[d / 2 + 2][d + 1];
		// 처음엔 위로 한 칸 올라가야함
		dp[1][1] = 1;
		// dp[height][distance]: distance 거리의 height 높이에 도달할 수 있는 비행기 가짓수
		for (int index = 2; index <= d; index++) {
			// 비행기가 '전체길이 / 2'보다 높이 올라가면, d일 때 착륙할 수 없음
			for (int height = 1; height <= d / 2; height++) {
				// 위에서 내려오거나, 아래에서 올라가거나
				dp[height][index] = (dp[height - 1][index - 1] + dp[height + 1][index - 1]) % m;
			}
		}
		System.out.println(dp[1][d - 1]);
		sc.close();
	}
}
