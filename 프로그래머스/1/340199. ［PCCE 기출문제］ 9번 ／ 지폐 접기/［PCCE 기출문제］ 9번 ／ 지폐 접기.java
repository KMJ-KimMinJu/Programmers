import java.util.*;

class Solution {
    public int solution(int[] wallet, int[] bill) {
        
        int answer = 0;
        int wallet_min = min(wallet);
        int wallet_max = max(wallet);
        
        while(true){
            int bill_min = min(bill);
            int bill_max = max(bill);
            
            //접은 지폐가 지갑의 크기보다 작을 경우
            if(bill_min <= wallet_min && bill_max <= wallet_max)
                break;
            
            //90도 돌렸을 때 지갑에 들어가는 경우
            if(bill_min <= wallet_max && bill_max <= wallet_min)
                break;
            
            if(bill[0] > bill[1]){
                bill[0] = bill[0]/2;
            }else{
                bill[1] = bill[1]/2;
            }
            
            answer++;
        }
        
        return answer;
    }
    
    public int min(int[] temp){
        return Math.min(temp[0], temp[1]);
    }
    
    public int max(int[] temp){
        return Math.max(temp[0], temp[1]);
    }
}