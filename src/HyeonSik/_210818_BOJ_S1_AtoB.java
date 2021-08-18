import java.util.Scanner;

public class _210818_BOJ_S1_AtoB {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int result = 1;
		while (B >= A) {
			if (B == A) {
				System.out.println(result);
				System.exit(0);
			}
			// B가 짝수이면, 2로 나눔
			if ((B & 1) == 0)
				B >>= 1;
			// B가 1로 끝나면, 1을 없앰
			else if (B % 10 == 1)
				B /= 10;
			// 그 외일 경우 만들 수 없음
			else
				break;
			result++;
		}
		System.out.println(-1);
	}
}
