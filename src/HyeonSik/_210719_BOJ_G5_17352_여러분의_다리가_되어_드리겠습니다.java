import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class _210719_BOJ_G5_17352_여러분의_다리가_되어_드리겠습니다 {
	static int N;
	static int[] parents;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		parents = new int[N + 1];
		for (int i = 1; i <= N; i++)
			parents[i] = i;
		for (int i = 0; i < N - 2; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			union(a, b);
		}
		HashSet<Integer> set = new HashSet<>();
		for (int i = 1; i <= N; i++)
			set.add(parents[i]);
		for (int cur : set) {
			System.out.print(cur + " ");
		}
	}

	static int getParent(int a) {
		if (parents[a] == a)
			return a;
		return parents[a] = getParent(parents[a]);
	}

	static void union(int a, int b) {
		a = getParent(a);
		b = getParent(b);
		if (a < b)
			parents[b] = a;
		else
			parents[a] = b;
	}
}
