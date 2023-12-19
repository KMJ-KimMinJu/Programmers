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

        if(N>=2) {
            DP[2] = 3;
        }

        for(int i = 3; i<= N; i++){
            DP[i] = (DP[i-2]*2+DP[i-1])%10007;
        }

        System.out.println(DP[N]);
    }
}