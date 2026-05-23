import java.util.*;

class Solution {
    
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        
        queue.offer(new int[]{0, 0});
        visited[0][0] = true;
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            
            int x = current[0];
            int y = current[1];
            
            if (x == n - 1 && y == m - 1) {
                return maps[x][y];
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    continue;
                }
                
                if (maps[nx][ny] == 0 || visited[nx][ny]) {
                   continue; 
                }
                
                visited[nx][ny] = true;
                maps[nx][ny] = maps[x][y] + 1;
                
                queue.offer(new int[]{nx, ny});
            }
        }
        
        
        return -1;
    }
}