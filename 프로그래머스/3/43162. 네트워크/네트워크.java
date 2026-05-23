class Solution {
    
    private static boolean[] visited;
    private static int[][] computers;
    
    public int solution(int n, int[][] cps) {
        int answer = 0;
        visited = new boolean[n];
        computers = cps;
        
        for (int i = 0; i < n; i++){
            if (!visited[i]) {
                answer++;
                dfs(i);
            }
        }
        return answer;
    }
    
    private static void dfs(int idx) {
        visited[idx] = true;
        
        for (int i = 0; i < computers.length; i++) {
            boolean connect = computers[idx][i] == 1;
            
            if (connect) {
                if (!visited[i]) {
                    dfs(i);
                }
            }
        }
    }
}