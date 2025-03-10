import java.io.*;
import java.util.*;

public class Main {
    public static int M, N;
    public static int[][] graph;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        graph = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                if (graph[i][j] == 1) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        int result = bfs();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (graph[i][j] == 0) {
                    bw.write("-1\n");
                    bw.flush();
                    return;
                }
            }
        }

        bw.write(result + "\n");
        bw.flush();
    }

    private static int bfs() {
        int days = -1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int s = 0; s < size; s++) {
                int[] current = queue.poll();
                int x = current[0];
                int y = current[1];

                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if (isValid(nx, ny) && graph[nx][ny] == 0) {
                        graph[nx][ny] = 1;
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
            days++;
        }
        return days;
    }

    private static boolean isValid(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }
}
