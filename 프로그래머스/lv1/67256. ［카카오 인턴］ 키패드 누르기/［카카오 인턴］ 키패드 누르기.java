import java.util.*;

class Solution {
    public String solution(int[] numbers, String hand) {
        
        //147은 무조건 왼
        //369는 무조건 오
        
        StringBuffer result = new StringBuffer();
        
        int left = 10; //왼손 위치
        int right = 12; //오른손 위치
        int num = 0; //숫자의 거리 파악 위함
        
        for(int i= 0; i<numbers.length; i++){
            
            if(numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7){
                result.append("L");
                left = numbers[i];

            }else if(numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9){
                result.append("R");
                right = numbers[i];

            }else {
                
                if(numbers[i] == 0){
                    numbers[i]  += 11;
                }
                
                //숫자로부터 왼손과 오른손의 거리
                int l_hand = (Math.abs(numbers[i]-left))/3 + (Math.abs(numbers[i]-left))%3; 
                int r_hand = (Math.abs(numbers[i]-right))/3 + (Math.abs(numbers[i]-right))%3;
                
                if(l_hand == r_hand){
                    if(hand.equals("right")){
                        result.append("R");
                        right = numbers[i];
                    }else{
                        result.append("L");
                        left = numbers[i];
                    }
                }else if(l_hand > r_hand){
                        result.append("R");
                        right = numbers[i];
                }else{
                        result.append("L");
                        left = numbers[i];
                    }
            }
        }
        
        return result.toString();
    }
}