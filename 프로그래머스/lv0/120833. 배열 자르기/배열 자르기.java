import java.util.Arrays;

class Solution {
    public int[] solution(int[] numbers, int num1, int num2) {
        int array[] = Arrays.copyOfRange(numbers, num1, num2+1);
                                         /*
        String str = "";
        
        for(int i = num1; i <= num2 ; i++){
                str += numbers[i] + ",";
        }
    
        String[] answer = str.split(",");
 
        int[] answer_arr = new int[answer.length];
    
        for(int i = 0; i < answer_arr.length; i++){
            answer_arr[i] = Integer.parseInt(answer[i]);
        }
    
        return answer_arr; */
                                         
        return array;
    }
}