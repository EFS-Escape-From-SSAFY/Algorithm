import java.util.Scanner;

public class _210715_BOJ_G5_12878_Blocks {
	static long[][] matrix = { { 2, 1, 1, 0 }, { 1, 2, 0, 1 }, { 1, 0, 2, 1 }, { 0, 1, 1, 2 } };
	static long[][][] calculatedMatrix;
	static int MOD = 10007;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		calculatedMatrix = new long[32][4][4];
		for (int i = 0; i < 4; i++)
			for (int j = 0; j < 4; j++)
				calculatedMatrix[1][i][j] = matrix[i][j];
		for (int index = 1; (1 << index) <= N; index++) {
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					for (int k = 0; k < 4; k++) {
						calculatedMatrix[index + 1][i][j] = (calculatedMatrix[index + 1][i][j] + calculatedMatrix[index][i][k] * calculatedMatrix[index][k][j]) % MOD;
					}
				}
			}
		}
		long arr[] = { 1, 0, 0, 0 };
		// bit가 N에 포함될 때
		for (int bit = 0; (1 << bit) <= N; bit++) {
			if (((1 << bit) & N) == 0)
				continue;
			long[] temp = new long[4];
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					temp[i] = (temp[i] + (arr[j] * calculatedMatrix[bit + 1][i][j])) % MOD;
				}
			}
			for (int i = 0; i < 4; i++)
				arr[i] = temp[i];
		}
		System.out.println(arr[0]);
	}
}
