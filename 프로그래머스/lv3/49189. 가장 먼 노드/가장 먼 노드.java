import java.util.*;

class Solution {
    
    public static int[] answer; //방문 횟수 배열
    public static boolean[] visited; //방문 확인 배열
    public static ArrayList<Integer>[] node;
    
    public int solution(int n, int[][] edge) {
        
        answer = new int[edge.length+1];
        visited = new boolean[edge.length+1];
        
        node = new ArrayList[edge.length+1];
        
        for(int i = 1; i<= edge.length; i++){
            node[i] = new ArrayList<>();
        }
        
        //양방향이기 때문
        for(int i = 0; i< edge.length; i++){
            node[edge[i][0]].add(edge[i][1]);
            node[edge[i][1]].add(edge[i][0]);
        }
      
        BFS(1);
        
        int max = Arrays.stream(answer).max().getAsInt();
        System.out.println(max);
        int count = 0;
        
        for(int i = 1; i<= edge.length; i++){
            if(answer[i] == max){
                count++;
            }   
        }
        
        return count;
    }
    
    public static void BFS(int X){
        
        Queue<Integer> queue = new LinkedList<>();
        queue.add(X);
        
        visited[X]= true;
        
        while(queue.size() != 0){
            int now = queue.poll();
            
            for(int i : node[now]){
                
                if(!visited[i]){
                    System.out.println("i"+i);
                    visited[i] = true;
                    queue.add(i);
                    answer[i] = answer[now]+1;
                }
            }
        }

    }
}