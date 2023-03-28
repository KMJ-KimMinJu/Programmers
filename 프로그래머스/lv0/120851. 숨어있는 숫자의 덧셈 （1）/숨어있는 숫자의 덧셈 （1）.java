import java.util.Arrays;

class Solution {
    public int solution(String my_string) {
        String res = "";
        
        for(int i = 0; i<my_string.length(); i++){
            if(!(my_string.substring(i,i+1).matches("^[a-zA-Z]*$")))
                res += my_string.substring(i,i+1) + " ";
        }
        
        String[] answer_s = res.split(" ");
        
        int [] answer_i = new int[answer_s.length];
        int sum = 0;
        for(int i = 0; i<answer_i.length; i++){
            answer_i[i] = Integer.parseInt(answer_s[i]);
            sum += answer_i[i];
        }
        
        
        return sum;
    }
}