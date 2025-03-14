import java.io.*;
import java.util.Arrays;

public class Main {

    private static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        dp = new int[N + 1];
        for (int i = 2; i < N + 1; i++) {
            calculate(i);
        }

        System.out.println(dp[N]);

    }


    private static void calculate(int x) {
        if (x == 2 || x == 3) {
            dp[x] = 1;
            return;
        }

        int data = dp[x - 1];

        if (x % 2 == 0) {
            data = Math.min(dp[x / 2], data);
        }

        if (x % 3 == 0) {
            data = Math.min(dp[x / 3], data);
        }
        dp[x] = data + 1;
    }
}
