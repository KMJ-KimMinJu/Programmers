import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());

        // 큰 수로 정렬함
        // 로프의 최대 중량이 클수록 버틸 수 있는 최대 중량이 늘어남
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0; i<N; i++){
            st = new StringTokenizer(bf.readLine());
            int temp = Integer.parseInt(st.nextToken());

            pq.offer(temp);
        }

        int max = -1;
        
        for(int i = 1; i <= N; i++){
            int temp = pq.poll();

            max = Math.max(max, temp * i);
        }

        System.out.println(max);
    }
}