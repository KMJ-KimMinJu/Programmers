import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuffer sb = new StringBuffer();

        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        long gcd = GCD(a, b);

        while(gcd != 0){
            sb.append("1");
            gcd--;
        }

        System.out.println(sb.toString());
    }

    static long GCD(long a, long b){
        if(a%b == 0) {
            return b;
        }
        return GCD(b, a%b);
    }
}