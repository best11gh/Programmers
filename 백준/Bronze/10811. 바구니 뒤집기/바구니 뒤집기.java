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
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken()) - 1;
            int right = Integer.parseInt(st.nextToken()) - 1;

            while (left < right) {
                int temp = nums[left];
                nums[left++] = nums[right];
                nums[right--] = temp;
            }
        }

        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
