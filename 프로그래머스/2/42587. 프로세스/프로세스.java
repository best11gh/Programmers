import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Deque<Process> queue = new ArrayDeque<>();
        for (int i = 0; i < priorities.length; i++){
            queue.offer(new Process(i, priorities[i]));
        }
        
        int answer = 0;
        while (!queue.isEmpty()) {
            Process process = queue.poll();
            boolean higher = false;
            
            for (Process p: queue) {
                if (p.priority > process.priority) {
                    higher = true;
                    break;
                }
            }
            
            
            if (higher) {
                queue.offer(process);
            } else {
                answer++;
                if (process.idx == location) {
                    return answer;
                }
            }
        }
        
        return answer;
    }
    
    class Process {
        int idx;
        int priority;
        
        public Process(int idx, int priority) {
            this.idx = idx;
            this.priority = priority;
        }
    }
}