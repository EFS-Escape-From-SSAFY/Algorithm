import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _210719_BOJ_G5_12893_적의_적 {
	static int N, M;
	static int[] parents;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		ArrayList<Integer>[] arr = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++)
			arr[i] = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a].add(b);
			arr[b].add(a);
		}
		// distance[index] = 몇 칸 떨어져있는지
		int[] distance = new int[N + 1];
		// 모든 사람에서부터 탐색
		for (int index = 1; index <= N; index++) {
			// 이미 탐색된 경우(같은 트리 안에 있는 경우), continue
			if (distance[index] != 0)
				continue;
			Queue<Integer> queue = new LinkedList<>();
			distance[index] = 1;
			queue.add(index);

			while (!queue.isEmpty()) {
				int cur = queue.poll();

				for (int next : arr[cur]) {
					if (distance[next] != 0)
						continue;
					queue.add(next);
					distance[next] = distance[cur] + 1;
				}
			}
		}
		if (isValidate(distance, arr))
			System.out.println(1);
		else
			System.out.println(0);

	}

	// 적의 적 이론이 유효한지 확인
	private static boolean isValidate(int[] distance, ArrayList<Integer>[] arr) {
		// 두 사람 i, j를 고르는 모든 경우의 수 에 대해 탐색
		for (int i = 1; i <= N; i++) {
			for (int j = i + 1; j <= N; j++) {
				// 만약 i와 j의 떨어진 거리 수가 같고, i에서 j로 가는 길이 존재한다면
				// 적의 적임에도 친구가 아닌 적이므로 false
				if (distance[i] % 2 == distance[j] % 2) {
					for (int num : arr[i]) {
						if (num == j)
							return false;
					}
				}
			}
		}
		return true;
	}
}
