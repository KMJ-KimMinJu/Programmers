import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        
        PriorityQueue<Integer> hot = new PriorityQueue<>();

        for(int i =0; i< scoville.length; i++){
            hot.add(scoville[i]);
        }
        
        boolean sco_check = false;
        int count = 0;
        
        while(hot.peek() < K){
            
            if(hot.size() == 1){
                sco_check = true;
                break; //반복문이 실행됐는데 큐의 사이즈가 1이라면 -1을 리턴
            }
            
            int made_hot = hot.poll()+(hot.poll()*2);
            
            hot.add(made_hot);
            count++;
        }
        
        if(sco_check){
            return -1;
        }else{
            return count;
        }
    }
}