import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _210923_BOJ_S3_1449_수리공_항승 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int result = 0;
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int index = 0; index < N; index++)
			arr[index] = Integer.parseInt(st.nextToken());
		Arrays.sort(arr);
		for (int index = 0; index < N; index++) {
			if (index == N - 1)
				result++;
			else {
				int length = L - 1;
				while (true) {
					if (index < N - 1 && arr[index + 1] - arr[index] <= length) {
						length -= (arr[index + 1] - arr[index]);
						index++;
					} else
						break;
				}
				result++;
			}
		}
		System.out.println(result);
	}
}
