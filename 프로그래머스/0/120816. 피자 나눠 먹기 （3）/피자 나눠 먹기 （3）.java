class Solution {    
    public int solution(int slice, int n) {
        boolean canDivide = n % slice == 0;
        int answer = n / slice + (canDivide ? 0 : 1);
        return answer;
    }
}