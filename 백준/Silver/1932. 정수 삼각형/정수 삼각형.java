import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i] = new int[i + 1];
            for (int j = 0; j < i + 1; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                int left = j > 0 ? arr[i - 1][j - 1] : 0;
                int right = j < i ? arr[i - 1][j] : 0;

                arr[i][j] += Math.max(left, right);
            }
        }

        int result = 0;
        for (int num : arr[n - 1]) {
            result = Math.max(result, num);
        }
        System.out.println(result);
    }

}
