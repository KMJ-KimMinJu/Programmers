import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;
public class Main {
    public static StringBuilder sb = new StringBuilder();
    public static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());

        System.out.println(new BigInteger("2").pow(N).subtract(BigInteger.ONE));

        if(N <= 20) {
            hanoi(N, 1, 2, 3);
            System.out.println(sb);
        }
    }

    public static void hanoi(int n , int start, int mid, int end){

        if(n == 0){
            return;
        }

        hanoi(n-1, start, end, mid);

        sb.append(start + " " + end+"\n");

        hanoi(n-1, mid, start, end);
    }
}