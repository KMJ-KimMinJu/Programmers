import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};

    public static boolean visited[][];
    public static int[][] bfs;

    static int N,M;
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken()); //정점개수
        M = Integer.parseInt(st.nextToken()); //간선개수

        bfs = new int[N][M];
        visited = new boolean[N][M]; //방문 여부 확인

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            String[] temp = st.nextToken().split("");
            for(int j = 0; j<M; j++){
                bfs[i][j]= Integer.parseInt(temp[j]);
            }
        }
        BFS(0,0); //시작지점은 0,0
        System.out.println(bfs[N-1][M-1]);
    }

    static void BFS(int x, int y){

        Queue<int[]> que = new LinkedList<>();

        que.add(new int[] {x,y});

        visited[x][y] = true;

        while(que.size() != 0) {
    
            int node[] = que.poll();

            for(int k=0; k<4; k++){ //해당 인덱스에서 상하좌우 보기
                int x_index = node[0]+dx[k]; //상하좌우 x인덱스 확인
                int y_index = node[1]+dy[k]; //상하좌우 y인덱스 확인

                //상하좌우 확인했을 때 인덱스 번호가 미로의 크기보다 작고, 0보다 커야함.
                if(x_index>=0 && y_index>=0&&x_index<N&&y_index<M){
                    //칸이 0이 아니면서 방문한 적 없는지 확인
                    if(bfs[x_index][y_index]!=0 && visited[x_index][y_index] == false){
                        visited[x_index][y_index] = true;
                        bfs[x_index][y_index] = bfs[node[0]][node[1]]+1;
                        que.add(new int[]{x_index, y_index});
                    }
                }
            }
        }
    }
}