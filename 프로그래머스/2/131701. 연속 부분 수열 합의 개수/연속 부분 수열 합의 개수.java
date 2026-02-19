import java.util.*;

class Solution {
    public int solution(int[] elements) {
        
        int index = 1;
        HashSet<Integer> set = new HashSet<>();
        
        while(index <= elements.length){
            
            for(int i = 0; i < elements.length; i++){
                int sum = 0;
                
                for(int j = i; j < (i+index); j++){
                    sum += elements[j%elements.length];
                }
                
                set.add(sum);
            }
            
            index++;
        }
        
        return set.size();
    }
}