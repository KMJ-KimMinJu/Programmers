import java.util.*;

class Solution {
    
    static int answer;
    
    public int solution(int[] numbers, int target) {
        
        DFS(0, 0, numbers, target);
        
        return answer;
    }
    
    static void DFS(int sum, int index, int[] numbers, int target) {
        
        if(index == numbers.length){
            if(target == sum){
                answer++;
                return;
            }else{
                return;
            }
        }
        
        
        DFS(sum + numbers[index], index+1, numbers, target);
        DFS(sum - numbers[index], index+1, numbers, target);
    }
    

}