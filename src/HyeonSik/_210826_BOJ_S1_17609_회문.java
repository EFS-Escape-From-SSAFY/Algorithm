import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _210826_BOJ_S1_17609_회문 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			String string = br.readLine();
			int left = 0, right = string.length() - 1;
			while (true) {
				if (left >= right) {
					result.append(0 + "\n");
					break;
				}
				if (string.charAt(left) != string.charAt(right)) {
					if (isPalindrome(string.substring(left + 1, right + 1))) {
						result.append(1 + "\n");
					} else if (isPalindrome(string.substring(left, right))) {
						result.append(1 + "\n");
					} else {
						result.append(2 + "\n");
					}
					break;
				}
				left++;
				right--;
			}
		}
		System.out.println(result);
	}

	public static boolean isPalindrome(String string) {
		int left = 0, right = string.length() - 1;
		while (left < right) {
			if (string.charAt(left) != string.charAt(right))
				return false;
			left++;
			right--;
		}
		return true;
	}
}
