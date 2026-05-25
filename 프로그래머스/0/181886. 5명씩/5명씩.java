class Solution {
    public String[] solution(String[] names) {
        int size = (names.length + 4) / 5;
        String[] answer = new String[size];

        int idx = 0;
        for (int i = 0; i < names.length; i++) {
            if (i % 5 == 0) {
                answer[idx] = names[i];
                idx++;
            }
        }

        return answer;
    }
}