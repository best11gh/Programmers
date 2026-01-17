import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        System.out.println(A * B / getGcd(A, B));
    }


    private static long getGcd(long a, long b) {
        while (b > 0) {
            long r = a % b;
            a = b;
            b = r;
        }

        return a;
    }
}
