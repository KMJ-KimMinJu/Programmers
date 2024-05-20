import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        
        Arrays.sort(phone_book);
        
        HashMap<Integer,String> map = new HashMap<>();
        boolean answer = true;
        
        for(int i = 0; i<phone_book.length; i++){
            map.put(i,phone_book[i]);
        }
        
        for(int i = 0; i<map.size()-1; i++){
            String number = map.get(i);
            String number2 = map.get(i+1);
            
                if(number2.startsWith(number)){
                    answer = false;
                    return answer;
                }
            
        }
        
        return answer;
    }
}