import java.io.*;

public class Main {

    private static final int MOD = 1_000_000_007;
    private static final long[][] origin = {{1, 1}, {1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());

        if (n == 1) {
            System.out.println(1);
            return;
        }

        long[][] result = pow(origin, n - 1);
        System.out.println(result[0][0]);
    }

    private static long[][] pow(long[][] A, long B) {
        if (B == 1) {
            return A;
        }

        long[][] half = pow(A, B / 2);
        long[][] square = multiply(half, half);

        if (B % 2 == 0) {
            return square;
        }
        return multiply(square, A);
    }


    private static long[][] multiply(long[][] A, long[][] B) {
        long[][] result = new long[2][2];

        result[0][0] = (A[0][0] * B[0][0] + A[0][1] * B[1][0]) % MOD;
        result[0][1] = (A[0][0] * B[0][1] + A[0][1] * B[1][1]) % MOD;
        result[1][0] = (A[1][0] * B[0][0] + A[1][1] * B[1][0]) % MOD;
        result[1][1] = (A[1][0] * B[0][1] + A[1][1] * B[1][1]) % MOD;

        return result;
    }
}
