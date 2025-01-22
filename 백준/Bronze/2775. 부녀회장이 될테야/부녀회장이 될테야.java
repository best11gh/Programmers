import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    private static final int[][] apart = new int[15][15];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        makeApart();

        for (int i = 0; i < T; i++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());

            int count = apart[k][n];
            bw.write(count + "\n");
        }
        br.close();
        bw.flush();
        bw.close();

    }


    private static void makeApart() {
        for (int i = 0; i < 15; i++) {
            for (int j = 1; j < 15; j++) {
                if (i == 0) {
                    apart[i][j] = j;
                    continue;
                }

                apart[i][j] = apart[i][j - 1] + apart[i - 1][j];
            }
        }
    }


}
