import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _210712_BOJ_G3_13904_과제 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int result = 0;
        info[] arr = new info[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            arr[i] = new info(w, d);
        }
        Arrays.sort(arr, (o1, o2) -> {
            if (o1.weight == o2.weight)
                return o2.day - o1.day;
            return o2.weight - o1.weight;
        });
        boolean[] check = new boolean[1001];
        for(info cur: arr){
            int day = cur.day;
            while(check[day] && day >= 1)
                day--;
            if(day == 0)
                continue;
            result += cur.weight;
            check[day] = true;
        }
        System.out.println(result);
    }

    public static class info {
        int day, weight;

        info(int day, int weight) {
            this.day = day;
            this.weight = weight;
        }
    }
}
