import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.BitSet;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _210720_BOJ_G5_17453_두_개의_문 {
	static int n, m;
	static BitSet[] switches = new BitSet[21];
	// 이미 방문한 스위치인지 확인
	static boolean[] visited = new boolean[(1 << 21)];
	static int[] switchCount = new int[202];
	static int[] switchHistory = new int[202];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		String start = br.readLine();
		BitSet startbit = getBitSet(start);

		for (int i = 1; i <= 20; i++)
			switches[i] = new BitSet();
		for (int i = 1; i <= m; i++) {
			String str = br.readLine();
			switches[i] = getBitSet(str);
		}
		Arrays.fill(switchCount, -1);
		dfs(startbit, 0, 0, 1);
		for (int index = 100 - n; index <= 100 + n; index++) {
			// 눌러야 하는 스위치 개수
			sb.append(switchCount[index] + " ");
			// switchBit에서 켜져있는 스위치 위치 출력
			int switchBit = switchHistory[index];
			for (int count = 1; switchBit != 0; count++, switchBit /= 2) {
				if ((switchBit & 1) == 1) {
					sb.append(count + " ");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	private static void dfs(BitSet bitset, int count, int switchBit, int index) {
		if (count > m)
			return;
		// 중복 탐색 x
		if (visited[switchBit])
			return;
		visited[switchBit] = true;
		// index번 스위치 선택 x
		dfs(bitset, count, switchBit, index + 1);
		// i번 스위치 선택
		for (int i = index; i <= m; i++) {
			BitSet nextbit = (BitSet) bitset.clone();
			nextbit.xor(switches[i]);
			dfs(nextbit, count + 1, switchBit | 1 << (i - 1), i + 1);
		}
		int year = getYearFromBitSet(bitset);
		switchCount[year] = count;
		switchHistory[year] = switchBit;
	}

	public static int getYearFromBitSet(BitSet bitset) {
		return 100 + n - 2 * (n - bitset.cardinality());
	}

	public static BitSet getBitSet(String str) {
		BitSet bitset = new BitSet();
		for (int index = 0; index < str.length(); index++)
			if (str.charAt(str.length() - 1 - index) == '1')
				bitset.set(index);
		return bitset;
	}
}
// 스위치 개수: 20개
// 최대 2^20(1,000,000)의 스위치 종류가 가능함
// dfs로 돌면서 모든 종류의 스위치 가지수 탐색