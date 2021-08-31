import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _210831_BOJ_G4_2457_공주님의_정원 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());
		int result = 0;
		PriorityQueue<date> pq = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int startMonth = Integer.parseInt(st.nextToken());
			int startDay = Integer.parseInt(st.nextToken());
			int endMonth = Integer.parseInt(st.nextToken());
			int endDay = Integer.parseInt(st.nextToken());
			pq.add(new date(startMonth, startDay, endMonth, endDay));
		}
		int endMonth = 3, endDay = 1;
		while (!pq.isEmpty()) {
			// 일단 하나 꺼내고 확인
			date pick = pq.poll();
			if (isOver(pick.startMonth, pick.startDay, endMonth, endDay))
				break;
			// 꽅이 지는 시기가 가장 늦은 것 고르기
			while (!pq.isEmpty()) {
				date cur = pq.poll();
				// 꽃이 피는 시기가 목표 시기보다 늦는 경우, 다시 넣고 break
				if (isOver(cur.startMonth, cur.startDay, endMonth, endDay)) {
					pq.add(cur);
					break;
				}
				// 꽃이 지는 시기가 가장 늦은 것 pick에 넣기
				if (isOver(cur.endMonth, cur.endDay, pick.endMonth, pick.endDay))
					pick = cur;
			}
			result++;
			// 11월 30일 까지 다 고른 경우, 종료
			if (isEnd(pick)) {
				System.out.println(result);
				System.exit(0);
			}
			endMonth = pick.endMonth;
			endDay = pick.endDay;
		}
		System.out.println(0);
	}

	public static boolean isOver(int startMonth, int startDay, int endMonth, int endDay) {
		if (startMonth > endMonth)
			return true;
		if (startMonth == endMonth && startDay > endDay)
			return true;
		return false;
	}

	public static boolean isEnd(date cur) {
		if (cur.endMonth == 12 || (cur.endMonth == 11 && cur.endDay == 31))
			return true;
		return false;
	}

	public static class date implements Comparable<date> {
		int startMonth, startDay, endMonth, endDay;

		date(int startMonth, int startDay, int endMonth, int endDay) {
			this.startMonth = startMonth;
			this.startDay = startDay;
			this.endMonth = endMonth;
			this.endDay = endDay;
		}

		@Override
		public int compareTo(date o) {
			if (this.startMonth == o.startMonth && this.startDay == o.startDay) {
				if (this.endMonth == o.endMonth)
					return o.endDay - this.endDay;
				return o.endMonth - this.endMonth;
			}
			if (this.startMonth == o.startMonth)
				return this.startDay - o.startDay;
			return this.startMonth - o.startMonth;
		}
	}
}
