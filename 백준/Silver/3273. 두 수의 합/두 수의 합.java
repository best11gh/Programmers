import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int x = Integer.parseInt(br.readLine());

        int result = 0;

        Arrays.sort(arr);
        int start = 0;
        int end = n - 1;

        while (start < end) {
            int sum = arr[start] + arr[end];

            if (sum == x) {
                result++;
                start++;
                end--;
            } else if (sum > x) {
                end--;
            } else {
                start++;
            }
        }

        bw.write(result + "\n");
        bw.close();
        br.close();
    }
}
