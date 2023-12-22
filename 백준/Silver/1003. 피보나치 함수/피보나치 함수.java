import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int T = Integer.parseInt(st.nextToken());

        for(int i = 1; i <= T; i++){

            st = new StringTokenizer(bf.readLine());
            int N = Integer.parseInt(st.nextToken());

            if(N == 0){
                System.out.println(1+ " "+0);
                continue;
            }

            ArrayList<int[]>[] DP = new ArrayList[N+1];

            for(int j = 0; j<=N; j++){
                DP[j] = new ArrayList<>();
            }

            DP[0].add(new int[] {1,0});

            for(int j = 1; j <= N; j++){

                if(j == 1){
                    DP[1].add(new int[] {0,1});
                }else{
                    int[] first = DP[j-1].get(0);
                    int[] second = DP[j-2].get(0);

                    DP[j].add(new int[] {first[0]+second[0], first[1]+second[1]});
                }
            }

            System.out.println(DP[N].get(0)[0]+" "+DP[N].get(0)[1]);
        }

    }
}