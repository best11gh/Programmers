import java.io.*;
import java.util.*;

public class Main {

    private static int N;
    private static int result = Integer.MAX_VALUE;

    private static int[][] arr;
    private static boolean[] selected;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        selected = new boolean[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());
                arr[i][j] = num;
            }
        }

        dfs(0, 0);
        System.out.println(result);
    }


    private static void dfs(int cnt, int start) {
        if (cnt == N / 2) {
            calculate();
            return;
        }

        for (int i = start; i < N; i++) {
            selected[i] = true;
            dfs(cnt + 1, i + 1);
            selected[i] = false;
        }
    }

    private static void calculate() {
        int startT = 0;
        int linkT = 0;

        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                if (selected[i] && selected[j]) {
                    startT += arr[i][j] + arr[j][i];
                } else if (!selected[i] && !selected[j]) {
                    linkT += arr[i][j] + arr[j][i];
                }
            }
        }

        result = Math.min(result, Math.abs(startT - linkT));
    }
}
