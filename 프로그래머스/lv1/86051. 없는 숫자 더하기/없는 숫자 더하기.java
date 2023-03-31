import java.util.Arrays;

class Solution {
    public int solution(int[] numbers) {
        int sum = 0;
        for(int i = 0; i<numbers.length; i++){
            sum += numbers[i];
        }
        
        if((45-sum) == 0){
                return 0;
        }else
            return (45-sum);
    }
}