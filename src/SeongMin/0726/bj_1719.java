import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class bj_1719 {
    static ArrayList<Point>[] ways;
    static int n;
    static int m;
    static class Point implements Comparable<Point>{
        int num;
        int weight;
        public Point(int num, int weight){
            this.num = num;
            this.weight = weight;
        }

        @Override
        public int compareTo(Point o) {
            return this.weight - o.weight;
        }
    }
    static void dijikstra(int num){
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Point> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[n+1];
        int[] past = new int[n+1];
        int[] length = new int[n+1];
        Arrays.fill(length,10001);
        length[num]=0;
        past[num]=num;
        pq.add(new Point(num,0));
        while(!pq.isEmpty()){
            Point cur = pq.poll();
            if(visited[cur.num])
                continue;
            visited[cur.num]=true;
            for(Point next : ways[cur.num]){
                if(length[next.num]>length[cur.num]+next.weight){
                    length[next.num]=length[cur.num]+next.weight;
                    past[next.num]=cur.num;
                    pq.add(new Point(next.num,length[next.num]));
                }
            }
        }

        for(int v = 1; v <= n; v++) {
            if(v == num) {
                sb.append("- ");
                continue;
            }
            int answer = 0;
            for(int j = v; j != num; j = past[j]) {
                answer = j;
            }
            sb.append(answer + " ");
        }
        System.out.println(sb);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        ways = new ArrayList[n+1];
        for(int i=1;i<=n;i++){
            ways[i] = new ArrayList<>();
        }
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            ways[a].add(new Point(b,r));
            ways[b].add(new Point(a,r));
        }
        for(int i=1;i<=n;i++){
            dijikstra(i);
        }
    }
}
