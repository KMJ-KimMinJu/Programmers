import java.util.*;

class Solution {
    
    public static List<int[]> list = new ArrayList<>();
    
    public void hanoi(int n, int start, int p, int from){
         
        if(n == 0){
            return;
        }
        
            hanoi(n-1, start, from, p);
            list.add(new int[] {start, from});
            
            hanoi(n-1, p, start, from);
    }
    
    
    public int[][] solution(int n) {
        hanoi(n, 1, 2, 3);
        
        int[][] answer = new int[list.size()][2];
        

        int index = 0;
        for(int[] arr : list){
            answer[index][0] = arr[0];
            answer[index][1] = arr[1];
            index++;
        }
        
        
        return answer;
    }
}