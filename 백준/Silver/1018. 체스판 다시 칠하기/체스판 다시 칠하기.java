import java.io.*;
import java.util.*;

public class Main {

    private static boolean[][] arr; // true: B, false: W

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        arr = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = line.charAt(j) == 'B';
            }
        }

        int result = 64;

        for (int i = 0; i < N - 7; i++) {
            for (int j = 0; j < M - 7; j++) {
                result = Math.min(result, getRepaintCount(i, j));
            }
        }

        System.out.println(result);
    }

    private static int getRepaintCount(int x, int y) {
        boolean firstColor = arr[x][y];
        int count = 0;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                boolean expected = ((i + j) % 2 == 0) ? firstColor : !firstColor;

                if (arr[x + i][y + j] != expected) {
                    count++;
                }
            }
        }
        count = Math.min(count, 64 - count);
        return count;
    }
}
