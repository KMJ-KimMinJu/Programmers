import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(bf.readLine());
            Integer x = Integer.parseInt(st.nextToken());

            try {
                if (x == 0) {
                    System.out.println(pq.remove());
                } else {
                    pq.offer(x);
                }
            } catch (NoSuchElementException e){
                System.out.println(0);
            }
        }

    }
}