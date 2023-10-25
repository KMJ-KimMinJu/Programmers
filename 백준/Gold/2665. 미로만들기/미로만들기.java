import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int[][] distances;
    static boolean[][] visited;
    public static int[][] bfs;
    static int N;
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken()); //정점개수

        bfs = new int[N][N];
        distances = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            String[] temp = st.nextToken().split("");
            for(int j = 0; j<N; j++){
                bfs[i][j]= Integer.parseInt(temp[j]);
                distances[i][j] = Integer.MAX_VALUE;
            }
        }
        System.out.println(BFS(0,0)); //시작지점은 0,0
    }

    static int BFS(int x, int y){

        Queue<int[]> que = new LinkedList<>();
        que.add(new int[] {x,y});
        distances[0][0] = 0;
        visited[0][0] = true;

        while(que.size() != 0) {

            int node[] = que.poll();

            for(int k=0; k<4; k++){ //해당 인덱스에서 상하좌우 보기
                int x_index = node[0]+dx[k]; //상하좌우 x인덱스 확인
                int y_index = node[1]+dy[k]; //상하좌우 y인덱스 확인

                if(x_index>=0 && y_index>=0&&x_index<N&&y_index<N) {

                    if (distances[x_index][y_index] > distances[node[0]][node[1]]){

                        if(bfs[x_index][y_index] == 1){
                            distances[x_index][y_index] = distances[node[0]][node[1]];
                            que.offer(new int[]{x_index, y_index});
                            visited[x_index][y_index] = true;
                        }else{
                            distances[x_index][y_index] = distances[node[0]][node[1]]+1;
                            que.offer(new int[]{x_index, y_index});
                            visited[x_index][y_index] = true;
                        }

                    }
                }
            }
        }

        return distances[N - 1][N - 1];
    }
}