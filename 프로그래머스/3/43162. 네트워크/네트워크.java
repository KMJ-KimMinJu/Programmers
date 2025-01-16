import java.util.*;

class Solution {
    
    static boolean visited[];
    static int count = 0;
    
    public int solution(int n, int[][] computers) {
        
        visited = new boolean[n];
        
        for(int i = 0; i<n; i++){
            if(visited[i]){
                continue;
            }
            
            DFS(i,0, n, computers);
            count++;
        }
        
        
        return count ;
    }
    
    public static void DFS(int x, int y, int n, int[][] computers) {
        
        visited[x] = true;
        
        for(int i = y; i<n; i++){
            if(x == i){
                continue;
            }
            
            if(computers[x][i] == 1 && !visited[i]){
                DFS(i,0, n, computers);
            }
        }
    }
    
}