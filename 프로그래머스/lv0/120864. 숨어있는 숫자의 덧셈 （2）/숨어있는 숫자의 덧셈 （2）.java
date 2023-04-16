import java.util.regex.Pattern;

class Solution {
    public int solution(String my_string) {
        
        String[] my_str = my_string.split("");
        String number = "0";
        int str=0;
        
        for(int i= 0; i<my_str.length; i++){
            String first = my_str[i];
            if(Pattern.matches("^[a-zA-Z]*$", first)){
                str += Integer.parseInt(number);
                number = "0";
            }else{
                number += first;
            }
        }
        
        str += Integer.parseInt(number);
        
        return str;
        
        
    }
}