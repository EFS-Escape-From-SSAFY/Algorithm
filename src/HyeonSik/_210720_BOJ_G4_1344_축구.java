import java.util.Scanner;

public class _210720_BOJ_G4_1344_축구 {
	static int[] prime = { 2, 3, 5, 7, 11, 13, 17 };
	static int[][] sum = new int[19][19];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		double a = 0;
		double b = 0;
		for (int primeNum : prime) {
			a += getCombination(18, primeNum) * getPercentage(A, primeNum);
			b += getCombination(18, primeNum) * getPercentage(B, primeNum);
		}
		double result = 1 - (1 - a) * (1 - b);
		System.out.println(result);
	}

	public static int getCombination(int n, int r) {
		if (sum[n][r] != 0)
			return sum[n][r];
		if (n == r || r == 0)
			return 1;
		return sum[n][r] = getCombination(n - 1, r - 1) + getCombination(n - 1, r);
	}

	public static double getPercentage(int goal, int count) {
		double goalPercent = (double) goal / 100;
		double notGoalPercent = (double) (100 - goal) / 100;
		double per = 1;
		for (int i = 0; i < count; i++)
			per *= goalPercent;
		for (int i = 0; i < 18 - count; i++)
			per *= notGoalPercent;
		return per;
	}
}
