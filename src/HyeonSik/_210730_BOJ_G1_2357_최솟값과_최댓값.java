import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _210730_BOJ_G1_2357_최솟값과_최댓값 {
	static int N, M;
	static int[] minTree, maxTree, arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		// log2(N)으로 트리의 높이 구하기
		int height = (int) Math.ceil((Math.log(N) / Math.log(2)));
		// 높이로 노드 개수 구하기
		int treeSize = 1 << (height + 1);
		arr = new int[N + 1];
		minTree = new int[treeSize + 1];
		maxTree = new int[treeSize + 1];
		for (int i = 1; i <= N; i++)
			arr[i] = Integer.parseInt(br.readLine());
		// 세그먼트 트리 초기화
		minTreeInit(1, 1, N);
		maxTreeInit(1, 1, N);
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int left = Integer.parseInt(st.nextToken());
			int right = Integer.parseInt(st.nextToken());
			sb.append(findMinValue(1, 1, N, left, right) + " " + findMaxValue(1, 1, N, left, right) + "\n");
		}
		System.out.println(sb);
	}

	private static int minTreeInit(int index, int left, int right) {
		// 리프 노드인 경우
		if (left == right)
			return minTree[index] = arr[left];
		// left ~ right 구간 사이의 최솟값 구하기
		else {
			int mid = (left + right) / 2;
			return minTree[index] = Math.min(minTreeInit(index * 2, left, mid), minTreeInit(index * 2 + 1, mid + 1, right));
		}
	}

	private static int maxTreeInit(int index, int left, int right) {
		// 리프 노드인 경우
		if (left == right)
			return maxTree[index] = arr[left];
		// left ~ right 구간 사이의 최댓값 구하기
		else {
			int mid = (left + right) / 2;
			return maxTree[index] = Math.max(maxTreeInit(index * 2, left, mid), maxTreeInit(index * 2 + 1, mid + 1, right));
		}
	}

	private static int findMinValue(int index, int start, int end, int left, int right) {
		// 고정된 left~right 구간을 벗어난 경우
		if (end < left || right < start)
			return Integer.MAX_VALUE;
		// 범위 안에 속한 경우
		if (left <= start && end <= right)
			return minTree[index];
		// 적당한 범위 찾기
		int mid = (start + end) / 2;
		return Math.min(findMinValue(index * 2, start, mid, left, right), findMinValue(index * 2 + 1, mid + 1, end, left, right));
	}

	private static int findMaxValue(int index, int start, int end, int left, int right) {
		// 고정된 left~right 구간을 벗어난 경우
		if (end < left || right < start)
			return Integer.MIN_VALUE;
		// 범위 안에 속한 경우
		if (left <= start && end <= right)
			return maxTree[index];
		// 적당한 범위 찾기
		int mid = (start + end) / 2;
		return Math.max(findMaxValue(index * 2, start, mid, left, right), findMaxValue(index * 2 + 1, mid + 1, end, left, right));
	}
}
