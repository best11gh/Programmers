import java.io.*;

public class Main {
    private static int[][] apart;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        apart = new int[15][15];
        makeApart();

        for (int i = 0; i < T; i++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            sb.append(apart[k][n]).append("\n");
        }

        System.out.println(sb);
        br.close();
    }


    private static void makeApart() {
        for (int i = 0; i < 15; i++) {
            for (int j = 1; j < 15; j++) {
                if (i == 0){
                    apart[0][j] = j;
                    continue;
                }

                apart[i][j] = apart[i][j - 1] + apart[i - 1][j];
            }
        }


    }
}
