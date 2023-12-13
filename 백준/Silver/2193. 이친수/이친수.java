import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());

        long[] DP = new long[N+1];// 최대 수익

        for(int i = 1; i <= N; i++){

            if(i == 1 || i == 2){ //첫 번째는 무조건 1, 그 다음은 무조건 0
                DP[i] = 1;
            }else {
                DP[i] = DP[i - 1] + DP[i - 2];
            }
        }

        System.out.println(DP[N]);
    }
}