class Solution {
    
    private static int DIVISION = 7;
    
    public int solution(int n) {
        boolean canDivide = n % DIVISION == 0;
        
        int answer = n / DIVISION + (canDivide ? 0: 1);
        
        
        return answer;
    }
}
