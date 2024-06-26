import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        
       int answer = 1;
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i=0; i<clothes.length; i++){
            String key = clothes[i][1];
            
            //의상의 종류를 가지고 map에 추가
            if(!map.containsKey(key)) { 
                map.put(key, 1);
            } else {
                map.put(key, map.get(key) + 1);
            }
        }
        
        Iterator<Integer> it = map.values().iterator();
        
        while(it.hasNext()) { //경우의 수를 계산
            answer *= it.next().intValue()+1;
        }
        
        return answer-1;
    }
}