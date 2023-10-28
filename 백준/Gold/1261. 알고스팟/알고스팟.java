
import java.io.*;
import java.util.*;

public class Main
{
    static int N, M;
    static class Node{
        int x, y, cnt;
        Node(int x, int y, int cnt){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }

    }
    static int[][] bfs;
    static boolean[][] visited;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        bfs = new int[M][N];
        visited = new boolean[M][N];

        for(int i = 0; i < M; i++){
            String[] s = br.readLine().split("");
            for(int j = 0; j < N; j++){
                bfs[i][j] = Integer.parseInt(s[j]);
            }
        }

        System.out.println(bfs());
    }

    static int bfs(){
        PriorityQueue<Node> q = new PriorityQueue<Node>((o1, o2) -> Integer.compare(o1.cnt, o2.cnt));
        q.offer(new Node(0, 0, 0));
        visited[0][0] = true;

        while(!q.isEmpty()){
            Node node = q.poll();
            int x_index, y_index;

            if(node.x == M-1 && node.y == N-1){
                return node.cnt;
            }

            for(int i = 0; i < 4; i++){
                x_index = node.x + dx[i];
                y_index = node.y + dy[i];
                if(x_index >= 0 && y_index >= 0 && x_index < M && y_index < N){
                    if(!visited[x_index][y_index] && bfs[x_index][y_index] == 1){
                        visited[x_index][y_index] = true;
                        q.offer(new Node(x_index, y_index, node.cnt+1));
                    }else if(!visited[x_index][y_index] && bfs[x_index][y_index] == 0){
                        visited[x_index][y_index] = true;
                        q.offer(new Node(x_index, y_index, node.cnt));
                    }
                }
            }
        }
        return 0;
    }
}
