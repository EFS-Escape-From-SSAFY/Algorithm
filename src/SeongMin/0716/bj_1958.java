import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class bj_1958 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = new String[3];
        for(int idx=0;idx<3;idx++)
            strings[idx]=br.readLine();
        int maxsize=0;
        for(String s:strings){
            maxsize = Math.max(maxsize,s.length());
        }
        int[][][] dp = new int[strings[0].length()+1][strings[1].length()+1][strings[2].length()+1];
        int cur=0;
        for(int i=0;i<strings[0].length();i++){
            for(int j=0;j<strings[1].length();j++){
                for(int k=0;k<strings[2].length();k++){
                    if(strings[0].charAt(i)==strings[1].charAt(j)&&strings[1].charAt(j)==strings[2].charAt(k)){
                        dp[i+1][j+1][k+1]=dp[i][j][k]+1;
                    }else{
                        int temp = Math.max(dp[i+1][j+1][k],dp[i][j+1][k+1]);
                        dp[i+1][j+1][k+1] = Math.max(temp,dp[i+1][j][k+1]);
                    }

                }
            }
        }
        System.out.println(dp[strings[0].length()][strings[1].length()][strings[2].length()]);
    }
}
