import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> people = new HashMap<>();
        
        for (String person : participant) {
            people.put(person, people.getOrDefault(person, 0) + 1);
        }

        for (String person : completion){
            int cnt = people.get(person) - 1;
 
            if (cnt == 0){
                people.remove(person);
            } else {
                people.put(person, cnt);
            }
        }
        

        String answer = people.keySet().iterator().next(); 
        return answer;
    }
}