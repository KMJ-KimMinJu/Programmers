import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int T = Integer.parseInt(st.nextToken());

        int[][] D = new int[15][15];

        for(int i = 0; i < 15; i++){
            D[0][i] = i; //0층에는 모두 호수만큼 산다
            D[i][1] = 1; //1호에는 무조건 1명
        }

        for(int i = 1; i< 15; i++){
            for(int j = 1; j < 15; j++){
                D[i][j] = D[i-1][j]+D[i][j-1]; //같은 층의 옆집은 결국 아래층의 1부터 b-1까지의 합이랑 같음
            }
        }

        for(int i = 0; i<T; i++){
            int k = Integer.parseInt(bf.readLine()); //층
            int n = Integer.parseInt(bf.readLine()); //호

            System.out.println(D[k][n]);
        }

    }
}