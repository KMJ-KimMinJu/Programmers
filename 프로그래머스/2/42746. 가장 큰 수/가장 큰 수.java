import java.util.*;

class Solution {

    public String solution(int[] numbers) {
        
        String[] num_str = new String[numbers.length];
        
        //숫자를 string으로 변환
        for(int i=0; i<numbers.length; i++){
            num_str[i] = String.valueOf(numbers[i]);
        }
        
        //문자열로 따졌을 때 "610"이 큰지 "106"이 큰지 확인 후에 더 큰 걸로 정렬
        Arrays.sort(num_str, new Comparator<String>(){
            
            @Override
            public int compare(String o1, String o2){
      
                String sum = o1 + o2;
                String reverseSum = o2 + o1;
                
                return reverseSum.compareTo(sum);
            }
        });
        
        if(num_str[0].equals("0")) return "0";
        
        StringBuffer sb = new StringBuffer();
        
        for(int i = 0; i<num_str.length; i++){
            sb.append(num_str[i]);
        }
        
        return sb.toString();
    }
}
