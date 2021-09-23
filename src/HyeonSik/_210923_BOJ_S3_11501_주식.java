import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _210923_BOJ_S3_11501_주식 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		while (TC-- > 0) {
			int N = Integer.parseInt(br.readLine()), max = 0;
			long result = 0;
			int[] arr = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int index = 0; index < N; index++)
				arr[index] = Integer.parseInt(st.nextToken());

			for (int index = N - 1; index >= 0; index--) {
				if (arr[index] > max)
					max = arr[index];
				else
					result += (max - arr[index]);
			}
			sb.append(result + "\n");
		}
		System.out.println(sb);
	}
}
