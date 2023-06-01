import java.util.*;
class Solution {
    public Integer[] solution(int[] numbers) {
        
        Set<Integer> num = new HashSet<>();
        
        Arrays.sort(numbers);
        
        for(int i= 0; i<numbers.length; i++){
            for(int j = i+1; j<numbers.length; j++){
                num.add(numbers[i]+numbers[j]);
            }
        }
        
        Integer[] arr = num.toArray(new Integer[0]);
        
        Arrays.sort(arr);
        return arr;
    }
}