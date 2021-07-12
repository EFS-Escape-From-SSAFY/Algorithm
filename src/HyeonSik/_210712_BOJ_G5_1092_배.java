import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _210712_BOJ_G5_1092_배 {
	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// Input
		N = Integer.parseInt(br.readLine());
		ArrayList<Integer> crane = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int index = 0; index < N; index++)
			crane.add(Integer.parseInt(st.nextToken()));
		M = Integer.parseInt(br.readLine());
		ArrayList<Integer> boxes = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for (int index = 0; index < M; index++)
			boxes.add(Integer.parseInt(st.nextToken()));

		// 내림차순 정렬
		Collections.sort(crane, Collections.reverseOrder());
		Collections.sort(boxes, Collections.reverseOrder());
		if(crane.get(0) < boxes.get(0)) {
			System.out.println(-1);
			System.exit(0);
		}
		boolean[] check = new boolean[M];
		int result = 0, boxIndex = 0, craneIndex = 0;
		while (!hasNoBox(check)) {
			result++;
			for (craneIndex = 0, boxIndex = 0; craneIndex < N && boxIndex < M; boxIndex++) {
				if (check[boxIndex])
					continue;
				if (crane.get(craneIndex) >= boxes.get(boxIndex)) {
					craneIndex++;
					check[boxIndex] = true;
				}
			}
		}

		System.out.println(result);
	}

	static boolean hasNoBox(boolean[] check) {
		for (boolean cur : check) {
			if (!cur)
				return false;
		}
		return true;
	}
}
