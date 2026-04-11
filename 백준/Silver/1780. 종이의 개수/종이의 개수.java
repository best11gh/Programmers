import java.io.*;
import java.util.*;

public class Main {

    private static int[][] arr;
    private static int[] cnt = new int[3];

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

        cut(0, 0, N);
        System.out.println(cnt[0]);
        System.out.println(cnt[1]);
        System.out.println(cnt[2]);
    }

    private static void cut(int x, int y, int size) {
        int value = arr[x][y];
        if (isSame(x, y, size, value)) {
            cnt[value + 1]++;
            return;
        }

        int third = size / 3;

        cut(x, y, third);
        cut(x, y + third, third);
        cut(x, y + 2 * third, third);

        cut(x + third, y, third);
        cut(x + third, y + third, third);
        cut(x + third, y + 2 * third, third);

        cut(x + 2 * third, y, third);
        cut(x + 2 * third, y + third, third);
        cut(x + 2 * third, y + 2 * third, third);
    }

    private static boolean isSame(int x, int y, int size, int value) {
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (arr[i][j] != value) {
                    return false;
                }
            }
        }
        return true;
    }
}
