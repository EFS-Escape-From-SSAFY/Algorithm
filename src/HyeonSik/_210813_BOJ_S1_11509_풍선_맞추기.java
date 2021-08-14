import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _210813_BOJ_S1_11509_풍선_맞추기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] height = new int[N];
		int[] arrow = new int[1000001];
		int result = 0;
		for (int index = 0; index < N; index++)
			height[index] = Integer.parseInt(st.nextToken());

		for (int curHeight : height) {
			// 현재 높이에 있는 화살이 있으면, 터뜨리고 한 칸 내림
			if (arrow[curHeight] > 0) {
				arrow[curHeight]--;
				arrow[curHeight - 1]++;
			}
			// 현재 높이에 있는 화살 없으면, 화살 추가
			else {
				result++;
				arrow[curHeight - 1]++;
			}
		}
		System.out.println(result);
	}
}
