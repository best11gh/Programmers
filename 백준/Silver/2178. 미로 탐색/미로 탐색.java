import java.awt.Point;
import java.io.*;
import java.util.*;

public class Main {

    private static int N;
    private static int M;
    private static int[][] graph;
    private static boolean[][] visited;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            for (int j = 0; j < M; j++) {
                graph[i][j] = row.charAt(j) - '0';
            }
        }

        bfs(0, 0);
        System.out.println(graph[N - 1][M - 1]);
    }


    private static void bfs(int x, int y) {
        visited[x][y] = true;
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));

        while (!queue.isEmpty()) {
            Point point = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = point.x + dx[i];
                int ny = point.y + dy[i];

                if (!isInBounds(nx, ny) || graph[nx][ny] == 0 || visited[nx][ny]) {
                    continue;
                }

                queue.add(new Point(nx, ny));
                visited[nx][ny] = true;
                graph[nx][ny] = graph[point.x][point.y] + 1;
            }
        }
    }

    private static boolean isInBounds(int x, int y) {
        return (x >= 0 && x < N && y >= 0 && y < M);
    }


}
