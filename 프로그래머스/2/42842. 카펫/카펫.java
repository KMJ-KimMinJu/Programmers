import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        
        int[] answer = new int[2];
        int total = brown + yellow;
        
        for(int i = total; i >= total / i; i--){
            if( total % i == 0){
                int big = i;
                int small = total / i;
                if( (big-2) * (small-2) == yellow) return new int[]{big,small};
            }
    }

        return answer;
    }
}