import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] trees = new int[N];

        int min = 0;
        int max = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, trees[i]);
        }

        int result = 0;

        while (min <= max) {
            int mid = (min + max) / 2;

            long heights = 0;
            for (int tree : trees) {
                if (tree > mid) {
                    heights += tree - mid;
                }
            }

            if (heights >= M) {
                result = mid;
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }

        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}