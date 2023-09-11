import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        long start = Long.parseLong(st.nextToken());

        int answer = 0;

        long [] isPrime = new long[10000001]; //소수 판별을 위한 배열

        //소수가 아니라면 0
        isPrime[0] = isPrime[1] = 0;

        for (int i = 2; i < isPrime.length; i++) {
            isPrime[i] = i;
        }

        //에라토스테네스의 체 사용해서 소수 구하기
        for (int i = 2; i < isPrime.length; i++) {
            if (isPrime[i] == 0) {
                continue;
            }
            for (int j = i + i; j < isPrime.length; j = j + i) {
                isPrime[j] = 0;
            }
        }


        for(int i = 2; i< isPrime.length; i++){
            if (isPrime[i] == 0) {
                continue;
            }

            if(isPrime[i] >= start) {
                StringBuffer str = new StringBuffer(String.valueOf(isPrime[i]));

                str.reverse();

                if (String.valueOf(isPrime[i]).equals(str.toString())) {
                    System.out.println(isPrime[i]);
                    break;
                }
            }
        }
    }
}