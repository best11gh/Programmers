import java.io.*;

public class Main {

    private static char[][] arr;
    private static final char pattern = '*';

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        arr = new char[N][N];
        star(0, 0, N);

        StringBuilder sb = new StringBuilder();
        for (char[] chars : arr) {
            for (char aChar : chars) {
                sb.append(aChar);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void star(int x, int y, int n) {
        if (n == 1) {
            arr[x][y] = pattern;
            return;
        }

        int size = n / 3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 1 & j == 1) {
                    blank(x + size, y + size, size);
                } else {
                    star(x + i * size, y + j * size, size);
                }
            }
        }

    }

    private static void blank(int x, int y, int size) {
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                arr[i][j] = ' ';
            }
        }
    }
}
