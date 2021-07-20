import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class bj_1774 {
    static class route implements Comparable<route>{
        int num;
        double length;
        public route(int num, double length){
            this.num = num;
            this.length = length;
        }

        @Override
        public int compareTo(route o) {
            if(length>o.length)
                return 1;
            else
                return -1;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        double[][] map = new double[n+1][n+1];
        boolean[] visited = new boolean[n+1];
        double[] x = new double[n+1];
        double[] y = new double[n+1];
        for(int i=1;i<n+1;i++){
            st = new StringTokenizer(br.readLine());
            x[i]=Integer.parseInt(st.nextToken());
            y[i]=Integer.parseInt(st.nextToken());
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                double temp = Math.sqrt(Math.pow((x[i]-x[j]),2)+Math.pow((y[i]-y[j]),2));
                map[i][j]=temp;
                map[j][i]=temp;
            }
        }
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b]=0;
            map[b][a]=0;
        }
        int count=0;
        double result=0;
        PriorityQueue<route> routes = new PriorityQueue<>();
        visited[1]=true;
        for(int i=2;i<=n;i++)
            routes.add(new route(i,map[1][i]));
        while(!routes.isEmpty()){
            if(count==n-1)
                break;
            route temp  = routes.poll();
            if(!visited[temp.num]){
                visited[temp.num]=true;
                count++;
                result+=temp.length;
                for(int i=1;i<=n;i++)
                    routes.add(new route(i,map[temp.num][i]));
            }
        }
        System.out.printf("%.2f",result);
    }
}
