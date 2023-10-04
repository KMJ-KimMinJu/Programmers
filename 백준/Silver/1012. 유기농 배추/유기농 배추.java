import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {

    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    public static int answer;
    public static boolean[][] visited; //방문 확인 배열
    public static int[][] node;
    static int M, N;
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int T = Integer.parseInt(st.nextToken()); //테스트 케이스

        for(int i = 1; i<= T; i++) {

            st = new StringTokenizer(bf.readLine());

            M = Integer.parseInt(st.nextToken()); //가로
            N = Integer.parseInt(st.nextToken()); //세로
            int K = Integer.parseInt(st.nextToken()); //배추 개수

            node = new int[M][N];
            visited = new boolean[M][N];

            answer = 0;

            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(bf.readLine());

                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                node[x][y] = 1;
            }


            for(int j = 0; j<M; j++){
                for(int k = 0;k<N; k++){
                    if (node[j][k] == 1 && visited[j][k] == false){
                        BFS(j, k);
                        answer++;
                    }
                }
            }

            System.out.println(answer);
        }
    }

    public static void BFS(int x, int y) {

        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[] {x, y});
        visited[x][y] = true;

        while(queue.size() != 0){
            int now[] = queue.poll();

            for(int i = 0; i<4; i++){
                int x_index = now[0]+dx[i];
                int y_index = now[1]+dy[i];

                if(x_index >= 0 && y_index>= 0 && x_index<M && y_index<N){
                    if(node[x_index][y_index] == 1 && visited[x_index][y_index] == false){
                        visited[x_index][y_index] = true;
                        queue.add(new int[]{x_index,y_index});
                    }
                }
            }
        }
    }

}