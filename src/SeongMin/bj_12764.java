package study0706;

import java.util.PriorityQueue;
import java.util.Scanner;

public class bj_12764 {
    static class Person implements Comparable<Person>{
        int starttime;
        int endtime;
        public Person(int starttime,int endtime){
            this.starttime = starttime;
            this.endtime = endtime;
        }
        @Override
        public int compareTo(Person o) {
            if(o.starttime<this.starttime)
                return 1;
            else if(o.starttime==this.starttime){
                if(o.endtime<this.endtime)
                    return 1;
            }
            return -1;
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Person> pqueue = new PriorityQueue<>();
        for(int i=0;i<n;i++){
            int st = sc.nextInt();
            int et = sc.nextInt();
            pqueue.add(new Person(st,et));
        }
        int[] computers = new int[n];
        int[] uses = new int[n];
        int result = 0;
        while(!pqueue.isEmpty()){
            Person p = pqueue.poll();
            for(int i=0;i<n;i++){
                if(computers[i]<=p.starttime){
                    uses[i]++;
                    computers[i]=p.endtime;
                    break;
                }
            }
        }
        for(int i:computers){
            if(i==0)
                break;
            result++;
        }
        System.out.println(result);
        for(int i=0;i<result;i++)
            System.out.print(uses[i]+" ");
    }
}
