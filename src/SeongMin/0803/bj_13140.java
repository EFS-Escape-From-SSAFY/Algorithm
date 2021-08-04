import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj_13140 {
    static int n;
    static void check(boolean[] visited, int[] arr, int length){

        if(length==7){
            if(arr[0]==0||arr[1]==0)
                return;
            int temp=0;
            temp+=(arr[0]+arr[1])*10000;
            temp+=(arr[2]+arr[3])*1000;
            temp+=(arr[4]+arr[5])*100;
            temp+=arr[5]*20;
            temp+=arr[3]+arr[6];
            if(temp==n) {
                StringBuilder sb = new StringBuilder();
                sb.append("  ");
                sb.append(arr[1]);
                sb.append(arr[2]);
                sb.append(arr[5]);
                sb.append(arr[5]);
                sb.append(arr[3]+"\n");
                sb.append("+ ");
                sb.append(arr[0]);
                sb.append(arr[3]);
                sb.append(arr[4]);
                sb.append(arr[5]);
                sb.append(arr[6]+"\n");
                sb.append("-------\n");
                System.out.print(sb);
                System.out.printf("%7d",n);
                System.exit(0);
            }
            return;
        }
        for(int i=0;i<10;i++){
            if(!visited[i]){
                visited[i]=true;
                arr[length]=i;
                check(visited,arr,length+1);
                visited[i]=false;
            }
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        boolean[] visited = new boolean[10];
        int[]  arr = new int[7];
        check(visited,arr,0);
        System.out.println("No Answer");
    }
}
