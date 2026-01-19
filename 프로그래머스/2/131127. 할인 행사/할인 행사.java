import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        
        int first_index = 0;
        int last_index = first_index + 9;
        
        int answer = 0;
        
        HashMap<String, Integer> want_sale = new HashMap<>();
        
        for(int i = 0; i < want.length; i++){
            want_sale.put(want[i], number[i]);
        }
        
        while(discount.length > last_index){
            
            for(int i = first_index; i <= last_index; i++){
                
                //포함 안 된 항목이 있다면 패스
                if(!want_sale.containsKey(discount[i])){
                    continue;
                }
                
                //포함된다면
                want_sale.put(discount[i], want_sale.get(discount[i])-1);
            }
            
            //for문이 다 돌았을 때 확인
            boolean zero = want_sale.values()
                     .stream()
                     .allMatch(v -> v == 0);
            
            if(zero) {
                answer++;
            }else{

                    for(int i = 0; i < want.length; i++){
                        want_sale.put(want[i], number[i]);
                    }

                    first_index++;
                    last_index++;
            }
        }
        
        return answer;
    }
}