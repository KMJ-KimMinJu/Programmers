import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        
        int[] answer = new int[targets.length];
        
        // for(int i = 0; i<answer.length; i++){
        //     answer[i] = -1;
        // }
        
        
        for(int i =0; i<targets.length; i++){
            String target = targets[i];
            int count = 0;

            for(int j = 0; j<target.length(); j++){
            
                String str = String.valueOf(target.charAt(j));
                
                int min = Integer.MAX_VALUE; //int 타입 최대값

                for (String x : keymap) {
                    int idx = x.indexOf(str);
                    if (idx != -1) {
                        min = Math.min(min, idx + 1);
                    }
                }
                
                if(min == Integer.MAX_VALUE){ //수가 없다는 뜻
                    count = -1;
                    break;
                }
                count += min;
            }
            answer[i] = count;
        }
        
        return answer;
    }
}