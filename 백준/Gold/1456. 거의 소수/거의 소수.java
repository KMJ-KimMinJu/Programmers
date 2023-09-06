import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int count = 0;

        long start = Long.parseLong(st.nextToken());
        long end = Long.parseLong(st.nextToken());

        count = 0;

        long [] isPrime = new long[10000001]; //소수 판별을 위한 배열, 크기는 입력 최대값의 제곱근

        //소수가 아니라면 0
        isPrime[0] = isPrime[1] = 0;

        for (int i = 2; i < isPrime.length; i++) {
            isPrime[i] = i;
        }

        //에라토스테네스의 체 사용해서 소수 구하기
        for (int i = 2; i <= Math.sqrt(isPrime.length); i++) {
            if (isPrime[i] == 0) {
                continue;
            }
            for (int j = i + i; j < isPrime.length; j = j + i) {
                isPrime[j] = 0;
            }
        }

        /*선별된 소수로 범위 내의 숫자가 제곱수인지 확인 후에 맞다면 count 증가*/
        for (int i = 2; i < isPrime.length; i++) {
            if (isPrime[i] != 0) {

                long temp = isPrime[i];

                //직접 나눠주면서 몫이 temp가 될 때까지 나누기
                while ((double)isPrime[i] <= (double)end/(double)temp) { // 2제곱일때까지
                    if ((double)isPrime[i] >= (double)start/(double)temp) { //2이상의 제곱일 경우
                        count++;
                    }
                    temp *= isPrime[i];
                }
            }
        }

        System.out.println(count);
    }
}