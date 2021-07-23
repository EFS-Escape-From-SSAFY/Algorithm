import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class _210723_BOJ_G3_2143_두_배열의_합 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());
		int[] A = new int[n + 1];
		st = new StringTokenizer(br.readLine());
		// 배열 A의 누적 합 구하기
		for (int index = 1; index <= n; index++) {
			A[index] = Integer.parseInt(st.nextToken());
			A[index] += A[index - 1];
		}
		int m = Integer.parseInt(br.readLine());
		int[] B = new int[m + 1];
		st = new StringTokenizer(br.readLine());
		// 배열 B의 누적 합 구하기
		for (int index = 1; index <= m; index++) {
			B[index] = Integer.parseInt(st.nextToken());
			B[index] += B[index - 1];
		}
		// mapA: 배열 A의 모든 부 배열의 합에 대한 HashMap
		HashMap<Integer, Long> mapA = new HashMap<>();
		HashMap<Integer, Long> mapB = new HashMap<>();
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j <= n; j++) {
				int num = A[j] - A[i];
				mapA.put(num, mapA.getOrDefault(num, (long) 0) + 1);
			}
		}
		for (int i = 0; i < m; i++) {
			for (int j = i + 1; j <= m; j++) {
				int num = B[j] - B[i];
				mapB.put(num, mapB.getOrDefault(num, (long) 0) + 1);
			}
		}
		long result = 0;
		// mapA의 어떤 값 + mapB의 어떤 값이 T가 되는 경우 찾기
		for (int num : mapA.keySet()) {
			// num + x = T 인 값 x가 mapB에 존재할 경우
			if (mapB.containsKey(T - num)) {
				result += mapA.get(num) * mapB.get(T - num);
			}
		}
		System.out.println(result);
	}
}
