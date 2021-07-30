import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_11437 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        ArrayList<Integer>[] edge = new ArrayList[n+1];
        int[] rank = new int[n+1];
        int[] parent = new int[n+1];
        for(int i=1;i<=n;i++){
            edge[i] = new ArrayList<>();
        }
        for(int i=0;i<n-1;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            edge[a].add(b);
            edge[b].add(a);
        }
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n+1];
        queue.add(1);
        visited[1]=true;
        while(!queue.isEmpty()){
            int p = queue.poll();
            for(int c:edge[p]){
                if(!visited[c]) {
                    queue.add(c);
                    rank[c] = rank[p] + 1;
                    parent[c] = p;
                    visited[c]=true;
                }
            }
        }
        int m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(rank[a]>rank[b]){
                for(int j=rank[a];j>rank[b];j--){
                    a=parent[a];
                }
            }else{
                for(int j=rank[b];j>rank[a];j--){
                    b=parent[b];
                }
            }
            while(a!=b){
                a=parent[a];
                b=parent[b];
            }
            sb.append(a+"\n");
        }
        System.out.println(sb);
    }
}
