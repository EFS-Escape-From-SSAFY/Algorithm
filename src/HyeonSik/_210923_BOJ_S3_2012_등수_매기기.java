import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _210923_BOJ_S3_2012_등수_매기기 {
	static int MAX = 500000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long result = 0;
		int[] arr = new int[N + 1];
		for (int index = 1; index <= N; index++)
			arr[index] = Integer.parseInt(br.readLine());

		Arrays.sort(arr);
		for (int index = 1; index <= N; index++)
			result += Math.abs(arr[index] - index);
		System.out.println(result);
	}
}
