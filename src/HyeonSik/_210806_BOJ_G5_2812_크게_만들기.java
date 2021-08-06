import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class _210806_BOJ_G5_2812_크게_만들기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int length = N - K;
		char[] num = br.readLine().toCharArray();
		Deque<Integer> deque = new LinkedList<>();
		for (int index = 0; index < N; index++) {
			// 현재 고른 값(deque에 저장)보다 다음에 넣을 값이 큰 경우, 고른 값에서 삭제 
			while (K > 0 && !deque.isEmpty() && deque.peekLast() < num[index] - '0') {
				deque.pollLast();
				K--;
			}
			// deque에 넣기
			deque.add(num[index] - '0');
		}
		for (int i = 0; i < length; i++)
			sb.append(deque.pollFirst());
		System.out.println(sb);
	}
}
