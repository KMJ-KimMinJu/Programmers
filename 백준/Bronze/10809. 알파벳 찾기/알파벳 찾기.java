import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        String[] N = st.nextToken().split(""); //알파벳

        for(char ch= 'a'; ch<= 'z'; ch++){
            System.out.print(Arrays.asList(N).indexOf(String.valueOf(ch))+" ");
        }
    }
}