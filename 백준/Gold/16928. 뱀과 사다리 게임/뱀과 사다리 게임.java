import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[] board = new int[101];
        
        for (int i = 1; i <= 100; i++) {
            board[i] = i;
        }
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            board[start] = end;
        }
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            board[start] = end;
        }
        
        
        System.out.println(bfs(board));
    }

    private static int bfs(int[] board) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[101];
        queue.add(new int[]{1, 0});
        visited[1] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int pos = cur[0];
            int moves = cur[1];
            if (pos == 100) {
                return moves;
            }
            for (int dice = 1; dice <= 6; dice++) {
                int nextPos = pos + dice;
                if (nextPos > 100) continue;
                int finalPos = board[nextPos];
                if (!visited[finalPos]) {
                    visited[finalPos] = true;
                    queue.add(new int[]{finalPos, moves + 1});
                }
            }
        }
        return -1;
    }
}
