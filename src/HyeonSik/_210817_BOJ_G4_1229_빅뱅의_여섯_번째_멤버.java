import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _210816_BOJ_G4_1229_빅뱅의_여섯_번째_멤버 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] dp = new int[1000001];
		Queue<Integer> queue = new LinkedList<>();
		ArrayList<Integer> bigbangSet = new ArrayList<>();
		// 빅뱅 수 찾기
		for (int number = 1, distance = 5; number <= N; number += distance, distance += 4) {
			queue.add(number);
			bigbangSet.add(number);
			dp[number] = 1;
		}
		// 빅뱅수 중 답이 6, 5, 4인 가장 큰 값들이 존재
		// 1791보다 큰 수에 대해 답이 항상 4보다 작거나 같음
		// 이 수를 건너뜀으로 시간 줄이기
		dp[11] = 6;
		dp[26] = 6;
		dp[130] = 5;
		dp[146858] = 4;

		// Queue로 BFS 탐색
		while (!queue.isEmpty()) {
			int curNum = queue.poll();

			if (curNum == N)
				break;

			for (int bigBangNum : bigbangSet) {
				int next = bigBangNum + curNum;
				if(next > N)
					break;
				if (next <= N && dp[next] == 0) {
					dp[next] = dp[curNum] + 1;
					queue.add(next);
				}
			}
		}
		System.out.println(dp[N]);
	}
}
