import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _210708_BOJ_G2_3745_오름세 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder result = new StringBuilder();
		String str;
		while ((str = br.readLine()) != null) {
			if(str == "" || str.length() == 0)
				break;
			int n = Integer.parseInt(str);
			int[] arr = new int[n];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++)
				arr[i] = Integer.parseInt(st.nextToken());
			ArrayList<Integer> lis = new ArrayList<>();
			for (int num : arr) {
				if (lis.isEmpty() || lis.get(lis.size() - 1) < num) {
					lis.add(num);
				} else {
					int left = 0, right = lis.size() - 1;
					while (left < right) {
						int mid = (left + right) / 2;
						if (lis.get(mid) >= num)
							right = mid;
						else
							left = mid + 1;
					}
					lis.set(right, num);
				}
			}
			result.append(lis.size()+"\n");
		}
		System.out.println(result);
	}
}
