import java.util.Arrays;

class Solution {
    public int solution(String my_string) {
        String res = "";
        
        //문자를 하나씩 자른 후 정규표현식을 사용해서 알파벳인지 아닌지 판별함
        for(int i = 0; i<my_string.length(); i++){
            if(!(my_string.substring(i,i+1).matches("^[a-zA-Z]*$")))
                res += my_string.substring(i,i+1) + " ";            //알파벳이 아닐 때 하나씩 문자열에 추가
        }
        
        String[] answer_s = res.split(" ");
 
        int sum = 0;
        
        //문자로 바꿔준 후
        for(int i = 0; i<answer_s.length; i++){
        
            sum += Integer.parseInt(answer_s[i]);
        }
        
        
        return sum;
    }
}