import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static int whiteCount = 0;
    public static int blueCount = 0;
    public static int[][] paper;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        paper = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        divideAndCount(N, 0, 0);

        bw.write(whiteCount + "\n");
        bw.write(blueCount + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static void divideAndCount(int size, int row, int col) {
        if (countColor(size, row, col)) {
            return;
        }

        int newSize = size / 2;
        divideAndCount(newSize, row, col);
        divideAndCount(newSize, row + newSize, col);
        divideAndCount(newSize, row, col + newSize);
        divideAndCount(newSize, row + newSize, col + newSize);
    }


    public static boolean countColor(int size, int row, int col) {
        int color = paper[row][col];

        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (color != paper[i][j]) {
                    return false;
                }
            }
        }

        if (color == 0) {
            whiteCount++;
        } else {
            blueCount++;
        }

        return true;

    }
}
