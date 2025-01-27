import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            if (N == 1) {
                bw.write(1 + "\n");
                br.readLine();
                continue;
            }
            st = new StringTokenizer(br.readLine());
            Queue<int[]> order = new LinkedList<>();
            for (int j = 0; j < N; j++) {
                order.add(new int[]{j, Integer.parseInt(st.nextToken())});
            }
            int result = getPriority(M, order);
            bw.write(result + "\n");
        }

        bw.flush();
        bw.close();

    }


    private static int getPriority(int M, Queue<int[]> order) {
        int result = 0;

        while (!order.isEmpty()) {
            int[] first = order.poll();
            boolean isHighest = true;

            for (int[] current : order) {
                if (first[1] < current[1]) {
                    order.add(first);
                    isHighest = false;
                    break;
                }
            }

            if (!isHighest) {
                continue;
            }

            result++;
            if (first[0] == M) {
                break;
            }
        }

        return result;

    }
}
