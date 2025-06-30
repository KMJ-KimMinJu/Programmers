import java.util.*;

class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        
        int day = startday; //시작일
        
        int people = schedules.length; //총 인원
        
        int count = 0;
        
        for(int i = 0 ; i < people ; i++){
            
            //출근 희망 시간 계산
            int min = (schedules[i] + 10) % 100; 
            int plus_min = min / 60;
            min = min % 60;
            
            int hours = ((schedules[i] / 100) + plus_min) % 24;
            
            int start_time = hours * 100 + min; //출근 희망 시간
            
            if(late_check(start_time, day, timelogs[i])){
                count++;
            }
            
        }
        
        return count;
    }
    
    private boolean late_check(int start_time, int day, int[] timelog){
        
        boolean check = true; //지각 체크
        
        for(int time : timelog){
            
            if(!check){ // 지각을 한 번이라도 했다면 체크 종료
                break;
            }
            
            if(day > 5){ // 주말은 지각 체크 하지 않기
                
                if(day > 7){ // 일요일 다음 월요일로 넘어가도록
                    day = 1;
                }else{
                    day++;
                    continue;
                }
            }
        
            // 2. 지각인지 아닌지 확인
            
            
            if(start_time < time){
                check = false;
            }
            
            day++;
        }
        
        return check;
    }
}