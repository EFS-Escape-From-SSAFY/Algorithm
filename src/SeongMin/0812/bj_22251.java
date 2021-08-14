
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_22251 {
	public static void main(String[] args) throws Exception {
		int arr[][] = { { 1, 1, 1, 1, 1, 1, 0 }, { 0, 0, 0, 0, 1, 1, 0 }, { 1, 0, 1, 1, 0, 1, 1 },
				{ 1, 0, 0, 1, 1, 1, 1 }, { 0, 1, 0, 0, 1, 1, 1 }, { 1, 1, 0, 1, 1, 0, 1 }, { 1, 1, 1, 1, 1, 0, 1 },
				{ 1, 0, 0, 0, 1, 1, 0 }, { 1, 1, 1, 1, 1, 1, 1 }, { 1, 1, 0, 1, 1, 1, 1 } };
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int result = 0;
		for (int i = 1; i <= n; i++) {
			int num = i;
			int temp = x;
			int count = p;
			for (int j = k-1; j >=0; j--) {
				int r = (int)Math.pow(10,j);
				int t1 = (int) (num/r);
				int t2 = (int) (temp/r);
				num = num%r;
				temp = temp%r;
				for(int t=0;t<arr[0].length;t++) {
					if(arr[t1][t]!=arr[t2][t]) {
						count--;
					}
				}
				if(count<0)
					break;
			}
			if(count>=0) {
				result++;
			}

		}
		System.out.println(result-1);
	}
}
