import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _210729_BOJ_G2_12738_가장_긴_증가하는_부분_수열_3 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		ArrayList<Integer> lis = new ArrayList<>();
		for (int num : arr) {
			// 처음 넣거나 혹은 마지막 값이 더 작은 경우
			if (lis.isEmpty() || lis.get(lis.size() - 1) < num) {
				lis.add(num);
			} else {
				// lower_bound 구하기
				int left = 0, right = lis.size() - 1;
				while (left < right) {
					int mid = (left + right) / 2;
					if (lis.get(mid) >= num)
						right = mid;
					else
						left = mid + 1;
				}
				lis.set(left, num);
			}
		}
		System.out.println(lis.size());
	}
}