import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _210915_BOJ_G5_11578_팀원모집 {
	static int[] counts;
	static boolean[] selected;
	static int result = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		ArrayList<Integer>[] students = new ArrayList[M + 1];
		for (int index = 1; index <= M; index++) {
			students[index] = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			st.nextToken();
			while (st.hasMoreTokens()) {
				students[index].add(Integer.parseInt(st.nextToken()));
			}
		}
		counts = new int[N + 1];
		dfs(N, M, 1, 0, students);
		if (result == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(result);
	}

	private static void dfs(int N, int M, int index, int count, ArrayList<Integer>[] students) {
		if (canSolveAll(N)) {
			result = Math.min(result, count);
			return;
		}
		if (index > M)
			return;
		// 팀원 선택
		for (int problem : students[index])
			counts[problem]++;
		dfs(N, M, index + 1, count + 1, students);
		for (int problem : students[index])
			counts[problem]--;
		// 팀원 선택 x
		dfs(N, M, index + 1, count, students);
	}

	public static boolean canSolveAll(int N) {
		for (int index = 1; index <= N; index++)
			if (counts[index] == 0)
				return false;
		return true;
	}
}
