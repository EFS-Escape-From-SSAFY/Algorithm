import java.util.Scanner;

public class _210812_BOJ_G5_22251_빌런_호석 {
	static int converter[][] = { 
			//0  1  2  3  4  5  6  7  8  9
			{ 0, 4, 3, 3, 4, 3, 2, 3, 1, 2 }, 
			{ 4, 0, 5, 3, 2, 5, 6, 1, 5, 4 }, 
			{ 3, 5, 0, 2, 5, 4, 3, 4, 2, 3 }, 
			{ 3, 3, 2, 0, 3, 2, 3, 2, 2, 1 }, 
			{ 4, 2, 5, 3, 0, 3, 4, 3, 3, 2 }, 
			{ 3, 5, 4, 2, 3, 0, 1, 4, 2, 1 }, 
			{ 2, 6, 3, 3, 4, 1, 0, 5, 1, 2 },
			{ 3, 1, 4, 2, 3, 4, 5, 0, 4, 3 }, 
			{ 1, 5, 2, 2, 3, 2, 1, 4, 0, 1 },
			{ 2, 4, 3, 1, 2, 1, 2, 3, 1, 0 }
		};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int P = sc.nextInt();
		int X = sc.nextInt();

		int result = 0;
		int[] startNumber = convertNumber(X, K);
		for (int number = 1; number <= N; number++) {
			int[] targetNumber = convertNumber(number, K);
			int count = 0;
			for (int index = 0; index < K; index++)
				count += converter[startNumber[index]][targetNumber[index]];
			if (count <= P)
				result++;
		}
		sc.close();
		System.out.println(result - 1);
	}

	public static int[] convertNumber(int number, int K) {
		int[] arr = new int[K];
		for (int index = K - 1; index >= 0; index--) {
			arr[index] = number % 10;
			number /= 10;
		}
		return arr;
	}
}
