import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class _210914_BOJ_G2_4195_친구_네트워크 {
	static HashMap<String, String> parents;
	static HashMap<String, Integer> sizes;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		while (TC-- > 0) {
			int F = Integer.parseInt(br.readLine());
			parents = new HashMap<>();
			sizes = new HashMap<>();
			// F번 수행
			while (F-- > 0) {
				st = new StringTokenizer(br.readLine());
				String A = st.nextToken();
				String B = st.nextToken();
				// A가 없으면 만들고, 있으면 부모 구하기
				if (!parents.containsKey(A)) {
					parents.put(A, A);
					sizes.put(A, 1);
				} else
					A = getParent(A);
				// B가 없으면 만들고, 있으면 부모 구하기
				if (!parents.containsKey(B)) {
					parents.put(B, B);
					sizes.put(B, 1);
				} else
					B = getParent(B);

				union(A, B);
				// A와 B의 부모가 같으면, A가 속한 그룹 사이즈 출력
				// A와 B의 부모가 다르면, A와 B 그룹 사이즈 더한 값 출력
				A = getParent(A);
				B = getParent(B);
				if (A.equals(B)) {
					sb.append(sizes.get(A) + "\n");
				} else
					sb.append(sizes.get(A) + sizes.get(B) + "\n");
			}
		}
		// 마지막 개행 제거
		sb.setLength(sb.length() - 1);
		System.out.println(sb);
	}

	public static String getParent(String x) {
		if (parents.get(x).equals(x))
			return x;
		parents.put(x, getParent(parents.get(x)));
		return parents.get(x);
	}

	public static void union(String a, String b) {
		String parentA = getParent(a);
		String parentB = getParent(b);

		int diff = parentA.compareTo(parentB);
		if (diff == 0)
			return;
		else if (diff < 0) {
			sizes.put(parentA, sizes.get(parentA) + sizes.get(parentB));
			sizes.put(parentB, 0);
			parents.put(parentB, parentA);
		} else {
			sizes.put(parentB, sizes.get(parentA) + sizes.get(parentB));
			sizes.put(parentA, 0);
			parents.put(parentA, parentB);
		}
	}
}
