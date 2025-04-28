import java.io.*;
import java.util.*;

public class Main {

    private static int[][][] tomato;
    private static int[] dx = { -1, 1, 0, 0, 0, 0 };
    private static int[] dy = { 0, 0, -1, 1, 0, 0 };
    private static int[] dz = { 0, 0, 0, 0, -1, 1 };
    private static int M;
    private static int N;
    private static int H;
    private static Queue<Pont3D> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        tomato = new int[H][N][M];

        for (int z = 0; z < H; z++) {
            for (int y = 0; y < N; y++) {
                st = new StringTokenizer(br.readLine());
                for (int x = 0; x < M; x++) {
                    tomato[z][y][x] = Integer.parseInt(st.nextToken());
                    if (tomato[z][y][x] == 1) {
                        queue.add(new Pont3D(x, y, z));
                    }
                }
            }
        }

        bfs();

        int days = 0;
        for (int z = 0; z < H; z++) {
            for (int y = 0; y < N; y++) {
                for (int x = 0; x < M; x++) {
                    if (tomato[z][y][x] == 0) {
                        System.out.println(-1);
                        return;
                    }
                    days = Math.max(days, tomato[z][y][x]);
                }
            }
        }

        System.out.println(days - 1);
    }

    private static void bfs() {
        while (!queue.isEmpty()) {
            Pont3D p = queue.poll();
            for (int i = 0; i < 6; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                int nz = p.z + dz[i];

                if (isAvailable(nx, ny, nz)) {
                    tomato[nz][ny][nx] = tomato[p.z][p.y][p.x] + 1;
                    queue.add(new Pont3D(nx, ny, nz));
                }
            }
        }
    }

    private static boolean isAvailable(int x, int y, int z) {
        if (x < 0 || x >= M || y < 0 || y >= N || z < 0 || z >= H) {
            return false;
        }
        return tomato[z][y][x] == 0;
    }

}

class Pont3D {
    int x, y, z;

    public Pont3D(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}
