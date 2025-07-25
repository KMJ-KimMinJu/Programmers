import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static boolean[] prime;
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());

        prime = new boolean[N+1];

        for(int i = 2; i <= N; i++){

            if(!prime[i]){
                for(int j = i + i; j <= N; j+=i){
                    prime[j] = true;
                }
            }
        }

        for(int i = 2; i <= N; i++){
            if(!prime[i]){

                while(N % i == 0){
                    N = N / i;

                    System.out.println(i);
                }

                if(N == 1){
                    break;
                }
            }
        }

    }
}