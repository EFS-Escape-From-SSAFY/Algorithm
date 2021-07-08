import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

// 캔디 개수 내림차순 정렬 후, 가장 받고 싶은 개수가 큰 것부터 수 줄여가기
// HashMap 사용해서 받고 싶은 개수가 같은 수는 한번에 처리 
public class _210708_BOJ_G2_2878_캔디캔디 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		// map: <받고 싶은 캔디 값, 중복 되는 개수>
		HashMap<Integer, Integer> map = new HashMap<>();
		HashSet<Integer> set = new HashSet<>();
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			map.put(num, map.getOrDefault(num, 0) + 1);
			set.add(num);
		}
		// 캔디 개수 중복 없애기
		ArrayList<Integer> arr = new ArrayList<>(set);
		Collections.sort(arr, Collections.reverseOrder());
		// 마지막에 0 넣어주기
		arr.add(0);
		for (int index = 0; index < arr.size(); index++) {
			// count: 가장 큰 캔디 수 -> 그 다음 큰 캔디 수로 바꾸기 위해 필요한 크기
			int count = (arr.get(index) - arr.get(index + 1)) * map.get(arr.get(index));
			// 가장 큰 수를 그 다음 수만큼 줄일 수 있다면 (ex. { 10, 10, 8, 6 } -> { 8, 8, 8, 6 })
			if (M >= count) {
				M -= count;
				map.put(arr.get(index + 1), map.getOrDefault(arr.get(index + 1), 0) + map.get(arr.get(index)));
				map.remove(arr.get(index));
			}
			// 가장 큰 수를 그 다음 수만큼 줄일 수 없다면 (ex. { 10, 10, 8, 6 } -> { 9, 9, 8, 6 })
			else {
				// mother: 모두 균등하게 줄 수 있는 크기, child: 균등하게 주고 남은 크기
				int mother = M / map.get(arr.get(index));
				int child = M % map.get(arr.get(index));
				int tmp = map.get(arr.get(index));
				// 현재 캔디 크기 다 지우기
				map.remove(arr.get(index));
				// 재설정
				map.put(arr.get(index) - mother, map.getOrDefault(arr.get(index) - mother, 0) + tmp - child);
				map.put(arr.get(index) - mother - 1, map.getOrDefault(arr.get(index) - mother - 1, 0) + child);
				break;
			}
		}
		long result = 0;
		for (int num : map.keySet()) {
			result += (long) map.get(num) * num * num;
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
//		// total: 부족한 사탕 개수
//		long total = -M;
//		for (int i = 0; i < N; i++) {
//			arr[i] = Integer.parseInt(br.readLine());
//			total += arr[i];
//		}
//		// 오름차순 정렬
//		Arrays.sort(arr);
//		for (int index = 0; index < N; index++) {
//			// num: 부족한 사탕 개수 / (남은 사람 수), 현재 사탕 개수 중 작은 값
//			long num = Math.min(total / (N - index), arr[index]);
//			result += num * num;
//			total -= num;
//		}
//		System.out.println(result);
//	}
//}