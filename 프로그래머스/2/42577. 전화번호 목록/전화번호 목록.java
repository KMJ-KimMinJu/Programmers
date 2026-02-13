import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        
        Arrays.sort(phone_book);
        
        HashMap<Integer, String> numbers = new HashMap<>();
        
        for(int i = 0; i < phone_book.length; i++){
            numbers.put(i, phone_book[i]);
        }
        
        boolean answer = true;
        
        for(int i = 0; i < phone_book.length-1; i++){
            String first = numbers.get(i);
            
                String second = numbers.get(i+1);
                
                if(second.startsWith(first)){
                    answer = false;
                    break;
                }

        }
        
        return answer;
    }
}