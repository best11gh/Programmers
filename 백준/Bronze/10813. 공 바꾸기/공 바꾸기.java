import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = i + 1;
        }

        int M = Integer.parseInt(st.nextToken());

        for (int p = 0; p < M; p++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());

            int temp = nums[i-1];

            nums[i - 1] = nums[j - 1];
            nums[j - 1] = temp;
        }

        StringBuilder sb = new StringBuilder();

        for (int num : nums) {
            sb.append(num).append(" ");
        }

        System.out.println(sb);
    }
}
