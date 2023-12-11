import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int T = Integer.parseInt(st.nextToken()); //테스트 케이스

        for(int i = 0; i < T; i++){
            st = new StringTokenizer(bf.readLine());
            int west = Integer.parseInt(st.nextToken()); //서
            int east = Integer.parseInt(st.nextToken()); //동

            long[][] D = new long[east+1][east+1];

            for(int j = 0; j <= east; j++){
                D[j][0] = 1;
                D[j][1] = j;
                D[j][j] = 1;
            }

            for(int j = 2; j <= east; j++){
                for(int k = 1; k < j; k++){
                    D[j][k] = D[j-1][k] + D[j-1][k-1];
                }
            }

            System.out.println(D[east][west]);
        }

    }
}