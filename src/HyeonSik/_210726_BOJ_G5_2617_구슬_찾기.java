import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _210726_BOJ_G5_2617_구슬_찾기 {
	static int INF = 1000000000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] arr1 = new int[N + 1][N + 1];
		int[][] arr2 = new int[N + 1][N + 1];
		boolean[] result = new boolean[N + 1];
		for (int i = 1; i <= N; i++) {
			Arrays.fill(arr1[i], INF);
			Arrays.fill(arr2[i], INF);
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr1[a][b] = 1;
			arr2[b][a] = 1;
		}
		// 플로이드 와샬
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					arr1[i][j] = Math.min(arr1[i][j], arr1[i][k] + arr1[k][j]);
					arr2[i][j] = Math.min(arr2[i][j], arr2[i][k] + arr2[k][j]);
				}
			}
		}
		for (int index = 1; index <= N; index++) {
			// index번 구슬보다 무거운 구슬의 개수, 가벼운 구슬이 개수를 각각 구함
			int heavy = 0, light = 0;
			for (int i = 1; i <= N; i++) {
				if (arr1[index][i] != INF)
					light++;
				if (arr2[index][i] != INF)
					heavy++;
			}
			// 무겁거나 가벼운 구슬의 개수가 전체의 중간보다 많다면, 절대로 중간 무게가 될 수 없음
			if (heavy >= (N + 1) / 2 || light >= (N + 1) / 2)
				result[index] = true;
		}
		int count = 0;
		for (int index = 1; index <= N; index++)
			if (result[index])
				count++;
		System.out.println(count);
	}
}
