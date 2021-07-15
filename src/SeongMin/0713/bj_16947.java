import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bj_16947 {
    static boolean[] cycle;
    static boolean[] visited;
    static int[] result;
    static ArrayList<Integer>[] arrays;

    static void dfs(int start, int cur, int count) {
        visited[cur] = true;
        for (int i : arrays[cur]) {
            if (count >= 2 && i == start) {
                cycle[start] = true;
                return;
            }
            if (!visited[i]) {
                dfs(start, i, count + 1);
            }
        }
        return;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        cycle = new boolean[N + 1];
        visited = new boolean[N + 1];
        arrays = new ArrayList[N + 1];
        result = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            arrays[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arrays[a].add(b);
            arrays[b].add(a);
        }
        for (int i = 1; i < N + 1; i++) {
            Arrays.fill(visited, false);
            dfs(i, i, 0);

        }
        ArrayList<Integer> edges = new ArrayList<>();
        for (int i = 1; i < N + 1; i++) {
            if (cycle[i] && arrays[i].size() > 2) {
                edges.add(i);
            }
        }
        Arrays.fill(visited, false);
        for (int edge : edges) {
            Queue<Integer> queue = new LinkedList<>();
            queue.add(edge);
            queue.add(1);
            while (!queue.isEmpty()) {
                int temp = queue.poll();
                int depth = queue.poll();
                for (int t : arrays[temp]) {
                    if (!cycle[t] && !visited[t]) {
                        visited[t] = true;
                        result[t] = depth;
                        queue.add(t);
                        queue.add(depth + 1);
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < N + 1; i++)
            sb.append(result[i] + " ");
        System.out.println(sb);
    }
}
