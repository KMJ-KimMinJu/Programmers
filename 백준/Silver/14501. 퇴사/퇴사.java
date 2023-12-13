import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());

        int[][] work = new int[N][2];

        for(int i= 0; i<N; i++){
            st = new StringTokenizer(bf.readLine());
            work[i][0] = Integer.parseInt(st.nextToken()); //소요시간
            work[i][1] = Integer.parseInt(st.nextToken()); //돈
        }

        int[] DP = new int[N+2];// 최대 수익

        for(int i = N; i > 0; i--){

            if(work[i-1][0] + i > N+1){
                DP[i] = DP[i+1];
            }else{
                DP[i] = Math.max(DP[i+1], DP[i+work[i-1][0]]+work[i-1][1]);
            }
        }

        System.out.println(DP[1]);
    }
}