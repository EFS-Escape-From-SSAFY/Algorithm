import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class _210805_BOJ_G1_1700_멀티탭_스케줄링 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] arr = new int[K];
		int result = 0, index = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		// 처음 멀티탭에 넣기
		HashSet<Integer> set = new HashSet<>();
		while (set.size() < N && index < K) {
			set.add(arr[index]);
			index++;
		}
		// 현재 꽂힌 플러그 중 가장 마지막에 나오는 것  제거
		for (; index < K; index++) {
			// 이미 꽂혀져 있는 경우
			if (set.contains(arr[index]))
				continue;
			else {
				// 다음에 사용되는 전기제품의 첫 번째 사용 인덱스 구하기
				HashMap<Integer, Integer> nextIndex = new HashMap<>();
				for (int i = index; i < K; i++) {
					if (!nextIndex.containsKey(arr[i]))
						nextIndex.put(arr[i], i);
				}
				// 다음에 쓸 일 없는 전기제품 제거
				boolean flag = false;
				for (int num : set) {
					if (!nextIndex.containsKey(num)) {
						set.remove(num);
						set.add(arr[index]);
						flag = true;
						result++;
						break;
					}
				}
				if (flag)
					continue;
				// 가장 늦게 나오는 것 제거
				int deleteNum = -1, deleteIndex = -1;
				for (int num : nextIndex.keySet()) {
					if (set.contains(num) && deleteIndex < nextIndex.get(num)) {
						deleteNum = num;
						deleteIndex = nextIndex.get(num);
					}
				}
				// 플러그가 한개이면, 기존에 쓰던 것 제거해야됨
				if (N == 1) {
					set.clear();
				}
				set.remove(deleteNum);
				set.add(arr[index]);
				result++;
			}
		}
		System.out.println(result);
	}
}
