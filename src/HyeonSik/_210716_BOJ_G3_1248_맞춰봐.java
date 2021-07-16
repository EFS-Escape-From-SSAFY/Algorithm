import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _210716_BOJ_G3_1248_맞춰봐 {
	static int N;
	static String word;
	static int[] nums, sum;
	static char[][] operations;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		word = br.readLine();
		nums = new int[N + 1];
		sum = new int[N + 1];
		operations = new char[N + 1][N + 1];
		for (int index = 0, i = 1; i <= N; i++) {
			for (int j = i; j <= N; j++) {
				operations[i][j] = word.charAt(index++);
			}
		}
		dfs(1);
	}

	public static void dfs(int index) {
		if (index > N) {
			for (int i = 1; i <= N; i++)
				System.out.print(nums[i] + " ");
			System.exit(0);
		}
		// op: index번 째 숫자의 기호
		// op에 따라 들어갈 숫자의 범위가 나눠짐
		char op = operations[index][index];
		if (op == '0') {
			sum[index] = sum[index - 1];
			if (canGo(index)) {
				nums[index] = 0;
				dfs(index + 1);
			}
		} else {
			for (int i = 1; i <= 10; i++) {
				int num = i;
				if (op == '-')
					num *= -1;
				sum[index] = sum[index - 1] + num;
				if (canGo(index)) {
					nums[index] = num;
					dfs(index + 1);
				}
				sum[index] -= num;
			}
		}
	}

	private static boolean canGo(int index) {
		for (int row = 1; row <= index; row++) {
			for (int col = row; col <= index; col++) {
				if (operations[row][col] == '+' && (sum[col] - sum[row - 1]) <= 0)
					return false;
				if (operations[row][col] == '-' && (sum[col] - sum[row - 1]) >= 0)
					return false;
				if (operations[row][col] == '0' && (sum[col] - sum[row - 1]) != 0)
					return false;
			}
		}
		return true;
	}
}