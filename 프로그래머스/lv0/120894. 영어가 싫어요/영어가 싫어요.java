import java.util.Arrays;

class Solution {
    public long solution(String numbers) {
        String num = "";
        String number = "";
        String[] s_num = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        String[] i_num = {"0","1","2","3","4","5","6","7","8","9"};
        
        for(int i = 0; i<numbers.length(); i++){
            num += String.valueOf(numbers.charAt(i));
            
            if(Arrays.asList(s_num).contains(num)){
                number += i_num[Arrays.asList(s_num).indexOf(num)];
                num = "";
            }
        }
        
        return Long.parseLong(number);
    }
}