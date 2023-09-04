import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int[] prime = new int[end+1];

        //소수가 아니라면 0
        prime[0] = prime[1] = 0;

        for(int i = 2; i<=end; i++){
            prime[i]= i;
        }

        for(int i= 2; i<=end; i++){
            if(prime[i]== 0){ //소수가 아닌 경우에는 패스
                continue;
            }
            for(int j = i*2; j<= end; j+= i){ //소수라면 그 수의 배수는 전부 제외
                    prime[j] = 0;
            }
        }

        for(int i = 0; i<prime.length; i++){
            if(prime[i] != 0){

                if(prime[i] >= start && prime[i] <= end) { //입력받은 수의 범위에 해당하는 소수만 출력
                    System.out.println(prime[i]);
                }
            }
        }
    }
}