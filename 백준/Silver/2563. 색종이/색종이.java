import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[100][100];

        int result = 0;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int left = Integer.parseInt(st.nextToken());
            int bottom = Integer.parseInt(st.nextToken());

            for (int x = left; x < left + 10; x++) {
                for (int y = bottom; y < bottom + 10; y++) {
                    if (arr[x][y] == 1) {
                        continue;
                    }
                    arr[x][y] = 1;
                    result++;
                }
            }
        }

        System.out.println(result);
    }
}
