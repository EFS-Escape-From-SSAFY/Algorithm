import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class _210913_BOJ_G5_20437_문자열게임2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			String string = br.readLine();
			int K = Integer.parseInt(br.readLine());
			int minLength = Integer.MAX_VALUE, maxLength = Integer.MIN_VALUE;
			// 알파벳 별로 ArrayList 만들기
			ArrayList<Integer>[] alphabets = new ArrayList[26];
			for (int i = 0; i < 26; i++)
				alphabets[i] = new ArrayList<>();
			// 알파벳마다 인덱스 위치 저장
			for (int index = 0; index < string.length(); index++) {
				char c = string.charAt(index);
				alphabets[c - 'a'].add(index);
			}
			for (int index = 0; index < 26; index++) {
				// 해당 알파벳이 K개 이상인 경우
				if (alphabets[index].size() >= K) {
					// 슬라이딩 윈도우
					int start = 0, end = K - 1;
					for (; end < alphabets[index].size(); end++, start++) {
						int diff = alphabets[index].get(end) - alphabets[index].get(start) + 1;
						minLength = Math.min(minLength, diff);
						maxLength = Math.max(maxLength, diff);
					}
				}
			}
			if (minLength != Integer.MAX_VALUE) {
				sb.append(minLength + " " + maxLength + "\n");
			} else
				sb.append("-1\n");
		}
		System.out.println(sb);
	}
}
