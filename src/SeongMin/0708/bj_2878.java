
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class bj_2878 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        long M = sc.nextInt(); // 총 사탕 개수
        long N = sc.nextInt(); // 사람 수
        ArrayList<Long> candy = new ArrayList<>(); // 원하는 사탕 수
        long candysum = 0; // 원하는 사탕의 총 합
        for(int i=0;i<N;i++) {
            long temp = sc.nextInt();
            candy.add(temp);
            candysum+=temp;
        }
        Collections.sort(candy);
        long remainder = candysum - M;
        long result = 0;
        for(int i=0;i<N;i++){
             long tmp = Math.min(candy.get(i),remainder/(N-i));
             result += tmp*tmp;
             remainder -= tmp;

        }
        result = (long) (result % Math.pow(2,64));
        System.out.println(result);
    }
}
