import java.util.*;

class Solution {

    public String solution(int[] numbers) {
        
        String[] num_str = new String[numbers.length];
        
        for(int i=0; i<numbers.length; i++){
            num_str[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(num_str, new Comparator<String>(){
            
            @Override
            public int compare(String o1, String o2){
                if(o1.length() == o2.length()){
                    return o2.compareTo(o1);
                }
                
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
