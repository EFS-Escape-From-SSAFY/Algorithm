import java.util.Scanner;

public class bj_1344 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int[] oddnums = {2, 3, 5, 7, 11, 13, 17};
        double percentA = (double) a / 100;
        double percentB = (double) b / 100;
        double[][][] scoremap = new double[19][19][19];
        scoremap[0][0][1] = (1.0 - percentA) * (1.0 - percentB);
        scoremap[0][1][1] = (1.0 - percentA) * percentB;
        scoremap[1][0][1] = (1.0 - percentB) * percentA;
        scoremap[1][1][1] = percentA * percentB;
        for (int k = 2; k < 19; k++) {
            for (int i = 0; i < 19; i++) {
                for (int j = 0; j < 19; j++) {
                    scoremap[i][j][k] = scoremap[i][j][k - 1] * (1.0 - percentA) * (1.0 - percentB);
                    if (i > 0) {
                        scoremap[i][j][k] += scoremap[i - 1][j][k - 1] * (1.0 - percentB) * percentA;
                    }
                    if (j > 0) {
                        scoremap[i][j][k] += scoremap[i][j - 1][k - 1] * (1.0 - percentA) * percentB;
                    }
                    if (i > 0 && j > 0) {
                        scoremap[i][j][k] += scoremap[i - 1][j - 1][k - 1] * percentA * percentB;
                    }
                }
            }
        }
        double result = 0;
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                boolean check = false;
                for (int o : oddnums) {
                    if (o == i || o == j) {
                        check = true;
                        break;
                    }
                }
                if (check) {
                    result += scoremap[i][j][18];
                }
            }
        }
        System.out.println(result);
    }
}
