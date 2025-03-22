import java.io.*;
import java.util.*;

public class Main {
    private static Queue<Integer> queue = new LinkedList<>();
    private static boolean[] visited = new boolean[100001];
    private static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int result = bfs(N);

        System.out.println(result);
    }

    private static int bfs(int v) {
        queue.add(v);
        visited[v] = true;
        int time = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int s = 0; s < size; s++) {
                int current = queue.poll();
                if (current == K) {
                    return time;
                }

                int[] dx = {current - 1, current + 1, current * 2};

                for (int nx : dx) {
                    if (nx >= 0 && nx <= 100000 && !visited[nx]) {
                        visited[nx] = true;
                        queue.add(nx);
                    }
                }


            }
            time++;

        }
        return time;
    }

}
