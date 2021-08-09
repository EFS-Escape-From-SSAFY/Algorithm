import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _210809_BOJ_S1_11497_통나무_건너뛰기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr);
			int[] sorted = new int[N];
			int start = 0, end = N - 1, index = 0;
			for (int i = 0; i < N; i++) {
				if (start <= end && index < N)
					sorted[start++] = arr[index++];
				if (start <= end && index < N)
					sorted[end--] = arr[index++];
			}
			int result = Math.abs(sorted[0] - sorted[N - 1]);
			for (int i = 0; i < N - 1; i++)
				result = Math.max(result, Math.abs(sorted[i + 1] - sorted[i]));
			sb.append(result + "\n");
		}
		System.out.println(sb);
	}
}
