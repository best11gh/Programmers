import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long N = Long.parseLong(br.readLine());
        long k = Long.parseLong(br.readLine());

        long left = 1;
        long right = k;

        while (left <= right) {
            long mid = (left + right) / 2;

            long cnt = 0;
            for (long i = 1; i <= N; i++) {
                cnt += Math.min(mid / i, N);
            }

            if (cnt >= k) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(left);
    }
}
