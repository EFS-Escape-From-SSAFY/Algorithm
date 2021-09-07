import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _210906_BOJ_G3_10800_컬러볼 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		Ball[] balls = new Ball[N];

		for (int index = 0; index < N; index++) {
			st = new StringTokenizer(br.readLine());
			int C = Integer.parseInt(st.nextToken());
			int S = Integer.parseInt(st.nextToken());
			balls[index] = new Ball(C, S, index);
		}
		Arrays.sort(balls);

		int[] colors = new int[N + 1];
		int[] scores = new int[N];
		int[] sizes = new int[2001];
		int sum = 0;
		for (int index = 0; index < N; index++) {
			Ball ball = balls[index];

			sum += ball.size;
			colors[ball.color] += ball.size;
			sizes[ball.size] += ball.size;

			scores[ball.index] = sum - colors[ball.color] - sizes[ball.size] + ball.size;

			if (index != 0 && balls[index - 1].color == ball.color && balls[index - 1].size == ball.size)
				scores[ball.index] = scores[balls[index - 1].index];
		}
		for (int score : scores)
			sb.append(score + "\n");
		System.out.println(sb);
	}

	public static class Ball implements Comparable<Ball> {
		int color, size, index;

		Ball(int color, int size, int index) {
			this.color = color;
			this.size = size;
			this.index = index;
		}

		@Override
		public int compareTo(Ball o) {
			if (this.size == o.size)
				return this.color - o.color;
			return this.size - o.size;
		}
	}
}
