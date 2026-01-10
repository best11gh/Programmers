import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] nums = new int[N];
        int max = 0;
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            nums[i] = num;
            max = Integer.max(num, max);
        }

        int[] countingArr = new int[max];
        for (Integer num : nums) {
            countingArr[num - 1]++;
        }

        for (int i = 1; i < countingArr.length; i++) {
            countingArr[i] += countingArr[i - 1];
        }

        int[] result = new int[N];
        for (int i = nums.length - 1; i >= 0; i--) {
            int num = nums[i];
            result[--countingArr[num - 1]] = num;
        }

        for (int num : result) {
            bw.write(String.valueOf(num));
            bw.newLine();
        }
        
        bw.close();
        br.close();
    }
}
