class Solution {
    
    private static int[] numbers;
    private static int target;
    private static int answer; 
    
    public int solution(int[] nums, int tg) {
        numbers = nums;
        target = tg;
        answer = 0;
        
        dfs(0, 0);
        return answer;
    }
    
    private static void dfs(int idx, int sum) {
        if (idx == numbers.length) {
            if (sum == target) {
                answer++;
            }
            return;
        }
        
        
        int num = numbers[idx];

        dfs(idx + 1, sum + num);
        dfs(idx + 1, sum - num);
    }
}