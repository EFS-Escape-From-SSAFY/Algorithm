import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_17182 {
    static int n;
    static int start;
    static int[][] map;
    static int result;
    public static void dfs(boolean[] visited,int index, int length, int sum){
        if(length==n-1){
            result = Math.min(result,sum);
            return;
        }
        for(int i=0;i<n;i++){
            if(i!=index){
                if(!visited[i]){
                    visited[i]=true;
                    dfs(visited,i,length+1,sum+map[index][i]);
                    visited[i]=false;
                }
            }
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        result=Integer.MAX_VALUE;
        for(int k=0;k<n; k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(map[i][k]+map[k][j]<map[i][j]){
                        map[i][j]=map[i][k]+map[k][j];
                    }
                }
            }
        }
        boolean[] visited = new boolean[n];
        visited[start]=true;
        dfs(visited,start,0,0);
        System.out.println(result);
    }
}
