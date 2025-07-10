import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());

        BigInteger number = BigInteger.ONE;
        number = fact(N);

        String[] fact_num = String.valueOf(number).split((""));

        int count = 0;
        
        //뒤에서부터 확인. 0이 아닌 숫자를 보는 즉시 종료
        for(int i = fact_num.length-1; i >= 0; i--){
            if(fact_num[i].equals("0")){ //0의 개수를 카운트
                count++;
            }else{
                break;
            }
        }

        System.out.println(count);
    }

    public static BigInteger fact(int N){

        if(N < 1){
            return BigInteger.ONE;
        }

        return BigInteger.valueOf(N).multiply(fact(N-1));
    }
}