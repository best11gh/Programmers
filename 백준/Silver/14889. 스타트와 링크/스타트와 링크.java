import java.io.*;
import java.util.*;

public class Main {

    private static int N;
    private static int result = Integer.MAX_VALUE;

    private static int[][] arr;
    private static List<Integer> selected = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];

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
            List<Integer> non = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                if (!selected.contains(i)) {
                    non.add(i);
                }
            }
            result = Math.min(result, Math.abs(calculate(selected) - calculate(non)));
            return;
        }

        for (int i = start; i < N; i++) {
            selected.add(i);
            dfs(cnt + 1, i + 1);
            selected.remove(selected.size() - 1);
        }
    }

    private static int calculate(List<Integer> selected) {
        int result = 0;

        for (int i = 0; i < selected.size(); i++) {
            int x = selected.get(i);
            for (int j = i; j < selected.size(); j++) {
                int y = selected.get(j);
                result += arr[x][y] + arr[y][x];
            }
        }
        return result;
    }
}
