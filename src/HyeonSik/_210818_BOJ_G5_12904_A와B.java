import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _210818_BOJ_G5_12904_A와B {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String S = br.readLine();
		StringBuilder T = new StringBuilder(br.readLine());
		while (S.length() <= T.length()) {
			// A와 B가 같으면, S를 T로 바꿀 수 있다.
			if (S.equals(T.toString())) {
				System.out.println(1);
				System.exit(0);
			}
			// 마지막이 A로 끝나면, A 지우기
			if (T.charAt(T.length() - 1) == 'A') {
				T.setLength(T.length() - 1);
			}
			// 마지막이 B로 끝나면, B를 지우고 뒤집기
			else if (T.charAt(T.length() - 1) == 'B') {
				T.setLength(T.length() - 1);
				T = T.reverse();
			}
			// 그 외의 경우, 만들 수 없음
			else {
				break;
			}
		}
		System.out.println(0);
	}
}
