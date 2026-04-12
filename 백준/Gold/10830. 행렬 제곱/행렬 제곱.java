import java.io.*;
import java.util.*;

public class Main {

    private static int MOD = 1000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        int[][] A = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken()) % MOD;
            }
        }

        int[][] result = pow(A, B);

        StringBuilder sb = new StringBuilder();
        for (int[] nums : result) {
            for (int num : nums) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static int[][] pow(int[][] A, long B) {
        if (B == 1) {
            return A;
        }

        int[][] half = pow(A, B / 2);

        if (B % 2 == 0) {
            return square(half, half);
        }
        return square(half, square(half, A));
    }


    private static int[][] square(int[][] A, int[][] B) {
        int N = A.length;
        int[][] result = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    result[i][j] += A[i][k] * B[k][j];
                    result[i][j] %= MOD;
                }
            }
        }
        return result;
    }
}
