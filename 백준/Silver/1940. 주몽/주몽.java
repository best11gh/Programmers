import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] nums = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);
        int result = 0;

        int start = 0;
        int end = N - 1;
        while (start < end) {
            int sum = nums[start] + nums[end];
            if (sum == M) {
                start++;
                end--;
                result++;
            } else if (sum > M) {
                end--;
            } else {
                start++;
            }

        }

        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
