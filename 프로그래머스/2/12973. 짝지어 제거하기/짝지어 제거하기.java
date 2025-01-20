import java.util.*;

class Solution
{
    public int solution(String s)
    {
        Stack<Character> stack = new Stack<>();
        
        for(Character a : s.toCharArray()){
            
            if(stack.size() != 0 && stack.peek() == a){
                stack.pop();
            }else{
                stack.push(a);
            }
        }
         
        return stack.size() == 0 ? 1 : 0;
    }
}