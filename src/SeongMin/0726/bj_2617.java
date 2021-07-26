import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj_2617 {
    static ArrayList<Integer>[] morethan;
    static ArrayList<Integer>[] lessthan;
    static int N;
    static int M;
    static int half;
    static boolean[] visited;
    static int count;
    static void frontdfs(int num){
        visited[num]=true;
        for(int a:lessthan[num]){
            if(!visited[a]){
                count++;
                frontdfs(a);
            }
        }
    }
    static void backdfs(int num){
        visited[num]=true;
        for(int a:morethan[num]){
            if(!visited[a]){
                count++;
                backdfs(a);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        morethan = new ArrayList[N+1];//i 보다 큰 숫자 개수
        lessthan = new ArrayList[N+1];//i 보다 작은 숫자 개수
        visited = new boolean[N+1];
        for(int i=1;i<=N;i++){
            morethan[i]=new ArrayList<Integer>();
            lessthan[i]=new ArrayList<Integer>();
        }
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            lessthan[b].add(a);
            morethan[a].add(b);
        }
        half = N/2+1;
        int result=0;
        for(int i=1;i<=N;i++){
            count=0;
            Arrays.fill(visited,false);
            frontdfs(i);
            if(count>=half){
                result++;
                continue;
            }
            count=0;
            Arrays.fill(visited,false);
            backdfs(i);
            if(count>=half)
                result++;
        }
        System.out.println(result);
    }
}
