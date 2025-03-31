import java.io.*;
import java.util.*;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static List<List<Integer>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        int result = 0;
        int minSum = Integer.MAX_VALUE;

        for (int i = 1; i <= N; i++) {
            int sum = bfs(i);
            if (sum < minSum) {
                minSum = sum;
                result = i;
            }
        }

        System.out.println(result);
    }


    private static int bfs(int start) {
        int[] distance = new int[N + 1];
        Arrays.fill(distance, -1);
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(start);
        distance[start] = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int neighbor : graph.get(current)) {
                if (distance[neighbor] == -1) {
                    distance[neighbor] = distance[current] + 1;
                    queue.offer(neighbor);
                }
            }
        }

        int sum = 0;
        for (int i = 1; i <= N; i++) {
            sum += distance[i];
        }
        return sum;
    }
}
