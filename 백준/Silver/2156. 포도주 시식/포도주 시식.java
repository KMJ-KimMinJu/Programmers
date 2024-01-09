import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int T = Integer.parseInt(st.nextToken());
        int[] DP = new int[T+1];
        int[] wine = new int[T+1];

        for(int i = 1; i <= T; i++){

            st = new StringTokenizer(bf.readLine());
            int N = Integer.parseInt(st.nextToken());

            wine[i] = N;
        }

        DP[1] = wine[1];

        if(T >= 2){
            DP[2] = wine[1]+wine[2];
        }

        for(int i = 3; i <= T; i++){
            
            DP[i] = Math.max(DP[i-1],Math.max(DP[i-2]+wine[i], DP[i-3]+wine[i-1]+wine[i]));
        }

        System.out.println(DP[T]);
    }
}