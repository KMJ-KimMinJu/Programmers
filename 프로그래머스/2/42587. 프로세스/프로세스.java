import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        
        //빼야 할 순서를 알기 위해 우선순위 큐 생성
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i : priorities){
            pq.offer(i);
        }
        
        Queue<Integer[]> queue = new LinkedList<>();
        
        //큐에 실행 프로세스 삽입
        for(int i = 0; i < priorities.length; i++){
            queue.offer(new Integer[] {priorities[i], i});
        }
        
        int count = 0; //몇 번째로 실행되는지 저장하는 변수
        
        while(true){
            Integer[] temp = queue.poll();
            Integer priority = pq.peek();
            
            if(temp[0] == priority){ //실행 프로세스와 우선순위가 맞다면
                pq.poll();
                count++;
                
                if(temp[1] == location){ //알고싶은 인덱스 번호도 맞다면
                    break;
                }
            }else{ //아니라면
                queue.offer(temp);
            }
            
        }
        
        return count;
    }
}