import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        int i = 0;
        
        while(i<commands.length){
            int[] copy = new int[commands[i][1]-commands[i][0]+1];
            int k = 0;
            
            for(int j = commands[i][0]-1; j<commands[i][1]; j++){
                copy[k] = array[j];
                k++;
            }
            
            Arrays.sort(copy);
            answer[i]= copy[commands[i][2]-1];
            
            i++;
        }
        
        
        return answer;
    }
}