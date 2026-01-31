import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[8001];

        int sum = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            sum += num;
            nums[num + 4000] += 1;

            max = Integer.max(num, max);
            min = Integer.min(num, min);
        }

        int mean = (int) Math.round((double) sum / N);
        int range = max - min;

        int median = 0;
        int count = 0;

        int mode = 0;
        int modeMax = 0;
        boolean flag = false;

        for (int i = min + 4000; i <= max + 4000; i++) {
            if (nums[i] <= 0) {
                continue;
            }

            if (count < (N + 1) / 2) {
                count += nums[i];
                median = i - 4000;
            }

            if (modeMax < nums[i]) {
                modeMax = nums[i];
                mode = i - 4000;
                flag = true;
            } else if (modeMax == nums[i] && flag) {
                mode = i - 4000;
                flag = false;
            }
        }

        System.out.println(mean);
        System.out.println(median);
        System.out.println(mode);
        System.out.println(range);
    }
}
