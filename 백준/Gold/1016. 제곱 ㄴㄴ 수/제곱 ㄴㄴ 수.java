import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        long start = Long.parseLong(st.nextToken());
        long end = Long.parseLong(st.nextToken());

        int answer = 0;

        boolean [] isPrime = new boolean[(int)(end-start+1)];

        for (long i = 2; i <= Math.sqrt(end); i++) {
            long dob = i * i;

            long index = start/dob;

            if(start % dob != 0){
                index++;
            }

           for (long k = index; dob * k <= end; k ++) {
               isPrime[(int)((k * dob) - start)] = true;
           }
        }

        for(long i = 0; i < isPrime.length; i++){
            if(!isPrime[(int) i]){
                answer++;
            }
        }

        System.out.println(answer);
    }
}