import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] D = new int[N+1][N+1];

        for(int i = 0; i <= N; i++){
            D[i][1] = i; //i개 중 1개
            D[i][i] = 1; //i개 중 모두
            D[i][0] = 1; //i개 중 0개
        }

        for(int i = 2; i<= N; i++){
            for(int j = 1; j <= N; j++){
                D[i][j] = D[i-1][j]+D[i-1][j-1];
                D[i][j] = D[i][j] % 10007;
            }
        }

        System.out.println(D[N][K]);
    }
}