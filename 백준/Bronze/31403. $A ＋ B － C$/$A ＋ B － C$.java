import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int a = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bf.readLine());
        int b = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bf.readLine());
        int c = Integer.parseInt(st.nextToken());

        String aPlusb = a+""+b;
        int aPlusb_int = Integer.parseInt(aPlusb);

        System.out.println(a+b-c);
        System.out.println(aPlusb_int - c);
    }

}