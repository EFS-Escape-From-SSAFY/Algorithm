import java.util.Scanner;

public class _210830_BOJ_G4_12888_완전_이진_트리_도로_네트워크 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int H = sc.nextInt();
		long[] dp = new long[61];
		dp[0] = 1;
		dp[1] = 1;
		for (int index = 2; index <= H; index++) {
			// 가장 바깥쪽 한개
			dp[index] = 1;
			// 내부에 index-2개 까지 2번씩 반복됨
			for (int i = 0; i <= index - 2; i++)
				dp[index] += 2 * dp[i];
		}
		System.out.println(dp[H]);
	}
}
