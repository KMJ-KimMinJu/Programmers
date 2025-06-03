import java.util.*;

class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        
        int[] pos_arr = Arrays.stream(pos.split(":")).mapToInt(Integer::parseInt).toArray();
        int[] op_start_arr = Arrays.stream(op_start.split(":")).mapToInt(Integer::parseInt).toArray();
        int[] op_end_arr = Arrays.stream(op_end.split(":")).mapToInt(Integer::parseInt).toArray();
        int[] video_len_arr = Arrays.stream(video_len.split(":")).mapToInt(Integer::parseInt).toArray();
    
        //명령어를 시작하기 전 오프닝 구간에 있는지 확인
        if(op_check(pos_arr, op_start_arr, op_end_arr)){
            pos_arr[0] = op_end_arr[0];
            pos_arr[1] = op_end_arr[1];
        }
        
        for(int i = 0; i<commands.length; i++){
            
            switch (commands[i]){
            
                case "next":
                    
                    //남은 위치가 10초 미만인 경우
                    if((pos_arr[0] == video_len_arr[0]) &&( video_len_arr[1] - pos_arr[1] < 10)){
                        pos_arr[1] = video_len_arr[1];
                    }else{
                        
                        //10초 후로 넘어갔는데 분이 바뀐 경우
                        if(pos_arr[1] + 10 >= 60){
                            pos_arr[0]++;
                            
                            pos_arr[1] = (pos_arr[1] + 10) % 60;
                        }else{ //아닌 경우
                            pos_arr[1] += 10;
                        }
                        
                        //비디오의 최대 길이를 넘긴 경우
                        if(pos_arr[0] >= video_len_arr[0] && pos_arr[1] >= video_len_arr[1]){
                            pos_arr[0] = video_len_arr[0];
                            pos_arr[1] = video_len_arr[1];
                        }
                    }
                    
                    if(op_check(pos_arr, op_start_arr, op_end_arr)){
                        pos_arr[0] = op_end_arr[0];
                        pos_arr[1] = op_end_arr[1];
                    }
                    
                    break;
                    
                case "prev":
                    
                    //현재 시간이 10초 미만일 경우 
                    if((pos_arr[0] == 0) && (pos_arr[1] < 10)){
                        pos_arr[1] = 0;
                    } else{
                        //10초 전으로 돌아갔는데 분이 바뀌는 경우
                        
                        if(pos_arr[1] - 10 < 0){
                            pos_arr[0]--;
                            
                            pos_arr[1] = 60 - (10 - pos_arr[1]);
                            
                        }else{//분이 바뀌지 않는 경우
                            pos_arr[1] -= 10;
                        }
                        
                    }
                    
                    if(op_check(pos_arr, op_start_arr, op_end_arr)){
                        pos_arr[0] = op_end_arr[0];
                        pos_arr[1] = op_end_arr[1];
                    }
                    
                    break;
            }
        }
        
        
        String mm, ss;
        
        if(pos_arr[0] == 0){
            mm = "00";
        }else if(pos_arr[0] < 10){
            mm = "0" + pos_arr[0];
        }else{
            mm = "" + pos_arr[0];
        }
        
        if(pos_arr[1] == 0){
            ss = "00";
        }else if(pos_arr[1] < 10){
            ss = "0" + pos_arr[1];
        }else{
            ss = "" + pos_arr[1];
        }
        
        return mm+":"+ss;
    }
    
    //오프닝 시간 사이에 있는지 확인
    public boolean op_check(int pos[], int op_start[], int op_end[]){
        
        //초로 바꿔서 계산
        int op_start_time = op_start[0] * 60 + op_start[1];
        int op_end_time = op_end[0] * 60 + op_end[1];
        int pos_time = pos[0] * 60 + pos[1];
        
        if(op_start_time <= pos_time && op_end_time >= pos_time){
            return true;
        }else{
            return false;
        }
        
    }
}