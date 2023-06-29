import java.util.*;
class Solution {
    public int solution(int[] ingredient) {
        
        int[] perfect = {1,2,3,1};

        int answer = 0;
        Stack<Integer> stack = new Stack<>(); //int형 스택 선언
        
        for(int i = 0; i<ingredient.length; i++){
            stack.push(ingredient[i]);
            
            if(stack.size() >= 4){
                if(stack.get(stack.size()-4) == 1 && stack.get(stack.size()-3) == 2 &&stack.get(stack.size()-2) == 3 && stack.get(stack.size()-1) == 1){
                    answer++;
                    
                    
                    stack.pop();stack.pop();stack.pop();stack.pop();
                }
            }
        }
        return answer;
    }
    
    
}