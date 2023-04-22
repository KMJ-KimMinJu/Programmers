import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public Integer[] solution(int num, int total) {

        
        if(num == 1){
            Integer[] arr = {total};
            return arr;
        }
        
        
        if(total == 0){
            ArrayList<Integer> arr = new ArrayList<>();
            num = num/2;
            
            for(int i = 0; i>=-num; i--){
                arr.add(i);
            }
            
            for(int i = 1; i<= num; i++){
                arr.add(i);
            }
            
            Integer[] answer = arr.toArray(new Integer[arr.size()]);
            Arrays.sort(answer);
            return answer;
            
        }
        
        
        
        int sum = 0;
        ArrayList<Integer> arr = new ArrayList<>();
        int count = total;
     
        for(int j = count; j>-1000; j--){
            for(int i = j; i>j-num; i--){
                sum += i;
                arr.add(i);
            }
            
            if(sum == total){
                break;
            }else{
                arr.clear();
                sum = 0;
            }
        }
        
        Integer[] answer = arr.toArray(new Integer[arr.size()]);
        Arrays.sort(answer);
        return answer;
    }
}