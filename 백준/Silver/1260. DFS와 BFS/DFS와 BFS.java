import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        // 인접 리스트 생성
        int N = Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        // 인접 리스트 채우기
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            putEdge(graph, a, b);
        }

        // 정렬
        for (ArrayList<Integer> integers : graph) {
            Collections.sort(integers);
        }

        boolean[] visited = new boolean[N + 1];
        StringBuilder sb = new StringBuilder();

        dfs(graph, visited, V, sb);
        sb.append("\n");

        Arrays.fill(visited, false);

        bfs(graph, visited, V, sb);

        bw.write(sb + "\n");

        bw.flush();
        bw.close();
        br.close();
    }


    private static void putEdge(ArrayList<ArrayList<Integer>> graph, int x, int y) {
        graph.get(x).add(y);
        graph.get(y).add(x);
    }

    private static void dfs(ArrayList<ArrayList<Integer>> graph, boolean[] visited, int v, StringBuilder sb) {
        sb.append(v).append(" ");
        visited[v] = true;

        for (Integer nextV : graph.get(v)) {
            if (visited[nextV]) {
                continue;
            }

            dfs(graph, visited, nextV, sb);
        }
    }

    private static void bfs(ArrayList<ArrayList<Integer>> graph, boolean[] visited, int v, StringBuilder sb) {
        Queue<Integer> q = new LinkedList<>();
        q.add(v);
        visited[v] = true;

        while (!q.isEmpty()){
            int temp = q.poll();
            sb.append(temp).append(" ");

            for (Integer nextV : graph.get(temp)){
                if (visited[nextV]){
                    continue;
                }
                visited[nextV] = true;
                q.add(nextV);
            }



        }


    }


}
