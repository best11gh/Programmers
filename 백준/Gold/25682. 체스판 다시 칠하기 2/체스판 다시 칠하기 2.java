import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] prefixSum = new int[N + 1][M + 1];

        // 시작 색이 B라고 생각
        for (int i = 1; i <= N; i++) {
            String line = br.readLine();
            for (int j = 1; j <= M; j++) {
                char input = line.charAt(j - 1);

                char expected = ((i + j) % 2 == 0) ? 'B' : 'W';
                int diff = (input == expected) ? 0 : 1;

                prefixSum[i][j] = prefixSum[i][j - 1] + prefixSum[i - 1][j] - prefixSum[i - 1][j - 1] + diff;
            }
        }

        // K 단위
        int min = Integer.MAX_VALUE;

        for (int i = K; i <= N; i++) {
            for (int j = K; j <= M; j++) {

                int repaint = prefixSum[i][j] - prefixSum[i - K][j] - prefixSum[i][j - K] + prefixSum[i - K][j - K];
                repaint = Math.min(repaint, K * K - repaint);
                
                min = Math.min(min, repaint);
            }
        }

        System.out.println(min);
    }
}
