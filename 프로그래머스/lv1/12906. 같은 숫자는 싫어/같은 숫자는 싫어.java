import java.util.*;

public class Solution {
    public Integer[] solution(int []arr) {
        
        Stack<Integer> stackInt = new Stack<>();
        
        stackInt.add(arr[0]); //첫 번째 값 추가
        
        for(int i = 1; i<arr.length; i++){
            
            //제일 최근에 넣은 값을 확인해서 연속된 값인지 아닌지 확인
            if(stackInt.peek() == arr[i]){ 
                continue;
            }else{
                stackInt.add(arr[i]);
            }
        }
        
       Integer[] answer = new Integer[stackInt .size()];
        answer = stackInt.toArray(answer);
        
        return answer;
    }
}