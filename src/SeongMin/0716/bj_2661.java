import java.util.Scanner;

public class bj_2661 {
    static int[] arr;
    static int n;

    static boolean check(int idx) {
        boolean check = true;
        outerloop:
        for (int i = 1; i <= (idx+1) / 2; i++) {
            int count=0;
            for (int j = 0; j < i; j++) {
                if (arr[idx - j] == arr[idx - i - j]) {
                  count++;
                }
            }
            if(count==i)
                check=false;
        }
        return check;
    }

    static void backtraking(int idx) {
        if (idx == n) {
            for (int i : arr)
                System.out.print(i);
            System.out.println();
            System.exit(0);
        }
        for (int i = 1; i < 4; i++) {
            arr[idx] = i;
            if (check(idx)) {
                backtraking(idx + 1);
            }
        }
        return;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];
        backtraking(0);
        for (int i : arr)
            System.out.print(i);
    }
}
