import java.util.*;

class Solution {
    
    private static final int COMPLETE = 100;
    
    public int[] solution(int[] progresses, int[] speeds) {
        Deque<Integer> queue = new ArrayDeque<>();
        
        for (int i = 0; i < progresses.length; i++) {
            int progress = progresses[i];
            int speed = speeds[i];
            
            int day = (COMPLETE - progress + speed - 1) / speed;
            queue.offer(day);
        }
        
        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            int first = queue.poll();
            int cnt = 1;
            
            while (!queue.isEmpty() && first >= queue.peek()) {
                queue.poll();
                cnt++;
            }
            result.add(cnt);
        }
        
        int[] arr = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            arr[i] = result.get(i);
        }

        return arr;
    }
}