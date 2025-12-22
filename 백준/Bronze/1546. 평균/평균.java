import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] scores = new int[N];
        int max = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            scores[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, scores[i]);
        }

        double total = 0;

        for (double score : scores) {
            total += score / max * 100;
        }

        System.out.println(total / N);
    }
}
