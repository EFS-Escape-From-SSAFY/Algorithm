import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class bj_17453 {
    static ArrayList<Integer>[] result;
    static int[] switches;
    static int start;
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        start = 0;
        result = new ArrayList[2 * n + 1];
        for(int i=0;i<2*n+1;i++){
            result[i]=new ArrayList<>();
        }
        String temp = br.readLine();
        int cur = 0;
        for (int i = n - 1; i >= 0; i--) {
            start += (temp.charAt(cur++) - '0') * Math.pow(2, i);
        }
        switches = new int[m + 1];
        for (int j = 1; j <= m; j++) {
            temp = br.readLine();
            cur = 0;
            for (int i = n - 1; i >= 0; i--) {
                switches[j] += (temp.charAt(cur++) - '0') * Math.pow(2, i);
            }
        }
        for (int i = 0; i < (1 << m); i++) {
            ArrayList<Integer> subset = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                if ((i & 1 << j) > 0) {
                    subset.add(j);
                }
            }
            int tempstart = start;
            for(int t:subset){
                tempstart^=t;
            }
            tempstart = -n+2*Integer.bitCount(tempstart);
            if(tempstart<=n&&tempstart>=-n&&result[tempstart+n].size()==0){
                System.out.println("asd"+tempstart+n);
                result[tempstart+n].addAll(subset);
            }
        }
        for(ArrayList<Integer> a:result)
            System.out.println(a.size());
    }
}
