import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());

        int[] DP = new int[N+1];

        for(int i = 2; i <= N; i++){

            DP[i] = DP[i-1] + 1; // 1을 뺴는 연산의 횟수를 더해줌

            if(i % 3 == 0){
                DP[i] = Math.min(DP[i], DP[i/3]+1);
            }

            if(i % 2 == 0){
                DP[i] = Math.min(DP[i], DP[i/2]+1);
            }

        }

        System.out.println(DP[N]);
    }
}