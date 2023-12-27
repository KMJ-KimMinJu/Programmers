import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int T = Integer.parseInt(st.nextToken());

        int[][] DP = new int[T][10];

        for(int i = 1; i < 10; i++){
            DP[0][i] = 1;
        }

        for(int i = 1; i < T; i++){
            for(int j = 0; j<10; j++){
                if(j == 0){
                    DP[i][j] = DP[i-1][1] % 1000000000;
                }else if (j == 9){
                    DP[i][j] = DP[i-1][8] % 1000000000;
                }else {
                    DP[i][j] = (DP[i-1][j-1] + DP[i-1][j+1]) % 1000000000;
                }
            }
        }

        long answer = 0;

        for(int i : DP[T-1]){
            answer += i;
        }

        System.out.println(answer % 1000000000);
    }
}