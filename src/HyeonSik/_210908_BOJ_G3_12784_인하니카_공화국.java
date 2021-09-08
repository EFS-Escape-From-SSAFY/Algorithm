import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _210908_BOJ_G3_12784_인하니카_공화국 {
	static int[] dp, count;
	static boolean[] visited;
	static ArrayList<Info>[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		while (TC-- > 0) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			visited = new boolean[N + 1];
			count = new int[N + 1];
			dp = new int[N + 1];
			Arrays.fill(dp, -1);
			arr = new ArrayList[N + 1];
			for (int index = 1; index <= N; index++)
				arr[index] = new ArrayList<>();
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());
				count[a]++;
				count[b]++;
				arr[a].add(new Info(b, d));
				arr[b].add(new Info(a, d));
			}
			// 섬이 하나만 있는 경우, 다이너마이트가 필요하지 않음
			if (N == 1)
				sb.append("0\n");
			// 1번 섬부터 탐색
			else
				sb.append(find(1) + "\n");
		}
		System.out.println(sb);
	}

	public static int find(int node) {
		if (dp[node] != -1)
			return dp[node];
		// leaf 섬(다리가 하나밖에 없는지)인지 확인
		boolean isLeaf = true;
		dp[node] = 0;
		visited[node] = true;
		for (Info next : arr[node]) {
			if (visited[next.dest])
				continue;
			isLeaf = false;
			dp[node] += Math.min(next.weight, find(next.dest));
		}
		// 섬에 다리가 하나밖에 없으면, 그 다리 값 반환
		if (isLeaf)
			return arr[node].get(0).weight;
		return dp[node];
	}

	public static class Info {
		int dest, weight;

		Info(int dest, int weight) {
			this.dest = dest;
			this.weight = weight;
		}
	}
}
