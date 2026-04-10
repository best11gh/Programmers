import java.io.*;
import java.util.*;

public class Main {

    private static int[][] arr;
    private static int white = 0;
    private static int blue = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        paint(0, 0, N);

        System.out.println(white);
        System.out.println(blue);
    }

    private static void paint(int x, int y, int length) {
        if (isSame(x, y, length)) {
            if (arr[x][y] == 0) {
                white++;
            } else {
                blue++;
            }
            return;
        }

        int half = length / 2;
        paint(x, y, half);
        paint(x + half, y, half);
        paint(x, y + half, half);
        paint(x + half, y + half, half);
    }

    private static boolean isSame(int x, int y, int length) {
        int color = arr[x][y];
        for (int i = x; i < x + length; i++) {
            for (int j = y; j < y + length; j++) {
                if (arr[i][j] != color) {
                    return false;
                }
            }
        }
        return true;
    }
}
