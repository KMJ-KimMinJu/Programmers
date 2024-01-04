import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int T = Integer.parseInt(st.nextToken());

        for(int i = 0; i < T; i++){

            st = new StringTokenizer(bf.readLine());
            int N = Integer.parseInt(st.nextToken());

            long[] DP = new long[N];

            for(int j = 0; j < N; j++){
                if(j == 0 || j == 1 || j == 2){
                    DP[j] = 1;
                }else{
                    DP[j] = DP[j-2]+DP[j-3];
                }
            }

            System.out.println(DP[N-1]);
        }

    }
}