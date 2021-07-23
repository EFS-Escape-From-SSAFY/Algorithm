import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class _210723_BOJ_G4_10986_나머지_합 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N + 1];
		// hashmap: 연속된 부분 구간의 합을 M으로 나눈 나머지들의 개수
		HashMap<Integer, Long> hashmap = new HashMap<>();
		for (int i = 1; i <= N; i++) {
			int num = Integer.parseInt(st.nextToken()) % M;
			arr[i] = arr[i - 1] + num;
			arr[i] %= M;
			hashmap.put(arr[i], hashmap.getOrDefault(arr[i], (long) 0) + 1);
		}
		long result = 0;
		// 연속된 부분 구간의 합이 M으로 나누어 떨어지기 위해서는, 구간의 누적합의 나머지가 같아야 함
		// 조합 개수 구해서 더하기
		for (Long key : hashmap.values()) {
			result += getCombinationCount(key);
		}
		// 나머지가 0인 경우, 처음부터 해당 누적 합 또한 M으로 나눠짐
		if (hashmap.containsKey(0))
			result += hashmap.get(0);
		System.out.println(result);
	}

	public static long getCombinationCount(long n) {
		return n * (n - 1) / 2;
	}
}
