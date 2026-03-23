import java.io.*;

public class Main {

    private static int MOD = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N + 1][10];

        for (int i = 1; i <= 9; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 0; j <= 9; j++) {
                int left = j > 0 ? dp[i - 1][j - 1] : 0;
                int right = j < 9 ? dp[i - 1][j + 1] : 0;
                dp[i][j] = (left + right) % MOD;
            }
        }

        int result = 0;
        for (int i = 0; i <= 9; i++) {
            result = (result + dp[N][i]) % MOD;
        }
        System.out.println(result);
    }
}
