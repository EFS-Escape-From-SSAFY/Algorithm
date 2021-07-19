import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_12893 {
    static int[] root;
    static int[] enemy;

    static int find(int x) {
        if (x == root[x])
            return x;
        else
            return find(root[x]);
    }

    static void union(int a, int b) {
        int x = find(a);
        int y = find(b);
        if (x == y) {
            return;
        }
        root[x] = y;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int answer = 1;
        root = new int[n + 1];
        enemy = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            root[i] = i;
            enemy[i] = 0;
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = find(Integer.parseInt(st.nextToken()));
            int b = find(Integer.parseInt(st.nextToken()));
            if (a==b) {
                answer = 0;
                break;
            }
            if (enemy[a] == 0) {
                enemy[a] = b;
            } else {
                union(enemy[a], b);
            }
            if (enemy[b] == 0) {
                enemy[b] = a;
            } else {
                union(enemy[b], a);
            }
        }
        System.out.print(answer);
    }
}
