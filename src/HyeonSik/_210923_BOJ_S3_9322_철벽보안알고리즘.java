import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class _210923_BOJ_S3_9322_철벽보안알고리즘 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		while (TC-- > 0) {
			int N = Integer.parseInt(br.readLine());
			String[] first = br.readLine().split(" ");
			String[] second = br.readLine().split(" ");
			String[] coded = br.readLine().split(" ");
			HashMap<String, Integer> map = new HashMap<>();
			HashMap<Integer, Integer> converter = new HashMap<>();
			for (int i = 0; i < N; i++) {
				map.put(first[i], i);
			}
			for (int i = 0; i < N; i++) {
				converter.put(map.get(second[i]), i);
			}
			for (int i = 0; i < N; i++) {
				sb.append(coded[converter.get(i)] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
