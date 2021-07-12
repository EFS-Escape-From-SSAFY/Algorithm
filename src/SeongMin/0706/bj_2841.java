
import java.util.Scanner;
import java.util.Stack;

public class bj_2841 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 입력 수
        int p = sc.nextInt(); // 프렛 수
        int result = 0;
        Stack<Integer> lines[] = new Stack[7]; // 각 라인의 기록
        for (int i = 1; i < 7; i++)
            lines[i] = new Stack<Integer>();
        for (int i = 0; i < n; i++) {
            int linenum = sc.nextInt(); // 누를 라인
            int pnum = sc.nextInt(); // 누를 프렛
            if (lines[linenum].isEmpty()) {
                result++;
                lines[linenum].push(pnum);
            } else {
                while (!lines[linenum].isEmpty()) {
                    int temp = lines[linenum].pop();
                    if (temp < pnum) {
                        lines[linenum].push(temp);
                        lines[linenum].push(pnum);
                        result++;
                        break;
                    } else if (temp > pnum) {
                        result++;
                        if(lines[linenum].isEmpty())
                        {
                            lines[linenum].push(pnum);
                            result++;
                            break;
                        }
                    } else {
                        lines[linenum].push(temp);
                        break;
                    }
                }
            }

        }
        System.out.println(result);
    }
}

