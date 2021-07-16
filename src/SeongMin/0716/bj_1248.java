import java.util.Scanner;

public class bj_1248 {
    static int num;
    static int[] arr;
    static int[][] plusminus;

    static boolean check(int idx) {
        int temp = num-idx;
        for(int i=0;i<temp;i++){
            int t = 0;
            for(int j=idx;j>idx-1;j++){
                t+=arr[idx];
            }
            if(temp*plusminus[temp-1][i]<0)
                return false;
            else if(temp==0&&plusminus[temp-1][i]!=0)
                return false;
            else if(temp!=0&&plusminus[temp-1][i]!=0)
                return false;
        }
        return true;
    }
    static void backtracking(int idx) {
        if (idx == 0) {
            for (int i : arr)
                System.out.print(i);
            System.exit(0);
        }
        for(int i=-10;i<=10;i++)
        {
            arr[idx]=i;
            if(check(idx)){
                backtracking(idx-1);
            }else
                return;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        num = sc.nextInt();
        arr = new int[num];
        String s = sc.next();
        plusminus = new int[num][num];
        int cur = num*(num+1)/2-1;
        for(int i=0;i<4;i++){
            for(int j=0;j<=i;j++){
                switch(s.charAt(cur--)){
                    case '-':
                        plusminus[i][j]=-1;
                        break;
                    case '0':
                        plusminus[i][j]=0;
                        break;
                    case '+':
                        plusminus[i][j]=1;
                        break;
                }
            }

        }
        backtracking(3);
    }
}
