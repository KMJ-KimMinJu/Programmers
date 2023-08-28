import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken()); //동전 종류
        int M = Integer.parseInt(st.nextToken()); //동전 가치의 합

        int[] coin = new int[N];
        int sum = 0;

        for(int i= 0; i<N; i++){
            st = new StringTokenizer(bf.readLine());
            coin[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = N-1; i>=0; i--){
            if(M == 0){
                break;
            }
            if(coin[i]>M){
                continue;
            }if(coin[i]<=M){
                sum += (M/coin[i]); //동전 개수 더해주기
                M =  (M%coin[i]);//남은 돈
            }
        }

        System.out.println(sum);
    }
}