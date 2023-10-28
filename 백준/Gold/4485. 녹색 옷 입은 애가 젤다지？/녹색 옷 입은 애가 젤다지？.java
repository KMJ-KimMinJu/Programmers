
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
    static int[][] distance;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int index = 0;

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());

            if(N == 0){
                break;
            }

            bfs = new int[N+1][N+1];
            distance = new int[N+1][N+1];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                Arrays.fill(distance[i], Integer.MAX_VALUE);

                for (int j = 0; j < N; j++) {
                    bfs[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            index++;

            int answer = (bfs()+bfs[N-1][N-1]);
            System.out.println("Problem "+ index+": "+answer);

        }
    }

    static int bfs(){
        PriorityQueue<Node> q = new PriorityQueue<Node>((o1, o2) -> Integer.compare(o1.cnt, o2.cnt));
        q.offer(new Node(0, 0,0));
        distance[0][0] = 0;

        while(!q.isEmpty()){
            Node node = q.poll();
            int x_index, y_index;

            if(node.x == N-1 && node.y == N-1){
                return node.cnt;
            }

            for(int k=0; k<4; k++){ //해당 인덱스에서 상하좌우 보기
                x_index = node.x+dx[k]; //상하좌우 x인덱스 확인
                y_index = node.y+dy[k]; //상하좌우 y인덱스 확인

                if(x_index>=0 && y_index>=0&&x_index<N&&y_index<N) {

                    if (distance[x_index][y_index] > bfs[node.x][node.y]+node.cnt){
                            distance[x_index][y_index] = bfs[node.x][node.y]+node.cnt;
                            q.offer(new Node(x_index, y_index, distance[x_index][y_index]));
                    }
                }
            }
        }
        return 0;
    }
}