import java.util.*;

class Solution {
    public Integer[] solution(int[] numbers) {
        
        HashSet<Integer> sum = new HashSet<>(); //sum 결과 저장(중복 제거용)
        
        for(int i = 0; i < numbers.length-1; i++){
            for(int j = i+1; j < numbers.length; j++){
                
                sum.add(numbers[i] + numbers[j]);
            }
        }
        
        Integer[] answer = sum.toArray(new Integer[0]); //set을 array로 변환
        Arrays.sort(answer);
        
        return answer; 
    }
}