import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class _210802_BOJ_G4_5052_전화번호_목록 {
	static boolean consistency = true;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			int n = Integer.parseInt(br.readLine());
			Trie trie = new Trie();
			consistency = true;
			for (int i = 0; i < n; i++) {
				char[] call = br.readLine().toCharArray();
				trie.insert(call, 0, trie);
			}
			if (consistency)
				sb.append("YES\n");
			else
				sb.append("NO\n");
		}

		System.out.println(sb);
	}

	public static class Trie {
		HashMap<Character, Trie> next;
		boolean isFinish;

		Trie() {
			this.isFinish = false;
			this.next = new HashMap<>();
		}

		void insert(char[] str, int index, Trie cur) {
			if (index == str.length) {
				cur.isFinish = true;
				// 현재 번호가 다른 번호의 접두사일 경우
				if (!cur.next.isEmpty())
					consistency = false;
				return;
			}
			char c = str[index];
			// 다음 Trie가 없는 경우, 새로 만들어줌
			if (!cur.next.containsKey(c)) {
				cur.next.put(c, new Trie());
			}
			// 다른 번호가 현재 번호의 접두사일 경우
			if (cur.isFinish)
				consistency = false;
			// 다음 단어 insert
			insert(str, index + 1, cur.next.get(c));
		}
	}
}
