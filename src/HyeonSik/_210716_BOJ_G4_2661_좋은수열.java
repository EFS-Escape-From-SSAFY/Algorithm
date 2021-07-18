
import java.util.Scanner;

public class _210716_BOJ_G4_2661_좋은수열 {
	static int N;
	static String res;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		dfs("");
	}

	private static void dfs(String str) {
		if (str.length() == N) {
			System.out.println(str);
			System.exit(0);
		}
		for (int i = 1; i <= 3; i++) {
			String nextStr = str + Integer.toString(i);
			boolean check = true;
			for (int j = 0; check && j < nextStr.length(); j++) {
				String temp = nextStr.substring(j);
				if ((temp.length() & 1) == 0) {
					String temp1 = temp.substring(0, temp.length() / 2);
					String temp2 = temp.substring(temp.length() / 2, temp.length());
					if (temp1.equals(temp2)) {
						check = false;
						continue;
					}
				}
			}
			if (check)
				dfs(nextStr);
		}
	}
}