import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static int[][] graph;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            // 인접 행렬 생성
            graph = new int[M][N];
            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());
                graph[X][Y] = 1;
            }

            visited = new boolean[M][N];

            int result = 0;
            for (int x = 0; x < M; x++) {
                for (int y = 0; y < N; y++) {
                    if (graph[x][y] == 1 & !visited[x][y]) {
                        dfs(x, y);
                        result++;
                    }
                }
            }

            bw.write(result + "\n");

        }

        bw.flush();
        bw.close();
        br.close();
    }


    private static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int x_i = x + dx[i];
            int y_i = y + dy[i];

            if (x_i >= 0 && x_i < graph.length && y_i >= 0 && y_i < graph[0].length
                    && !visited[x_i][y_i] && graph[x_i][y_i] == 1) {
                dfs(x_i, y_i);
            }
        }

    }

}
