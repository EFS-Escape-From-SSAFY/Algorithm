import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class bj_12738 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer> arr = new ArrayList<>();
        int[] list = new int[n];
        for(int i=0;i<n;i++){
            list[i] = Integer.parseInt(st.nextToken());
        }
        for(int num:list){
            int t = num;
            int left = 0;
            int right = arr.size()-1;
            if(right<0){//처음에 값을 넣어준다.
                arr.add(t);
            }else{
                if(arr.get(right)<t){//마지막 값보다 들어온 값이 클 경우 lis에 넣어준다.
                    arr.add(t);
                }else{
                    while(left<right){
                        int middle = (right+left)>>1;
                        if(arr.get(middle)>=t){
                            right=middle;
                        }else{
                            left=middle+1;
                        }
                    }
                    arr.set(right,t);
                }
            }
        }
        System.out.println(arr.size());
    }
}
