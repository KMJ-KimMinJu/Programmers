import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); //유저 수
        int M = Integer.parseInt(st.nextToken()); //친구 관계 수

        int[][] dist = new int[N+1][N+1];

        for(int i = 1; i<= N; i++){
            for (int j = 1; j <= N; j++) {
                if (i == j) { //자기 자신
                    continue;
                }
                else {
                    dist[i][j] = 100000000;
                }
            }
        }

        for(int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            dist[a][b] = Math.min(dist[a][b], 1); //같은 경로에 대한 가중치가 들어올 수 있음
            dist[b][a] = Math.min(dist[b][a], 1); //양방향
        }

        for(int i = 1 ; i <= N ; i ++) {
            for(int j = 1 ; j <= N ; j ++) {
                for(int k = 1 ; k <= N ; k ++) {
                    if(dist[j][k] > dist[j][i] + dist[i][k]) {
                        dist[j][k] = dist[j][i] + dist[i][k]; //j에서 k까지의 최단경로는 j에서 i + i에서 K까지의 경로의 합과 같음
                    }
                }
            }
        }

        int[] answer = new int[N+1];

        //케빈 베이컨의 수의 합
        for(int i = 1 ; i <= N ; i ++) {
            answer[i] = Arrays.stream(dist[i]).sum();
        }

        int index = 0;

        int min = 1000000;
        
        //케빈 베이컨의 수가 가장 작은 사람을 구해주기
        for(int i = 1; i<= N; i++){
            if(min > answer[i]){
                min = answer[i];
                index = i;
            }
        }

        System.out.println(index);

    }

}