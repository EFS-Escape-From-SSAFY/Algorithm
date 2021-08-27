import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _210827_BOJ_G5_14675_단절점과_단절선 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] visited = new int[N + 1];

		for (int index = 1; index <= N - 1; index++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			visited[a]++;
			visited[b]++;
		}
		int Q = Integer.parseInt(br.readLine());
		for (int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			if (t == 1) {
				if (isCutVertex(k, visited))
					sb.append("yes\n");
				else
					sb.append("no\n");
			} else {
				sb.append("yes\n");
			}
		}
		System.out.println(sb);
	}

	public static boolean isCutVertex(int index, int[] visited) {
		if (visited[index] == 1)
			return false;
		return true;
	}
}
