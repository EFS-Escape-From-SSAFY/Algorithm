import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _210706_BOJ_G4_2109_순회강연 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int n = Integer.parseInt(br.readLine());
		boolean[] check = new boolean[10001];
		Info[] infos = new Info[n];
		for (int index = 0; index < n; index++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			infos[index] = new Info(p, d);
		}
		//pay값이 가장 큰 것부터 확인
		Arrays.sort(infos, (o1, o2) -> {
			if (o1.pay == o2.pay)
				return o1.day - o2.day;
			return o2.pay - o1.pay;
		});
		int result = 0;
		for (Info cur : infos) {
			//방문하지 않은 day 중 가장 큰 값 찾기
			while (check[cur.day])
				cur.day--;
			//방문 불가능할 경우, continue
			if (cur.day == 0)
				continue;
			check[cur.day] = true;
			result += cur.pay;
		}
		System.out.println(result);
	}

	public static class Info {
		int pay, day;

		Info(int p, int d) {
			this.pay = p;
			this.day = d;
		}
	}
}
