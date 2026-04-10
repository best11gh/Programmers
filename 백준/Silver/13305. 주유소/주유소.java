import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long[] roads = new long[N - 1];
        long[] prices = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N - 1; i++) {
            roads[i] = Long.parseLong(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            prices[i] = Long.parseLong(st.nextToken());
        }

        long totalCost = 0;
        long minPrice = prices[0];
        for (int i = 0; i < N - 1; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            totalCost += minPrice * roads[i];
        }

        System.out.println(totalCost);
    }
}
