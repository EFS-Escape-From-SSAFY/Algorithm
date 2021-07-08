import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class bj_1744 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int max = 10001;
        int result=0;
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0;i<n;i++) {
            int a = sc.nextInt();
            arr.add(a);
            if(a==1)
                result++;
        }
        Collections.sort(arr);
        int index0 = max;
        int index1 = max;
        for(int i=0;i<n;i++) {
            if(arr.get(i)==0)
                index0 = i;
            else if(arr.get(i)==1)
                index1 = i;
        }
        if(index1!=max){
            if((n-index1)%2==1)
            {
                //1이상 숫자 짝수개
                for(int i=n-1;i>index1;i-=2)
                {
                    result+=arr.get(i)*arr.get(i-1);
                }
            }else{
                //1이상 숫자 홀수개
                for(int i=n-1;i>index1+1;i-=2)
                {
                    result+=arr.get(i)*arr.get(i-1);
                }
                result+=arr.get(index1+1);
            }
        }else
        {
            for(int i=n-1;i>0;i-=2){
                int a = arr.get(i);
                int b = arr.get(i-1);
                if(a>0&&b<=0)
                    result+=a;
                if(a<=0||b<=0)
                    break;
                result+=a*b;
            }
            if(n%2==1&&arr.get(0)>0)
                result+=arr.get(0);
        }
        if(index0!=max) {
            if (index0 % 2 == 1) {
                //0보다 작은게 홀수개
                for (int i = index0; i > 0; i -= 2)
                    result += arr.get(i) * arr.get(i - 1);
            } else {
                if (index0 != 0)
                    for (int i = 0; i < index0-1; i += 2)
                        result += arr.get(i) * arr.get(i + 1);
            }
        }else
        {
            for(int i=0;i<n-1;i+=2){
                int a = arr.get(i);
                int b = arr.get(i+1);
                if(a<0&&b>0)
                    result+=a;
                if(a>0||b>0)
                    break;
                result+=a*b;
            }
            if(n%2==1&&arr.get(n-1)<0)
                result+=arr.get(n-1);
        }

        System.out.println(result);
    }
}
