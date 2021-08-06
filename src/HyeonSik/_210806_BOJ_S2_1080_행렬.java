import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _210806_BOJ_S2_1080_행렬 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		char[][] A = new char[N][M];
		char[][] B = new char[N][M];
		for (int i = 0; i < N; i++)
			A[i] = br.readLine().toCharArray();
		for (int i = 0; i < N; i++)
			B[i] = br.readLine().toCharArray();
		int result = 0;
		for (int y = 0; y + 3 <= N; y++) {
			for (int x = 0; x + 3 <= M; x++) {
				if (A[y][x] != B[y][x]) {
					for (int i = 0; i < 3; i++)
						for (int j = 0; j < 3; j++)
							A[y + i][x + j] = A[y + i][x + j] == '0' ? '1' : '0';
					result++;
				}
			}
		}
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < M; x++) {
				if (A[y][x] != B[y][x]) {
					System.out.println(-1);
					System.exit(0);
				}
			}
		}
		System.out.println(result);
	}
}
