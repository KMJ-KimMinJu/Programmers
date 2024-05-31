import java.util.*;

class Solution {
    
    static int[] dx = {0,1,0,-1}; //우, 하, 좌, 상
    static int[] dy = {1,0,-1,0};
    static boolean visited[][];
    static int N,M;
    
    public int solution(int[][] maps) {
        
        N = maps.length;
        M = maps[0].length; 
        visited = new boolean[N][M];

        BFS(0,0, maps);
        
        if(visited[N-1][M-1] == false){
            return -1;
        }else{
            return maps[N-1][M-1];
        }
    }
    
    static void BFS(int x, int y, int[][] maps){
        
        Queue<int[]> queue = new LinkedList<>();
        
        queue.add(new int[] {x,y});
        
        visited[x][y] = true;
        
        while(queue.size() != 0){
            int node[] = queue.poll();
          
            for(int i = 0; i<4; i++){
                int index_x = node[0]+dx[i];
                int index_y = node[1]+dy[i];
                
                //상하좌우 인덱스 번호가 maps 크기보다 작고, 0보다 커야함
                if(index_x>=0 && index_y>=0&&index_x<N&&index_y<M){
                    //0이 아니면서 방문한 적이 없어야 함
                    if(maps[index_x][index_y] != 0 && visited[index_x][index_y] == false){
                        visited[index_x][index_y] = true;
                        maps[index_x][index_y] = maps[node[0]][node[1]]+1; //여태껏 움직인 칸을 누적해서 구해줌
                        queue.add(new int[]{index_x, index_y});
                    }
                }
            }
        }
    }
}