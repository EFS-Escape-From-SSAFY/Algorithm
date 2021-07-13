import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_1240 {
    static class Point {
        int num;
        int length;
        Point(int num, int length) {
            this.num = num;
            this.length = length;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N, M;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        int[][] map = new int[N + 1][N + 1];
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            map[a][b] = r;
            map[b][a] = r;
        }
        for (int t = 0; t < M; t++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            boolean visited[] = new boolean[N+1];
            Queue<Point> queue = new LinkedList<>();
            queue.add(new Point(start, 0));
            visited[start]=true;
            while(!queue.isEmpty()) {
                Point p = queue.poll();
                if(p.num==end) {
                    sb.append(p.length + "\n");
                    break;
                }
                for(int i = 1;i<N+1;i++){
                    if(!visited[i]&&map[p.num][i]!=0) {
                        queue.add(new Point(i, p.length + map[p.num][i]));
                        visited[i]=true;
                    }
                }
            }
        }
        System.out.println(sb);
    }
}

