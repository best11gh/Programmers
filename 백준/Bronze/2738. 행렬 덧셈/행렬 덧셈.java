import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int q = 0; q < M; q++) {
                    arr[j][q] += Integer.parseInt(st.nextToken());
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int[] ints : arr) {
            for (int num : ints) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
