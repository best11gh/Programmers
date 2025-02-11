import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int computer = Integer.parseInt(br.readLine());
        int pair = Integer.parseInt(br.readLine());

        int[][] graph = new int[computer + 1][computer + 1];

        for (int i = 0; i < pair; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());

            graph[num1][num2] = 1;
            graph[num2][num1] = 1;
        }
        boolean[] visited = new boolean[computer + 1];

        int result = dfs(1, visited, graph) - 1;
        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static int dfs(int v, boolean[] visited, int[][] graph) {
        visited[v] = true;
        int result = 1;

        for (int i = 1; i < graph[v].length; i++) {
            if (graph[v][i] == 1 && !visited[i]) {
                result += dfs(i, visited, graph);
            }
        }

        return result;
    }
}
