class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            
            if (i == 0 || s.charAt(i - 1) == ' '){
                answer.append(Character.toUpperCase(ch));
            } else {
                answer.append(Character.toLowerCase(ch));
            }
        }
        
        return answer.toString();
    }
}