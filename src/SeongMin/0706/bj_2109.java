
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;


public class bj_2109 {
    static class Offer implements Comparable<Offer>{
        int p;
        int d;
        public Offer(int p, int d){
            this.p = p;
            this.d = d;
        }
        @Override
        public int compareTo(Offer o) {
            if(o.p>this.p)
                return 1;
            else if(o.p==this.p)
                if(o.d>this.d)
                    return 1;
            return -1;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 총 입력값
        int max = 0;
        PriorityQueue<Offer> pqueue = new PriorityQueue<>();
        for(int i=0;i<n;i++){
            int p = sc.nextInt(); // 대학이 제시한 금액
            int d = sc.nextInt(); // 대학이 요청한 날짜
            pqueue.add(new Offer(p,d));
            max = Math.max(max,d);
        }
        boolean check[] = new boolean[max+1];
        int result = 0;
        while(!pqueue.isEmpty()){
            Offer o = pqueue.poll();
            for(int i=o.d;i>=1;i--){
                if(!check[i]){
                    check[i]=true;
                    result+=o.p;
                    break;
                }
            }
        }
        System.out.println(result);
    }
}
