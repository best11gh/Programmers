import java.io.*;
import java.util.*;

public class Main {

    private static boolean[] visited;
    private static ArrayList<ArrayList<Node>> tree = new ArrayList<>();
    private static int max = 0;
    private static int start;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int V = Integer.parseInt(br.readLine());
        for (int i = 0; i < V + 1; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 0; i < V; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            while (true) {
                int e = Integer.parseInt(st.nextToken());
                if (e == -1) {
                    break;
                }
                int cost = Integer.parseInt(st.nextToken());
                tree.get(from).add(new Node(e, cost));
            }
        }

        visited = new boolean[V + 1];
        dfs(1, 0);

        visited = new boolean[V + 1];
        max = 0;
        dfs(start, 0);

        System.out.println(max);
    }

    private static void dfs(int v, int dist) {
        if (dist > max) {
            max = dist;
            start = v;
        }

        visited[v] = true;

        for (Node node : tree.get(v)) {
            if (!visited[node.e]) {
                dfs(node.e, node.cost + dist);
            }
        }
    }


    private static class Node {
        private final int e;
        private final int cost;

        public Node(int e, int cost) {
            this.e = e;
            this.cost = cost;
        }
    }

}
