
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); //개수
        int[][] dist = new int[N][N];

        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j<N; j++){
                dist[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] answer = new int[N][N];

        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    // i에서 k, k에서 j
                    if (dist[i][k] == 1 && dist[k][j] == 1) {
                        dist[i][j] = 1;
                    }
                }
            }
        }


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(dist[i][j] + " ");
            }
            System.out.println();
        }

    }

}