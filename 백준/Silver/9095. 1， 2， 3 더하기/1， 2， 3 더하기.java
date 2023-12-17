import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());

        int[] DP = new int[12];

        DP[1] = 1;
        DP[2] = 2;
        DP[3] = 4;

        for(int i = 4; i<12; i++){
            DP[i] = DP[i-1]+DP[i-2]+DP[i-3];
        }
        
        for(int i= 1; i <= N; i++){
            st = new StringTokenizer(bf.readLine());
            int input = Integer.parseInt(st.nextToken());

            System.out.println(DP[input]);
        }
    }
}