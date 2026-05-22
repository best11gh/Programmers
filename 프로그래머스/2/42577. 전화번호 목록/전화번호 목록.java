import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        Set<String> set = new HashSet<>();
        for (String phone : phone_book) {
            set.add(phone);
        }
        
        for (String phone : phone_book) {
            for (int i = 1; i < phone.length(); i++){
                String str = phone.substring(0, i);
                
                if (set.contains(str)) {
                    return false;
                }
            }
            
        }
        return true;
    }
}