import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class bj_10971 {
    static boolean[] visited;
    static int result;
    static int n;
    static int map[][];
    public static void dfs(int start,int index, int length, int sum){
        if(length==n&&start==index){
            result = Math.min(result,sum);
            return;
        }
        for(int i=1;i<=n;i++){
            if(i!=index){
                if(!visited[i]&&map[index][i]>0){
                    visited[i]=true;
                    dfs(start,i,length+1,sum+map[index][i]);
                    visited[i]=false;
                }
            }
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        visited = new boolean[n + 1];
        result = 999999999;
        map = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        for(int i=1;i<=n;i++){
            dfs(i,i,0,0);
        }
        System.out.println(result);
    }
}
