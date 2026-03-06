import java.io.*;
import java.util.*;

public class Main {

    private static int N;
    private static int M;

    private static boolean[] visited;
    private static int[] arr;

    private static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N];
        arr = new int[M];

        dfs(0);

        System.out.println(sb);
    }

    private static void dfs(int depth) {
        if (depth == M) {
            for (int num : arr) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int num = 0; num < N; num++) {
            if (!visited[num]) {
                visited[num] = true;
                arr[depth] = num + 1;
                dfs(depth + 1);
                visited[num] = false;
            }
        }
    }

}
