import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
class Solution {
    public String solution(String[] participant, String[] completion) {
        

        
        // Arrays.sort(participant);
        // Arrays.sort(completion);
        
//         String com = String.join("", completion);
//         String answer = "";
        
//         for(int i = 0; i<participant.length; i++){
//             if(!com.contains(participant[i])){
//                 answer = participant[i];
//                 break;
//             }else{
//                 com = com.replace(participant[i], "");
//             }
//         }
        
        // Arrays.sort(participant);
        // Arrays.sort(completion);
        
//         ArrayList<String> part = new ArrayList<>(Arrays.asList(participant));
//         ArrayList<String> com = new ArrayList<>(Arrays.asList(completion));
//         String answer = "";
        
//         //이름에 중복이 없을 경우
//         for(String a: part){
//             if(com.indexOf(a) == -1)
//                 answer = a;
//         }
        
//         //이름에 중복이 있는 경우
//         if(answer.equals("")){
//             for(String a: com){
//                 if(part.indexOf(a) == -1 || (part.lastIndexOf(a) != part.indexOf(a)))
//                     answer = a;
//         }
//         }
        
//         return answer;
        
        // Arrays.sort(participant);
        // Arrays.sort(completion);
        
        String answer = "";
        
        Map<String, Integer> map = new HashMap<>();
        
         for(String part: participant) {            
            map.put(part, map.getOrDefault(part, 0)+1); //중복되지 않는 건 value로 1이 들어감 무조건.
        }
        
        for(String com : completion){
            map.put(com, map.get(com)-1);
        }
        
        for(String key: map.keySet()){
            if( !(map.get(key) < 1) ){
                answer = key;
                break;
            }
        }
       
        
        return answer;
        
    }
}