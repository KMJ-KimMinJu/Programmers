import java.util.*;

class Solution {
    public int solution(String s) {
        
        String x = "";
        int answer = 0; //나눠지는 문자열의 수
        int same_count = 0; //x와 같은 문자의 수
        int diff_count = 0; //x와 다른 문자의 수
        
        boolean a = true;
        
        for(int i= 0; i<s.length(); i++){
            if(a) x = String.valueOf(s.charAt(i));
            
            if(x.equals(String.valueOf(s.charAt(i)))){
                same_count ++;
                a = false;
            }else{
                diff_count ++;
            }
            
            if(same_count ==diff_count){
                answer ++;
                same_count = 0;
                diff_count = 0;
                a = true; //x의 값을 바꿔주기 위해
            }
        }
        
        return (same_count == 0 && diff_count == 0) ? answer : answer + 1 ;
    }
}