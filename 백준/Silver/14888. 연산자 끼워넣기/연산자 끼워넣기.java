import java.io.*;
import java.util.*;

public class Main {

    private static int N;
    private static int result;

    private static int[] arr;
    private static int[] oper;

    private static int min = Integer.MAX_VALUE;
    private static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        oper = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            oper[i] = Integer.parseInt(st.nextToken());
        }

        result = arr[0];
        dfs(1);

        System.out.println(max);
        System.out.println(min);
    }
    
    private static void dfs(int idx) {
        if (idx == N) {
            max = Integer.max(max, result);
            min = Integer.min(min, result);
            return;
        }

        int num = arr[idx];

        for (int i = 0; i < 4; i++) {
            if (oper[i] != 0) {
                int prev = result;

                calculate(num, i);
                oper[i] -= 1;

                dfs(idx + 1);
                
                result = prev;
                oper[i] += 1;
            }
        }
    }

    private static void calculate(int num, int operator) {
        switch (operator) {
            case 0:
                result += num;
                break;
            case 1:
                result -= num;
                break;
            case 2:
                result *= num;
                break;
            case 3:
                result /= num;
                break;
        }
    }
}
