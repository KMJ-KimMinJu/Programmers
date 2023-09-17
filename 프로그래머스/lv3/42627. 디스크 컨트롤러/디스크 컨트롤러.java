import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
               
        int sum = 0; 
        int now = 0; //한 작업이 끝난 직후의 시간
        int end = 0; //끝난 작업 개수
        int index = 0;
        
        //이후로는 작업시간이 짧은 순서대로 하되, 작업시간이 같을 경우 요청 시간이 빠른 순서대로 함
        PriorityQueue<int[]> time= new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) {
                    return Integer.compare(o1[1], o2[1]);
                }

                return Integer.compare(o1[1], o2[1]);
            }
        });

        //모든 작업이 다 끝날 때까지
        while(end < jobs.length){
            
            while(index < jobs.length && jobs[index][0]<= now){
                time.add(jobs[index++]);
            }
            
            if(time.size() == 0){ //작업이 요청이 없는 상태라면 처음 요청 상태를 넣어줌
                now = jobs[index][0];
            }else{ 
                
                int[] temp = time.poll();
                sum += temp[1] + now-temp[0]; //소요시간 + 대기시간
                now += temp[1]; //소요시간만큼 작업이 진행된 시간을 처리
                end++;
            }
        }
        
        int answer = (int)Math.floor(sum/jobs.length);

        
        return answer;
    }
    
}