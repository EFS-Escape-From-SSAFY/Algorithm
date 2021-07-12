package study0706;

import java.util.PriorityQueue;
import java.util.Scanner;

public class bj_13904 {
    static class Homework implements Comparable<Homework>{
        int day;
        int score;
        public Homework(int day, int score){
            this.day = day;
            this.score = score;
        }
        @Override
        public int compareTo(Homework o) {
            if(o.score>this.score) {
                return 1;
            }else if(o.score==this.score) {
                if(o.day>this.day)
                    return 1;
            }
            return -1;
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        boolean used[] = new boolean[1001];
        PriorityQueue<Homework> homeworkPriorityQueue = new PriorityQueue<>();
        for(int i=0;i<N;i++){
            homeworkPriorityQueue.add(new Homework(sc.nextInt(),sc.nextInt()));
        }
        int result = 0;
        for(Homework h:homeworkPriorityQueue){
            System.out.println(h.day+" "+h.score);
        }
        while(!homeworkPriorityQueue.isEmpty()){
            Homework homework = homeworkPriorityQueue.poll();
            for(int i=homework.day;i>0;i--){
                if(!used[i]){
                    result+=homework.score;
                    used[i]=true;
                    break;
                }
            }
        }
        System.out.println(result);
    }
}
