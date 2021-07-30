import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bj_2623 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        sc.nextLine();	//아래서 nextLine() 받기 전에 버퍼에 남아있는 엔터 처리

        int[] inDegree = new int[1001];
        ArrayList<Integer>[] outDegree  =new ArrayList[1001];
        for(int i = 1; i<=N; i++) {
            outDegree[i] = new ArrayList<Integer>();
        }
        ArrayList<Integer> list = new ArrayList<Integer>();

        for(int i = 0; i<M; i++) {

            int singerNum = sc.nextInt();

            for(int k = 0; k<singerNum; k++) {
                int num = sc.nextInt();
                list.add(num);
            }


            for(int k = 0; k<list.size()-1; k++) {
                int first = list.get(k);
                int second = list.get(k+1);

                inDegree[second] += 1;
                outDegree[first].add(second);

            }
            list.clear();
        }


        Queue<Integer> que = new LinkedList<Integer>();
        for(int i = 1; i<=N; i++) {
            if(inDegree[i]==0) {
                que.add(i);
            }
        }


        ArrayList<Integer> ansList = new ArrayList<Integer>();
        while(!que.isEmpty()) {

            int now = que.poll();
            ansList.add(now);

            for(int i = 0; i<outDegree[now].size(); i++) {
                int next = outDegree[now].get(i);
                inDegree[next] -= 1;
                if(inDegree[next]==0) que.add(next);
            }
        }

        if(ansList.size()!=N) {
            ansList.clear();
            ansList.add(0);
        }
        for(int i = 0; i<ansList.size(); i++) {
            System.out.println(ansList.get(i));
        }
    }
}