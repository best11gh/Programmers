import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    private static int M;
    private static final ArrayList<Node> chickens = new ArrayList<>();
    private static final ArrayList<Node> homes = new ArrayList<>();
    private static final ArrayList<Node> selected = new ArrayList<>();
    private static boolean[] visited;
    private static int result = Integer.MAX_VALUE;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   // 도시 크기
        M = Integer.parseInt(st.nextToken());   // 치킨 집 개수

        // 그래프 만들기
        int[][] graph = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int info = Integer.parseInt(st.nextToken());
                graph[i][j] = info;
                if (info == 1) {
                    homes.add(new Node(i, j));
                } else if (info == 2) {
                    chickens.add(new Node(i, j));
                }
            }
        }
        visited = new boolean[chickens.size()];

        dfs(0, 0);

        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static void dfs(int count, int start) {
        if (count == M) {
            // 결과 출력
            int sum = 0;
            for (Node home : homes) {
                int min = Integer.MAX_VALUE;
                for (Node chicken : selected) {
                    int distance = Math.abs(home.x - chicken.x) + Math.abs(home.y - chicken.y);
                    min = Math.min(min, distance);
                }
                sum += min;
            }
            result = Math.min(result, sum);
            return;
        }

        for (int i = start; i < chickens.size(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                selected.add(chickens.get(i));
                dfs(count + 1, i + 1);
                selected.remove(chickens.get(i));
                visited[i] = false;
            }
        }


    }


    private static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
