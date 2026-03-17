import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int result = tile(N);
        System.out.println(result);
    }

    private static int tile(int n) {
        if (n == 1) {
            return 1;
        }

        int prev2 = 1;
        int prev1 = 2;

        for (int i = 3; i <= n; i++) {
            int current = (prev1 + prev2) % 15746;
            prev2 = prev1;
            prev1 = current;
        }
        return prev1;
    }
}
