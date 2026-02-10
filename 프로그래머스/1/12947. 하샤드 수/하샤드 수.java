import java.util.*;

class Solution {
    public boolean solution(int x) {
    
        String x_str = x+"";
        
        int sum = 0;
        
        for(int i = 0; i < x_str.length(); i++){
            sum += (x_str.charAt(i)-'0');
        }
        
        boolean check = (x % sum == 0) ? true : false;
        
        return check;
    }
}
