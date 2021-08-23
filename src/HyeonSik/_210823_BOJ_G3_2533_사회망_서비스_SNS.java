import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _210823_BOJ_G3_2533_사회망_서비스_SNS {
	// dp[index][0]: index가 얼리 어답터가 아닐 때 최솟값
	// dp[index][1]: index가 얼리 어답터일때 최솟값
	static int[][] dp;
	static ArrayList<Integer>[] arr;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());
		arr = new ArrayList[N + 1];
		dp = new int[N + 1][2];
		visited = new boolean[N + 1];
		for (int i = 1; i <= N; i++)
			arr[i] = new ArrayList<>();
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a].add(b);
			arr[b].add(a);
		}
		find(1);
		System.out.println(Math.min(dp[1][0], dp[1][1]));
	}

	private static void find(int index) {
		visited[index] = true;
		dp[index][1] = 1;
		for (int next : arr[index]) {
			if (visited[next])
				continue;
			find(next);
			// 내가 얼리 어답터인 경우, 친구가 얼리 어답터든 아니든 상관 없음
			dp[index][1] += Math.min(dp[next][0], dp[next][1]);
			// 내가 얼리 업답터가 아닌 경우, 친구가 얼리 어답터여야 함
			dp[index][0] += dp[next][1];
		}
	}
}
