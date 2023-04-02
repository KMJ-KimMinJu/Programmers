import java.util.Arrays;

class Solution {
    public String solution(String my_string) {
        my_string = my_string.toLowerCase();
        
        char[] str = my_string.toCharArray();
        Arrays.sort(str);
        
        String answer = "";
        
        for(int i = 0; i<str.length; i++){
            answer += String.valueOf(str[i]);
        }
        
        return answer;
    }
}