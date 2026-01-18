import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] trees = new int[N];
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(br.readLine());
        }

        int gcd = trees[1] - trees[0];
        for (int i = 2; i < N; i++) {
            int diff = trees[i] - trees[i - 1];
            gcd = getGcd(gcd, diff);
        }

        int total = 0;
        for (int i = 1; i < N; i++) {
            int diff = trees[i] - trees[i - 1];
            total += (diff / gcd) - 1;
        }

        System.out.println(total);
    }

    private static int getGcd(int a, int b) {
        while (b > 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}
