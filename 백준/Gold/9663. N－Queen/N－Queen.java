import java.io.*;

public class Main {

    private static int N;
    private static int[] arr;
    private static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        dfs(0);
        System.out.println(result);
    }

    private static void dfs(int row) {
        if (row >= N) {
            result++;
            return;
        }

        for (int x = 0; x < N; x++) {
            boolean attack = false;

            for (int prev = 0; prev < row; prev++) {
                if (arr[prev] == x || (Math.abs(row - prev) == Math.abs(arr[prev] - x))) {
                    attack = true;
                    break;
                }
            }

            if (!attack) {
                arr[row] = x;
                dfs(row + 1);
            }
        }
    }
}
