import java.util.Scanner;

public class _210803_BOJ_G4_13140_Hello_World {
	static int[] number = new int[6];
	static int[] carry = new int[6];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] c = sc.next().toCharArray();
		for (int i = 0; i < c.length; i++)
			number[c.length - i - 1] = c[i] - '0';
		dfs(0, new int[7], new boolean[10]);
		System.out.println("No Answer");
	}

	static void dfs(int index, int[] choice, boolean[] visited) {
		// 정답 출력
		if (index == 7) {
			System.out.println("  " + choice[5] + choice[4] + choice[2] + choice[2] + choice[0]);
			System.out.println("+ " + choice[6] + choice[0] + choice[3] + choice[2] + choice[1]);
			System.out.println("-------");
			if (number[5] == 0)
				System.out.println("  " + number[4] + number[3] + number[2] + number[1] + number[0]);
			else
				System.out.println(" " + number[5] + number[4] + number[3] + number[2] + number[1] + number[0]);
			System.exit(0);
		}
		// 백트래킹 탐색
		for (int num = 0; num < 10; num++) {
			// 이미 사용된 것
			if (visited[num])
				continue;
			if (isValid(index, choice, num)) {
				choice[index] = num;
				setCarry(index, choice, 1);
				visited[num] = true;
				dfs(index + 1, choice, visited);
				visited[num] = false;
				setCarry(index, choice, 0);
			}
		}
	}

	private static void setCarry(int index, int[] choice, int set) {
		if (index == 1) {
			if (choice[0] + choice[1] >= 10)
				carry[1] = set;
		} else if (index == 2) {
			if (2 * choice[2] + carry[1] >= 10)
				carry[2] = set;
		} else if (index == 3) {
			if (choice[2] + choice[3] + carry[2] >= 10)
				carry[3] = set;
		} else if (index == 4) {
			if (choice[0] + choice[4] + carry[3] >= 10)
				carry[4] = set;
		} else if (index == 6) {
			if (choice[5] + choice[6] + carry[4] >= 10)
				carry[5] = set;
		}
	}

	static boolean isValid(int index, int[] choice, int num) {
		// o
		if (index == 0)
			return true;
		// d
		if (index == 1 && (choice[0] + num) % 10 == number[0])
			return true;
		// l
		if (index == 2 && (2 * num + carry[1]) % 10 == number[1])
			return true;
		// r
		if (index == 3 && (choice[2] + num + carry[2]) % 10 == number[2])
			return true;
		// e
		if (index == 4 && (choice[0] + num + carry[3]) % 10 == number[3])
			return true;
		// h
		if (index == 5 && num != 0)
			return true;
		// w
		if (index == 6 && num != 0 && (choice[5] + num + carry[4]) % 10 == number[4] && (choice[5] + num + carry[4]) / 10 == number[5])
			return true;
		return false;
	}
}
