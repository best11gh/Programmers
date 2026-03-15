import java.io.*;
import java.util.*;

public class Main {

    private static int N;

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
        
        dfs(1, arr[0]);

        System.out.println(max);
        System.out.println(min);
    }

    private static void dfs(int idx, int value) {
        if (idx == N) {
            max = Integer.max(max, value);
            min = Integer.min(min, value);
            return;
        }

        int num = arr[idx];

        for (int i = 0; i < 4; i++) {
            if (oper[i] > 0) {
                oper[i]--;
                dfs(idx + 1, calculate(value, num, i));
                oper[i]++;
            }
        }
    }

    private static int calculate(int a, int b, int operator) {
        switch (operator) {
            case 0:
                return a + b;
            case 1:
                return a - b;
            case 2:
                return a * b;
            case 3:
                return a / b;
        }
        return 0;
    }
}
