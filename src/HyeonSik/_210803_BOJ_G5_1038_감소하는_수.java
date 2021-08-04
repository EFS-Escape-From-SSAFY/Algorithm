import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _210803_BOJ_G5_1038_감소하는_수 {
	public static void main(String[] args) {
		// 최대 크기: 9876543210 -> Long
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Queue<Long> queue = new LinkedList<>();
		ArrayList<Long> list = new ArrayList<>();
		// 0 ~ 9 넣기
		for (int i = 0; i < 10; i++) {
			queue.add((long) i);
			list.add((long) i);
		}
		while (!queue.isEmpty()) {
			long cur = queue.poll();
			long lastNumber = cur % 10;
			// 맨 마지막 숫자보다 작은 숫자 붙여서 넣기
			for (int num = 0; num < lastNumber; num++) {
				queue.add(10 * cur + num);
				list.add(10 * cur + num);
			}
		}
		Collections.sort(list);
		if (N >= list.size())
			System.out.println(-1);
		else
			System.out.println(list.get(N));
	}
}
