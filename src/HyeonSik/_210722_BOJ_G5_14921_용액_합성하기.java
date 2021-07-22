import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _210722_BOJ_G5_14921_용액_합성하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int index = 0; index < N; index++)
			arr[index] = Integer.parseInt(st.nextToken());
		Arrays.sort(arr);
		int start = 0, end = N - 1, result = Integer.MAX_VALUE;
		while (start < end) {
			int sum = arr[start] + arr[end];
			if (Math.abs(result) > Math.abs(sum))
				result = sum;
			if (sum < 0)
				start++;
			else
				end--;
		}
		System.out.println(result);
	}
}
