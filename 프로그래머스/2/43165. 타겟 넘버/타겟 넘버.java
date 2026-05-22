class Solution {
    
    private static int[] numbers;
    private static int target;
    private static int result; // 만들어지는 숫자
    private static int answer; // 방법의 수
    
    public int solution(int[] nums, int tg) {
        numbers = nums;
        target = tg;
        result = 0;
        answer = 0;
 
        
        dfs(0);
        return answer;
    }
    
    private static void dfs(int cnt) {
        if (cnt == numbers.length) {
            if (result == target) {
                answer++;
            }
            return;
        }
        
        
        int num = numbers[cnt];

        result += num;
        dfs(cnt+1);
            

        result -= (num * 2);
        dfs(cnt + 1);
            
        result += num;
    }
}