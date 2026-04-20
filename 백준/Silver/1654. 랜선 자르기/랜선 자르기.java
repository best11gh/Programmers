import java.io.*;
import java.util.*;

public class Main {

    private static int N;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        arr = new int[K];
        long right = 0;
        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            right = Math.max(right, arr[i]);
        }

        long left = 1;
        while (left <= right) {
            long mid = (left + right) / 2;

            if (canMake(mid)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(right);
    }

    private static boolean canMake(long length) {
        long cnt = 0;

        for (int cable : arr) {
            cnt += cable / length;
        }

        return cnt >= N;
    }
}
