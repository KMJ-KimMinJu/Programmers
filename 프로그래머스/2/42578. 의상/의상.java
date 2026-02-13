import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        
        HashMap<String, Integer> fashion = new HashMap<>();
        
        for(int i = 0; i < clothes.length; i++){
            String[] temp = clothes[i];
            
            if(fashion.containsKey(temp[1])){
                fashion.put(temp[1], fashion.get(temp[1])+1);
            }else{
                fashion.put(temp[1], 1);
            }
            
        }
        
        int answer = 1;
        
        for(Integer i : fashion.values()){
            
            answer *= i+1; 
        }
        
        return answer-1;
        
    }
}