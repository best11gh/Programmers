class Solution {
    
    private static final int AMERICANO = 5500;
    
    public int[] solution(int money) {
        int cnt = money / AMERICANO;
        int remain = money % AMERICANO;
        
        int[] answer = {cnt, remain};
        return answer;
    }
}