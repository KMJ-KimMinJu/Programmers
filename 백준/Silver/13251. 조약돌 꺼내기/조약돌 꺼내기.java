import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int M = Integer.parseInt(st.nextToken()); //색깔 수

        int [] stone = new int[M];
        int all_stone = 0;
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < M; i++) {

            stone[i] += Integer.parseInt(st.nextToken());

            all_stone += stone[i];
        }

        st = new StringTokenizer(bf.readLine());
        int K = Integer.parseInt(st.nextToken());

        double answer = 0;

        if(M == 1){
            System.out.println((double) 1);
            return;
        }else {
            for(int i = 0; i < stone.length; i++){
                double temp = 1.0;

                for(int j = 0; j < K; j++){
                    temp *= (double)(stone[i]-j)/(all_stone-j);
                }

                answer += temp;
            }
        }

        System.out.println(answer);
    }
}