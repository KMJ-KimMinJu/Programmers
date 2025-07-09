import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int hours = Integer.parseInt(st.nextToken());
        int min = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bf.readLine());
        int time = Integer.parseInt(st.nextToken());

        int plus_h = (min + time) / 60;

        hours = (hours + plus_h) % 24;

        min = (min + time) % 60;

        System.out.println(hours + " " + min);
    }
}