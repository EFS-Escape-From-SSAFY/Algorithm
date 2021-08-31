import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _210831_BOJ_G5_2230_수_고르기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N, M, result = Integer.MAX_VALUE;
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		// 입력 후 정렬
		int[] numbers = new int[N];
		for (int i = 0; i < N; i++)
			numbers[i] = Integer.parseInt(br.readLine());
		Arrays.sort(numbers);
		// n * log n 탐색
		for (int index = 0; index < N; index++) {
			// 이분탐색
			int left = index, right = N - 1, mid;
			while (left <= right) {
				mid = (left + right) / 2;
				int diff = Math.abs(numbers[mid] - numbers[index]);
				if (diff > M) {
					right = mid - 1;
					result = Math.min(result, diff);
				} else if (diff < M) {
					left = mid + 1;
				} else {
					result = M;
					break;
				}
			}
		}
		System.out.println(result);
	}
}
