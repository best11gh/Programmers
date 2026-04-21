import java.io.*;
import java.util.*;

public class Main {

    private static int[] arr;
    private static int N;
    private static int C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        arr = new int[N];

        C = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int left = 1;
        int right = arr[N - 1] - arr[0];

        while (left <= right) {
            int mid = (left + right) / 2;

            if (canInstall(mid)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(right);
    }

    private static boolean canInstall(int length) {
        int cnt = 1;
        int last = arr[0];

        for (int i = 1; i < N; i++) {
            if (arr[i] - last >= length) {
                last = arr[i];
                cnt++;
            }
        }

        return cnt >= C;
    }
}
