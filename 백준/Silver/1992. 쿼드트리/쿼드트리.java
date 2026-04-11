import java.io.*;
import java.util.*;

public class Main {

    private static int[][] arr;
    private static StringBuilder result = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = line.charAt(j) - '0';
            }
        }
        
        compress(0, 0, N);
        System.out.println(result);
    }


    private static void compress(int x, int y, int size) {
        int point = arr[x][y];
        if (isSame(x, y, size, point)) {
            result.append(point);
            return;
        }

        int halfSize = size / 2;

        result.append("(");
        compress(x, y, halfSize);
        compress(x, y + halfSize, halfSize);
        compress(x + halfSize, y, halfSize);
        compress(x + halfSize, y + halfSize, halfSize);
        result.append(")");
    }

    private static boolean isSame(int x, int y, int size, int point) {
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (point != arr[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
