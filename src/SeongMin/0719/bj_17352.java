import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_17352 {
    static int[] root; // 대표 섬
    static int[] rank; // 트리의 높이

    static int find(int x) {
        if (root[x] == x)
            return x;
        else {
            return find(root[x]);
        }
    }

    static void union(int a, int b) {//대표 합치기
        int tempa = find(a);
        int tempb = find(b);
        if (tempa == tempb) {
            return;
        } else {
            if (rank[tempa] < rank[tempb]) {
                root[tempa] = root[tempb];
            } else {
                root[tempb] = root[tempa];
                if (rank[tempa] == rank[tempb]) {
                    rank[tempa]++;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        root = new int[n + 1];
        rank = new int[n + 1];
        for (int i = 1; i <= n; i++) // 자신을 대표로 초기화
            root[i] = i;
        for (int i = 0; i < n - 2; i++) {
            st = new StringTokenizer(br.readLine());
            union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        int t = find(1);
        for (int i = 2; i <= n; i++) {
            if (find(i) != t) {
                System.out.println(1+" "+i);
                break;
            }
        }
    }
}
