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
                if (j == 0) {
                    arr[i][j] += arr[i - 1][j];
                    continue;
                }

                if (j == arr[i].length - 1) {
                    arr[i][j] += arr[i - 1][j - 1];
                    continue;
                }

                arr[i][j] += Math.max(arr[i - 1][j], arr[i - 1][j - 1]);
            }
        }

        int result = 0;
        for (int num : arr[n - 1]) {
            result = Math.max(result, num);
        }
        System.out.println(result);
    }

}
