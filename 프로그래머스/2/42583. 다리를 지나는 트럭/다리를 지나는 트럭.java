import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < bridge_length; i++){
            queue.offer(0);
        }

        int totalW = 0;
        int time = 0;
        int idx = 0;
        
        while (idx < truck_weights.length) {
            totalW -= queue.poll();
            time++;
            
            int currentW = truck_weights[idx];
            if (totalW + currentW <= weight) {
                queue.offer(currentW);
                totalW += currentW;
                idx++;
            } else {
                queue.offer(0);
            }
        }
        
        time += bridge_length;
        return time;
    }
}