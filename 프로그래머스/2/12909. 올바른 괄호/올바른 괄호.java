import java.util.*;

class Solution {
    boolean solution(String s) {
        Queue<String> queue = new LinkedList<>();
        
        if(s.startsWith(")") || s.endsWith("(")){
            return false;
        }
        
        String[] str = s.split("");
        
        for(int i = 0; i<str.length; i++){
            if(str[i].equals("(")){
                queue.offer(str[i]);
            }else{
                queue.poll();
            }
        }
        
        if(queue.size() != 0){
            return false;
        }else{
            return true;
        }
    }
}