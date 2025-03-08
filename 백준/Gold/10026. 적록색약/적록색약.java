import java.io.*;

public class Main {

    public static int N;
    public static char[][] graph;
    public static boolean[][] visited;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        graph = new char[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            graph[i] = line.toCharArray();
        }

        int normal = 0;
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    dfs(i, j);
                    normal++;
                }
            }
        }

        int blind = 0;
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    dfsByBlind(i, j);
                    blind++;
                }
            }
        }

        bw.write(normal + "\n");
        bw.write(blind + "\n");
        bw.flush();
        bw.close();
        br.close();
    }


    private static void dfs(int x, int y) {
        visited[x][y] = true;
        char color = graph[x][y];

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (isValid(nx, ny) && !visited[nx][ny] && color == graph[nx][ny]) {
                dfs(nx, ny);
            }
        }

    }

    private static void dfsByBlind(int x, int y) {
        visited[x][y] = true;
        char color = graph[x][y];

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (isValid(nx, ny) && !visited[nx][ny]) {
                if ((color == 'R' || color == 'G') && (graph[nx][ny] == 'R' || graph[nx][ny] == 'G')) {
                    dfsByBlind(nx, ny);
                } else if (color == graph[nx][ny]) {
                    dfsByBlind(nx, ny);
                }
            }
        }


    }


    private static boolean isValid(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }
}
