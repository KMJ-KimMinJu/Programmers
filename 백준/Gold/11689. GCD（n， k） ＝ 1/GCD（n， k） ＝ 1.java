import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        long n = Long.parseLong(st.nextToken());;
        long result = n;

        for(long i = 2; i<= Math.sqrt(n); i++){
                if(n%i==0){//소인수 분해를 해주는 과정
                    result = result-result/i; //오일러 방식 사용

                    while(n%i == 0){ //소인수로 계속 나누어주기
                        n/=i;
                    }
                }else{
                    continue;
                }
        }

        if(n>1){ //마지막에 남은 값이 1이 아니라 소인수라면 오일러 방식 사용
            result = result-result/n;
        }

        System.out.println(result);
    }
}