import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());

        long[] DP = new long[N+1];

        DP[1] = 1;

        for(int i = 2; i <= N; i++){
            if(i == 2){
                DP[2] = 1;
                continue;
            }

            DP[i] = DP[i-1]+DP[i-2];
        }

        System.out.println(DP[N]);
    }
}