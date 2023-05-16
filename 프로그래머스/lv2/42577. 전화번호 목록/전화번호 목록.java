import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {

        // HashSet<Integer> answer = new HashSet<>();
        boolean answer = true;
        Arrays.sort(phone_book);
        
        for(int i = 0; i<phone_book.length-1; i++){
            String one = (phone_book[i].length()>=phone_book[i+1].length())? phone_book[i]:phone_book[i+1]; // 큰 거
            String two = (phone_book[i].length()>=phone_book[i+1].length())? phone_book[i+1]:phone_book[i]; //작은 거
            if(one.startsWith(two)){
                answer = false;
                break;
            }
            
        }
        return answer;
        
//         for(int i = 0; i<phone_book.length; i++){
//             Integer str = Integer.valueOf(phone_book[i].substring(0, phone_book[0].length()));     
            
//             answer.add(str);
//         }
        
//         if(answer.size() != phone_book.length)
//             return false;
//         else
//             return true;

    }
}