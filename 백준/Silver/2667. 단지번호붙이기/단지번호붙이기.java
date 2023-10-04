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
    static int N, count;
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken()); //테스트 케이스

            node = new int[N][N];
            visited = new boolean[N][N];

            answer = 0;

            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(bf.readLine());
                String[] temp = st.nextToken().split("");
                for(int i = 0; i<N; i++){
                    node[j][i] = Integer.parseInt(temp[i]);
                }
            }
            ArrayList<Integer> house = new ArrayList<>();

            for(int j = 0; j<N; j++){
                for(int k = 0;k<N; k++){
                    if (node[j][k] == 1 && visited[j][k] == false){
                        BFS(j, k);
                        answer++;
                        house.add(count);

                        count = 0;
                    }
                }
            }

            System.out.println(answer);
            Collections.sort(house);

            for(int a : house){
                System.out.println(a);
            }
    }

    public static void BFS(int x, int y) {

        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[] {x, y});
        visited[x][y] = true;

        while(queue.size() != 0){
            int now[] = queue.poll();
            count++;

            for(int i = 0; i<4; i++){
                int x_index = now[0]+dx[i];
                int y_index = now[1]+dy[i];

                if(x_index >= 0 && y_index>= 0 && x_index<N && y_index<N){
                    if(node[x_index][y_index] == 1 && visited[x_index][y_index] == false){
                        visited[x_index][y_index] = true;
                        queue.add(new int[]{x_index,y_index});
                    }
                }
            }
        }
    }

}