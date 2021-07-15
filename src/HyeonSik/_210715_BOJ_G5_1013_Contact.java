import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _210715_BOJ_G5_1013_Contact {
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		while (N-- > 0) {
			String str = br.readLine();
			System.out.println(solve(str, 0) ? "YES" : "NO");

		}
	}

	private static boolean solve(String str, int start) {
		int len = str.length();
		for (int idx = 0; idx < len;) {
			if (str.charAt(idx) == '0') {
				if (idx + 1 == len)
					return false;
				if (str.charAt(idx + 1) != '1')
					return false;
				else
					idx += 2;
			} else {
				int cntZero = 0;
				idx++;
				for (; idx < len && str.charAt(idx) == '0'; idx++, cntZero++)
					;
				if (cntZero < 2 || idx == len)
					return false;
				int cntOne = 0;
				for (; idx < len && str.charAt(idx) == '1'; idx++, cntOne++)
					;
				if (cntOne == 0)
					return false;
				if (idx == len)
					return true;
				if (cntOne == 1) {
					continue;
				} else {
					if (idx + 1 < len && str.charAt(idx) == '0' && str.charAt(idx + 1) == '0') {
						idx--;
					}
				}
			}
		}
		return true;
	}
}
