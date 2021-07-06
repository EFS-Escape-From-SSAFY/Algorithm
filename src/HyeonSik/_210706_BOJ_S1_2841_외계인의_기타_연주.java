import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class _210706_BOJ_S1_2841_외계인의_기타_연주 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		int result = 0;
		Stack<Integer>[] stacks = new Stack[7];
		for (int index = 1; index <= 6; index++)
			stacks[index] = new Stack<>();
		while (N-- > 0) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int flat = Integer.parseInt(st.nextToken());
			while (!stacks[num].isEmpty() && stacks[num].peek() > flat) {
				++result;
				stacks[num].pop();
			}
			if (!stacks[num].isEmpty() && stacks[num].peek() == flat) {
				continue;
			} else {
				result++;
				stacks[num].add(flat);
			}
		}
		System.out.println(result);
	}
}
