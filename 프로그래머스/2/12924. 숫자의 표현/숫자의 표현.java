import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        
        //1부터 n까지
        for(int i = 1; i<= n; i++){
            
            int temp = 0;
            int j = i;
            
            //연속된 숫자 중 더했을 때 n이 되는 경우가 있는지 확인
            while(temp <= n){
                temp += j;
                j++;
                
                if(temp == n){
                    answer++;
                }
            }
        }
        
        return answer;
    }
}