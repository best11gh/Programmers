import java.io.*;
import java.util.*;

public class Main {

    private static int[][] arr;
    private static List<Point> empty = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new int[9][9];

        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                int num = Integer.parseInt(st.nextToken());
                arr[i][j] = num;
                if (num == 0) {
                    empty.add(new Point(i, j));
                }
            }
        }

        dfs(0);
    }

    private static void dfs(int idx) {
        if (idx == empty.size()) {
            printBoard();
        }

        Point point = empty.get(idx);
        int x = point.x;
        int y = point.y;

        for (int num = 1; num <= 9; num++) {
            if (isPositive(x, y, num)) {
                arr[x][y] = num;
                dfs(idx + 1);
                arr[x][y] = 0;
            }
        }
    }

    private static void printBoard() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
        System.exit(0);
    }

    private static boolean isPositive(int x, int y, int num) {
        for (int pos = 0; pos < 9; pos++) {
            if (arr[x][pos] == num || arr[pos][y] == num) {
                return false;
            }
        }

        int boxX = (x / 3) * 3;
        int boxY = (y / 3) * 3;
        for (int i = boxX; i < boxX + 3; i++) {
            for (int j = boxY; j < boxY + 3; j++) {
                if (arr[i][j] == num) {
                    return false;
                }
            }
        }
        return true;
    }

    private static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
