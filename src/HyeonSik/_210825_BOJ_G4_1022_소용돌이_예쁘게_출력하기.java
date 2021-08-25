import java.util.Scanner;

public class _210825_BOJ_G4_1022_소용돌이_예쁘게_출력하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int r1, c1, r2, c2;
		int maxValue = 0;
		r1 = sc.nextInt();
		c1 = sc.nextInt();
		r2 = sc.nextInt();
		c2 = sc.nextInt();
		// (r1, c1) ~ (r2, c2)의 좌표 값 구하기
		int[][] arr = new int[r2 - r1 + 1][c2 - c1 + 1];
		for (int y = 0; y <= r2 - r1; y++) {
			for (int x = 0; x <= c2 - c1; x++) {
				// 좌표 구하기
				arr[y][x] = getNumberByPos(r1 + y, c1 + x);
				// 최댓값
				maxValue = Math.max(maxValue, arr[y][x]);
			}
		}
		// 최댓값의 자릿수 구하기
		int len = (int) Math.log10(maxValue) + 1;
		// 형식에 맞춰서 출력
		for (int y = 0; y <= r2 - r1; y++) {
			for (int x = 0; x <= c2 - c1; x++) {
				// 맨 첫번째인 경우 띄어쓰기 X
				if (x == 0)
					sb.append(String.format("%" + len + "d", arr[y][x]));
				// 그 외
				else
					sb.append(String.format("%" + (len + 1) + "d", arr[y][x]));
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	// (r, c) 좌표의 값 구하기
	private static int getNumberByPos(int r, int c) {
		// r, c의 절대값 중 큰 값(value)의 주위를 따라 탐색
		// (value, value) 값 부터 (9, 25, 49, 64 ...) 좌, 상, 우, 하 순서로 탐색
		int value = Math.max(Math.abs(r), Math.abs(c));
		int len = 2 * value + 1;
		int y = value, x = value, num = len * len;
		// value: 3일 때 예시
		// 좌 (49 ~ 44)
		for (int i = 0; i < len - 1; i++) {
			if (y == r && c == x)
				return num;
			x--;
			num--;
		}
		// 상 (43 ~ 38)
		for (int i = 0; i < len - 1; i++) {
			if (y == r && c == x)
				return num;
			y--;
			num--;
		}
		// 우 (37 ~ 32)
		for (int i = 0; i < len - 1; i++) {
			if (y == r && c == x)
				return num;
			x++;
			num--;
		}
		// 하 (30 ~ 26)
		for (int i = 0; i < len - 1; i++) {
			if (y == r && c == x)
				return num;
			y++;
			num--;
		}
		// 0, 0인 경우
		return 1;
	}
}
