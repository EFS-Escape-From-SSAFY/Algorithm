import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _210706_BOJ_G3_12764_싸지방에_간_준하 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int count = 0;
		// infos: 컴퓨터 사용 정보
		Info[] infos = new Info[N];
		for (int index = 0; index < N; index++) {
			st = new StringTokenizer(br.readLine());
			int P = Integer.parseInt(st.nextToken());
			int Q = Integer.parseInt(st.nextToken());
			infos[index] = new Info(P, Q);
		}
		Arrays.sort(infos, (o1, o2) -> {
			if (o1.start == o2.start)
				return o1.end - o2.end;
			return o1.start - o2.start;
		});

		//사용 중인 컴퓨터
		PriorityQueue<Info> usingComputers = new PriorityQueue<>();
		//사용 가능한 컴퓨터
		PriorityQueue<Integer> availableComputers = new PriorityQueue<>();
		//usingCount[index] = index번 컴퓨터가 몇 번 사용 되었는지
		int[] usingCount = new int[100001];
		for (Info cur : infos) {
			//현재 시간(cur.start)에 사용이 끝난 컴퓨터가 있는지 확인
			//있으면 availableComputers에 넣기
			while (!usingComputers.isEmpty() && usingComputers.peek().end < cur.start) {
				availableComputers.add(usingComputers.poll().index);
			}
			//사용 가능한 컴퓨터 있으면
			if (!availableComputers.isEmpty()) {
				usingCount[availableComputers.peek()]++;
				usingComputers.add(new Info(cur.start, cur.end, availableComputers.poll()));
			}
			//사용 가능한 컴퓨터 없으면, 새로운 컴퓨터 사용
			else {
				count++;
				usingCount[count]++;
				usingComputers.add(new Info(cur.start, cur.end, count));
			}
		}
		sb.append(count + "\n");
		for (int index = 1; index <= count; index++)
			sb.append(usingCount[index] + " ");
		System.out.println(sb);
	}

	public static class Info implements Comparable<Info> {
		int start, end, index;

		public Info(int p, int q) {
			this.start = p;
			this.end = q;
		}

		public Info(int start, int end, int index) {
			this.start = start;
			this.end = end;
			this.index = index;
		}

		@Override
		public int compareTo(Info o) {
			if (this.end == o.end)
				return this.index - o.index;
			return this.end - o.end;
		}
	}
}
