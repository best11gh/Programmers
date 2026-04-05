import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[] remain = new long[M];
        long sum = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            sum += Long.parseLong(st.nextToken());
            remain[(int) (sum % M)]++;
        }

        long result = 0;
        result += remain[0];

        for (int i = 0; i < M; i++) {
            result += remain[i] * (remain[i] - 1) / 2;
        }

        System.out.println(result);
    }
}
