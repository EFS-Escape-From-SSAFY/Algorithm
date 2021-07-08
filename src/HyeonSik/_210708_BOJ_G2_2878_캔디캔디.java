import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class _210708_BOJ_G2_2878_캔디캔디 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[] temp = new int[N];
		int[] arr = new int[N + 1];
		HashMap<Integer, Integer> hashmap = new HashMap<>();
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			hashmap.put(num, hashmap.getOrDefault(num, 0) + 1);
			temp[i] = num;
		}
		Arrays.sort(temp);
		for (int i = 0; i < N; i++)
			arr[i] = temp[N - i - 1];
		arr[N] = 0;
		for (int index = 0; index < N; index++) {
			if (arr[index] == arr[index + 1])
				continue;
			int need = (arr[index] - arr[index + 1]) * hashmap.get(arr[index]);
			if (M >= need) {
				M -= need;
				hashmap.put(arr[index + 1], hashmap.getOrDefault(arr[index + 1], 0) + hashmap.get(arr[index]));
				hashmap.remove(arr[index]);
			} else {
				int mother = M / hashmap.get(arr[index]);
				int child = M % hashmap.get(arr[index]);
				int tmp = hashmap.get(arr[index]);
				hashmap.remove(arr[index]);

				hashmap.put(arr[index] - mother, hashmap.getOrDefault(arr[index] - mother, 0) + tmp - child);
				hashmap.put(arr[index] - mother - 1, hashmap.getOrDefault(arr[index] - mother - 1, 0) + child);
				break;
			}
		}

		long result = 0;
		for (int num : hashmap.keySet()) {
			result += (long) hashmap.get(num) * num * num;
		}
		System.out.println(result);
	}
}

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//import java.util.StringTokenizer;
//
//public class _210708_BOJ_G2_2878_캔디캔디 {
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		int M = Integer.parseInt(st.nextToken());
//		int N = Integer.parseInt(st.nextToken());
//		int[] arr = new int[N];
//		long result = 0;
//		long total = -M;
//		for (int i = 0; i < N; i++) {
//			arr[i] = Integer.parseInt(br.readLine());
//			total += arr[i];
//		}
//		Arrays.sort(arr);
//		for (int index = 0; index < N; index++) {
//			long num = Math.min(total / (N - index), arr[index]);
//			result += num * num;
//			total -= num;
//		}
//		System.out.println(result);
//	}
//}