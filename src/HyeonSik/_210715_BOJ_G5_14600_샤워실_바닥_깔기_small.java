import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _210715_BOJ_G5_14600_샤워실_바닥_깔기_small {
	static int K, X, Y;
	static int[][][] tile = { { { 0, 0 }, { 0, 1 }, { 1, 0 } }, { { 0, 0 }, { 0, 1 }, { 1, 1 } },
			{ { 0, 0 }, { 1, 0 }, { 1, 1 } }, { { 0, 0 }, { 1, 0 }, { 1, -1 } } };
	static int[][] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		K = 1 << K;
		StringTokenizer st = new StringTokenizer(br.readLine());
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		arr = new int[K][K];
		arr[K - Y][X - 1] = -1;
		dfs(1);
		System.out.println(-1);
	}

	static void dfs(int count) {
		if (isAnswer()) {
			// �� ���
			for (int y = 0; y < K; y++) {
				for (int x = 0; x < K; x++) {
					System.out.print(arr[y][x] + " ");
				}
				System.out.println();
			}
			System.exit(0);
		}
		for (int y = 0; y < K; y++) {
			for (int x = 0; x < K; x++) {
				if (arr[y][x] == 0) {
					for (int type = 0; type < 4; type++) {
						if (canAddTile(y, x, type)) {
							addTile(y, x, type, count);
							dfs(count + 1);
							deleteTile(y, x, type);
						}
					}
				}
			}
		}
	}

	static boolean canAddTile(int y, int x, int type) {
		for (int index = 0; index < 3; index++) {
			int ny = y + tile[type][index][0];
			int nx = x + tile[type][index][1];
			if (ny < 0 || nx < 0 || ny >= K || nx >= K)
				return false;
			if (arr[ny][nx] != 0)
				return false;
		}
		return true;
	}

	static boolean isAnswer() {
		for (int y = 0; y < K; y++)
			for (int x = 0; x < K; x++)
				if (arr[y][x] == 0)
					return false;
		return true;
	}

	static void addTile(int y, int x, int type, int count) {
		for (int index = 0; index < 3; index++) {
			int ny = y + tile[type][index][0];
			int nx = x + tile[type][index][1];
			arr[ny][nx] = count;
		}
	}

	static void deleteTile(int y, int x, int type) {
		for (int index = 0; index < 3; index++) {
			int ny = y + tile[type][index][0];
			int nx = x + tile[type][index][1];
			arr[ny][nx] = 0;
		}
	}
}
