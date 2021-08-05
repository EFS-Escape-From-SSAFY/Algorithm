import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _210805_BOJ_G5_9019_DSLR {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		while (tc-- > 0) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			boolean[] visited = new boolean[10001];
			Queue<Integer> queue = new LinkedList<>();
			Queue<String> command = new LinkedList<>();
			queue.add(start);
			command.add("");
			visited[start] = true;
			while (!queue.isEmpty()) {
				int cur = queue.poll();
				String str = command.poll();
				if (cur == end) {
					sb.append(str + "\n");
					break;
				}

				// D
				int next = D(cur);
				if (!visited[next]) {
					visited[next] = true;
					queue.add(next);
					command.add(str + 'D');
				}
				// S
				next = S(cur);
				if (!visited[next]) {
					visited[next] = true;
					queue.add(next);
					command.add(str + 'S');
				}
				// L
				next = L(cur);
				if (!visited[next]) {
					visited[next] = true;
					queue.add(next);
					command.add(str + 'L');
				}
				// R
				next = R(cur);
				if (!visited[next]) {
					visited[next] = true;
					queue.add(next);
					command.add(str + 'R');
				}
			}
		}
		System.out.println(sb);
	}

	public static int D(int num) {
		return (2 * num) % 10000;
	}

	public static int S(int num) {
		return num == 0 ? 9999 : num - 1;
	}

	public static int L(int num) {
		return (num * 10) % 10000 + num / 1000;
	}

	public static int R(int num) {
		return num / 10 + (num % 10) * 1000;
	}
}
