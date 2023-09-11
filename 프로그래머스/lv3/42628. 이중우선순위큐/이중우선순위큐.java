import java.util.*;

class Solution {
    
    public int[] solution(String[] operations) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(); //최솟값
        PriorityQueue<Integer> maxpq = new PriorityQueue<>(Collections.reverseOrder()); //최댓값
        
        for(int i = 0; i<operations.length; i++){
            
            String[] temp= operations[i].split(" ");
            
            if(temp[0].equals("I")){ //숫자 삽입
                pq.offer(Integer.parseInt(temp[1]));
                maxpq.offer(Integer.parseInt(temp[1]));
                
            }else if(temp[0].equals("D")){
                if(temp[1].equals("1")){ //최댓값 삭제
                    if(pq.size() == 0){
                        continue;
                    }
                    
                    int max = maxpq.poll();//최댓값 삭제
                    pq.remove(max);
                    
                }else{ //최솟값 삭제
                    if(pq.size() == 0){
                        continue;
                    }
                    
                    int min = pq.poll(); //최솟값 삭제
                    maxpq.remove(min); //같이 추가했기 때문에 같이 삭제

                }
            }
        }
        
        int[] answer = new int[2];
        
        if(pq.size()>0){
            answer[0] = maxpq.poll();
            answer[1] = pq.poll();
        }
        
        return answer;
    }
}