import java.util.Arrays;

class Solution {
    public String solution(String s) {
        
        String answer = "";
        
        for(int i = 0; i<s.length(); i++){
            String a = String.valueOf(s.charAt(i));
            String str = s.replace(a, "");
            
            if(s.length() - str.length() == 1){
                answer += a;
            }
        }
        
        String[] sort_str = answer.split("");
        
        Arrays.sort(sort_str);
        
        
        return String.join("", sort_str);
    }
}