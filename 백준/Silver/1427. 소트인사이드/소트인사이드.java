import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String N = br.readLine();
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < N.length(); i++) {
            nums.add(N.charAt(i) - '0');
        }

        nums.sort(Collections.reverseOrder());

        for (Integer num : nums) {
            bw.write(String.valueOf(num));
        }
        bw.close();
        br.close();
    }
}
