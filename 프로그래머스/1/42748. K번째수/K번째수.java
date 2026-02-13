import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        
        int[] answer = new int[commands.length]; //정답 배열
        
        
        for(int i = 0; i < commands.length; i++){
            int[] temp = commands[i];
            
            answer[i] = sliceArray(array, temp);
        }
        
        return answer;
    }
    
    public static int sliceArray(int[] array, int[] temp){
        
        int i = temp[0]-1;
        int j = temp[1]-1;
        int k = temp[2]-1;
        
        int[] slice = new int[j-i+1];
        
        for(int index = 0; index < slice.length; index++){
            
            slice[index] = array[i++];
            
            if(j < i){
                break;
            }
        }
        
        Arrays.sort(slice);
        
        return slice[k];
    }
    
}