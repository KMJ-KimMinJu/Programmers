import java.util.*;

class Solution {
    public String solution(String s) {
        
        String[] str = s.split(" ");
        
        int[] number = new int[str.length];
        
        for(int i = 0; i<str.length; i++){
            number[i] = Integer.parseInt(str[i]);
        }
        
        Arrays.sort(number);
        String[] answer = {String.valueOf(number[0]), String.valueOf(number[number.length-1])};
        String str_answer = String.join(" ", answer);
        
        return str_answer;
    }
}