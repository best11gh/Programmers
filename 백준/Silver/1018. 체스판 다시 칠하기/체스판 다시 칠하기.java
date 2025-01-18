import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] board = new String[N];

        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            board[i] = row;
        }

        int result = 64;
        for (int i = 0; i < N - 7; i++) {
            for (int j = 0; j < M - 7; j++) {
                String[] subBoard = Arrays.copyOfRange(board, i, i + 8);
                result = Math.min(getChangeCount(subBoard, j), result);
            }
        }

        bw.write(result + "\n");
        bw.flush();
        bw.close();
    }


    private static int getChangeCount(String[] board, int colCount) {
        String case1;
        String case2;
        int count = 0;

        char firstColor = board[0].charAt(colCount);
        if (firstColor == 'W') {
            case1 = "WBWBWBWB";
            case2 = "BWBWBWBW";
        } else {
            case1 = "BWBWBWBW";
            case2 = "WBWBWBWB";
        }

        for (int i = 0; i < 8; i++) {
            String caseRow = i % 2 == 0 ? case1 : case2;
            String row = board[i].substring(colCount, colCount + 8);

            if (row.equals(caseRow)) {
                continue;
            }

            for (int j = 0; j < 8; j++) {
                if (row.charAt(j) != caseRow.charAt(j)) {
                    count++;
                }
            }
        }

        return Math.min(count, 64 - count);
    }

}