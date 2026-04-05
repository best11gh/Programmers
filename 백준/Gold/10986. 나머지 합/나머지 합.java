import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[] remain = new long[M];
        remain[0] = 1;

        long sum = 0;
        long result = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            sum += Long.parseLong(st.nextToken());

            int mod = (int) (sum % M);

            result += remain[mod];
            remain[mod]++;
        }

        System.out.println(result);
    }
}
