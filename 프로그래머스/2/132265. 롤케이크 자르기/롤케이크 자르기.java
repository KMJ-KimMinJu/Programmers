import java.util.*;

class Solution {
    
    public int solution(int[] topping) {
        
        int count = 0;
        
        Map<Integer, Integer> soo = new HashMap<>();
        Set<Integer> bro = new HashSet<>();
        
        //철수한테 모든 토핑을 몰아서 주기
        for(int i = 0; i < topping.length; i++){
            soo.put(topping[i], soo.getOrDefault(topping[i], 0) + 1);
        }
        
        //그리고 동생한테 토핑을 한 개씩 주며 공평하게 나누어졌는지 확인
        for(int i = 0; i < topping.length; i++){
            
            if(soo.get(topping[i]) == 1){
                soo.remove(topping[i]);
            }else{
                soo.put(topping[i], soo.get(topping[i])-1);
            }
            
            bro.add(topping[i]);
            
            if(soo.size() == bro.size()){
                count++;
            }
        }
        
        return count;
    }
}