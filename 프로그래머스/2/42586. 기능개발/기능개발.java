import java.util.*;

class Solution {
    public Integer[] solution(int[] progresses, int[] speeds) {
        
        //우선 남은 퍼센트를 구해서 일수를 차례대로 넣어줌. QUEUE에 넣어줄 것임
        //그래서 기준이 되는 수를 하나 뽑아놓고, 그 뒤로 하나씩 빼주면서 일수를 더해서 기준이 되는 수 보다 작을 때까지 빼기
        
        Queue<Integer> days = new LinkedList<>();
        
        for(int i = 0; i<progresses.length; i++){
            int percent = 100-progresses[i];
            
            int day = (int)Math.ceil(1.0*percent/speeds[i]);
            days.offer(day);
        }

        ArrayList<Integer> answer = new ArrayList<>();      
        
        while(!days.isEmpty()){
            int temp = days.poll();
 
            int sum = 0;
            int count = 1;
            
            while(true){
                
                if(days.isEmpty()){
                    break;
                }

                if(days.peek() > temp){
                    break;
                }
                
                days.poll();
                count++;
            }
            
            answer.add(count);
        }
        
        Integer arr[] = answer.toArray(new Integer[answer.size()]);
        
        return arr;
    }
}