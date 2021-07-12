package study0706;

import java.util.*;

public class bj_1092 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int crains[] = new int[N];
        for(int i=0;i<N;i++) {
            crains[i] = sc.nextInt();
        }
        int M = sc.nextInt();
        LinkedList<Integer> boxes = new LinkedList<>();
        for(int i=0;i<M;i++) {
            boxes.add(sc.nextInt());
        }
        Arrays.sort(crains);
        Collections.sort(boxes,Collections.reverseOrder());
        int result=0;
        if(boxes.getFirst()>crains[N-1]) {
            result = -1;
        }
        else {
            while(boxes.size()>0){
                Iterator<Integer> iter = boxes.iterator();
                for(int i=N-1;i>=0;i--){
                    while(iter.hasNext())
                    {
                        int n = iter.next();
                        if(n<=crains[i]){
                            iter.remove();
                            break;
                        }
                    }
                }
                result++;
            }
        }
        System.out.println(result);
    }
}
