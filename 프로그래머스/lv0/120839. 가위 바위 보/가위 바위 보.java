import java.util.HashMap;
import java.util.Map;

class Solution {
    public String solution(String rsp) {
        Map<String, String> di = new HashMap<>();
        String answer = "";
        
        di.put("2", "0");
        di.put("0", "5");
        di.put("5", "2");
        
     
        for(int i = 0 ; i<rsp.length(); i++){
            String a = rsp.substring(i, i+1);
            answer += di.get(a);
        }
  
        
        /*
        for(String key: di.getkey())
            answer += di.get(key);
        */
        
        return answer;
        
        
    }
}