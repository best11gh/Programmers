import java.io.*;
import java.util.*;

public class Main {

    private static int M;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        arr = new int[N];
        M = Integer.parseInt(st.nextToken());

        long left = 0;
        long right = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            right = Math.max(right, arr[i]);
        }

        while (left <= right) {
            long mid = (left + right) / 2;

            if (canCut(mid)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(right);
    }

    private static boolean canCut(long height) {
        long total = 0;
        for (int tree : arr) {
            total += Math.max(tree - height, 0);
        }
        return total >= M;
    }
}
