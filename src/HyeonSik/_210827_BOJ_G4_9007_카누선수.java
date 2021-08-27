import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _210827_BOJ_G4_9007_카누선수 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			// 학생들 정보 얻기
			int[][] students = new int[4][n];
			for (int i = 0; i < 4; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++)
					students[i][j] = Integer.parseInt(st.nextToken());
			}
			// 1, 2반 학생들 합친 값과 3, 4반 학생들 합친 값 저장
			int[][] twoStudents = new int[2][n * n];
			for (int i = 0, index = 0; i < n; i++) {
				for (int j = 0; j < n; j++, index++) {
					twoStudents[0][index] = students[0][i] + students[1][j];
					twoStudents[1][index] = students[2][i] + students[3][j];
				}
			}
			// 정렬
			Arrays.sort(twoStudents[0]);
			Arrays.sort(twoStudents[1]);
			int result = twoStudents[0][0] + twoStudents[1][0];
			// 1, 2반 학생들의 합은 차례대로 탐색
			for (int index = 0; index < n * n; index++) {
				// 3, 4반 학생들의 합은 이분탐색
				int left = 0, right = n * n - 1;

				while (left <= right) {
					int mid = (left + right) / 2;
					int sum = twoStudents[0][index] + twoStudents[1][mid];
					// result보다 네 학생의 무게가 더 가까운 경우
					if (Math.abs(k - result) >= Math.abs(k - sum)) {
						// 무게가 같은 경우, 더 작아야 함
						if (Math.abs(k - result) == Math.abs(k - sum)) {
							result = Math.min(result, sum);
						} else
							result = sum;
					}
					if (sum > k)
						right = mid - 1;
					else if (sum < k)
						left = mid + 1;
					else
						break;
				}
				if (result == k)
					break;
			}
			sb.append(result + "\n");
		}
		System.out.println(sb);
	}
}
