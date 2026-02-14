import java.util.*;

class Solution {

    public String solution(int[] numbers) {
        
        String[] number = new String[numbers.length];
        
        for(int i = 0; i < numbers.length; i++){ // 숫자를 문자열로 변환
            number[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(number, new Comparator<String>(){
            
            @Override
            public int compare(String a, String b){
                String sum1 = a+b;
                String sum2 = b+a;
                
                return sum2.compareTo(sum1);
            }
        });     
        
        String answer = (number[0].equals("0")) ? "0" : String.join("", number);
        
        return answer;
    }
}
