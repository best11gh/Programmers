import java.io.*;
import java.util.*;

public class Main {

    private static final int P = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        long top = factorial(N);
        long bottom = factorial(N - K) * factorial(K) % P;

        System.out.println(top * pow(bottom, P - 2) % P);
    }


    private static long factorial(int n) {
        long result = 1;
        while (n > 1) {
            result = (result * n) % P;
            n--;
        }
        return result;
    }

    private static long pow(long a, long b) {
        if (b == 1) {
            return a % P;
        }

        long half = pow(a, b / 2);
        if (b % 2 == 0) {
            return (half * half) % P;
        }
        return ((half * half) % P) * a % P;
    }
}
