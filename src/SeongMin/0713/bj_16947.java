import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bj_16947 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        ArrayList<Integer>[] arrays = new ArrayList[N + 1];
        for (int i = 1; i < N + 1; i++) {
            arrays[i] = new ArrayList<Integer>();
        }
        int[] result = new int[N + 1];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arrays[a].add(b);
            arrays[b].add(a);
        }

        Queue<Integer> away = new LinkedList<>();
        for (int i = 1; i < N + 1; i++) {
            if (arrays[i].size() == 1) {
                away.add(i);
            }
        }
        boolean visited[] = new boolean[N + 1];
        while (!away.isEmpty()) {
            int start = away.poll();
            visited[start] = true;
            while (true) {
                System.out.println(start);
                if (arrays[start].size() > 2) {
                    int sum = 0;
                    int temp = 0;
                    for (int t : arrays[start]) {
                        if (!visited[t] && arrays[t].size() > 2) {
                            temp=t;
                            sum++;
                        }
                    }
                    System.out.println(sum);
                    if(sum==1){
                        visited[temp] = true;
                        start=temp;
                    }else{
                        break;
                    }
                }else{
                    System.out.println("here");
                    for(int t:arrays[start]){
                        if(!visited[t]){
                            start = t;
                            visited[t]=true;
                        }
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++)
            sb.append(visited[i] + " ");
        System.out.println(sb);
    }
}
