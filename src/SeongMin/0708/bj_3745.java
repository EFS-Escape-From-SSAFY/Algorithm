
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class bj_3745 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int days[] = new int[n];
            for(int i=0;i<n;i++)
                days[i]=sc.nextInt();
            ArrayList<Integer> arr = new ArrayList<>();
            for(int i=0;i<n;i++){
                int temp  = days[i];
                if(arr.isEmpty() || arr.get(arr.size()-1) < temp)
                    arr.add(temp);
                else
                {
                    int left = 0;
                    int right = arr.size()-1;
                    while(left<right)
                    {
                        int mid = (left+right)/2;
                        if(arr.get(mid)>=temp)
                            right=mid;
                        else
                            left = mid+1;
                    }
                    arr.set(right,temp);
                }
            }
            System.out.println(arr.size());
        }
    }
}
